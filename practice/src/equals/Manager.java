package equals;

import java.util.ArrayList;

public class Manager extends Employee {
       private double bonus;

       public Manager(String name, double salary, int year, int month, int day) {
              super(name, salary, year, month, day);
              bonus = 0;
       }

       @Override
       public double getSalary() {
              double baseSalary = super.getSalary();
              return baseSalary + bonus;
       }
       public double getBonus() { return bonus; }

       public void setBonus(double bonus) {
              this.bonus = bonus;
       }

       @Override
       public boolean equals(Object otherObject) {
              if (!super.equals(otherObject)) return false;

              Manager other = (Manager) otherObject;
              // super.equals checked that this and other belong to the same class
              return bonus == other.bonus;
       }

       @Override
       public int hashCode() {
              return super.hashCode() + 17 * Double.valueOf(bonus).hashCode();
       }

       @Override
       public String toString() {
              return super.toString() + "[bonus=" + bonus + "]";
       }

       public static void main(String[] args) {
              // pass Capacity
              ArrayList<Manager> staff = new ArrayList<>(0);
              staff.ensureCapacity(100);
              staff.add(new Manager("Mr.D", 150000, 1988, 10,12));
              System.out.println(staff.size());
              staff.trimToSize();
       }
}
