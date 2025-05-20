
package com.mycompany.telaquestionario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaQuestionario extends JFrame{

    
    public void setNavigation(CardLayout cardLayout, JPanel painelPrincipal) {
        this.cardLayout = cardLayout;
        this.painelQuestionario = painelPrincipal;
    }
    
    public TelaQuestionario() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        
        painelQuestionario = new JPanel(cardLayout);

        try {
            PanelQuestionario telaQuestionarioPanel = new PanelQuestionario(painelQuestionario);
            painelQuestionario.add(telaQuestionarioPanel, "TelaRecuperarSenha");
            add(painelQuestionario);
            cardLayout.show(painelQuestionario, "TelaRecuperarSenha");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestionario tela = new TelaQuestionario();
            tela.setVisible(true);
        });
    }
    public static class PanelQuestionario extends JPanel {

        private BufferedImage imagemDeFundoQuestionario;
        private BufferedImage imagemBotaoUsarQuestionario;
        private BufferedImage imagemBotaoEditar;
        private BufferedImage imagemBotaoNovoQuestionario;
                
        private JButton BotaoUsarQuestionario;
        private JButton BotaoEditar;
        private JButton BotaoNovoQuestionario;
        private final JPanel container;
        
        
        public PanelQuestionario(JPanel container) throws IOException {
            this.container = container;
            setLayout(new GridBagLayout());

            imagemDeFundoQuestionario = ImageIO.read(getClass().getResource("/ImagensTelaRecuperarSenha/telaRecuperarSenha.png"));
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
                    double escala = 1.1; // Defina a escala conforme necessário
                }
            };
            painelConteudo.setOpaque(false);
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
            
            if (imagemDeFundoQuestionario != null) {
                g2d.drawImage(imagemDeFundoQuestionario, 0, 0, w, h, this);
            }
        }
    }
    
}


