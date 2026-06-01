package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.ContatoRequestDTO;
import com.globalsolution.java.celticstech.dto.response.ContatoResponseDTO;
import com.globalsolution.java.celticstech.exceptions.ResourceNotFoundException;
import com.globalsolution.java.celticstech.models.ContatoModels;
import com.globalsolution.java.celticstech.repository.ContatoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    @CacheEvict(value = {"contatos", "contatosById"}, allEntries = true)
    public ContatoResponseDTO criarContato(ContatoRequestDTO contatoRequest){
        ContatoModels contato = contatoRepository.save(contatoRequest.toEntity());
        return ContatoResponseDTO.fromEntity(contato);
    }

    public ContatoModels listarContatoPorId(Long id){
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado"));
    }

    @Cacheable(value = "contatosById", key = "#id")
    public ContatoResponseDTO listarPorId(Long id){
        ContatoModels contato = listarContatoPorId(id);
        return ContatoResponseDTO.fromEntity(contato);
    }

    @Cacheable(
            value = "contatos",
            key = "#pageable.pageNumber + '-' + #pageable.pageSize"
    )
    public Page<ContatoResponseDTO> listarTodos(Pageable pageable){
        return contatoRepository.findAll(pageable)
                .map(ContatoResponseDTO::fromEntity);
    }

    @CacheEvict(value = {"contatos", "contatosById"}, allEntries = true)
    public void deletarContato(Long id){
        ContatoModels contato = listarContatoPorId(id);
        contatoRepository.delete(contato);
    }

    @CacheEvict(value = {"contatos", "contatosById"}, allEntries = true)
    public ContatoResponseDTO atualizarContato(Long id, ContatoRequestDTO contatoRequest){
        ContatoModels contato = listarContatoPorId(id);

        contato.setTelefone(contatoRequest.telefone());
        contato.setEmail(contatoRequest.email());

        ContatoModels atualizado = contatoRepository.save(contato);

        return ContatoResponseDTO.fromEntity(atualizado);
    }
}