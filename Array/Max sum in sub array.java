class Solution {
  public static long pairWithMaxSum(long arr[], long N) {
    long max = Long.MIN_VALUE;
    for (int i = 1; i < N; i++) {
      max = Math.max(max, arr[i] + arr[i - 1]);
    }
    return max;
  }
}
