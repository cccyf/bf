package serviceImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BFExecutionTest {

private ExecuteServiceImpl executor;
	
	@Before
	public void setUp() throws Exception {
		executor = new ExecuteServiceImpl();
	}

	@Test
	public void test_single_char_echo() throws Exception{
		String code = ",.";
		assertEquals("A", executor.execute(code, "A")); 
	}
	
	@Test
	public void test_add_to_char() throws Exception{
		String code = ",+++++.";
		assertEquals("F", executor.execute(code, "A"));
	}
	
	@Test
	public void test_add() throws Exception{
		String code = ",>++++++[<-------->-],,[<+>-]<.";
		assertEquals("7", executor.execute(code, "4+3"));
	}
	
	@Test
	public void test_hi_nju() throws Exception{
		String code = "++++++++[>+++++++++[>+>+>+>+>+>+<<<<<<-]<-]++++++[>++++++[>>+>-<<<-]<-]>>>--->---->++++++>++>+++++++++++++<<<<<.>.>.>.>.>.";
		assertEquals("Hi NJU", executor.execute(code, ""));
	}
	
	@Test
	public void test_multiplication() throws Exception{
		String code = ",>,,>++++++++[<------<------>>-]<<[>[>+>+<<-]>>[<<+>>-]<<<-]>>>++++++[<++++++++>-]<.";
		assertEquals("8", executor.execute(code, "2*4"));
	}
	
	@Test
	public void test_char_echo() throws Exception{
		String code = ",>,<.>.";
		assertEquals("AB", executor.execute(code, "AB"));
	}
	@Test
	public void test_add_to_char2() throws Exception{
		String code = ",+++.";
		assertEquals("G", executor.execute(code, "D"));
	}
	@Test
	public void test_add2() throws Exception{
		String code = ",>++++++[<-------->-],,[<+>-]<." ;
		assertEquals("6", executor.execute(code, "2+4"));
	}
	@Test
	public void test_hello_world() throws Exception{ 
		String code ="++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.";
		assertEquals("Hello World!", executor.execute(code, ""));
	}
	@Test
	public void test_multiplication2() throws Exception{
		String code =",>,,>++++++++[<------<------>>-]<<[>[>+>+<<-]>>[<<+>>-]<<<-]>>>++++++[<++++++++>-]<.";
		assertEquals("4", executor.execute(code, "2*2"));
	}
	
	
	
}
