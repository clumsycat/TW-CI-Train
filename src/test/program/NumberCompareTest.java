package test.program;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import main.java.program.AnswerGenerator;
import main.java.program.NumberComparer;

public class NumberCompareTest {

	@Test
	public void should_return_0A0B(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","5678");
		assertEquals("0A0B", result);
	}
	@Test
	public void should_return_4A0B(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","1234");
		assertEquals("4A0B", result);
	}
	@Test
	public void should_return_0A4B(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","4321");
		assertEquals("0A4B", result);
	}
	@Test
	public void should_return_1A1B(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","1356");
		assertEquals("1A1B", result);
	}
	@Test
	public void should_return_2A2B(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","4231");
		assertEquals("2A2B", result);
	}
	@Test
	public void should_return_error(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","1111");
		assertEquals("same number", result);
	}
	@Test
	public void should_return_error_on_chars(){
		NumberComparer compare = new NumberComparer();
		String result = compare.compare("1234","aaaa");
		assertEquals("not numbers", result);
	}
	
	@Test
	public void should_return_for_4diff_numbers(){
		NumberComparer compare = new NumberComparer();
		String randomNumber = compare.randomNumber();
		HashSet numberSet = new HashSet<Character>();
		for(int i=0;i<4;i++)
			numberSet.add(randomNumber.charAt(i));
		assertEquals(4, numberSet.size());
	}
	
	@Test
	public void should_return_1234_random_numbers_sequence_of_1_1_2_3_4(){
		//重新开启新类，完成随机数生成的分步，测试随机数其中的一步 or 几步
		RandomStub randomStub = new RandomStub();
		randomStub.add(1);
		randomStub.add(1);
		randomStub.add(2);
		randomStub.add(3);
		randomStub.add(4);
		
		AnswerGenerator generator = new AnswerGenerator(randomStub);
		
		String random = generator.getRandomNumber();
		
		assertEquals("1234", random);
	}
	
	
}
