package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import com.globalsolution.java.celticstech.models.AssociacaoAgricultorModels;
import com.globalsolution.java.celticstech.models.id.AssociacaoAgricultorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociacaoAgricultorRepository extends JpaRepository<AssociacaoAgricultorModels, AssociacaoAgricultorId> {
}
