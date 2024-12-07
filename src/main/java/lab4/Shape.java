package lab4;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Embedded
   private Color color;

   public Shape() {}

   public Shape(Color c) {
      this.color = c;
   }

   public Long getId() {
      return id;
   }

   public abstract double getArea();
   public abstract double getPerimeter();

   public String getColorDescription() {
      return "Red: " + color.getRed() + ", Green: " + color.getGreen() + ", Blue: " + color.getBlue() + ", Alpha: " + color.getAlpha();
   }

   public String getName() {
      return "Name: " + this.getClass().getSimpleName();
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }
}
