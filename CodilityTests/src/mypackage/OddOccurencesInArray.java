/**
 * Write a method such that it returns the odd integer occurence in an array
 * of odd length.
 * 
 * Author: Deepanjan Das
 */

 public class OddOccurencesInArray{
     public int solution(int[] A){

        //length of the array
        int arrayLength = A.length;

        //initializations
        int num; //starting number
        int occurences = 0; //number of pairs of an element in A

        //outer most loop to count for each distinct element
        for(int i=0; i<arrayLength; i++){
            num = A[i];
            occurences++; //a number by itself is one occurence
            
            //look for occurences for num
            for (int j=i+1; j<arrayLength; j++){
                if(A[j] == num) {//pair found
                    occurences += 1; 
                }
            }
            //check whether occurences for num is even or odd
            //even occurence means num has pair(s)
            //odd means num does not have a pair -> is the answer
            if(occurences%2 == 0){
                //reset occurences and move on to the next element
                //here we need to store the particular num elemnt
                //because later in the array when we encounter the
                //same element, we dont want to lost the pair info
            }
            else {
                //num's occurence is odd, therefore it is the answer
                return num;
            }
        }

        //the method fails
        return -1;

     }