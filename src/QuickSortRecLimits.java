import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class QuickSortRecLimits extends Application
{
	private GraphView graphView;

   @Override
	public void start(Stage stage)
	{
      DataModel model = new DataModel();
      ArrayList<Long>[] times = model.getTimes();
      int[] ARRAY_SIZE = model.getARRAY_SIZE();
      String title = "QuickSort RecLimits";
		VBox vbox = new VBox();
		HBox btnPlace = new HBox();
		btnPlace.setId("buttonplace");
		btnPlace.setSpacing(20);
		btnPlace.setAlignment(Pos.CENTER);
		Button close = new Button("Close");
		close.setId("grey");
		close.setOnAction(event -> {
			Platform.exit();
		});
		Button clear = new Button("Clear");
		clear.setId("grey");
		clear.setOnAction(event -> {
         graphView.clear();
		});
		btnPlace.getChildren().addAll(clear, close);

		graphView = new GraphView(times, ARRAY_SIZE, title);
		graphView.setMinSize(800, 750);
		graphView.setId("graph");

		vbox.getChildren().addAll(btnPlace, graphView);

		// Creates a scene and adds the graph to the scene.
		Scene scene = new Scene(vbox);
		// Places the scene in the stage
		stage.setScene(scene);

		// Set the stage title
		stage.setTitle(title);

		//scene.getStylesheets().add("chart.css");
		stage.setOnCloseRequest(e -> Platform.exit());
		// Display the stage
		stage.show();

	}

	public static void main(String[] args)
	{
		launch();
	}
}