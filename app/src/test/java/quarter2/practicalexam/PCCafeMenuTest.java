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
        input.append("1\n");          // Main menu: Register
        input.append("Bryan\n");      // Username
        input.append("12345\n");      // Password

        // ================================
        // E-WALLET
        // ================================
        input.append("2\n");          // Main menu: E-Wallet
        input.append("1\n");          // Add Money
        input.append("200\n");        // ₱200 top-up
        input.append("3\n");          // Back

        // ================================
        // BUY PC HOURS
        // ================================
        input.append("3\n");          // Main menu: Buy PC Hours
        input.append("1\n");          // ₱15 - 1 Hour
        input.append("6\n");          // Back

        // ================================
        // FOOD AND DRINKS
        // ================================
        input.append("4\n");          // Main menu: Food and Drinks
        input.append("1\n");          // Pancit Canton - ₱30
        input.append("5\n");          // Mountain Dew - ₱20
        input.append("7\n");          // Back

        // ================================
        // LOGIN TO PC
        // ================================
        input.append("5\n");          // Main menu: Login
        input.append("Bryan\n");      // Username
        input.append("12345\n");      // Password

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