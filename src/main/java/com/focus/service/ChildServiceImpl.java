package com.focus.service;

import com.focus.dto.ChildNameDTO;
import com.focus.model.Child;
import com.focus.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService{
    @Autowired
    private ChildRepository childRepository;

    public ChildNameDTO getChildName(UUID child_id){
        Child child = childRepository.findById(child_id).get();
        ChildNameDTO childNameDTO = new ChildNameDTO(child.getName());

        return childNameDTO;

    }
}
