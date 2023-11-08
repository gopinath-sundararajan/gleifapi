package com.example.gleif.gleifapi.service.impl;

import com.example.gleif.gleifapi.exception.ModelPopulationException;
import com.example.gleif.gleifapi.model.Root;
import com.example.gleif.gleifapi.service.api.GleifModelPopulatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GleifApiModelPopulatorServiceImpl implements GleifModelPopulatorService {

    @Override
    public Root populateModel(List<Object> rawObjectGleifResponseList) throws ModelPopulationException {
        return null;
    }
}
