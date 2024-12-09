package com.projetos.logincadastro.service;

import com.projetos.logincadastro.model.User;
import com.projetos.logincadastro.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean register(String email, String password, String username){
        if (userRepository.findByEmail(email).isPresent()){
            return false; // Retorna false se o e-mail já estiver cadastrado
        }

        if (userRepository.findByUsername(username).isPresent()) {
            return false; // Retorna false se o username já estiver em uso
        }

        // Se o e-mail não existir, cria e salva o novo usuário
        User newUser = new User(email, password, username);
        userRepository.save(newUser);
        return true; // Retorna true se o cadastro for bem-sucedido
    }
}
