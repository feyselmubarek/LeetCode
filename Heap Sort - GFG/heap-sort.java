// { Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}


// } Driver Code Ends


class Solution
{
    // Function to build a Heap from array.
    void buildHeap(int arr[], int n) {
        // Your code here
        for(int idx = 0; idx < n; idx++){
            insert(arr, arr[idx], idx);
        }
    }

    // Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {
        // Your code here
        while(i < n){
            int l = leftChild(i);
            int r = rightChild(i);

            if(r < n && arr[r] > arr[l] && arr[r] > arr[i]){
                swap(arr, r, i);
                i = r;
            }else if(l < n && arr[l] > arr[i]){
                swap(arr, i, l);
                i = l;
            }else{
                break;
            }
        }

    }

    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        // code here
        buildHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = remove(arr, i);
        }
    }

    public void insert(int[] arr, int element, int i) {
        arr[i] = element;
        while (i > 0 && arr[i] > arr[parent(i)]) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    public int remove(int[] arr, int i){
        int max = arr[0];
        swap(arr, i, 0);
        heapify(arr, i, 0);
        return max;
    }

    public void swap(int[] arr, int i, int j){
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public int leftChild(int idx){
        return (idx * 2) + 1;
    }
    
    public int rightChild(int idx){
        return (idx * 2) + 2;
    }
    
    public int parent(int idx){
        return idx % 2 == 0 ? (idx / 2 ) - 1 : idx / 2;
    }

 }
 
 
