package com.mycompany.telaspoligenio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaCadastrar extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelCadastrar;
    
     public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelCadastrar = painelPrincipal;
    }
    
    public TelaCadastrar() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelCadastrar = new JPanel(cardLayout);

        try {
            PanelCadastrar telaInicioPanel = new PanelCadastrar(painelCadastrar);
            painelCadastrar.add(telaInicioPanel, "TelaCadastrar");
            add(painelCadastrar);
            cardLayout.show(painelCadastrar, "TelaCadastrar");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCadastrar tela = new TelaCadastrar();
            tela.setVisible(true);
        });
    }
    
    public static class PanelCadastrar extends JPanel {

        private BufferedImage imagemDeFundoCadastrar;
        private BufferedImage imagemNomeCadastrar;
        private BufferedImage imagemRaCadastrar;
        private BufferedImage imagemEmailCadastrar;
        private BufferedImage imagemSenhaCadastrar;
        private BufferedImage imagemConfirmarSenha;
        private BufferedImage imagemSerieCadastro;
        private BufferedImage imagemTurmaCadastro;
        private BufferedImage imagemCadastrar;
        private BufferedImage imagemVoltarCadastrar;
        
        private JTextField campoTextoNome;
        private JTextField campoTextoRA;
        private JTextField campoTextoEmail;
        private JPasswordField campoTextoSenha;
        private JPasswordField campoTextoConfirmSenha;
        private JTextField campoTextoSerie;
        private JTextField campoTextoTurma;
        private JButton botaoCadastrar;
        private JButton botaoVoltarCadastrar;
        //private JTextField campoTextoNome;
        
        private final JPanel container;
        
        public PanelCadastrar(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            imagemDeFundoCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/telaCadastrar.png"));
            imagemNomeCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/nomeCadastrar.png"));
            imagemRaCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/raCadastrar.png"));
            imagemEmailCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/emailCadastrar.png"));
            imagemSenhaCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/senhaCadastrar.png"));
            imagemConfirmarSenha = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/confirmarSenhaCadastro.png"));
            imagemSerieCadastro = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/serieCadastro.png"));
            imagemTurmaCadastro = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/turmaCadastrar.png"));
            imagemCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/cadastrar.png"));
            imagemVoltarCadastrar = ImageIO.read(getClass().getResource("/ImagensTelaCadastrar/voltarLoginCadastrar.png"));
            
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
                    int larguraNomeCadastrar = (int) (imagemNomeCadastrar.getWidth() * 0.7 * escala);
                    int alturaNomeCadastrar = (int) (imagemNomeCadastrar.getHeight() * 0.7 * escala);
                    int larguraRaCadastrar = (int) (imagemRaCadastrar.getWidth() * 0.7 * escala);
                    int alturaRaCadastrar = (int) (imagemRaCadastrar.getHeight() * 0.7 * escala);
                    int larguraEmailCadastrar = (int) (imagemEmailCadastrar.getWidth() * 0.7 * escala);
                    int alturaEmailCadastrar = (int) (imagemEmailCadastrar.getHeight() * 0.7 * escala);
                    int larguraSenhaCadastrar = (int) (imagemSenhaCadastrar.getWidth() * 0.7 * escala);
                    int alturaSenhaCadastrar = (int) (imagemSenhaCadastrar.getHeight() * 0.7 * escala);
                    int larguraConfirmSenha = (int) (imagemConfirmarSenha.getWidth() * 0.7 * escala);
                    int alturaConfirmSenha = (int) (imagemConfirmarSenha.getHeight() * 0.7 * escala);
                    int larguraSerieCadastrar = (int) (imagemSerieCadastro.getWidth() * 0.7 * escala);
                    int alturaSerieCadastrar = (int) (imagemSerieCadastro.getHeight() * 0.7 * escala);
                    int larguraTurmaCadastrar = (int) (imagemTurmaCadastro.getWidth() * 0.7 * escala);
                    int alturaTurmaCadastrar = (int) (imagemTurmaCadastro.getHeight() * 0.7 * escala);
                    int larguraCadastrar = (int) (imagemCadastrar.getWidth() * 0.7 * escala);
                    int alturaCadastrar = (int) (imagemCadastrar.getHeight() * 0.7 * escala);
                    int larguraVoltarCadastrar = (int) (imagemVoltarCadastrar.getWidth() * 0.2 * escala);
                    int alturaVoltarCadastrar = (int) (imagemVoltarCadastrar.getHeight() * 0.2 * escala);
                    
                    // Posicionamento com base no centro
                    int xNCad = centroX - (larguraNomeCadastrar / 2);
                    int yNCad = (int) (h * 0.60) - 460; // Posição vertical do campo email
                    int xRaCad = centroX - (larguraNomeCadastrar / 2);
                    int yRaCad = yNCad + alturaNomeCadastrar + (int)(20 * escala); // 20px abaixo do campo NOME
                    int xEmailCad = centroX - (larguraNomeCadastrar / 2);
                    int yEmailCad = yRaCad + alturaRaCadastrar + (int)(20 * escala); // 20px abaixo do campo RA
                    int xPassCad = centroX - (larguraNomeCadastrar / 2);
                    int yPassCad = yEmailCad + alturaEmailCadastrar + (int)(20 * escala); // 20px abaixo do campo EMAIL
                    int xPassConf = centroX - (larguraNomeCadastrar / 2);
                    int yPassConf = yPassCad + alturaSenhaCadastrar + (int)(20 * escala); // 20px abaixo do campo Senha
                    int xSerie = centroX - (larguraNomeCadastrar / 2);
                    int ySerie = yPassConf + alturaConfirmSenha + (int)(20 * escala); // 20px abaixo do campo Confirmar Senha
                    int xTurma = centroX + (larguraNomeCadastrar / 14);
                    int yTurma = yPassConf + alturaConfirmSenha + (int)(20 * escala); // 20px abaixo do campo Confirmar Senha
                    int xCadastro = centroX - (larguraCadastrar / 2);
                    int yCadastro = yTurma + alturaTurmaCadastrar + (int)(100 * escala); // 20px abaixo do campo Serie
                    int xVoltarCadastro = centroX - (larguraVoltarCadastrar / 2);
                    int yVoltarCadastro = yCadastro + alturaCadastrar + (int)(70 * escala); // 20px abaixo do campo Cadastro
                    
                    campoTextoNome.setBounds(xNCad + (int)(77 * escala) + 18, yNCad + (int)(27 * escala) - 21, (int)(350 * escala), (int)(50 * escala));
                    campoTextoRA.setBounds(xRaCad + (int)(77 * escala) - 13, yRaCad + (int)(27 * escala) - 21, (int)(350 * escala), (int)(50 * escala));
                    campoTextoEmail.setBounds(xEmailCad + (int)(77 * escala) + 22, yEmailCad + (int)(27 * escala) - 21, (int)(350 * escala), (int)(50 * escala));
                    campoTextoSenha.setBounds(xPassCad + (int)(77 * escala) + 22, yPassCad + (int)(27 * escala) - 21, (int)(350 * escala), (int)(50 * escala));
                    campoTextoConfirmSenha.setBounds(xPassConf + (int)(77 * escala) + 128, yPassConf + (int)(27 * escala) - 21, (int)(350 * escala), (int)(50 * escala));
                    campoTextoSerie.setBounds(xSerie + (int)(77 * escala) + 22, ySerie + (int)(27 * escala) - 22, (int)(50 * escala), (int)(50 * escala));
                    campoTextoTurma.setBounds(xTurma + (int)(77 * escala) + 35, yTurma + (int)(27 * escala) - 22, (int)(50 * escala), (int)(50 * escala));
                    botaoCadastrar.setBounds(xCadastro, yCadastro, larguraCadastrar, alturaCadastrar);
                    botaoVoltarCadastrar.setBounds(xVoltarCadastro, yVoltarCadastro, larguraVoltarCadastrar, alturaVoltarCadastrar);
                    
                    // Desenhar campos
                    g2d.drawImage(imagemNomeCadastrar, xNCad, yNCad, larguraNomeCadastrar, alturaNomeCadastrar, this);
                    g2d.drawImage(imagemRaCadastrar, xRaCad, yRaCad, larguraRaCadastrar, alturaRaCadastrar, this);
                    g2d.drawImage(imagemEmailCadastrar, xEmailCad, yEmailCad, larguraEmailCadastrar, alturaEmailCadastrar, this);
                    g2d.drawImage(imagemSenhaCadastrar, xPassCad, yPassCad, larguraSenhaCadastrar, alturaSenhaCadastrar, this);
                    g2d.drawImage(imagemConfirmarSenha, xPassConf, yPassConf, larguraConfirmSenha, alturaConfirmSenha, this);
                    g2d.drawImage(imagemSerieCadastro, xSerie, ySerie, larguraSerieCadastrar, alturaSerieCadastrar, this);
                    g2d.drawImage(imagemTurmaCadastro, xTurma, yTurma, larguraTurmaCadastrar, alturaTurmaCadastrar, this);
                    g2d.drawImage(imagemCadastrar, xCadastro, yCadastro, larguraCadastrar, alturaCadastrar, this);
                    g2d.drawImage(imagemVoltarCadastrar, xVoltarCadastro, yVoltarCadastro, larguraVoltarCadastrar, alturaVoltarCadastrar, this);
                    
                }
            };
            painelConteudo.setOpaque(false);
            
            campoTextoNome = new JTextField();
            campoTextoNome.setBorder(null);
            campoTextoNome.setOpaque(false);
            campoTextoNome.setForeground(Color.BLACK);
            campoTextoNome.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoNome);
            
            campoTextoRA = new JTextField();
            campoTextoRA.setBorder(null);
            campoTextoRA.setOpaque(false);
            campoTextoRA.setForeground(Color.BLACK);
            campoTextoRA.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoRA);
            
            campoTextoEmail = new JTextField();
            campoTextoEmail.setBorder(null);
            campoTextoEmail.setOpaque(false);
            campoTextoEmail.setForeground(Color.BLACK);
            campoTextoEmail.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoEmail);
            
            campoTextoSenha = new JPasswordField();
            campoTextoSenha.setBorder(null);
            campoTextoSenha.setOpaque(false);
            campoTextoSenha.setForeground(Color.BLACK);
            campoTextoSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoSenha);
            
            campoTextoConfirmSenha = new JPasswordField();
            campoTextoConfirmSenha.setBorder(null);
            campoTextoConfirmSenha.setOpaque(false);
            campoTextoConfirmSenha.setForeground(Color.BLACK);
            campoTextoConfirmSenha.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoConfirmSenha);
            
            campoTextoSerie = new JTextField();
            campoTextoSerie.setBorder(null);
            campoTextoSerie.setOpaque(false);
            campoTextoSerie.setForeground(Color.BLACK);
            campoTextoSerie.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoSerie);
            
            campoTextoTurma = new JTextField();
            campoTextoTurma.setBorder(null);
            campoTextoTurma.setOpaque(false);
            campoTextoTurma.setForeground(Color.BLACK);
            campoTextoTurma.setFont(new Font("Jockey One", Font.BOLD, 24));
            painelConteudo.add(campoTextoTurma);
            
            botaoCadastrar = new JButton();
            botaoCadastrar.setBorderPainted(false);
            botaoCadastrar.setContentAreaFilled(false);
            botaoCadastrar.setFocusPainted(false);
            botaoCadastrar.setOpaque(false);
            botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoCadastrar);
            
            botaoVoltarCadastrar = new JButton();
            botaoVoltarCadastrar.setBorderPainted(false);
            botaoVoltarCadastrar.setContentAreaFilled(false);
            botaoVoltarCadastrar.setFocusPainted(false);
            botaoVoltarCadastrar.setOpaque(false);
            botaoVoltarCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoVoltarCadastrar.addActionListener(e -> {
                CardLayout cl = (CardLayout) container.getLayout();
                cl.show(container, "TelaInicial");
            });
            painelConteudo.add(botaoVoltarCadastrar);
            
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
            
            if (imagemDeFundoCadastrar != null) {
                g2d.drawImage(imagemDeFundoCadastrar, 0, 0, w, h, this);
            }
        }
    }
}
