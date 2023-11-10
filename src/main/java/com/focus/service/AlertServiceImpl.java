package com.focus.service;

import com.focus.dto.AlertDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Device;
import com.focus.repository.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//busca y recopila las alertas asociadas a un niño específico en la base de datos y las devuelve en forma
// de una lista de objetos AlertDTO

@Service
public class AlertServiceImpl implements AlertService {

    private final ChildRepository childRepository;

    public AlertServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public List<AlertDTO> getAlerts(UUID parent_id) {
        try {
        // get children by parent_id
        List<Child> children = childRepository.findAllByParentId(parent_id);
        if (children == null) {
            throw new ResourceNotFoundException("Children not found");
        }

        // get alertDTOs from devices
        List<AlertDTO> alertDTOs = new ArrayList<>();
        for (Child child : children) {
            List<Device> devices = child.getDevices();
            for (Device device : devices) {
                List<Alert> alerts = device.getAlerts();
                for (Alert alert : alerts) {
                    alertDTOs.add(new AlertDTO(child.getId(), child.getName(), alert.getType().toString()));
                }
            }
        }

        return alertDTOs;


        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }
}
