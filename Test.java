import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JPanel implements KeyListener, ActionListener {
    private boolean upPressed = false;
    private boolean downPressed = false;

    private int paddleY = 250;  // Paleta del jugador
    private int paddleYAI = 250; // Paleta del oponente (AI)
    private int ballX = 350;
    private int ballY = 250;
    private int ballXDirection = -1;
    private int ballYDirection = -1;

    public Test() {
        Timer timer = new Timer(5, this);
        timer.start();

        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 700, 500);

        // Paletas
        g.setColor(Color.WHITE);
        g.fillRect(10, paddleY, 10, 100); // Paleta del jugador
        g.fillRect(670, paddleYAI, 10, 100); // Paleta de la AI

        // Bola
        g.fillOval(ballX, ballY, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Movimiento de la paleta del jugador
        if (upPressed && paddleY > 0) {
            paddleY -= 2;
        }
        if (downPressed && paddleY < 400) {
            paddleY += 2;
        }

        // Movimiento de la paleta del oponente (AI simple)
        if (ballY < paddleYAI && paddleYAI > 0) {
            paddleYAI -= 1;
        }
        if (ballY > paddleYAI + 100 && paddleYAI < 400) {
            paddleYAI += 1;
        }

        // Movimiento de la bola
        ballX += ballXDirection;
        ballY += ballYDirection;

        // Rebote en la parte superior e inferior de la ventana
        if (ballY <= 0 || ballY >= 480) {
            ballYDirection *= -1;
        }

        // Rebote en las paletas
        if (ballX <= 20 && ballY >= paddleY && ballY <= paddleY + 100) {
            ballXDirection *= -1;
        }
        if (ballX >= 650 && ballY >= paddleYAI && ballY <= paddleYAI + 100) {
            ballXDirection *= -1;
        }

        // Reinicio de la bola si sale por los lados izquierdo o derecho
        if (ballX <= 0 || ballX >= 680) {
            ballX = 350;
            ballY = 250;
            ballXDirection *= -1;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        Test game = new Test();
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
    }
}
