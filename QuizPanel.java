import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuizPanel {

    public static JPanel createQuizPanel(JFrame frame, JPanel mainMenuPanel) {
        // Custom JPanel to draw the background image
        JPanel quizPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("assets/questions.png"); // Path to the background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        quizPanel.setLayout(null);
        quizPanel.setBounds(0, 0, 1280, 720);

        // Difficulty label at the top left
        JLabel difficultyLabel = new JLabel("Difficulty: " + QuestionManager.difficulty);
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 18));
        difficultyLabel.setForeground(Color.WHITE);
        difficultyLabel.setBounds(20, 20, 200, 30);
        quizPanel.add(difficultyLabel);

        // Rewind button
        ImageIcon rewindIcon = new ImageIcon(new ImageIcon("assets/rewind.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JButton rewindButton = new JButton(rewindIcon);
        rewindButton.setContentAreaFilled(false);
        rewindButton.setBorderPainted(false);
        rewindButton.setFocusPainted(false);
        rewindButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rewindButton.setBounds(1090, 20, 50, 50);
        quizPanel.add(rewindButton);

        // Back to Menu button
        ImageIcon quitIcon = new ImageIcon(new ImageIcon("assets/close.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JButton backToMenuButton = new JButton(quitIcon);
        backToMenuButton.setContentAreaFilled(false);
        backToMenuButton.setBorderPainted(false);
        backToMenuButton.setFocusPainted(false);
        backToMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backToMenuButton.setBounds(1180, 20, 50, 50);
        quizPanel.add(backToMenuButton);

        // Question label
        JTextArea questionLabel = new JTextArea();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Standard font
        questionLabel.setBackground(Color.RED); // Full red background
        questionLabel.setForeground(Color.BLACK); // Black texte background
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setEditable(false);
        questionLabel.setBounds(440, 100, 400, 60);
        quizPanel.add(questionLabel);

        // Option buttons
        JButton option1 = new JButton();
        JButton option2 = new JButton();
        JButton option3 = new JButton();
        JButton option4 = new JButton();

        styleQuizButton(option1);
        styleQuizButton(option2);
        styleQuizButton(option3);
        styleQuizButton(option4);

        option1.setBounds(440, 200, 400, 40);
        option2.setBounds(440, 260, 400, 40);
        option3.setBounds(440, 320, 400, 40);
        option4.setBounds(440, 380, 400, 40);

        quizPanel.add(option1);
        quizPanel.add(option2);
        quizPanel.add(option3);
        quizPanel.add(option4);

        // Feedback label
        JLabel feedbackLabel = new JLabel("");
        feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        feedbackLabel.setForeground(Color.WHITE);
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        feedbackLabel.setBounds(440, 450, 400, 30);
        quizPanel.add(feedbackLabel);

        // Load the first question
        loadQuestion(questionLabel, option1, option2, option3, option4, feedbackLabel);

        // Add action listeners for quiz options
        ActionListener answerListener = e -> {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals(QuestionManager.questions.get(QuestionManager.currentQuestionIndex)[5])) {
                feedbackLabel.setText("Correct!");
                QuestionManager.score++;
            } else {
                feedbackLabel.setText("Incorrect! The correct answer is: " + QuestionManager.questions.get(QuestionManager.currentQuestionIndex)[5]);
            }
            QuestionManager.currentQuestionIndex++;
            if (QuestionManager.currentQuestionIndex < QuestionManager.questions.size()) {
                loadQuestion(questionLabel, option1, option2, option3, option4, feedbackLabel);
            } else {
                feedbackLabel.setText("Quiz Complete! Your score: " + QuestionManager.score + "/" + QuestionManager.questions.size());

                // Disable all interactive components
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                rewindButton.setEnabled(false);
                backToMenuButton.setEnabled(false);

                Timer timer = new Timer(3000, evt -> {
                    frame.remove(quizPanel);
                    frame.add(mainMenuPanel);
                    frame.revalidate();
                    frame.repaint();
                    QuestionManager.score = 0; // Reset score for the next quiz
                    QuestionManager.currentQuestionIndex = 0; // Reset question index
                });
                timer.setRepeats(false);
                timer.start();
            }
        };

        option1.addActionListener(answerListener);
        option2.addActionListener(answerListener);
        option3.addActionListener(answerListener);
        option4.addActionListener(answerListener);

        // Rewind button action listener
        rewindButton.addActionListener(e -> {
            if (QuestionManager.currentQuestionIndex > 0) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Do you want to go back to the previous choice?", "Rewind", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    QuestionManager.currentQuestionIndex--;
                    loadQuestion(questionLabel, option1, option2, option3, option4, feedbackLabel);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This is the first question. You cannot rewind further.", "Rewind", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Back to Main Menu button action listener
        backToMenuButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to return to the main menu?", "Back to Main Menu", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                frame.remove(quizPanel);
                frame.add(mainMenuPanel);
                frame.revalidate();
                frame.repaint();
                QuestionManager.score = 0; // Reset score when returning to the menu
                QuestionManager.currentQuestionIndex = 0; // Reset question index
            }
        });

        return quizPanel;
    }

    private static void styleQuizButton(JButton button) {
        button.setBackground(Color.RED); // Full red background
        button.setForeground(Color.BLACK); // Black text
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
    }

    private static void loadQuestion(JTextArea questionLabel, JButton option1, JButton option2, JButton option3, JButton option4, JLabel feedbackLabel) {
        String[] question = QuestionManager.questions.get(QuestionManager.currentQuestionIndex);
        questionLabel.setText(question[0]);
        option1.setText(question[1]);
        option2.setText(question[2]);
        option3.setText(question[3]);
        option4.setText(question[4]);
        feedbackLabel.setText("");
    }
}