class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class AddTwoList {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode result = null, nextChain = null;
    while (l1 != null || l2 != null) {
      int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
      if (sum > 9) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }
      ListNode ln = new ListNode(sum);
      if (result == null) {
        result = nextChain = ln;
      } else {
        nextChain.next = ln;
        nextChain = ln;
      }
      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }

    if (carry > 0) {
      ListNode ln = new ListNode(carry);
      nextChain.next = ln;
      nextChain = ln;
    }

    return result;
  }

  public static void main(String...args) {
    // ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
    // ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
    ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
    ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
    AddTwoList obj = new AddTwoList();
    ListNode ans = obj.addTwoNumbers(l1, l2);
    while(ans != null) {
      System.out.println(ans.val);
      ans = ans.next;
    }
  }
}
