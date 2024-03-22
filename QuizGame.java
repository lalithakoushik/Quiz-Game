import java.util.*;

public class QuizGame {
    private List<Question> questions = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int score = 0;

    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        game.addQuestion(new Question("What is the capital of France?", new String[]{"A) Madrid", "B) Rome", "C) Paris", "D) Berlin"}, "C"));
        game.addQuestion(new Question("Who wrote 'Romeo and Juliet'?", new String[]{"A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Mark Twain"}, "B"));

        game.startQuiz();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        for (Question question : questions) {
            long startTime = System.currentTimeMillis();
            long endTime = startTime + 30 * 1000; // 30 seconds for each question

            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            String userAnswer = "";
            while (System.currentTimeMillis() < endTime) {
                System.out.println("Enter your answer (A, B, C, or D): ");
                userAnswer = scanner.nextLine().trim().toUpperCase();
                if (!userAnswer.isEmpty()) {
                    break;
                }
            }

            if (userAnswer.equals(question.getCorrectAnswer())) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer is " + question.getCorrectAnswer());
            }
        }

        displayResults();
    }

    public void displayResults() {
        System.out.println("Quiz Over! Your final score is: " + score + "/" + questions.size());
        // Here you can add a summary of correct/incorrect answers if needed
    }
}

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
