import java.util.Random;

class account {
    private int balance;

    public account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнение баланса на " + amount + ". Текущий баланс: " + balance);
        notifyAll();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("Ожидание пополнения баланса...");
            wait();
        }

        balance -= amount;
        System.out.println("Снятие " + amount + " со счета. Остаток: " + balance);
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

        System.out.println("Остаток на балансе: " + account.getBalance());
    }
}