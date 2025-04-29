import javax.swing.*;
import java.awt.*;

public class MainMenu {

    public static JPanel createMainMenuPanel(JFrame frame) {
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(null);
        mainMenuPanel.setBounds(0, 0, 1280, 720);
        mainMenuPanel.setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("CodeQuest: OOP Edition");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 100, 1280, 50); // Span the entire width of the panel
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        mainMenuPanel.add(titleLabel);

        JButton startButton = new JButton("Start");
        UIHelper.styleButton(startButton);
        startButton.setBounds(540, 250, 200, 50);
        mainMenuPanel.add(startButton);

        JButton difficultyButton = new JButton("Difficulty: " + QuestionManager.difficulty);
        UIHelper.styleButton(difficultyButton);
        difficultyButton.setBounds(540, 350, 200, 50);
        mainMenuPanel.add(difficultyButton);

        JButton quitButton = new JButton("Quit");
        UIHelper.styleButton(quitButton);
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
            QuestionManager.difficulty = (String) JOptionPane.showInputDialog(
                    frame,
                    "Select Difficulty:",
                    "Difficulty",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    QuestionManager.difficulty
            );
            difficultyButton.setText("Difficulty: " + QuestionManager.difficulty);
        });

        quitButton.addActionListener(e -> System.exit(0));

        return mainMenuPanel;
    }
}