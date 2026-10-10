package mahasiswa_linked_list;

import java.util.Scanner;

public class MahasiswaApp {
    public static void run(Scanner input) {
        MahasiswaLinkedList daftarMahasiswa = new MahasiswaLinkedList();
        int menuMahasiswa;

        do {
            System.out.println("\n===== MANAJEMEN DATA MAHASISWA =====");
            System.out.println("1. Tambah mahasiswa");
            System.out.println("2. Hapus mahasiswa");
            System.out.println("3. Update nilai mahasiswa");
            System.out.println("4. Tampilkan mahasiswa");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("Pilih menu: ");
            menuMahasiswa = input.nextInt();
            input.nextLine();

            switch (menuMahasiswa) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = input.nextLine();
                    System.out.print("Masukkan nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan nilai: ");
                    int nilai = input.nextInt();
                    input.nextLine();
                    if (nilai < 0 || nilai > 100) {
                        System.out.println("Nilai harus antara 0 sampai 100.");
                    } else {
                        daftarMahasiswa.tambahMahasiswa(nim, nama, nilai);
                    }
                    break;
                case 2:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nimHapus = input.nextLine();
                    daftarMahasiswa.hapusMahasiswa(nimHapus);
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang akan diupdate: ");
                    String nimUpdate = input.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = input.nextInt();
                    input.nextLine();
                    if (nilaiBaru < 0 || nilaiBaru > 100) {
                        System.out.println("Nilai harus antara 0 sampai 100.");
                    } else {
                        daftarMahasiswa.updateNilai(nimUpdate, nilaiBaru);
                    }
                    break;
                case 4:
                    daftarMahasiswa.tampilkanMahasiswa();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (menuMahasiswa != 0);
    }
}
