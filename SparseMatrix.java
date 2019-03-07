public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private HeadNode firstRow;
    private HeadNode firstColumn;

    //Sparse Matrix logic
    public SparseMatrix(int rows, int columns){
        System.out.println("WAHOO");
        
        this.totalRows = rows;
        this.totalColumns = columns;

        //generate the needed number of matrixColumn HeadNodes to represent the sparse matrix columns
        MatrixColumn curColumn = new MatrixColumn();
        this.firstColumn = curColumn;

        for(int i = 0; i < totalColumns; i++){
            curColumn.setNextColumn(new MatrixColumn());
            curColumn = (MatrixColumn)curColumn.getNextColumn();
        }

        //generate the needed number of matrixRow HeadNodes to represent the sparse matrix rows
        MatrixRow curRow = new MatrixRow();
        this.firstRow = curRow;

        for(int i = 0; i < totalRows; i++){
            curRow.setNextRow(new MatrixRow());
            curRow = (MatrixRow)curRow.getNextRow();
        }
    }

    public void insert(int row, int column, int value){
        ValueNode nodeToInsert = new ValueNode();
        nodeToInsert.setValue(value);

        //Insert the new valueNode into the right row
        HeadNode rowHead = getRow(row);
        nodeToInsert.setRow(row);
        rowHead.insert(nodeToInsert); //need to implement matrixRow and matrixColumn insert()

        //insert the new valueNode into the right column
        HeadNode columnHead = getColumn(column);
        nodeToInsert.setColumn(column);
        columnHead.insert(nodeToInsert);
    }

    public HeadNode getRow(int position){
        HeadNode cur = firstRow;
        for(int i = 0; i < position; i++){
            cur = cur.getNext();
        }
        return cur;
    }

    public HeadNode getColumn(int position){
        HeadNode cur = firstColumn;
        for(int i = 0; i < position; i++){
            cur = cur.getNext();
        }
        return cur;
    }

    public int getValue(int row, int column){
        HeadNode curColumn = firstColumn;
        HeadNode curRow = firstRow;
        for(int i = 0; i < column; i++){
            curColumn = curColumn.getNext();
        }
        for(int i = 0; i < row; i++){
            curRow = curRow.getNext();
        }


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
