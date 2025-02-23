package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    String text;
    int cursor;

    /**
     * Constructs a new SimpleStringBuffer.
     */
    public SimpleStringBuffer() {
        this.text = "";
        this.cursor = 0;
    }

    /**
     * Inserts a character at the current cursor position.
     *
     * @param ch the character to insert.
     */
    public void insert(char ch) {
        String left = text.substring(0, cursor);
        String right = text.substring(cursor);
        text = left + ch + right;
        cursor++;
    }

    /**
     * Deletes the character to the left of the cursor.
     */
    public void delete() {
        if (cursor > 0) {
            String left = text.substring(0, cursor - 1);
            String right = text.substring(cursor);
            text = left + right;
            cursor--;
        }
    }

    /**
     * Returns the current cursor position.
     *
     * @return the current cursor position.
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * Moves the cursor one position to the left.
     */
    public void moveLeft() {
        if (cursor > 0) {
            cursor--;
        }
    }

    /**
     * Moves the cursor one position to the right.
     */
    public void moveRight() {
        if (cursor < text.length()) {
            cursor++;
        }
    }

    /**
     * Returns the size of the buffer.
     *
     * @return the size of the buffer.
     */
    public int getSize() {
        return text.length();
    }

    /**
     * Returns the character at the specified index.
     *
     * @param i the index of the character to return.
     * @return the character at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public char getChar(int i) {
        if (i < 0 || i >= text.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return text.charAt(i);
    }

    /**
     * Returns the contents of the buffer as a String.
     *
     * @return the contents of the buffer as a String.
     */
    public String toString() {
        return text;
    }
}
