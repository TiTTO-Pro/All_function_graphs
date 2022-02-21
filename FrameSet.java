package sample;

import javax.swing.*;
import java.awt.*;

class FrameSet extends JFrame {

    final int HEIGHT = 1000;
    final int WIDTH = 1000;
    // final int k; - remove the comment to start the graph 'y = k / x'
    // final int a; - like ~k~ and etc.

    public FrameSet() // public FrameSet(int k) - 'y = k / x'
                      // public FrameSet(int a) - 'y = ax ^ 2'
                      // public FrameSet() - 'y = √x'
    {
        this.setSize(WIDTH, HEIGHT);// general background
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        //this.k = k; - for 'y = k / x'
        //this.a = a; - for 'y = ax ^ 2'
        
    }

    public void paint(Graphics g) {
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.60F);
        g.setFont(newFont);
        //---
        int UnitSegmentForX = 35;// Unit segment(35 pixels)
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

        for (int i = 1; i <= 13; i++) {// the location of all points relative to ОХ from 1 until 13
            g2.drawString(String.valueOf(i), (HEIGHT / 2) + UnitSegmentForX, (WIDTH / 2));
            UnitSegmentForX += 35;
        }
        for (int i = 1; i <= 13; i++) { // the location of all points relative to ОY from 1 until 13
            g2.drawString(String.valueOf(i), (HEIGHT / 2), (WIDTH / 2) - UnitSegmentForY);
            UnitSegmentForY += 35;
        }
        for (int i = -1; i >= -13; i--) {// the location of all points relative to ОХ from -1 until -13
            g2.drawString(String.valueOf(i), (HEIGHT / 2) - UnitSegmentForXOtriz, WIDTH / 2);
            UnitSegmentForXOtriz += 35;
        }
        for (int i = -1; i >= -13; i--) {// the location of all points relative to ОY from -1 until -13
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
        
        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(115, 9, 9));

        //---------------↓-----------Insert the code here(y = ax^2 and etc)------------------------↓
        
        
        //---------------|------------------------End----------------------------------------------|



    }
}
