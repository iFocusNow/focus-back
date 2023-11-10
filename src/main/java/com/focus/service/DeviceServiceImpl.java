package com.focus.service;

import com.focus.dto.DeviceDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
import com.focus.model.*;
import com.focus.repository.AppDeviceRepository;
import com.focus.repository.ChildRepository;
import com.focus.repository.DeviceRepository;
import com.focus.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//contiene varios métodos relacionados con la gestión de dispositivos ("Device") en el sistema
//se crea una lista de objetos "DeviceDTO" basada en los dispositivos encontrados. Finalmente, se devuelve la lista de objetos "DeviceDTO".
// utiliza el método findAllByChild() del repositorio "repo" para obtener una lista de dispositivos asociados al objeto "Child" con el identificador proporcionado
//guarda el nuevo dispositivo en el repositorio y obtiene el dispositivo guardado.

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository repo;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private AppDeviceRepository appDeviceRepository;
    public List<DeviceDTO> getAllDevices(UUID child_id) {
        try {
            List<Device> devices = repo.findAllByChild(child_id);
            if (devices.isEmpty()) {
                throw new ResourceNotFoundException("Devices not found with child id: " + child_id);
            }
            List<DeviceDTO> deviceDTOs = new ArrayList<>();

            for (Device device : devices) {
                DeviceDTO deviceDTO = new DeviceDTO(
                        device.getId(),
                        device.getChild().getId(),
                        device.getType(),
                        device.getBrand()
                );
                deviceDTOs.add(deviceDTO);
            }
            return deviceDTOs;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public List<Device> getDevices(UUID child_id) {
        try {
            List<Device> devices = repo.findAllByChild(child_id);
            if (devices.isEmpty()) {
                throw new ResourceNotFoundException("Devices not found with child id: " + child_id);
            }
            return devices;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public Device saveDevice(Device device, Child child) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            child.setUpdated_at(timestamp);

            Device newDevice = new Device(
                    child,
                    device.getType(),
                    device.getBrand()
            );
            Device savedDevice = repo.save(newDevice);
            savedDevice.getChild().setDevices(null);
            return savedDevice;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public void delete(UUID id, boolean forced) {
        try {
            Device device = repo.findById(id).get();
            if (device == null) {
                throw new ResourceNotFoundException("Device not found with id: " + id);
            }
            if (forced) {
                List<Link> links = linkRepository.findAllByDevice(id);
                List<AppDevice> appDevices = appDeviceRepository.findAllByDevice(id);
                for (Link li : links) {
                    linkRepository.delete(li);
                }
                for (AppDevice ad : appDevices) {
                    appDeviceRepository.delete(ad);
                }
            }

            repo.delete(device);
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }
}
