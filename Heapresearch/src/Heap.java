/* Heap.java
this program will instantiate a heap and perform heapsort
last edited 8/7/23 by Lavdrim Islami
 */
public class Heap {
    public int size = 0;
    public static int smallestChild;// the smaller of two children of the current node while sifting
    public int[] heap;
    public Heap(){
        heap = new int[1000001]; //make the size 1000001 due to index 0 not being used
    }
    //insert method
    public void insert(int data){
        if(size == 0) { //checks if heap is empty and if so adds to index 1
            size++;
            heap[size] = data;
        }//end if
        else {
            size++;
            //add the item to end of the items in the array
            heap[size] = data; //points to the end
            //percolate method to put new item into correct spot in tree
            this.percolate(size);
        }//end else
    }//end insert

    public void percolate(int current){
        //if current item is not root
        if (current > 1) {
            int parent = heap[(current) / 2]; // Calculate parent index
            // If parent < child, swap the two & repeat the recursion
            if (parent > heap[current]) {
                int temp = parent; // Swap
                heap[(current) / 2] = heap[current]; // Swap
                heap[current] = temp; // Swap

                this.percolate(current/2); // Recurse with parent index
            }//end if ( heap[ int(current/2) ] < heap[current] )
        }// end (current >1
    } // end percolate

    //extract method
    public int extract(){
        //retrieve value from root of the tree (array element 1)
        int returnValue = heap[1];

        //move value from last element to the root
        heap[1] = heap[size];

        //decrease the size of heap by 1
        size--;

        //set current pointer to root of heap
        int current = 1;

        //call sift method to maintain heap
        sift(current);

        return returnValue;
    }//end extract

    //sift method
    public void sift(int current){
        int temp;
        //if current item has 1 child
        if(((current * 2) <= size) && ((current * 2 + 1) > size)){ //if left exists & right doesn't

            //if childs value < current value, swap and recursively sift down the tree
            if(heap[current * 2] < heap[current]){
                temp = heap[current]; //swap
                heap[current] = heap[current * 2]; //swap
                heap[current * 2] = temp; //swap

                //sift from child
                sift (current * 2);
            }//end if ( heap[current*2] > heap[current] )\
        }// end if ( (current*2) <= size ) and ( (current*2+1) > size )

        //if current item has two children
        if((current * 2 + 1) <= size){ //both left and right children exist
            //find the smallest of the two children
            if(heap[current * 2 + 1] < heap[current * 2]) { //right is smallest
                smallestChild = current * 2 + 1;
            } //end if
            else {                    //else left is smallest
                smallestChild = current * 2;

            }
            //if smallestchild value < current value then swap
            if(heap[smallestChild] < heap[current]){
                temp = heap[current]; //swap
                heap[current] = heap[smallestChild]; //swap
                heap[smallestChild] = temp; //swap

                sift(smallestChild);
            } //end if
        }//end if

    } //end sift

    public static void heapsort(int[] a){
        //instantiate heap
        Heap myHeap = new Heap();

        //iterate the array, inserting each element in to the heap one at a time  (heapify)
        for(int i = 0; i < a.length; i++){
            myHeap.insert(a[i]);
        }//end for
        //iterate the array, extracting each element from the heap into the array one at a time
        for (int i = 0; i < a.length; i++){
            a[i] = myHeap.extract();
        }//end heapsort
    }
}