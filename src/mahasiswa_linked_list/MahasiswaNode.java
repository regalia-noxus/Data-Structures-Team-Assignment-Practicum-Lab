package mahasiswa_linked_list;

public class MahasiswaNode {
    private String nim;
    private String nama;
    private int nilai;
    private MahasiswaNode next;

    public MahasiswaNode(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null;
    }

    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getNilai() {
        return nilai;
    }
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
    public MahasiswaNode getNext() {
        return next;
    }
    public void setNext(MahasiswaNode next) {
        this.next = next;
    }
}
