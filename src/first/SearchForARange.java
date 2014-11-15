package first;

public class SearchForARange {

  public int[] searchRange(int[] A, int target) {
    int[] result = new int[2];
    result[0] = -1;
    result[1] = -1;
    if (A == null || A.length == 0)
      return result;
    int begin = 0;
    int end = A.length - 1;
    int mid = 0;
    while (begin <= end) {
      mid = (begin + end) / 2;
      if (A[mid] == target) {
        break;
      } else if (A[mid] < target) {
        begin = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    if (A[mid] != target)
      return result;
    int i = mid;
    int j = mid;
    while (i >= 0 && A[i] == target)
      i--;
    while (j <= A.length - 1 && A[j] == target)
      j++;
    i++;
    j--;
    result[0] = i;
    result[1] = j;
    return result;
  }
}
