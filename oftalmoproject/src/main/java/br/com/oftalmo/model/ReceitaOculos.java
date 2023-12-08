package br.com.oftalmo.model;

import java.sql.Date;

public class ReceitaOculos extends GenericModel{
    private String detalhamento;
    private Date dt_consulta;
    private int id_consulta_medica;

    public ReceitaOculos(String detalhamento, Date dt_consulta, int id_consulta_medica){
        this.detalhamento = detalhamento;
        this.dt_consulta = dt_consulta;
        this.id_consulta_medica = id_consulta_medica;
    }
    public ReceitaOculos(Integer id,String detalhamento, Date dt_consulta, int id_consulta_medica){
        this.detalhamento = detalhamento;
        this.dt_consulta = dt_consulta;
        this.id_consulta_medica = id_consulta_medica;
        super.setId(id);
    }

    public String getDetalhamento(){
        return this.detalhamento;
    }
    public Date getDtConsulta(){
        return this.dt_consulta;
    }
    public int getIdConsultaMedica(){
        return this.id_consulta_medica;
    }
    public void setDetalhamento(String detalhamento){
        this.detalhamento = detalhamento;
    }
    public void setDtConsulta(Date dt_consulta){
        this.dt_consulta = dt_consulta;
    }
    public void setIdConsultaMedica(int id_consulta_medica){
        this.id_consulta_medica = id_consulta_medica;
    }

    @Override
    public String toString(){
        return  "Receita Oculos {" +
                "id='" + this.getId() + "\'" +
                "detalhamento='" + this.detalhamento + "\'" +
                "data consulta='" + this.dt_consulta + "\'" +
                "id consulta médica='" + this.id_consulta_medica + "\'" +
                '}';

    }
}
