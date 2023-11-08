package com.example.gleif.gleifapi.service.api;

import com.example.gleif.gleifapi.exception.ModelPopulationException;
import com.example.gleif.gleifapi.model.Root;

import java.util.List;

public interface GleifModelPopulatorService {

    Root populateModel(List<Object> rawObjectGleifResponseList) throws ModelPopulationException;
}
