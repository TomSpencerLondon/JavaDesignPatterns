package org.example.structural.adapter.example.input;

import java.io.*;

// Adaptee: InputStream (byte-based input)
class ByteStreamSource {
    public InputStream getByteStream() throws FileNotFoundException {
        // Return a byte stream (from a file in this case)
        File inputFile = new File("./src/main/java/org/example/adapter/example/input/input.txt");

        return new FileInputStream(inputFile);
    }
}

// Target Interface: Reader (character-based input)
interface TextReader {
    void readText() throws IOException;
}

// Adapter: InputStreamReader (adapts byte stream to character stream)
class ByteToTextAdapter implements TextReader {
    private InputStreamReader inputStreamReader;

    // The adapter takes in a byte stream and adapts it to a character stream
    public ByteToTextAdapter(InputStream byteStream, String charsetName) throws UnsupportedEncodingException {
        // InputStreamReader adapts InputStream (byte) to Reader (character)
        this.inputStreamReader = new InputStreamReader(byteStream, charsetName);
    }

    @Override
    public void readText() throws IOException {
        // Using BufferedReader to read the character stream
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line;
        System.out.println("Reading text from adapted byte stream:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // Print each line
        }
        reader.close(); // Close streams after reading
    }
}

// Client: Uses the target interface (TextReader) and expects character input
public class InputStreamAdapterPatternExample {
    public static void main(String[] args) {
        try {
            // Adaptee: ByteStreamSource provides a byte stream
            ByteStreamSource byteStreamSource = new ByteStreamSource();
            InputStream byteStream = byteStreamSource.getByteStream(); // Get byte stream from a file

            // Adapter: ByteToTextAdapter converts the byte stream to character stream
            TextReader textReader = new ByteToTextAdapter(byteStream, "UTF-8");

            // Client: Uses the TextReader interface to read characters
            textReader.readText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

