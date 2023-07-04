
package view.gui;


import model.ShapeList;

import javax.swing.JComponent;
import java.awt.*;


public class PaintCanvas extends JComponent {

    private ShapeList shapeList;

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        drawRectangle(0, 0, getWidth(), getHeight());

        for (Shape shape : shapeList.getAllShapes()){
            graphics2d.setColor(Color.black);
            graphics2d.fill(shape);
        }

    }

    public void drawRectangle ( int x, int y, int width, int height){
    }
}
