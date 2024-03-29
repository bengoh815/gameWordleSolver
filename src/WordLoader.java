import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordLoader {
    public List<String> loadWords(String filePath) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = null;
        try {
            File file = new File(filePath);
            scanner = new Scanner(file, "UTF-8");
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                line = line.replaceAll(",", "");
                list.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        return list;
    }
}
