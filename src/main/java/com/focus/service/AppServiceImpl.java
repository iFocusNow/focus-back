package com.focus.service;

import com.focus.model.App;
import com.focus.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService{
    @Autowired
    AppRepository appRepository;

    public List<App> listAll() {
        List<App> apps;
        apps = appRepository.findAll();
        return apps;
    }

}
