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
	static int authUserT; 
	static String abFileT = "https://www.wcpss.net//site/handlers/icalfeed.ashx?MIID=1359";
	
	//class info, max 8 classes
/*	static ArrayList classes = new ArrayList<TextField>();
	static ArrayList time = new ArrayList<TextField>();
*/
	static String code1; static String t1;
	static String code2; static String t2;
	static String code3; static String t3;
	static String code4; static String t4;
	static String code5; static String t5;
	static String code6; static String t6;
	static String code7; static String t7;
	static String code8; static String t8;
	
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
		Text label1 = new Text ("goMeet is disabled");
		label1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		Button button1 = new Button("Back");
		button1.setOnAction(e -> window.setScene(scene));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		layout1.setAlignment(Pos.CENTER);
		scene1 = new Scene(layout1, 400, 600);
		
		
		//if the user chooses to turn on goMeet
		Text label2 = new Text ("goMeet: edit settings");
		label2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		Label aU = new Label("authUser=");
		
		//finding which account to use
		TextField authUser = new TextField();
		authUser.setPromptText("authUser =");
		authUser.setMaxWidth(30);
		HBox aUFormat = new HBox();
		aUFormat.getChildren().addAll(aU, authUser);
		aUFormat.setAlignment(Pos.CENTER);
		
		Button button2 = new Button("Cancel");
		button2.setOnAction(e -> window.setScene(scene));
		Button button3 = new Button("Next");
		button3.setOnAction(e -> {
			if (authUser.getText().contentEquals("")) {
				Popup.display("Please specify which account to use.");
			}
			authUserT = Integer.parseInt(authUser.getText());
			window.setScene(scene3);
		});
		VBox layout2 = new VBox(10);
		layout2.getChildren().addAll(label2, aUFormat, button2, button3);
		layout2.setAlignment(Pos.CENTER);
		scene2 = new Scene(layout2, 400, 600);
		
		//new page asking for details about schedule
		Label abs = new Label("a/b day schedule link");
		TextField abFile = new TextField("https://www.wcpss.net//site/handlers/icalfeed.ashx?MIID=1359");
		abFile.setPromptText("link");
		abFile.setMaxWidth(300);
		
		VBox vbForTextField = new VBox();
		
		//class labels
		Label c1 = new Label("Class 1");
		TextField sched1 = new TextField();
		sched1.setPromptText("class 1 code");
		TextField time1 = new TextField();
		time1.setPromptText("time in HH:MM 24-hr");
		sched1.setMaxWidth(150);
		time1.setMaxWidth(150);
		vbForTextField.getChildren().addAll(c1, sched1, time1);
		//sched1.setAlignment(Pos.CENTER);
		//time1.setAlignment(Pos.CENTER);
		
		Label c2 = new Label("Class 2");
		TextField sched2 = new TextField();
		sched2.setPromptText("class 2 code");
		TextField time2 = new TextField();
		time2.setPromptText("time in HH:MM 24-hr");
		sched2.setMaxWidth(150);
		time2.setMaxWidth(150);
		vbForTextField.getChildren().addAll(c2, sched2, time2);
		
		Label c3 = new Label("Class 3");
		TextField sched3 = new TextField();
		sched3.setPromptText("class 3 code");
		TextField time3 = new TextField();
		time3.setPromptText("time in HH:MM 24-hr");
		sched3.setMaxWidth(150);
		time3.setMaxWidth(150);
		vbForTextField.getChildren().addAll(c3, sched3, time3);
		
		Label c4 = new Label("Class 4");
		TextField sched4 = new TextField();
		sched4.setPromptText("class 4 code");
		TextField time4 = new TextField();
		time4.setPromptText("time in HH:MM 24-hr");
		sched4.setMaxWidth(150);
		time4.setMaxWidth(150);
		vbForTextField.getChildren().addAll(c4, sched4, time4);
		vbForTextField.setAlignment(Pos.CENTER);
		
		VBox vbForTextField2 = new VBox();
		
		//class labels
		Label c5 = new Label("Class 5");
		TextField sched5 = new TextField();
		sched5.setPromptText("class 5 code");
		TextField time5 = new TextField();
		time5.setPromptText("time in HH:MM 24-hr");
		sched5.setMaxWidth(150);
		time5.setMaxWidth(150);
		vbForTextField2.getChildren().addAll(c5, sched5, time5);
		
		Label c6 = new Label("Class 6");
		TextField sched6 = new TextField();
		sched6.setPromptText("class 6 code");
		TextField time6 = new TextField();
		time6.setPromptText("time in HH:MM 24-hr");
		sched6.setMaxWidth(150);
		time6.setMaxWidth(150);
		vbForTextField2.getChildren().addAll(c6, sched6, time6);
		
		Label c7 = new Label("Class 7");
		TextField sched7 = new TextField();
		sched7.setPromptText("class 7 code");
		TextField time7 = new TextField();
		time7.setPromptText("time in HH:MM 24-hr");
		sched7.setMaxWidth(150);
		time7.setMaxWidth(150);
		vbForTextField2.getChildren().addAll(c7, sched7, time7);
		
		Label c8 = new Label("Class 8");
		TextField sched8 = new TextField();
		sched8.setPromptText("class 8 code");
		TextField time8 = new TextField();
		time8.setPromptText("time in HH:MM 24-hr");
		sched8.setMaxWidth(150);
		time8.setMaxWidth(150);
		vbForTextField2.getChildren().addAll(c8, sched8, time8);
		vbForTextField2.setAlignment(Pos.CENTER);
		
		HBox format = new HBox();
		format.getChildren().addAll(vbForTextField, vbForTextField2);
		format.setAlignment(Pos.CENTER);
		
		Button button4 = new Button("Back");
		button4.setOnAction(e -> window.setScene(scene2));
		//need to take info from text boxes
		Button button5 = new Button("Save");
		button5.setOnAction(e -> {
			if (abFile.getText().contentEquals("")) {
				Popup.display("Please enter an A/B day schedule.");
			}
			abFileT = abFile.getText();
			//get info from textfield, store it
			code1 = sched1.getText();
			t1 = time1.getText();
			code2 = sched2.getText();
			t2 = time2.getText();
			code3 = sched3.getText();
			t3 = time3.getText();
			code4 = sched4.getText();
			t4 = time4.getText();
			code5 = sched5.getText();
			t5 = time5.getText();
			code6 = sched6.getText();
			t6 = time6.getText();
			code7 = sched7.getText();
			t7 = time7.getText();
			code8 = sched8.getText();
			t8 = time8.getText();
			//call timer
			});
		VBox layout3 = new VBox(10);
		layout3.getChildren().addAll(label2);
		layout3.getChildren().addAll(abs, abFile);
		layout3.getChildren().addAll(format);
		layout3.getChildren().addAll(button4, button5);
		layout3.setAlignment(Pos.CENTER);
		scene3 = new Scene(layout3, 400, 600);
		
		window.setTitle("goMeet");
		window.setScene(scene);
		window.show();

	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
