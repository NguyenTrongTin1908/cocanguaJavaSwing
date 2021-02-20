/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.ArrayListBC.oct;
import static BUS.ArrayListBC.qct;
import static GUI.BancoGUI.flag;
import static BUS.Xingau.die;
import static BUS.Xingau.num_Xingau;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Keyer
 */
public class Raquan {

    
    public static int k = 1,vt_raquan;

     public int Raquan()
    {
            return KiemTraRaQuan();
            
    
    }
     public int Da( int da ,int bida)
  {
    qct.get(bida).setVitri(qct.get(bida).getVitriraquan() - 1);
                            qct.get(bida).setTrangthai(0);
                            qct.get(da).setTrangthai(1);
                            qct.get(da).setVitri(qct.get(da).getVitriraquan());
                            oct.get(qct.get(da).getVitriraquan()).setTrangthai(1);
                            oct.get(qct.get(da).getVitriraquan()).setId_qc(da);
                            
                               vt_raquan= qct.get(da).getVitriraquan(); 
                               return 1;
  }
     public int Bichan()
     {
         num_Xingau=die.getSteps();
         return 2;
     }

    public int KiemTraRaQuan() {
        int kq = -2;
        for (int i = 0; i <= 15; i++) {
            ////////Kiểm tra phe,trạng thái quân có được ra hay k/////////////

            if (qct.get(i).getPhe() == flag) {
                if (qct.get(i).getTrangthai() == 0) {
                    if (oct.get(qct.get(i).getVitriraquan()).getTrangthai() == 0) {
                        System.out.println("hi");
                        qct.get(i).setTrangthai(1);
                        qct.get(i).setVitri(qct.get(i).getVitriraquan());
                        oct.get(qct.get(i).getVitriraquan()).setTrangthai(1);
                        oct.get(qct.get(i).getVitriraquan()).setId_qc(i);
                        kq = -1;
                        vt_raquan= qct.get(i).getVitriraquan();
                        break;

                        ///////////////Nếu vị trí ra quân co quan doi thu////////////////////
                        /////////////DA/////////////////////////
                    } else {
                        int tmp = oct.get(qct.get(i).getVitriraquan()).getId_qc();
                        if (qct.get(i).getPhe() != qct.get(tmp).getPhe()) {
                            kq=Da(i, tmp);
                            break;
                        } else {
                            kq=Bichan();
                            
                        }
                    }
                }

            }

        }
        return kq;

    }
}
