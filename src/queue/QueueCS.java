import java.util.LinkedList;
import java.util.Queue;

public class QueueCS{
    public static void main(String[] args) {
        Queue<String> antrean = new LinkedList<>();

        //Daftar antrean
        antrean.offer("Andi");
        antrean.offer("Budi");
        antrean.offer("Siti");

        //Menampilkan daftar antrean
        System.out.println("Pelanggan dalam antrean:");
        int nomor = 1;
        for (String nama : antrean) {
            System.out.println(nomor + ". " + nama);
            nomor++;
        }

        //Melayani pelanggan paling depan
        String dilayani = antrean.poll();
        if (dilayani != null) {
            System.out.println("\nMelayani pelanggan: " + dilayani);
        }

        //Menampilkan antrean setelah pelanggan dilayani
        System.out.println("Pelanggan dalam antrean:");
        nomor = 1;
        for (String nama : antrean) {
            System.out.println(nomor + ". " + nama);
            nomor++;
        }
    }
}