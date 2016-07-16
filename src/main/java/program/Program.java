package main.java.program;

public class Program {
    public static void main(String[] args) {
    	RandomGenerator randomGenerator = new RandomGenerator();
    	AnswerGenerator answerGenerator = new AnswerGenerator(randomGenerator);
    	
    	String randomNumber = answerGenerator.getRandomNumber();
    	
    	System.out.println(randomNumber);
    	
    }
}
