package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Canvas canvas;
    private GraphicsContext graphicsContext;
    private Car car1;
    private Car car2;
    private TrafficLights trafficLights1;
    private TrafficLights trafficLights2;
    private Timeline carmovement;
    private Timeline trafficLightsMode;
    private boolean traffic = true;

    private AnimationTimer animationTimer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsContext = canvas.getGraphicsContext2D();

        car1 = new Car(10,canvas.getHeight() / 2 + 50, 0,0.5,50,30, Paint.valueOf("BLUE"));
        car2 = new Car(canvas.getWidth() - 60,canvas.getHeight() / 2 - 50, 0,-0.5,50,30, Paint.valueOf("RED"));
        trafficLights1 = new TrafficLights(canvas.getWidth() / 2 - 200, canvas.getHeight() / 2 + 200, 50, Paint.valueOf("GREEN"));
        trafficLights2 = new TrafficLights(canvas.getWidth() / 2 + 200, canvas.getHeight() / 2 - 200, 50, Paint.valueOf("GREEN"));

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                draw();
            }
        };
        carmovement = new Timeline(new KeyFrame(
                Duration.millis(1),
                actionEvent -> updateCars()
        ));

        carmovement.setCycleCount(Animation.INDEFINITE);

        trafficLightsMode = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> changeTrafficLight()));

        trafficLightsMode.setCycleCount(Animation.INDEFINITE);
        startApp();

    }

    private void startApp(){
        animationTimer.start();
        carmovement.play();
        trafficLightsMode.play();
    }


    private void draw(){

        graphicsContext.setFill(Paint.valueOf("LIGHTGREEN"));
        graphicsContext.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        drawRoad(0, canvas.getHeight() / 2 - 100, canvas.getWidth(), 240);
        drawTraffic(trafficLights1);
        drawTraffic(trafficLights2);
        drawCars(car1);
        drawCars(car2);

    }

    private void drawTraffic(TrafficLights trafficLights){

        graphicsContext.setFill(trafficLights.getColor());
        graphicsContext.fillOval(trafficLights.getX(), trafficLights.getY(), trafficLights.getRadius(), trafficLights.getRadius());

    }

    private void drawRoad(double x, double y, double width, double height){

        graphicsContext.setFill(Paint.valueOf("BLACK"));
        graphicsContext.fillRect(x,y,width,height);

    }

    private void drawCars(Car car){
        graphicsContext.setFill(car.getColor());
        graphicsContext.fillRect(car.getX(), car.getY(), car.getWidth(), car.getHeight());
    }

    private void updateCars(){
        if(!(trafficLights1.getColor() == Paint.valueOf("RED") && car1.getX() > trafficLights1.getX() -70 && car1.getX() + car1.getWidth() < trafficLights1.getX())){
            car1.update();
        }
        if(!(trafficLights2.getColor() == Paint.valueOf("RED") && car2.getX() < trafficLights2.getX() + 70 && car2.getX() + car2.getWidth() > trafficLights2.getX())){
            car2.update();
        }

        if(car1.getX() > canvas.getWidth()){
            car1.setX(-car1.getWidth() * 2);
        }

        if(car2.getX() + car2.getWidth() < 0){
            car2.setX(canvas.getWidth() + car2.getWidth());
        }

    }

    private void changeTrafficLight(){
        traffic = !traffic;
        System.out.println(traffic);
        if(traffic){
            trafficLights1.setColor(Paint.valueOf("GREEN"));
            trafficLights2.setColor(Paint.valueOf("GREEN"));
            return;
        }
        trafficLights1.setColor(Paint.valueOf("RED"));
        trafficLights2.setColor(Paint.valueOf("RED"));

    }
}
