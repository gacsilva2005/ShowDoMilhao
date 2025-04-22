/*Definindo classe Professor, herdando métodos de AbstractPessoa e implementando
a interfaceAdministrador para separar apenas os métodos e atributos que vão ser 
utilizados por essa classe em específico*/
public class Professor extends AbstractPessoa implements interfaceAdministrador {
    
    //Definindo variável local
    private String especialidade;
    
    /*Get e Set definidos para os métodos da variável local*/
    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    
    
    /*MÉTODO CONSTRUTOR herdando parâmetros da Super Classe para que não
    necessite atribui-las novamente*/ 
    public Professor(String nome, String id, String email, String especialidade) {
        super(nome, id, email); /*Chamando construtor da Super Classe para
        inicializar corretamente os seus atributos exclusivos*/
        this.especialidade = especialidade;
    }
    
    /*Métodos herdados da Super classe e definidas apenas as de uso exclusivo
    desta classe pela interfaceAdministrador*/
    @Override
    public void autenticarUsuario() {
        System.out.println("Email = " + getEmail() + " \nId = " + getId() + 
        " \nNome = " + getNome() + " \nEspecialidade = " + getEspecialidade());
    }

    @Override
    public void cadastrarJogador() {
    
    }

    @Override
    public void criarSala() {
    
    }

    @Override
    public void adicionarPerguntas() {
    
    }

    @Override
    public void consultarRanking() {
    
    }

    @Override
    public void iniciarPartida() {
    
    }

    @Override
    public void gerenciarDicas() {
    
    }
}