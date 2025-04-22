/*Criando a classe SubTelaOpcoes e herdando métodos e atributos da Super Classe
"AbstractTela"*/
public class SubTelaOpcoes extends AbstractTela {
    
    //Definindo variáveis locais
    private String materia;
    
    /*Getters e Setters herdados da classe abstrata e definindo os métodos 
    para a variável local*/
    @Override
    public Integer getCor(){
        return cor;
    }
    @Override
    public Integer getTamanho(){
        return tamanho;
    }
    @Override
    public void setCor(Integer cor){
        this.cor = cor;
    }
    @Override
    public void setTamanho(Integer tamanho){
        this.tamanho = tamanho;
    }
    
    
    public String getMateria(){
        return materia;
    }
    public void setMateria(String materia){
        this.materia = materia;
    }
    
    public SubTelaOpcoes(String materia, Integer cor, Integer tamanho){
        super(cor, tamanho);/*Chamando construtor da Super Classe para
        inicializar corretamente os seus atributos exclusivos*/
        this.materia = materia;
    }
    
    //Método herdado da Super classe
    @Override
    public void mudarTela() {
    
    }
    
}
