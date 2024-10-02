package src.main.lib;

public enum MachineType {
    M1(100,100),
    M2(100,200),
    M3(250, 250),
    M4(150, 200);

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
