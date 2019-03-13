public class Homework2 {

    public void run(){
        MatrixReader mt = new MatrixReader();
        //create and save the sparseMatrix for MatrixA
        SparseMatrix sparseMatrixA = mt.read("MatrixA");
        System.out.println("MatrixA");
        sparseMatrixA.print();
        SparseMatrix tranSparA = sparseMatrixA.transpose();
        System.out.println("MatrixA Transpose");
        tranSparA.print();

        //create and save the sparseMatrix for MatrixB
        SparseMatrix sparseMatrixB = mt.read("MatrixB");
        System.out.println("MatrixB");
        sparseMatrixB.print();
        SparseMatrix tranSparB = sparseMatrixB.transpose();
        System.out.println("MatrixB Transpose");
        tranSparB.print();

        //product of both matrices
        SparseMatrix productMatrix = sparseMatrixA.product(sparseMatrixB);
        System.out.println("Product of MatrixA and MatrixB");
        productMatrix.print();


    }
}
