//1. Class & Object

// Mobil.java
public class Mobil {
private String nopol;
private String warna;
private String merk;
private int kecepatan;
private double jarakTempuh;
private int waktu;
private double kecepatanMS;

public void setNopol(String n) {
nopol = n;
}
public void setWarna(String s) {
warna = s;
}
public void setMerk(String m) {
merk = m;
}
public void setKecepatan(int k) {
kecepatan = k;
}
public void setJarakTempuh(double j) {
jarakTempuh = j;
}
public void hitungJarakTempuh(int waktu) {
jarakTempuh = kecepatan * waktu;
}
public void tampilKecepatanMS() {
kecepatanMS = kecepatan * 1000.0 / 3600.0;
System.out.println("Kecepatan dalam m/s: " + kecepatanMS + " m/s");
}

public void display() {
System.out.println("Mobil bermerk " + merk);
System.out.println("bernomor polisi " + nopol);
System.out.println("serta memililki warna " + warna);
System.out.println("bergerak dengan kecepatan " + kecepatan + " kpj");
System.out.println("dan telah menempuh jarak " + jarakTempuh + " km");
}
}

// App.java
import java.util.Scanner;

public class App {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
//instansiasi objek bernama m1
Mobil m1 = new Mobil();
System.out.print("Masukkan merk mobil 1: ");
String inputMerk = input.nextLine();
System.out.print("Masukkan nomor polisi mobil 1: ");
String inputNopol = input.nextLine();

m1.setKecepatan(50);
m1.setMerk(inputMerk);
m1.setNopol(inputNopol);
m1.setWarna("Merah");
m1.setJarakTempuh(30.0);
m1.display();
System.out.println("---------------");
//instansiasi objek bernama m2
Mobil m2 = new Mobil();
m2.setKecepatan(100);
m2.setMerk("Mitsubishi");
m2.setNopol("N 1134 AG");
m2.setWarna("Biru");
m2.display();
System.out.println("---------------");
System.out.println("Atribut pada objek m1 diubah.");
//mengubah warna dari objek m1
m1.setWarna("Hijau");
//menampilkan hasil perubahan
m1.display();
}
}

//2. Konstruktor

// Penerbit.java
public class Penerbit {
    
String nama;
String kota = "Malang";

Penerbit() {
this.nama = "Springer";
}
Penerbit(String nama) {
this.nama = nama;
}
Penerbit(String nama, String kota) {
this.nama = nama;
this.kota = kota;
}
public void display() {
System.out.println("Penerbit " + nama);
System.out.println("di Kota " + kota);
}
}

//PenerbitApp.java
public class PenerbitApp {
public static void main(String[] args) {
Penerbit penerbit = new Penerbit();

penerbit.display();
Penerbit or = new Penerbit("O'Reilly");
or.display();
Penerbit gm = new Penerbit("Gramedia", "Jakarta");
gm.display();
}
}

//3. Variabel Primitif dan Referensi

//Penerbit.java
public class Penerbit {
String nama;
String kota = "Malang";
Penerbit() {
this.nama = "Springer";
}
Penerbit(String nama) {
this.nama = nama;
}
Penerbit(String nama, String kota) {
this.nama = nama;
this.kota = kota;
}
public void display() {
System.out.println("Penerbit " + nama);
System.out.println("di Kota " + kota);
}
}

//Buku.java
public class Buku {
public String judul;
public int halaman;
public String author;
public Penerbit penerbit;
public void display() {
System.out.println("Buku " + judul);
System.out.println("Halaman: " + halaman);
System.out.println("Author : " + author);
penerbit.display();
System.out.println("------------------");
}
}

//BukuApp.java
public class BukuApp {
public static void main(String[] args) {
Penerbit gm = new Penerbit("Gramedia", "Jakarta");
Penerbit sp = new Penerbit("Springer", "New York");
Buku artikel = new Buku();
artikel.judul = "Rahasia OOP";
artikel.halaman = 10;
artikel.author = "John D. Walker";
artikel.penerbit = gm;
Buku paper = new Buku();
paper.judul = "Tips dan Trik Pemrograman Diet";
paper.halaman = 240;
paper.author = "Cydia Lapr";
paper.penerbit = sp;
// ===
artikel.display();
paper.display();
// copy!
artikel.author = paper.author;
artikel.author = "Halu de Luna";
artikel.display();
paper.display();
// copy!
artikel.penerbit = paper.penerbit;
artikel.penerbit.nama = "UB Press";
artikel.display();
paper.display();
}
}
