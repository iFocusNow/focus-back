package com.focus.service;

import com.focus.dto.AlertDTO;
import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.repository.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlertServiceImpl implements AlertService {

    private final ChildRepository childRepository;

    public AlertServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public List<AlertDTO> getChildAlerts(UUID childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new RuntimeException("Child not found"));

        List<AlertDTO> alertDTOs = new ArrayList<>();

        List<Alert> alerts = child.getAlerts();
        for (Alert alert : alerts) {
            AlertDTO alertDTO = new AlertDTO(
                    alert.getChild().getId(),
                    alert.getType().toString()
            );
            alertDTOs.add(alertDTO);
        }

        return alertDTOs;
    }
}
