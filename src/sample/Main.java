package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.awt.*;

import static java.awt.Color.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
public class Main extends Application {

    String value;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label text_area=new Label("Enter the value in m (Area) : ");

        TextField input_field=new TextField();

        Button btn_apply = new Button("Apply Changes");

        GridPane root = new GridPane();

        root.addRow(0, text_area, input_field);

        root.addRow(2, btn_apply);

        Scene scene=new Scene(root,600,600);

        btn_apply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                value=input_field.getText().trim();
                drawLayout(Integer.parseInt(value));
            }

            private void drawLayout(int value) {

                Button go_back=new Button("go back");

                go_back.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        primaryStage.setScene(scene);
                    }
                });

                GridPane root = new GridPane();

                //Circle
                Group group = new Group();
                Circle circle = new Circle();
                circle.setCenterX(200);
                circle.setCenterY(200);
                circle.setRadius(value);
                circle.setFill(Color.RED);
                group.getChildren().addAll(circle);

                //Square
                Group group2 = new Group();
                Rectangle rect=new Rectangle();
                rect.setX(200);
                rect.setY(200);
                rect.setWidth(value);
                rect.setHeight(value);
                group2.getChildren().addAll(rect);

                root.addRow(0,group,group2);
                root.addRow(1,go_back);

                Scene scene2=new Scene(root,600,600);
                primaryStage.setScene(scene2);
                primaryStage.setTitle("Graphics");
                primaryStage.show();
            }

        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Graphics Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}