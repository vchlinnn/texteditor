package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * Renders the contents of a GapBuffer to a Screen.
     *
     * @param buf    the GapBuffer to render.
     * @param screen the Screen to render to.
     * @throws IOException
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        // renders the entire GapBuffer to the given screen, calling screen.refresh()
        // to update the display.
        String content = buf.toString();
        for (int i = 0; i < content.length(); i++) {
            screen.setCharacter(i, 0, TextCharacter.fromCharacter(content.charAt(i))[0]);
        }
        screen.refresh();
    }

    /**
     * The main entry point for the TextEditor application.
     *
     * @param args command-line arguments.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        GapBuffer buf = new GapBuffer();
        Path path = Paths.get(args[0]);

        if (Files.exists(path) && Files.isRegularFile(path)) {
            String fileContent = Files.readString(path);
            for (int i = 0; i < fileContent.length(); i++) {
                buf.insert(fileContent.charAt(i));
            }
        }

        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();

        boolean isRunning = true;
        while (isRunning) {
            drawBuffer(buf, screen);
            KeyStroke stroke = screen.readInput();
            KeyType key = stroke.getKeyType();
            if (key.equals(KeyType.Character)) {
                char character = stroke.getCharacter();
                buf.insert(character);
            } else if (key.equals(KeyType.ArrowLeft)) {
                buf.moveLeft();
            } else if (key.equals(KeyType.ArrowRight)) {
                buf.moveRight();
            } else if (key.equals(KeyType.Backspace)) {
                buf.delete();
            } else if (key.equals(KeyType.Escape)) {
                isRunning = false;
            }
        }
        Files.writeString(path, buf.toString());
        screen.stopScreen();
    }
}
