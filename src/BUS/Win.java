/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.ArrayListBC.qct;
import static GUI.BancoGUI.flag;
import javax.swing.JOptionPane;

/**
 *
 * @author Keyer
 */
public class Win {
    public Win() {
    }
    public int CheckWin() {
        int win = 0;
        for (int i = 0; i < 16; i++) {
            if (qct.get(i).getPhe() == flag && qct.get(i).getVitri() == qct.get(i).getVitriraquan() - 2) {
                win++;
            }
            if (qct.get(i).getPhe() == flag && qct.get(i).getVitri() == qct.get(i).getVitriraquan() - 3) {
                win++;
            }
            if (qct.get(i).getPhe() == flag && qct.get(i).getVitri() == qct.get(i).getVitriraquan() - 4) {
                win++;
            }
            if (qct.get(i).getPhe() == flag && qct.get(i).getVitri() == qct.get(i).getVitriraquan() - 5) {
                win++;
            }
        }
        if (win == 4) {
//           
return 99;
        }
return 0;
    }

    
}
