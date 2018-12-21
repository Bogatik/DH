

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        int P=0;
        int A= 0;

        int min = 2;

        int x1 = 0;
        int x2 = 0;

        Random random = new Random(System.currentTimeMillis());
        Random random1 = new Random(System.currentTimeMillis());

        try
        {
            FileInputStream fstream = new FileInputStream("Число P.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            List<String> strList = new ArrayList<>();
            String strLine;

            while((strLine = reader.readLine()) != null)
            {
                strList.add(strLine);
            }
            int num = random.nextInt(strList.size()); //num - индекс числа в списке простых чисел
            P = Integer.parseInt(strList.get(num)); // P - число из списка простых по индексу num

            A = min + random.nextInt(P - 1 ); // A - рандомное число 2<A<P

            x1 = ((min + random1.nextInt(P - 1)));
            x2 = ((min + random1.nextInt(P - 1)));
        }
        catch (IOException e)
        {
            System.err.println("Ошибка");
        }

        try (FileWriter writer = new FileWriter("log.txt", false))
        {
            writer.write("X1 = " + x1 + "; X2 = " + x2 + ";\n");
            writer.write("A = " + A + "; \n");
            writer.write("P =" + P + ".");

            User Bob = new User(P, A, x1, "Денис");
            User Alise = new User(P, A, x2, "Настя");

            writer.write(Bob.countY());
            writer.write(Bob.sendToUser(Bob, Alise, Bob.Y)); // Y - открытый ключ

            writer.write(Alise.countY());
            writer.write(Alise.sendToUser(Alise, Bob, Alise.Y));

            writer.write(Bob.closedKey());
            writer.write(Alise.closedKey());

        }
    }

}