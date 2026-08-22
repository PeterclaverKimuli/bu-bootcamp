import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    private static int skipped = 0;
    private static int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

    public static void main(String[] args) {
        try {
            // Step 1: read scores from file
            ArrayList<Integer> scores = readScores(args[0]);

            // Step 2: calculate statistics
            // get average
            double average = calculateAverage(scores);

            // get min and max
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int score : scores) {
                if (score > max) {
                    max = score;
                }

                if (score < min) {
                    min = score;
                }
            }

            // get grade counts
            for (int score : scores) {
                if (score > 89)
                    countA++;
                else if (score > 79)
                    countB++;
                else if (score > 69)
                    countC++;
                else if (score > 59)
                    countD++;
                else
                    countF++;
            }

            // Step 3: write and print report
            writeReport(scores, average, max, min, "report.txt");
        } catch (Exception e) {
            System.out.println("Please add an input file name.");
        }
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (!line.isEmpty()) {
                    try {
                        int number = Integer.parseInt(line);
                        result.add(number);
                    } catch (NumberFormatException e) {
                        skipped++;
                        System.out.println("Could not read number: " + e.getMessage());
                    }
                } else
                    skipped++;
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return result;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty())
            return 0.0;

        double sum = 0;

        for (int score : scores)
            sum += score;

        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int high, int low,
            String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("=== Grade Analysis Report === %n"));
            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            writer.write(String.format("Invalid lines skipped: %d%n", skipped));
            writer.newLine();

            writer.write(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));
            writer.newLine();

            writer.write(String.format("Grade distribution: %n"));
            writer.write(String.format("    A (90-100): %d%n", countA));
            writer.write(String.format("    B (80-89): %d%n", countB));
            writer.write(String.format("    C (70-79): %d%n", countC));
            writer.write(String.format("    D (60-69): %d%n", countD));
            writer.write(String.format("    F (below 60): %d%n", countF));

        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            System.out.println();

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}