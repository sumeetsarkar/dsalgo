public class Heap {

  private int[] arr;
  private int capacity;
  private int size;

  public Heap(int capacity) {
    this.capacity = capacity;
    this.arr = new int[capacity];
    this.size = 0;
  }
  
  private int getLeftChildIndex(int index) { return (2 * index) + 1; }
  private int getRightChildIndex(int index) { return (2 * index) + 2; }
  private int getParentIndex(int index) { return (index - 1) / 2; }

  private boolean hasRightChild(int index) { return getLeftChildIndex(index) < size; }
  private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
  private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

  private int getLeftChild(int index) { return arr[getLeftChildIndex(index)]; }
  private int getRightChild(int index) { return arr[getRightChildIndex(index)]; }
  private int getParent(int index) { return arr[getParentIndex(index)]; }

  public int peek() {
    return size > 0 ? arr[0] : Integer.MIN_VALUE;
  }
  
  public void push(int val) {
    if (size < capacity) {
      arr[size] = val;
      size++;
      heapifyUp();
    }
  }

  public int poll() {
    int polledValue = Integer.MIN_VALUE;
    if (size > 0) {
      polledValue = arr[0];
      arr[0] = arr[size - 1];
      size--;
      heapifyDown();
    }
    return polledValue;
  }

  public void heapifyUp() {
    int index = size - 1;
    while(hasParent(index) && getParent(index) > arr[index]) {
      int temp = getParent(index);
      arr[getParentIndex(index)] = arr[index];
      arr[index] = temp;
      index = getParentIndex(index);
    }
  }

  public void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
        smallChildIndex = getRightChildIndex(index);
      }
      if (arr[index] < arr[smallChildIndex]) {
        break;
      } else {
        int temp = arr[index];
        arr[index] = arr[smallChildIndex];
        arr[smallChildIndex] = temp;
        index = smallChildIndex;
      }
    }
  }

  public void display() {
    for (int i = 0; i < this.size; i ++) {
      System.out.printf("%d, lc: %d, rc: %d\n",
        this.arr[i],
        hasLeftChild(i) ? getLeftChild(i) : Integer.MIN_VALUE,
        hasRightChild(i) ? getRightChild(i) : Integer.MIN_VALUE);
    }
  }

  public static void main(String...args) {
    int[] arr = { 19, 3, 56, 8, 21, 5, 30 };
    Heap heap = new Heap(7);
    for (int i : arr) {
      heap.push(i);
    }
    heap.display();
    heap.poll();
    heap.poll();
    heap.display();
  }
}
