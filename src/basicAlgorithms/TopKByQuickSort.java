package basicAlgorithms;

// O(n) time, O(1) extra space
public class TopKByQuickSort {

	public TopKByQuickSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	int partition(int a[],int first,int end){
        int i=first;
        int pivot=a[end];
        for(int j=first;j<end;j++){
             if(a[j]<pivot){
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
                i++;
             }
        }
        a[end]=a[i];
        a[i]=pivot;
        return i;    
   }
	
   void getTopKMinBySort(int a[],int first,int end,int k){
      if(first<end){
          int partitionIndex=partition(a,first,end);
          if(partitionIndex==k-1)return;
          else if(partitionIndex>k-1) {
        	  getTopKMinBySort(a,first,partitionIndex-1,k);
          }        	  
          else {
        	  // 0 - partiionIndex are organized, consider the right side only, keep K here
        	  getTopKMinBySort(a,partitionIndex+1,end,k);
          }
      }
   }
   public static void main(String []args){
      int a[]={2,20,3,7,9,1,17,18,0,14};
      int k=1;
      new TopKByQuickSort().getTopKMinBySort(a,0,a.length-1,k);
      for(int i=0;i<k;i++){
         System.out.print(a[i]+" ");
      }
   }

}
