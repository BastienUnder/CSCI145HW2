public class MatrixRow implements HeadNode{

    private Node nextRow;
    private Node nextColumn;

    //Node Logic
    public HeadNode getNextRow(){
        //returns the next MatrixRow

        return (HeadNode)nextRow;
    }
    public void setNextRow(Node next){
        this.nextRow = next;
    }
    public ValueNode getNextColumn(){
        //returns the first valueNode in its row
        return (ValueNode)nextColumn;
    }
    public void setNextColumn(Node next){
        this.nextColumn = next;
    }


    //HeadNode Logic
    public HeadNode getNext(){
        return (HeadNode)nextRow;

    }

    public ValueNode getFirst(){
        return (ValueNode)nextColumn;
    }

    public void insert(ValueNode value){
        // should insert a ValueNode in sorted order based on the row and column of the ValueNode being inserted
        if(getFirst() == null){
            setNextColumn(value);
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
    public int get(int position){


        // return 0 if there is no ValueNode at the specified position (Note that row and column positions start at 1, not 0)
        return 0;
    }
}
