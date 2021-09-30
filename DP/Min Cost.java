class Solution {
  static int minCost(int N, int cost[][]) {
    return util(cost, -1, 0);
  }

  private static int util(int[][] cost, int i, int k) {
    if (k > cost.length)
      return Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < cost[k].length; j++) {
      if (j != i) {
        min = Math.min(min, cost[k][j] + util(cost, j, k + 1));
      }
    }
    return min;
  }
}
