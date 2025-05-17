package TelasCriaçãoSala;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaQuestPersonalizado extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelQuestPersonalizada;

    public TelaQuestPersonalizado() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelQuestPersonalizada = new JPanel(cardLayout);

        try {
            PanelQuestPersonalizada panelQuestPersonalizada = new PanelQuestPersonalizada(); // Cria o painel
            add(panelQuestPersonalizada); // Adiciona o painel diretamente ao JFrame

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestPersonalizado tela = new TelaQuestPersonalizado();
            tela.setVisible(true);
        });
    }

    public static class PanelQuestPersonalizada extends JPanel {

        private BufferedImage imagemdeFundoQuestPersonalizado;
        private BufferedImage imagemNomeQuiz;
        private BufferedImage imagemBoxMateria;
        private BufferedImage imagemAddQuestao;
        private BufferedImage imagemMaterias;
        
        private JLabel labelSelecioneMateria;

        private boolean mostrarImagemMateria = false;


        private JButton botaoAddQuestao;
        private JButton botaoChoiceMateria;

        public PanelQuestPersonalizada() throws IOException {
            setLayout(new GridBagLayout());

            imagemdeFundoQuestPersonalizado = ImageIO.read(getClass().getResource
                    ("/ImagensTelaQuestPersonalizado/telaQuestaoPersonalizada.png"));
            imagemNomeQuiz = ImageIO.read(getClass().getResource("/ImagensTelaQuestPersonalizado/nomeQuiz.png"));
            imagemBoxMateria = ImageIO.read(getClass().getResource("/ImagensTelaQuestPersonalizado/boxMaterias.png"));
            imagemAddQuestao = ImageIO.read(getClass().getResource("/ImagensTelaQuestPersonalizado/addQuestao.png"));
            imagemMaterias = ImageIO.read(getClass().getResource("/ImagensTelaQuestPersonalizado/escolherMateria.png"));


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
                    double escala = 1.0;
                    int larguraNomeQuiz = (int) (imagemNomeQuiz.getWidth() * 0.7 * escala);
                    int alturaNomeQuiz = (int) (imagemNomeQuiz.getHeight() * 0.7 * escala);
                    int larguraBoxMateria = (int) (imagemBoxMateria.getWidth() * 0.7 * escala);
                    int alturaBoxMateria= (int) (imagemBoxMateria.getHeight() * 0.7 * escala);
                    int larguraAddQuest = (int) (imagemAddQuestao.getWidth() * 0.7 * escala);
                    int alturaAddQuest = (int) (imagemAddQuestao.getHeight() * 0.7 * escala);
                    int larguraChoiceMat = (int) (imagemMaterias.getWidth() * 0.7 * escala);
                    int alturaChoiceMat = (int) (imagemMaterias.getHeight() * 0.7 * escala);

                    int xNQuiz = centroX - (larguraNomeQuiz / 3) + 30;
                    int yNQuiz = (int) (h * 0.45) - 208;
                    int xBoxMat = centroX - (larguraNomeQuiz / 3) + 30;
                    int yBoxMat = yNQuiz + alturaNomeQuiz + (int)(45 * escala);
                    int xAddQ = centroX - (larguraBoxMateria / 2) - 5;
                    int yAddQ = yBoxMat + alturaBoxMateria + (int)(100 * escala);
                    int xCMat = centroX - (larguraNomeQuiz / 2) - 5;
                    int yCMat = yBoxMat + alturaChoiceMat + (int)(100 * escala);

                    botaoAddQuestao.setBounds(xAddQ, yAddQ, larguraAddQuest, alturaAddQuest);
                    botaoChoiceMateria.setBounds(xCMat, yCMat, larguraChoiceMat, alturaChoiceMat);

                    g2d.drawImage(imagemNomeQuiz, xNQuiz, yNQuiz, larguraNomeQuiz, alturaNomeQuiz, this);
                    g2d.drawImage(imagemBoxMateria, xBoxMat, yBoxMat, larguraBoxMateria, alturaBoxMateria, this);
                    g2d.drawImage(imagemAddQuestao, xAddQ, yAddQ, larguraAddQuest, alturaAddQuest, this);

                    if(mostrarImagemMateria && imagemMaterias != null){
                        g2d.drawImage(imagemMaterias, xBoxMat, yBoxMat, larguraBoxMateria, alturaBoxMateria, this);
                    }
                }
            };
            painelConteudo.setOpaque(false);
            
            labelSelecioneMateria = new JLabel(new ImageIcon(imagemMaterias));
            labelSelecioneMateria.setVisible(false);
            labelSelecioneMateria.setBounds(0, 0,
                    imagemMaterias.getWidth(), imagemMaterias.getHeight());
            painelConteudo.add(labelSelecioneMateria);

            botaoChoiceMateria = new JButton();
            botaoChoiceMateria.setBorderPainted(false);
            botaoChoiceMateria.setContentAreaFilled(false);
            botaoChoiceMateria.setFocusPainted(false);
            botaoChoiceMateria.setOpaque(false);
            botaoChoiceMateria.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoChoiceMateria.addActionListener(e -> {
                mostrarImagemMateria = true;
                painelConteudo.repaint();
            });

            painelConteudo.add(botaoChoiceMateria);

            botaoAddQuestao = new JButton();
            botaoAddQuestao.setBorderPainted(false);
            botaoAddQuestao.setContentAreaFilled(false);
            botaoAddQuestao.setFocusPainted(false);
            botaoAddQuestao.setOpaque(false);
            botaoAddQuestao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            painelConteudo.add(botaoAddQuestao);

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

            if (imagemdeFundoQuestPersonalizado != null) {
                g2d.drawImage(imagemdeFundoQuestPersonalizado, 0, 0, w, h, this);
            }
        }
    }
}