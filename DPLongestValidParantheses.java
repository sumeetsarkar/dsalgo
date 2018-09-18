import java.util.Stack;
import java.util.Arrays;

public class DPLongestValidParantheses {

  public void longestValidParentheses_R(String s, int index, int[] mem) {
    int i = index;
    int pushIndex = index;
    Stack<Character> stack = new Stack<Character>();
    while(s.length() > i) {
      if (s.charAt(i) == ')') {
        if (stack.empty()) {
          longestValidParentheses_R(s, i + 1, mem);
          break;
        } else if (stack.peek() == '(') {
          stack.pop();
          mem[pushIndex] = mem[pushIndex] + 1;
        }
      } else {
        stack.push(s.charAt(i));
      }
      i++;
    }
    if (!stack.empty()) {
      mem[pushIndex] = 0;
    }
  }

  public int longestValidParentheses(String s) {
    int[] mem = new int[s.length()];
    longestValidParentheses_R(s, 0, mem);
    printMem(mem);
    Arrays.sort(mem);
    return mem.length > 0 ? mem[mem.length - 1] : 0;
  }

  void printMem(int[] mem) {
    for (int i : mem) {
      System.out.printf("%d ", i);
    }
    System.out.println();
  }

  public static void main(String...args) {
    DPLongestValidParantheses obj = new DPLongestValidParantheses();
    String s = ")()()))()";
    System.out.println(obj.longestValidParentheses(s));
  }
}
