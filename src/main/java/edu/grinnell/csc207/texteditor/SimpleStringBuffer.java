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
        if (cursor > 0) {
            cursor--;
        }
    }

    public void moveRight() {
        if (cursor < text.length()) {
            cursor++;
        }
    }

    public int getSize() {
        return text.length();
    }

    public char getChar(int i) {
        if (i < 0 || i >= text.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return text.charAt(i);
    }

    @Override
    public String toString() {
        return text;
    }
}
