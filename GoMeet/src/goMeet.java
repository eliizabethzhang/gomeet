import javafx.scene.effect.Effect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class goMeet extends Application implements EventHandler<ActionEvent> {

	Button button;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("goMeet");
		button = new Button("fuck a bear");

		button.setOnAction(e -> System.out.println("bear fucked"));

		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		Scene scene = new Scene(layout, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
