/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modajlab4;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class hw2 extends Application {
    
    @Override
   public void start(Stage primaryStage) {
        Pane q=new Pane();
        
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
        
        Label lang=new Label("Language");
        CheckBox ca=new CheckBox ("Arabic"); 
        CheckBox ce=new CheckBox ("English");
        CheckBox cs=new CheckBox ("Spanish");
        GridPane p2=new GridPane();
         
        Label l=new Label("About You");
        TextArea t = new TextArea();t.setPromptText("your biography...");t.setPrefSize(300, 100);
          
        Button b=new Button("Register");b.setPrefWidth(400);
        
        b.setOnAction(e ->{
            boolean upper=pfpa.getText().equals(pfpa.getText().toLowerCase());
            boolean lower=pfpa.getText().equals(pfpa.getText().toUpperCase());
            boolean r=!upper && !lower && !(pfpa.getText().matches("[0-9]*"))&&pfpa.getText().length()>8;
            Label PhonError=new Label("invalid number;Phone must be 8 digit");
            PhonError.setTextFill(Color.RED);
            Label PhonError2=new Label("invalid number;Phone must be in number");
            PhonError2.setTextFill(Color.RED);
            Label NameError=new Label("invalid name;name must be in letters only");
            NameError.setTextFill(Color.RED);
            Label EmalError1=new Label("invalid email;email missing @");
            EmalError1.setTextFill(Color.RED);
            Label EmalError2=new Label("invalid email;email missing .");
            EmalError2.setTextFill(Color.RED);
            Label passError1=new Label("invalid password;password must have lower,upper letter,number,and more than 8 char");
            passError1.setTextFill(Color.RED);
            Label CpassError1=new Label("invalid password;confirm must be the same password");
            CpassError1.setTextFill(Color.RED);
            Label cError1=new Label("invalid select;you must select country");
            cError1.setTextFill(Color.RED);
            Label tError1=new Label("invalid about u;you must enter more than 50 char");
            tError1.setTextFill(Color.RED);
            Alert a=new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("gtg");
            
            
            if(!(tn.getText().matches("[a-z]+")))
                p2.addRow(0,NameError);
            if(!(te.getText().contains("@")))
                p2.addRow(1, EmalError1);
            if(!(te.getText().contains(".")))
                p2.addRow(2, EmalError2);
            if(!(tp.getText().length()==8))
                p2.addRow(3,PhonError);
            if(!(tp.getText().matches("[0-9]+")))
            p2.addRow(4,PhonError2);
            if(!r)
            p2.addRow(5,passError1);
            if(!(pfpa.getText().equals(pfc.getText())))
            p2.addRow(6,CpassError1 );
            if(c.getSelectionModel().isEmpty())
                p2.addRow(7, cError1);
            if(t.getText().length()<50)
                p2.addRow(8, tError1);
            else
                a.show();
        });
        
        GridPane p=new GridPane();
         p.setHgap(20);
         p.setVgap(20);
        
        
        HBox hg=new HBox();
        hg.setSpacing(20);
        hg.getChildren().addAll(rm,rf);
        
        HBox hl=new HBox();
        hl.setSpacing(20);
        hl.getChildren().addAll(ca,ce,cs);
        
      
        
        
        
        VBox v=new VBox();
        v.setSpacing(10);
        v.setPadding(new Insets(10, 30, 10, 30));
    
       
        p.add(ln, 0, 0);p.add(tn, 1, 0);
        p.add(le, 0, 1);p.add(te, 1, 1);
        p.add(lp, 0, 2);p.add(tp,1 , 2);
        p.add(lpa, 0, 3);p.add(pfpa, 1, 3);
        p.add(lc, 0, 4);p.add(pfc, 1, 4);
        p.add(lco, 0, 5);p.add(c, 1, 5);
        p.add(lge, 0, 6);p.add(hg, 1, 6);
        p.add(lang, 0, 7);p.add(hl, 1,7);
        p.add(l, 0, 8);p.add(t, 1, 8);
        
        
        v.getChildren().addAll(p,b,p2);

       
        
        Scene scene = new Scene(v,450,700);
        
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