package src;
import javafx.scene.effect.Effect; 
import javafx.scene.image.Image;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import java.net.URI;
import java.awt.Desktop;

public class GoMeet extends Application implements EventHandler<ActionEvent> {

	//variables . lol
	Stage window;
	Scene scene; Scene scene1; Scene scene2; Scene scene3;
	static boolean abd; static int authUserT; static int numClassT; 
	static String abFileT;
	
	//class info, max 8 classes
	static ArrayList classes = new ArrayList<TextField>();
	static ArrayList time = new ArrayList<TextField>();

	
	public static void main(String[] args) throws IOException, URISyntaxException {
		launch(args);
		/*
		Desktop d = Desktop.getDesktop();
		d.browse(new URI("https://www.google.com/"));
		*/

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.getIcons().add(new Image(this.getClass().getResourceAsStream("gomeet_icon.png")));
		
		Text t = new Text ("goMeet");
		t.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
		
		final ToggleGroup group = new ToggleGroup();
		RadioButton rb1 = new RadioButton("On");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);
		RadioButton rb2 = new RadioButton("Off");
		rb2.setToggleGroup(group);
		
		Button save = new Button("Next");
		save.setOnAction(e -> {
			if (rb1.isSelected()) {
				window.setScene(scene2);
			}
			else if (rb2.isSelected()) {
				window.setScene(scene1);
			}
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(t, rb1, rb2, save);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 400, 600); 
		
		//if user chooses to turn off goMeet
		Label label1 = new Label("goMeet is disabled.");
		Button button1 = new Button("Back");
		button1.setOnAction(e -> window.setScene(scene));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		layout1.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, 400, 600);
		
		
		//if the user chooses to turn on goMeet
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		Label label2 = new Label("goMeet: edit settings");
		
		ToggleButton ab = new ToggleButton("a/b day functionality?");
		TextField authUser = new TextField();
		authUser.setPromptText("authUser =");
		TextField numClass = new TextField();
		numClass.setPromptText("number of classes");
		
		Button button2 = new Button("Cancel");
		button2.setOnAction(e -> window.setScene(scene));
		//need to take info from text boxes
		Button button3 = new Button("Next");
		button3.setOnAction(e -> {
			authUserT = Integer.parseInt(authUser.getText());
			numClassT = Integer.parseInt(numClass.getText());
			abd = ab.isSelected();
			window.setScene(scene3);
		});
		VBox layout2 = new VBox(10);
		layout2.getChildren().addAll(label2, ab, authUser, numClass, button2, button3);
		scene2 = new Scene(layout2, 400, 600);
		
		//asking for details 
		TextField abFile = new TextField();
		abFile.setPromptText("a/b day schedule");
		
		Button button4 = new Button("Back");
		button4.setOnAction(e -> window.setScene(scene2));
		//need to take info from text boxes
		Button button5 = new Button("Save");
		button5.setOnAction(e -> {
			if (abd) {
				abFileT = abFile.getText();
			}
			for (int j = 0; j < numClassT; j++) {
				String time1 = ((TextInputControl) classes.get(j)).getText();
				//call timer
			}
		});
		VBox layout3 = new VBox(10);
		layout3.getChildren().addAll(label2);
		//does not work
		if (abd == true) {
			layout3.getChildren().add(abFile);
		}
		//does not work
		for (int i = 0; i < numClassT; i++) {
			TextField tempC = new TextField();
			tempC.setPromptText("code");
			TextField tempT = new TextField();
			tempT.setPromptText("time (HH:MM) (24-hour time)");
			layout3.getChildren().addAll(tempC, tempT);
			classes.add(tempC);
			time.add(tempT);
		}
		
		layout3.getChildren().addAll(button4, button5);
		layout3.setAlignment(Pos.CENTER);
		scene3 = new Scene(layout3, 400, 600);
		
		window.setTitle("goMeet");
		window.setScene(scene);
		window.show();

	}
}
