import java.util.HashMap;

public class DPUniquePaths2 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    if (m == 0) return 0;
    int n = obstacleGrid[0].length;
    return findUniquePaths(obstacleGrid, m - 1, n - 1, new HashMap<String, Integer>());
  }

  public int findUniquePaths(int[][] obstacleGrid, int row, int col, HashMap<String, Integer> map) {
    if (row < 0 || col < 0)
      return 0;
    if (obstacleGrid[row][col] == 1)
      return 0;
    if (row == 0 && col == 0)
      return 1;
    if (map.containsKey((row + ":" + col)))
      return map.get((row + ":" + col));
    int up = findUniquePaths(obstacleGrid, row - 1, col, map)
      + findUniquePaths(obstacleGrid, row, col - 1, map);
    map.put((row + ":" + col), up);
    return up;
  }

  public static void main(String...args) {
    DPUniquePaths2 up = new DPUniquePaths2();
    int[][] obstacleGrid = {
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    };
    System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
  }
}
