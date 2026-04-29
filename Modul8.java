//Node.java
class Node {
  int data;
  Node left, right;

    Node(int data) {
      this.data = data;
    }

    public void add(int data) {
      if (data > this.data) {
        if (this.right == null) {
          this.right = new Node(data);
        } else this.right.add(data);
      }

      if (data < this.data) {
        if (this.left == null) {
          this.left = new Node(data);
        } else this.left.add(data);
      }
    }
}

//BinaryTree.java
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void add(int data) {
      if (root == null) {
        root = new Node(data);
      return;
      }
     root.add(data);
    }

    public void preTraverse(Node node) {
      if (node == null) return;
      System.out.printf("[%d]", node.data);
      preTraverse(node.left);
      preTraverse(node.right);
    }

    public void inTraverse(Node node) {
      if (node == null) return;
      inTraverse(node.left);
      System.out.printf("[%d]", node.data);
      inTraverse(node.right);
    }

    public void postTraverse(Node node) {
      if (node == null) return;
      postTraverse(node.left);
      postTraverse(node.right);
      System.out.printf("[%d]", node.data);
    }

    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int getHeight(Node node) {

        if (node == null) {
            return 0; 
        }
        
        int tinggiKiri = getHeight(node.left);
        int tinggiKanan = getHeight(node.right);

        return Math.max(tinggiKiri, tinggiKanan) + 1;
    }

    public void levelTraverse(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.printf("[%d] ", current.data);

            if (current.left != null) {
                queue.offer(current.left);
            }
            
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("=== Proses Memasukkan Data ===");
        
        for (int i = 0; i < 10; i++) {
            int nilai = (int) (Math.random() * 100);
            System.out.printf("Nilai %d dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        System.out.println("\nHasil Penelusuran (Traversal)");
        
        System.out.print("Preorder  : ");
        tree.preTraverse(tree.root);
        System.out.println();
        
        System.out.print("Inorder   : ");
        tree.inTraverse(tree.root);
        System.out.println();
        
        System.out.print("Postorder : ");
        tree.postTraverse(tree.root);
        System.out.println();

        System.out.println("");

        int[] dataSimulasi = {42, 87, 15, 63, 9, 91, 28, 74, 5};
        
        for (int nilai : dataSimulasi) {
            tree.add(nilai);
        }
        
        int totalNode = tree.countNodes(tree.root);
        
        System.out.println("Perhitungan Node");
        System.out.println("Total node yang ada di dalam Binary Tree: " + totalNode);

        System.out.println("");

        for (int nilai : dataSimulasi) {
            tree.add(nilai);
        }
        
        int totalDaun = tree.countLeaves(tree.root);
        
        System.out.println("Perhitungan Daun (Leaf)");
        System.out.println("Total daun yang ada di dalam Binary Tree: " + totalDaun);

        System.out.println("");

        for (int nilai : dataSimulasi) {
            tree.add(nilai);
        }
        
        int tinggiPohon = tree.getHeight(tree.root);
        
        System.out.println("Pengukuran Tinggi Binary Tree");
        System.out.println("Tinggi maksimal dari Binary Tree tersebut adalah: " + tinggiPohon);

        System.out.println("");

        for (int nilai : dataSimulasi) {
            tree.add(nilai);
        }
        
        System.out.println("Perbandingan Metode Traversal");
        System.out.print("1. Preorder   : ");
        tree.preTraverse(tree.root);
        System.out.println();
        
        System.out.print("2. Inorder    : ");
        tree.inTraverse(tree.root);
        System.out.println();
        
        System.out.print("3. Postorder  : ");
        tree.postTraverse(tree.root);
        System.out.println();
        
        System.out.print("4. Levelorder : ");
        tree.levelTraverse(tree.root);
        System.out.println();
    }
}

//soal bo. 8 jika diubah menjadi string
//node.java
class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
    }

    public void add(String data) {
        if (data.compareTo(this.data) > 0) {
            if (this.right == null) {
                this.right = new Node(data);
            } else {
                this.right.add(data);
            }
        } 

        else if (data.compareTo(this.data) < 0) {
            if (this.left == null) {
                this.left = new Node(data);
            } else {
                this.left.add(data);
            }
        }
    }
}

//BinaryTree.java
public class BinaryTree {
    Node root;

    public void add(String data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%s] ", node.data); 
        inTraverse(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        System.out.println("=== Memasukkan Data Nama ===");
        String[] nama = {"Griffin", "Maven", "Pictures", "Panji", "Bayu"};
        
        for (String n : nama) {
            System.out.println("Menambahkan: " + n);
            tree.add(n);
        }

        System.out.print("\nHasil Inorder (Urut Abjad): ");
        tree.inTraverse(tree.root);
        System.out.println();
    }
}
