package others;

/*
 * For N people, gift(i,j) ==> true means i gives a gift to j while 
 * gift(i, j) ==> false means i doesn't give a gift to j
 * Is there a person that receives all other people's gift and doesn't give
 * any gift?
 * O(N) time;
 */
public class giveGift {

  private static final int PEOPLENUM = 100;

  private static boolean gift(int i, int j) {
    return false;
  }

  private static void Solution() {
    // 3N total
    int i = 0;
    int j = PEOPLENUM - 1;
    while (i < j) {
      if (gift(i, j)) {
        i++;
      } else {
        j--;
      }
    }
    int result = i;
    // here i == j is what we want
    // but still need to check that all people give a gift to result and
    // the result doesn't give anything out
    // if guaranteed unique, this is our result; otherwise, need two more pass
    // to check
  }

}
