public class DPLongestPallindromeSubstring {
  public static void main(String...args) {
    String s = "abcbcca";
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

    for (int k = 3; k < n; k++) {
      for(int i = 0; i < n - k + 1; i++) {
        int j = i + k - 1;
        if (table[i + 1][j - 1] && arr[i] == arr[j]) {
          table[i][j] = true;
          if (k > longest) {
            longest = k;
            start = i;
          }
        }
      }
    }

    System.out.printf("longest pallindrom of length %d, at poistion %d, \npallindrome %s",
      longest, start, s.substring(start, longest + 1));
  }
}
