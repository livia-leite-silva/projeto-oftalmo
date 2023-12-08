package br.com.oftalmo.util;

import br.com.oftalmo.DAO.MedicoDAO;
import br.com.oftalmo.DAO.PacienteDAO;
import br.com.oftalmo.DAO.EspecialidadeDAO;

import br.com.oftalmo.model.Medico;
import br.com.oftalmo.model.Paciente;
import br.com.oftalmo.model.Especialidade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Teste {

    static MedicoDAO medicoDAO = new MedicoDAO();
    static PacienteDAO pacienteDAO = new PacienteDAO();
    static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    public static void main(String[] args) throws SQLException {

        //count
        System.out.println(pacienteDAO.count());

        //salvar
        String data = "2002-10-09";
        Paciente paciente = new Paciente("Leo", "433.456.654-08", (Date) data);
        pacienteDAO.insertPaciente(paciente);

        //select
    //     medico = pacienteDAO.selectMedico(2);
    //     System.out.println(medico);

    //     //update
    //     medico.setNome("João Pedro");
    //     medicoDAO.updateMedico(medico);
    //     medico = medicoDAO.selectMedico(2);
    //     System.out.println(medico);

    //     //select all
    //     List<Medico> medicos = medicoDAO.selectAllMedico();
    //     medicos.forEach(System.out::println);

    //     //delete
    //     medicoDAO.deleteMedico(2);
    //     medicoDAO.selectAllMedico().forEach(System.out::println);
    // }
}
