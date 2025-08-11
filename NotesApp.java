import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "notes.txt";

        System.out.println("Welcome to the Notes App!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Write a note");
            System.out.println("2. Read all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter your note: ");
                String note = scanner.nextLine();
                writeNote(fileName, note);
            } else if (choice == 2) {
                readNotes(fileName);
            } else if (choice == 3) {
                System.out.println("Exiting Notes App. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Hint 1: Use FileWriter to write notes to a file
    public static void writeNote(String fileName, String note) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // true = append mode
            writer.write(note + "\n");
            writer.close();
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Hint 2: Use FileReader or BufferedReader to read notes
    public static void readNotes(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("\nYour Notes:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Try writing one first.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
