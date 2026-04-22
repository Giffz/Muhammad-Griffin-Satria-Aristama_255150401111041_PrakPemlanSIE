//Node.java

class Node {
int data;
Node next;
Node(int data) { this.data = data; }
}

//CustomStack.java
public class CustomStack {
Node top;
int size = 0;
public void push(int x) {
Node n = new Node(x);
n.next = top;
top = n;
size++;
}
public int pop() {
if (top == null)
throw new RuntimeException("Stack is empty.");
int val = top.data;
top = top.next;
size--;
return val;
}
public boolean isEmpty() {
return top == null;
}

public static void main(String[] args) {
        CustomStack mainStack = new CustomStack();
        CustomStack tempStack = new CustomStack();

        mainStack.push(1);
        mainStack.push(2);
        mainStack.push(3);
        mainStack.push(4);

        System.out.println("Menyelipan Angka 5");

        tempStack.push(mainStack.pop()); 
        tempStack.push(mainStack.pop()); 
        tempStack.push(mainStack.pop()); 
        
        mainStack.push(5);
        System.out.println("Angka 5 berhasil diselipkan!");

     
        mainStack.push(tempStack.pop()); 
        mainStack.push(tempStack.pop()); 
        mainStack.push(tempStack.pop()); 

        System.out.println("=================================");

        System.out.print("Isi Stack saat di-pop (Dari atas ke bawah): ");
        while (!mainStack.isEmpty()) {
            System.out.print("[" + mainStack.pop() + "]");
        }
        System.out.println();
    }

   
    public int peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty.");
        }

        return top.data; 
    }
}

//UndoRedo.java
import java.util.Scanner;
import java.util.Stack;

public class UndoRedo {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    public void action(String command) {
        System.out.println("Action: " + command);
        undoStack.push(command);
        redoStack.clear(); // Redo stack dikosongkan setiap ada aksi baru
        UndoRedo.print(undoStack, redoStack);
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            redoStack.push(undoStack.pop());
        }
        UndoRedo.print(undoStack, redoStack);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
        } else {
            undoStack.push(redoStack.pop());
        }
        UndoRedo.print(undoStack, redoStack);
    }

    public static void print(Stack<String> undo, Stack<String> redo) {
        System.out.print("Stack Undo: ");
        for (String s : undo) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("Stack Redo: ");
        for (String s : redo) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        UndoRedo app = new UndoRedo();
        Scanner scanner = new Scanner(System.in);
        String command;
        
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Ketikkan teks sebagai command.");
            System.out.println("Ketik U untuk melakukan Undo");
            System.out.println("Ketik R untuk melakukan Redo");
            System.out.println("Ketik X untuk mengakhiri program.");
            System.out.print("Command: ");
            
            command = scanner.nextLine();
            
            if (command.equalsIgnoreCase("x")) break;
            
            if (command.equalsIgnoreCase("u")) { 
                app.undo(); 
            } else if (command.equalsIgnoreCase("r")) { 
                app.redo(); 
            } else {
                app.action(command);
            }
        }
        scanner.close();
        System.out.println("Program selesai.");
    }
}

//CustomQueue.java
public class CustomQueue {

    private Node head, tail;
    private int size = 0;
    public void enqueue(int x) {

    Node n = new Node(x);

        if (tail != null) tail.next = n;
          tail = n;
        if (head == null) head = tail;
          size++;
    }

    public int dequeue() {
    if (head == null)
      throw new RuntimeException("Queue is empty.");
    int val = head.data;
    head = head.next;
    if (head == null) tail = null;
      size--;
    return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
            return;
        }
    
        Node current = head;
        System.out.print("Isi Queue saat ini: [ ");
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    public int peek() {
        if (head == null) {
            throw new RuntimeException("Queue is empty.");
        }
        return head.data;
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("=== SEBELUM FUNGSI PEEK() ===");
        queue.print();
        System.out.println();
        
        System.out.println("=== MEMANGGIL PEEK() ===");
        System.out.println("Elemen terdepan saat ini adalah: " + queue.peek());
        System.out.println();
        
        System.out.println("=== SESUDAH FUNGSI PEEK() ===");
        queue.print();
    }
}

//Antrian.java
import java.util.LinkedList;
import java.util.Scanner;

public class Antrian {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>(); 
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu Antrian Pelanggan:");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.println("5. Cek Pelanggan Terdepan");
            System.out.print("Pilih (1-5): ");
            
            try {
                int choice = sc.nextInt();
                sc.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Masukan Nama Pelanggan: ");
                        String name = sc.nextLine();
                        
                        if (name.equalsIgnoreCase("Budi")) {
                            queue.addFirst(name); 
                            System.out.println(name + " (VIP) ditambahkan ke antrian paling depan.");
                        } else {
                            queue.offer(name);
                            System.out.println(name + " ditambahkan ke antrian.");
                        }
                        break;
                    case 2:
                        if (queue.isEmpty())
                            System.out.println("Antrian kosong.");
                        else {
                            String nama = queue.poll();
                            System.out.println("Melayani pelanggan : " + nama);
                        }
                        break;
                    case 3:
                        System.out.println("Antrian Saat Ini: " + queue);
                        break;
                    case 4:
                        System.out.println("Keluar.");
                        sc.close();
                        return;
                    case 5:
                        if (queue.isEmpty()) {
                            System.out.println("Tidak ada antrian");
                        } else {
                            System.out.println("Pelanggan terdepan saat ini: " + queue.peek());
                        }
                        break;
                    default:
                        throw new Exception("Invalid input.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.next();
            }
        }
    }
}
