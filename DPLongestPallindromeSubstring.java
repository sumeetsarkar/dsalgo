public class DPLongestPallindromeSubstring {

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    char[] arr = s.toCharArray();
    int n = arr.length;
    boolean[][] table = new boolean[n][n];

    int start = -1, longest = -1;
    for (int i = 0; i < n; i ++) {
      table[i][i] = true;
      start = i;
      longest = 1;
    }

    for (int i = 0; i < n - 1; i ++) {
      if (arr[i] == arr[i + 1]) {
        table[i][i + 1] = true;
        start = i;
        longest = 2;
      }
    }

    for (int k = 3; k <= n; k++) {
      for(int i = 0; i < n - k + 1; i++) {
        int j = i + k - 1;
        if (table[i + 1][j - 1] && arr[i] == arr[j]) {
          table[i][j] = true;
          if (k >= longest) {
            longest = k;
            start = i;
          }
        }
      }
    }

    return s.substring(start, start + longest);
  }

  public static void main(String...args) {
    String s = "aaa";
    DPLongestPallindromeSubstring obj = new DPLongestPallindromeSubstring();
    System.out.println(obj.longestPalindrome(s));
  }
}
