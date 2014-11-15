package first;

public class SearchMatrix {

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    if (target < matrix[0][0])
      return false;
    int row = search(matrix, target);
    int i = 0;
    int j = matrix[row].length - 1;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }
    return false;
  }

  public static int search(int[][] matrix, int target) {
    int i = 0;
    int j = matrix.length - 1;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (matrix[mid][0] == target) {
        return mid;
      } else if (matrix[mid][0] > target) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    return (i + j) / 2;
  }
  
  public static boolean oneDArray(int[][] matrix, int target){
    int rows = matrix.length;
    int columns = matrix[0].length;
    int begin = 0;
    int end = rows * columns - 1;
    while(begin<=end){
      int mid = (begin+end)/2;
      if(matrix[mid/columns][mid%columns]==target){
        return true;
      }else if(matrix[mid/columns][mid%columns]>target){
        end = mid - 1;
      }else{
        begin = mid+1;
      }
    }
    return false;
  }
}
