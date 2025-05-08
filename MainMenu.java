import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class MainMenu {

    public static JPanel createMainMenuPanel(JFrame frame) {
        // Custom JPanel to draw the background image
        JPanel mainMenuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("assets/mainmenu.png"); // Path to the background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        mainMenuPanel.setLayout(null);
        mainMenuPanel.setBounds(0, 0, 1280, 720);
        mainMenuPanel.setDoubleBuffered(true); 

        JButton startButton = new JButton("Start");
        JButton difficultyButton = new JButton("Difficulty: " + QuestionManager.difficulty);
        JButton quitButton = new JButton("Quit");

        UIHelper.styleButton(startButton);
        startButton.setBackground(Color.RED); // Full red background
        startButton.setForeground(Color.BLACK); // Black text
        startButton.setBorder(new LineBorder(Color.BLACK, 2)); // Black border
        startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(true);
        startButton.setOpaque(true);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBounds(540, 250, 200, 50);
        mainMenuPanel.add(startButton);
        
        UIHelper.styleButton(difficultyButton);
        difficultyButton.setBackground(Color.RED); // Full red background
        difficultyButton.setForeground(Color.BLACK); // Black text
        difficultyButton.setBorder(new LineBorder(Color.BLACK, 2)); // Black border
        difficultyButton.setFocusPainted(false);
        difficultyButton.setContentAreaFilled(true);
        difficultyButton.setOpaque(true);
        difficultyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        difficultyButton.setFont(new Font("Arial", Font.BOLD, 16));
        difficultyButton.setBounds(540, 350, 200, 50);
        mainMenuPanel.add(difficultyButton);
        
        UIHelper.styleButton(quitButton);
        quitButton.setBackground(Color.RED); // Full red background
        quitButton.setForeground(Color.BLACK); // Black text
        quitButton.setBorder(new LineBorder(Color.BLACK, 2)); // Black border
        quitButton.setFocusPainted(false);
        quitButton.setContentAreaFilled(true);
        quitButton.setOpaque(true);
        quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitButton.setFont(new Font("Arial", Font.BOLD, 16));
        quitButton.setBounds(540, 450, 200, 50);
        mainMenuPanel.add(quitButton);

        // Version label at the bottom-right corner
        JLabel versionLabel = new JLabel("Version 1.0.0");
        versionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        versionLabel.setForeground(Color.LIGHT_GRAY);
        versionLabel.setBounds(1140, 690, 120, 20); // Increased width and adjusted position
        mainMenuPanel.add(versionLabel);

        // Add action listeners for main menu buttons
        startButton.addActionListener(e -> {
            QuestionManager.generateQuestions();
            frame.remove(mainMenuPanel);
            frame.add(QuizPanel.createQuizPanel(frame, mainMenuPanel));
            frame.revalidate();
            frame.repaint();
        });

        difficultyButton.addActionListener(e -> {
            String[] options = {"Easy", "Medium", "Hard"};
            String selectedDifficulty = (String) JOptionPane.showInputDialog(
                    frame,
                    "Select Difficulty:",
                    "Difficulty",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    QuestionManager.difficulty
            );

            // Only update if the user made a selection (not null)
            if (selectedDifficulty != null) {
                QuestionManager.difficulty = selectedDifficulty;
                difficultyButton.setText("Difficulty: " + QuestionManager.difficulty);
            }
        });

        quitButton.addActionListener(e -> System.exit(0));

        return mainMenuPanel;
    }
}