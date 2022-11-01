import java.util.Random;

public class ComputerGuesserRandom implements IGuesser
{
    private int min;
    private int max;
    private final static Random rand = new Random();
    private int guess;

    public void yourTurn()
    {

    }

    public String getName()
    {
        return "Computer random guesser";
    }

    public void newGame(int min, int max, String opponent, String type)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public int makeGuess()
    {
        guess = rand.nextInt(max - min + 1) + min;
        return guess;
    }

    public void guessFeedback(Answer answer)
    {
        switch(answer)
        {
            case TOO_LOW:
                min = guess + 1;
                break;
            case TOO_HIGH:
                max = guess - 1;
                break;
            case CORRECT:
                break;
            default:
                throw new RuntimeException("This should never happen!");
        }
    }

    public boolean endOfGame(int numberOfGuesses, String opponent)
    {
        return true;
    }
}
