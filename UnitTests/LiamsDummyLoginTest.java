/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author liambarry
 */
public class DummyUserLoginTest {
    
    public static boolean loginSuccessful(String input){
        
        if(input == "Liam Barry"){
            return true;
        }else{
            return false;
        }
    } 

    /**
     * Test of loginSuccessful method, of class DummyUserLogin.
     */
    @Test
    public void testLoginSuccessful() {
        System.out.println("loginSuccessful");
        String input = "Liam Barry";
        boolean expResult = true;
        boolean result = loginSuccessful(input);
        assertEquals(expResult, result);
    }
    
}
