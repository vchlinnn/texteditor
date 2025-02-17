package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    char[] buffer;
    int startGap;
    int endGap;

    public GapBuffer() {
        this.buffer = new char[10];
        this.startGap = 0;
        this.endGap = buffer.length - 1;
    }

    public void insert(char ch) {
        buffer[startGap] = ch;
        startGap++;
    }

    public void delete() {
        startGap--;
    }

    public int getCursorPosition() {
        return startGap;
    }

    public void moveLeft() {
        buffer[endGap - 1] = buffer[startGap - 1];
        startGap--;
        endGap--;
    }

    public void moveRight() {
        buffer[startGap] = buffer[endGap];
        startGap++;
        endGap++;
    }

    public int getSize() {
        return buffer.length - (endGap - startGap);
    }

    public char getChar(int i) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return buffer[i];
    }

    public String toString() {
        return (new String(buffer)).substring(0, startGap) + (new String(buffer)).substring(endGap);
    }
}
