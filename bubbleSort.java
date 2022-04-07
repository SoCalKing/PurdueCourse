package Bubble;
import java.util.Arrays;
import java.security.MessageDigest;

public class bubbleSort {
	// Optimized Bubble sort in Java


	  // perform the bubble sort
	  static void bubbleSort(int array[]) {
		  var startTime = System.nanoTime();
	    int size = array.length;
	    
	    // loop to access each array element
	    for (int i = 0; i < (size-1); i++) {
	    
	      // check if swapping occurs
	      boolean swapped = false;
	      
	      // loop to compare adjacent elements
	      for (int j = 0; j < (size-i-1); j++) {

	        // compare two array elements
	        // change > to < to sort in descending order
	        if (array[j] > array[j + 1]) {

	          // swapping occurs if elements
	          // are not in the intended order
	          int temp = array[j];
	          array[j] = array[j + 1];
	          array[j + 1] = temp;
	          
	          swapped = true;
	        }
	      }
	      // no swapping means the array is already sorted
	      // so no need for further comparison
	      if (!swapped)
	        break;

	    }
	  }

	  
	  	  
	
	   
	    

	       public static void main(String args[]) throws Exception{
	    	   
	   	    int[] data = { 35,268, 22,120, 16,8};
	          
	          //Creating the MessageDigest object  
	          MessageDigest md = MessageDigest.getInstance("SHA-256");

	          //Passing data to the created MessageDigest Object
	          md.update((byte) data.length);
	          
	          //Compute the message digest
	          byte[] digest = md.digest();      
	          System.out.println(digest);  
	         
	          //Converting the byte array in to HexString format
	          StringBuffer hexString = new StringBuffer();
	          
	          for (int i = 0;i<digest.length;i++) {
	             hexString.append(Integer.toHexString(0xFF & digest[i]));
	          }
	          System.out.println("Hex format : " + hexString.toString()); 
	          
	       // call method using the class name
	   	   bubbleSort(data);
	   	    
	   	 System.out.println("Sorted Array in Ascending Order:");
		    System.out.println(Arrays.toString(data));
	        long endTime = System.nanoTime();
	  long startTime = 0;
	  System.out.println("Took "+(endTime - startTime) + " nseconds");
	    }
	 
 }
	
