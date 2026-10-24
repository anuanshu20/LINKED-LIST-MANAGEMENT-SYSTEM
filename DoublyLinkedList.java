import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static class Node {
        int data;
        Node next, prev;
        Node(int data) {
            this.data = data;
        }
    }
    Node head, tail;
    void showUpdatedList() {
        System.out.print("Updated Linked List: ");
        if (head == null) {
            System.out.println("null (empty list)");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // 1. Insert at beginning
    void insertBeginning(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        System.out.println("Inserted at beginning: " + value);
        showUpdatedList();
    }
    // 2. Insert at end
    void insertEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        System.out.println("Inserted at end: " + value);
        showUpdatedList();
    }
    // 3. Insert at position (starting from 1)
    void insertAtPosition(int value, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertBeginning(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }
        if (temp == tail) {
            insertEnd(value);
            return;
        }
        Node node = new Node(value);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        System.out.println("Inserted " + value +
                           " at position " + position);
        showUpdatedList();
    }
    // 4. Insert after a value
    void insertAfterNode(int target, int value) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }
        if (temp == tail) {
            insertEnd(value);
            return;
        }
        Node node = new Node(value);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        System.out.println("Inserted " + value + " after " + target);
        showUpdatedList();
    }
    // 5. Insert before a value
    void insertBeforeNode(int target, int value) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }
        if (temp == head) {
            insertBeginning(value);
            return;
        }
        Node node = new Node(value);
        node.prev = temp.prev;
        node.next = temp;
        temp.prev.next = node;
        temp.prev = node;
        System.out.println("Inserted " + value + " before " + target);
        showUpdatedList();
    }
    // 6. Delete from beginning
    void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Deleted: " + head.data);
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        showUpdatedList();
    }
    // 7. Delete from end
    void deleteEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Deleted: " + tail.data);
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        showUpdatedList();
    }
    // 8. Delete at position
    void deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Invalid position or empty list.");
            return;
        }
        Node temp = head;
        for (int i = 1; i < position && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position not found.");
            return;
        }
        if (temp == head) {
            deleteBeginning();
            return;
        }
        if (temp == tail) {
            deleteEnd();
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Deleted: " + temp.data);
        showUpdatedList();
    }
    // 9. Delete by value
    void deleteByValue(int value) {
        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }
        if (temp == head) {
            deleteBeginning();
            return;
        }
        if (temp == tail) {
            deleteEnd();
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        System.out.println("Deleted: " + value);
        showUpdatedList();
    }
    // 10. Search
    void search(int value) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println(value +
                    " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Value not found.");
    }
    // 11. Update a value
    void update(int oldValue, int newValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                System.out.println("Updated " + oldValue +
                                   " to " + newValue);
                showUpdatedList();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found.");
    }
    // 12. Display forward
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Forward: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // 13. Display backward
    void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Backward: ");
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    // 14. Count nodes
    int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    // 15. Find maximum
    void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        for (Node temp = head.next; temp != null; temp = temp.next) {
            if (temp.data > max) {
                max = temp.data;
            }
        }
        System.out.println("Maximum: " + max);
    }
    // 16. Find minimum
    void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        for (Node temp = head.next; temp != null; temp = temp.next) {
            if (temp.data < min) {
                min = temp.data;
            }
        }
        System.out.println("Minimum: " + min);
    }
    // 17. Find middle
    void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }
    // 18. Reverse
    void reverse() {
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        System.out.println("List reversed.");
        showUpdatedList();
    }
    // 19. Sort in ascending order
    void sort() {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
        System.out.println("List sorted.");
        showUpdatedList();
    }
    // 20. Remove duplicates
    void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    Node duplicate = runner;
                    runner = runner.next;
                    if (duplicate == tail) {
                        tail = duplicate.prev;
                        tail.next = null;
                    } else {
                        duplicate.prev.next = duplicate.next;
                        duplicate.next.prev = duplicate.prev;
                    }
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicates removed.");
        showUpdatedList();
    }
    // Main method
    public static void main(String[] args) {
        Main list = new Main();
        int choice, value, target, position, newValue;
        System.out.println("===== DOUBLY LINKED LIST =====");
        System.out.print("How many elements initially? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            list.insertEnd(sc.nextInt());
        }
        System.out.println("\nInitial list:");
        list.showUpdatedList();
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Insert after a value");
            System.out.println("5. Insert before a value");
            System.out.println("6. Delete from beginning");
            System.out.println("7. Delete from end");
            System.out.println("8. Delete at position");
            System.out.println("9. Delete by value");
            System.out.println("10. Search");
            System.out.println("11. Update a value");
            System.out.println("12. Display forward");
            System.out.println("13. Display backward");
            System.out.println("14. Count nodes");
            System.out.println("15. Find maximum");
            System.out.println("16. Find minimum");
            System.out.println("17. Find middle");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove duplicates");
            System.out.println("21. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertBeginning(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.insertEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.insertAtPosition(value, position);
                    break;
                case 4:
                    System.out.print("Insert after which value? ");
                    target = sc.nextInt();
                    System.out.print("Enter new value: ");
                    value = sc.nextInt();
                    list.insertAfterNode(target, value);
                    break;
                case 5:
                    System.out.print("Insert before which value? ");
                    target = sc.nextInt();
                    System.out.print("Enter new value: ");
                    value = sc.nextInt();
                    list.insertBeforeNode(target, value);
                    break;
                case 6:
                    list.deleteBeginning();
                    break;
                case 7:
                    list.deleteEnd();
                    break;
                case 8:
                    System.out.print("Enter position to delete: ");
                    list.deleteAtPosition(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Enter value to delete: ");
                    list.deleteByValue(sc.nextInt());
                    break;
                case 10:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;
                case 11:
                    System.out.print("Enter old value: ");
                    value = sc.nextInt();
                    System.out.print("Enter new value: ");
                    newValue = sc.nextInt();
                    list.update(value, newValue);
                    break;
                case 12:
                    list.display();
                    break;
                case 13:
                    list.displayBackward();
                    break;
                case 14:
                    System.out.println("Total nodes: " + list.countNodes());
                    break;
                case 15:
                    list.findMaximum();
                    break;
                case 16:
                    list.findMinimum();
                    break;
                case 17:
                    list.findMiddle();
                    break;
                case 18:
                    list.reverse();
                    break;
                case 19:
                    list.sort();
                    break;
                case 20:
                    list.removeDuplicates();
                    break;
                case 21:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 21);
        sc.close();
    }
}
