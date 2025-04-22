//Classe Molde para outras classes do programa herdarem
public abstract class AbstractTela {
    protected Integer cor;
    protected Integer tamanho;

    // Getters e Setters comuns entre as classes
    public Integer getCor(){
        return cor;
    }
    public Integer getTamanho(){
        return tamanho;
    }
    public void setCor(Integer cor){
        this.cor = cor;
    }
    public void setTamanho(Integer tamanho){
        this.tamanho = tamanho;
    }
    
    public AbstractTela(Integer cor, Integer tamanho) {
        this.cor = cor;
        this.tamanho = tamanho;
    }
    
    //Criando método que será herdado
    public abstract void mudarTela();
}