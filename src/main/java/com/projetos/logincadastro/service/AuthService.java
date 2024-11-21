package com.projetos.logincadastro.service;

import com.projetos.logincadastro.model.User;
import com.projetos.logincadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password){
        //Buscar o usuario pelo e-mail
        User user = userRepository.findByEmail(email).orElse(null);

        //Se o usuario não existir ou  a senha for incorreta
        if (user == null || !user.getPassword().equals(password)){
            return false;
        }

        return true; // Se as credenciais estiverem corretas
    }
}
