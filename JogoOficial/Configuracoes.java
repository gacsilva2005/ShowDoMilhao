//Criando classe Configuracoes
public class Configuracoes {
    //Definindo variáveis locais
    private Boolean Audio;
    private String Dificuldade;
    
    /*Métodos getters e setters para as variáveis locais*/
    public Boolean getAudio(){
        return Audio;
    }
    public void setAudio(Boolean Audio){
        this.Audio = Audio;
    }
    
    public String getDificuldade(){
        return Dificuldade;
    }
    public void setDificuldade(String Dificuldade){
        this.Dificuldade = Dificuldade;
    }
    
    //definindo os parâmetros com os atributos criados
    public Configuracoes(Boolean Audio, String Dificuldade){
        this.Audio = Audio; /*"This" acessa a instância atual da classe Produto 
        e ele recebe o que for atribuido por parâmetro na chamada do método*/
        this.Dificuldade = Dificuldade;
    }
    
    
    
    //Criando métodos a serem utilizados pela classe
    public void ativarAudio(){
        
    }
    public void desativarAudio(){
        
    }
    public void ativarDica(){
        
    }
    public void desativarDica(){
        
    }
}
