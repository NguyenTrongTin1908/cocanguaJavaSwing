/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
/**
 *
 * @author Keyer
 */
public class Xingau {
    public static Die die;
    public static int num_Xingau;
    public void Doxingau()
            
    {      
    	die = new Die();

        die.thrown();
         num_Xingau=die.getSteps();
        
    }
    
    
}
