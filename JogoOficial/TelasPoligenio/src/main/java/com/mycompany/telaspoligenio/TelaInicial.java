package com.mycompany.telaspoligenio;

import com.mycompany.telaspoligenio.TelaCadastrar.PanelCadastrar;
import com.mycompany.telaspoligenio.TelaRecuperarSenha.PanelRecuperarSenha;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaInicial extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelInicial;
    

    public TelaInicial() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelInicial = new JPanel(cardLayout);
        
        try {
            PanelInicial panelInicial = new PanelInicial(painelInicial);
            PanelRecuperarSenha panelRecuperarSenha = new PanelRecuperarSenha(painelInicial);
            PanelCadastrar panelCadastrar = new PanelCadastrar(painelInicial);

            painelInicial.add(panelInicial, "TelaInicial");
            painelInicial.add(panelRecuperarSenha, "TelaRecuperarSenha");
            painelInicial.add(panelCadastrar, "TelaCadastrar");

            add(painelInicial);
            cardLayout.show(painelInicial, "TelaInicial");


        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelInicial, nomeTela);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial tela = new TelaInicial();
            tela.setVisible(true);
        });
    }

    public static class PanelInicial extends JPanel {

        private BufferedImage imagemDeFundo;
        private BufferedImage imagemBotaoEntrar;
        private BufferedImage imagemInputRA;
        private BufferedImage imagemInputSenha;
        private BufferedImage imagemCadastrar;
        private BufferedImage imagemEsqSenha;

        private JButton botaoEntrar;
        private JButton botaoEsqSenha;
        private JButton botaoCadastrar;
        private JTextField campoTextoRA;
        private JPasswordField campoTextoSenha;
        
        private JButton botaoSelecionado = null;
        
        private TelaInicial Inicial;
        private final JPanel container;
        
        
        
        public PanelInicial(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            imagemDeFundo = ImageIO.read(getClass().getResource("/ImagensTelaInicial/telaLogin.png"));
            imagemBotaoEntrar = ImageIO.read(getClass().getResource("/ImagensTelaInicial/botaoEntrarLogin.png"));
            imagemInputRA = ImageIO.read(getClass().getResource("/ImagensTelaInicial/inputBoxRA.png"));
            imagemInputSenha = ImageIO.read(getClass().getResource("/ImagensTelaInicial/inputBoxSenha.png"));
            imagemCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaInicial/cadastrarLogin.png"));
            imagemEsqSenha = ImageIO.read(getClass().getResource("/ImagensTelaInicial/forgotPassword.png"));
            
            

            // Camada sobre o fundo
            JPanel painelConteudo = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    int w = getWidth();
                    int h = getHeight();

                    // Centro da tela
                    int centroX = w / 2;

                    // Dimensões dos elementos
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraInput = (int) (imagemInputRA.getWidth() * 0.7 * escala);
                    int alturaInput = (int) (imagemInputRA.getHeight() * 0.7 * escala);
                    int larguraBotao = (int) (imagemBotaoEntrar.getWidth() * 0.7 * escala);
                    int alturaBotao = (int) (imagemBotaoEntrar.getHeight() * 0.7 * escala);
                    int larguraCadastrar = (int) (imagemCadastrar.getWidth() * 0.7 * escala);
                    int alturaCadastrar = (int) (imagemCadastrar.getHeight() * 0.7 * escala);
                    int larguraEsqSenha = (int) (imagemEsqSenha.getWidth() * 0.7 * escala);
                    int alturaEsqSenha = (int) (imagemEsqSenha.getHeight() * 0.7 * escala);

                    // Posicionamento com base no centro
                    int xRA = centroX - (larguraInput / 2);
                    int yRA = (int) (h * 0.45) - 30; // 45% da altura da tela
                    int xSenha = centroX - (larguraInput / 2);
                    int ySenha = yRA + alturaInput + (int)(20 * escala); // 20px abaixo do campo RA
                    int xBotao = centroX - (larguraBotao / 2) - 3;
                    int yBotao = ySenha + alturaInput + (int)(40 * escala); // 40px abaixo do campo Senha
                    int xCadastrar = centroX - (larguraBotao / 2) + 200;
                    int yCadastrar = yBotao + alturaBotao + (int)(40 * escala) - 10;
                    int xEsqSenha = centroX - (larguraBotao / 2) - 160;
                    int yEsqSenha = yBotao + alturaBotao + (int)(40 * escala) - 10;

                    // Atualiza os bounds
                    campoTextoRA.setBounds(xRA + (int)(77 * escala) - 5, yRA + (int)(27 * escala) - 8, (int)(400 * escala), (int)(50 * escala));
                    campoTextoSenha.setBounds(xSenha + (int)(115 * escala) - 5, ySenha + (int)(27 * escala) - 8, (int)(400 * escala), (int)(50 * escala));
                    botaoEntrar.setBounds(xBotao, yBotao, larguraBotao, alturaBotao);
                    botaoEsqSenha.setBounds(xEsqSenha, yEsqSenha, larguraEsqSenha, alturaEsqSenha);
                    botaoCadastrar.setBounds(xCadastrar, yCadastrar, larguraCadastrar, alturaCadastrar);

                    // Desenhar campos
                    g2d.drawImage(imagemInputRA, xRA, yRA, larguraInput, alturaInput, this);
                    g2d.drawImage(imagemInputSenha, xSenha, ySenha, larguraInput, alturaInput, this);
                    g2d.drawImage(imagemBotaoEntrar, xBotao, yBotao, larguraBotao, alturaBotao, this);
                    g2d.drawImage(imagemCadastrar, xCadastrar, yCadastrar, larguraCadastrar, alturaCadastrar, this);
                    g2d.drawImage(imagemEsqSenha, xEsqSenha, yEsqSenha, larguraEsqSenha, alturaEsqSenha, this);
                }
            };
            
            
            painelConteudo.setOpaque(false);

            // Campos e botão
            campoTextoRA = new JTextField();
            campoTextoRA.setBorder(null);
            campoTextoRA.setOpaque(false);
            campoTextoRA.setForeground(Color.BLACK);
            campoTextoRA.setFont(new Font("Jockey One", Font.BOLD, 30));
            painelConteudo.add(campoTextoRA);

            campoTextoSenha = new JPasswordField();
            campoTextoSenha.setBorder(null);
            campoTextoSenha.setOpaque(false);
            campoTextoSenha.setForeground(Color.BLACK);
            campoTextoSenha.setFont(new Font("Jockey One", Font.BOLD, 30));
            painelConteudo.add(campoTextoSenha);

            botaoEntrar = new JButton();
            botaoEntrar.setBorderPainted(false);
            botaoEntrar.setContentAreaFilled(false);
            botaoEntrar.setFocusPainted(false);
            botaoEntrar.setOpaque(false);
            botaoEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoEntrar);
            
            botaoEsqSenha = new JButton();
            botaoEsqSenha.setBorderPainted(false);
            botaoEsqSenha.setContentAreaFilled(false);
            botaoEsqSenha.setFocusPainted(false);
            botaoEsqSenha.setOpaque(false);
            botaoEsqSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoEsqSenha.addActionListener(e -> {
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "TelaRecuperarSenha");
            });
            painelConteudo.add(botaoEsqSenha);
            
            botaoCadastrar = new JButton();
            botaoCadastrar.setBorderPainted(false);
            botaoCadastrar.setContentAreaFilled(false);
            botaoCadastrar.setFocusPainted(false);
            botaoCadastrar.setOpaque(false);
            botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCadastrar.addActionListener(e -> {
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "TelaCadastrar");
            });
            painelConteudo.add(botaoEsqSenha);
            painelConteudo.add(botaoCadastrar);

            setLayout(new BorderLayout());
            add(painelConteudo, BorderLayout.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int w = getWidth();
            int h = getHeight();

            // Melhor qualidade de renderização
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            
            if (imagemDeFundo != null) {
                g2d.drawImage(imagemDeFundo, 0, 0, w, h, (ImageObserver) this);
            }
        }
    }
}
