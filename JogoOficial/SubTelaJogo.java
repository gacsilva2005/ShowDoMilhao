/*Criando a classe SubTelaJogo e herdando métodos e atributos da Super Classe
"AbstractTela"*/
public class SubTelaJogo extends AbstractTela {
    
   //Definindo variáveis locais
   private Boolean checkPoint;
   private String alternativas;
   
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
   
   public Boolean getCheckPoint(){
      return checkPoint;
   }
   public String getAlternativas(){
      return alternativas;
   }
   public void setCheckPoint(Boolean checkPoint){
      this.checkPoint = checkPoint;
   }
   public void setAlternativas(String alternativas){
       this.alternativas = alternativas;
   }

   //Método construtor herdado da Super Classe
   public SubTelaJogo(Integer cor, Integer tamanho, Boolean checkPoint, String alternativas){
       super(cor, tamanho);/*Chamando construtor da Super Classe para
       inicializar corretamente os seus atributos exclusivos*/
       this.checkPoint = checkPoint;
       this.alternativas = alternativas;
   }
   
   //Método herdado da Super classe
   @Override
   public void mudarTela() {
   
   }
   public void carregarPerguntas(){
       
   }
   public void carregarAlternativas(){
       
   }
   public void selecionarDicas(){
       
   }
   public void escolherAlternativas(){
       
   }
}