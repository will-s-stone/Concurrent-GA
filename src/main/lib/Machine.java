package src.main.lib;

import java.awt.*;

public class Machine {
    MachineType type;
    //(x, y) cartesian coords of machine
    int height, width, x, y;


    Machine(Machine.TYPE type, int x, int y){
        this.type = type;

        this.x = x;
        this.y = y;

    }

    void display()

}

