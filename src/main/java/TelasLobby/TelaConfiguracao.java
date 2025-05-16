package TelasLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaConfiguracao extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelConfiguracao;
    
    
    public TelaConfiguracao() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelConfiguracao = new JPanel(cardLayout);

        try {
            PanelConfiguracao telaConfigPanel = new PanelConfiguracao();
            painelConfiguracao.add(telaConfigPanel, "TelaConfiguracao");
            add(painelConfiguracao);
            cardLayout.show(painelConfiguracao, "TelaConfiguracao");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaConfiguracao tela = new TelaConfiguracao();
            tela.setVisible(true);
        });
    }
    
    public static class PanelConfiguracao extends JPanel {

        private BufferedImage imagemDeFundoConfiguracao;
        private BufferedImage imagemBotaoAudioOn;
        private BufferedImage imagemBotaoAudioOff;
        private BufferedImage imagemBotaoSairConfig;
        
        private JButton botaoAudioOn;
        private JButton botaoAudioOff;
        private JButton botaoSair;
        
        public PanelConfiguracao() throws IOException {
            setLayout(new GridBagLayout());

            imagemDeFundoConfiguracao = ImageIO.read(getClass().getResource("/ImagensTelaConfiguracao/telaConfiguracao.png"));
            imagemBotaoAudioOn = ImageIO.read(getClass().getResource("/ImagensTelaConfiguracao/botaoMusicaOn.png"));
            imagemBotaoAudioOff = ImageIO.read(getClass().getResource("/ImagensTelaConfiguracao/botaoMusicaOff.png"));
            imagemBotaoSairConfig = ImageIO.read(getClass().getResource("/ImagensTelaConfiguracao/botaoSairConfig.png"));
            
            
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
                    int larguraAudioOn = (int) (imagemBotaoAudioOn.getWidth() * 0.7 * escala);
                    int alturaAudioOn = (int) (imagemBotaoAudioOn.getHeight() * 0.7 * escala);
                    int larguraAudioOff = (int) (imagemBotaoAudioOff.getWidth() * 0.7 * escala);
                    int alturaAudioOff = (int) (imagemBotaoAudioOff.getHeight() * 0.7 * escala);
                    int larguraSair = (int) (imagemBotaoSairConfig.getWidth() * 0.7 * escala);
                    int alturaSair = (int) (imagemBotaoSairConfig.getHeight() * 0.7 * escala);
                    
                    int xAudioON = centroX - (larguraAudioOn / 2) - 90;
                    int yAudioON = (int) (h * 0.45); // 45% da altura da tela
                    int xAudioOFF = centroX - (alturaAudioOff / 2) + 90;
                    int yAudioOFF = (int) (h * 0.45); // 45% da altura da tela
                    int xSair = centroX - (larguraSair / 2);
                    int ySair = (int) (h * 0.45) + 400; // 20px abaixo do campo NOME
                    
                    botaoAudioOn.setBounds(xAudioON, yAudioON, larguraAudioOn, alturaAudioOn);
                    botaoAudioOff.setBounds(xAudioOFF, yAudioOFF, larguraAudioOff, alturaAudioOff);
                    botaoSair.setBounds(xSair, ySair, larguraSair, alturaSair);
                    
                    g2d.drawImage(imagemBotaoAudioOff, xAudioOFF, yAudioOFF, larguraAudioOff, alturaAudioOff, this);
                    g2d.drawImage(imagemBotaoAudioOn, xAudioON, yAudioON, larguraAudioOn, alturaAudioOn, this);
                    g2d.drawImage(imagemBotaoSairConfig, xSair, ySair, larguraSair, alturaSair, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            botaoAudioOn = new JButton();
            botaoAudioOn.setBorderPainted(false);
            botaoAudioOn.setContentAreaFilled(false);
            botaoAudioOn.setFocusPainted(false);
            botaoAudioOn.setOpaque(false);
            botaoAudioOn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAudioOn);
            
            botaoAudioOff = new JButton();
            botaoAudioOff.setBorderPainted(false);
            botaoAudioOff.setContentAreaFilled(false);
            botaoAudioOff.setFocusPainted(false);
            botaoAudioOff.setOpaque(false);
            botaoAudioOff.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAudioOff);
            
            botaoSair = new JButton();
            botaoSair.setBorderPainted(false);
            botaoSair.setContentAreaFilled(false);
            botaoSair.setFocusPainted(false);
            botaoSair.setOpaque(false);
            botaoSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoSair);
            
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
            
            if (imagemDeFundoConfiguracao != null) {
                g2d.drawImage(imagemDeFundoConfiguracao, 0, 0, w, h, this);
            }
        }
    }
}
