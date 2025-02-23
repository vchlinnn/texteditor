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
        if (startGap == endGap) {
            expandBuffer();
        }
    }

    public void expandBuffer() {
        char[] newBuffer = new char[buffer.length * 2];
        for (int i = 0; i < startGap; i++) {
            newBuffer[i] = buffer[i];
        }
        for (int i = endGap; i < buffer.length; i++) {
            newBuffer[i + buffer.length] = buffer[i];
        }
        buffer = newBuffer;
        endGap = buffer.length - 1;
    }

    public void delete() {
        if (startGap > 0) {
            startGap--;
        }
    }

    public int getCursorPosition() {
        return startGap;
    }

    public void moveLeft() {
        if (startGap > 0) {
            buffer[endGap - 1] = buffer[startGap - 1];
            startGap--;
            endGap--;
        }
    }

    public void moveRight() {
        if (endGap < buffer.length - 1) {
            buffer[startGap] = buffer[endGap];
            startGap++;
            endGap++;
        }
    }

    public int getSize() {
        return buffer.length - (endGap + 1 - startGap);
    }

    public char getChar(int i) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return buffer[i];
    }

    public String toString() {
        if (startGap == 0 && endGap == buffer.length - 1) {
            return "";
        } else if (startGap == 0) {
            return (new String(buffer)).substring(endGap);
        } else if (endGap == buffer.length - 1) {
            return (new String(buffer)).substring(0, startGap);
        } else {
            return (new String(buffer)).substring(0, startGap) + (new String(buffer)).substring(endGap);
        }
    }
}
