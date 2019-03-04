import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;





public class MatrixReader {



    public SparseMatrix read(String file){

        SparseMatrix spar = new SparseMatrix(1,2);

        File f = new File(file);

        if(f.isFile() && f.canRead()){
            System.out.println("Fuck");
        }

        try(Scanner input = new Scanner(f)){
            //SparseMatrix spar = new SparseMatrix();
            //int test = input.nextInt();
            //System.out.println(test);

            spar.setTotalRows((input.nextInt()));
            input.nextLine();
            spar.setTotalColumns(input.nextInt());
            input.nextLine();

        }
        catch(NoSuchElementException | IOException e){
            e.printStackTrace();
        }


        System.out.println("Total rows: " + spar.getTotalRows());
        System.out.println("Total Columns: " + spar.getTotalColumns());


        return spar;
    }
}
