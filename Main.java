package DevideAndConqurer;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62};
        BinarySearch binary_search = new BinarySearch(arr);

        int[] max_heap_arr = {50, 30, 20, 15, 10, 8, 16};
        Heap max_heap = new Heap();

        for(int i = 0; i < max_heap_arr.length; i++) {
            max_heap.insertNode(new Node(max_heap_arr[i]));
        }

        max_heap.heapInsertion(new Node(60));



        max_heap.BFS(max_heap.root, new Queue(), 0);
        //System.out.println("Last Node "+max_heap.LastNodeBFS(max_heap.root, new Queue(), 0, new Stack()).parent.getData());
        System.out.println("After deletion");
        max_heap.DeleteHeapNode();
        max_heap.BFS(max_heap.root, new Queue(), 0);


        
        
  




        
    }
}
