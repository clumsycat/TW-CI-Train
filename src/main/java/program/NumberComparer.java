package main.java.program;

import java.util.Scanner;

public class NumberComparer {

	// 1234,4321
	public static String compare(String systemInput, String userInput) {
		// TODO Auto-generated method stub
		int A = 0;
		int B = 0;
		//user数组存储数字对应的位置，1，2，3，4
		int user[] = new int[10];
		//保留用户输入在数组user中，并判断输入是否合法
		for (int i = 0; i < 4; i++) {
			if (userInput.charAt(i) < '0' || userInput.charAt(i) > '9')
				return "not numbers";
			if (user[userInput.charAt(i) - '0'] != 0)
				return "same number";
			user[userInput.charAt(i) - '0'] = i + 1;
		}
		//匹配系统随机数 和用户数字的位置和数字的对应关系
		for (int i = 0; i < 4; i++) {
			if (user[systemInput.charAt(i) - '0'] == i + 1)
				A++;
			else if (user[systemInput.charAt(i) - '0'] != 0)
				B++;
		}

/*		for (int j = 0; j < 4; j++) {
			if (systemInput.charAt(j) == userInput.charAt(j)) {
				A++;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				if (systemInput.charAt(j) == userInput.charAt(i)) {
					B++;
					break;
				}
			}
		}*/
		return A + "A" + B + "B";
	}

	public static String randomNumber() {
/*		String number = "";
		int user[] = new int[10];
		while (number.length() < 4) {
			int singleRandomNumber = (int) (Math.random() * 10);
			if(user[singleRandomNumber] == 1)
				continue;
			user[singleRandomNumber] = 1;
			number = number + singleRandomNumber;
		}*/
/*		while( number.length()<4){
			int temp = (int) (Math.random() * 9000) + 1000;
			number += temp;
			while(temp!=0){
				if(user[temp%10]!=0){
					number = "";
					continue;
				}	
				user[temp%10]+=1;
				temp /= 10;
			}
		}*/
    	RandomGenerator randomGenerator = new RandomGenerator();
    	AnswerGenerator answerGenerator = new AnswerGenerator(randomGenerator);
    	
    	String randomNumber = answerGenerator.getRandomNumber();
		return randomNumber;
	}

	public static void main(String[] args) {
		String systemNumber = randomNumber();
		System.out.println("随机数已生成，欢迎来猜");
		boolean continueGuess = true;
		while (continueGuess) {
			Scanner sc = new Scanner(System.in);
			String userNumber = sc.nextLine();
			String res = compare(systemNumber,userNumber);
			if(res.equals("4A0B")){
				continueGuess = false;
				System.out.println("Congratuations!");
			}	
			System.out.println("当前结果" + res);
		}
	}
}
