import java.math.BigDecimal;

public abstract class Shape {
  // abstract class vs class (Difference)

  // Difference
  // 1. Cannot be "new"
  // 2. May contain abstract method(s) , implicitly public

  // Same:
  // 1. May have instance varibles (attributes)
  // 2. May have instance methods
  // 3. May have static methods
  // 4. Must contain constructor, but cannot be "new", for super() only

  private String color;

  // Constructor
  public Shape() {

  }

  public Shape(String color) {
    this.color = color;
  }

  abstract double area(); // implicitly public

  public String getColor() {
    return this.color;
  }

  public static double totalArea(Shape[] shapes) {
    BigDecimal total = BigDecimal.valueOf(0);
    for (Shape shape : shapes) {
      total = total.add(BigDecimal.valueOf(shape.area()));
      // Shape.area() -> runtime -> which object (circle/Square) -> different
      // Implementation of area()
    }
    return total.doubleValue();
  }

  public static void main(String[] args) {
    String s = "hello"; // hello is a String obj., x is a String type object referance

    Shape s1 = new Circle2(3.2d, "Yellow"); // Polymorhism
    // Java Compile Time: s1 has area(), getColor()

    System.out.println("s1 area = " + s1.area());
    System.out.println("s1 color = " + s1.getColor());
    // System.out.println("s1 radius = " + s1.getRadius());

    Circle2 c2 = (Circle2) s1;
    System.out.println(c2.getRadius());

    Circle2 c1 = new Circle2();
    System.out.println("c1 area = " + c1.area());
    System.out.println("c1 color = " + c1.getColor());
    System.out.println("c1 radius = " + c1.getRadius());

    Shape[] shapes = new Shape[] { new Circle2(4), new Square(9) };
    System.out.println(totalArea(shapes)); // 131.2654824574367

  }
}
