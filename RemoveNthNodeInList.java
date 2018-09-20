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
  
public class RemoveNthNodeInList {
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = head;
    ListNode itemToDelete = temp;
    int counter = 1;
    // get the itemToDelete
    while(temp != null) {
      if (counter >= n && temp.next != null) {
        itemToDelete = itemToDelete.next;
      }
      counter++;
      temp = temp.next;
    }
    // if itemToDelete is null, means it is the first item
    // as it is pushed in each node traversal
    if (itemToDelete == null) {
      head = head.next;
    
    // if itemToDelete.next != null then it is intermediate item
    } else if (itemToDelete.next != null) {
      itemToDelete.val = itemToDelete.next.val;
      itemToDelete.next = itemToDelete.next.next;
    
    // if itemToDelete.next == null then it is last item
    } else if (itemToDelete.next == null) {
      temp = head;
      while (temp != null) {
        if (temp.next != null && temp.next.next == null) {
          temp.next = null;
          break;
        }
        // if item is last item, but list has only item
        if (temp.next == null) {
          head = null;
          break;
        }
        temp = temp.next;
      }
    }
    return head;
  }

  public static void main(String...args) {
    ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    // ListNode l1 = new ListNode(1, null);
    RemoveNthNodeInList obj = new RemoveNthNodeInList();
    ListNode ans = obj.removeNthFromEnd(l1, 1);
    while(ans != null) {
      System.out.printf("%d ", ans.val);
      ans = ans.next;
    }
  }
}
