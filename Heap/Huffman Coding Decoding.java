class Solution {
  public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
    ArrayList<Integer> list = new ArrayList<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      if (minHeap.size() >= k)
        minHeap.poll();
      minHeap.add(arr[i]);
    }
    while (!minHeap.isEmpty()) {
      list.add(minHeap.poll());
    }
    return list;
  }
}
