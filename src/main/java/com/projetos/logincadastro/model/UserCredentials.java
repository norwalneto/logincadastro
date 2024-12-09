package com.projetos.logincadastro.model;

public class UserCredentials {

    private String email;
    private String password;
    private String username;

    //Construtores
    public UserCredentials(){
    }

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    //Getters e Setter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
