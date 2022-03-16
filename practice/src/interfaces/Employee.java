package interfaces;

public class Employee implements Comparable<Employee> {
       private String name;
       private double salary;

       public Employee(String name, double salary) {
              this.name = name;
              this.salary = salary;
       }

       public String getName() { return name; }
       public  double getSalary() { return salary; }

       public void raiseSalary(double byPercent) {
              double raise = salary + byPercent / 100;
              salary += raise;
       }
       /**
        * Compares employees by salary
        * @param other another Employee object
        * @return a negative value if this employee has a lower salary than
        * otherObject, 0 if the salaries are the same, a positive value otherwise
        */
       public int compareTo(Employee other) {
              return Double.compare(salary, other.salary);
       }
}
//interface Comparable<T> {
//       default int compareTo(T other) { return 0; }
//        // By default, all element are the same
//}

//public interface Collection {
//       int size(); // An abstract method
//       default boolean isEmpty() {
//              return size() == 0;
//       }
//       // ...
//}
