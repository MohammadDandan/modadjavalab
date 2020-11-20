/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modajlab2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mod
 */
public class modajlab2 extends Application {
    Text ctc(){ 
 
    Text t1=new Text(21, 32,"what will happen now?");
    t1.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 32));
    t1.setFill(Color.PURPLE);
  
  
    return t1;
    
}
    public void start(Stage primaryStage) throws FileNotFoundException {
        InputStream in =new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\AJL32021-\\modajlab\\ne.png");
     ImageView image1= new ImageView(new Image(in));
     image1.setX(900);
     image1.setY(800);
     image1.setFitWidth(600);
     image1.setFitHeight(600);
     image1.setPreserveRatio(true);
     
     
     InputStream in1=new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\AJL32021-\\modajlab\\ve.jpg");
     ImageView image2= new ImageView(new Image(in1));
     image2.setX(300);
     image2.setY(400);
     image2.setFitWidth(600);
     image2.setFitHeight(590);
     image2.setPreserveRatio(true);
     
     
     
     
          Circle c=new Circle(20);
     
     c.setStyle("-fx-fill:linear-gradient(#B22222,#a6e7ff );-fx-stroke:linear-gradient(#39FF14,#C724B1) ");
     
      VBox v1=new VBox();
      v1.setPadding(new Insets(10));
      v1.setStyle("-fx-background-color:linear-gradient(to right top ,#228B22 ,#fdbcb4 ,#a6e7ff 80% )");
      v1.setAlignment(Pos.CENTER);
      v1.getChildren().add(ctc());
      
      HBox h1 =new HBox();
      h1.setPadding( new Insets(20));
      h1.setAlignment(Pos.CENTER_LEFT);
      h1.setSpacing(20);
      h1.getChildren().add(image1);
      
      HBox h2 =new HBox();
      h2.setPadding( new Insets(20));
      h2.setAlignment(Pos.CENTER_RIGHT);
      h2.setSpacing(20);
      h2.getChildren().add(image2);
      
      v1.getChildren().add(h1);
      v1.getChildren().add(h2);
      v1.getChildren().add(c);
      
        Scene scene = new Scene(v1, 1920, 1080);

        primaryStage.setTitle("project");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
       // Scene scene = new Scene(root, 300, 250);
        
       /* primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
