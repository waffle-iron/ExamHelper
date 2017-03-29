/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class JUnitTestsTest {
    
    public static boolean addToDatabase(String input){
		if(input.indexOf('"') >= 0){
			input = input.replaceAll("\"|\"", "");
		}
		
		//adds to actual database
		return true;	
    }

    /**
     * Test of addToDatabase method, of class JUnitTests.
     */
    @Test
    public void testAddToDatabase() {
        System.out.println("addToDatabase");
        String input = "";
        boolean expResult = true;
        boolean result = addToDatabase(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
