package com.globalsolution.java.celticstech.repository;

import com.globalsolution.java.celticstech.models.ContatoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModels, Long> {
}
