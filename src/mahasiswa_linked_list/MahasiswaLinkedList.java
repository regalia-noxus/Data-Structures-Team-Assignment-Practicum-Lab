package mahasiswa_linked_list;

public class MahasiswaLinkedList {
    private MahasiswaNode head;
    public MahasiswaLinkedList() {
        head = null;
    }

    //Menambahkan mahasiswa di akhir daftar.
    public void tambahMahasiswa(String nim, String nama, int nilai) {
        MahasiswaNode current = head;
        //Cek NIM belum digunakan
        while (current != null) {
            if (current.getNim().equals(nim)) {
                System.out.println("NIM sudah terdaftar!");
                return;
            }
            current = current.getNext();
        }
        //Tambah Mahasiswa baru di akhir node
        MahasiswaNode mahasiswaBaru = new MahasiswaNode(nim, nama, nilai);
        if (head == null) {
            head = mahasiswaBaru;
        } else {
            current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(mahasiswaBaru);
        }
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    //Menghapus mahasiswa berdasarkan NIM
    public void hapusMahasiswa(String nim) {
        if (head == null) {
            System.out.println("Daftar mahasiswa masih kosong.");
            return;
        }
        //Cek mahasiswa yang dihapus berada di node pertama
        if (head.getNim().equals(nim)) {
            head = head.getNext();
            System.out.println("Mahasiswa berhasil dihapus.");
            return;
        }
        //Mencari mahasiswa yang akan dihapus berdasarkan NIM
        MahasiswaNode current = head;
        while (current.getNext() != null && !current.getNext().getNim().equals(nim)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
        } else {
            //Menghubungkan node sebelumnya dengan node sesudah yang dihapus
            current.setNext(current.getNext().getNext());
            System.out.println("Mahasiswa berhasil dihapus.");
        }
    }

    //Mengubah nilai mahasiswa berdasarkan NIM
    public void updateNilai(String nim, int nilaiBaru) {
        MahasiswaNode current = head;
        //Mencari mahasiswa berdasarkan NIM
        while (current != null) {
            if (current.getNim().equals(nim)) {
                current.setNilai(nilaiBaru);
                System.out.println("Nilai mahasiswa berhasil diupdate.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Mahasiswa tidak ditemukan.");
    }

    // Menampilkan seluruh data mahasiswa.
    public void tampilkanMahasiswa() {
        if (head == null) {
            System.out.println("Daftar mahasiswa masih kosong.");
            return;
        }
        MahasiswaNode current = head;
        int nomor = 1;
        System.out.println("\nDaftar Mahasiswa:");
        while (current != null) {
            System.out.println(nomor
                    + ". NIM: " + current.getNim()
                    + ", Nama: " + current.getNama()
                    + ", Nilai: " + current.getNilai());
            current = current.getNext();
            nomor++;
        }
    }
}
