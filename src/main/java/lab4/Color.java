package lab4;
import jakarta.persistence.*;

@Embeddable
public class Color {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public Color() {}

    public Color(int red, int green, int blue, int alpha) {
        if(red < 0 || green < 0 || blue < 0 || alpha < 0 ||
                red > 255 || green > 255 || blue > 255 || alpha > 255) {
            throw new IllegalArgumentException("Invalid color value: Values must be between 0 and 255.");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    public Color(int red,int green, int blue) {
        this(red, green, blue, 0);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

}
