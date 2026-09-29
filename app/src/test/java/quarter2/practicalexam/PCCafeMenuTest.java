package quarter2.practicalexam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class PCCafeMenuTest {

    @Test
    public void testPCCafeSystem() {

        StringBuilder input = new StringBuilder();

        // ================================
        // REGISTER
        // ================================
        input.append("1\n");
        input.append("Bryan\n");
        input.append("12345\n");

        // ================================
        // E-WALLET
        // ================================
        input.append("2\n");
        input.append("1\n");
        input.append("200\n");
        input.append("3\n");

        // ================================
        // BUY PC HOURS
        // ================================
        input.append("3\n");
        input.append("1\n");
        input.append("6\n");

        // ================================
        // FOOD AND DRINKS
        // ================================
        input.append("4\n");
        input.append("1\n");
        input.append("5\n");
        input.append("7\n");

        // ================================
        // LOGIN TO PC
        // ================================
        input.append("5\n");
        input.append("Bryan\n");
        input.append("12345\n");

        // ================================
        // EXIT
        // ================================
        input.append("6\n");

        ByteArrayInputStream simulatedInput =
                new ByteArrayInputStream(
                        input.toString().getBytes()
                );

        Scanner scanner = new Scanner(simulatedInput);

        PCCafeMenu menu = new PCCafeMenu();

        menu.run(scanner);
    }
}