import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueLL {
    Node head;
    Node tail;

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deQueue() {
        if (head == null) {
            System.out.println("null");
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        System.out.println(data);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
        QueueLL queue = new QueueLL();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            queue.enQueue(element);
        }
        System.out.println("Queue:");
        queue.display();

        System.out.print("Dequeue elements:");
        queue.deQueue();
        System.out.println("Queue after dequeuing element:");
        queue.display();
    }

}
