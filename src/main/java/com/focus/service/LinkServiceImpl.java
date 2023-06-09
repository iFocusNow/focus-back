package com.focus.service;

import com.focus.dto.AppDeviceDTO;
import com.focus.dto.LinkBlockPeriodDTO;
import com.focus.dto.LinkCreateDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
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

//En este bloque se enfoca acerca al bloqueo de los links para los hijos, como el listar, mostrar y eliminar estos

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository repo;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private BlockPeriodRepository blockPeriodRepository;

    public List<LinkBlockPeriodDTO> getAllLinkBlockPeriods(UUID device_id) {
        try {
            List<Link> links = repo.findAllByDevice(device_id);
            if (links.isEmpty()) {
                throw new ResourceNotFoundException("No links found for device with id: " + device_id);
            }
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
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteLink(UUID id) {
        try {
            if (repo.findById(id).isEmpty()) {
                return false;
            }

            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new InternalServerErrorException("Error deleting link:", e);
        }
    }

    public boolean save(LinkCreateDTO link) {
        try {
            // Create block period
            BlockPeriod blockPeriod = new BlockPeriod(
                    link.getIs_monday(),
                    link.getIs_tuesday(),
                    link.getIs_wednesday(),
                    link.getIs_thursday(),
                    link.getIs_friday(),
                    link.getIs_saturday(),
                    link.getIs_sunday()
            );
            BlockPeriod savedBlockPeriod = blockPeriodRepository.save(blockPeriod);

            // Get device

            // Create link
            Link newLink = new Link(
                    deviceRepository.findById(link.getDevice_id()).get(),
                    savedBlockPeriod,
                    link.getName(),
                    link.getUrl()
            );

            repo.save(newLink);

            return true;
        } catch (Exception e) {
           throw new InternalServerErrorException("Error saving link:",e);
        }
    }
}
