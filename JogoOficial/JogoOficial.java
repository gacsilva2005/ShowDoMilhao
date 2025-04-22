public class JogoOficial {

    public static void main(String[] args) {
        String nome = "Gabriel";
        String id = "25.00775-8";
        String email = "gabrielconceicaosilva.2005@gmail.com";
        
        String nome2 = "Bethany";
        String id2 = "25.00865-7";
        String email2 = "bethanygomesdasilva.2005@gmail.com";
        Integer serie = 9;
        String especialidade = "Matematica";

        //Instanciando uma classe aluno para teste
        Aluno Gabriel = new Aluno(nome, id, email, serie);
        Professor Bethany = new Professor(nome2, id2, email2, especialidade);
        TelaLogin tela = new TelaLogin(Gabriel, Bethany);
        tela.setVisible(true);
        
        
        Bethany.autenticarUsuario();

        //Chamando método de teste
        Gabriel.autenticarUsuario();
        Gabriel.jogar();
        Gabriel.desistir();
    }
}
