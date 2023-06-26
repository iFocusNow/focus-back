package com.focus.service;

import com.focus.dto.AppDeviceDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
import com.focus.model.App;
import com.focus.model.AppDevice;
import com.focus.model.BlockPeriod;
import com.focus.model.Device;
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
                        appDevice.getId(),
                        appDevice.getApp().getName(),
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

            if (appDevices.isEmpty()) return false;
            if (!appDevices.isEmpty()) {
                for (AppDevice appDevice : appDevices) {
                    repo.delete(appDevice);
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public boolean save(AppDevice appDevice) {
        try {
            if (appRepository.findById(appDevice.getApp().getId()).isEmpty()) return false;
            if (blockPeriodRepository.findById(appDevice.getBlock_period().getId()).isEmpty()) return false;
            if (deviceRepository.findById(appDevice.getDevice().getId()).isEmpty()) return false;

            App appFound = appRepository.findById(appDevice.getApp().getId()).get();
            BlockPeriod blockPeriodFound = blockPeriodRepository.findById(appDevice.getBlock_period().getId()).get();
            Device deviceFound = deviceRepository.findById(appDevice.getDevice().getId()).get();

            AppDevice newAppDevice = new AppDevice(deviceFound, appFound, blockPeriodFound);
            AppDevice savedAppDevice = repo.save(newAppDevice);
            return true;
        }catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }


}
