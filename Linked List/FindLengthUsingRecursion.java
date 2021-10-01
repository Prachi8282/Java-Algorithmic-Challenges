class FindLengthUsingRecursion {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int length(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + length(current.next);
    }

    static void insert(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            Node newNode = new Node(data);
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }
    }

    public static void main(String[] args) {
        insert(5);
        insert(10);
        insert(15);
        System.out.println("Length is " + length(head));
    }
}