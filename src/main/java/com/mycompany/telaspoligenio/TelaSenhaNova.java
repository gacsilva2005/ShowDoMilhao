package com.mycompany.telaspoligenio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaSenhaNova extends JFrame{
    
     private CardLayout cardLayout;
    private JPanel painelSenhaNova;  
    
    public TelaSenhaNova() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelSenhaNova = new JPanel(cardLayout);
        try {
            PanelSenhaNova painelSenhaNova = new PanelSenhaNova(); // Cria o painel
            add(painelSenhaNova); // Adiciona o painel diretamente ao JFrame

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaSenhaNova tela = new TelaSenhaNova();
            tela.setVisible(true);
        });
    }
    
    public static class PanelSenhaNova extends JPanel {
        
        private BufferedImage imagemFundoSenhaNova;
        private BufferedImage imagemInputSenhaNova;
        private BufferedImage imagemInputConfirmarSenhaNova;
        private BufferedImage imagemBotaoEnviarSenhaNova;
        private BufferedImage imagemBotãoVoltarLogSN;
        
        private JPasswordField campoSenhaNova;
        private JPasswordField campoConfirmarSenhaNova;
        
        private JButton botaoEnviar;
        private JButton botaoVoltar;
        
        public PanelSenhaNova() throws IOException {
            setLayout(new GridBagLayout());
                
            imagemFundoSenhaNova = ImageIO.read(getClass().getResource("/ImagensTelaSenhaNova/telaSenhaNova.png"));
            imagemInputSenhaNova = ImageIO.read(getClass().getResource("/ImagensTelaSenhaNova/inputSenhaNova.png"));
            imagemInputConfirmarSenhaNova = ImageIO.read(getClass().getResource("/ImagensTelaSenhaNova/inputConfirmarSenhaNova.png"));
            imagemBotaoEnviarSenhaNova = ImageIO.read(getClass().getResource("/ImagensTelaSenhaNova/botaoEnviarSenhaNova.png"));
            imagemBotãoVoltarLogSN = ImageIO.read(getClass().getResource("/ImagensTelaSenhaNova/botaoVoltaLogSN.png"));
            
            JPanel painelConteudo = new JPanel() {
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
                    
                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraInputSenhaNova = (int) (imagemInputSenhaNova.getWidth() * 0.7 * escala);
                    int alturaInputSenhaNova = (int) (imagemInputSenhaNova.getHeight() * 0.7 * escala);
                    int larguraInputConfirmSenhaNova = (int) (imagemInputConfirmarSenhaNova.getWidth() * 0.7 * escala);
                    int alturaInputConfirmSenhaNova = (int) (imagemInputConfirmarSenhaNova.getHeight() * 0.7 * escala);
                    int largurabotaoEnviarSenhaNova = (int) (imagemBotaoEnviarSenhaNova.getWidth() * 0.7 * escala);
                    int alturabotaoEnviarSenhaNova = (int) (imagemBotaoEnviarSenhaNova.getHeight() * 0.7 * escala);
                    int larguraBotaoVoltarSN = (int) (imagemBotãoVoltarLogSN.getWidth() * 0.7 * escala);
                    int alturaBotaoVoltarSN = (int) (imagemBotãoVoltarLogSN.getHeight() * 0.7 * escala);
                    
                    int xNewPass = centroX - (larguraInputSenhaNova / 2);
                    int yNewPass = (int) (h * 0.60) - 50; // Posição vertical do campo email
                    int xConfirmPass = centroX - (larguraInputConfirmSenhaNova / 2);
                    int yConfirmPass = yNewPass + alturaInputSenhaNova + (int)(20 * escala); // 20px abaixo da Nova Senha
                    int xBEnviar = centroX - (largurabotaoEnviarSenhaNova / 2);
                    int yBEnviar = yConfirmPass + alturaInputConfirmSenhaNova + (int)(50 * escala); // 20px abaixo da Nova Senha
                    int xBotaoVoltarSN = centroX - (larguraBotaoVoltarSN / 2);
                    int yBotaoVoltarSN = yBEnviar + alturabotaoEnviarSenhaNova + 50; // 20px abaixo do botão enviar
                    
                    campoSenhaNova.setBounds(xNewPass + (int)(77 * escala) + 80,
                            yNewPass + (int)(27 * escala) - 23, 
                            (int)(400 * escala), 
                            (int)(50 * escala));
                    
                    campoConfirmarSenhaNova.setBounds(xConfirmPass + (int)(77 * escala) + 185,
                            yConfirmPass + (int)(27 * escala) - 23, 
                            (int)(400 * escala), 
                            (int)(50 * escala));
                    
                    botaoEnviar.setBounds(xBEnviar, yBEnviar, largurabotaoEnviarSenhaNova, alturabotaoEnviarSenhaNova);
                    botaoVoltar.setBounds(xBotaoVoltarSN, yBotaoVoltarSN, larguraBotaoVoltarSN, alturaBotaoVoltarSN);
                    
                    g2d.drawImage(imagemInputSenhaNova, xNewPass, yNewPass, larguraInputSenhaNova, alturaInputSenhaNova, this);
                    
                    g2d.drawImage(imagemBotãoVoltarLogSN, 
                            xBotaoVoltarSN, 
                            yBotaoVoltarSN, 
                            larguraBotaoVoltarSN, 
                            alturaBotaoVoltarSN, this);
                    
                    g2d.drawImage(imagemInputConfirmarSenhaNova,
                            xConfirmPass,
                            yConfirmPass, 
                            larguraInputConfirmSenhaNova, 
                            alturaInputConfirmSenhaNova, this);
                    
                    g2d.drawImage(imagemBotaoEnviarSenhaNova, 
                            xBEnviar, 
                            yBEnviar, 
                            largurabotaoEnviarSenhaNova, 
                            alturabotaoEnviarSenhaNova, this);
                }
           };
           painelConteudo.setOpaque(false);
           
           campoSenhaNova = new JPasswordField();
           campoSenhaNova.setBorder(null);
           campoSenhaNova.setOpaque(false);
           campoSenhaNova.setForeground(Color.BLACK);
           campoSenhaNova.setFont(new Font("Jockey One", Font.BOLD, 24));
           painelConteudo.add(campoSenhaNova);
           
           campoConfirmarSenhaNova = new JPasswordField();
           campoConfirmarSenhaNova.setBorder(null);
           campoConfirmarSenhaNova.setOpaque(false);
           campoConfirmarSenhaNova.setForeground(Color.BLACK);
           campoConfirmarSenhaNova.setFont(new Font("Jockey One", Font.BOLD, 24));
           painelConteudo.add(campoConfirmarSenhaNova);
           
           botaoEnviar = new JButton();
           botaoEnviar.setBorderPainted(false);
           botaoEnviar.setContentAreaFilled(false);
           botaoEnviar.setFocusPainted(false);
           botaoEnviar.setOpaque(false);
           botaoEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
           painelConteudo.add(botaoEnviar);
           
           botaoVoltar = new JButton();
           botaoVoltar.setBorderPainted(false);
           botaoVoltar.setContentAreaFilled(false);
           botaoVoltar.setFocusPainted(false);
           botaoVoltar.setOpaque(false);
           botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
           painelConteudo.add(botaoVoltar);
           
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
            
            if (imagemFundoSenhaNova != null) {
                g2d.drawImage(imagemFundoSenhaNova, 0, 0, w, h, this);
            }
        }
    }
}
