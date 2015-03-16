package others;

public class QS {

  public static void qs(int[] a){
    int begin = 0;
    int end = a.length - 1;
    helper(a, begin, end);
  }
  
  public static void helper(int[] a, int begin, int end){   
    int index = partition(a, begin, end);
    if( begin < index - 1){
      helper(a,begin,index-1);
    }
    if( end > index) {
      helper(a, index, end);
    }
  }
  
  public static int partition(int[] a, int left, int right){
    int pivot = a[right];
    while(left<=right){
      while(a[left]<pivot) left++;
      while(a[right]>pivot) right--;
      if(left<=right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
      }    
    }
    return left;
  }
  
  static int parti(int arr[], int left, int right)
  {
        int i = left, j = right;
        int tmp;
        int pivot = arr[right-1];
       
        while (i <= j) {
              while (arr[i] < pivot)
                    i++;
              while (arr[j] > pivot)
                    j--;
              if (i <= j) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
              }
        };
       
        return i;
  }
   
  static void quickSort(int arr[], int left, int right) {
        int index = parti(arr, left, right);
        if (left < index - 1)
              quickSort(arr, left, index - 1);
        if (index < right)
              quickSort(arr, index, right);
  }

  
  
  public static void main(String[] args) {
    int[] a = {2,23,532,576,4,21,32,1,32,24,32,12};
    //qs(a);
    quickSort(a, 0, a.length-1);
    for(int i : a){
      System.out.print( i + " ");
    }
  }
}
