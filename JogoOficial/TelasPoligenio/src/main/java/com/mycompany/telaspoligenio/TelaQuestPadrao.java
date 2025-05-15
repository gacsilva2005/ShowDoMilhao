package com.mycompany.telaspoligenio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaQuestPadrao extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelQuestPadrao;  
    
    public TelaQuestPadrao() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelQuestPadrao = new JPanel(cardLayout);
        try {
            PanelQuestPadrao painelQuestPadrao = new PanelQuestPadrao(); // Cria o painel
            add(painelQuestPadrao); // Adiciona o painel diretamente ao JFrame

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestPadrao tela = new TelaQuestPadrao();
            tela.setVisible(true);
        });
    }
    
    public static class PanelQuestPadrao extends JPanel {
        
        private BufferedImage imagemdeFundoQuestPadrao;
        private BufferedImage imagemMatematicaPadrao;
        private BufferedImage imagemPortuguesPadrao;
        private BufferedImage imagemHistoriaPadrao;
        private BufferedImage imagemGeografiaPadrao;
        private BufferedImage imagemCienciasPadrao;
        
        private JButton botaoMatematica;
        private JButton botaoPortugues;
        private JButton botaoHistoria;
        private JButton botaoGeografia;
        private JButton botaoCiencias;
        
        
        public PanelQuestPadrao() throws IOException {
            setLayout(new GridBagLayout());
                
            imagemdeFundoQuestPadrao = ImageIO.read(getClass().getResource
                                        ("/ImagensQuestPadrao/telaQuestPadrao.png"));
            imagemMatematicaPadrao = ImageIO.read(getClass().getResource("/ImagensQuestPadrao/matematicaPadrao.png"));
            imagemPortuguesPadrao = ImageIO.read(getClass().getResource("/ImagensQuestPadrao/portuguesPadrao.png"));
            imagemHistoriaPadrao = ImageIO.read(getClass().getResource("/ImagensQuestPadrao/historiaPadrao.png"));
            imagemGeografiaPadrao = ImageIO.read(getClass().getResource("/ImagensQuestPadrao/geografiaPadrao.png"));
            imagemCienciasPadrao = ImageIO.read(getClass().getResource("/ImagensQuestPadrao/cienciasPadrao.png"));
            
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
                    int larguraMatematicaPadrao = (int) (imagemMatematicaPadrao.getWidth() * 0.7 * escala);
                    int alturaMatematicaPadrao = (int) (imagemMatematicaPadrao.getHeight() * 0.7 * escala);
                    int larguraPortuguesPadrao = (int) (imagemPortuguesPadrao.getWidth() * 0.7 * escala);
                    int alturaPortuguesPadrao = (int) (imagemPortuguesPadrao.getHeight() * 0.7 * escala);
                    int larguraHistoriaPadrao = (int) (imagemHistoriaPadrao.getWidth() * 0.7 * escala);
                    int alturaHistoriaPadrao = (int) (imagemHistoriaPadrao.getHeight() * 0.7 * escala);
                    int larguraGeografiaPadrao = (int) (imagemGeografiaPadrao.getWidth() * 0.7 * escala);
                    int alturaGeografiaPadrao = (int) (imagemGeografiaPadrao.getHeight() * 0.7 * escala);
                    
                    // Posicionamento com base no centro
                    int xMat = centroX - (larguraMatematicaPadrao / 2) - 300;
                    int yMat = (int) (h * 0.60) - 240; // Posição vertical do botão Matematica
                    int xPort = centroX - (larguraMatematicaPadrao / 2) - 300;
                    int yPort = yMat + alturaMatematicaPadrao + (int)(10 * escala); // 40px abaixo do botao Matematica
                    int xHist = centroX - (larguraMatematicaPadrao / 2) + 280;
                    int yHist = (int) (h * 0.60) - 240; // Posição vertical do botão Historia
                    int xGeo = centroX - (larguraMatematicaPadrao / 2) + 280;
                    int yGeo = yHist + alturaHistoriaPadrao + (int)(10 * escala);
                    
                    botaoMatematica.setBounds(xMat, yMat, larguraMatematicaPadrao, alturaMatematicaPadrao);
                    botaoPortugues.setBounds(xPort, yPort, larguraPortuguesPadrao, alturaPortuguesPadrao);
                    botaoHistoria.setBounds(xHist, yHist, larguraHistoriaPadrao, alturaHistoriaPadrao);
                    botaoGeografia.setBounds(xGeo, yGeo, larguraGeografiaPadrao, alturaGeografiaPadrao);
                    
                    g2d.drawImage(imagemMatematicaPadrao, xMat, yMat, larguraMatematicaPadrao, alturaMatematicaPadrao, this);
                    g2d.drawImage(imagemPortuguesPadrao, xPort, yPort, larguraPortuguesPadrao, alturaPortuguesPadrao, this);
                    g2d.drawImage(imagemHistoriaPadrao, xHist, yHist, larguraHistoriaPadrao, alturaHistoriaPadrao, this);
                    g2d.drawImage(imagemGeografiaPadrao, xGeo, yGeo, larguraGeografiaPadrao, alturaGeografiaPadrao, this);
                    
                }
            };
            painelConteudo.setOpaque(false);
            
            botaoMatematica = new JButton();
            botaoMatematica.setBorderPainted(false);
            botaoMatematica.setContentAreaFilled(false);
            botaoMatematica.setFocusPainted(false);
            botaoMatematica.setOpaque(false);
            botaoMatematica.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoMatematica);
            
            botaoPortugues = new JButton();
            botaoPortugues.setBorderPainted(false);
            botaoPortugues.setContentAreaFilled(false);
            botaoPortugues.setFocusPainted(false);
            botaoPortugues.setOpaque(false);
            botaoPortugues.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoPortugues);
            
            botaoHistoria = new JButton();
            botaoHistoria.setBorderPainted(false);
            botaoHistoria.setContentAreaFilled(false);
            botaoHistoria.setFocusPainted(false);
            botaoHistoria.setOpaque(false);
            botaoHistoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoHistoria);
            
            botaoGeografia = new JButton();
            botaoGeografia.setBorderPainted(false);
            botaoGeografia.setContentAreaFilled(false);
            botaoGeografia.setFocusPainted(false);
            botaoGeografia.setOpaque(false);
            botaoGeografia.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoGeografia);
            
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
            
            if (imagemdeFundoQuestPadrao != null) {
                g2d.drawImage(imagemdeFundoQuestPadrao, 0, 0, w, h, this);
            }
        }
    }
}
