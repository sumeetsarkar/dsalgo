import java.util.HashMap;

public class DPStringInterleaving {

  public boolean isStringInterleaved(String s1, int i, String s2, int j, String s3, HashMap<String, Boolean> map) {
    if (s1.equals("") && s2.equals("") && s3.equals(""))
      return true;
    if (s1.equals("") && s2.equals(s3))
      return true;
    if (s2.equals("") && s1.equals(s3))
      return true;

    Boolean memoResult = map.get(i + ":" + j);
    if (memoResult != null)
      return memoResult;

    boolean path1 = false, path2 = false;

    if (s1.length() > 0 && s1.substring(0, 1).equals(s3.substring(0, 1))) {
      String nextS1 = s1.substring(1, s1.length());
      i = i + 1;
      path1 = isStringInterleaved(nextS1, i, s2, j, s3.substring(1, s3.length()), map);
    }
    if (s2.length() > 0 && s2.substring(0, 1).equals(s3.substring(0, 1))) {
      String nextS2 = s2.substring(1, s2.length());
      j = j + 1;
      path2 = isStringInterleaved(s1, i, nextS2, j, s3.substring(1, s3.length()), map);
    }
    boolean isInterleavePossible = path1 || path2;
    map.put(i + ":" + j, isInterleavePossible);
    return isInterleavePossible;
  }

  public static void main(String...args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";

    // s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
    // s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
    // s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";

    boolean result = false;
    if (s1.length() + s2.length() == s3.length()) {
      DPStringInterleaving obj = new DPStringInterleaving();
      HashMap<String, Boolean> map = new HashMap<String, Boolean>();
      result = obj.isStringInterleaved(s1, 0, s2, 0, s3, map);
    }
    System.out.println(result);
  }
}
