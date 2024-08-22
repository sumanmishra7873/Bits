import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class wordcounter {
    private static final String[] STOP_WORDS = { "a", "an", "the", "is", "are", "in", "on", "at", "to", "and" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to input text or '2' to provide a file:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String text = "";

        switch (choice) {
            case 1:
                System.out.println("Enter the text:");
                text = scanner.nextLine();
                break;
            case 2:
                text = readFromFile();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }

        if (text.isEmpty()) {
            System.out.println("No text to count.");
            return;
        }

        // Count words
        int totalCount = countWords(text);
        System.out.println("Total words: " + totalCount);

        // Unique words and their frequencies
        Map<String, Integer> wordFrequencies = getWordFrequencies(text);
        System.out.println("Number of unique words: " + wordFrequencies.size());
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                text.append(fileScanner.nextLine()).append(" ");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting.");
            System.exit(0);
        }
        return text.toString();
    }

    private static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        int count = 0;
        for (String word : words) {
            if (!Arrays.asList(STOP_WORDS).contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    private static Map<String, Integer> getWordFrequencies(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words) {
            if (!Arrays.asList(STOP_WORDS).contains(word.toLowerCase())) {
                wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordFreqMap;
    }
}