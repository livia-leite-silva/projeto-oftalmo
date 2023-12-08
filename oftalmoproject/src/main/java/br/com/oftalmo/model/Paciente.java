package br.com.oftalmo.model;

import java.sql.Date;

public class Paciente extends GenericModel {
    private String nome;
    private String cpf;
    private Date dt_nascimento;
    
    public Paciente(String nome, String cpf, Date dt_nascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
    }
    public Paciente(Integer id ,String nome, String cpf, Date dt_nascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        super.setId(id);
    }

    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public Date getDtNascimento(){
        return this.dt_nascimento;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setNome(Date dt_nascimento){
        this.dt_nascimento = dt_nascimento;
    }

    @Override
    public String toString() {
        return "Paciente {" +
                "id='" + this.getId() + "\'" +
                "nome='" + this.nome + "\'" +
                "cpf='" + this.cpf + "\'" +
                "data de nascimento='" + this.dt_nascimento + "\'" +
                '}';
    }
}
