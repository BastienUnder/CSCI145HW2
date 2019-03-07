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

            SparseMatrix spar = new SparseMatrix(rows, columns);



            //read the matrix provided and save the contents as our sparse matrix as head nodes and value nodes
            int rowCount = 1;
            //iterate through each row of the matrix, down
            while(input.hasNextLine()){

                String inputArray[] = input.nextLine().split(" ");

                //iterate through each column right
                for(int i = 0; i < inputArray.length; i++){

                    String individual[] = inputArray[i].split(",");


                    int columnNum = Integer.parseInt(individual[0]);
                    int value = Integer.parseInt(individual[1]);

                    //put the given matrix in order, of columns, then do this process of creating valueNodes and point them to each other IN ORDER

                    //Assuming that each line has a real value
                    if(rowCount == 1 && i ==0){
                        //create a matrixRow and set
                    }



                    //inputArr[count][i] = inputArray[i];//.split(",");
                    System.out.print(inputArray[i] + " " );
                    rowCount++;
                }

                if(!inputArray.equals(null)){
                    String rowFirstValueNode[] = inputArray[0].split(",");

                }

                System.out.println();

                rowCount++;
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
