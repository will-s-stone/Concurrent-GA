package src.main.lib;

public enum MachineType {
    M1(10,10),
    M2(10,20),
    M3(25, 25),
    M4(15, 20);

    private final int width;
    private final int height;


    MachineType(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
