package model.Commands;



import model.Point;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class ClickHandler extends MouseAdapter {
    private Point startPoint = new Point();
    private Point endPoint = new Point();
    private PaintCanvas canvas; // reference to paintCanvas object
  private ShapeList shapeList;


    public ClickHandler(PaintCanvas canvas, ShapeList shapeList, ApplicationState appState) {
        this.canvas = canvas;
        this.shapeList = shapeList;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint.setX(e.getX());
        startPoint.setY(e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {


        endPoint.setX(e.getX());
        endPoint.setY(e.getY());

        int x = Math.min(startPoint.getX(), endPoint.getX());
        int y = Math.min(startPoint.getY(), endPoint.getY());
        int width = Math.abs(startPoint.getX() - endPoint.getX());
        int height = Math.abs(startPoint.getY() - endPoint.getY());


        Shape shape = new Rectangle(x,y, width, height);
        shapeList.addShape(shape);
        canvas.repaint();

    }



}





