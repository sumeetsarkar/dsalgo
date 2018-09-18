import java.util.HashMap;

public class DPUniquePaths {

  public int uniquePaths(int m, int n) {
    return findUniquePaths(m - 1, n - 1, new HashMap<String, Integer>());
  }

  public int findUniquePaths(int row, int col, HashMap<String, Integer> map) {
    if (row < 0 || col < 0)
      return 0;
    if (row == 0 && col == 0)
      return 1;
    if (map.containsKey((row + ":" + col)))
      return map.get((row + ":" + col));
    int up = findUniquePaths(row - 1, col, map) + findUniquePaths(row, col - 1, map);
    map.put((row + ":" + col), up);
    return up;
  }

  public static void main(String...args) {
    DPUniquePaths up = new DPUniquePaths();
    System.out.println(up.uniquePaths(3, 2));
  }
}
