package quarter2.practicalexam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class FastFoodsMenuTest {

    @Test
    public void testFastFoodFlow() {

        String automatedInput = "1\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "3\n";

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.getBytes()
                );

        Scanner scanner = new Scanner(inputStream);

        FastFoodsMenu fastFoodSystem = new FastFoodsMenu();

        fastFoodSystem.start(scanner);
    }
}