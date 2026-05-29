package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import com.globalsolution.java.celticstech.models.id.AgricultorCultivoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgricultorCultivoRepository extends JpaRepository<AgricultorCultivoModels, AgricultorCultivoId> {
    Page<AgricultorCultivoModels> findByAgricultorIdAgricultor(Long idAgricultor, Pageable pageable);
}