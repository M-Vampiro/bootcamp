import java.util.Objects;

public class Cat {
  private String name;
  private int age;
 // private final eyes[] = new eyes[2];



   public Cat(String name, int age) {
    this.name = name;
    this.age = age;
   }

   public String getName() {
    return this.name;

   }

   public int getAge() {
    return this.age;
   }
  
   @Override
   public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } if (!(obj instanceof Cat)) {
      return false;
    } 
    Cat cat = (Cat) obj;
    //return cat.getAge() == this.age && cat.getName().equals(this.name);
    return Objects.equals(cat.getAge() , this.age)
        && Objects.equals(cat.getName() , this.name);
   }

   @Override
   public int hashCode() { // hashcode -> represents object address
      return Objects.hash(this.name, this.age);


   }















}
