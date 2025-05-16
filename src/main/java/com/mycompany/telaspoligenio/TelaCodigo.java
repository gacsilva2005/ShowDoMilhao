    package com.mycompany.telaspoligenio;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
    import javax.imageio.ImageIO;

    public class TelaCodigo extends JFrame {

        private CardLayout cardLayout;
        private JPanel painelCodigo;

        public TelaCodigo() {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            cardLayout = new CardLayout();
            painelCodigo = new JPanel(cardLayout);

            try {
                PanelCodigo telaCodigoPanel = new PanelCodigo();
                painelCodigo.add(telaCodigoPanel, "TelaCodigo");
                add(painelCodigo);
                cardLayout.show(painelCodigo, "TelaCodigo");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao inicializar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                TelaCodigo tela = new TelaCodigo();
                tela.setVisible(true);
            });
        }

        public static class PanelCodigo extends JPanel {
            
            private int xInput, yInput, larguraInputCod, alturaInputCod;


            private BufferedImage imagemDeFundoCodigo;
            private BufferedImage imagemBotaoEntrarCodigo;
            private BufferedImage imagemBotaoVoltarCodigo;
            private BufferedImage imagemInputCodigo;

            private JButton botaoEntrarCod;
            private JButton botaoVoltarCod;
            private JTextField campoTextoCodigo;

            public PanelCodigo() throws IOException {
                setLayout(new GridBagLayout());

                imagemDeFundoCodigo = ImageIO.read(getClass().getResource("/ImagensTelaCodigo/telaCodigo.png"));
                imagemBotaoEntrarCodigo = ImageIO.read(getClass().getResource("/ImagensTelaCodigo/botaoEntrarCodigo.png"));
                imagemBotaoVoltarCodigo = ImageIO.read(getClass().getResource("/ImagensTelaCodigo/botaoVoltarCodigo.png"));
                imagemInputCodigo = ImageIO.read(getClass().getResource("/ImagensTelaCodigo/inputCodigo.png"));

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
                        int larguraEntarCod = (int) (imagemBotaoEntrarCodigo.getWidth() * 0.7 * escala);
                        int alturaEntrarCod = (int) (imagemBotaoEntrarCodigo.getHeight() * 0.7 * escala);
                        int larguraBotVoltCod = (int) (imagemBotaoVoltarCodigo.getWidth() * 0.7 * escala);
                        int alturaBotVoltCod = (int) (imagemBotaoVoltarCodigo.getHeight() * 0.7 * escala);
                        
                        larguraInputCod = (int) (imagemInputCodigo.getWidth() * 0.7 * escala);
                        alturaInputCod = (int) (imagemInputCodigo.getHeight() * 0.7 * escala);

                        xInput = centroX - (larguraInputCod/2) - 15; // alinhado horizontalmente com a imagem de referência
                        yInput = (int) (h * 0.45) - 40;
                        
                        int xEntrar = centroX - (larguraEntarCod / 2) - 15;
                        int yEntrar = yInput + alturaInputCod + (int)(35 * escala); 
                        int xVolt = centroX - (larguraBotVoltCod / 2) - 15;
                        int yVolt = yEntrar + alturaEntrarCod + (int)(5 * escala); 


                        botaoEntrarCod.setBounds(xEntrar, yEntrar, larguraEntarCod, alturaEntrarCod);
                        botaoVoltarCod.setBounds(xVolt, yVolt, larguraBotVoltCod, alturaBotVoltCod);
                        campoTextoCodigo.setBounds(xInput + (int)(77 * escala) + 200, yInput + (int)(27 * escala) - 3, (int)(400 * escala), (int)(50 * escala));

                        // Desenhar campos
                        g2d.drawImage(imagemBotaoEntrarCodigo, xEntrar, yEntrar, larguraEntarCod, alturaEntrarCod, this);
                        g2d.drawImage(imagemBotaoVoltarCodigo, xVolt, yVolt, larguraBotVoltCod, alturaBotVoltCod, this);
                        g2d.drawImage(imagemInputCodigo, xInput, yInput, larguraInputCod, alturaInputCod, this);
                    }
                };
                painelConteudo.setOpaque(false);

                botaoEntrarCod = new JButton();
                botaoEntrarCod.setBorderPainted(false);
                botaoEntrarCod.setContentAreaFilled(false);
                botaoEntrarCod.setFocusPainted(false);
                botaoEntrarCod.setOpaque(false);
                botaoEntrarCod.setCursor(new Cursor(Cursor.HAND_CURSOR));
                painelConteudo.add(botaoEntrarCod);

                botaoVoltarCod = new JButton();
                botaoVoltarCod.setBorderPainted(false);
                botaoVoltarCod.setContentAreaFilled(false);
                botaoVoltarCod.setFocusPainted(false);
                botaoVoltarCod.setOpaque(false);
                botaoVoltarCod.setCursor(new Cursor(Cursor.HAND_CURSOR));
                painelConteudo.add(botaoVoltarCod);

                campoTextoCodigo = new JTextField();
                campoTextoCodigo.setBorder(null);
                campoTextoCodigo.setOpaque(false);
                campoTextoCodigo.setForeground(Color.BLACK);
                campoTextoCodigo.setFont(new Font("Jockey One", Font.BOLD, 30));
                painelConteudo.add(campoTextoCodigo);
                
                painelConteudo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Rectangle areaInput = new Rectangle(xInput, yInput, larguraInputCod, alturaInputCod);
                    if (areaInput.contains(e.getPoint())) {
                        campoTextoCodigo.requestFocusInWindow();
                        }
                    }       
                });
                        
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

                if (imagemDeFundoCodigo != null) {
                    g2d.drawImage(imagemDeFundoCodigo, 0, 0, w, h, this);
                }
            }
        }
    }
