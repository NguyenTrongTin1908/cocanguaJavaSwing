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
public class Setup {
    private ArrayList<QuancoDTO> qct;
    private ArrayList<OcoDTO> oct;

    /**
     *
     * @return
     */
    public ArrayList<QuancoDTO> Setup_QC() {
        qct = new ArrayList<QuancoDTO>();
        int phe = 1;
        
        int vt = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                QuancoDTO qc = new QuancoDTO();
                qc.setID_quanco((phe * 10) + j);
                qc.setTrangthai(0);
                qc.setPhe(phe);
                qc.setVitri(vt);
                qc.setVitriraquan(vt + 1);
                qc.setVitrivedich(vt - 7);
                qct.add(qc);
            }
            vt += 21;
            phe += 1;
        }
        
        return qct;
    }
public ArrayList<OcoDTO> Setup_OC() {
         oct = new ArrayList<OcoDTO>();
         for (int i = 0; i <= 83; i++) {
            OcoDTO oc = new OcoDTO();
            oc.setId_o(i);
            oct.add(oc);
        }
        return oct;
    }
    
}
