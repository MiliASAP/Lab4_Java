package lab4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ShapeDAOTest {

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    static void setupSessionFactory() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @BeforeEach
    void setupSession() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @AfterEach
    void tearDownSession() {
        if (session != null) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @AfterAll
    static void tearDownSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void testShapeTableCreation() {
        assertDoesNotThrow(() -> {
            session.getTransaction().commit();
            session.beginTransaction();
        });
    }

    @Test
    void testInsertAndRetrieveTriangle() {
        Triangle triangle = new Triangle(3, 5, 3, 4, 5, "triangle", new Color(255, 123, 34, 78));
        session.save(triangle);
        session.flush();
        session.clear();

        List<Triangle> triangles = session.createQuery("FROM Triangle", Triangle.class).list();
        assertEquals(1, triangles.size());
        assertEquals(3.0, triangles.get(0).getA());
        assertEquals(255, triangles.get(0).getColor().getRed());
    }

    @Test
    void testInsertAndRetrieveRectangle() {
        Rectangle rectangle = new Rectangle(10.0, 5.0, "rectangle", new Color(255, 255, 255));
        session.save(rectangle);
        session.flush();
        session.clear();

        List<Rectangle> rectangles = session.createQuery("FROM Rectangle", Rectangle.class).list();
        assertEquals(1, rectangles.size());
        assertEquals(10.0, rectangles.get(0).getWidth());
        assertEquals(255, rectangles.get(0).getColor().getGreen());
    }

    @Test
    void testUpdateTriangle() {
        Triangle triangle = new Triangle(3, 5, 3, 4, 5, "triangle", new Color(123, 123, 34, 78));
        session.save(triangle);

        Triangle retrievedTriangle = session.get(Triangle.class, triangle.getId());
        retrievedTriangle.setA(6.0);
        session.update(retrievedTriangle);

        Triangle updatedTriangle = session.get(Triangle.class, triangle.getId());
        assertEquals(6.0, updatedTriangle.getA());
    }

    @Test
    void testDeleteRectangle() {
        Rectangle rectangle = new Rectangle(10.0, 5.0, "rectangle", new Color(233, 211, 255));
        session.save(rectangle);

        Rectangle retrievedRectangle = session.get(Rectangle.class, rectangle.getId());
        session.delete(retrievedRectangle);

        Rectangle deletedRectangle = session.get(Rectangle.class, rectangle.getId());
        assertNull(deletedRectangle);
    }
}
