package factory;

import handler.MouseEventHandler;
import java.util.Collection;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.Entity;
import lib.Transition;

/**
 * @author laki
 */
public class DiagramFactory {

    public static void createStage(Stage primaryStage, Collection<Entity> entities, Collection<Transition> transitions) {
        Group root = new Group();

        for (Transition transition : transitions) {
            root.getChildren().add(transition.getTransitionView());
        }
        MouseEventHandler.setTransitions(transitions);

        for (Entity entity : entities) {
            entity.getEntityGroup().setOnMousePressed(MouseEventHandler.onMousePressedEventHandler);
            entity.getEntityGroup().setOnMouseDragged(MouseEventHandler.onMouseStateDraggedEventHandler);
            root.getChildren().add(entity.getEntityGroup());
        }

        primaryStage.setScene(new Scene(root, 600, 600));
    }

}
