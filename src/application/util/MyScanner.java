package application.util;

import java.util.Scanner;

public class MyScanner {
    private Scanner scanner = new Scanner(System.in);

    public String line(){
        String line = scanner.nextLine();
        while (line.isEmpty()){
            line = scanner.nextLine();
        }
        return line;
    }
    public int sInt()
    {
        while (!scanner.hasNextInt())
        {
            scanner.next();
        }
        return scanner.nextInt();
    }
    public long sLong()
    {
        while (!scanner.hasNextLong())
        {
            scanner.next();
        }
        return scanner.nextLong();
    }
}
