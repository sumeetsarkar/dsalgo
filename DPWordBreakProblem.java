import java.util.HashMap;

public class DPWordBreakProblem {

  public boolean solve(String s, HashMap<String, Integer> map) {
    if (s.equals("")) return true;
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i ++) {
      boolean isPrefixWord = map.containsKey(s.substring(0, i + 1));
      System.out.println(s.substring(0, i + 1) + " " + isPrefixWord);
      if (isPrefixWord == true) {
        String suffix = s.substring(i + 1);
        boolean isSuffixWord = map.containsKey(suffix);
        System.out.println(s.substring(0, i + 1) + " " + isPrefixWord + " " + suffix + " " + isSuffixWord);
        if (isSuffixWord == true) {
          return true;
        } else {
          if (solve(suffix, map) == true) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String...args) {
    DPWordBreakProblem problem = new DPWordBreakProblem();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    // map.put("these", 1);
    // map.put("the", 1);
    // map.put("xyz", 1);
    // String s = "thesexyz";
    // map.put("i", 1);
    // map.put("like", 1);
    // map.put("sam", 1);
    // map.put("samsung", 1);
    // map.put("sung", 1);
    // String s = "ilikesamsung";
    map.put("a", 1);
    map.put("aa", 1);
    map.put("aaa", 1);
    map.put("aaaa", 1);
    map.put("aaaaa", 1);
    map.put("aaaaaa", 1);
    map.put("aaaaaaa", 1);
    map.put("aaaaaaaa", 1);
    map.put("aaaaaaaaa", 1);
    map.put("aaaaaaaaaa", 1);
    // String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    System.out.println("Possible " + problem.solve(s, map));
  }
}

/*
the sexyz

sexyz


*/