public class MatrixColumn implements HeadNode {

    private Node nextRow;
    private Node nextColumn;

    //Node Logic
    public ValueNode getNextRow() {
        //returns the first valueNode in its column
        return (ValueNode)nextRow;
    }
    public void setNextRow(Node next) {
        this.nextRow = next;
    }
    public HeadNode getNextColumn() {
        //returns the next MatrixColumn
        return (HeadNode)nextColumn;
    }
    public void setNextColumn(Node next) {
        this.nextColumn = next;
    }

    //HeadNode Logic
    public HeadNode getNext() {
        return (HeadNode)nextColumn;
    }
    public ValueNode getFirst() {
        return (ValueNode)nextRow;
    }
    public void insert(ValueNode value) {
        // should insert a ValueNode in sorted order based on the row and column of the ValueNode being inserted
        if(getFirst() == null){
            setNextRow(value);
        }

        //if we want to insert into a lower row than the first one is in
        else if(getFirst().getRow() < value.getRow()){
            ValueNode cur = getFirst();



            //if there's only one valueNode in that column set the new ValueNode for right after
            if(cur.getNextColumn() == null){
                cur.setNextColumn(value);
            }
            else {
                colLoop: for (int i = 1; i < value.getRow() + 1; i++) {
                    if (cur.getNextRow() != null) {
                        if (cur.getNextRow().getRow() > value.getRow() && value.getRow() == i) {
                            value.setNextRow(cur.getNextRow());
                            cur.setNextRow(value);
                            break colLoop;
                        }
                        else if(cur.getNextRow().getRow() > value.getRow() && i < value.getRow()){
                            //run the for loop again to be in the right Row
                        }

                        else {
                            cur = cur.getNextRow();
                        }
                    }

                    else {
                        cur.setNextRow(value);
                        break colLoop;
                    }
                }
            }





            /*while(cur.getNextRow() != null){

                if(cur.getNextRow().getRow() > value.getRow()){
                    cur.setNextRow(value);
                    break;
                }
                else{
                    cur = cur.getNextRow();
                }
            }*/
        }

        //if we want to insert into a row before the first valueNode in that column
        else{
            value.setNextRow(getFirst());
            setNextRow(value);
        }
    }
    public int get(int position) {

        // return 0 if there is no ValueNode at the specified position (Note that row and column positions start at 1, not 0)
        return 0;
    }
}
