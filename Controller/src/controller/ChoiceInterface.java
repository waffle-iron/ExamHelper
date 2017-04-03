/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author liambarry
 */
public class ChoiceInterface extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Choice Interface");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        
        Text scenetitle = new Text("Please Choose an Option");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Label userName = new Label("User Name:");
        //grid.add(userName, 0, 1);

        //TextField userTextField = new TextField();
        //grid.add(userTextField, 1, 1);

        //Label pw = new Label("Password:");
        //grid.add(pw, 0, 2);

        //PasswordField pwBox = new PasswordField();
        //grid.add(pwBox, 1, 2);
        
        Button btn = new Button("Export Exam");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        Button btn2 = new Button("Import Questions");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 0, 4);
        
        Button btn3 = new Button("Log out");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid.add(hbBtn3, 2, 4);

        primaryStage.show();
  
        btn.setOnAction((ActionEvent e) -> {
            System.out.println("clicked");
        });
        
        btn2.setOnAction((ActionEvent e) -> {
            System.out.println("clicked");
        });
        
        btn3.setOnAction((ActionEvent e) -> {
            System.out.println("clicked");
        });
    }
    
    //public static String nextScreen(String screen){
        
    //}

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
