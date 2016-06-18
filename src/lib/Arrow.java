package lib;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.shape.QuadCurve;

/**
 * thanks to
 * http://stackoverflow.com/questions/26702519/javafx-line-curve-with-arrow-head
 *
 * @author laki
 */
public class Arrow extends Polygon {

    private final Rotate rotate;

    public Arrow(QuadCurve curve) {
        super(new double[]{0, 0, 5, 20, -5, 20}); // arrow shape
        setFill(Color.BLACK);

        rotate = new Rotate();
        rotate.setAxis(Rotate.Z_AXIS);

        getTransforms().add(rotate);
        double angle = Math.atan2(curve.getEndY(), curve.getEndX());
        angle = Math.toDegrees(angle);
        rotate.setAngle(angle + 90);

        setTranslateX(((curve.getStartX() + curve.getEndX()) / 2 + curve.getControlX()) / 2);
        setTranslateY((curve.getStartY() + curve.getEndY()) / 2);
    }

    public void setAngle(double endX, double endY) {
        double angle = Math.atan2(endY, endX);
        angle = Math.toDegrees(angle);
        rotate.setAngle(angle + 90);
    }
}
