import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientWriter {

    public boolean writeClient(Client client) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(client.getId() + ".ser"))) {
            oos.writeObject(client);
            return true; // Successfully written the client
        } catch (IOException e) {
            System.err.println("Error writing client to file: " + e.getMessage());
            return false; // Failed to write the client
        }
    }
}
