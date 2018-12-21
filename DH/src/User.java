
public class User {
    public String name;
    private long P;
    private long A;
    public long Y;
    private long X;
    private long Z;
    private long Y2;

    public User (int P, int A, int X, String name)  //Конструктор класса User
    {
        this.P = P;
        this.A = A;
        this.X = X;
        this.name = name;
    }

    public String countY()
    {
        Y = modular_pow(A, X, P);
        return "\n" + name + " Производит вычисления: " + "Y =" + A + "^" + X + "mod" + P
                + "\n Y = " + Y + "\n";
    }

    public String sendToUser(User sender, User getter, long Y)
    {
        sender.getFromUser(getter, sender, Y);

        return getFromUser(getter, sender, Y);
    }

    public String getFromUser(User getter, User sender, long Y)
    {
        getter.Y2 = Y;
        return sender.name + " Отправил " + Y + "\n" + getter.name + " Получил " + Y;
    }

    public String closedKey()
    {
        Z = modular_pow(Y2, X, P);
        return "\n" + name + " вычислил закрытый ключ: " + Z;
    }

    private long modular_pow(long digit, long power, long modul) // метод для безопасного деления по модулю чисел с большими степенями
    {                              // каждая степень числа делится по модулю
        long c = 1;

        for (int i = 1; i <= power; i++)
        {
            c = (c * digit) % modul;
        }

        return c;
    }

}
