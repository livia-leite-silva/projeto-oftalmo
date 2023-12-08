package br.com.oftalmo.model;

public class EspecificacaoLente extends GenericModel{
    private Float valor;
    private int id_estrutura_lente;
    private int id_atributo_estrutura_lente;

    public EspecificacaoLente(Float valor, int id_estrutura_lente, int id_atributo_estrutura_lente){
        this.valor = valor;
        this.id_estrutura_lente = id_estrutura_lente;
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
    }

    public EspecificacaoLente(Integer id, Float valor, int id_estrutura_lente, int id_atributo_estrutura_lente){
        this.valor = valor;
        this.id_estrutura_lente = id_estrutura_lente;
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
        super.setId(id);
    }

    public Float getValor(){
        return this.valor;
    }
    public int getIdEstruturaLente(){
        return this.id_estrutura_lente;
    }
    public int getIdAtributoEstruturaLente(){
        return this.id_atributo_estrutura_lente;
    }
    public void setIdAtributoEstruturaLente(int id_atributo_estrutura_lente){
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
    }
    public void setValor(Float valor){
        this.valor = valor;
    }
    public void setIdEstruturaLente(int id_estrutura_lente){
        this.id_estrutura_lente = id_estrutura_lente;
    }

    public String toString(){
        return "Especificações Lente {" +
                "id='" + this.getId() + "\'" +
                "valor='" + this.valor + "\'" +
                "id estrutura lente='" + this.id_estrutura_lente + "\'" +
                "id atributo estrutura lente='" + this.id_atributo_estrutura_lente + "\'" +
                '}';
    }
}
