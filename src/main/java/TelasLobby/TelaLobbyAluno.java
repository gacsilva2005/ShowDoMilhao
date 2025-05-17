package TelasLobby;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaLobbyAluno extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelLobbyAluno;
    
    public TelaLobbyAluno(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelLobbyAluno = new JPanel(cardLayout);
        
        try {
            PanelLobbyAluno telaLobbyAlunoPanel = new PanelLobbyAluno();
            painelLobbyAluno.add(telaLobbyAlunoPanel, "TelaLobbyAluno");
            add(painelLobbyAluno);
            cardLayout.show(painelLobbyAluno, "TelaLobbyAluno");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLobbyAluno telaPrincipal = new TelaLobbyAluno();
            telaPrincipal.setVisible(true);
        });
    }
    
    public static class PanelLobbyAluno extends JPanel {
        
        private BufferedImage imagemDeFundoLobbyAluno;
        private BufferedImage imagemBotaoJogar;
        private BufferedImage imagemBotaoConfig;
        private BufferedImage imagemBoxCash;
        
        private JButton botaoJogar;
        private JButton botaoConfig;
        private JTextField campoCash;
        
        public PanelLobbyAluno() throws IOException {
            setLayout(new GridBagLayout());
            
            imagemDeFundoLobbyAluno = ImageIO.read(getClass().getResource("/ImagensTelaLobbyAluno/telaLobbyAluno.png"));
            imagemBotaoJogar = ImageIO.read(getClass().getResource("/ImagensTelaLobbyAluno/botaoJogar.png"));
            imagemBotaoConfig = ImageIO.read(getClass().getResource("/ImagensTelaLobbyAluno/botaoConfig.png"));
            imagemBoxCash = ImageIO.read(getClass().getResource("/ImagensTelaLobbyAluno/boxCash.png"));
            
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
                    int larguraBotJogar = (int) (imagemBotaoJogar.getWidth() * 0.7 * escala);
                    int alturaBotJogar = (int) (imagemBotaoJogar.getHeight() * 0.7 * escala);
                    int larguraBotConfig = (int) (imagemBotaoConfig.getWidth() * 0.7 * escala);
                    int alturaBotConfig = (int) (imagemBotaoConfig.getHeight() * 0.7 * escala);
                    int larguraBoxCash = (int) (imagemBoxCash.getWidth() * 0.7 * escala);
                    int alturaBoxCash = (int) (imagemBoxCash.getHeight() * 0.7 * escala);
                    
                    // Posicionamento com base no centro
                    int xJogar = centroX - (larguraBotJogar / 2) - 290;
                    int yJogar = (int) (h * 0.45) + 20; // 45% da altura da tela
                    int xConfig = centroX - (larguraBotJogar / 2) - 290;
                    int yConfig = yJogar + alturaBotJogar + (int)(20 * escala); // 20px abaixo do campo RA
                    int xCash = centroX + (larguraBotJogar / 3); // alinhado horizontalmente com a imagem de referência
                    int yCash = yConfig + alturaBotConfig + (int)(20 * escala); // 20px abaixo da imagem de referência
                    
                    botaoJogar.setBounds(xJogar, yJogar, larguraBotJogar, alturaBotJogar);
                    botaoConfig.setBounds(xConfig, yConfig, larguraBotConfig, alturaBotConfig);
                    campoCash.setBounds(xCash + (int)(77 * escala) + 140, yCash + (int)(27 * escala) - 18, (int)(400 * escala), (int)(50 * escala));
                    
                    // Desenhar campos
                    g2d.drawImage(imagemBotaoJogar, xJogar, yJogar, larguraBotJogar, alturaBotJogar, this);
                    g2d.drawImage(imagemBotaoConfig, xConfig, yConfig, larguraBotConfig, alturaBotConfig, this);
                    g2d.drawImage(imagemBoxCash, xCash, yCash, larguraBoxCash, alturaBoxCash, this);
                }
            };
            painelConteudo.setOpaque(false);
            
            botaoJogar = new JButton();
            botaoJogar.setBorderPainted(false);
            botaoJogar.setContentAreaFilled(false);
            botaoJogar.setFocusPainted(false);
            botaoJogar.setOpaque(false);
            botaoJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoJogar);
            
            botaoConfig = new JButton();
            botaoConfig.setBorderPainted(false);
            botaoConfig.setContentAreaFilled(false);
            botaoConfig.setFocusPainted(false);
            botaoConfig.setOpaque(false);
            botaoConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoConfig);
            
            campoCash = new JTextField();
            campoCash.setBorder(null);
            campoCash.setOpaque(false);
            campoCash.setForeground(Color.BLACK);
            campoCash.setFont(new Font("Jockey One", Font.BOLD, 40));
            campoCash.setText("1.000");
            campoCash.setEditable(false);
            campoCash.setFocusable(false);
            painelConteudo.add(campoCash);
            
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
            
            if (imagemDeFundoLobbyAluno != null) {
                g2d.drawImage(imagemDeFundoLobbyAluno, 0, 0, w, h, this);
            }
        }
    }
}
