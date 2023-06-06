package com.focus.service;

import com.focus.dto.AppDTO;
import com.focus.model.App;
import com.focus.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AppServiceImpl implements AppService{
    @Autowired
    AppRepository appRepository;

    public List<AppDTO> listApp() {
        List<App> appList = appRepository.findAll();
        List<AppDTO> appDTOList = new ArrayList<>();

        for(App app: appList){
            AppDTO appDTO = new AppDTO(app.getId(),app.getName(),app.getLogo_url());
            appDTOList.add(appDTO);
        }
        return appDTOList;
    }

}
