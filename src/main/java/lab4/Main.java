package lab4;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        ShapeDAO shapeDAO = new ShapeDAO(sessionFactory);

        try {
            Triangle triangle = new Triangle(4,5,4,6,7,"triangle",new Color(255,123,34,78));
            shapeDAO.saveShape(triangle);
            Rectangle rectangle = new Rectangle(2,5,"rectangle",new Color(255,255,255));
            shapeDAO.saveShape(rectangle);

            shapeDAO.getAllShapes().forEach((Shape s) -> {System.out.println(
                    s.getName() + " (" + s.getId() + "): " + s + " | color: " + s.getColorDescription()
            );});
        }finally {
            shapeDAO.close();
        }

    }
}