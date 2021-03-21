package src;
import javafx.scene.effect.Effect; 
import javafx.scene.image.Image;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URI;
import java.awt.Desktop;

public class GoMeet extends Application implements EventHandler<ActionEvent> {

	Stage window;
	Scene scene; Scene scene1; Scene scene2;

	public static void main(String[] args) throws IOException, URISyntaxException {
		launch(args);
		Desktop d = Desktop.getDesktop();
		d.browse(new URI("https://www.google.com/"));

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.getIcons().add(new Image(this.getClass().getResourceAsStream("gomeet_icon.png")));
		
		Label label = new Label("lets fuck bears.");
		
		Button button = new Button("fuck a bear");
		button.setOnAction(e -> window.setScene(scene1));
		VBox layout = new VBox(20);
		RadioButton rb = new RadioButton("on");
		
		layout.getChildren().addAll(label, button, rb);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 200, 200); 
		
		Label label1 = new Label("the bear is curious.");
		Button button1 = new Button("fuck a bear again");
		button1.setOnAction(e -> window.setScene(scene2));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		layout1.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, 200, 200);
		
		Label label2 = new Label("the bear liked it.");
		Button button2 = new Button("fuck the bear again again");
		Label label3 = new Label("don't wanna fuck the bear?");
		Button button3 = new Button("fine.");
		button2.setOnAction(e -> window.setScene(scene));
		button3.setOnAction(e -> Popup.display("try again", "why....."));
		VBox layout2 = new VBox(10);
		layout2.getChildren().addAll(label2, button2, label3, button3);
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 200, 200);
		
		window.setTitle("goMeet");
		window.setScene(scene);
		window.show();

	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
