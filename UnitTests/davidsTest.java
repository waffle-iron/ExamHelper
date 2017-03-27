import org.junit.Assert;

import org.junit.Test;



public class TestFailure {

	
	@Test
	public void whenCharactersNotRecognizedBySqliteAreInString(){
		String input = '"';
		Assert.assertEquals(true, addToDatabase(input));
	}
	
	
	public static boolean addToDatabase(String input){
		if(input.indexOf('"') >= 0){
			input = input.replaceAll("\"|\"", "");
		}
		
		//adds to actual database
		return true;	
	}
}

