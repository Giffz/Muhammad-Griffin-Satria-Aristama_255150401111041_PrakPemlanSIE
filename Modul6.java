// Subsoal 1 dan 2
// SingleLinkedList
public class SingleLinkedList {

    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();

        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);

        list.addFirst(new Node("A"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addFirst(new Node("B"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addLast(new Node("C"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);
        System.out.println("");

        
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));
        System.out.println("KONDISI AWAL");
        list.printList();
        System.out.println();

        System.out.println("a. Mencari nilai 'B': " + (list.find("B") != null ? "Ditemukan" : "Tidak ditemukan"));
        
        System.out.println("b. Mencari index 2: Data = " + list.getNode(2).data);
        System.out.println();

        System.out.println("c. Menghapus index 1 (B):");
        list.removeAt(1);
        list.printList();
        System.out.println();

        System.out.println("d. Menghapus nilai 'A':");
        list.remove("A");
        list.printList();
        System.out.println();

        System.out.println("e. Menyisipkan 'X' di index 0:");
        list.insertAt(0, new Node("X"));
        list.printList();
        System.out.println();

        System.out.println("f. Menyisipkan 'Y' setelah 'C':");
        list.insertAfter("C", new Node("Y"));
        list.printList();
        System.out.println();

        System.out.println("g. Menyisipkan 'Z' sebelum 'C':");
        list.insertBefore("C", new Node("Z"));
        list.printList();
    }

    void printList() {
        Node current = head;
        System.out.print("Isi List: [ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    
    Node find(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    
    Node getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    void removeAt(int index) {
        if (index < 0 || index >= size) return;
        
        if (index == 0) { 
            head = head.next;
            if (head == null) tail = null; 
        } else {
            Node prev = getNode(index - 1);
            prev.next = prev.next.next;     
            if (prev.next == null) tail = prev; 
        }
        size--;
    }

    void remove(Object value) {
        if (isEmpty()) return;

        if (head.data.equals(value)) {
            removeAt(0);
            return;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(value)) {
                prev.next = current.next;
                if (current.next == null) tail = prev;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    void insertAt(int index, Node newNode) {
        if (index < 0 || index > size) return;
        
        if (index == 0) {
            addFirst(newNode);
        } else if (index == size) {
            addLast(newNode);
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    void insertAfter(Object key, Node newNode) {
        Node current = find(key);
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) tail = newNode; 
            size++;
        } else {
            System.out.println("Node dengan nilai " + key + " tidak ditemukan.");
        }
    }

    void insertBefore(Object key, Node newNode) {
        if (isEmpty()) return;

        if (head.data.equals(key)) {
            addFirst(newNode);
            return;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(key)) {
                newNode.next = current;
                prev.next = newNode;
                size++;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Node dengan nilai " + key + " tidak ditemukan.");
    }

}

//Node.java
public class Node {

    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
    }
    
    public static void main(String[] args) {
        Node node = new Node("A");

        System.out.println("Node: " + node);
        System.out.println("Node data: " + node.data);
        System.out.println("Node next: " + node.next);
    }
}

//Sub Soal 2
// DoubleLinkedList
public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printFromBack() {
        Node current = tail; 
        
        System.out.println("Isi list dari belakang:");
        
        while (current != null) {
            
            System.out.println(current.data);
            
            current = current.prev;
        }
    }

    void printList() {
        Node current = head;
        System.out.print("Isi List: [ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    Node find(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null; 
    }

    Node getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    void removeAt(int index) {
        if (index < 0 || index >= size) return; 
        
        if (index == 0) { 
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; 
        } else if (index == size - 1) { 
            tail = tail.prev;
            tail.next = null;
        } else { 
            Node current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    void remove(Object value) {
        Node current = find(value);
        if (current == null) return; 

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    void insertAt(int index, Node newNode) {
        if (index < 0 || index > size) return;
        
        if (index == 0) {
            addFirst(newNode);
        } else if (index == size) {
            addLast(newNode);
        } else {
            Node current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    void insertAfter(Object key, Node newNode) {
        Node current = find(key);
        if (current != null) {
            if (current == tail) {
                addLast(newNode);
            } else {
                newNode.prev = current;
                newNode.next = current.next;
                current.next.prev = newNode;
                current.next = newNode;
                size++;
            }
        } else {
            System.out.println("Node dengan nilai " + key + " tidak ditemukan.");
        }
    }

    void insertBefore(Object key, Node newNode) {
        Node current = find(key);
        if (current != null) {
            if (current == head) {
                addFirst(newNode);
            } else {
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
                size++;
            }
        } else {
            System.out.println("Node dengan nilai " + key + " tidak ditemukan.");
        }
    }



    public static void main(String[] args) {
        DoubleLinkedList list = 
    new DoubleLinkedList();

    Node nodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");

    list.addLast(nodeA);
    System.out.println("head: " + list.head.data);
    System.out.println("tail: " + list.tail.data);

    list.addLast(nodeB);
    System.out.println("head: " + list.head.data);
    System.out.println("tail: " + list.tail.data);

    list.addLast(nodeC);
    System.out.println("head: " + list.head.data);
    System.out.println("tail: " + list.tail.data);

    list.print();

    System.out.println("Next of B: " + nodeB.next.data);
    System.out.println("Prev of B: " + nodeB.prev.data);

    System.out.println();

    System.out.println("Cetak Maju (Head ke Tail)");
    list.print();

    System.out.println();

    System.out.println("Cetak Mundur (Tail ke Head)");
    list.printFromBack();

    System.out.println("=== KONDISI AWAL ===");
        list.printList();
        System.out.println();

        System.out.println("a. Mencari nilai 'B': " + (list.find("B") != null ? "Ditemukan" : "Tidak ditemukan"));

        System.out.println("b. Mencari index 2: Data = " + list.getNode(2).data);
        System.out.println();

        System.out.println("c. Menghapus index 1 (B):");
        list.removeAt(1);
        list.printList();
        System.out.println();

        System.out.println("d. Menghapus nilai 'A':");
        list.remove("A");
        list.printList();
        System.out.println();

        System.out.println("e. Menyisipkan 'X' di index 0:");
        list.insertAt(0, new Node("X"));
        list.printList();
        System.out.println();

        System.out.println("f. Menyisipkan 'Y' setelah 'C':");
        list.insertAfter("C", new Node("Y"));
        list.printList();
        System.out.println();

        System.out.println("g. Menyisipkan 'Z' sebelum 'C':");
        list.insertBefore("C", new Node("Z"));
        list.printList();
    
    }
}

//Node.java
public class Node {
    Object data;
    Node next, prev;

    Node() {}
    Node(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");

        System.out.println("node : " + nodeA);
        System.out.println("data : " + nodeA.data);
        System.out.println("next : " + nodeA.next);
        System.out.println("prev : " + nodeA.prev);

        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.next = nodeB;
        nodeA.prev = nodeC;

        System.out.println("next data : " + nodeA.next.data);
        System.out.println("prev data : " + nodeA.prev.data);
    }
}
