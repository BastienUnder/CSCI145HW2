public interface HeadNode extends Node {
    HeadNode getNext();
    ValueNode getFirst();
    void insert(ValueNode value);
    int get(int position);


}
