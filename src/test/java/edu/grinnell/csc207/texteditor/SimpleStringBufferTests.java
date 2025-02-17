package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.Functions;
import net.jqwik.api.Property;

public class SimpleStringBufferTests {
    @Test
    public void insertUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('a');
        assertEquals("a", buffer.text);
        assertEquals(1, buffer.cursor);
        buffer.insert('b');
        assertEquals("ab", buffer.text);
        assertEquals(2, buffer.cursor);
    }

    @Test
    public void deleteUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.delete();
        assertEquals("a", buffer.text);
        assertEquals(1, buffer.cursor);
        buffer.delete();
        assertEquals("", buffer.text);
        assertEquals(0, buffer.cursor);
    }

    @Test
    public void getCursorPositionUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
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
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.moveLeft();
        assertEquals(1, buffer.cursor);
        buffer.moveLeft();
        assertEquals(0, buffer.cursor);
        buffer.moveLeft();
        assertEquals(0, buffer.cursor);
    }

    @Test
    public void moveRightUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.moveLeft();
        buffer.moveRight();
        assertEquals(2, buffer.cursor);
        buffer.moveRight();
        assertEquals(2, buffer.cursor);
    }

    @Test
    public void getSizeUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        assertEquals(0, buffer.getSize());
        buffer.insert('a');
        assertEquals(1, buffer.getSize());
        buffer.delete();
        assertEquals(0, buffer.getSize());
    }

    @Test
    public void getCharUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        buffer.insert('a');
        buffer.insert('b');
        assertEquals('a', buffer.getChar(0));
        assertEquals('b', buffer.getChar(1));
    }

    @Test
    public void toStringUnitTest() {
        SimpleStringBuffer buffer = new SimpleStringBuffer();
        assertEquals("", buffer.toString());
        buffer.insert('a');
        buffer.insert('b');
        assertEquals("ab", buffer.toString());
    }

}
