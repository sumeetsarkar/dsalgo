class Node {
  public String data;
  public Node left, right;
  public  Node(String data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

public class LowestCommonAncestor {

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

  public Node findLCA(Node root, String num1, String num2) {
    if (root == null)
      return null;
    if (num1 == num2)
      return root;
    if (root.data == num1 || root.data == num2) {
      return root;
    }
    Node leftNode = findLCA(root.left, num1, num2);
    Node rightNode = findLCA(root.right, num1, num2);
    if (leftNode == null && rightNode == null)
      return null;
    if (leftNode != null && rightNode != null)
      return root;
    return leftNode == null ? rightNode : leftNode;
  }

  public static void main(String[] args) {
    String[] tree = { "F", "D", "G", "C", "E", "H", "J", "B", "A", null, null, null, "I" };
    LowestCommonAncestor lca = new LowestCommonAncestor();
    Node root = lca.createTree(tree, 0);
    Node lcaNode = lca.findLCA(root, "I", "G");
    System.out.println(lcaNode == null ? null : lcaNode.data);
  }
}
