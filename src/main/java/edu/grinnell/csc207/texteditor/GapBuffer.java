package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    char[] buffer;
    int startGap;
    int endGap;

    /**
     * Constructs a new GapBuffer with a default size of 10.
     */
    public GapBuffer() {
        this.buffer = new char[10];
        this.startGap = 0;
        this.endGap = buffer.length;
    }

    /**
     * Inserts a character at the current cursor position.
     * 
     * @param ch the character to insert.
     */
    public void insert(char ch) {
        buffer[startGap] = ch;
        startGap++;
        if (startGap == endGap) {
            expandBuffer();
        }
    }

    /**
     * Expands the buffer by doubling its size.
     */
    public void expandBuffer() {
        char[] newBuffer = new char[buffer.length * 2];
        for (int i = 0; i < startGap; i++) {
            newBuffer[i] = buffer[i];
        }
        for (int i = endGap; i < buffer.length; i++) {
            newBuffer[i + buffer.length] = buffer[i];
        }
        buffer = newBuffer;
        endGap = buffer.length;
    }

    /**
     * Deletes the character at the current cursor position.
     */
    public void delete() {
        if (startGap > 0) {
            startGap--;
        }
    }

    /**
     * Returns the current cursor position.
     * 
     * @return the current cursor position.
     */
    public int getCursorPosition() {
        return startGap;
    }

    /**
     * Moves the cursor one position to the left.
     */
    public void moveLeft() {
        if (startGap > 0) {
            buffer[endGap - 1] = buffer[startGap - 1];
            startGap--;
            endGap--;
        }
    }

    /**
     * Moves the cursor one position to the right.
     */
    public void moveRight() {
        if (endGap < buffer.length) {
            buffer[startGap] = buffer[endGap];
            startGap++;
            endGap++;
        }
    }

    /**
     * Returns the size of the buffer.
     * 
     * @return the size of the buffer.
     */
    public int getSize() {
        return startGap + (buffer.length - endGap);
    }

    /**
     * Returns the character at the specified index.
     * 
     * @param i the index of the character to return.
     * @return the character at the specified index.
     */
    public char getChar(int i) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (i < startGap) {
            return buffer[i];
        } else {
            return buffer[i + (endGap - startGap)];
        }
    }

    /**
     * Returns the buffer as a string.
     * 
     * @return the buffer as a string.
     */
    public String toString() {
        if (startGap == 0 && endGap == buffer.length) {
            return "";
        } else if (startGap == 0) {
            return (new String(buffer)).substring(endGap);
        } else if (endGap == buffer.length) {
            return (new String(buffer)).substring(0, startGap);
        } else {
            return (new String(buffer)).substring(0, startGap) +
                    (new String(buffer)).substring(endGap);
        }
    }
}
