package br.com.oftalmo.model;

import java.sql.Date;

public class EspecialidadeMedica extends GenericModel {
    private String observacao;
    private Date dt_conclusao;
    private int id_especialidade;
    private int id_medico;

    public EspecialidadeMedica(String observacao, Date dt_conclusao, int id_especialidade, int id_medico){
        this.observacao = observacao;
        this.dt_conclusao = dt_conclusao;
        this.id_especialidade = id_especialidade;
        this.id_medico = id_medico;
    }

    public EspecialidadeMedica(Integer id,String observacao, Date dt_conclusao, int id_especialidade, int id_medico){
        this.observacao = observacao;
        this.dt_conclusao = dt_conclusao;
        this.id_especialidade = id_especialidade;
        this.id_medico = id_medico;
        super.setId(id);
    }


    public String getObservacao(){
        return this.observacao;
    }
    public Date getDtConclusao(){
        return this.dt_conclusao;
    }
    public int getIdEspecialidade(){
        return this.id_especialidade;
    }
    public int getIdMedico(){
        return this.id_medico;
    }
    public void setObservacao(String observacao){
        this.observacao = observacao;
    }
    public void setDtConclusao(Date dt_conclusao){
        this.dt_conclusao = dt_conclusao;
    }
 

    @Override
    public String toString() {
        return "Especialidade Medica{" +
                "id='" + this.getId() + "\'" +
                "observacao='" + this.observacao + "\'" +
                "data conclusao='" + this.dt_conclusao + "\'" +
                "id especialidade='" + this.id_especialidade + "\'" +
                "id medico='" + this.id_medico + "\'" +
                '}';
    }
}
