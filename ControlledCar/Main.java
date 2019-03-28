package application;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public void start(Stage theStage) 
    {
        theStage.setTitle( "Animation" );
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        Canvas canvas = new Canvas( 800, 380);
        root.getChildren().add( canvas );
        ArrayList<String> input = new ArrayList<String>();
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString(); 
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });
        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });
         GraphicsContext gc = canvas.getGraphicsContext2D();
         Image road = new Image( "Road.jpg" );      
         Image car = new Image("Car.jpg");
                         
         final long startTime = System.nanoTime();
        new AnimationTimer()
        {
        	double z = 0; 
        	double y = 220;
            public void handle(long currentNanoTime)
            {
                if (input.contains("LEFT")) {
                     y = y - 8;
                }
                if (input.contains("RIGHT")) {
                	y = y + 8;
                }       
                double diff = (currentNanoTime - startTime) / 1000000000.0;
           	 double x1 = x2 - diff * 200;
           	  gc.drawImage( road, x, 0);
           	
               if ( x <= -200) {
           	 z = z + 200;

               }         
               gc.drawImage( car, 20, y);
            }
        }.start();
        theStage.show();
    }
	public static void main(String[] args)
    {
        launch(args);
    }
}