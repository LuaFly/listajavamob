package com.luana.lista.model;

public class Pessoa {

    //Construtor
    //Atributos - Objetos - Molde - Modelo - Template
    //Métodos de Acesso - Gets and Sets

    private String nome;
    private String sobreNome;
    private  String curso;
    private  String telefone;


    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // To String - para textos, caracteres


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", curso='" + curso + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
