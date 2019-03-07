public class SparseMatrixTest {
    public void testCreateMatrixA(){
        int numRows = 4;
        int numColumns = 6;

        SparseMatrix matrixA = new SparseMatrix(4,6);
        matrixA.insert(1,1,8);
        matrixA.insert(1,6,60);
        matrixA.insert(1,2,5);
        matrixA.insert(2,2,33);
        matrixA.insert(2,4,36);
        matrixA.insert(3,5,18);
        matrixA.insert(3,4,32);
        matrixA.insert(3,3,31);
        matrixA.insert(4,6,98);
        matrixA.print();
    }
}
