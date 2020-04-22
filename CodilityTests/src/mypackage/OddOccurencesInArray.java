package mypackage;

/**
 * Write a method such that it returns the odd integer occurence in an array
 * of odd length.
 * URL of problem description: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * 
 * Author: Deepanjan Das
 */

 public class OddOccurencesInArray{
    
    /**
     * Description: Main method. Calls solution(int[] a) method by passing array to it.
     *              Displays answer.
     * @param {String} args[] console arguments passed in console when running main method.
     * @return none
     */
    public static void main(String args[]){
        OddOccurencesInArray obj = new OddOccurencesInArray();
        
        //Instantiate array
        int[] array = new int[] {3,2,4,0,0,4,0,3,4,0,4};
        System.out.println("Displaying array - ");
        
        for(int num:array){ 
            System.out.print(num + " ");
        }
        System.out.println();
        int answer = obj.solution(array);
        
        //check for failure
        if(answer == -1){
            System.out.println("Solution failed!");
        }
        System.out.println("Unpaired element in the array is " + answer);
    } 

    /**
     * method Name: solution
     * Description: Finds out un-paired element in int array and returns its value.
     *              Running time O(n(n-1)) => O(n^2), where n is size of array 
     * @param {int[]} array A
     * @return {int} value of unpaired element in A 
     */
    public int solution(int[] A){

        //length of the array
        int arrayLength = A.length;

        //initializations
        int num; //starting number
        int occurences = 0; //number of pairs of an element in A

        //outer most loop to count for each distinct element
        for(int i=0; i<arrayLength; i++){
            if(A[i] == -1 ){//element already marked. Proceed to next iteration.
                continue;
            }
            num = A[i];
            
            occurences++; //initially encountering a number is one occurence
            
            //look for more occurences for num
            for (int j=i+1; j<arrayLength; j++){
                if(A[j] == -1){ //element already marked. Proceed to next iteration.
                    continue;
                }
                
                if(A[j] == num) {//increment occurences
                    occurences++; 
                }
                if((occurences != 0)&&(occurences%2 == 0)){
                    A[i] = -1;
                    A[j] = -1;  
                    occurences = 0;//reset occurences  
                }
            }
            //check whether occurences for num is even or odd
            //even occurence means num has pair(s)
            //odd means num does not have a pair
            if(occurences%2 == 0){
                //reset occurences and move on to the next element
                occurences = 0;
            }
            else {
                //num's occurence is odd, therefore it is the answer
                return num;
            }
        }

        //the method fails
        return -1;

     }
    }