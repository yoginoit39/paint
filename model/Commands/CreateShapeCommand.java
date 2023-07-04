//package model.Commands;
//
//import model.ShapeList;
//import model.interfaces.ICommand;
//import model.interfaces.IUndoable;
//
//import java.awt.*;
//
//public class CreateShapeCommand implements ICommand, IUndoable {
//
//    private ShapeList shapeList;
//    private Shape shape;
//
//    public CreateShapeCommand(ShapeList shapeList, Shape shape) {
//        this.shapeList = shapeList;
//        this.shape = shape;
//    }
//
//
//
//    @Override
//    public void run() {
//        shapeList.addShape(shape);
//        CommandHistory.add(this);
//
//
//    }
//
//    public void add(){
//        shapeList.addShape(shape);
//    }
//
//    @Override
//    public void undo() {
//        shapeList.removeShape(shape);
//    }
//
//    @Override
//    public void redo() {
//        shapeList.addShape(shape);
//    }
//
//
//
//}
//
//
//


package model.Commands;

import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IUndoable;

import java.awt.Shape;

public class CreateShapeCommand implements ICommand, IUndoable {

    private ShapeList shapeList;
    private Shape shape;

    public CreateShapeCommand(ShapeList shapeList, Shape shape) {
        this.shapeList = shapeList;
        this.shape = shape;
    }

    @Override
    public void run() {
        shapeList.addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void add() {
        shapeList.addShape(shape);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shape);
    }

    @Override
    public void redo() {
        shapeList.addShape(shape);
    }
}
