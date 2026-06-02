package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.AgricultorRequestDTO;
import com.globalsolution.java.celticstech.dto.response.AgricultorResponseDTO;
import com.globalsolution.java.celticstech.service.AgricultorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/agricultores")
public class AgricultorController {

    private AgricultorService agricultorService;

    public AgricultorController(AgricultorService agricultorService){
        this.agricultorService = agricultorService;
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Criar agricultor")
    @PostMapping()
    public ResponseEntity<AgricultorResponseDTO> criarAgricultor(@Valid @RequestBody AgricultorRequestDTO agricultorRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agricultorService.criarAgricultor(agricultorRequest));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Lista todos os agricultores")
    @GetMapping()
    public ResponseEntity<Page<AgricultorResponseDTO>> listarTodosAgricultores(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(agricultorService.listarTodosAgricultores(pageable));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Listar agricultor pelo ID com HATEOAS")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AgricultorResponseDTO>> listarAgricultorPorId(
            @PathVariable Long id
    ){
        AgricultorResponseDTO agricultor = agricultorService.buscarPorId(id);

        EntityModel<AgricultorResponseDTO> model = EntityModel.of(agricultor);

        model.add(linkTo(methodOn(AgricultorController.class)
                .listarAgricultorPorId(id)).withSelfRel());

        model.add(linkTo(methodOn(AgricultorController.class)
                .listarTodosAgricultores(Pageable.unpaged())).withRel("todos-agricultores"));

        model.add(linkTo(methodOn(AgricultorCultivoController.class)
                .listarCultivosDoAgricultor(id, Pageable.unpaged())).withRel("cultivos-do-agricultor"));

        return ResponseEntity.ok(model);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Deleta o agricultor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgricultor(@PathVariable Long id){
        agricultorService.removerAgricultor(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Atualiza o agricultor")
    @PutMapping("/{id}")
    public ResponseEntity<AgricultorResponseDTO> atualizarAgricultor(@PathVariable Long id,
                                                                     @Valid @RequestBody AgricultorRequestDTO agricultorRequest)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(agricultorService.atualizarAgricultor(id,agricultorRequest));
    }
}
