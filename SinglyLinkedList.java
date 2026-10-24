import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    void showUpdatedList() {
        System.out.print("Updated Linked List: ");
        if (head == null) {
            System.out.println("null (empty list)");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // 1. Insert at beginning
    void insertBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        System.out.println("Inserted at beginning: " + value);
        showUpdatedList();
    }
    // 2. Insert at end
    void insertEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
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
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        System.out.println("Inserted " + value +  " at position " + position);
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
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        System.out.println("Inserted " + value + " after " + target);
        showUpdatedList();
    }
    // 5. Insert before a value
    void insertBeforeNode(int target, int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == target) {
            insertBeginning(value);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value not found.");
            return;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
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
        head = head.next;
        showUpdatedList();
    }
    // 7. Delete from end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
            showUpdatedList();
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Deleted: " + temp.next.data);
        temp.next = null;
        showUpdatedList();
    }
    // 8. Delete at position
    void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or empty list.");
            return;
        }
        if (position == 1) {
            deleteBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position not found.");
            return;
        }
        System.out.println("Deleted: " + temp.next.data);
        temp.next = temp.next.next;
        showUpdatedList();
    }
    // 9. Delete by value
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == value) {
            deleteBeginning();
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Value not found.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Deleted: " + value);
        showUpdatedList();
    }
    // 10. Search
    void search(int value) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println(value + " found at position " + position);
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
                System.out.println("Updated " + oldValue + " to " + newValue);
                showUpdatedList();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found.");
    }
    // 12. Display list
    void display() {
        showUpdatedList();
    }
    // 13. Count nodes
    int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    // 14. Find maximum
    void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Maximum: " + max);
    }
    // 15. Find minimum
    void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Minimum: " + min);
    }
    // 16. Find middle element
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
    // 17. Reverse list
    void reverse() {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head = previous;
        System.out.println("List reversed.");
        showUpdatedList();
    }
    // 18. Sort in ascending order
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
    // 19. Remove duplicates
    void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
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
        System.out.println("===== SINGLY LINKED LIST =====");
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
            System.out.println("12. Display list");
            System.out.println("13. Count nodes");
            System.out.println("14. Find maximum");
            System.out.println("15. Find minimum");
            System.out.println("16. Find middle");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove duplicates");
            System.out.println("20. Exit");
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
                    System.out.println("Total nodes: " + list.countNodes());
                    break;
                case 14:
                    list.findMaximum();
                    break;
                case 15:
                    list.findMinimum();
                    break;
                case 16:
                    list.findMiddle();
                    break;
                case 17:
                    list.reverse();
                    break;
                case 18:
                    list.sort();
                    break;
                case 19:
                    list.removeDuplicates();
                    break;
                case 20:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 20);
        sc.close();
    }
}
