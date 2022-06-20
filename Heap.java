package DevideAndConqurer;
import java.util.ArrayList;

public class Heap {
    Node root;
    int size;
    Node leaf;

    Heap() {
        root = null;
        leaf = root;
        size = 0;
    }

    public int getSize(){
        return size;
    }


    public void BFS(Node root, Queue queue, int tree_size) {
        Node current_node = root;
        if(tree_size>size-1) {
            return;
        }else{
            System.out.println(current_node.getData());
            queue.push(current_node.left_child);
            queue.push(current_node.right_child);
            BFS(queue.pop(), queue, tree_size+1);

        }
    }

    public void findLeaf(Node root, Queue queue, int heap_size) {
        Node current_node = root;

        // This will make sure that current_node wont be null
        if(heap_size>size-1) {
            return;
        }else{
            if(current_node.left_child==null || current_node.right_child==null) {
                leaf = current_node;
                return;
            }
            
            queue.push(current_node.left_child);
            queue.push(current_node.right_child);

            findLeaf(queue.pop(), queue, heap_size+1);
            
            
        }
    }

    public void insertNode(Node new_node) {
        if(size==0) {
            root = new_node;
            root.parent = root;
            size++;
        }else{
            // System.out.println("leaf: "+leaf_node.getData());
            findLeaf(root, new Queue(), 0);
            if(leaf.left_child==null) {
                leaf.left_child = new_node;
                leaf.left_child.parent = leaf;
                size++;
            }else{
                leaf.right_child = new_node;
                leaf.right_child.parent = leaf;
                size++;
            }

        }

    }

    public void heapInsertion(Node new_node) {
        insertNode(new_node);
        Node current_node = new_node;
        while(current_node.getData()> current_node.parent.getData()) {
            int temp_parent_data = current_node.parent.getData();
            current_node.parent.data = current_node.getData();
            current_node.data = temp_parent_data;
            current_node = current_node.parent;
            
        }

    }

    // Heap Deletion
    public Node LastNodeBFS(Node root, Queue queue, int tree_size, Stack stack) {
        Node current_node = root;
        Stack current_stack = stack;
        if(tree_size>size-1) {
            return current_stack.peek();
        }else{
            stack.push(current_node);
            queue.push(current_node.left_child);
            queue.push(current_node.right_child);
            LastNodeBFS(queue.pop(), queue, tree_size+1, current_stack);

        }
        return current_stack.peek();
    }

    public int UnlinkNode() {
        int last_node = LastNodeBFS(root, new Queue(), 0, new Stack()).getData();
        if(size%2==0){
            LastNodeBFS(root, new Queue(), 0, new Stack()).parent.left_child = null;
        }else{
            LastNodeBFS(root, new Queue(), 0, new Stack()).parent.right_child = null;
        }

        return last_node;
    }

    public void DeleteHeapNode() {
        int last_node_data = UnlinkNode();
        Node current_node = root;
        current_node.data = last_node_data;
        Boolean compareChildren = current_node.getData()<current_node.left_child.getData() || current_node.getData()<current_node.right_child.getData();
        while(compareChildren) {
            if((current_node.left_child!=null && current_node.right_child!=null)){
                if(current_node.left_child.getData()>current_node.right_child.getData()){
                    int temp_node = current_node.data;
                    current_node.data = current_node.left_child.getData();
                    current_node.left_child.data = temp_node;
                    current_node = current_node.left_child;
                }else{
                    int temp_node = current_node.data;
                    current_node.data = current_node.right_child.getData();
                    current_node.right_child.data = temp_node;
                    current_node = current_node.right_child;
                }
            }else{
                break;
            }

        }

        size = size-1;
    }

    

}
