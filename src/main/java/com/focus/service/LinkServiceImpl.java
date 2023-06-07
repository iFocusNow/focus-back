package com.focus.service;

import com.focus.dto.AppDeviceDTO;
import com.focus.dto.LinkBlockPeriodDTO;
import com.focus.model.BlockPeriod;
import com.focus.model.Device;
import com.focus.model.Link;
import com.focus.repository.BlockPeriodRepository;
import com.focus.repository.DeviceRepository;
import com.focus.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository repo;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private BlockPeriodRepository blockPeriodRepository;

    public List<LinkBlockPeriodDTO> getAllLinkBlockPeriods(UUID device_id) {
        List<Link> links = repo.findAllByDevice(device_id);
        List<LinkBlockPeriodDTO> linkBlockPeriodDTOs = new ArrayList<>();

        for (Link link : links) {
            LinkBlockPeriodDTO linkBlockPeriodDTO = new LinkBlockPeriodDTO(
                    link.getId(),
                    link.getName(),
                    link.getUrl(),
                    link.getBlock_period().getId(),
                    link.getBlock_period().getIs_monday(),
                    link.getBlock_period().getIs_tuesday(),
                    link.getBlock_period().getIs_wednesday(),
                    link.getBlock_period().getIs_thursday(),
                    link.getBlock_period().getIs_friday(),
                    link.getBlock_period().getIs_saturday(),
                    link.getBlock_period().getIs_sunday()
            );

            linkBlockPeriodDTOs.add(linkBlockPeriodDTO);
        }
        return linkBlockPeriodDTOs;
    }

    public boolean deleteLink(UUID id) {
        if(repo.findById(id).isEmpty()) {
            return false;
        }

        repo.deleteById(id);
        return true;
    }

    public boolean save(Link link) {
        if(deviceRepository.findById(link.getDevice().getId()).isEmpty()) return false;
        if(blockPeriodRepository.findById(link.getBlock_period().getId()).isEmpty()) return false;

        Device deviceFound = deviceRepository.findById(link.getDevice().getId()).get();
        BlockPeriod blockPeriodFound = blockPeriodRepository.findById(link.getBlock_period().getId()).get();

        Link newlink = new Link(deviceFound,blockPeriodFound,link.getName(),link.getUrl());
        Link savedLink = repo.save(newlink);
        return true;
    }
}
