package br.com.oftalmo.util;

import br.com.oftalmo.DAO.AtributoEstruturaLenteDAO;
import br.com.oftalmo.model.AtributoEstruturaLente;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class AtributoEstruturaLenteTeste {

    static AtributoEstruturaLenteDAO atributoEstruturaLenteDAO = new AtributoEstruturaLenteDAO();

    public static void main(String[] args) throws SQLException {

        // count
        System.out.println(atributoEstruturaLenteDAO.count());

        //salva
        AtributoEstruturaLente atributoEstruturaLente = new AtributoEstruturaLente("descricao", "lado_olho");
        atributoEstruturaLenteDAO.insertAtributoEstruturaLente(atributoEstruturaLente);

        // select by id
    //     medico = pacienteDAO.selectMedico(2);
    //     System.out.println(medico);

    //    //update
    //     medico.setNome("João Pedro");
    //     medicoDAO.updateMedico(medico);
    //     medico = medicoDAO.selectMedico(2);
    //     System.out.println(medico);

    //    //select all
    //     List<Medico> medicos = medicoDAO.selectAllMedico();
    //     medicos.forEach(System.out::println);

    //     //delete
    //     medicoDAO.deleteMedico(2);
    //     medicoDAO.selectAllMedico().forEach(System.out::println);
    }
}


