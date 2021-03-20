import javafx.scene.effect.Effect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class goMeet extends Application implements EventHandler<ActionEvent> {

	Stage window;
	Scene scene; Scene scene1; Scene scene2;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		Label label = new Label("lets fuck bears.");
		Button button = new Button("fuck a bear");
		button.setOnAction(e -> window.setScene(scene1));
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, button);
		scene = new Scene(layout, 400, 300); 
		
		Label label1 = new Label("the bear is curious.");
		Button button1 = new Button("fuck a bear again");
		button1.setOnAction(e -> window.setScene(scene2));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 200, 200);
		
		Label label2 = new Label("the bear liked it. fuck it again");
		Button button2 = new Button("the bear liked it. fuck the bear again again");
		button2.setOnAction(e -> window.setScene(scene));
		HBox layout2 = new HBox(40);
		layout2.getChildren().addAll(label2, button2);
		scene2 = new Scene(layout2, 400, 200);
		
		window.setTitle("goMeet");
		window.setScene(scene);
		window.show();

	}
}
