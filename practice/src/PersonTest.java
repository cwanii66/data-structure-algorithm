import java.util.*;

/**
 * This program demonstrates abstract classes
 * @version 1.01
 * @author Cay Horstman and Chris Wong
 */

public class PersonTest {
       public static void main(String[] args) {
              Person[] people = new Person[2];

              // fill the people array with student and Employee objects
              people[0] = new Employeeee("Harry", 50000, 1989, 10, 1);
              people[1] = new Student("Maria Morris", "computer science");

              // print out names and descriptions of all Person objects
              for (Person p : people) {
                     System.out.println(p.getName() + ", " + p.getDescription());
              }
       }
}

abstract class Person {
       public Person(String n) {
              name = n;
       }

       public abstract String getDescription();

       public String getName() {
              return name = "";
       }

       private String name;
}

class Employeeee extends Person {
       // constructor
       public Employeeee(String n, double s, int year, int month, int day) {
              super(n);
              salary = s;
              GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
              hireDay = calendar.getTime();
       }
       // more methods
       public double getSalary() {
              return salary;
       }
       // shouldn't return changeable reference
       public Date getHireDay() {
              // return hireDay;
              return (Date) hireDay.clone();
       }
       public void raiseSalary(double byPercent) {
              double raise = this.salary * byPercent / 100;
              this.salary += raise;
       }
       public String getDescription() {
              return String.format("an employee with a salary of $%.2f", salary);
       }

       @Override
       public boolean equals(Object otherObject) {
              // a quick test to see if the objects are identical
              if (this == otherObject) return true;

              // must return false if the explicit parameter is null
              if (otherObject == null) return false;

              // if the class don't match, they can't be equal
              if (getClass() != otherObject.getClass()) return false;

              // if all subclasses have uniform semantics, use "instanceof"
              // if (!( otherObject instanceof className)) return false;

              // now we know otherObject is non-null Employee
              Employeeee other = (Employeeee) otherObject;

              // test whether the fields have identical values
              return name.equals(other.name)
                      && salary == other.salary
                      && hireDay.equals(other.hireDay);
       }

       public static void main(String[] args) { // unit test
              Employee e = new Employee("Harry", 5000, 1999, 11, 6);
              System.out.println(e.getName() + " " + e.getSalary());
       }

       // instance fields
       private double salary;
       private Date hireDay;
       private String name;
}

class Student extends Person {
       public Student(String n, String m) {
              // pass n to superclass constructor
              super(n);
              major = m;
       }
       public String getDescription() {
              return "a student majoring in " + this.major;
       }

       // Student instance fields
       private String major;
}
