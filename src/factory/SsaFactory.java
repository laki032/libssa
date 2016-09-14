package factory;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import lib.Rounded;

/**
 * @author laki
 */
public class SsaFactory {

    private static int interfaceCount = 0;
    private static int processCount = 0;
    private static int dataWarehousesCount = 0;

    public static Group createInterface(String text) {
        return createInterface(text, 0, 0);
    }

    public static Group createInterface(String name, int x, int y) {
        interfaceCount++;
        Rectangle rectOutter = new Rectangle(100, 60);
        rectOutter.setFill(Color.BLACK);
        Rectangle rectInner = new Rectangle(96, 56);
        rectInner.setFill(Color.WHITE);
        rectInner.setX(2);
        rectInner.setY(2);
        Group g = new Group(rectOutter, rectInner, formatText(name, Rectangle.class));
        if (x == 0 && y == 0) {
            x = calcX();
            y = calcY();
        }
        g.setTranslateX(x);
        g.setTranslateY(y);
        g.setCursor(Cursor.CROSSHAIR);
        return g;
    }

    public static Group createProcess(String text) {
        return createProcess(text, 0, 0);
    }

    public static Group createProcess(String text, int x, int y) {
        processCount++;
        Ellipse eOutter = new Ellipse(50, 30);
        eOutter.setFill(Color.BLACK);
        Ellipse eInner = new Ellipse(48, 28);
        eInner.setFill(Color.WHITE);
        Text ellipseText = new Text(text);
        ellipseText.setWrappingWidth(80);
        int offset = -1 * (text.length() > 25 ? 1 : (text.length() > 15 ? 2 : 3));
        ellipseText.setTranslateX(text.length() * offset);
        Group g = new Group(eOutter, eInner, ellipseText);
        if (x == 0 && y == 0) {
            x = calcX();
            y = calcY();
        }
        g.setTranslateX(x);
        g.setTranslateY(y);
        g.setCursor(Cursor.HAND);
        return g;
    }

    public static Group createDataWarehouse(String name) {
        return createDataWarehouse(name, 0, 0);
    }

    public static Group createDataWarehouse(String name, int x, int y) {
        dataWarehousesCount++;
        Rectangle rectOutter = new Rectangle(100, 60);
        rectOutter.setFill(Color.BLACK);
        Rectangle rectInner = new Rectangle(100, 56);
        rectInner.setFill(Color.WHITE);
        rectInner.setY(2);
        Group g = new Group(rectOutter, rectInner, formatText(name, Rectangle.class));
        if (x == 0 && y == 0) {
            x = calcX();
            y = calcY();
        }
        g.setTranslateX(x);
        g.setTranslateY(y);
        g.setCursor(Cursor.CROSSHAIR);
        return g;
    }

    private static int calcX() {
        return interfaceCount * 100;
    }

    private static int calcY() {
        return interfaceCount * 100;
    }

    private static Text formatText(String t, Class c) {
        Text text = new Text(t);
        text.setWrappingWidth(80);
        text.setTextAlignment(TextAlignment.CENTER);
        if (!c.isAssignableFrom(Rounded.class)) {
            text.setX(10);
            text.setY(t.length() < 25 ? 30 : 15);
        }
        return text;
    }

}