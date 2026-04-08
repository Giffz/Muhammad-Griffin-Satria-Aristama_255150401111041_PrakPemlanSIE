//Soal Abstract
//Emoney.java
public abstract class Emoney {
    protected double balance;
    protected String name;

    public abstract void topUp(double amount);
    public abstract void pay(double amount);

    public void balance() {
      System.out.print(this.name + " balance: ");
      System.out.println(String.valueOf(this.balance));
    }
}

//Opo.java
public class Opo extends Emoney {
    public Opo() { this.name = "Opo"; }

    @Override
    public void topUp(double amount) {
      System.out.println("Top up: " + amount);
      this.balance += amount;
      this.balance();
    }

    @Override
    public void pay(double amount) {
      double amountToPay = amount - (0.1 * amount);
      if (this.balance > amountToPay) {
        this.balance -= amountToPay;
        System.out.printf("Pay " + amount);
        System.out.println(" using " + this.name);
      } else System.out.println("Not enough balance.");
        this.balance();
    }
}

//Shopipay.java
public class ShopiPay extends Emoney {
    public ShopiPay() { this.name = "ShopiPay"; }

    @Override
    public void topUp(double amount) {
      System.out.println("Top up: " + amount);
      this.balance += (amount + (0.05 * amount));
      this.balance();
    }

    @Override   
    public void pay(double amount) {
      if (this.balance > amount) {
        this.balance -= amount;
        System.out.printf("Pay " + amount);
        System.out.println(" using " + this.name);
      } else System.out.println("Not enough balance.");
        this.balance();
    }
}

//Kris.java
public class Kris extends Emoney {
    
    public Kris() { 
        this.name = "Kris"; 
    }

    @Override
    public void topUp(double amount) {
        System.out.println("Top up: " + amount);
        this.balance += (amount + (0.05 * amount));
        this.balance();
    }

    @Override
    public void pay(double amount) {
        double amountToPay = amount - (0.03 * amount);
        
        if (this.balance > amountToPay) {
            this.balance -= amountToPay;
            System.out.printf("Pay " + amount);
            System.out.println(" using " + this.name);
        } else {
            System.out.println("Not enough balance.");
        }
        this.balance();
    }
}

//Customer.java
public class Customer {
    private final Emoney account;

    public Customer(Emoney account) {
      this.account = account;
    }

    public void pay(double amount) {
      this.account.pay(amount);
    }

    public void deposit(double amount) {
      this.account.topUp(amount);
    }

    public void getMoney() {
      this.account.balance();
    }
}

//Shopipedia.java
public class Shopipedia {
public static void main(String[] args) {
    
ShopiPay shopiCard = new ShopiPay();
Customer miki = new Customer(shopiCard);
miki.deposit(10000);
miki.pay(2000);
miki.pay(3000);
miki.deposit(1000);
miki.pay(7000);

System.out.println("------------------");

Opo opoCard = new Opo();
Customer dono = new Customer(opoCard);
dono.deposit(10000);
dono.pay(2000);
dono.pay(3000);
dono.deposit(1000);
dono.pay(7000);

System.out.println("--------------------");

Kris kris = new Kris();
Customer joko = new Customer(kris);

joko.deposit(10000);
joko.pay(2000);
joko.pay(3000);
joko.deposit(1000);
joko.pay(7000);

Emoney krisCard = new Emoney() {
    
    {
        this.name = "Kris";
    }

    @Override
    public void topUp(double amount) {
        System.out.println("Top up: " + amount);
        this.balance += (amount + (0.05 * amount));
        this.balance();
    }

    @Override
    public void pay(double amount) {
        double amountToPay = amount - (0.03 * amount);
        
        if (this.balance > amountToPay) {
            this.balance -= amountToPay;
            System.out.printf("Pay " + amount);
            System.out.println(" using " + this.name);
        } else {
            System.out.println("Not enough balance.");
        }
        this.balance();
    }
};

System.out.println("--------------------");
Customer budi = new Customer(krisCard);

budi.deposit(10000);
budi.pay(2000);
budi.pay(3000);
budi.deposit(1000);
budi.pay(7000);
}
}

// Package BangunDatar soal no. 5 Abstract Class
//BangunDatar.java
public abstract class BangunDatar {
    public abstract double hitungLuas(); 
}

//Persegi.java
class Persegi extends BangunDatar {
    double sisi;
    Persegi(double s) { this.sisi = s; }

    @Override
    public double hitungLuas() {
    return sisi * sisi;
    }
}

//Lingkaran.java
public class Lingkaran extends BangunDatar {
    double jariJari;
    Lingkaran(double r) { this.jariJari = r; }

    @Override
    public double hitungLuas() {
    return 3.14 * jariJari * jariJari;
    }
}

//Main.java
public class Main {
    public static void main(String[] args) {
        BangunDatar kotak = new Persegi(5);
        BangunDatar koin = new Lingkaran(10);

        System.out.println("Luas Kotak: " + kotak.hitungLuas());
        System.out.println("Luas Koin: " + koin.hitungLuas());
    }
}

//Soal Interface
//ICrew
public interface ICrew {
void doWork();
String getName();
void kick();
}

//IImpostor
public interface IImpostor extends ICrew {
void kill(ICrew crew);
}

//Crew.java
public class Crew implements ICrew {
private String name;
private boolean isDead = false;

public Crew(String name) {
this.name = name;
}
@Override
public void doWork() {
System.out.println("Crew " + this.name + " is doing work.");
}
@Override
public String getName() {
return this.name;
}
public void callMeeting() {
if (this.isDead) {
System.out.println(this.name + " cannot call a meeting because they are dead!");
} else {
System.out.print(this.name + " found a corpse ");
System.out.print("and calls a meeting. ");
System.out.println("Let's find the impostor!");
}
}

public void setDead() {
this.isDead = true;
}

@Override
public void kick() {
System.out.println("Crew " + this.name + " was ejected.");
System.out.println(this.name + " was not An Impostor.");
}
}

//Impostor.java
public class Impostor implements IImpostor, ICrew {
private final String name;
public Impostor(String name) {
this.name = name;
}
@Override
public void kill(ICrew crew) {
System.out.println(crew.getName() + " has been killed!");
if (crew instanceof Crew) {
((Crew) crew).setDead();
}
}
@Override
public void doWork() {
System.out.println("Impostor " + this.name + " is doing work.");
}
@Override
public String getName() {
return this.name;
}

@Override
public void kick() {
System.out.println("Impostor " + this.name + " was ejected.");
System.out.println(this.name + " was An Impostor!");
}
}

//AmongUsGame.java
public class AmongUsGame {
public static void main(String[] args) {
Crew brian, cindy, david;
Impostor jacky;
brian = new Crew("Brian");
cindy = new Crew("Cindy");
david = new Crew("David");
jacky = new Impostor("Jacky");
brian.doWork();
cindy.doWork();
david.doWork();
jacky.doWork();
jacky.kill(cindy);
cindy.callMeeting(); //tes crew mati call meeting
david.callMeeting();
AmongUsGame.check(brian);
AmongUsGame.check(david);
AmongUsGame.check(jacky);
}
public static void check(ICrew crew) {
if (AmongUsGame.isImpostor(crew))
System.out.println(crew.getName() + " is the impostor!");
else System.out.println(crew.getName() + " is not the impostor.");
}
public static boolean isImpostor(ICrew crew) {
return (crew instanceof Impostor);
}
}
