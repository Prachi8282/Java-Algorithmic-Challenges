class Solution {
  public static int activitySelection(int start[], int end[], int n) {
    Activity[] arr = new Activity[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Activity(start[i], end[i]);
    }
    Arrays.sort(arr, (a, b) -> (a.end - b.end));
    int count = 1;
    int endC = arr[0].end;
    for (int i = 1; i < n; i++) {
      if (arr[i].start > endC) {
        count++;
        endC = arr[i].end;
      }
    }
    return count;
  }
}

class Activity {
  int start;
  int end;

  Activity(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
