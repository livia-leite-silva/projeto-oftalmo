package br.com.oftalmo.model;

public class EstruturaLente extends GenericModel{
    private String tipo_correcao;
    private int distancia_pupilar;
    private int id_receita_oculos;

    public EstruturaLente(String tipo_correcao, int distancia_pupilar, int id_receita_oculos){
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
    }
    public EstruturaLente(Integer id, String tipo_correcao, int distancia_pupilar,  int id_receita_oculos){
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.id_receita_oculos = id_receita_oculos;
        super.setId(id);
    }

    public String getTipoCorrecao(){
        return this.tipo_correcao;
    }
    public int getDistanciaPupilar(){
        return this.distancia_pupilar;
    }
    public int getIdReceitaOculos(){
        return this.id_receita_oculos;
    }
    public void setTipoCorrecao(String tipo_correcao){
        this.tipo_correcao = tipo_correcao;
    }
    public void setDistanciaPupilar(int distancia_pupilar){
        this.distancia_pupilar = distancia_pupilar;
    }
    public void setIdReceitaOculos(int id_receita_oculos){
        this.id_receita_oculos = id_receita_oculos;
    }
    
    public String toString(){
        return "Estrutura Lente {" +
                "id='" + this.getId() + "\'" +
                "tipo correção='" + this.tipo_correcao + "\'" +
                "distância pupilar='" + this.distancia_pupilar + "\'" +
                "id receita óculos='" + this.id_receita_oculos + "\'" +
                '}';
    }
}
    

