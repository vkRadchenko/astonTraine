package astonTraine.prototype.shapes;

import astonTraine.prototype.Shape;

import java.util.HashMap;
import java.util.Map;

public class CopyShapesFactory {
    Map<String, Shape> cache = new HashMap<>();

    public CopyShapesFactory() {
        Circle circle = new Circle(400,150,"Red",50);
        Rectangle rectangle = new Rectangle(30,20,"Black",50,30);

        cache.put("Little red circle",circle);
        cache.put("Little black rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }
}
