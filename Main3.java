public class Main3{
    public static void main(String[] args) {
        int money = 15;
        int price = 1;
        int wrap = 3;

        int chocolates = money / price; //  оличество шоколадок, которые можно купить за имеющиес€ деньги
        int wrappers = chocolates; //  оличество оберток, которые останутс€ после покупки шоколадок

        while (wrappers >= wrap) {
            int extraChocolates = wrappers / wrap; //  оличество дополнительных шоколадок, которые можно получить за обертки
            chocolates += extraChocolates; // ”величиваем общее количество шоколадок
            wrappers = wrappers % wrap + extraChocolates; // ќбновл€ем количество оберток по условию задачи
        }

        System.out.println("ћаксимальное количество шоколадок, которые вы можете получить: " + chocolates);
    }
}