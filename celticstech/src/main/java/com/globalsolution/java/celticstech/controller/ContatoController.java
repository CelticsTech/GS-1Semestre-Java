package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.ContatoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.ContatoResponseDTO;
import com.globalsolution.java.celticstech.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @Operation(summary = "Criar contato")
    @PostMapping
    public ResponseEntity<ContatoResponseDTO> criarContato(
            @Valid @RequestBody ContatoRequestDTO contatoRequest
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contatoService.criarContato(contatoRequest));
    }

    @Operation(summary = "Listar contato por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contatoService.listarPorId(id));
    }

    @Operation(summary = "Listar todos os contatos")
    @GetMapping
    public ResponseEntity<Page<ContatoResponseDTO>> listarTodos(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contatoService.listarTodos(pageable));
    }

    @Operation(summary = "Deletar contato")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable Long id){
        contatoService.deletarContato(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @Operation(summary = "Atualizar contato")
    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> atualizarContato(
            @PathVariable Long id,
            @Valid @RequestBody ContatoRequestDTO contatoRequest
    ){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contatoService.atualizarContato(id, contatoRequest));
    }
}