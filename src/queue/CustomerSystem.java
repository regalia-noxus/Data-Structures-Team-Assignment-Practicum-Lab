package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class QueueCS {
    Queue<String> antrean = new LinkedList<>();

    public QueueCS() {
        this.antrean = new LinkedList<>();
    }

    // Mendaftar antrean (Enqueue)
    public void tambahAntrean(String nama) {
        antrean.add(nama);
        System.out.println(nama + " berhasil dimasukkan ke dalam antrean.");
    }

    // Memproses antrean terdepan (Dequeue)
    public void prosesAntreanBerikutnya() {
        if (antrean.isEmpty()) {
            System.out.println("Daftar Antrean: Kosong. Tidak ada pelanggan untuk dilayani.");
        } else {
            String dilayani = antrean.poll();
            System.out.println("Melayani pelanggan: " + dilayani);
        }
    }

    // Menampilkan daftar antrean
    public void tampilkanAntrean() {
        if (antrean.isEmpty()) {
            System.out.println("Pelanggan dalam antrean: Kosong");
        } else {
            System.out.println("Pelanggan dalam antrean:");
            int index = 1;
            for (String pelanggan : antrean) {
                System.out.println(index + ". " + pelanggan);
                index++;
            }
        }
    }

    public boolean isEmpty() {
        return antrean.isEmpty();
    }
}

public class CustomerSystem {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        QueueCS manager = new QueueCS();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM MANAJEMEN ANTREAN =====");
            System.out.println("1. Tambah Antrean (Enqueue)");
            System.out.println("2. Proses Antrean Terdepan (Dequeue)");
            System.out.println("3. Tampilkan Semua Antrean");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.next();
                continue;
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama/data antrean: ");
                    String data = scanner.nextLine().trim();
                    if (!data.isEmpty()) {
                        manager.tambahAntrean(data);
                    } else {
                        System.out.println("Data tidak boleh kosong.");
                    }
                    break;
                case 2:
                    manager.prosesAntreanBerikutnya();
                    break;
                case 3:
                    manager.tampilkanAntrean();
                    break;
                case 4:
                    System.out.println("Keluar dari program manajemen antrean.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
            }
        } while (pilihan != 4);
    }
}