package first;

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

  private static void revisedSolution() {
    // hint given by Shuo Zheng: 3N total
    int i = 0;
    int j = PEOPLENUM - 1;
    while (i < j) {
      if (gift(i, j)) {
        i++;
      } else {
        j--;
      }
    }
    int resutl = i;
    // here i == j is what we want
    // but still need to check that all people give a gift to result and
    // all result doesn't give anything out
  }

  public static void main(String[] args) {
    // here we initiate the array to be false; so when update the boolean to be
    // true
    // means that it can't be the result
    // each call to gift(i,j) can eliminate one candidate, gift(i,j) == true
    // means that
    // i can't be the candidate; while false means that j can't be the candidate
    // thus after N calls to the gift(i,j), we should get the result
    boolean[] results = new boolean[PEOPLENUM];
    for (int i = 0; i < results.length; i++) {
      if (results[i])
        continue; // true means that it can't be the candidate
      for (int j = i + 1; j < results.length; j++) {
        if (results[j])
          continue;
        if (gift(i, j)) {
          results[i] = true;
          break;
        } else {
          results[j] = true;
          continue;
        }
      }
    }
    for (int i = 0; i < results.length; i++) {
      if (!results[i]) {
        // need to check; A --> B --> C
        // the problem here is that A doesn't give a gift to B, which eliminate
        // the possibility
        // of B, and A gives a gift to C, which breaks the loop and continue
        // from C
        // say that C is the final result, but maybe B doesn't give a gift to C
        for (int j = 0; j < results.length; j++) {
          if (i != j) {
            if (!gift(j, i)) {
              return;
            }
          }
        }
        System.out.println(i);
        break;
      }
    }
  }
}
