package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.response.AgricultorCultivoResponseDTO;
import com.globalsolution.java.celticstech.service.AgricultorCultivoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultores/{idAgricultor}/cultivos")
public class AgricultorCultivoController {

    private AgricultorCultivoService agricultorCultivoService;

    public AgricultorCultivoController(AgricultorCultivoService agricultorCultivoService){
        this.agricultorCultivoService = agricultorCultivoService;
    }

    //-------------------------------------------------------------------------------------------------------------------


    @PostMapping("/{idCultivo}")
    public ResponseEntity<AgricultorCultivoResponseDTO> vincularCultivo(
            @PathVariable Long idAgricultor,
            @PathVariable Long idCultivo
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agricultorCultivoService.vincularCultivo(idAgricultor, idCultivo));
    }

    //-------------------------------------------------------------------------------------------------------------------


    @DeleteMapping("/{idCultivo}")
    public ResponseEntity<Void> deletarVinculo(
            @PathVariable Long idAgricultor,
            @PathVariable Long idCultivo
    ){
        agricultorCultivoService.deletarVinculo(idAgricultor, idCultivo);
        return ResponseEntity.noContent().build();
    }

    //-------------------------------------------------------------------------------------------------------------------


    @GetMapping
    public ResponseEntity<Page<AgricultorCultivoResponseDTO>> listarCultivosDoAgricultor(
            @PathVariable Long idAgricultor,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                agricultorCultivoService.listarCultivosDoAgricultor(idAgricultor, pageable)
        );
    }
}