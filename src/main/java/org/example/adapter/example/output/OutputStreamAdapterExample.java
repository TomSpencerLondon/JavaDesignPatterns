package org.example.adapter.example.output;

import java.io.*;

// Adaptee: OutputStream (byte-based output)
class ByteStreamDestination {
    public OutputStream getByteStream() throws FileNotFoundException {
        File outputFile = new File("./src/main/java/org/example/adapter/example/output/output.txt");
        return new FileOutputStream(outputFile);
    }
}

// Target Interface: Writer (character-based output)
interface TextWriter {
    void writeText(String text) throws IOException;
}

// Adapter: OutputStreamWriter (adapts character stream to byte stream)
class TextToByteAdapter implements TextWriter {
    private OutputStreamWriter outputStreamWriter;

    // The adapter takes in a byte stream and adapts it to a character stream for writing
    public TextToByteAdapter(OutputStream byteStream, String charsetName) throws UnsupportedEncodingException {
        // OutputStreamWriter adapts OutputStream (byte) to Writer (character)
        this.outputStreamWriter = new OutputStreamWriter(byteStream, charsetName);
    }

    @Override
    public void writeText(String text) throws IOException {
        // Using BufferedWriter to write the character stream
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write(text); // Write the provided text
        writer.newLine(); // Add a newline character
        writer.close(); // Close the streams after writing
        System.out.println("Text written to the adapted byte stream (output.txt).");
    }
}

// Client: Uses the target interface (TextWriter) and expects character-based output
public class OutputStreamAdapterExample {
    public static void main(String[] args) {
        try {
            // Adaptee: ByteStreamDestination provides a byte stream
            ByteStreamDestination byteStreamDestination = new ByteStreamDestination();
            OutputStream byteStream = byteStreamDestination.getByteStream(); // Get byte stream for file output

            // Adapter: TextToByteAdapter converts the character stream to byte stream
            TextWriter textWriter = new TextToByteAdapter(byteStream, "UTF-8");

            // Client: Uses the TextWriter interface to write character data
            String textToWrite = "This text is being written using the Adapter Pattern!";
            textWriter.writeText(textToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

