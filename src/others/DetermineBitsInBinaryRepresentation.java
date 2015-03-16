package others;
/*
 * unsigned int
 * 找一个无符号数中有多少个set bit
 */
public class DetermineBitsInBinaryRepresentation {

  public static int numberOfBits(int n){
    int result = 0;
    while(n>0){
      n = n & (n-1);
      result++;
    }
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println(numberOfBits(15));
  }
}
