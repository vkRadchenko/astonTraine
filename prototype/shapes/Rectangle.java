package astonTraine.prototype.shapes;

import astonTraine.prototype.Shape;

public class Rectangle extends Shape {

    private int width;
    private int height;


    public Rectangle(int x, int y, String color, int width, int height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(getX(),getY(),getColor(), width,height);
    }

    @Override
    public boolean equals(Object obj2) {
        if (!(obj2 instanceof Rectangle) || !super.equals(obj2)) return false;
        Rectangle shape2 = (Rectangle) obj2;
        return shape2.width == width && shape2.height == height;
    }
}
