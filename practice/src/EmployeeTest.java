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
              name = n;
              salary = s;
              GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
              hireDay = calendar.getTime();
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
       // instance fields
       private String name;
       private double salary;
       private Date hireDay;
}
