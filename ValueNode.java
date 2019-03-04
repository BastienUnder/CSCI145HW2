public class ValueNode implements Node{
    //declare
    private int row;
    private int column;
    private int value;
    private Node nextRow;
    private Node nextColumn;

    //Node Logic
    public Node getNextRow(){
        return nextRow;
    }

    public void setNextRow(Node next){
        this.nextRow = nextRow;
    }

    public Node getNextColumn(){
        return nextColumn;
    }

    public void setNextColumn(Node next){
        this.nextColumn = nextColumn;
    }



}
