package com.example.demo;

public class Professor{
    private long id;
    private String nome;
    private int matricula;
    private String area;

    public Professor(){}
    public Professor(long id, String nome, int matricula, String area) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.area = area;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

}