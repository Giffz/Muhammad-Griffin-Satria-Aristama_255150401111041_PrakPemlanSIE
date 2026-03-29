// method overload
//Tiket.java
public class Tiket {
    protected String namaPenumpang = "Anonim";
    protected String tujuan = "Jakarta";
    protected int jarakTempuh = 750;
    protected double hargaTiket = 250000;

    public void pesan() {}

    public void pesan(String n, String t) {
      this.namaPenumpang = n;
      this.tujuan = t;
      this.jarakTempuh = 90; this.hargaTiket = 55000;
    }

    public void pesan(String n, String t, int j, double h) {
      this.namaPenumpang = n;
      this.tujuan = t;
      this.jarakTempuh = j; this.hargaTiket = h;
    }

    public void tampil() {
      System.out.println("Nama Penumpang: " + this.namaPenumpang);
      System.out.println("Tujuan: " + this.tujuan);
      System.out.println("Jarak Tempuh: " + this.jarakTempuh);
      System.out.println("Harga Tiket: " + this.hargaTiket);
      System.out.println("--------------------");
    }
}

//AgenApp.java
public class AgenApp {
    public static void main(String[] args) {
      Tiket t1 = new Tiket();
      t1.pesan();
      t1.tampil();

      Tiket t2 = new Tiket();
      t2.pesan("Ani", "Bandung");
      t2.tampil();

      Tiket t3 = new Tiket();
      t3.pesan("Cici", "Surabaya", 200, 100000);
      t3.tampil();

      // penambahan statement baru sesuai soal method overload no. 4
      Tiket t4 = new Tiket();
      t4.pesan("Dono", 60);
      t4.tampil(); 
    }
}

//Method Overriding
//TiketBus.java
public class TiketBus extends Tiket {
    @Override
    public void pesan() {
    this.tujuan = "Bandung";
    }

    @Override
    public void pesan(String n, String t) {
      if (t.equals("Makassar")) {
      this.tujuan = "Makassar";
      System.out.println("Maaf " + n + ", tiket tidak dapat dipesan.");
      } 
    }

    @Override
    public void tampil() {
    if (!this.tujuan.equals("Makassar")) {
      super.tampil();
    } else {
      System.out.println("Tiket tujuan Makassar tidak tersedia.");
      System.out.println("--------------------");
      }
    }

    public void pesan(String n) {
        this.namaPenumpang = n; 
    }
}

//AgenBusApp.java
public class AgenBusApp {
  public static void main(String[] args) {
    Tiket t1 = new Tiket();
    t1.pesan();
    t1.tampil();

    TiketBus t2 = new TiketBus();
    t2.pesan();
    t2.tampil();

    TiketBus t3 = new TiketBus();
    t3.pesan("Kasino", "Bandung", 650, 450000);
    t3.tampil();
    t1.pesan("Indro", "Makassar");
    t1.tampil();
    t2.pesan("Dono", "Makassar");
    t2.tampil();

    TiketBus t4 = new TiketBus();
    t4.pesan("Joko");
    t4.tampil();

    TiketBus tKhusus = new TiketBus() {
    @Override
    public void tampil() {
        System.out.println("====================================");
        System.out.println("         E-TICKET BUS ROYAL        ");
        System.out.println("====================================");
        System.out.println(" Nama Penumpang : " + this.namaPenumpang);
        System.out.println(" Kota Tujuan    : " + this.tujuan);
        System.out.println(" Total Bayar    : Rp " + this.hargaTiket);
        System.out.println("====================================");
        System.out.println("Semoga Perjalanan Anda Menyenangkan ");
        System.out.println("====================================\n");
      }
    };
    
    tKhusus.pesan("Griffin", "Malang",400, 150000); 
    tKhusus.tampil();
    }
}


//Polimorfise
//Character.java
public class Character {

    public String name;
    public void doWork() {}
    public void kill(Character ch) {}
    
}

//Crew.java
public class Crew extends Character {

    public Crew(String name) {
      this.name = name;
    }

    @Override
    public void doWork() {
      System.out.println("Crew " + this.name + " is doing work.");
    }

    public void callMeeting() {
      System.out.print(this.name + " found a corpse ");
      System.out.print("and calls a meeting. ");
      System.out.println("Let's find the impostor!");
    }
    
}

//Impostor.java
public class Impostor extends Character {

    public Impostor(Character ch) {
      this.name = ch.name;
    }

    public void kill(Character ch) {
      System.out.println(ch.name + " has been killed!");
    }
    
}

//NonPlayableChar.java
public class NonPlayableChar extends Character {

    public NonPlayableChar(String name) {
        this.name = name;
    }
    
}

//AmongUsGame.java
public class AmongUsGame {
    public static void main(String[] args) {
    // Create references of Character
      Character brian, cindy, david, jacky;

      brian = new Crew("Brian");
      cindy = new Crew("Cindy");
      david = new Crew("David");
      jacky = new Crew("Jacky");

      brian.doWork();
      cindy.doWork();
      david.doWork();
      jacky.doWork();

      jacky = (Character) new Impostor(jacky);

      jacky.kill(cindy);

      if (david instanceof Crew crew)
        crew.callMeeting();

      AmongUsGame.check(brian);
      AmongUsGame.check(david);
      jacky = (Character) new NonPlayableChar(jacky.name);
      AmongUsGame.check(jacky);

    }

    public static void check(Character ch) {
      if (AmongUsGame.isImpostor(ch))
        System.out.println(ch.name + " is the impostor!");
      else System.out.println(ch.name + " is not the impostor.");
    }

    public static boolean isImpostor(Character ch) {
      return (ch instanceof Impostor);
    }
    
}
