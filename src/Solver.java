import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solver {
    public void solve() {
        WordLoader wordLoader = new WordLoader();
        List<String> list = wordLoader.loadWords("5_letters.csv");
        
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 6; i++) {
            // input
            // check word
            String word = "";
            do {
                System.out.print("Whats your " + i + "st guess: ");
                word = scanner.nextLine();
                if (word.length() != 5 || !list.contains(word)) {
                    System.out.println("Word is not valid");
                }
            } while (word.length() != 5 || !list.contains(word));

            word = word.toLowerCase();

            // check color
            String correctness = "";
            do {
                System.out.println("G = Green Y = Yellow g = grey");
                System.out.print("Whats are the colors (GgYYg): ");
                correctness = scanner.nextLine();

                // need to fix the regex
                if (correctness.length() != 5 || !correctness.matches("[GgY]+")) {
                    System.out.println("Colors is not valid");
                }
            } while (correctness.length() != 5 || !correctness.matches("[GgY]+"));
            

            System.out.println(word + " | " + correctness);

            // process data
            // remove all g, !G, Y[current pos]
            for (int j = 0; j < 5; j++) {
                Character c = word.charAt(j);
                String str = String.valueOf(c);
                int num = j;
                switch (correctness.charAt(j)) {
                    case 'g':
                        list.removeIf(x -> x.contains(str));
                        break;
                    case 'G':
                        list.removeIf(x -> x.charAt(num) != c);
                        break;
                    case 'Y':
                        list.removeIf(x -> x.charAt(num) == c);
                        break;
                }

            }
            
            System.out.println(list.size());
            // list remove
        }
    }
}