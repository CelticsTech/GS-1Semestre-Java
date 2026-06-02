package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.AssociacaoModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociacaoRepository extends JpaRepository<AssociacaoModels, Long> {
    Optional<AssociacaoModels> findByLogin(String login);
}
