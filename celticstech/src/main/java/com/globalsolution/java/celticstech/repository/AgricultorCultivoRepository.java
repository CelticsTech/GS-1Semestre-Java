package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import com.globalsolution.java.celticstech.models.id.AgricultorCultivoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorCultivoRepository
        extends JpaRepository<AgricultorCultivoModels, AgricultorCultivoId> {
}