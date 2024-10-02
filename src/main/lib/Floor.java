package src.main.lib;

import javax.swing.*;
import java.util.List;
import java.awt.*;


public class Floor {
    private Station[] stations;
    JFrame frame;

    Floor(JFrame frame){
        this.frame = frame;
        this.frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final double [] [] AFFINITY = {
            // M1   M2   M3   M4
            {  0,  0.5, 0.3, 0.7 },  // M1
            { 0.5,  0, -0.2, 0.7 },  // M2
            { 0.3,-0.2,  0,  0.7 },  // M3
            { 0.7, 0.7, 0.7,  0  }   // M4
    };
    public static double getAffinity(Machine m1, Machine m2){
        return AFFINITY[m1.getType().ordinal()][m2.getType().ordinal()];
    }

    public static double calcProd(List<Machine> machines) {
        double tp = 0;
        // go through all the machines, do some stuff with the affinity with respect to their positions.
        // return tp, total production.
        for (int i = 0; i < machines.size(); i++) {
            // double check this if in trouble
            for (int j = i + 1; j < machines.size(); j++) {
                Machine m1 = machines.get(i);
                Machine m2 = machines.get(j);
                double d = calcDist(m1, m2);
                double a = getAffinity(m1, m2);
                tp += a / d;
            }
        }
        return tp;
    }

    public static double calcDist(Machine m1, Machine m2) {
        int dx = m1.getX() - m2.getX();
        int dy = m1.getY() - m2.getY();
        return Math.sqrt(dx * dx + dy * dy);
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
