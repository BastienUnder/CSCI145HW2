public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private HeadNode firstRow;
    private HeadNode firstColumn;

    //Sparse Matrix logic
    public SparseMatrix(int rows, int columns){

    }
    public void insert(int row, int column, int value){

    }
    public HeadNode getRow(int position){
        return null;
    }
    public HeadNode getColumn(int position){
        return null;
    }
    public int getValue(int row, int column){
        return 0;
    }
    public void print(){

    }
    public SparseMatrix transpose(){
        return null;
    }
    public SparseMatrix product(SparseMatrix other){
        return null;
    }

    //Getters and Setters
    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }
}
