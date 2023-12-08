package br.com.oftalmo.model;

public class ObservacaoLaudo extends GenericModel{
    private String descricao;
    private int id_receita_oculos;

    public ObservacaoLaudo(String descricao, int id_receits_oculos){
        this.descricao = descricao;
        this.id_receita_oculos = id_receits_oculos;
    }
    public ObservacaoLaudo(Integer id, String descricao, int id_receits_oculos){
        this.descricao = descricao;
        this.id_receita_oculos = id_receits_oculos;
        super.setId(id);
    }   

    public String getDescricao(){
        return this.descricao;
    }
    public int getIdReceitaOculos(){
        return this.id_receita_oculos;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setIdReceitaOculos(int id_receita_oculos){
        this.id_receita_oculos = id_receita_oculos;
    }

    @Override
    public String toString(){
        return  "Observacao Laudo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + this.descricao + "\'" +
                "id receita óculos='" + this.id_receita_oculos + "\'" +
                '}';
    }
}
