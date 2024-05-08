
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientLoader {

    public Client loadClient(String filepath) {
        Client client = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            client = (Client) ois.readObject();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            // Handle the exception (e.g., rethrow or log to a file)
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found while reading from file: " + e.getMessage());
            // Handle the exception (e.g., rethrow or log to a file)
        }
        return client;
    }
}
