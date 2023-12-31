/**
 * Expected Output:
 * Car Year=2020, Car Model=ModelY
 */
public class JavaQuest19 {
  // Declare instance variables carYear and carModel
  private int carYear;
  private String carModel;
  // Constructor with variables carYear and carModel
  private JavaQuest19(int year , String model) {
    this.carYear = year; 
    this.carModel = model;
  }

  private int getcarYear() {
    return this.carYear;
  }
  private String getcarModel() {
    return this.carModel;
  }
  public static void main(String[] args) {
    JavaQuest19 myCar = new JavaQuest19(2020, "ModelY");
    // Create an instance of class Exercise12, with carYear 2020, and carModel
    // "ModelY"
    // print the expected output
    System.out.println("Car Year=" + myCar.getcarYear() + ", Car Model=" + myCar.getcarModel());
      
  }
}