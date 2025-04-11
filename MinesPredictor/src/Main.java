import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter Client Seed: ");
        String clientSeed = scanner.nextLine();

        System.out.print("Enter Server Seed: ");
        String serverSeed = scanner.nextLine();

        System.out.print("Enter Nonce: ");
        int nonce = scanner.nextInt();

        // Step 2: Combine into message
        String message = clientSeed + "-" + nonce;

        // Step 3: HMAC SHA256
        String hmacResult = null;
        try {
            hmacResult = hmacSHA256(serverSeed, message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("HMAC: " + hmacResult);

        // Step 4: Use result to determine mine positions
        List<Integer> mines = getMinePositions(hmacResult, 5); // Predict 5 mine positions
        System.out.println("Predicted Mine Positions: " + mines);
    }

    // HMAC SHA256
    public static String hmacSHA256(String key, String message) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secretKey);
        byte[] hmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hmac) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Generate mine positions from hex
    public static List<Integer> getMinePositions(String hex, int numberOfMines) {
        List<Integer> positions = new ArrayList<>();
        int gridSize = 25;

        for (int i = 0; positions.size() < numberOfMines && i < hex.length(); i += 2) {
            String byteStr = hex.substring(i, i + 2);
            int val = Integer.parseInt(byteStr, 16);
            int pos = val % gridSize + 1; // Position from 1 to 25

            if (!positions.contains(pos)) {
                positions.add(pos);
            }
        }
        return positions;
    }

}
