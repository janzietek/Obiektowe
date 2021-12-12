package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import agh.ics.oop.GrassField;

public class App extends Application {
    GrassField map;

    @Override
    public void init() {
        try {
            String[] commands = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(commands);
            this.map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, this.map, positions);
            System.out.println(this.map.toString());
            engine.run();
            System.out.println(this.map.toString());

        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }

    public void start (Stage primaryStage){
        primaryStage.setTitle("My world");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 400, 400);

        Vector2d LL = map.getLowerLeft();
        Vector2d UR = map.getUpperRight();

        Label labelxy = new Label("y/x");
        grid.add(labelxy, 0, 0);
        GridPane.setHalignment(labelxy, HPos.CENTER);

        int i, j;

        for (i = LL.x; i <= UR.x; i++) {
            Label label = new Label(String.valueOf(i));
            grid.add(label, i - LL.x + 1, 0);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
        }
        grid.getColumnConstraints().add(new ColumnConstraints(20));


        for (j = UR.y; j >= LL.y; j--) {
            Label label = new Label(String.valueOf(j));
            grid.add(label, 0, UR.y - j + 1);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(30));
        }
        grid.getRowConstraints().add(new RowConstraints(30));


        for (i = LL.x; i <= UR.x; i++) {
            for (j = UR.y; j >= LL.y; j--) {
                Vector2d currentPosition = new Vector2d(i, j);
                if (map.objectAt(currentPosition) == null) {
                    Label label = new Label(" ");
                    grid.add(label, i - LL.x + 1, UR.y - j + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                else {
                    Label label = new Label(map.objectAt(currentPosition).toString());
                    grid.add(label, i - LL.x + 1, UR.y - j + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
