public class LinkedList {

    Node head;
    Node tail;
    int length = 0;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Clear the linked list
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    // Add an element to linked list
    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    // Remove last element from linked list
    public Node removeLast() {
        if (length == 0)
            return null;
        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        Node last = tmp.next;
        tail = tmp;
        tail.next = null;
        length--;
        return last;
    }

    // Remove first element from the linked list
    public Node removeFirst() {
        if (length == 0)
            return null;

        Node temp = head;
        head = head.next;
        length--;

        return temp;
    }
    // Get an element at index

    // Set an element at index

    // Search for an element

    // Reverse a linked list

    // Print the elements of linked list
    public String toString() {
        if (length == 0)
            return "";
        Node temp = head;
        StringBuffer buffer = new StringBuffer();
        buffer.append("[" + temp.value + ", ");
        while (temp.next != null) {
            temp = temp.next;
            buffer.append(temp.value + ", ");
        }
        buffer.append("]" + "(" + length + ")");
        return buffer.toString();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.append(1);
        linkedList.append(2);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.append(3);
        System.out.println(linkedList);

        linkedList.clear();
        System.out.println(linkedList);
        linkedList.append(3);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.append(1);
        linkedList.append(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);

    }

}