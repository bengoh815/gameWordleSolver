import java.util.List;

public class Solver {
    public Solver() {

    }

    public void solve() {
        WordLoader wordLoader = new WordLoader();
        List<String> list = wordLoader.loadWords("5_letters.csv");
        System.out.println(list.size());
    }
}