package sample;

import javax.swing.*;
import java.awt.*;

class FrameSet extends JFrame {

    final int HEIGHT = 1000;
    final int WIDTH = 1000;
    final int k;

    public FrameSet(int k) {
        this.setSize(WIDTH, HEIGHT);// общий фон
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.k = k;
    }

    public void paint(Graphics g) {
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.60F);
        g.setFont(newFont);
        //---
        int UnitSegmentForX = 35;// еденичный отрезок
        int UnitSegmentForY = 35;
        int UnitSegmentForXOtriz = 35;
        int UnitSegmentForYOtriz = 35;
        Graphics2D g2 = (Graphics2D) g;
        Color newColor = new Color(13, 165, 19, 180);// color of graph
        g2.setColor(newColor);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);//line x
        g2.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);// line y
        g2.drawString("0", HEIGHT / 2, WIDTH / 2);// location(0, 0)

        for (int i = 1; i <= 13; i++) {// местоположение всех точек отн ОХ от 0 до 10
            g2.drawString(String.valueOf(i), (HEIGHT / 2) + UnitSegmentForX, (WIDTH / 2));
            UnitSegmentForX += 35;
        }
        for (int i = 1; i <= 13; i++) { //местоположение всех точек отн ОY от 0 до 10
            g2.drawString(String.valueOf(i), (HEIGHT / 2), (WIDTH / 2) - UnitSegmentForY);
            UnitSegmentForY += 35;
        }
        for (int i = -1; i >= -13; i--) {// Отн X от -1 до -10
            g2.drawString(String.valueOf(i), (HEIGHT / 2) - UnitSegmentForXOtriz, WIDTH / 2);
            UnitSegmentForXOtriz += 35;
        }
        for (int i = -1; i >= -13; i--) {//Отн Y от -1 до -10
            g2.drawString(String.valueOf(i), (HEIGHT / 2), (WIDTH / 2) + UnitSegmentForYOtriz);
            UnitSegmentForYOtriz += 35;
        }

        //draw grid
        g2.setStroke(new BasicStroke(1));
        int dx, dy;
        Color c1 = new Color(39, 2, 45, 255);
        dx = dy = 35;
        Color c = g2.getColor(); // save color
        final int W = getWidth();
        final int H = getHeight();
        g2.setColor(c1);
        for (int x = 10; x < W; x += dx) {
            g2.drawLine(x, 0, x, H);
        }
        for (int y = 10; y < H; y += dy) {
            g2.drawLine(0, y, W, y);
        }
        g2.setColor(c); // restore color

        //---------------------------y = ax^2-----------------------------↓

        if(a < 0){
            for(int i = 0; i < 10; i++){
                g2.drawLine((WIDTH / 2) - (35 * (i)),
                        (int) ((HEIGHT / 2) - (35 * (a * Math.pow(i, 2)))),
                        (WIDTH / 2) - (35 * (i + 1)),
                        (int) ((HEIGHT / 2) - (35 * (a * (Math.pow((i + 1), 2)))))

                );
                for(int j = 0; j > -10; j--){
                    g2.drawLine((WIDTH / 2) - (35 * (j)),
                            (int) ((HEIGHT / 2) - (35 * (a * Math.pow(j, 2)))),
                            (WIDTH / 2) - (35 * (j + 1)),
                            (int) ((HEIGHT / 2) - (35 * (a * (Math.pow((j + 1), 2)))))

                    );
                }
            }
        }
        else if(a > 0){
            for(int i = 0; i < 10; i++){
                g2.drawLine((WIDTH / 2) + (35 * (i)),
                        (int) ((HEIGHT / 2) - (35 * (a * Math.pow(i, 2)))),
                        (WIDTH / 2) + (35 * (i + 1)),
                        (int) ((HEIGHT / 2) - (35 * (a * (Math.pow((i + 1), 2)))))

                );
                for(int j = 0; j > -10; j--){
                    g2.drawLine((WIDTH / 2) + (35 * (j)),
                            (int) ((HEIGHT / 2) - (35 * (a * Math.pow(j, 2)))),
                            (WIDTH / 2) + (35 * (j + 1)),
                            (int) ((HEIGHT / 2) - (35 * (a * (Math.pow((j + 1), 2)))))

                    );
                }
            }

        }


    }
}
