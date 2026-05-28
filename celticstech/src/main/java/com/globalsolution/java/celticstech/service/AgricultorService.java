package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.repository.AgricultorRepository;
import org.springframework.stereotype.Service;

@Service
public class AgricultorService {

    private AgricultorRepository agricultorRepository;

    public AgricultorService(AgricultorRepository agricultorRepository){
        this.agricultorRepository = agricultorRepository;
    }

}
