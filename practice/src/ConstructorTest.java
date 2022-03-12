import java.util.*;

/**
 * This program demonstrates object construction
 * @version 1.01
 * @author Cay Horstman
 */
public class ConstructorTest {
       public static void main(String[] args) {
              // fill the staff array with three Employeee objects
              Employeee[] staff = new Employeee[3];
              staff[0] = new Employeee("Harry", 40000);
              staff[1] = new Employeee(60000);
              staff[2] = new Employeee();

              // print out information about all Employeee objects
              for (Employeee e : staff) {
                     System.out.println( e.getName() + e.getId() + e.getSalary() );
              }
       }

}
class Employeee {
       // three overloaded constructors
       public Employeee(String n, double s) {
              this.name = n;
              this.salary = s;
       }
       public Employeee(double s) {
              // calls the Employee(String, double) constructor
              this("Employee #" + nextId, s);
       }
       // the default constructor
       public Employeee() {
              // name initialized to "" -- see below
              // salary not explicitly set -- initialized to 0
              // id initialized in initialization block
       }

       public String getName() {
              return this.name;
       }
       public double getSalary() {
              return this.salary;
       }
       public int getId() {
              return this.id;
       }

       private static int nextId;

       private int id;
       private String name = ""; // instance field initialization
       private double salary;

       // static initialization block
       static {
              Random generator = new Random();
              // set nextId to a random number between 0 and 9999
              nextId = generator.nextInt(10000);
       }
       // object initialization block
       {
              id = nextId;
              nextId++;
       }
}
