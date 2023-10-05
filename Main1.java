import java.util.Random;

class account {
    private int balance;

    public account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("���������� ������� �� " + amount + ". ������� ������: " + balance);
        notifyAll();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("�������� ���������� �������...");
            wait();
        }

        balance -= amount;
        System.out.println("������ " + amount + " �� �����. �������: " + balance);
    }

    public int getBalance() {
        return balance;
    }
}

public class Main1 {
    public static void main(String[] args) {
        account account = new account(0);

        Thread depositThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int amount = random.nextInt(100);
                account.deposit(amount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start();

        try {
            account.withdraw(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("������� �� �������: " + account.getBalance());
    }
}