import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Tester {
    @Test
    public void testLoaderSize() {
        WordLoader wordLoader = new WordLoader();
        List<String> list = wordLoader.loadWords("5_letters.csv");
        assertEquals(list.size(), "2499");
    }
}
