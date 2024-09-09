/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author keiner5212
 */
public class RoomCard extends javax.swing.JPanel {
    private JLabel descriptionLabel;
    private JButton actionButton;
    private JLabel imageLabel;

    public RoomCard(String title, String description, String action, String image) {
        setLayout(new BorderLayout());
        setPreferredSize(new java.awt.Dimension(830, 180));
        setBorder(BorderFactory.createLineBorder(java.awt.Color.gray, 1));

        descriptionLabel = new JLabel("<html><body><h1>" + title + "</h1><br><p style='width: 700px'>" + description + "</p></body></html>");
        actionButton = new JButton(action);

        // load image from url  
        imageLabel = new JLabel();
        try {
            ImageIcon imageIcon = new ImageIcon(new URL(image));
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(170, 170, java.awt.Image.SCALE_SMOOTH));
            imageLabel.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
            imageLabel.setText("Error loading image");
        }

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        imagePanel.add(imageLabel);


        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.add(descriptionLabel);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        actionPanel.add(actionButton);

        add(imagePanel, BorderLayout.WEST);
        // add(titlePanel, BorderLayout.CENTER);
        add(descriptionPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.EAST);

        actionButton.addActionListener(e -> {
            System.out.println("Action: " + action);
        });
    }
}
