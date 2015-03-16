package first;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class CanCompleteCircuit {

  public static int canCompleteCircuitImproved(int[] gas, int[] cost) {
    int result = 0;
    int[] fill = new int[gas.length];
    for (int i = 0; i < fill.length; i++) {
      fill[i] = gas[i] - cost[i];
    }
    int sum = 0;
    int r = 0;
    for (int i = 0; i < fill.length; i++) {
      sum += fill[i];
      r += fill[i];
      if (r < 0) {
        result = i + 1; // guaranteed to be unique; so if exists, must be the
                        // next index
        r = 0;
      }
    }
    if (sum >= 0)
      return result;
    else
      return -1;
  }

  public static void main(String[] args) {
    int[] gas = { 2, 0, 1, 2, 3, 4, 0 };
    int[] cost = { 0, 1, 0, 0, 0, 0, 11 };
    System.out.println(canCompleteCircuitImproved(gas, cost));
  }
}
