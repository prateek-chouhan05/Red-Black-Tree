public class NodeRB{
    NodeRB left;
    NodeRB right;
    Boolean colour;//true for red and false for black
    Integer val;

    NodeRB(Integer value) {
        left = null;
        right = null;
        val = value;
        colour=true;
    }
}