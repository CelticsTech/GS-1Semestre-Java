package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.CultivoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.CultivoResponseDTO;
import com.globalsolution.java.celticstech.service.CultivoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cultivos")
public class CultivoController {

    private CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService){
        this.cultivoService = cultivoService;
    }

    //-------------------------------------------------------------------------------------------------------------------


    @PostMapping()
    public ResponseEntity<CultivoResponseDTO> criarCultivo(@Valid @RequestBody CultivoRequestDTO cultivoRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cultivoService.criarCultivo(cultivoRequest));
    }

    //-------------------------------------------------------------------------------------------------------------------


    @GetMapping("/{id}")
    public ResponseEntity<CultivoResponseDTO> listarCultivoPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cultivoService.listarPorId(id));
    }

    //-------------------------------------------------------------------------------------------------------------------


    @GetMapping()
    public ResponseEntity<Page<CultivoResponseDTO>> listarTodos(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cultivoService.listarTodosCultivos(pageable));
    }

    //-------------------------------------------------------------------------------------------------------------------


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCultivo(@PathVariable Long id){
        cultivoService.deletarCultivo(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //-------------------------------------------------------------------------------------------------------------------


    @PutMapping("/{id}")
    public ResponseEntity<CultivoResponseDTO> atualizarCultivo(@PathVariable Long id, @Valid @RequestBody CultivoRequestDTO cultivoRequest){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cultivoService.atualizarCultivo(id,cultivoRequest));
    }
}
