package test.program;

import java.util.ArrayList;

import main.java.program.RandomGenerator;

public class RandomStub extends RandomGenerator{
	ArrayList<Integer> numberList = new ArrayList<Integer>();
	public void add(int i) {
		// TODO Auto-generated method stub
		numberList.add(i);
	}
	
	public int next(){
		return numberList.remove(0);
	}

}
