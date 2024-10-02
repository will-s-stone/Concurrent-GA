package src.main.lib;

import javax.swing.*;
import java.awt.*;


public class Floor {
    private Station[] stations;
    JFrame frame;

    Floor(JFrame frame){
        this.frame = frame;
        this.frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    class Station {
        public void draw(JFrame frame) {
            frame.add(new JPanel() {
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawRect(50, 50, 200, 100);
                }
            });
            frame.setVisible(true);
        }

    }

    void draw(){
        for (int i = 0; i < stations.length; i++) {
            stations[i].draw(frame);

        }
    }
}
