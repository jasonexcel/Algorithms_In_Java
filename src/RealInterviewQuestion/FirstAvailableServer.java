package RealInterviewQuestion;

/*
You're running a pool of servers where the servers are numbered sequentially starting from 1. Over time, any given server might explode, in which case its server number
 is made available for reuse. When a new server is launched, it should be given the lowest available number.

Write a function which, given the list of currently allocated server numbers, returns the number of the next server to allocate.

For example:

  >> next_server_number([5, 3, 1])
  2
  >> next_server_number([5, 4, 1, 2])
  3
  >> next_server_number([3, 2, 1]) 1 2 3
  4
  >> next_server_number([2, 3])
  1
  >> next_server_number([])
  1
*/

//[5 3 1] = [1 3 5]
public class FirstAvailableServer {

    public int findFirstPositive(int[] A){
        //test specials cases
        if(A == null || A.length == 0){
            throw new IllegalArgumentException();
        }
        //A[i] == i + 1 ==> A[A[i] - 1] = A[i]
        // 5 4 1 2
        // 5 4 1 2
        // 5 2 1 4
        // 1 2 5 4
        for(int i = 0; i < A.length; i++){
            while(A[i] > 0 && A[i] <= A.length && A[i] != i + 1){
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1){
                return i + 1;
            }
            
        }
        return A.length + 1;
    }
}