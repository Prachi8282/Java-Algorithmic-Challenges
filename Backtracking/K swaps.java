class Solution {
  private static String max = "0";

  public static String findMaximumNum(String str, int k) {
    if (str == null || str.length() == 1 || k == 0)
      return str;
    util(0, str, k);
    return max;
  }

  private static void util(int start, String str, int k) {
    if (k < 0) {
      if (str.compareTo(max) > 0) {
        max = str;
      }
      return;
    }
    for (int i = start; i < str.length(); i++) {
      StringBuilder sb = new StringBuilder(str);
      sb.setCharAt(start, str.charAt(i));
      sb.setCharAt(i, str.charAt(start));
      util(start+1, sb.toString(), k - 1);
    }
  }

}
