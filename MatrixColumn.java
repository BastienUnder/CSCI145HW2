public class MatrixColumn implements HeadNode {

    private Node nextRow;
    private Node nextColumn;

    //Node Logic
    public Node getNextRow() {
        //returns the first valueNode in its column
        return nextRow;
    }
    public void setNextRow(Node next) {
        this.nextRow = next;
    }
    public Node getNextColumn() {
        //returns the next MatrixColumn
        return nextColumn;
    }
    public void setNextColumn(Node next) {
        this.nextColumn = next;
    }

    //HeadNode Logic
    public HeadNode getNext() {
        return null;
    }
    public ValueNode getFirst() {
        return null;
    }
    public void insert(ValueNode value) {
        // should insert a ValueNode in sorted order based on the row and column of the ValueNode being inserted

    }
    public int get(int position) {

        // return 0 if there is no ValueNode at the specified position (Note that row and column positions start at 1, not 0)
        return 0;
    }
}
