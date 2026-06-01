package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.AgricultorCultivoModels;
import com.globalsolution.java.celticstech.models.AssociacaoAgricultorModels;
import com.globalsolution.java.celticstech.models.id.AssociacaoAgricultorId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociacaoAgricultorRepository extends JpaRepository<AssociacaoAgricultorModels, AssociacaoAgricultorId> {
    Page<AssociacaoAgricultorModels> findByAssociacaoIdAssociacao(Long idAssociacao, Pageable pageable);
}
