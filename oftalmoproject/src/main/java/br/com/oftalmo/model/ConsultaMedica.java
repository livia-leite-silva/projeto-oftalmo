package br.com.oftalmo.model;

import java.sql.Date;

public class ConsultaMedica extends GenericModel{
    private String assinatura;
    private Date dt_consulta;
    private int id_paciente;
    private int id_medico;

    public ConsultaMedica(String assinatura, Date dt_consulta,int id_paciente,int id_medico){
        this.assinatura = assinatura;
        this.dt_consulta = dt_consulta;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }
    public ConsultaMedica(Integer id,String assinatura, Date dt_consulta,int id_paciente,int id_medico){
        this.assinatura = assinatura;
        this.dt_consulta = dt_consulta;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        super.setId(id);
    }

    public String getAssinatura(){
        return this.assinatura;
    }
    public Date getDtConsulta(){
        return this.dt_consulta;
    }
    public int getIdPaciente(){
        return this.id_paciente;
    }
    public int getIdMedico(){
       return this.id_medico;
    }
    public void setAssinatura(String assinatura){
        this.assinatura = assinatura;
    }
    public void setDtConsulta(Date dt_consulta){
        this.dt_consulta = dt_consulta;
    }

    public String toString(){
        return "Consulta Médica {" +
                "id='" + this.getId() + "\'" +
                "assinatura='" + this.assinatura + "\'" +
                "data consulta='" + this.dt_consulta + "\'" +
                "id paciente='" + this.id_paciente + "\'" +
                "id médico='" + this.id_medico + "\'" +
                '}';
    }
}
