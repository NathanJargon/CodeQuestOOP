import javax.swing.*;

public class CodeQuestOOP {

    public static void main(String[] args) {
        // Initialize questions for each difficulty
        QuestionManager.initializeQuestions();

        // Generate questions for the default difficulty
        QuestionManager.generateQuestions();

        // Create the main frame
        JFrame frame = new JFrame("CodeQuest OOP Quiz");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create panels
        JPanel mainMenuPanel = MainMenu.createMainMenuPanel(frame);
        JPanel quizPanel = QuizPanel.createQuizPanel(frame, mainMenuPanel);

        // Add the main menu panel to the frame
        frame.add(mainMenuPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}