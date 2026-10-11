package benchmark_runner;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import mahasiswa_linked_list.MahasiswaNode;

// Anggota 4 
// Tugas: Mengukur durasi operasi Queue, Stack, dan Linked List dengan System.nanoTime()
public class BenchmarkRunner {

    // ini variasi jumlah elemen (N) untuk melihat perbandingan efisiensi skala kecil vs besar
    private static final int[] VARIASI_DATA = {1000, 10000};
    
    // jadi jumlah perulangan pencarian data agar durasi pencarian terbaca jelas dalam nanodetik
    private static final int JUMLAH_PENCARIAN = 100;
    
    // ini adalah variabel volatile untuk mencegah optimasi compiler (Dead Code Elimination)
    // agar JVM tidak melewatkan komputasi loop saat proses benchmark
    private static volatile int hasilTerakhir;

    // method utama untuk mengeksekusi seluruh rangkaian pengujian
    public static void run() {
        System.out.println("\n================ HASIL BENCHMARK ================");
        System.out.println("Waktu diukur menggunakan System.nanoTime().");

        // Pemanasan (Warm-up): Menjalankan 1 siklus awal tanpa dicatat agar proses pemuatan class (class loading) tidak memengaruhi akurasi hasil

        jalankanSkenario(1000, false);

        // fungsi disini untuk menjalankan pengujian aktual untuk setiap variasi N (1.000 dan 10.000)
        for (int n : VARIASI_DATA) {
            jalankanSkenario(n, true);
        }

        // ini fungsi pengecekan dummy untuk memastikan hasil komputasi benar-benar dibaca
        if (hasilTerakhir == Integer.MIN_VALUE) {
            System.out.println("Hasil tidak valid.");
        }

        // keterangan teori kompleksitas (Big-O) 
        System.out.println("\nCatatan:");
        System.out.println("- Queue enqueue/dequeue dan Stack push/pop adalah O(1) per operasi.");
        System.out.println("- Linked List insert di awal adalah O(1) per operasi.");
        System.out.println("- Search/update dilakukan pada node terakhir sehingga perlu menelusuri N node (O(n)).");
        System.out.println("- Hasil dapat berbeda pada setiap komputer dan setiap kali program dijalankan.");
    }

    // method pembungkus alias agar tetap bisa dipanggil dengan nama lama dari Main.java
    public static void jalankanUjiWaktu() {
        run();
    }

    // ini fungsi inti untuk mengukur durasi masing-masing operasi struktur data
    private static void jalankanSkenario(int n, boolean tampilkanHasil) {
        
        // --- 1. PENGUJIAN QUEUE (FIFO) ---
        Queue<Integer> queue = new ArrayDeque<Integer>();

        // fungsinya mengukur waktu Enqueue (penambahan elemen ke belakang)
        long mulai = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        long waktuEnqueue = System.nanoTime() - mulai;

        // fungsinya mengukur waktu Dequeue (pengambilan elemen dari depan)
        int nilai = 0;
        mulai = System.nanoTime();
        for (int i = 0; i < n; i++) {
            nilai = queue.poll();
        }
        long waktuDequeue = System.nanoTime() - mulai;
        hasilTerakhir = nilai;


        // --- 2. PENGUJIAN STACK (LIFO) ---
        Stack<Integer> stack = new Stack<Integer>();

        // fungsinya mengukur waktu Push (penambahan elemen ke atas tumpukan)
        mulai = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        long waktuPush = System.nanoTime() - mulai;

        // fungsinya mengukur waktu Pop (pengambilan elemen paling atas)
        mulai = System.nanoTime();
        for (int i = 0; i < n; i++) {
            nilai = stack.pop();
        }
        long waktuPop = System.nanoTime() - mulai;
        hasilTerakhir = nilai;


        // --- 3. PENGUJIAN LINKED LIST MAHASISWA ---
        // Menyiapkan sekumpulan node objek mahasiswa terlebih dahulu
        MahasiswaNode[] dataMahasiswa = new MahasiswaNode[n];
        for (int i = 0; i < n; i++) {
            dataMahasiswa[i] = new MahasiswaNode(buatNim(i), "Mahasiswa " + i, 70);
        }

        // fungsinya mengukur waktu Insert di awal list (Insert at Head) -> Operasi O(1)
        MahasiswaNode head = null;
        mulai = System.nanoTime();
        for (int i = 0; i < n; i++) {
            dataMahasiswa[i].setNext(head);
            head = dataMahasiswa[i];
        }
        long waktuInsert = System.nanoTime() - mulai;

        // fungsinya mengukur waktu Search & Update data pada posisi terjauh Karena data dimasukkan di head, maka NIM pertama (NIM000000) berada di ujung akhir
        // sehingga program dipaksa melakukan penelusuran/traversal penuh (Kasus Terburuk / Worst-Case O(n))
        String nimDicari = buatNim(0);
        mulai = System.nanoTime();
        for (int i = 0; i < JUMLAH_PENCARIAN; i++) {
            cariDanUpdateNama(head, nimDicari, "Nama Update");
        }
        long waktuSearchUpdate = System.nanoTime() - mulai;

        // Menampilkan hasil uji ke tabel jika bukan sesi pemanasan
        if (tampilkanHasil) {
            tampilkanTabel(n, waktuEnqueue, waktuDequeue, waktuPush, waktuPop,
                    waktuInsert, waktuSearchUpdate);
        }
    }

    // fungsi pembantu penelusuran (traversal) Linked List dari head sampai ketemu
    private static boolean cariDanUpdateNama(MahasiswaNode head, String nim, String namaBaru) {
        MahasiswaNode current = head;
        while (current != null) {
            if (current.getNim().equals(nim)) {
                current.setNama(namaBaru);
                hasilTerakhir = current.getNilai();
                return true;
            }
            current = current.getNext(); // Berpindah ke node berikutnya
        }
        return false;
    }

    // fungsi utilitas untuk membuat format string NIM dummy (contoh: NIM000001)
    private static String buatNim(int nomor) {
        return String.format("NIM%06d", nomor);
    }

    // fungsi untuk mencetak kerangka tabel hasil benchmark di layar konsol
    private static void tampilkanTabel(int n, long enqueue, long dequeue, long push,
            long pop, long insert, long searchUpdate) {
        System.out.println("\nN = " + n);
        System.out.println("+---------------------------+------------+----------------+--------------+");
        System.out.println("| Operasi                   | Jumlah Uji | Total (ns)     | Total (detik)|");
        System.out.println("+---------------------------+------------+----------------+--------------+");
        tampilkanBaris("Queue enqueue", n, enqueue);
        tampilkanBaris("Queue dequeue", n, dequeue);
        tampilkanBaris("Stack push", n, push);
        tampilkanBaris("Stack pop", n, pop);
        tampilkanBaris("Linked List insert", n, insert);
        tampilkanBaris("Linked List search/update", JUMLAH_PENCARIAN, searchUpdate);
        System.out.println("+---------------------------+------------+----------------+--------------+");
    }

    // fungsi untuk memformat angka nanodetik dan detik agar lurus dan rapi di tabel
    private static void tampilkanBaris(String operasi, int jumlahUji, long nanodetik) {
        double detik = nanodetik / 1_000_000_000.0;
        System.out.printf("| %-25s | %,10d | %,14d | %12.9f |%n",
                operasi, jumlahUji, nanodetik, detik);
    }
}
