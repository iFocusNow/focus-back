package com.focus.service;

import com.focus.dto.ChildDTO;
import com.focus.model.Child;
import com.focus.repository.ChildRepository;
import com.focus.service.ChildService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public List<ChildDTO> getParentChildren(UUID parentId) {
        List<Child> children = childRepository.findAllByParentId(parentId);
        List<ChildDTO> childrenDTOs = new ArrayList<>();
        for (Child child : children) {
            ChildDTO childDTO = new ChildDTO(
                    child.getId(),
                    child.getName()
            );
            childrenDTOs.add(childDTO);
        }
        return childrenDTOs;
    }
}