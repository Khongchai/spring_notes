import java.lang.annotation.Documented;

/**
 * Annotation doesn't really do anything to change a program's runtime behavior, same as Dart's.
 *
 * Annotations are essentially for documenting or telling the compiler // some tools additional information.
 *
 * @Documented, for example,tells the Javadoc to document this in the generated documentation
 */
public class Main {
    public static void main(String[] args) {
        final Shape shape = new Shape();
        System.out.printf("%f", shape.x);
    }
}

@Documented
@interface Entity {
    double x();
    double y();
}

@Entity(x = 20, y = 10)
class Shape {
    public double x;
    public double y;
}




