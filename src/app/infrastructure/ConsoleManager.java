package app.infrastructure;

import java.util.Scanner;

//TODO: Продумать абстракцию получше
public class ConsoleManager implements IOManager {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public void output(String content) {
        System.out.println(content);
    }
}
