package br.com.oftalmo.model;


public class AtributoEstruturaLente extends GenericModel {
    private String descricao;
    private String lado_olho;

    public AtributoEstruturaLente(String descricao, String lado_olho){
        this.descricao = descricao;
        this.lado_olho = lado_olho;
    }
    public AtributoEstruturaLente(Integer id,String descricao, String lado_olho){
        this.descricao = descricao;
        this.lado_olho = lado_olho;
        super.setId(id);
    }

    public String getDescricao(){
        return this.descricao;
    }
    public String getLadoOlho(){
        return this.descricao;
    }
    public void setLadoOlho(String lado_olho){
        this.lado_olho = lado_olho;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String toString(){
        return "Atributos estrutura lente {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + this.descricao + "\'" +
                "lado olho='" + this.lado_olho + "\'" +
                '}';
    }
}
    

