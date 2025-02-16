package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    String text;
    int cursor;

    public SimpleStringBuffer() {
        this.text = "";
        this.cursor = 0;
    }

    public void insert(char ch) {
        String left = text.substring(0, cursor);
        String right = text.substring(cursor);
        text = left + ch + right;
        cursor++;
    }

    public void delete() {
        if (cursor > 0) {
            String left = text.substring(0, cursor - 1);
            String right = text.substring(cursor);
            text = left + right;
            cursor--;
        }
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    public void moveRight() {
        throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    public int getSize() {
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    public char getChar(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
