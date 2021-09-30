import java.util.Arrays;

class Solution {
  static long inversionCount(long arr[], long N) {
    return mergeCount(arr, 0, (int) N - 1);
  }

  private static long mergeCount(long arr[], int start, int end) {
    long count = 0;
    while (start < end) {
      int mid = start + (end - start) / 2;
      count += mergeCount(arr, start, mid);
      count += mergeCount(arr, mid + 1, end);
      count += merge(arr, start, mid, end);
    }
    return count;
  }

  private static long merge(long[] arr, int start, int mid, int end) {
    long[] leftArr = Arrays.copyOfRange(arr, start, mid + 1);
    long[] rightArr = Arrays.copyOfRange(arr, mid + 1, end);
    long swaps = 0;
    int i = 0, j = 0, k = start;
    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
        swaps += leftArr.length - i;
      }
    }
    while (i < leftArr.length) {
      arr[k++] = leftArr[i++];
    }
    while (j < rightArr.length) {
      arr[k++] = rightArr[j++];
    }
    return swaps;
  }
}
