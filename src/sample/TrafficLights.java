package sample;

import javafx.scene.paint.Paint;

public class TrafficLights {

    private double x;
    private double y;
    private double radius;
    private Paint color;

    public TrafficLights(double x, double y, double radius, Paint color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }
}
