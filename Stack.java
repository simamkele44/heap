package DevideAndConqurer;
import java.util.ArrayList;

public class Stack {
    private ArrayList<Node> stack;

    Stack(){
        stack = new ArrayList<Node>();
    }

    public void push(Node data) {
        stack.add(data);
    }

    public Node peek() {
        return stack.get(stack.size()-1);
    }

    public int getSize(){
        return stack.size();
    }

    public Node pop(){
        Node top = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return top;
    }

    public void show() {
        for(int i=0; i<stack.size(); i++){
            System.out.println(stack.get(i));
        }
    }

    public Boolean isEmpty() {
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }

}
