package br.com.oftalmo.servico;

import br.com.oftalmo.DAO.MarcaDAO;
import br.com.oftalmo.model.Marca;

public class ServicoMarca {

    private MarcaDAO marcaDAO = new MarcaDAO();
    //TODO: Aqui é um exemplo de regra de negócio. possivelmente quando estivermos implementando
    // as regras de vistoria do pneu tenham regras nesse modelo de padrão de projeto.
    public void insertMarca(Marca entidade) {
        if (marcaDAO.count() <= 20) {
            marcaDAO.insertMarca(entidade);
        }
    }
}
