import javax.swing.*;
import java.util.Random;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormWindow extends JFrame {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextPane detailsPane;
    private JTree portfoliosTree;
    private JTextPane additionalInfoPane;

    public FormWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Client Portfolio Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Top panel for input fields and update button
        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Client"));

        firstNameField = new JTextField(20);

        inputPanel.add(new JLabel("First Name"));
        inputPanel.add(firstNameField);
        JLabel label = new JLabel("Last Name");
        inputPanel.add(label);
        JButton updateButton = new JButton("Save Client");
        
        updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 Random random = new Random();
			    // Code to update the JTextPane with new information
			    updateDetailsPane();
			    
			    

			    // Get the current tree model
			    DefaultTreeModel treeModel = (DefaultTreeModel) portfoliosTree.getModel();
			    DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();

			    // Add new nodes to the tree
			    DefaultMutableTreeNode retirement = new DefaultMutableTreeNode("Retirement ($3180.0)");
			    retirement.add(new DefaultMutableTreeNode("T001 ($100.0)"));
			    retirement.add(new DefaultMutableTreeNode("T002 ($130.0)"));
			    retirement.add(new DefaultMutableTreeNode("T003 ($900.0)"));
			    retirement.add(new DefaultMutableTreeNode("T004 ($650.0)"));
			    retirement.add(new DefaultMutableTreeNode("T006 ($400.0)"));
			    retirement.add(new DefaultMutableTreeNode("A1000 ($1000.0)"));

			    DefaultMutableTreeNode test = new DefaultMutableTreeNode("Test ($1337.0)");
			    test.add(new DefaultMutableTreeNode("C0001 ($1337.0)"));

			    DefaultMutableTreeNode operations = new DefaultMutableTreeNode("Operations ($10000.0)");
			    operations.add(new DefaultMutableTreeNode("OPS001 ($10000.0)"));

			    // Clear previous content and add new portfolios
			    root.removeAllChildren(); // Clear existing nodes
			    root.add(retirement);
			    root.add(test);
			    root.add(operations);

			    // Refresh the tree to reflect the changes
			    treeModel.reload();
			    
			 // Update additional information pane
                String additionalInfo = String.format(
                    "Adding Portfolio: Retirement ($%.2f)\n" +
                    "Adding Account: T001, T002, T003, T004, T006, A1000\n" +
                    "Adding Portfolio: Operations ($%.2f)\n" +
                    "Adding Account: OPS001",
                    random.nextDouble() * 100000, // Randomized values for portfolios and accounts
                    random.nextDouble() * 100000
                );

                additionalInfoPane.setText(additionalInfo); 
			    
			}

        });
        updateButton.setBackground(Color.GRAY);
        updateButton.setPreferredSize(new Dimension(38, 20));
        updateButton.addActionListener(e -> updateDetailsPane());

        topPanel.add(inputPanel);
        lastNameField = new JTextField(20);
        inputPanel.add(lastNameField);
        
        inputPanel.add(lastNameField);
        JLabel label_1 = new JLabel("Phone Number");
        inputPanel.add(label_1);
        phoneField = new JTextField(20);
        inputPanel.add(phoneField);
        topPanel.add(updateButton);

        getContentPane().add(topPanel, BorderLayout.NORTH);

        // SplitPane for JTree on the left and JTextPane on the right
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(250); // Divider location for JTree
        splitPane.setResizeWeight(0.3); // Keep 30% space for JTree

        // JTree setup
        portfoliosTree = new JTree(new DefaultTreeModel(new DefaultMutableTreeNode("Portfolios")));
        portfoliosTree.setBorder(BorderFactory.createTitledBorder("Portfolios"));
        JScrollPane treeScrollPane = new JScrollPane(portfoliosTree);
        splitPane.setLeftComponent(treeScrollPane);

        // JTextPane setup
        detailsPane = new JTextPane();
        detailsPane.setBorder(BorderFactory.createTitledBorder("Client Details"));
        detailsPane.setEditable(false);
        JScrollPane detailsScrollPane = new JScrollPane(detailsPane);
        JScrollPane additionalScrollPane = new JScrollPane(); 

        getContentPane().add(splitPane, BorderLayout.CENTER);
        JPanel clientPanel = new JPanel(new BorderLayout(10,10));
        clientPanel.add(detailsScrollPane, BorderLayout.NORTH); // Existing client details
        clientPanel.add(additionalScrollPane, BorderLayout.SOUTH); // Additional information

        splitPane.setRightComponent(clientPanel); // Update right component to client panel
        
        
        // JTextPane for additional information
        additionalInfoPane = new JTextPane();
        clientPanel.add(additionalInfoPane, BorderLayout.CENTER);
        additionalInfoPane.setEditable(false); // Display-only
        additionalInfoPane.setBorder(BorderFactory.createTitledBorder("Additional Information"));

        getContentPane().add(splitPane, BorderLayout.CENTER); // Main layout
    }

    

    private DefaultTreeModel createTreeModel() {
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Portfolios");

    // Portfolio 1: Retirement
    DefaultMutableTreeNode retirement = new DefaultMutableTreeNode("Retirement ($3180.0)");
    retirement.add(new DefaultMutableTreeNode("T001 ($100.0)"));
    retirement.add(new DefaultMutableTreeNode("T002 ($130.0)"));
    retirement.add(new DefaultMutableTreeNode("T003 ($900.0)"));
    retirement.add(new DefaultMutableTreeNode("T004 ($650.0)"));
    retirement.add(new DefaultMutableTreeNode("T006 ($400.0)"));
    retirement.add(new DefaultMutableTreeNode("A1000 ($1000.0)"));

    // Portfolio 2: Test
    DefaultMutableTreeNode test = new DefaultMutableTreeNode("Test ($1337.0)");
    test.add(new DefaultMutableTreeNode("C0001 ($1337.0)"));

    // Portfolio 3: Operations
    DefaultMutableTreeNode operations = new DefaultMutableTreeNode("Operations ($10000.0)");
    operations.add(new DefaultMutableTreeNode("OPS001 ($10000.0)"));

    // Add portfolios to the root
    root.add(retirement);
    root.add(test);
    root.add(operations);

    return new DefaultTreeModel(root);
}


    private void updateDetailsPane() {
        Random random = new Random();

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phone = phoneField.getText();

        // Randomize the total value (between 0 and $100,000)
        double totalValue = random.nextDouble() * 100000; // Random double <= 100000
        int portfolioCount = random.nextInt(10) + 1; // Random integer between 1 and 10

        // Format the client details with randomized information
        String clientDetails = String.format(
            "First Name: %s\nLast Name: %s\nPhone Number: %s\nTotal Value: $%.2f\nPortfolio Count: %d\nPortfolio Names: Retirement, Test, Operations",
            firstName, lastName, phone, totalValue, portfolioCount
        );

        detailsPane.setText(clientDetails);
        String additionalInfo = String.format(
                "Adding Portfolio: Retirement ($%.2f)\n" +
                "Adding Account: T001 ($%.2f), T002 ($%.2f), T003 ($%.2f), T004 ($%.2f), T006 ($%.2f), A1000 ($%.2f)\n" +
                "Adding Portfolio: Test ($%.2f)\n" +
                "Adding Account: C0001\n" +
                "Adding Portfolio: Operations ($%.2f)\n" +
                "Adding Account: OPS001",
                random.nextDouble() * 100000, // Retirement
                random.nextDouble() * 100000, // T001
                random.nextDouble() * 100000, // T002
                random.nextDouble() * 100000, // T003
                random.nextDouble() * 100000, // T004
                random.nextDouble() * 100000, // T006
                random.nextDouble() * 100000, // A1000
                random.nextDouble() * 100000, // Test
                random.nextDouble() * 100000  // Operations
            );

            additionalInfoPane.setText(additionalInfo);
        
    }}