import javafx.scene.effect.Effect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//fuck fuck fuck fuck fuck fuc kuf kc ufkcu fkcu kfu fk
public class goMeet extends Application {
	
	Button button;

	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("goMeet");
		button = new Button("Get Started");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 900, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
