package com.focus.service;

import com.focus.dto.AlertDTO;
import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlertServiceImpl implements AlertService {

    private final ParentRepository parentRepository;

    public AlertServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<AlertDTO> getParentAlerts(UUID parentId) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        List<Child> children = parent.getChildren();
        List<AlertDTO> alertDTOs = new ArrayList<>();

        for (Child child : children) {
            List<Alert> alerts = child.getAlerts();
            for (Alert alert : alerts) {
                AlertDTO alertDTO = new AlertDTO(
                        alert.getChild().getId(),
                        alert.getType().toString(),
                        alert.getCreated_at(),
                        alert.getUpdated_at()
                );
                alertDTOs.add(alertDTO);
            }
        }

        return alertDTOs;
    }
}
