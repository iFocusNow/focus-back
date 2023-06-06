package com.focus.service;

import com.focus.dto.AppDTO;
import com.focus.model.App;

import java.util.List;
import java.util.UUID;

public interface AppService {
    public List<AppDTO> listApp();
}
