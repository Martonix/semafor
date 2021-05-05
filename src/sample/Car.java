package sample;

import javafx.scene.paint.Paint;

public class Car {

    private double x;
    private double y;
    private double dy;
    private double dx;
    private double width;
    private double height;
    private Paint color;

    public Car(double x, double y, double dy, double dx, double width, double height, Paint color) {
        this.x = x;
        this.y = y;
        this.dy = dy;
        this.dx = dx;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void update(){
        x += dx;
        y += dy;

    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }
}


