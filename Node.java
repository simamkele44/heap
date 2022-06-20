package DevideAndConqurer;

public class Node {
    public int data;
    Node left_child;
    Node right_child;
    Node parent;

    Node(int data) {
        this.data = data;
        left_child = null;
        right_child = null;
        parent = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeftChild() {
        return left_child;
    }

    public Node getRightChild() {
        return right_child;
    }

}
