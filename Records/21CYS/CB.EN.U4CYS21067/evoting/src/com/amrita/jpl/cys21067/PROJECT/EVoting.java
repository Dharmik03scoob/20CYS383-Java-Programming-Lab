package com.amrita.jpl.cys21067.PROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a secure voting system application.
 * It allows users to register, log in, and vote for a party.
 */

class SecureVotingSystem extends JFrame implements ActionListener {
    private JLabel titleLabel, ageLabel, voterIdLabel, fullNameLabel, contactNumberLabel, genderLabel, cityLabel, partyLabel;
    private JTextField ageTextField, voterIdTextField, fullNameTextField, contactNumberTextField;
    private JRadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
    private JComboBox<String> cityComboBox;
    private JButton submitButton;
    private Set<Integer> voterIds;
    private Map<String, Integer> voteCountMap;
    private ImageIcon party1Icon, party2Icon, party3Icon;
    private JRadioButton party1RadioButton, party2RadioButton, party3RadioButton;
    private JLabel party1Label, party2Label, party3Label;
    private ButtonGroup partyButtonGroup;

    /**
     * Constructs a new SecureVotingSystem object and initializes the UI components.
     */

    public SecureVotingSystem() {
        setTitle("Secure Voting System");
        setSize(600, 500);
        setLayout(null);

        voterIds = new HashSet<>();
        voteCountMap = new HashMap<>();

        titleLabel = new JLabel("Secure E - Voting System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(180, 10, 250, 40);
        add(titleLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(50, 60, 100, 20);
        add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(200, 60, 150, 20);
        add(ageTextField);

        voterIdLabel = new JLabel("Voter ID");
        voterIdLabel.setBounds(50, 100, 150, 20);
        add(voterIdLabel);

        voterIdTextField = new JTextField();
        voterIdTextField.setBounds(200, 100, 150, 20);
        add(voterIdTextField);

        fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setBounds(50, 140, 100, 20);
        add(fullNameLabel);

        fullNameTextField = new JTextField();
        fullNameTextField.setBounds(200, 140, 150, 20);
        add(fullNameTextField);

        contactNumberLabel = new JLabel("Contact Number");
        contactNumberLabel.setBounds(50, 180, 100, 20);
        add(contactNumberLabel);

        contactNumberTextField = new JTextField();
        contactNumberTextField.setBounds(200, 180, 150, 20);
        add(contactNumberTextField);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 220, 60, 20);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200, 220, 60, 20);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(280, 220, 80, 20);
        add(femaleRadioButton);

        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setBounds(370, 220, 80, 20);
        add(otherRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        cityLabel = new JLabel("City");
        cityLabel.setBounds(50, 260, 100, 20);
        add(cityLabel);

        String[] cities = {"Delhi", "Bangalore", "Mumbai", "Hyderabad", "Kolkata", "Chennai", "Pune"};
        cityComboBox = new JComboBox<>(cities);
        cityComboBox.setBounds(200, 260, 150, 20);
        add(cityComboBox);

        partyLabel = new JLabel("Select Party");
        partyLabel.setBounds(50, 300, 100, 20);
        add(partyLabel);

        party1Icon = new ImageIcon("party1.jpg");
        party2Icon = new ImageIcon("party2.jpg");
        party3Icon = new ImageIcon("party3.jpg");

        party1Label = new JLabel(party1Icon);
        party1Label.setBounds(180, 300, 100, 100);
        add(party1Label);

        party2Label = new JLabel(party2Icon);
        party2Label.setBounds(300, 300, 100, 100);
        add(party2Label);

        party3Label = new JLabel(party3Icon);
        party3Label.setBounds(420, 300, 100, 100);
        add(party3Label);

        party1RadioButton = new JRadioButton("Party 1");
        party1RadioButton.setBounds(200, 400, 100, 20);
        add(party1RadioButton);

        party2RadioButton = new JRadioButton("Party 2");
        party2RadioButton.setBounds(300, 400, 100, 20);
        add(party2RadioButton);

        party3RadioButton = new JRadioButton("Party 3");
        party3RadioButton.setBounds(400, 400, 100, 20);
        add(party3RadioButton);

        partyButtonGroup = new ButtonGroup();
        partyButtonGroup.add(party1RadioButton);
        partyButtonGroup.add(party2RadioButton);
        partyButtonGroup.add(party3RadioButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(250, 450, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    /**
     * Handles the actionPerformed event for the submitButton.
     * Collects user input, validates it, and processes the vote.
     *
     * @param e The ActionEvent instance.
     */

    public void actionPerformed(ActionEvent e) {
        String ageText = ageTextField.getText();
        String voterIdText = voterIdTextField.getText();
        String fullName = fullNameTextField.getText();
        String contactNumber = contactNumberTextField.getText();
        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (otherRadioButton.isSelected()) {
            gender = "Other";
        }
        String city = (String) cityComboBox.getSelectedItem();

        ImageIcon selectedPartyIcon = null;
        String selectedParty = "";
        if (party1RadioButton.isSelected()) {
            selectedPartyIcon = party1Icon;
            selectedParty = "Party 1";
        } else if (party2RadioButton.isSelected()) {
            selectedPartyIcon = party2Icon;
            selectedParty = "Party 2";
        } else if (party3RadioButton.isSelected()) {
            selectedPartyIcon = party3Icon;
            selectedParty = "Party 3";
        }

        if (ageText.isEmpty() || voterIdText.isEmpty() || fullName.isEmpty() || contactNumber.isEmpty() || gender.isEmpty() || city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill in all the details first.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!isNumeric(voterIdText)) {
                JOptionPane.showMessageDialog(this, "Invalid voter ID. Please enter a numeric value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age = Integer.parseInt(ageText);
            int voterId = Integer.parseInt(voterIdText);

            if (age < 18) {
                JOptionPane.showMessageDialog(this, "Age below 18. Not eligible to vote.", "Age Restriction", JOptionPane.ERROR_MESSAGE);
            } else {
                if (voterIds.contains(voterId)) {
                    JOptionPane.showMessageDialog(this, "This voter ID is already registered. Please enter a unique voter ID.", "Duplicate Voter ID", JOptionPane.ERROR_MESSAGE);
                } else {
                    voterIds.add(voterId);
                    JOptionPane.showMessageDialog(this, "Thank you for your vote! The party you voted for is " + selectedParty + ".");
                    incrementVoteCount(selectedParty);
                    displayVoteCounts(); // Display the vote counts
                }
            }

            // Clear the text fields
            ageTextField.setText("");
            voterIdTextField.setText("");
            fullNameTextField.setText("");
            contactNumberTextField.setText("");

            // Clear the radio buttons
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);

            // Clear the combo box selection
            cityComboBox.setSelectedIndex(0);

            // Clear the party selection
            partyButtonGroup.clearSelection();
        }
    }

    /**
     * Checks if a given string is numeric.
     *
     * @param str The string to check.
     * @return true if the string is numeric, false otherwise.
     */

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /**
     * Increments the vote count for a given party.
     *
     * @param party The party to increment the vote count for.
     */

    private void incrementVoteCount(String party) {
        voteCountMap.put(party, voteCountMap.getOrDefault(party, 0) + 1);
    }
    /**
     * Displays the vote counts for all parties.
     */

    private void displayVoteCounts() {
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            String party = entry.getKey();
            int voteCount = entry.getValue();
            System.out.println(party + ": " + voteCount);
        }
    }
}

/**
 * This class represents the registration user interface for the voting system.
 * It allows users to register by providing their details.
 */
class RegistrationUI {
    private JFrame frame;
    private JTextField nameTextField, phoneTextField, voterIdTextField;
    private JPasswordField passwordField;

    /**
     * Constructs a new RegistrationUI object and initializes the registration UI components.
     */
    public RegistrationUI() {
        frame = new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 220);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        JLabel phoneLabel = new JLabel("Pincode:");
        phoneTextField = new JTextField();

        JLabel voterIdLabel = new JLabel("Booth ID:");
        voterIdTextField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String phone = phoneTextField.getText();
                String voterId = voterIdTextField.getText();
                char[] password = passwordField.getPassword();

                // Add your registration logic here
                if (name.isEmpty() || phone.isEmpty() || voterId.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(frame, "Fill in all the details first.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!isNumeric(voterId)) {
                        JOptionPane.showMessageDialog(frame, "Invalid Booth ID. Please enter a numeric value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Register the user and store the information
                    JOptionPane.showMessageDialog(frame, "Registration successful! You can now log in.");
                    frame.dispose(); // Close the registration window

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new LoginUI();
                        }
                    });
                }

                // Clear the text fields
                nameTextField.setText("");
                phoneTextField.setText("");
                voterIdTextField.setText("");
                passwordField.setText("");
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the registration window
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new LoginUI();
                    }
                });
            }
        });

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);
        panel.add(voterIdLabel);
        panel.add(voterIdTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(registerButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(loginButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}

/**
 * This class represents the login user interface for the voting system.
 * It allows registered users to log in to the system.
 **/

class LoginUI {
    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private Map<String, char[]> registeredUsers;

    public LoginUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Booth ID:");
        usernameTextField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton submitButton = new JButton("Login");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                char[] password = passwordField.getPassword();

                // Add your authentication logic here
                if (registeredUsers.containsKey(username) && comparePasswords(password, registeredUsers.get(username))) {
                    frame.dispose(); // Close the login window
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new SecureVotingSystem();
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(submitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        registeredUsers = new HashMap<>();  // Initialize the registered users map
        // Add dummy user for testing
        registeredUsers.put("12345", "password".toCharArray());
    }

    private boolean comparePasswords(char[] password1, char[] password2) {
        if (password1.length != password2.length) {
            return false;
        }
        for (int i = 0; i < password1.length; i++) {
            if (password1[i] != password2[i]) {
                return false;
            }
        }
        return true;
    }
}
/**
 * The main class that starts the secure voting system application.
 */
public class EVoting {
    /**
     * The main entry point of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationUI();
            }
        });
    }
}