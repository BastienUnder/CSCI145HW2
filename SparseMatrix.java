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
        nodeToInsert.setColumn(column);
        nodeToInsert.setRow(row);

        //Insert the new valueNode into the right row
        HeadNode rowHead = getRow(row);
        //nodeToInsert.setRow(row);
        rowHead.insert(nodeToInsert); //need to implement matrixRow and matrixColumn insert()

        //insert the new valueNode into the right column
        HeadNode columnHead = getColumn(column);
        //nodeToInsert.setColumn(column);
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
        HeadNode curColumn = (HeadNode)firstColumn.getNextRow();//getNext
        HeadNode curRow = (HeadNode)firstRow.getNextColumn();//getNext
        for(int i = 1; i < column; i++){
            curColumn = curColumn.getNext();
        }
        for(int i = 1; i < row; i++){
            curRow = curRow.getNext();
        }

//THe top!!!!
        //if the location being looked for doesn't exist
        if(curRow.getNextColumn() == null){
            return 0;
        }


        //if we want to insert into a further column than the first one is in
        else if(getFirst().getColumn() < value.getColumn()){
            ValueNode cur = getFirst();

            //if there's only one valueNode in that row set the new ValueNode for right after
            if(cur.getNextColumn() == null){
                cur.setNextColumn(value);
            }
            else {
                rowLoop: for (int i = 1; i < value.getColumn() + 1; i++) {
                    if (cur.getNextColumn() != null) {
                        if (cur.getNextColumn().getColumn() > value.getColumn() && value.getColumn() == i) {
                            value.setNextColumn(cur.getNextColumn());
                            cur.setNextColumn(value);
                            break rowLoop;
                        }
                        else if(cur.getNextColumn().getColumn() > value.getColumn() && i < value.getColumn()){
                            //run the for loop again to be in the right column
                        }

                        else {
                            cur = cur.getNextColumn();
                        }
                    }

                    else {
                        cur.setNextColumn(value);
                        break rowLoop;
                    }
                }
            }

            /*while(cur.getNextColumn() != null){

                if(cur.getNextColumn().getColumn() > value.getColumn()){
                    cur.setNextColumn(value);
                    break;
                }
                else{
                    cur = cur.getNextColumn();
                }
            }*/
        }

        //if we want to insert into a column before the first valueNode in that row
        else{
            value.setNextColumn(getFirst());
            setNextColumn(value);
        }

    }

    //The Bottom!!!






        return 0;
    }

    public void print(){
        //print needs to print out the zeros before each of the matrix row's
        //first value(getFirst) as well as the zeros in between, print out
        //zeros for the difference between the far valueNode in the row
        //and the close(first, smaller) valeNode
        HeadNode curRow = (HeadNode)firstRow.getNextRow();
        ValueNode curCol = ((MatrixRow)firstRow.getNextRow()).getNextColumn();//.getNextColumn();//or curRow?? not firstRow
        for(int i = 1; i < totalRows + 1; i++){
            //HeadNode actualFirst = (HeadNode)firstRow.getNextRow();//AHHHHHHHH
            //ValueNode curCol = ((MatrixRow)firstRow.getNextRow()).getNextColumn();//.getNextColumn();//or curRow?? not firstRow
            for(int j = 1; j < totalColumns + 1; j++){
                if(curCol != null && curCol.getColumn() == j){
                    System.out.print(curCol.getValue() + " ");
                    curCol = curCol.getNextColumn();
                }
                else{
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
            curRow = (MatrixRow)curRow.getNextRow();

            if(curRow != null) {
                curCol = (ValueNode) curRow.getNextColumn();
            }
        }
    }
    public SparseMatrix transpose(){
        //
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
