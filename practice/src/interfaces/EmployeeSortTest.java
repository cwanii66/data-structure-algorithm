package interfaces;

import java.util.*;

/**
 * This program demonstrates the use of the Comparable interface
 * @version 1.30
 * @author Cay Horstman
 */

public class EmployeeSortTest {
       public static void main(String[] args) {
              Employee[] staff = new Employee[3];

              staff[0] = new Employee("Harry Hacker", 35000);
              staff[1] = new Employee("Carl Cracker", 75000);
              staff[2] = new Employee("Tony Tester", 38000);

              Arrays.sort(staff);

              // print out information about Employee objects
              for (Employee e : staff)
                     System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
       }
}

/*
       int compareTo( T other)
       void sort(Object[] a)      should have implemented comparable interface and the element could be compared
 */
