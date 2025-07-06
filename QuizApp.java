import java.util.ArrayList;
import java.util.Scanner;

class Question {
	String questionText;
    	String[] options;
    	int correctOption;

    	Question(String questionText, String[] options, int correctOption) {
        	this.questionText = questionText;
       		this.options = options;
        	this.correctOption = correctOption;
    	}

    	public void display() {
        	System.out.println("\n" + questionText);
        	for (int i = 0; i < options.length; i++) {
            		System.out.println((i + 1) + ". " + options[i]);
        	}
    	}

    	public boolean isCorrect(int userAnswer) {
		return userAnswer == correctOption;
    	}
}

public class QuizApp {
	public static void main(String[] args) {
        	Scanner sc = new Scanner(System.in);
        	ArrayList<Question> questions = new ArrayList<>();

	questions.add(new Question(
		"Which keyword is used to define a class in Java?",
            	new String[] { "define", "class", "object", "new" }, 2));

        questions.add(new Question(
            	"Which method is the entry point of a Java program?",
            	new String[] { "start()", "init()", "main()", "run()" }, 3));

        questions.add(new Question(
            	"Which data type is used to store decimal values?",
            	new String[] { "int", "String", "float", "char" }, 3));

        questions.add(new Question(
            	"Java is a:",
            	new String[] { "Compiled Language", "Interpreted Language", "Both", "None" }, 3));

        questions.add(new Question(
            	"Which operator is used to compare two values in Java?",
            	new String[] { "=", "==", "===", "!=" }, 2));

        int score = 0;
        System.out.println("Welcome to the Java Quiz!");
        System.out.println("Choose the correct option (1 to 4):");

        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).display();

            System.out.print("Your answer: ");
            int answer = sc.nextInt();

            if (questions.get(i).isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + questions.get(i).correctOption);
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("Excellent!");
        } else if (score >= 3) {
            System.out.println("Good job!");
        } else {
            System.out.println("Keep practicing!");
        }

        sc.close();
    }
}