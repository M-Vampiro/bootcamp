public class StringPrinter {
  private String x;

  public StringPrinter(String x) {
    this.x = x ;
  }

  public String getX() {
    return this.x;
  }

  public static void main(String[] args) {
    StringPrinter s = new StringPrinter("Hello");
    System.out.println(s.getX());
  }
}
