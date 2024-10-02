package src.main.lib;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.util.Random;


public class Floor {
    private List<Machine> machines;
    private final int h;
    private final int w;

    Floor(int h, int w){
        this.h = h;
        this.w = w;
        machines = new ArrayList<>();
    }

    void load(int num){
        ArrayList<MachineType> types = new ArrayList<MachineType>(Arrays.asList(MachineType.values()));
        for (int i = 0; i < num; i++) {
            Random rdm = new Random();
            int idx = rdm.nextInt(types.size());
            machines.add(new Machine(types.get(idx) , rdm.nextInt(w), rdm.nextInt(h)));
        }
    }

    public static void main(String[] args) {
        Floor f = new Floor(1000, 1000);
        f.load(11);
        VisFloor vf = new VisFloor();
        vf.addMachines(f.machines);
        JFrame frame = new JFrame("Floor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(f.h, f.w);

        frame.getContentPane().add(vf);
        frame.setVisible(true);

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

}

class VisFloor extends JComponent {
    List<Machine> machines = new ArrayList<>();
    public void addMachines(List<Machine> machines){
        this.machines = machines;
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Machine m : machines){
            g2.drawRect(m.getX(), m.getY(), m.getWidth(), m.getHeight());
        }
    }
}
