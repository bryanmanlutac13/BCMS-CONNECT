package quarter2.practicalexam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ArcadeCounterTest {

    @Test
    public void testArcadeFlow() {

        // Reset counter before testing
        ArcadeCounterMenu.counter = 0;

        // Add 10 counters
        // Use 3 counters
        // Check counter
        // Exit
        String input =
                "1\n" +
                        "10\n" +
                        "2\n" +
                        "3\n" +
                        "3\n" +
                        "4\n";

        Scanner scanner = new Scanner(
                new ByteArrayInputStream(input.getBytes())
        );

        ArcadeCounterMenu arcadeSystem = new ArcadeCounterMenu();

        arcadeSystem.start(scanner);

        // Expected: 10 - 3 = 7
        assertEquals(7, ArcadeCounterMenu.counter);
    }
}
