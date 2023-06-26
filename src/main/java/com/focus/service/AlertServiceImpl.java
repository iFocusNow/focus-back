package com.focus.service;

import com.focus.dto.AlertDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
import com.focus.model.Alert;
import com.focus.model.Child;
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
    public List<AlertDTO> getChildAlerts(UUID childId) {
        try {
            Child child = childRepository.findById(childId)
                    .orElseThrow(() -> new ResourceNotFoundException("Child not found with id: " + childId.toString()));

            List<AlertDTO> alertDTOs = new ArrayList<>();
            try {
                List<Alert> alerts = child.getAlerts();
                for (Alert alert : alerts) {
                    AlertDTO alertDTO = new AlertDTO(
                            alert.getChild().getId(),
                            alert.getChild().getName(),
                            alert.getType().toString()
                    );
                    alertDTOs.add(alertDTO);
                }
            } catch (Exception e) {
                throw new InternalServerErrorException("Internal server error", e);
            }

            return alertDTOs;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }
}
