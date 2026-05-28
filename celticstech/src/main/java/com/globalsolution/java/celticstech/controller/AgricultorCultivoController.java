package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.response.AgricultorCultivoResponseDTO;
import com.globalsolution.java.celticstech.service.AgricultorCultivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agricultores")
public class AgricultorCultivoController {

    private AgricultorCultivoService agricultorCultivoService;

    public AgricultorCultivoController(AgricultorCultivoService agricultorCultivoService){
        this.agricultorCultivoService = agricultorCultivoService;
    }

    @RequestMapping("/{idAgricultor}/cultivos/{idCultivo}")
    public ResponseEntity<AgricultorCultivoResponseDTO> vincularCultivo(@PathVariable Long idAgricultor, @PathVariable Long idCultivo){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agricultorCultivoService.vincularCultivo(idAgricultor, idCultivo));
    }
}
