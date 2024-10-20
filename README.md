# JavaDesignPatterns

https://capgemini.udemy.com/course/design-patterns-in-java-concepts-hands-on-projects/learn/lecture/9584434#overview


### Adapter Pattern
Example code
![image](https://github.com/user-attachments/assets/e5afbecd-129d-4ec8-a621-7e69fa1c4fdc)

### Java Example
![image](https://github.com/user-attachments/assets/407782dd-141f-4192-99a7-ef58f3874bd2)

Here’s an example of how the **Adapter Pattern** can be implemented using `InputStreamReader` in a real-world scenario, complete with the components of the pattern and comments to clarify how they relate to the Adapter Pattern.

### OutputStreamExample
![image](https://github.com/user-attachments/assets/c112c4ca-811f-4099-8f7c-217ac2b1e5c3)

Here’s an additional example showcasing how `java.io.OutputStreamWriter` can be used as part of the **Adapter Pattern**, similar to the previous example with `InputStreamReader`. In this case, `OutputStreamWriter` adapts a **character stream** (text) to a **byte stream** for writing data.

### Example Code

```java
import java.io.*;

// Adaptee: OutputStream (byte-based output)
class ByteStreamDestination {
    public OutputStream getByteStream() throws FileNotFoundException {
        // Return a byte stream (output to a file in this case)
        return new FileOutputStream("output.txt");
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
    public TextToByteAdapter(OutputStream byteStream, String charsetName) {
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
```

### Explanation

1. **Adaptee (ByteStreamDestination)**:
    - This class provides a **byte stream** (`OutputStream`) via the method `getByteStream()`, writing to a file in this case. It represents the destination where the data is written as bytes, but the client wants to write **text** (characters).

2. **Target Interface (TextWriter)**:
    - This is the **target interface** the client works with. It defines a method `writeText(String text)` for writing text. The client expects to use this interface to write **character streams**.

3. **Adapter (TextToByteAdapter)**:
    - The adapter implements the `TextWriter` interface, allowing the client to write character data. Internally, it uses `OutputStreamWriter` to convert the character stream to a byte stream.
    - The adapter accepts an `OutputStream` (byte-based) and a character encoding like UTF-8 to handle the conversion.

4. **Client (Main Class)**:
    - The `OutputStreamAdapterExample` class (client) interacts with the `TextWriter` interface to write character data.
    - The client is unaware of the byte-based output stream and works only with text.

### Key Points:
- The client needs to write text (characters) to a destination, but the underlying system works with bytes.
- `OutputStreamWriter` adapts the character stream to a byte stream, handling the necessary encoding (e.g., UTF-8).
- The adapter `TextToByteAdapter` bridges the gap between the client and the byte-based output system, allowing the client to use a higher-level interface.

### Output Example:

After running the above code, the text:

```
This text is being written using the Adapter Pattern!
```

will be written to the file `output.txt` in the working directory. The program will output:

```
Text written to the adapted byte stream (output.txt).
```

### Summary:
- In this example, `OutputStreamWriter` plays the role of an adapter by converting a **character stream** (text data) into a **byte stream** that can be written to a file.
- The client (`OutputStreamAdapterExample`) uses a `TextWriter` interface to write character data, but through the `TextToByteAdapter`, it is adapted to write bytes to the destination.