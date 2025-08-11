import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";
        int choice;

        do {
            System.out.println("\n1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete All Notes");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) { // Add note
                System.out.print("Enter note: ");
                String note = sc.nextLine();
                FileWriter fw = new FileWriter(fileName, true);
                fw.write(note + "\n");
                fw.close();
                System.out.println("Note saved!");
            }
            else if (choice == 2) { // View notes
                File file = new File(fileName);
                if (file.exists()) {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("- " + line);
                    }
                    br.close();
                } else {
                    System.out.println("No notes found.");
                }
            }
            else if (choice == 3) { // Delete all notes
                File file = new File(fileName);
                if (file.exists() && file.delete()) {
                    System.out.println("All notes deleted.");
                } else {
                    System.out.println("No notes to delete.");
                }
            }
        } while (choice != 4);

        sc.close();
    }
}
