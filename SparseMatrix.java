public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private HeadNode firstRow;
    private HeadNode firstColumn;

    //Sparse Matrix logic
    public SparseMatrix(int rows, int columns){
        System.out.println();

        this.totalRows = rows;
        this.totalColumns = columns;

        //generate the needed number of matrixColumn HeadNodes to represent the sparse matrix columns
        MatrixColumn curColumn = new MatrixColumn();
        this.firstColumn = curColumn;

        for(int i = 0; i < totalColumns; i++){//Does this give us one column to many?
            curColumn.setNextColumn(new MatrixColumn());
            curColumn = (MatrixColumn)curColumn.getNextColumn();
        }

        //generate the needed number of matrixRow HeadNodes to represent the sparse matrix rows
        MatrixRow curRow = new MatrixRow();
        this.firstRow = curRow;

        for(int i = 0; i < totalRows; i++){//one row too many?
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
        /*
//THe top!!!!
        //if the location being looked for doesn't exist

        //if there is nothing in the row
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
            } had a * and /
        }

        //if we want to insert into a column before the first valueNode in that row
        else{
            value.setNextColumn(getFirst());
            setNextColumn(value);
        }

    }

    //The Bottom!!!

        */
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
        SparseMatrix tranSpar = new SparseMatrix(totalColumns, totalRows);
        HeadNode curRow = (HeadNode) firstRow.getNextRow();//Make this a matrixNode not a HeadNode
        ValueNode curColumn = ((MatrixRow) firstRow.getNextRow()).getNextColumn();

        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                if (curColumn != null && curColumn.getColumn() == j) {
                    tranSpar.insert(curColumn.getColumn(), curColumn.getRow(), curColumn.getValue());

                    curColumn = curColumn.getNextColumn();
                }
            }
            curRow = (MatrixRow)curRow.getNextRow();

            if (curRow != null) {
                curColumn = (ValueNode) curRow.getNextColumn();
            }
            else{
                curColumn = null;
            }
        }
        return tranSpar;
    }

    public SparseMatrix product(SparseMatrix other){
        if (totalColumns != other.getTotalRows()) {
            System.out.println("The matrices have incompatible sizes.");
            System.out.println("Make sure that the first matrix has the same number of columns as the second matrix has rows.");
            return null;
        }
        SparseMatrix productSpar = new SparseMatrix(totalRows, other.getTotalColumns());
        HeadNode curRowA = (HeadNode) firstRow.getNextRow();
        ValueNode curColumnA = ((MatrixRow) firstRow.getNextRow()).getNextColumn();
        //HeadNode curRowB = (HeadNode) other.firstRow.getNextRow();
        HeadNode curColumnB = (HeadNode)other.firstColumn.getNextColumn();
        ValueNode iterateColumnB = ((MatrixColumn) other.firstColumn.getNextColumn()).getNextRow();
        HeadNode curRowAtemp = (HeadNode) firstRow.getNextRow();

        //for each row in MatrixA
        for (int i = 1; i < totalRows + 1; i++) {
            //for each column in MatrixB
            for (int j = 1; j < other.totalColumns + 1; j++) {

                int toInsert = 0;
                //multiply corresponding item from A's row by item in B's column

                for(int itemInRow = 1; itemInRow < totalColumns + 1; itemInRow++){
                    if(iterateColumnB != null && iterateColumnB.getRow() == itemInRow) {
                        if (curColumnA != null && curColumnA.getColumn() == itemInRow) {

                            int itemValueA = curColumnA.getValue();
                            int itemValueB = iterateColumnB.getValue();
                            //add to toInsert
                            toInsert = toInsert + (itemValueA * itemValueB);
                        }
                    }
                    //move to next item in both matrices
                    if(curColumnA != null && curColumnA.getColumn() == itemInRow) {
                        curColumnA = curColumnA.getNextColumn();
                    }

                    if(iterateColumnB != null && iterateColumnB.getRow() == itemInRow) {
                        iterateColumnB = iterateColumnB.getNextRow();
                    }


                }

                productSpar.insert(i, j, toInsert);



                //to use as a temp value to reset to each row in A each new column of B
                curRowAtemp = (HeadNode) firstRow.getNextRow();
                for (int whichRow = 1; whichRow < i; whichRow++) {
                    if (curRowAtemp != null) {
                        curRowAtemp = (HeadNode) curRowAtemp.getNextRow();
                    }
                }
                if(curRowAtemp != null){
                    curColumnA = (ValueNode)curRowAtemp.getNextColumn();
                }



                //to set to the next column in MatrixB, aka B
                curColumnB = ((MatrixColumn) other.firstColumn.getNextColumn());
                for(int whichColumn = 1; whichColumn < j +1; whichColumn++){
                    if(curColumnB != null) {
                        curColumnB = (MatrixColumn)curColumnB.getNextColumn();
                    }
                }

                if(curColumnB != null) {
                    iterateColumnB = ((MatrixColumn) curColumnB).getNextRow();
                }

            }

            //curColumnB = (MatrixColumn)other.firstColumn.getNextColumn();
            iterateColumnB = ((MatrixColumn) other.firstColumn.getNextColumn()).getNextRow();


            //curColumnA = ((MatrixRow) firstRow.getNextRow()).getNextColumn();
            for(int whichRow = 1; whichRow < i +1; whichRow++){
                if(curRowA != null){
                    curRowA = (HeadNode)curRowA.getNextRow();

                }
            }
            if(curRowA != null){
                curColumnA = (ValueNode)curRowA.getNextColumn();
            }


        }
        return productSpar;
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
