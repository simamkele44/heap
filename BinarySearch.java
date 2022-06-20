package DevideAndConqurer;

public class BinarySearch {
    int[] arr;
    int size;
    int low;
    int high;
    int mid;

    BinarySearch(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.low = 0;
        this.high = arr.length-1;
        this.mid = (low + high) / 2;
    }

    public int SearchItem(int item) {

        while(low<=high) {
            if(item>arr[mid]) {
                low = mid+1;
                mid = (low + high) / 2;
            }else if(item==arr[mid]) {
                return mid;
            }else{
                high = mid-1;
                mid = (low + high) / 2;
            }
        }
        return -1;
    }

    public int SearchItemRecursive(int item) {
        if(low>high) {
            return -1;
        }else{
            if(item>arr[mid]){
                low = mid+1;
                mid = (low + high) / 2;
                return SearchItemRecursive(item);
            }else if(item==arr[mid]){
                return mid;
            }else{
                high = mid-1;
                mid = (low + high) / 2;
                return SearchItemRecursive(item);
            }
        }
    }
}
