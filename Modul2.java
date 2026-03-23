// Lingkaran.java
public class Lingkaran {
    public static float PI = 3.14f;
    public float r; 
    
    public Lingkaran(float r) {
        this.r = r; 
    }

    public float luas() {
        return Lingkaran.PI * r * r; 
    }

    public float keliling() {
        return 2 * Lingkaran.PI * r; 
    }
}

// GeometriApp.java
public class GeometriApp {
    public static void main(String[] args) {
        Lingkaran lingKecil = new Lingkaran(2.0f);
        Lingkaran lingBesar = new Lingkaran(11.0f);

        float kK = lingKecil.keliling();
        float kB = lingBesar.keliling();

        System.out.println("Keliling Lingkaran Kecil: " + kK);
        System.out.println("Keliling Lingkaran Besar: " + kB);
    }
}

// Student.java
public class Student {
    private String nama; 
    private int skor; 

    public Student(String nama) {
        this.nama = nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public void gantiNama(String namaBaru) {
        this.setNama(namaBaru); 
    }

    public String getNama() {
        return this.nama;
    }

    public int getSkor() {
        return this.skor;
    }

    public static void setNama(Student std, String nama) {
        std.nama = nama;
    }
}

// SchoolApp.java
public class SchoolApp {
    public static void main(String[] args) {
        Student miki = new Student("Miki");
        Student mini = new Student("Mini");

        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());

        mini.gantiNama("Mono");

        Student.setNama(miki, "Kiki"); 

        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());
    }
}
