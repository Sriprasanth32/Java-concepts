import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackLL {
    Node head;

    StackLL() {
        head = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        int data = head.data;
        head = head.next;
        System.out.print(data);
    }

    public void peak() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        System.out.println(head.data);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

}

public class StackUsingLL {

    public static void main(String[] args) {
        StackLL stack = new StackLL();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        System.out.println("Stack:");
        stack.display();
        System.out.print("peak element=>");
        stack.peak();

        System.out.print("Popping elements:");

        stack.pop();
        System.out.println();

        System.out.println("Stack after popping:");
        stack.display();
    }
}
