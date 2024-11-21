package com.projetos.logincadastro.service;

import com.projetos.logincadastro.model.User;
import com.projetos.logincadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean register(String email, String password){
        if (userRepository.findByEmail(email).isPresent()){
            return false; // Retorna false se o e-mail já estiver cadastrado
        }

        // Se o e-mail não existir, cria e salva o novo usuário
        User newUser = new User(email, password);
        userRepository.save(newUser);
        return true; // Retorna true se o cadastro for bem-sucedido
    }
}
