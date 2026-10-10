package editor_stack;

import java.util.Stack;

public class TextEditor {
    private String currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        this.currentText = "";
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    // Menambahkan teks baru
    public void tambahTeks(String teksBaru) {
        undoStack.push(currentText);
        redoStack.clear();
        currentText += teksBaru;
    }

    // Mengembalikan ke kondisi sebelum perubahan
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada riwayat yang bisa di-undo.");
            return;
        }
        redoStack.push(currentText);
        currentText = undoStack.pop();
        System.out.println("Undo: \"" + currentText + "\"");
    }

    // Mengembalikan perubahan yang telah di-undo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada riwayat yang bisa di-redo.");
            return;
        }
        undoStack.push(currentText);
        currentText = redoStack.pop();
        System.out.println("Redo: \"" + currentText + "\"");
    }

    // Menampilkan teks saat ini
    public void tampilkanTeks() {
        System.out.println("Teks saat ini: \"" + currentText + "\"");
    }
}
