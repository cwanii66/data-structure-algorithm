package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * this program demonstrates the use of inner classes
 * @version 1.11
 * @author Cay Horstman
 */

public class innerClassTest {
       public static void main(String[] args) {
              TalkingClock clock = new TalkingClock(1000, true);
              clock.start(1000, true);

              // keep program running until user selects "Ok"
              JOptionPane.showMessageDialog(null, "Quit program ?");
              System.exit(0);
       }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
       private int interval;
       private boolean beep;

       /**
        * Constructs a talking clock
        * @param interval the interval between message (in milliseconds)
        * @param beep true if clock should beep
        */
       public TalkingClock(int interval, boolean beep) {
              this.interval = interval;
              this.beep = beep;
       }
       /**
        * Starts the clock
        */
       public void start(int interval, final boolean beep) {
              // 局部内部类
              class TimerPrinter implements ActionListener {
                     public void actionPerformed(ActionEvent event) {
                            System.out.println("At the tone, the time is " + new Date());
                            if (beep) Toolkit.getDefaultToolkit().beep();
                     }
              }

              // 编写内部对象的构造器
              // outerObject.new InnerClass(construction parameters)
              // ActionListener listener = this.new TimerPrinter();

              // 显式命名将外围类引用设置为其他对象
              // TalkingClock jabberer = new TalkingClock(1000, true);
              // TalkingClock.TimerPrinter listener = jabberer.new TimerPrinter();

              ActionListener listener = new TimerPrinter();
              Timer t = new Timer(interval, listener);
              t.start();
       }

       /*public class TimerPrinter implements ActionListener {
//              public TimePrinter(TalkingClock clock) // automatically generated code
//              {
//                     outer = clock;
//              }

              public void actionPerformed(ActionEvent event) {
                     System.out.println("At the tone, the time is " + new Date());
                     // OuterClass.this    外围类的引用
                     if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
              }
       }*/
}
