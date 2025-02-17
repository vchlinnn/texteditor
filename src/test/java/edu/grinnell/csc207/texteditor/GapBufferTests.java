package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class GapBufferTests {
    @Test
    public void insertUnitTest() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('a');
        assertEquals("a", buffer.toString());
        assertEquals(1, buffer.getCursorPosition());
        buffer.insert('b');
        assertEquals("ab", buffer.toString());
        assertEquals(2, buffer.getCursorPosition());
    }

    @Test
    public void deleteUnitTest() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.delete();
        assertEquals("a", buffer.toString());
        assertEquals(1, buffer.getCursorPosition());
        buffer.delete();
        assertEquals("", buffer.toString());
        assertEquals(0, buffer.getCursorPosition());
        buffer.delete();
        assertEquals("", buffer.toString());
        assertEquals(0, buffer.getCursorPosition());
    }

    @Test
    public void getCursorPositionUnitTest() {
        GapBuffer buffer = new GapBuffer();
        assertEquals(0, buffer.getCursorPosition());
        buffer.insert('a');
        assertEquals(1, buffer.getCursorPosition());
        buffer.insert('b');
        assertEquals(2, buffer.getCursorPosition());
        buffer.delete();
        assertEquals(1, buffer.getCursorPosition());
    }

    @Test
    public void moveLeftUnitTest() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.moveLeft();
        assertEquals(1, buffer.getCursorPosition());
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
    }

    @Test
    public void moveRightUnitTest() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.moveLeft();
        buffer.moveRight();
        assertEquals(2, buffer.getCursorPosition());
        buffer.moveRight();
        assertEquals(2, buffer.getCursorPosition());
    }

    @Test
    public void getSizeUnitTest() {
        GapBuffer buffer = new GapBuffer();
        assertEquals(0, buffer.getSize());
        buffer.insert('a');
        assertEquals(1, buffer.getSize());
        buffer.delete();
        assertEquals(0, buffer.getSize());
    }

    @Test
    public void getCharUnitTest() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('a');
        buffer.insert('b');
        assertEquals('a', buffer.getChar(0));
        assertEquals('b', buffer.getChar(1));
    }

    @Test
    public void toStringUnitTest() {
        GapBuffer buffer = new GapBuffer();
        assertEquals("", buffer.toString());
        buffer.insert('a');
        buffer.insert('b');
        assertEquals("ab", buffer.toString());
    }

    @Property
    public boolean propertyTest(@ForAll @IntRange(min = 1, max = 100) int size,
            @ForAll char ch) {
        GapBuffer buffer = new GapBuffer();
        for (int i = 0; i < size; i++) {
            buffer.insert(ch);
        }
        return buffer.getSize() == size && buffer.getChar(0) == ch;
    }
}
