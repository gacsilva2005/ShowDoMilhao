package com.mycompany.telaspoligenio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaCriarSala extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelCriarSala;

    public TelaCriarSala() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        painelCriarSala = new JPanel(cardLayout);

        try {
            PanelCriarSala telaCriarSalaPanel = new PanelCriarSala(this);

            TelaQuestPersonalizado telaQuestPersonalizadoFrame = new TelaQuestPersonalizado(); // Instancia o JFrame (opcional, dependendo do seu design)
            TelaQuestPersonalizado.PanelQuestPersonalizada painelQuestPersonalizada = new TelaQuestPersonalizado.PanelQuestPersonalizada();
            TelaQuestPadrao telaQuestPadraoFrame = new TelaQuestPadrao(); // Instancia o JFrame (opcional, dependendo do seu design)
            TelaQuestPadrao.PanelQuestPadrao painelQuestPadrao = new TelaQuestPadrao.PanelQuestPadrao();// Instancia o JPanel
            painelCriarSala.add(telaCriarSalaPanel, "TelaCriarSala");
            painelCriarSala.add(painelQuestPersonalizada, "TelaQuestPersonalizado");
            painelCriarSala.add(painelQuestPadrao, "TelaQuestPadrao");// Adiciona o JPanel
            add(painelCriarSala);
            cardLayout.show(painelCriarSala, "TelaCriarSala");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarTela(String nomeTela) {
        cardLayout.show(painelCriarSala, nomeTela);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaCriarSala tela = new TelaCriarSala();
            tela.setVisible(true);
        });
    }

    public static class PanelCriarSala extends JPanel {

        private BufferedImage imagemDeFundoCriarSala;
        private BufferedImage imagemBotaoQuestPadr;
        private BufferedImage imagemBotaoQuestPers;
        private BufferedImage imagemBotaoCriar;
        private BufferedImage imagemBotaoVoltar;

        private BufferedImage imagemQuestPadrSelecionado;
        private BufferedImage imagemQuestPersSelecionado;

        private JLabel labelPadrSelecionado;
        private JLabel labelPersSelecionado;

        private JButton botaoSelecionado = null;

        private JButton botaoQuestPadr;
        private JButton botaoQuestPers;
        private JButton botaoCriar;
        private JButton botaoVoltar;

        private TelaCriarSala CriarSala;

        public PanelCriarSala(TelaCriarSala tela) throws IOException {
            this.CriarSala = tela;
            setLayout(new GridBagLayout());

            imagemDeFundoCriarSala = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/telaSelecaoSala.png"));
            imagemBotaoQuestPadr = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/questionarioPadrao.png"));
            imagemBotaoQuestPers = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/questionarioPersonalizado.png"));
            imagemBotaoCriar = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/botaoCriarCS.png"));
            imagemBotaoVoltar = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/botaoVoltarCS.png"));
            imagemQuestPadrSelecionado = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/questPdrSelecionado.png"));
            imagemQuestPersSelecionado = ImageIO.read(getClass().getResource("/ImagensTelaCriarSala/questPersSelecionado.png"));

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

                    double escala = 1.0; // Defina a escala conforme necessário
                    int larguraQPdr = (int) (imagemBotaoQuestPadr.getWidth() * 0.7 * escala);
                    int alturaQPdr = (int) (imagemBotaoQuestPadr.getHeight() * 0.7 * escala);
                    int larguraQPers = (int) (imagemBotaoQuestPers.getWidth() * 0.7 * escala);
                    int alturaQPers = (int) (imagemBotaoQuestPers.getHeight() * 0.7 * escala);
                    int larguraBCriar = (int) (imagemBotaoCriar.getWidth() * 0.7 * escala);
                    int alturaBCriar = (int) (imagemBotaoCriar.getHeight() * 0.7 * escala);
                    int larguraBVoltar = (int) (imagemBotaoVoltar.getWidth() * 0.7 * escala);
                    int alturaBVoltar = (int) (imagemBotaoVoltar.getHeight() * 0.7 * escala);
                    int larguraSelPadr = (int) (imagemQuestPadrSelecionado.getWidth() * 0.7 * escala);
                    int alturaSelPadr = (int) (imagemQuestPadrSelecionado.getHeight() * 0.7 * escala);
                    int larguraSelPers = (int) (imagemQuestPersSelecionado.getWidth() * 0.7 * escala);
                    int alturaSelPers = (int) (imagemQuestPersSelecionado.getHeight() * 0.7 * escala);

                    int xQPdr = centroX - (larguraQPdr / 2);
                    int yQPdr = (int) (h * 0.45) - 37; // 45% da altura da tela
                    int xQPers = centroX - (larguraQPdr / 2);
                    int yQPers = yQPdr + alturaQPdr + (int)(20 * escala);
                    int xBCriar = centroX - (larguraBCriar / 2) - 250;
                    int yBCriar = yQPers + alturaQPers + (int)(20 * escala) + 120;
                    int xBVoltar = centroX - (larguraBVoltar / 2) + 250;
                    int yBVoltar = yQPers + alturaQPers + (int)(20 * escala) + 120;

                    botaoQuestPadr.setBounds(xQPdr, yQPdr, larguraQPdr, alturaQPdr);
                    botaoQuestPers.setBounds(xQPers, yQPers, larguraQPers, alturaQPers);
                    botaoCriar.setBounds(xBCriar, yBCriar, larguraBCriar, alturaBCriar);
                    botaoVoltar.setBounds(xBVoltar, yBVoltar, larguraBVoltar, alturaBVoltar);

                    g2d.drawImage(imagemBotaoQuestPadr, xQPdr, yQPdr, larguraQPdr, alturaQPdr, this);
                    g2d.drawImage(imagemBotaoQuestPers, xQPers, yQPers, larguraQPers, alturaQPers, this);
                    g2d.drawImage(imagemBotaoCriar, xBCriar, yBCriar, larguraBCriar, alturaBCriar, this);
                    g2d.drawImage(imagemBotaoVoltar, xBVoltar, yBVoltar, larguraBVoltar, alturaBVoltar, this);


                }
            };
            painelConteudo.setOpaque(false);

            labelPadrSelecionado = new JLabel(new ImageIcon(imagemQuestPadrSelecionado));
            labelPadrSelecionado.setVisible(false);
            labelPadrSelecionado.setBounds(0, 0,
                    imagemQuestPadrSelecionado.getWidth(), imagemQuestPadrSelecionado.getHeight());
            painelConteudo.add(labelPadrSelecionado);

            labelPersSelecionado = new JLabel(new ImageIcon(imagemQuestPersSelecionado));
            labelPersSelecionado.setVisible(false);
            labelPersSelecionado.setBounds(0, 0,
                    imagemQuestPadrSelecionado.getWidth(), imagemQuestPersSelecionado.getHeight());
            painelConteudo.add(labelPersSelecionado);

            botaoQuestPadr = new JButton();
            botaoQuestPadr.setBorderPainted(false);
            botaoQuestPadr.setContentAreaFilled(false);
            botaoQuestPadr.setFocusPainted(false);
            botaoQuestPadr.setOpaque(false);
            botaoQuestPadr.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoQuestPadr.addActionListener(e -> SelecionarBotao("padrao"));
            painelConteudo.add(botaoQuestPadr);


            botaoQuestPers = new JButton();
            botaoQuestPers.setBorderPainted(false);
            botaoQuestPers.setContentAreaFilled(false);
            botaoQuestPers.setFocusPainted(false);
            botaoQuestPers.setOpaque(false);
            botaoQuestPers.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoQuestPers.addActionListener(e -> SelecionarBotao("personalizado"));
            painelConteudo.add(botaoQuestPers);

            botaoCriar = new JButton();
            botaoCriar.setBorderPainted(false);
            botaoCriar.setContentAreaFilled(false);
            botaoCriar.setFocusPainted(false);
            botaoCriar.setOpaque(false);
            botaoCriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            botaoCriar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (botaoSelecionado == botaoQuestPers) {
                        CriarSala.mostrarTela("TelaQuestPersonalizado");
                    } else if (botaoSelecionado == botaoQuestPadr) {
                        CriarSala.mostrarTela("TelaQuestPadrao");
                    } else {
                        JOptionPane.showMessageDialog(PanelCriarSala.this, "Selecione um tipo de questionário para criar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            painelConteudo.add(botaoCriar);

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

        private void SelecionarBotao(String tipo) {
            switch (tipo) {
                case "padrao":
                    if (botaoSelecionado != botaoQuestPadr) {
                        int x = botaoQuestPadr.getX() + (botaoQuestPadr.getWidth()
                                - imagemQuestPadrSelecionado.getWidth()) / 2;
                        int y = botaoQuestPadr.getY() + (botaoQuestPadr.getHeight()
                                - imagemQuestPadrSelecionado.getHeight()) / 2;
                        labelPadrSelecionado.setBounds(x, y,
                                imagemQuestPadrSelecionado.getWidth(), imagemQuestPadrSelecionado.getHeight());
                        labelPadrSelecionado.setVisible(true);
                        labelPersSelecionado.setVisible(false);
                        labelPadrSelecionado.repaint();
                        botaoSelecionado = botaoQuestPadr;
                    }
                    break;

                case "personalizado":
                    if (botaoSelecionado != botaoQuestPers) {
                        int x = botaoQuestPers.getX() + (botaoQuestPers.getWidth()
                                - imagemQuestPersSelecionado.getWidth()) / 2;
                        int y = botaoQuestPers.getY() + (botaoQuestPers.getHeight()
                                - imagemQuestPersSelecionado.getHeight()) / 2;
                        labelPersSelecionado.setBounds(x, y,
                                imagemQuestPersSelecionado.getWidth(), imagemQuestPersSelecionado.getHeight());
                        labelPersSelecionado.setVisible(true);
                        labelPadrSelecionado.setVisible(false);
                        labelPersSelecionado.repaint();
                        botaoSelecionado = botaoQuestPers;
                    }
                    break;
            }
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

            if (imagemDeFundoCriarSala != null) {
                g2d.drawImage(imagemDeFundoCriarSala, 0, 0, w, h, this);
            }
        }
    }
}