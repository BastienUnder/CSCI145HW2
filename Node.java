public interface Node {

    Node getNextRow();
    void setNextRow(Node next);
    Node getNextColumn();
    void setNextColumn(Node next);
}
