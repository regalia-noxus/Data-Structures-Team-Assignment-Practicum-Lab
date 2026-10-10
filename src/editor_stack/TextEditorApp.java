package editor_stack;

import java.util.Scanner;

public class TextEditorApp {
    public static void run(Scanner input) {
        TextEditor editor = new TextEditor();
        int menuEditor;

        do {
            System.out.println("\n===== EDITOR TEKS (UNDO/REDO) =====");
            System.out.println("1. Tambah teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan teks");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("Pilih menu: ");
            menuEditor = input.nextInt();
            input.nextLine();

            switch (menuEditor) {
                case 1:
                    System.out.print("Masukkan teks yang ingin ditambahkan: ");
                    String teks = input.nextLine();
                    editor.tambahTeks(teks);
                    editor.tampilkanTeks();
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.tampilkanTeks();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            System.out.print("\n");
        } while (menuEditor != 0);
    }
}
