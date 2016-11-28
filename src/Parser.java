import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Parser {
    private ArrayList<Long> list;

    public Parser() {
        list = new ArrayList<>();
    }

    public ArrayList parse() {
        File file = new File("src/votes.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (input.hasNextLine()) {
            String nextLine = input.nextLine();
            list.add(Long.valueOf(nextLine));
        }

        input.close();

        return list;
    }


}
