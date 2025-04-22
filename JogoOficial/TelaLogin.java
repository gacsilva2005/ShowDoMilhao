//Importando bibliotecas necessárias
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Criando a classe TelaLogin, que herda da classe JFrame para permitir criação de interface gráfica
public class TelaLogin extends javax.swing.JFrame {
    // Declarando variáveis de instância para armazenar os objetos Aluno e Professor
    private Aluno Gabriel;
    private Professor Bethany;

    //Construtor da classe TelaLogin que recebe um Aluno e um Professor
    public TelaLogin(Aluno Gabriel, Professor Bethany) {
        this.Gabriel = Gabriel;
        this.Bethany = Bethany;
        initComponents(); // Método que inicializa os componentes da tela
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a tela para abrir em tela cheia
    }

    //Método que configura os componentes da interface gráfica
    @SuppressWarnings("unchecked")                     
    private void initComponents() {

        txtNome = new javax.swing.JFormattedTextField(); //Caixa de texto para o nome (nickname)
        txtId = new javax.swing.JPasswordField(); //Caixa de texto para o ID (senha)
        Entrar = new javax.swing.JButton(); //Botão de entrar

        //Define a ação de fechar a janela
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Define o texto inicial do campo de nome
        txtNome.setText("Digite seu nickname!");
        txtNome.setOpaque(false); // Define opacidade (fundo visível)
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt); //Ação ao inserir informação no campo
            }
        });
        txtId.setText("");

        //Define o texto do botão e sua ação
        Entrar.setText("Entrar");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt); //Ação quando clicar no botão
            }
        });

        //Layout da tela: define como os componentes serão posicionados
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Entrar)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Entrar)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack(); //Ajusta o tamanho da janela com base nos componentes
        setLocationRelativeTo(null); //Centraliza a janela na tela
    }                      

    //Ação ao interagir com o campo de texto do da variável nome
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        //Pode adicionar funcionalidades caso deseje fazer algo ao apertar Enter, por exemplo
    }                                       

    //Ação ao clicar no botão "Entrar"
    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        //Armazena os valores digitados pelo usuário
        String nomeDigitado = txtNome.getText(); 
        String idDigitado = new String(txtId.getPassword()); 

        //Verifica se os dados inseridos correspondem a instância Aluno Gabriel chamando os métodos da classe
        if (Gabriel.getNome().equals(nomeDigitado) && Gabriel.getId().equals(idDigitado)){
            JOptionPane.showMessageDialog(this, "Bem-vindo, " + Gabriel.getNome() + "!");
        }
        //Verifica se os dados inseridos correspondem a instância Professor Bethany chamando os métodos da classe
        else if(Bethany.getNome().equals(nomeDigitado) && Bethany.getId().equals(idDigitado)){
            JOptionPane.showMessageDialog(this, "Bem-vindo, professor(a) " + Bethany.getNome() + "!");
        }
        //Caso os dados estejam incorretos
        else {
            JOptionPane.showMessageDialog(this, "Dados incorretos.");
        }
    }                                      

    public static void main(String args[]) {
        //Definindo o tema (visual) da interface como "Nimbus", se estiver disponível
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Criação e exibição da tela (ainda falta instanciar os objetos aqui)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Declaração dos componentes da interface
    private javax.swing.JButton Entrar;
    private javax.swing.JPasswordField txtId;
    private javax.swing.JFormattedTextField txtNome;
}
