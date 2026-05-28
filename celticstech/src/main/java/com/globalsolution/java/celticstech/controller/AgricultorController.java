package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.AgricultorRequestDTO;
import com.globalsolution.java.celticstech.dto.response.AgricultorResponseDTO;
import com.globalsolution.java.celticstech.service.AgricultorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agricultor")
public class AgricultorController {

    private AgricultorService agricultorService;

    public AgricultorController(AgricultorService agricultorService){
        this.agricultorService = agricultorService;
    }

    //-------------------------------------------------------------------------------------------------------------------

    @PostMapping()
    public ResponseEntity<AgricultorResponseDTO> criarAgricultor(@Valid @RequestBody AgricultorRequestDTO agricultorRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agricultorService.criarAgricultor(agricultorRequest));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @GetMapping()
    public ResponseEntity<Page<AgricultorResponseDTO>> listarTodosAgricultores(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(agricultorService.listarTodosAgricultores(pageable));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<AgricultorResponseDTO> listarAgricultorPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(agricultorService.buscarPorId(id));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgricultor(@PathVariable Long id){
        agricultorService.removerAgricultor(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //-------------------------------------------------------------------------------------------------------------------


    @PutMapping("/{id}")
    public ResponseEntity<AgricultorResponseDTO> atualizarAgricultor(@PathVariable Long id,
                                                                     @Valid @RequestBody AgricultorRequestDTO agricultorRequest)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agricultorService.atualizarAgricultor(id,agricultorRequest));
    }
}
