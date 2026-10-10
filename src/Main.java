import java.util.Scanner;
import mahasiswa_linked_list.MahasiswaApp;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        do {
            System.out.println("\n===== DATA STRUCTURES =====");
            System.out.println("1. Sistem Antrean (Queue)");
            System.out.println("2. Editor Teks Undo/Redo (Stack)");
            System.out.println("3. Manajemen Mahasiswa (Linked List)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();
            input.nextLine();

            //Pilih kasus yang akan dijalankan.
            switch (menu) {
                case 1:
                    System.out.println("Program Queue belum diimplementasikan.");
                    break;
                case 2:
                    System.out.println("Program Stack belum diimplementasikan.");
                    break;
                case 3:
                    MahasiswaApp.run(input);
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (menu != 0);
        input.close();
    }
}
