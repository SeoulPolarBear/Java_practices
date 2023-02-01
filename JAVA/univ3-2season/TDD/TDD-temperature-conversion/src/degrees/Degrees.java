package degrees;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class Degrees extends Application 
{
	
	private RadioButton cmdCelFrom = new RadioButton("Celsius");
	private RadioButton cmdFahFrom = new RadioButton("Fahrenheit");
	private RadioButton cmdKelFrom = new RadioButton("Kelvin");
	 private RadioButton cmdCelTo = new RadioButton("Celsius");
	 private RadioButton cmdFahTo = new RadioButton("Fahrenheit");
	private RadioButton cmdKelTo = new RadioButton("Kelvin");
	private TextField txtValue = new TextField();
	private TextField txtResult = new TextField();
	private models.Converter converter = new models.Converter();
	
	@Override
	public void start(Stage primaryStage) {
	Button cmdClear = new Button("Clear");
	cmdClear.setOnAction(new EventHandler<ActionEvent>() {
	
		@Override
	public void handle(ActionEvent event) {
	txtValue.clear();
	txtResult.clear();
	}
	});
	
	Button cmdCalc = new Button("Calculate");
	cmdCalc.setOnAction(new EventHandler<ActionEvent>() {
	
		@Override
	public void handle(ActionEvent event) {
	try
	{
	 double value = Double.parseDouble(txtValue.getText().trim());
	if (cmdCelFrom.isSelected())
	{
	if (cmdFahTo.isSelected()) txtResult.setText(String.format("%1.1f", converter.ctof(value)));
	
	else if (cmdKelTo.isSelected()) txtResult.setText(String.format("%1.1f"
	, converter.ctok(value)));
	
	else txtResult.setText(String.format("%1.1f", value));
	}
	
	else if (cmdFahFrom.isSelected())
	{

if (cmdCelTo.isSelected()) txtResult.setText(String.format("%1.1f", converter.ftoc(value)));
	
else if (cmdKelTo.isSelected()) txtResult.setText(String.format("%1.1f"
	, converter.ftok(value)));
	
else txtResult.setText(String.format("%1.1f", value));
	}
	
	else
	{
	
		if (cmdCelTo.isSelected()) txtResult.setText(String.format("%1.1f", converter.ktoc(value)));
	else if (cmdFahTo.isSelected()) txtResult.setText(String.format("%1.1f"
	, converter.ktof(value)));
	
	else txtResult.setText(String.format("%1.1f", value));
	}
}
	catch (Exception ex)
	{
	 Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Error");
	alert.setHeaderText("Error when converting degrees");
	 alert.setContentText(ex.getMessage());
	
	 alert.showAndWait();
	}
	}
});
	 ToggleGroup group1 = new ToggleGroup();
	 cmdCelFrom.setToggleGroup(group1);
	cmdFahFrom.setToggleGroup(group1);
 cmdKelFrom.setToggleGroup(group1);
	cmdCelFrom.setSelected(true);
	ToggleGroup group2 = new ToggleGroup();
	cmdCelTo.setToggleGroup(group2);
	cmdFahTo.setToggleGroup(group2);
	cmdKelTo.setToggleGroup(group2);
	cmdFahTo.setSelected(true);
	txtResult.setEditable(false);
	GridPane root = new GridPane();
	root.setPadding(new Insets(20, 20, 20, 20));
	root.setHgap(20);
	root.setVgap(10);
	root.add(new Label("From"), 0, 0);
	root.add(new Label("To"), 1, 0);
	root.add(txtValue, 0, 1);
	root.add(txtResult, 1, 1);
	root.add(cmdCelFrom, 0, 2);
	root.add(cmdCelTo, 1, 2);
	root.add(cmdFahFrom, 0, 3);
	root.add(cmdFahTo, 1, 3);
	root.add(cmdKelFrom, 0, 4);
	root.add(cmdKelTo, 1, 4);
	root.add(cmdClear, 0, 5);
	root.add(cmdCalc, 1, 5);
	Scene scene = new Scene(root, 300, 220);
	primaryStage.setResizable(false);
	primaryStage.setTitle("Convert degrees");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public static void main(String[] args)
	{
	launch(args);
	}
}


