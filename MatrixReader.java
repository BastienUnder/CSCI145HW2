import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;


public class MatrixReader {

    public SparseMatrix read(String file){


        //Access and read our sparse matrix file!!
        try{
            File f = new File(file);
            Scanner input = new Scanner(f);

            //Set the total rows and columns and save them in our sparse matrix
            int rows = input.nextInt();
            input.nextLine();
            int columns = input.nextInt();
            input.nextLine();


            // create new SparseMatrix called "spar"
            SparseMatrix spar = new SparseMatrix(rows, columns);

            //read the matrix provided and save the contents of our sparse matrix as head nodes and value nodes
            int rowNum = 1;
            //iterate through each row of the matrix, downwards
            while(input.hasNextLine()){

                String[] currentLine = input.nextLine().split(" ");

                //iterate through each column to the right
                for(int i = 0; i < currentLine.length; i++){

                    String[] individual = currentLine[i].split(",");

                    int columnNum = Integer.parseInt(individual[0]);
                    int value = Integer.parseInt(individual[1]);

                    //call insert on SparseMatrix
                    spar.insert(rowNum, columnNum, value);

                }
                rowNum++;

            }
            //return our sparse matrix all nice and pretty looking!
            return spar;
        }

        //Error out if our file isn't find
        catch(NoSuchElementException | IOException e){
            System.out.println("File not found.");
            e.printStackTrace();
        }

        //return
        System.out.println("Uh Oh, looks like you crashed windows, need some help?");
        return null;
    }

}




