public interface HeadNode extends Node {
    //Well hello my friend, it looks like today is your birthday.
    HeadNode getNext();
    ValueNode getFirst();
    void insert(ValueNode value);
    int get(int position);


}
