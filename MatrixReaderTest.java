import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class MatrixReaderTest {
    public void run() {
        MatrixReader mr = new MatrixReader();
        mr.read("matrixA");

    }

    public void go() {

        try(PrintWriter pw = new PrintWriter(new FileWriter("whereami.txt"))) {

            pw.println("hello");
            pw.close();
        }
        catch(NoSuchElementException | IOException e){
            e.printStackTrace();
        }
    }

}
