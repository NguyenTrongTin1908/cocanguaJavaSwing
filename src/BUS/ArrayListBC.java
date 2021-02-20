/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.OcoDTO;
import DTO.QuancoDTO;
import java.util.ArrayList;

/**
 *
 * @author Keyer
 */
public class ArrayListBC {
     public static ArrayList<OcoDTO> oct;
     public static ArrayList<QuancoDTO> qct;

    public ArrayListBC() {
        Setup setup = new Setup();
        oct=setup.Setup_OC();
        qct=setup.Setup_QC();
    }

   
     
    
}
