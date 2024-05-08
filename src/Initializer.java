import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Initializer {

    public static final double SAVINGS_BONUS = 100.00; // Placeholder for savings bonus

    public static void main(String[] args) {
        // Set the look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace(); // You could handle the exception differently if needed
        }

        // Initialize and show the main application window
        SwingUtilities.invokeLater(() -> {
            // This is where you would create your initial Client object.
            // Since the implementation is not provided in the screenshot, a placeholder is used.
            // Please replace this with your actual client initialization code.
            
            
            FormWindow formWindow = new FormWindow();
            formWindow.setVisible(true);
        });
    }
}
