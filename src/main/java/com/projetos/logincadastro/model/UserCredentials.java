package com.projetos.logincadastro.model;

public class UserCredentials {

    private String email;
    private String password;

    //Construtores
    public UserCredentials(){
    }

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
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
}
