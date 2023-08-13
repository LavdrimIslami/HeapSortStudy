/* MegaMergeSortDemo.java
 This program Runs heapsort 100 times on an array of 1 million integers
 it then reports the time taken each time
 */
public class HeapStudy {

    public static void main(String[] arg) throws Exception{
        for (int k = 1; k<= 100; k++)
        {
        int size = 1000000;     // change this number to change the size of the random array
        int[] a = new int[size];
        int[] temp = new int[a.length];  // empty temporary array, the same size and type as a[]

        // fill the array with random integers
        for (int i = 0; i< a.length; i++) 
            a[i] = (int)(Math.random()*100000 +1);

        // get the start time in nanoseconds
        long startTime = System.nanoTime();

        //call HEAPSORT to sort the entire array
        Heap.heapsort(a);

        // get the end time in nanoseconds
        long endTime = System.nanoTime();

        // calculate elapsed time in nanoseconds
        long duration = endTime - startTime;

        // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.printf("%12.8f %n", (double)duration/+1.0E+09) ;
        }
    }// end main()

} // end class