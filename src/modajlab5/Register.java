/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modajlab4;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mod
 */
public class Register extends Application {
    
    @Override
   public void start(Stage primaryStage) {
        
        LogIn re=new LogIn();
    
        Pane q=new Pane();
                HBox country=new HBox(10);
                HBox gender=new HBox(20);
                HBox hl=new HBox();
        hl.setSpacing(20);

         GridPane p=new GridPane();
         p.setHgap(20);
         p.setVgap(20);
        
        Label ln=new Label ("Name");
        TextField tn=new TextField();

        
        Label le=new Label ("Email");
        TextField te=new TextField();
        
        Label lp=new Label ("Phone");
        TextField tp=new TextField();

        
        Label lpa=new Label ("Password");
        PasswordField pfpa = new PasswordField();
        
        Label lc=new Label ("Confirm");
        PasswordField pfc = new PasswordField();
        
        
        Label lco=new Label ("Country");
        ComboBox c = new ComboBox();
        c.getItems().addAll("japan","china","italy","france");
        
        Label lge=new Label ("Gender");
        RadioButton rm = new RadioButton("Male");
        RadioButton rf = new RadioButton("Female");
        
        final ToggleGroup group2=new ToggleGroup();
        rm.setToggleGroup(group2);
        rf.setToggleGroup(group2);
        
        
        Label lang=new Label("Language");
        CheckBox ca=new CheckBox ("Arabic"); 
        CheckBox ce=new CheckBox ("English");
        CheckBox cs=new CheckBox ("Spanish");
        GridPane p2=new GridPane();
         
        Label l=new Label("About You");
        TextArea t = new TextArea();t.setPromptText("your biography...");t.setPrefSize(300, 100);
          
        Button b=new Button("Register");b.setPrefWidth(100);
        b.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
        Button b2=new Button("LogIn");b2.setPrefWidth(100);
        b2.setStyle("-fx-background-color:linear-gradient(to right top ,#fdbcb4 ,#a6e7ff 80% )");
        b2.setOnAction(e->{
            try {
                re.start(primaryStage);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
    
        HBox bs=new HBox(270);
        bs.getChildren().addAll(b,b2);
        b.setOnAction(e->{
            boolean upper=pfpa.getText().equals(pfpa.getText().toLowerCase());
            boolean lower=pfpa.getText().equals(pfpa.getText().toUpperCase());
            boolean r=!upper && !lower && !(pfpa.getText().matches("[0-9]*"))&&pfpa.getText().length()>8;
            Label cError1=new Label("select country");
            cError1.setTextFill(Color.RED);
            Label gError1=new Label("enter the gender");
            gError1.setTextFill(Color.RED);
            Label lError1=new Label("enter the language");
            lError1.setTextFill(Color.RED);
            Alert a=new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("gtg");
            int n=0;
        
            if(!(tn.getText().matches("[a-z]+"))){
                tn.setStyle("-fx-border-color:red");
                tn.clear();
                tn.setPromptText("letters only");
                
            }
            
            if(tn.getText().matches("[a-z]+")){
                tn.setStyle("-fx-border-color:green");
                n++;
            }
            
//                p2.addRow(0,NameError);
            if(!(te.getText().contains("@"))&&!(te.getText().contains(".")))
                {
                    te.setStyle("-fx-border-color:red");
                te.clear();
                te.setPromptText("email missing . and @");
                }
            else if(!(te.getText().contains("@"))){
                te.setStyle("-fx-border-color:red");
                te.clear();
                te.setPromptText("email missing @ ");}
            
            else if(!(te.getText().contains(".")))    
            {
               te.setStyle("-fx-border-color:red");
                te.clear();
                te.setPromptText("email missing .");
            } 
            
            if((te.getText().contains("@")))
                if((te.getText().contains("."))){
                te.setStyle("-fx-border-color:green");
                n++;
                }
                
                
            if(!(tp.getText().length()==8)&&!(tp.getText().matches("[0-9]+")))
                {
                    tp.setStyle("-fx-border-color:red");
                tp.clear();
                tp.setPromptText("must be 8 digit and number");
                }

           else if(!(tp.getText().length()==8)){
                tp.setStyle("-fx-border-color:red");
                tp.clear();
                tp.setPromptText("must be 8 digit");
            }
                
           else if(!(tp.getText().matches("[0-9]+")))
               {
                tp.setStyle("-fx-border-color:red");
                tp.clear();
                tp.setPromptText("must be in number");
            }
            if((tp.getText().length()==8))
                if((tp.getText().matches("[0-9]+"))){
                   tp.setStyle("-fx-border-color:green"); 
                   n++;
                }
            
            if(!r){
                pfpa.setStyle("-fx-border-color:red");
                pfpa.clear();
                pfpa.setPromptText("password must have lower,upper letter,number,and more than 8 char");
            }
            if(r){
                pfpa.setStyle("-fx-border-color:green");
                n++;
                }
            
            if((pfpa.getText().equals(pfc.getText()))){
                pfc.setStyle("-fx-border-color:green");
                n++;
                }
            if(!(pfpa.getText().equals(pfc.getText()))){
                pfc.setStyle("-fx-border-color:red");
               pfc.clear();
                pfc.setPromptText("confirm must be the same password");
            }
            if(pfc.getText().isEmpty()){
                pfc.setStyle("-fx-border-color:red");
                pfc.setPromptText("confirm must be the same password");
            }
           
            
            if(c.getSelectionModel().isEmpty())
                 country.getChildren().add(cError1);
            else
                n++;
            c.setOnAction(c1->{ 
                country.getChildren().remove(cError1);
               
            });
            
            if(!((rf.isSelected()||rm.isSelected())))
                gender.getChildren().add(gError1);
            else
                n++;
            rf.setOnAction(gf->{
                gender.getChildren().remove(gError1);
            });
            rm.setOnAction(gm->{ 
                gender.getChildren().remove(gError1);
            });
           if(!(ca.isSelected()||ce.isSelected()||cs.isSelected()))
               hl.getChildren().add(lError1);
           else
                n++;
           ca.setOnAction(c1->{
               hl.getChildren().remove(lError1);
           });
           ce.setOnAction(c1->{
               hl.getChildren().remove(lError1);
           });
           cs.setOnAction(c1->{
               hl.getChildren().remove(lError1);
           });
                
            if(t.getText().length()<50){
               t.setStyle("-fx-border-color:red");
               t.clear();
               t.setPromptText("enter more than 50 charnter more than 50 char");
            }
            if(t.getText().length()>=50){
                t.setStyle("-fx-border-color:green");
                n++;
                }
            if(n==9)
                a.show();
        });
        
       
        
       
        gender.getChildren().addAll(rm,rf);
        
        
        hl.getChildren().addAll(ca,ce,cs);
        
      
        country.getChildren().add(c);
        
        VBox v=new VBox();
        v.setSpacing(10);
        v.setPadding(new Insets(10, 30, 10, 30));
    
       
        p.add(ln, 0, 0);p.add(tn, 1, 0);
        p.add(le, 0, 1);p.add(te, 1, 1);
        p.add(lp, 0, 2);p.add(tp,1 , 2);
        p.add(lpa, 0, 3);p.add(pfpa, 1, 3);
        p.add(lc, 0, 4);p.add(pfc, 1, 4);
       p.add(lco, 0, 5);p.add(country, 1, 5);
        p.add(lge, 0, 6);p.add(gender, 1, 6);
        p.add(lang, 0, 7);p.add(hl, 1,7);
        p.add(l, 0, 8);p.add(t, 1, 8);
        
        
        ImageView image1=new ImageView(new Image("https://i.picsum.photos/id/885/700/700.jpg?hmac=cZB-6NHU-e4-7H0V7IJxZZEuYTZuniyVqvtWAbK0EWs"));

    
    v.setBackground(new Background(new BackgroundImage(image1.getImage(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    v.setAlignment(Pos.CENTER);
        
        v.getChildren().addAll(p,bs);

       
        
        Scene scene = new Scene(v,500,500);
        
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