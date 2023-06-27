package com.focus.service;

import com.focus.dto.AppDeviceCreateDTO;
import com.focus.dto.AppDeviceDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
import com.focus.model.AppDevice;
import com.focus.model.BlockPeriod;
import com.focus.repository.AppDeviceRepository;
import com.focus.repository.AppRepository;
import com.focus.repository.BlockPeriodRepository;
import com.focus.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//proporciona métodos para obtener, eliminar y guardar dispositivos de aplicaciones.
// Además, realiza validaciones de existencia de las aplicaciones, periodos de bloqueo y dispositivos relacionados
// antes de realizar las operaciones correspondientes en la base de datos.

@Service
public class AppDeviceServiceImpl implements AppDeviceService {
    @Autowired
    private AppDeviceRepository repo;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private BlockPeriodRepository blockPeriodRepository;

    public List<AppDeviceDTO> getAllAppDevices(UUID device_id) {
        try {
            List<AppDevice> appDevices = repo.findAllByDevice(device_id);
            if (appDevices.isEmpty()) {
                throw new ResourceNotFoundException("No apps found for device with id: " + device_id);
            }
            List<AppDeviceDTO> appDeviceDTOs = new ArrayList<>();

            for (AppDevice appDevice : appDevices) {
                AppDeviceDTO appDeviceDTO = new AppDeviceDTO(
                        appDevice.getDevice().getId(),
                        appDevice.getApp().getName(),
                        appDevice.getApp().getId(),
                        appDevice.getApp().getLogo_url(),
                        appDevice.getApp().getName(),
                        appDevice.getBlock_period().getId(),
                        appDevice.getBlock_period().getIs_monday(),
                        appDevice.getBlock_period().getIs_tuesday(),
                        appDevice.getBlock_period().getIs_wednesday(),
                        appDevice.getBlock_period().getIs_thursday(),
                        appDevice.getBlock_period().getIs_friday(),
                        appDevice.getBlock_period().getIs_saturday(),
                        appDevice.getBlock_period().getIs_sunday()

                );
                appDeviceDTOs.add(appDeviceDTO);
            }
            return appDeviceDTOs;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public boolean deleteAppDevice(UUID device_id, UUID app_id) {
        try {
            List<AppDevice> appDevices = repo.findByDeviceAndApp(device_id, app_id);

            if (appDevices.isEmpty()) {
                throw new ResourceNotFoundException("No app found for device with id: " + device_id + " and app with id: " + app_id);
            }

            for (AppDevice appDevice : appDevices) {
                repo.delete(appDevice);
            }
            return true;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public boolean save(AppDeviceCreateDTO appDevice) {
        try {
            // create a block period
            BlockPeriod blockPeriod = new BlockPeriod(
                    appDevice.getIs_monday(),
                    appDevice.getIs_tuesday(),
                    appDevice.getIs_wednesday(),
                    appDevice.getIs_thursday(),
                    appDevice.getIs_friday(),
                    appDevice.getIs_saturday(),
                    appDevice.getIs_sunday()
            );
            BlockPeriod savedBlockPeriod = blockPeriodRepository.save(blockPeriod);

            // create an appDevice
            AppDevice newAppDevice = new AppDevice(
                    deviceRepository.findById(appDevice.getDevice_id()).get(),
                    appRepository.findById(appDevice.getApp_id()).get(),
                    savedBlockPeriod
            );

            repo.save(newAppDevice);

            return true;
        }catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }


}
