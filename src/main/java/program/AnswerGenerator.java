package main.java.program;



public class AnswerGenerator {
	RandomGenerator randomGenerator;
	
	public AnswerGenerator(RandomGenerator randomGenerator) {
		// TODO Auto-generated constructor stub
		this.randomGenerator = randomGenerator;
	}

	public String getRandomNumber() {
		// TODO Auto-generated method stub
		String number = "";
		while(true){
			if(number.length()==4)
				return number;
			int next = randomGenerator.next();
			if(number.contains(String.valueOf(next)))
				continue;
			number += next;
		}
	}

}
