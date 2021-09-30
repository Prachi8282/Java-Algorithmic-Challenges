public class Solution {
  int carAssembly(int a[][], int t[][], int e[], int x[]) {
    int first = e[0] + a[0][0];
    int second = e[1] + a[1][0];
    for (int i = 0; i < a.length; i++) {
      first = Math.min(first + a[0][i], second + t[1][i] + a[1][i]);
      second = Math.min(second + a[1][i], first + t[0][i] + a[0][i]);
    }
    return Math.min(first + x[0], second + x[1]);
  }
}
