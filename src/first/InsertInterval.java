package first;

/*
 * 怎么考虑分类比较重要
 */
import java.util.ArrayList;
import java.util.List;

class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}

public class InsertInterval {

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> results = new ArrayList<Interval>();
    for (Interval interval : intervals) {
      if (interval.end < newInterval.start) {
        results.add(interval);
      } else if (interval.start > newInterval.end) {
        results.add(newInterval);
        newInterval = interval;
      } else {
        int begin = Math.min(interval.start, newInterval.start);
        int end = Math.max(interval.end, newInterval.end);
        newInterval = new Interval(begin, end);
      }
    }
    results.add(newInterval);
    return results;
  }

}
