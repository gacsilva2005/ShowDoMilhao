/*Criando a classe SubTelaInicial e herdando métodos e atributos da Super Classe
"AbstractTela"*/
public class SubTelaInicial extends AbstractTela {
    
    //Getters e Setters herdados da Super Classe
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
    
    //Método construtor herdado da Super Classe
    public SubTelaInicial(Integer cor, Integer tamanho){
        super(cor, tamanho);/*Chamando construtor da Super Classe para
         inicializar corretamente os seus atributos exclusivos*/
    }
    
    //Método herdado da Super classe
     @Override
     public void mudarTela() {
     
     }
     
 }