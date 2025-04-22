/*Definindo classe Aluno, herdando métodos de AbstractPessoa e implementando
a interfaceJogador para separar apenas os métodos e atributos que vão ser 
utilizados por essa classe em específico*/
public class Aluno extends AbstractPessoa implements interfaceJogador {
    //Definindo variável local
    private Integer serie;
    
    /*Get e Set definidos para os métodos da variável local*/

    public Integer getSerie(){
        return serie;
    }
    public void setSerie(Integer serie){
        this.serie = serie;
    }
    
    /*MÉTODO CONSTRUTOR herdando parâmetros da Super Classe para que não
    necessite atribui-las novamente*/ 
    public Aluno(String nome, String id, String email, Integer serie){
        super(nome, id, email);/*Chamando construtor da Super Classe para
        inicializar corretamente os seus atributos exclusivos*/
        this.serie = serie;
    }
    
    /*Métodos herdados da Super classe e definidas apenas as de uso exclusivo
    desta classe pela interfaceJogador*/
    @Override
    public void autenticarUsuario() {
        System.out.println("Email = " + getEmail() + " \nId = " + getId() + 
        " \nNome = " + getNome() + " \nSerie = " + getSerie());
    }

    @Override
    public void jogar() {
        System.out.println("O aluno " + getNome() + " está jogando!");
    }

    @Override
    public void consultarPontuacao() {
        
    }

    @Override
    public void responderQuestao() {
    
    }

    @Override
    public void desistir() {
        System.out.println("O jogador de ID: " + getId() + " desistiu.");
    }
}
