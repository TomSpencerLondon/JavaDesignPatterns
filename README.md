# JavaDesignPatterns

https://capgemini.udemy.com/course/design-patterns-in-java-concepts-hands-on-projects/learn/lecture/9584434#overview


### Adapter Pattern
![image](https://github.com/user-attachments/assets/407782dd-141f-4192-99a7-ef58f3874bd2)

Here’s an example of how the **Adapter Pattern** can be implemented using `InputStreamReader` in a real-world scenario, complete with the components of the pattern and comments to clarify how they relate to the Adapter Pattern.

### Example Code

```java
import java.io.*;

// Adaptee: InputStream (byte-based input)
class ByteStreamSource {
    public InputStream getByteStream() throws FileNotFoundException {
        // Return a byte stream (from a file in this case)
        return new FileInputStream("example.txt");
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
    public ByteToTextAdapter(InputStream byteStream, String charsetName) {
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
public class AdapterPatternExample {
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
```

### Explanation

1. **Adaptee (ByteStreamSource)**:
    - This class provides a **byte stream** (`InputStream`) through the method `getByteStream()`. It represents the source that works with **bytes**, which is not suitable for direct text reading.

2. **Target Interface (TextReader)**:
    - This is the **target interface** that the client wants to work with. It defines a method `readText()` for reading text. The client expects to use this interface to work with **character streams** (not bytes).

3. **Adapter (ByteToTextAdapter)**:
    - This class implements the `TextReader` interface (target interface) and internally uses `InputStreamReader` to **adapt** the `InputStream` (byte stream) into a **character stream**.
    - The adapter takes an `InputStream` (byte-based) as a parameter and converts it into characters using `InputStreamReader`, which is part of the Java I/O framework.

4. **Client (Main Class)**:
    - The `AdapterPatternExample` class (client) interacts with the `TextReader` interface to read character data.
    - The client is unaware of the `InputStream` (byte-based) and interacts only with the character-based `TextReader`.

### Key Points:
- The client expects to work with text (character input), but the underlying source is a byte stream. The adapter (`ByteToTextAdapter`) bridges this gap by converting the byte stream to a character stream using `InputStreamReader`.
- `InputStreamReader` internally handles the logic of converting bytes to characters, typically using a specified character encoding like UTF-8.

### Output Example:
If the file `example.txt` contains the following content:
```
Hello, World!
This is an example of the Adapter Pattern in Java.
```

The program will output:
```
Reading text from adapted byte stream:
Hello, World!
This is an example of the Adapter Pattern in Java.
```

This demonstrates how the Adapter Pattern works by converting a byte stream into a character stream so that the client can work with text, even though the underlying data source is in bytes.