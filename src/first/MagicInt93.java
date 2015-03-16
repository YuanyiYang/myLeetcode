package first;

/*
 * Magic int A[i] == i; in a sorted array, find all the magic index; distinct or not distinct
 *
 * CC上的版本是这个的整理，因为不管A[mid]与mid的大小关系如何，都需要继续搜索左右两边
 */
public class MagicInt93 {

  public static int findAll(int[] array, int begin, int end) {
    if (end < begin || begin < 0 || end >= array.length) {
      return -1;
    }
    int midIndex = (begin + end) / 2;
    int midValue = array[midIndex];
    if (midValue == midIndex) {
      return midIndex;
    }
    if (midIndex > midValue) {
      int searchRight = findAll(array, midIndex + 1, end);
      if (searchRight != -1) {
        return searchRight;
      }
      if (midValue >= 0) {
        int searchLeft = findAll(array, begin, midValue);
        if (searchLeft != -1) {
          return searchLeft;
        }
      }
    } else {
      int searchLeft = findAll(array, begin, midIndex - 1);
      if (searchLeft != -1) {
        return searchLeft;
      }
      if (midValue <= array.length - 1) {
        int searchRight = findAll(array, midValue, end);
        if (searchRight != -1) {
          return searchRight;
        }
      }
    }
    return -1;
  }

}
