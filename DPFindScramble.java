import java.util.Stack;
import java.util.Arrays;

public class DPFindScramble {

  public boolean isScramble(String s1, String s2) {

    System.out.println("***" + s1 + " _" + s2);
    if (s1.length() != s2.length())
      return false;
    if (s1.equals(s2))
      return true;
    if (s1.length() == 1)
      return false;
    if (s1.length() == 2 && s1.equals(new StringBuilder(s2).reverse().toString()))
      return true;
    
    int mid = s1.length() / 2;
    String s1Sub1 = s1.substring(0, mid);
    String s2Sub1 = s2.substring(0, mid);
    boolean isSub1Matching = false;
    System.out.println("_" + s1Sub1 + " _" + s2Sub1);
    if (s1Sub1.equals(s2Sub1)) {
      isSub1Matching = true;
    } else {
      if (s1Sub1.length() == 2) {
        StringBuilder builder = new StringBuilder(s2Sub1);
        s2Sub1 = builder.reverse().toString();
      }
      isSub1Matching = isScramble(s1Sub1, s2Sub1);
    }

    String s1Sub2 = s1.substring(mid, s1.length());
    String s2Sub2 = s2.substring(mid, s2.length());
    boolean isSub2Matching = false;
    System.out.println(">" + s1Sub2 + " >" + s2Sub2);
    if (s1Sub2.equals(s2Sub2)) {
      isSub2Matching = true;
    } else {
      if (s1Sub2.length() == 2) {
        StringBuilder builder = new StringBuilder(s2Sub2);
        s2Sub2 = builder.reverse().toString();
      }
      isSub2Matching = isScramble(s1Sub2, s2Sub2);
    }
    return isSub1Matching && isSub2Matching;
  }

  public static void main(String...args) {
    DPFindScramble obj = new DPFindScramble();
    String s1 = "ab";
    String s2 = "ba";
    System.out.println(obj.isScramble(s1, s2));
  }
}
