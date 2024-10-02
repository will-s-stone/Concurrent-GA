package src.main.lib;

import java.awt.*;

public class Machine {
    private MachineType type;
    //(x, y) cartesian coords of machine
    private final int x;
    private final int y;


    Machine(MachineType type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;

    }
    MachineType getType(){return type;}
    int getX(){return x;}
    int getY(){return y;}
    void display(){}
    int getWidth(){return type.getWidth();}
    int getHeight(){return type.getHeight();}

}

