package com.globalsolution.java.celticstech.service;

import com.globalsolution.java.celticstech.dto.request.LoginRequestDTO;
import com.globalsolution.java.celticstech.dto.response.LoginResponseDTO;
import com.globalsolution.java.celticstech.exceptions.BusinessException;
import com.globalsolution.java.celticstech.models.AssociacaoModels;
import com.globalsolution.java.celticstech.repository.AssociacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AssociacaoRepository associacaoRepository;
    private TokenService tokenService;

    public AuthService(
            AssociacaoRepository associacaoRepository,
            TokenService tokenService
    ) {
        this.associacaoRepository = associacaoRepository;
        this.tokenService = tokenService;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        AssociacaoModels associacao = associacaoRepository
                .findByLogin(loginRequest.login())
                .orElseThrow(() -> new BusinessException("Login inválido"));

        if (!associacao.getSenha().equals(loginRequest.senha())) {
            throw new BusinessException("Senha inválida");
        }

        String token = tokenService.gerarToken(associacao);

        return new LoginResponseDTO(token);
    }
}