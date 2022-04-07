package Exception.catchexception;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class CatchException
        // implements AutoCloseable
{
       public static void main(String... args) {

       }
       public void read(String filename) throws IOException, FileNotFoundException {
              try {
                     InputStream in = new FileInputStream(filename);
                     int b;
                     while ((b = in.read()) != -1) {
                            // process input
                     }
              } catch (FileNotFoundException e) {
                     e.printStackTrace();
              } catch (IOException e) {
                     e.printStackTrace();
              }
       }
//       public void testSQL() {
//              try {
//                     // access the database
//              } catch(SQLException e) {
//
//              }
//       }
       // try-with-resources
       // try块退出时，会自动调用 res.close()。
       /*
       假设资源属于一个实现了 AutoCloseable 接口的类，
       Java SE 7 为这种代码模式提供了AutoCloseable 接口的一个方法：
       void close() throws Exception
        */
//       static void try_with_resource() {
//              try(Scanner in = new Scanner(new FileInputStream("/"), "UTF-8");
//              PrintWriter out = new PrintWriter("out.txt"))
//              {
//                     while (in.hasNext()) {
//                            out.println(in.next().toUpperCase());
//                     }
//              }
//       }
//
//       public void close() throws Exception {
//
//       }

}
