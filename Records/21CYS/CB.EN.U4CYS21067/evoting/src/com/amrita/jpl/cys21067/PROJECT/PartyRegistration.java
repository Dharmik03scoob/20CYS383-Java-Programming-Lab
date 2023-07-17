package com.amrita.jpl.cys21067.PROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * This class represents the party registration form.
 * It allows users to register a new political party by providing the party details and logo.
 */
class PartyRegistration extends JFrame implements ActionListener {
    JLabel titleLabel, partyNameLabel, partyLogoLabel, partyLeaderLabel, partySymbolLabel;
    JTextField partyNameTextField, partyLeaderTextField, partySymbolTextField;
    JButton browseButton, submitButton;
    JLabel selectedLogoLabel;
    File selectedLogoFile;

    /**
     * Constructs a new PartyRegistration object and initializes the party registration UI components.
     */
    public PartyRegistration() {
        setTitle("Party Registration");
        setSize(400, 350);
        setLayout(null);

        titleLabel = new JLabel("Party Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(110, 10, 250, 40);
        add(titleLabel);

        partyNameLabel = new JLabel("Party Name");
        partyNameLabel.setBounds(50, 60, 100, 20);
        add(partyNameLabel);

        partyNameTextField = new JTextField();
        partyNameTextField.setBounds(160, 60, 150, 20);
        add(partyNameTextField);

        partyLogoLabel = new JLabel("Party Logo");
        partyLogoLabel.setBounds(50, 100, 100, 20);
        add(partyLogoLabel);

        browseButton = new JButton("Browse");
        browseButton.setBounds(160, 100, 80, 20);
        browseButton.addActionListener(this);
        add(browseButton);

        selectedLogoLabel = new JLabel();
        selectedLogoLabel.setBounds(250, 100, 100, 100);
        add(selectedLogoLabel);

        partyLeaderLabel = new JLabel("Party Leader");
        partyLeaderLabel.setBounds(50, 220, 100, 20);
        add(partyLeaderLabel);

        partyLeaderTextField = new JTextField();
        partyLeaderTextField.setBounds(160, 220, 150, 20);
        add(partyLeaderTextField);

        partySymbolLabel = new JLabel("Party Symbol");
        partySymbolLabel.setBounds(50, 260, 100, 20);
        add(partySymbolLabel);

        partySymbolTextField = new JTextField();
        partySymbolTextField.setBounds(160, 260, 150, 20);
        add(partySymbolTextField);

        submitButton = new JButton("Register");
        submitButton.setBounds(140, 300, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    /**
     * Handles the actionPerformed event for the browseButton and submitButton.
     * Performs actions based on the event source.
     *
     * @param e The ActionEvent instance.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedLogoFile = fileChooser.getSelectedFile();
                ImageIcon logoIcon = new ImageIcon(selectedLogoFile.getPath());
                selectedLogoLabel.setIcon(logoIcon);
            }
        } else if (e.getSource() == submitButton) {
            String partyName = partyNameTextField.getText();
            String partyLeader = partyLeaderTextField.getText();
            String partySymbol = partySymbolTextField.getText();

            if (partyName.isEmpty() || partyLeader.isEmpty() || partySymbol.isEmpty() || selectedLogoFile == null) {
                JOptionPane.showMessageDialog(this, "Fill in all the details first.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(this, "Party registered successfully!");
                partyNameTextField.setText("");
                partyLeaderTextField.setText("");
                partySymbolTextField.setText("");
                selectedLogoLabel.setIcon(null);
                selectedLogoFile = null;
            }
        }
    }

    /**
     * The main entry point of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        new PartyRegistration();
    }
}
