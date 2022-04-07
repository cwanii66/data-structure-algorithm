package Exception;

import java.io.BufferedReader;
import java.io.IOException;

public class CreateExceptionClass {
       public static void main(String[] args) {

       }
}
class FileFormatException extends IOException {
       public FileFormatException() {}
       public FileFormatException(String gripe) {
              super(gripe);
       }
}
