import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Possible {
    public static void main(String[] args) {
        System.out.println("Program Started...");

        String filePath = "input.json";  // JSON file in the same directory
        try {
            System.out.println("Reading JSON file...");

            // Read the JSON file as a string
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Debug print JSON content
            System.out.println("JSON Content:\n" + content);

            // Parse JSON
            JSONObject jsonObject = new JSONObject(content);

            // Loop through multiple test cases
            for (String key : jsonObject.keySet()) {
                if (key.equals("keys")) continue; // Skip the keys section

                JSONObject testCase = jsonObject.getJSONObject(key);
                String base = testCase.getString("base");
                String value = testCase.getString("value");

                // Convert value to decimal
                int decimalValue = Integer.parseInt(value, Integer.parseInt(base));
                System.out.println("Test Case " + key + " -> Base: " + base + ", Value: " + value + ", Decimal: " + decimalValue);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error converting base value: " + e.getMessage());
        }

        System.out.println("Program Finished.");
    }
}
