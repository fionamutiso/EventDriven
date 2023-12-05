/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fiona.registration2;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration2 extends JFrame {

    private JTextField idField, nameField, addressField, contactField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JTextArea displayArea;

    public Registration2() {
        // Set up the main frame
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create a title label
        JLabel titleLabel = new JLabel("Registration Form", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Create components
        idField = new JTextField(8);
        nameField = new JTextField(15);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        addressField = new JTextField(20);
        contactField = new JTextField(10);
        displayArea = new JTextArea(20, 30);
        displayArea.setEditable(false);

        // Add radio buttons to button group
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Create buttons
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        // Register button action listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Exit button action listener
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create panel for registration form
        JPanel registrationPanel = new JPanel(new GridLayout(6, 2));
        registrationPanel.add(new JLabel("ID:"));
        registrationPanel.add(idField);
        registrationPanel.add(new JLabel("Name:"));
        registrationPanel.add(nameField);
        registrationPanel.add(new JLabel("Gender:"));
        registrationPanel.add(maleRadioButton);
        registrationPanel.add(new JLabel(""));
        registrationPanel.add(femaleRadioButton);
        registrationPanel.add(new JLabel("Address:"));
        registrationPanel.add(addressField);
        registrationPanel.add(new JLabel("Contact:"));
        registrationPanel.add(contactField);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        buttonPanel.add(exitButton);

        // Create main panel with title, registration form, and buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(registrationPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create panel for displaying registered details with labels vertically
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.add(new JLabel("ID:"));
        displayPanel.add(new JLabel(""));
        displayPanel.add(new JLabel("Name:"));
        displayPanel.add(new JLabel(""));
        displayPanel.add(new JLabel("Gender:"));
        displayPanel.add(new JLabel(""));
        displayPanel.add(new JLabel(""));
        displayPanel.add(new JLabel(""));
        displayPanel.add(new JLabel("Address:"));
        displayPanel.add(new JLabel(""));
        displayPanel.add(new JLabel("Contact:"));
        displayPanel.add(new JLabel(""));

        // Create main frame with a split pane for registration and display panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainPanel, displayPanel);
        splitPane.setResizeWeight(0.5);
        add(splitPane);

        // Set the frame to be visible
        setVisible(true);
    }

    private void registerUser() {
        // Get user input
        String id = idField.getText();
        String name = nameField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        String address = addressField.getText();
        String contact = contactField.getText();

        // Display registered details in the side panel
        displayArea.setText("ID: " + id + "\nName: " + name + "\nGender: " + gender + "\nAddress: " + address + "\nContact: " + contact);

        // Clear the registration form
        idField.setText("");
        nameField.setText("");
        genderGroup.clearSelection();
        addressField.setText("");
        contactField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Registration2();
            }
        });
    }
}
