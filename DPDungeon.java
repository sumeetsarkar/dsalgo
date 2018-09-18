public class DPDungeon {
  int[][] mem;

  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon.length == 0)
      return 0;
    mem = new int[dungeon.length][dungeon[0].length];
    return calculateMinimumHP_R(dungeon, 0, 0);
  }

  public int calculateMinimumHP_R(int[][] dungeon, int row, int col) {
    if (row >= dungeon.length || col >= dungeon[0].length)
      return Integer.MAX_VALUE;

    if (mem[row][col] > 0) {
      return mem[row][col];
    }
    int minHealth = Integer.MAX_VALUE;
    minHealth = Math.min(minHealth, calculateMinimumHP_R(dungeon, row + 1, col));
    minHealth = Math.min(minHealth, calculateMinimumHP_R(dungeon, row, col + 1));
    minHealth = minHealth == Integer.MAX_VALUE ? 1 : minHealth;
    mem[row][col] = minHealth > dungeon[row][col] ? (minHealth - dungeon[row][col]) : 1;
    return mem[row][col];
  }

  public static void main(String...args) {
    int[][] dungeon = {
      {-2, -3, 3},
      {-5, -10, 1},
      {10, 30, -5}
    };
    DPDungeon obj = new DPDungeon();
    System.out.println(obj.calculateMinimumHP(dungeon));
    for (int[] arr: obj.mem) {
      for (int i : arr) {
        System.out.printf("%d ", i);
      }
      System.out.println();
    }
  }
}