/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modajlab4;

import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mod
 */
public class homeScreen extends Application {
     ImageView[] iv = new ImageView[25];
    int x = 0;
    Graphics2D d;
     MediaPlayer MediaPlayer;
   
    
    @Override
   public void start(Stage stage) {
       LogIn in=new LogIn();
       Register re=new Register();
       String s="C:\\Users\\User\\Desktop\\hl.mp3";
        Media h=new Media(Paths.get(s).toUri().toString());
        MediaPlayer n =new MediaPlayer(h);
        n.setStartTime(Duration.seconds(4));
        n.setStopTime(Duration.minutes(5));
        n.isAutoPlay();
        n.play();
        Line l=new Line(0,530,680,530);
//        Line l2=new Line(680,530,0,530);
        ImageView img=new ImageView(new Image("file:///C:\\Users\\User\\Documents\\NetBeansProjects\\modajlab\\New folder\\car.png") );

        img.setTranslateX(0);
        
//        ImageView img1=new ImageView(new Image("file:///C:\\Users\\User\\Documents\\NetBeansProjects\\modajlab\\New folder\\slide0.jpg") );

        PathTransition pt = new PathTransition();
        
pt.setDuration(Duration.millis(6000));
pt.setPath(l);
pt.setNode(img);
pt.setCycleCount(Timeline.INDEFINITE);


  pt.play();
  
  
  Button SignIn=new Button("SignIn");
  
  SignIn.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
  SignIn.setOnAction(e->{
      n.stop();
           try {
               in.start(stage);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(homeScreen.class.getName()).log(Level.SEVERE, null, ex);
           }
  
  });
  SignIn.setTranslateX(200);
  SignIn.setTranslateY(300);
  
  
   Button SignUp=new Button("SignUp");
    SignUp.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
   SignUp.setOnAction(e->{
       n.stop();
       re.start(stage);
       
   });
   SignUp.setTranslateX(350);
  SignUp.setTranslateY(300);
        Pane pane = new Pane();

        for (int i = 0; i < 25; i++) {
            iv[i] = new ImageView(new Image("file:///C:\\Users\\User\\Documents\\NetBeansProjects\\modajlab\\New folder\\slide" + i + ".jpg"));
            iv[i].setFitWidth(600);
            iv[i].setFitHeight(600);

        }

        pane.getChildren().addAll(iv[x],img,SignIn,SignUp);
        

        EventHandler<ActionEvent> eventHandler = e -> {
            if (x < 9) {
                // Adding Children
                pane.getChildren().removeAll(iv[x],img,SignIn,SignUp);
                x++;
                pane.getChildren().addAll(iv[x],img,SignIn,SignUp);
                
            }
            else if (x == 9) {
                x = 0;
                pane.getChildren().removeAll(iv[10],img,SignIn,SignUp);
                pane.getChildren().addAll(iv[x],img,SignIn,SignUp);
                
            }
        };

        // Timeline Animation
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(3000), eventHandler));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        pane.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED) {
                animation.play();
            } else {
                animation.pause();
            }
        });
        
        
        

        Scene scene = new Scene(pane, 600, 600);

        stage.setScene(scene);
        stage.setTitle("Slide Show");
        stage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
