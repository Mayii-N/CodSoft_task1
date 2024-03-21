import javax.swing.*;

public class Main {
    static int userGuess;
    static int randomNumber;
    static int tries = 5;
    static int count;
    static int score = 0;

    public static void main(String[] args) {
        //randomize number
        Main m = new Main();
        m.randomize();
        m.start();

        int retry;
        String retryMessage = "Choose a number from the list below\n\n" +
                "1. Retry\n" +
                "2. Close";
        retry = Integer.parseInt(JOptionPane.showInputDialog(retryMessage));

        while (retry != 2){
            m.randomize();
            m.start();
            retry = Integer.parseInt(JOptionPane.showInputDialog(retryMessage));
        }
    }

    void randomize(){
        double random = Math.random();
        randomNumber = (int) (random * 101);
    }

    public static int getTries() {
        return tries;
    }

    public static void setTries(int tries) {
        Main.tries = tries;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Main.count = count;
    }

    void start(){
        userGuess = Integer.parseInt(JOptionPane.showInputDialog("Enter your guess"));
        tries = tries-1;
       count = 0;

        while (tries != 0){
            count++;
            if (userGuess == randomNumber){
                score++;
                JOptionPane.showMessageDialog(null, "You guessed right\n" +
                        "The correct answer is " + randomNumber + "\n" +
                        "You took " + count + " tries\n" +
                        "Your score is: " + score);
                tries = 0;
            } else if (userGuess > randomNumber) {
                JOptionPane.showMessageDialog(null, "Too high");
                userGuess = Integer.parseInt(JOptionPane.showInputDialog("Enter another guess"));
                count++;
                tries--;
                if (tries == 0){
                    String message = "You did not guess correctly.\n" +
                            "Your number of tries have been depleted\n" +
                            "Your score is: " + score;
                    JOptionPane.showMessageDialog(null, message);
                }
            } else if (userGuess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low");
                userGuess = Integer.parseInt(JOptionPane.showInputDialog("Enter another guess"));
                count++;
                tries--;
                if (tries == 0){
                    String message = "You did not guess correctly.\n" +
                            "Your number of tries have been depleted\n" +
                            "Your score is: " + score;
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        }
        setCount(0);
        setTries(5);
    }
}