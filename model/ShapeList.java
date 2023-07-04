package model;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class ShapeList {
    private List<Shape> shapes;

    public ShapeList() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        System.out.println("ShapeList: " + shapes.size());
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);

    }

    public List<Shape> getAllShapes() {
        return new ArrayList<>(shapes);
    }


}
