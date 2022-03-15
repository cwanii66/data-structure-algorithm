package ArrayList;

import equals.Employee;

import java.util.*;

/**
 * This program demonstrate the ArrayList class
 * @version 1.11
 * @author Cay Horstman
 */

public class ArrayListTest {
       public static void main(String[] args) {
              // fill the staff array list with three Employee objects
              ArrayList<Employee> staff = new ArrayList<>();
              staff.add(new Employee("Carl Cracker", 8000, 1987, 12, 15));
              staff.add(new Employee("Carl Cracker", 8000, 1987, 12, 15));
              staff.add(new Employee("Carl Cracker", 8000, 1987, 12, 15));

              // raise everyone's salary by 5%
              for (Employee e : staff)
                     e.raiseSalary(5);

              staff.remove(0);

              // print out information about all Employee objects
              for (Employee e : staff)
                     System.out.println(e.getName());
              /*
              void set(int index, E obj)
              E get(int index)
              void add(int index, E obj)
              E remove(int index)
               */
       }
}
