/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modajlab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mod
 */
public class LogIn extends Application {
    Text ctc(){ 
 
    Text t1=new Text("Username");
    t1.setFont(Font.font("Yu Gothic UI Semibold", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 23));
    t1.setStyle("-fx-fill:linear-gradient(#a4ae1d ,#a6e7ff )");
  
  
    return t1;
    
}
 
 
Text ctc2(){ 
 
    Text t1=new Text("Password");
    t1.setFont(Font.font("Yu Gothic UI Semibold", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 23));
    t1.setStyle("-fx-fill:linear-gradient(#a4ae1d ,#a6e7ff )");
  
  
    return t1;
    
}
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        homeScreen hs=new homeScreen();
        Register re=new Register();
        
       // "C:\\Users\\User\\Documents\\NetBeansProjects\\JavaFXApplication6\\New folder (2)"+slide.get(0)+".jpg";
        
   /* InputStream in =new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\ajlec1\\fe.jpg");
    ImageView image1= new ImageView(new Image(in));*/
     
     ImageView image1=new ImageView(new Image("https://i.picsum.photos/id/787/1920/1920.jpg?hmac=2xClFUxTZ_8OEBBm_PHNwQwq7D0IY0jVdGiD5A7b1Ek"));
    // image1.setFitHeight(192);
     //image1.setX(123);
     //image1.setFitWidth(108);
     
    GridPane p=new GridPane();
    p.setBackground(new Background(new BackgroundImage(image1.getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    p.setAlignment(Pos.CENTER);
   
    p.setHgap(5);
    p.setVgap(5);
      
      
    ImageView image2=new ImageView(new Image("https://i.picsum.photos/id/420/200/200.jpg?hmac=7hdmWb4uHh3ulb7_b_NXZ6QZY_mpCdVcwji4oMqP1Eg"));
    image2.setFitHeight(200);
    image2.setFitWidth(200);
     
    Label ln=new Label("", image2);
    ln.setContentDisplay(ContentDisplay.TOP);
    //ln.setStyle("-fx-fill:linear-gradient(#B22222,#a6e7ff )");
       
    Button btn = new Button();
    btn.setText("LogIn");
    btn.setContentDisplay(ContentDisplay.RIGHT);
    btn.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
    btn.setPrefSize(100, 0);
    
    Button b=new Button();
    b.setText("Home");
    b.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
    b.setOnAction(e->{
        hs.start(primaryStage);
    });
    
    Button b2=new Button();
    b2.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
    b2.setText("Sign up");
    b2.setOnAction(e->{
        re.start(primaryStage);
    });
    
    HBox control =new HBox(90);
    control.getChildren().addAll(b,b2);
    
    
    TextField txt = new TextField("");
  
    PasswordField txt2=new PasswordField();
    
    CheckBox cb = new CheckBox("Remember me");
    CheckBox cb2 = new CheckBox("Home");
    CheckBox cb3 = new CheckBox("Sign in");
  btn.setOnAction(e->{
 
   int n=0;        
            try {
                File fr=new File("users.txt");
           
            Scanner input = new Scanner(fr);
            
               input.nextLine();
                input.nextLine(); 
       while(input.hasNext()){
           
           if(input.next().equals(txt.getText())){
                
                   
                   if(input.next().equals(txt2.getText())){
                       Alert a1=new Alert(Alert.AlertType.INFORMATION);
                       a1.setContentText("good one ");
                       a1.show();
                       break;
                   }
                   else{
                       Alert a1=new Alert(Alert.AlertType.WARNING);
                       a1.setContentText("incorrect password");
                       a1.show();
                       break;
                   }
             
           }
           else{
               if(input.next().equals(txt2.getText())){
                       Alert a1=new Alert(Alert.AlertType.WARNING);
                       a1.setContentText("incorrect username ");
                       a1.show();
                       break;
                   }
                   
           }
           
               
       
               
           
           
       } 
             input.close();
    }       catch (FileNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
  });
    p.add(ln, 2, 0,1,1);
    p.add(control, 2, 1);
   
    p.add(ctc(), 1, 11);
    p.add(ctc2(), 1, 12);
    p.add(txt, 2,11);
    p.add(txt2, 2,12);
    p.add(btn, 3, 13);
    p.add(cb,1,13);
    //p.add(b, 1, 15);
    
    
   // p.getChildren().add(ln);
    //p.getChildren().addAll(txt,txt2,ln,ln2);
   // p.getChildren().addAll(ln,txt);
      
      
      
      Scene scene = new Scene(p, 400, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
