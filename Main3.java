public class Main3{
    public static void main(String[] args) {
        int money = 15;
        int price = 1;
        int wrap = 3;

        int chocolates = money / price; // ���������� ���������, ������� ����� ������ �� ��������� ������
        int wrappers = chocolates; // ���������� �������, ������� ��������� ����� ������� ���������

        while (wrappers >= wrap) {
            int extraChocolates = wrappers / wrap; // ���������� �������������� ���������, ������� ����� �������� �� �������
            chocolates += extraChocolates; // ����������� ����� ���������� ���������
            wrappers = wrappers % wrap + extraChocolates; // ��������� ���������� ������� �� ������� ������
        }

        System.out.println("������������ ���������� ���������, ������� �� ������ ��������: " + chocolates);
    }
}