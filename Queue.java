package DevideAndConqurer;
import java.util.ArrayList;

public class Queue {
    private ArrayList<Node> queue;

    Queue(){
        queue = new ArrayList<Node>();
    }

    public void push(Node data) {
        queue.add(data);
    }

    public Node peek() {
        return queue.get(0);
    }

    public int getSize(){
        return queue.size();
    }

    public Node pop(){
        Node first_item = queue.get(0);
        queue.remove(0);
        return first_item;
    }

    public void show() {
        for(int i=0; i<queue.size(); i++){
            System.out.println(queue.get(i));
        }
    }

    public Boolean isEmpty() {
        if(queue.size()==0){
            return true;
        }else{
            return false;
        }
    }

}
