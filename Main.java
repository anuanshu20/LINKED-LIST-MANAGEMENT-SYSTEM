import java.util.Scanner;
import java.util.HashSet;
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final SinglyLinkedList singly = new SinglyLinkedList();
    private static final DoublyLinkedList doubly = new DoublyLinkedList();
    public static void main(String[] args) {
        System.out.println("Welcome to Linked List Management System");
        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Both Lists");
            System.out.println("4. Exit");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> singlyMenu();
                case 2 -> doublyMenu();
                case 3 -> compareLists();
                case 4 -> {
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    private static void singlyMenu() {
        while (true) {
            System.out.println("\n--- SINGLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Value");
            System.out.println("5. Insert Before a Value");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Back");
            int c = readInt("Enter choice: ");
            int value, position;
            switch (c) {
                case 1:
                    singly.insertBeginning(readInt("Enter value: "));
                    break;
                case 2:
                    singly.insertEnd(readInt("Enter value: "));
                    break;
                case 3:
                    position = readInt("Enter position (1-based): ");
                    value = readInt("Enter value: ");
                    singly.insertAtPosition(value, position);
                    break;
                case 4:
                    int after = readInt("Insert after which value? ");
                    value = readInt("Enter new value: ");
                    singly.insertAfter(after, value);
                    break;
                case 5:
                    int before = readInt("Insert before which value? ");
                    value = readInt("Enter new value: ");
                    singly.insertBefore(before, value);
                    break;
                case 6:
                    singly.deleteBeginning();
                    break;
                case 7:
                    singly.deleteEnd();
                    break;
                case 8:
                    singly.deleteAtPosition(readInt("Enter position: "));
                    break;
                case 9:
                    singly.deleteByValue(readInt("Enter value: "));
                    break;
                case 10:
                    singly.search(readInt("Enter value to search: "));
                    break;
                case 11:
                    int oldValue = readInt("Enter old value: ");
                    int newValue = readInt("Enter new value: ");
                    singly.update(oldValue, newValue);
                    break;
                case 12:
                    singly.display();
                    break;
                case 13:
                    System.out.println("Node count: " + singly.count());
                    break;
                case 14:
                    singly.findMaximum();
                    break;
                case 15:
                    singly.findMinimum();
                    break;
                case 16:
                    singly.findMiddle();
                    break;
                case 17:
                    singly.reverse();
                    System.out.println("List reversed.");
                    break;
                case 18:
                    singly.sort();
                    System.out.println("List sorted.");
                    break;
                case 19:
                    singly.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;
                case 20:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static void doublyMenu() {
        while (true) {
            System.out.println("\n--- DOUBLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Value");
            System.out.println("5. Insert Before a Value");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Back");
            int c = readInt("Enter choice: ");
            int value, position;
            switch (c) {
                case 1:
                    doubly.insertBeginning(readInt("Enter value: "));
                    break;
                case 2:
                    doubly.insertEnd(readInt("Enter value: "));
                    break;
                case 3:
                    position = readInt("Enter position (1-based): ");
                    value = readInt("Enter value: ");
                    doubly.insertAtPosition(value, position);
                    break;
                case 4:
                    int after = readInt("Insert after which value? ");
                    value = readInt("Enter new value: ");
                    doubly.insertAfter(after, value);
                    break;
                case 5:
                    int before = readInt("Insert before which value? ");
                    value = readInt("Enter new value: ");
                    doubly.insertBefore(before, value);
                    break;
                case 6:
                    doubly.deleteBeginning();
                    break;
                case 7:
                    doubly.deleteEnd();
                    break;
                case 8:
                    doubly.deleteAtPosition(readInt("Enter position: "));
                    break;
                case 9:
                    doubly.deleteByValue(readInt("Enter value: "));
                    break;
                case 10:
                    doubly.search(readInt("Enter value to search: "));
                    break;
                case 11:
                    int oldValue = readInt("Enter old value: ");
                    int newValue = readInt("Enter new value: ");
                    doubly.update(oldValue, newValue);
                    break;
                case 12:
                    doubly.displayForward();
                    break;
                case 13:
                    doubly.displayBackward();
                    break;
                case 14:
                    System.out.println("Node count: " + doubly.count());
                    break;
                case 15:
                    doubly.findMaximum();
                    break;
                case 16:
                    doubly.findMinimum();
                    break;
                case 17:
                    doubly.findMiddle();
                    break;
                case 18:
                    doubly.reverse();
                    System.out.println("List reversed.");
                    break;
                case 19:
                    doubly.sort();
                    System.out.println("List sorted.");
                    break;
                case 20:
                    doubly.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;
                case 21:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private static void compareLists() {
        System.out.println("\n--- SINGLY VS DOUBLY LINKED LIST ----");
        System.out.printf("%-24s | %-23s | %-23s%n",
                "Feature", "Singly", "Doubly");
        System.out.println("----------------------------------------");
        System.out.printf("%-24s | %-23s | %-23s%n",
                "Links per node", "One (next)", "Two (prev and next)");
        System.out.printf("%-24s | %-23s | %-23s%n",
                "Traversal", "Forward", "Forward and backward");
        System.out.printf("%-24s | %-23s | %-23s%n",
                "Memory", "Less", "More");
        System.out.printf("%-24s | %-23s | %-23s%n",
                "Reverse traversal", "Not direct", "Direct");
        System.out.printf("%-24s | %-23s | %-23s%n",
                "Implementation", "Simpler", "More link updates");
    }
}
// ================= SINGLY LINKED LIST =================
class SinglyLinkedList {
    private Node head;
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public void insertBeginning(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        System.out.println("Inserted successfully.");
    }
    public void insertEnd(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = n;
        } else {
            Node t = head;
            while (t.next != null) t = t.next;
            t.next = n;
        }
        System.out.println("Inserted successfully.");
    }
    public void insertAtPosition(int value, int pos) {
        if (pos < 1 || pos > count() + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            insertBeginning(value);
            return;
        }
        Node t = head;
        for (int i = 1; i < pos - 1; i++) t = t.next;
        Node n = new Node(value);
        n.next = t.next;
        t.next = n;
        System.out.println("Inserted successfully.");
    }
    public void insertAfter(int target, int value) {
        Node t = head;
        while (t != null && t.data != target) t = t.next;
        if (t == null) {
            System.out.println("Value not found.");
            return;
        }
        Node n = new Node(value);
        n.next = t.next;
        t.next = n;
        System.out.println("Inserted successfully.");
    }
    public void insertBefore(int target, int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == target) {
            insertBeginning(value);
            return;
        }
        Node t = head;
        while (t.next != null && t.next.data != target) t = t.next;
        if (t.next == null) {
            System.out.println("Value not found.");
            return;
        }
        Node n = new Node(value);
        n.next = t.next;
        t.next = n;
        System.out.println("Inserted successfully.");
    }
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        System.out.println("First node deleted.");
    }
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node t = head;
            while (t.next.next != null) t = t.next;
            t.next = null;
        }
        System.out.println("Last node deleted.");
    }
    public void deleteAtPosition(int pos) {
        if (pos < 1 || pos > count()) {
            System.out.println("Invalid position or empty list.");
            return;
        }
        if (pos == 1) {
            deleteBeginning();
            return;
        }
        Node t = head;
        for (int i = 1; i < pos - 1; i++) t = t.next;
        t.next = t.next.next;
        System.out.println("Node deleted.");
    }
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == value) {
            deleteBeginning();
            return;
        }
        Node t = head;
        while (t.next != null && t.next.data != value) t = t.next;
        if (t.next == null) {
            System.out.println("Value not found.");
            return;
        }
        t.next = t.next.next;
        System.out.println("Value deleted.");
    }
    public void search(int value) {
        Node t = head;
        int pos = 1;
        while (t != null) {
            if (t.data == value) {
                System.out.println("Found at position " + pos);
                return;
            }
            t = t.next;
            pos++;
        }
        System.out.println("Value not found.");
    }
    public void update(int oldValue, int newValue) {
        Node t = head;
        while (t != null) {
            if (t.data == oldValue) {
                t.data = newValue;
                System.out.println("Value updated.");
                return;
            }
            t = t.next;
        }
        System.out.println("Value not found.");
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }
    public int count() {
        int count = 0;
        Node t = head;
        while (t != null) {
            count++;
            t = t.next;
        }
        return count;
    }
    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        for (Node t = head; t != null; t = t.next)
            if (t.data > max) max = t.data;
        System.out.println("Maximum: " + max);
    }
    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        for (Node t = head; t != null; t = t.next)
            if (t.data < min) min = t.data;
        System.out.println("Minimum: " + min);
    }
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }
    public void reverse() {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void sort() {
        for (Node i = head; i != null; i = i.next)
            for (Node j = i.next; j != null; j = j.next)
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
    }
    public void removeDuplicates() {
        HashSet<Integer> seen = new HashSet<>();
        Node current = head, prev = null;
        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next;
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
}
// ================= DOUBLY LINKED LIST =================
class DoublyLinkedList {
    private Node head, tail;

    private static class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
        }
    }
    public void insertBeginning(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        System.out.println("Inserted successfully.");
    }
    public void insertEnd(int value) {
        Node n = new Node(value);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        System.out.println("Inserted successfully.");
    }
    public void insertAtPosition(int value, int pos) {
        if (pos < 1 || pos > count() + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            insertBeginning(value);
            return;
        }
        if (pos == count() + 1) {
            insertEnd(value);
            return;
        }
        Node t = head;
        for (int i = 1; i < pos - 1; i++) t = t.next;
        Node n = new Node(value);
        n.next = t.next;
        n.prev = t;
        t.next.prev = n;
        t.next = n;
        System.out.println("Inserted successfully.");
    }
    public void insertAfter(int target, int value) {
        Node t = head;
        while (t != null && t.data != target) t = t.next;
        if (t == null) {
            System.out.println("Value not found.");
            return;
        }
        if (t == tail) {
            insertEnd(value);
            return;
        }
        Node n = new Node(value);
        n.next = t.next;
        n.prev = t;
        t.next.prev = n;
        t.next = n;
        System.out.println("Inserted successfully.");
    }
    public void insertBefore(int target, int value) {
        Node t = head;
        while (t != null && t.data != target) t = t.next;
        if (t == null) {
            System.out.println("Value not found.");
            return;
        }
        if (t == head) {
            insertBeginning(value);
            return;
        }
        Node n = new Node(value);
        n.prev = t.prev;
        n.next = t;
        t.prev.next = n;
        t.prev = n;
        System.out.println("Inserted successfully.");
    }
    private void unlink(Node t) {
        if (t.prev != null) t.prev.next = t.next;
        else head = t.next;
        if (t.next != null) t.next.prev = t.prev;
        else tail = t.prev;
    }
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        unlink(head);
        System.out.println("First node deleted.");
    }
    public void deleteEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        unlink(tail);
        System.out.println("Last node deleted.");
    }
    public void deleteAtPosition(int pos) {
        if (pos < 1 || pos > count()) {
            System.out.println("Invalid position or empty list.");
            return;
        }
        Node t = head;
        for (int i = 1; i < pos; i++) t = t.next;
        unlink(t);
        System.out.println("Node deleted.");
    }
    public void deleteByValue(int value) {
        Node t = head;
        while (t != null && t.data != value) t = t.next;
        if (t == null) {
            System.out.println("Value not found.");
            return;
        }
        unlink(t);
        System.out.println("Value deleted.");
    }
    public void search(int value) {
        Node t = head;
        int pos = 1;
        while (t != null) {
            if (t.data == value) {
                System.out.println("Found at position " + pos);
                return;
            }
            t = t.next;
            pos++;
        }
        System.out.println("Value not found.");
    }
    public void update(int oldValue, int newValue) {
        for (Node t = head; t != null; t = t.next) {
            if (t.data == oldValue) {
                t.data = newValue;
                System.out.println("Value updated.");
                return;
            }
        }
        System.out.println("Value not found.");
    }
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        for (Node t = head; t != null; t = t.next)
            System.out.print(t.data + " <-> ");
        System.out.println("null");
    }
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        for (Node t = tail; t != null; t = t.prev)
            System.out.print(t.data + " <-> ");
        System.out.println("null");
    }
    public int count() {
        int count = 0;
        for (Node t = head; t != null; t = t.next) count++;
        return count;
    }
    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        for (Node t = head; t != null; t = t.next)
            if (t.data > max) max = t.data;
        System.out.println("Maximum: " + max);
    }
    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        for (Node t = head; t != null; t = t.next)
            if (t.data < min) min = t.data;
        System.out.println("Minimum: " + min);
    }
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }
    public void reverse() {
        Node current = head;
        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }
    public void sort() {
        for (Node i = head; i != null; i = i.next)
            for (Node j = i.next; j != null; j = j.next)
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
    }
    public void removeDuplicates() {
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (seen.contains(current.data)) {
                unlink(current);
            } else {
                seen.add(current.data);
            }
            current = next;
        }
    }
}
