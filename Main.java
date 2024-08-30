package astonTraine;

import astonTraine.prototype.Shape;
import astonTraine.prototype.shapes.Circle;
import astonTraine.prototype.shapes.CopyShapesFactory;
import astonTraine.prototype.shapes.Rectangle;

public class Main {
    public static void main(String[] args) {
        checkingPrototypePattern();
    }
    public static void checkingPrototypePattern(){

        Circle circle = new Circle(10,20,"Green",50);
        Circle cloneCircle = (Circle) circle.clone();
        Rectangle rectangle = new Rectangle(30,20,"Black",50,30);
        Rectangle cloneRectangle = (Rectangle) rectangle.clone();

        CopyShapesFactory copyShapesFactory = new CopyShapesFactory();
        Shape shape1 = copyShapesFactory.get("Little red circle");
        Shape shape2 = copyShapesFactory.get("Little red circle");
        Shape shape3 = copyShapesFactory.get("Little black rectangle");
        Shape shape4 = copyShapesFactory.get("Little black rectangle");

        System.out.println();
        System.out.println("Circle identical: " + circle.equals(cloneCircle));
        System.out.println("rectangle identical: " + rectangle.equals(cloneRectangle));
        System.out.println("===========================");
        System.out.println("Factory");

        System.out.println("Shape identical: " + shape1.equals(shape2));
        System.out.println("Shape identical: " + shape3.equals(shape4));
        System.out.println("Shape identical: " + shape1.equals(shape4));
    }
}
