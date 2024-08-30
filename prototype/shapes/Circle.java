package astonTraine.prototype.shapes;

import astonTraine.prototype.Shape;

public class Circle extends Shape {
    public int radius;

    public Circle(int x, int y, String color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(getX(),getY(),getColor(),radius);
    }

    @Override
    public boolean equals(Object obj2) {
        if (!(obj2 instanceof Circle) || !super.equals(obj2)) return false;
        Circle shape2 = (Circle) obj2;
        return shape2.radius == radius;
    }

}
