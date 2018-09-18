import java.util.LinkedList;

class Node {
  public String data;
  public Node left, right;
  public  Node(String data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

public class TreeTraversal {

  public void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.printf("%s ", node.data);
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder(Node node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.printf("%s ", node.data);
    inOrder(node.right);
  }

  public void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.printf("%s ", node.data);
  }

  public void levelOrder(Node node) {
    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(node);
    levelOrder_R(queue);
  }

  void levelOrder_R(LinkedList<Node> queue) {
    if (queue.peek() == null)
      return;
    Node node = queue.poll();
    System.out.printf("%s ", node.data);
    if (node.left != null) queue.add(node.left);
    if (node.right != null) queue.add(node.right);
    levelOrder_R(queue);
  }

  public Node createTree(String[] tree, int index) {
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;
    
    Node leftChild = null, rightChild = null;
    if (leftChildIndex < tree.length) {
      leftChild = createTree(tree, leftChildIndex);
    }
    if (rightChildIndex < tree.length) {
      rightChild = createTree(tree, rightChildIndex);
    }

    String data = tree[index];
    if (data != null) {
      return new Node(tree[index], leftChild, rightChild);
    } else {
      return null;
    }
  }

  public static void main(String...args) {
    TreeTraversal tt = new TreeTraversal();
    String[] tree = { "F", "D", "G", "C", "E", "H", "J", "B", "A", null, null, null, "I" };

    Node root = tt.createTree(tree, 0);

    System.out.println("\nPre Order");
    tt.preOrder(root);
    
    System.out.println("\nIn Order");
    tt.inOrder(root);

    System.out.println("\nPost Order");
    tt.postOrder(root);

    System.out.println("\nLevel Order");
    tt.levelOrder(root);
  }
}
