import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeTest {
       public static void main(String[] args) {
              // fill the staff array with three Employee objects
              Employee[] staff = new Employee[3];
              for (int i = 0; i < staff.length; i++)
                     staff[i] = new Employee("Carl Cracker ", 75000, 1987, 12, 5);
              // raise everyone's salary by 5%
              for (Employee e : staff)
                     e.raiseSalary(5);

              // print out information about all Employee objects
              for (Employee e : staff) {
                     System.out.println(
                             "name=" + e.getName()
                              + ", salary=" + e.getSalary()
                               + ", hireDay=" + e.getHireDay()
                     );
              }
       }
}

class Employee {
       // constructor
       public Employee(String n, double s, int year, int month, int day) {
              this.name = n;
              this.salary = s;
              GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
              this.hireDay = calendar.getTime();
       }
       public Employee() {
              this.name = "";
              this.salary = 0;
       }
       // a method
       public String getName() {
              return name;
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

       public static void main(String[] args) { // unit test
              Employee e = new Employee("Harry", 5000, 1999, 11, 6);
              System.out.println(e.getName() + " " + e.getSalary());
       }

       // instance fields
       private String name;
       private double salary;
       private Date hireDay;
       private int id;
       // static field, belongs to class
       private static int nextId = 1;

       // object initialization block
       //  block execute as long as constructing object
       // common constructor ?(abnormal)
       {
              id = nextId;
              nextId++;
       }
}

class Manager extends Employee {
       /**
        * @param n the employee's name
        * @param s the salary
        * @param year the hire year
        * @param month the hire month
        * @param day the hire day
        */
       public Manager(String n, double s, int year, int month, int day) {
              super(n, s, year, month, day);
              bonus = 0;
       }
       public void setBonus(double b) {
              bonus = b;
       }
       @Override
       public double getSalary() {
              double baseSalary = super.getSalary();
              return baseSalary + bonus;
       }

       public static void main(String[] args) {
              // construct the Manager object
              Manager boss = new Manager("carl", 800000, 1988, 12, 11);
              boss.setBonus(5000);

              Employee[] staff = new Employee[3];

              // fill the staff array with Manager and Employee objects
              staff[0] = boss;
              staff[1] = new Employee("Harry", 5000, 1999, 10, 1);
              staff[2] = new Employee("Tommy", 4000, 1990, 3, 15);

              // print out information about all Employee objects
              // e --------> dynamic binding      maybe one of such polymorphism
              for (Employee e : staff) {
                     System.out.println("name: " + e.getName() + " , salary: " + e.getSalary());
              }
       }

       private double bonus;
}
