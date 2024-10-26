package com.example.demo;

public class Disciplina {
    private int id;
    private String nome;
    private String sigla;
    private String curso;
    private int semestre;

    public Disciplina(int id, String nome, String sigla, String curso, int semestre) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.curso = curso;
        this.semestre = semestre;
    }
    public Disciplina(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
}
