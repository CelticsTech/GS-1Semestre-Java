package com.globalsolution.java.celticstech.controller;

import com.globalsolution.java.celticstech.dto.request.CultivoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.CultivoResponseDTO;
import com.globalsolution.java.celticstech.service.CultivoService;
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
@RequestMapping("/cultivos")
public class CultivoController {

    private CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService){
        this.cultivoService = cultivoService;
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Cria o cultivo")
    @PostMapping()
    public ResponseEntity<CultivoResponseDTO> criarCultivo(@Valid @RequestBody CultivoRequestDTO cultivoRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cultivoService.criarCultivo(cultivoRequest));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Listar cultivo pelo ID com HATEOAS")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CultivoResponseDTO>> listarCultivoPorId(
            @PathVariable Long id
    ){
        CultivoResponseDTO cultivo = cultivoService.listarPorId(id);

        EntityModel<CultivoResponseDTO> model = EntityModel.of(cultivo);

        model.add(linkTo(methodOn(CultivoController.class)
                .listarCultivoPorId(id)).withSelfRel());

        model.add(linkTo(methodOn(CultivoController.class)
                .listarTodos(Pageable.unpaged())).withRel("todos-cultivos"));

        model.add(linkTo(methodOn(RecomendacaoController.class)
                .listarPorCultivo(id, Pageable.unpaged())).withRel("recomendacoes-do-cultivo"));

        return ResponseEntity.ok(model);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Lista todos os cultivos")
    @GetMapping()
    public ResponseEntity<Page<CultivoResponseDTO>> listarTodos(Pageable pageable){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cultivoService.listarTodosCultivos(pageable));
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Deleta o cultivo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCultivo(@PathVariable Long id){
        cultivoService.deletarCultivo(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "Atualiza o Cultivo")
    @PutMapping("/{id}")
    public ResponseEntity<CultivoResponseDTO> atualizarCultivo(@PathVariable Long id, @Valid @RequestBody CultivoRequestDTO cultivoRequest){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cultivoService.atualizarCultivo(id,cultivoRequest));
    }
}
