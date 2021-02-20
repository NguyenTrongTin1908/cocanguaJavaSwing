/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.Xingau.die;
import static BUS.ArrayListBC.oct;
import static BUS.ArrayListBC.qct;
import static BUS.Xingau.num_Xingau;
import static GUI.BancoGUI.flag;
import static GUI.BancoGUI.id_btn;

/**
 *
 * @author Keyer
 */
public class Dichuyen {

    public Dichuyen() {
    }

    public static int now = 0,
            change = 0;

    public int Move() {
        int kq = 0;

        switch (num_Xingau) {
           

            case 0:
                System.out.println("Vao case 0");
                break;
            case -1:
                System.out.println("Vao case -1");
                break;
            default:
                for (int i = 0; i < 16; i++) {
                    System.out.println("vi tri : " + qct.get(i).getVitri());
                }
                num_Xingau = die.getSteps();
                int qt_map = 21,pos = -1;
                now = 0;change = 0;
                
                int ar_flag[] = new int[5],
                 ar_pot[] = new int[5];
                //setup cĂ¡c má»‘c khi di chuyá»ƒn qua chuá»“ng 
                for (int i = 1; i <= 4; i++) {
                    ar_flag[i] = i;
                }
                for (int i = 1; i <= 4; i++) {
                    ar_pot[i] = (ar_flag[i] - 1) * qt_map + 14;
                }
                
                
                
                
                for (int i = 0; i <= 15; i++) {
                    if (qct.get(i).getVitri() == id_btn && qct.get(i).getPhe() != flag) {
                        num_Xingau = 999;
                        break;
                    }
                    //Kiá»ƒm tra trong 16 quĂ¢n cá»� quĂ¢n cá»� nĂ o Ä‘ang Ä‘á»©ng táº¡i button Ä‘Æ°á»£c click
                    if (qct.get(i).getVitri() == id_btn && qct.get(i).getPhe() == flag) {
                        now = qct.get(i).getVitri();
                        change = qct.get(i).getVitri() + num_Xingau;
                        if (change > 77 && qct.get(i).getPhe() != 1) {
                            int temp = change - 77;
                            change = temp;
                        } else if (change > 83) {
                            int temp = change - 83;
                            change = temp;
                        }
                  //Cho nháº£y bÆ°á»›c khi Ä‘i ngang qua vá»‹ trĂ­ Ä‘Ă­ch cá»§a Ä‘á»‘i phÆ°Æ¡ng
                        if ((now < ar_pot[1] + 1 && change > ar_pot[1] && change < ar_pot[1] + 14 + 9) || (now < ar_pot[2] + 1 && change > ar_pot[2] && change < ar_pot[2] + 14 + 9) || (now < ar_pot[3] + 1 && change > ar_pot[3] && change < ar_pot[3] + 14 + 9) || (now < ar_pot[4] + 1 && change > ar_pot[4] && change < ar_pot[4] + 14 + 9)) {
                            change = change + 7;
                        }
                        //LĂ¹i láº¡i Ä‘á»ƒ vá»� Ä‘Ă­ch khi Ä‘Ăºng chuá»“ng Ä‘Ă­ch cá»§a mĂ¬nh
                        if (now <= qct.get(i).getVitrivedich() && change > qct.get(i).getVitrivedich()) {
                            change = change - 7;

                        }
                        
                        pos = i;
                        break;
                    }

                }
                for (int i = 0; i <= 15; i++) {
                    if (qct.get(i).getVitri() == id_btn && now <= qct.get(i).getVitrivedich() + 6 && change > qct.get(i).getVitrivedich() + 6) {
                            kq = 1;
                            change=now;
                            num_Xingau = 999;
                            break;
                        }
                    
                    
                    if (now < qct.get(i).getVitri() && change == qct.get(i).getVitri()) {
                        if (qct.get(i).getPhe() == flag) {
                            kq = CoquanCungphe(); // //da co quan
                            change=now;
                            break;
                        } else {
                           
                               kq=Da(i);

                            break;
                        }
//
                    }
                    if (now < qct.get(i).getVitri() && change > qct.get(i).getVitri() && qct.get(i).getVitri() != qct.get(i).getVitriraquan() - 1) {
                      kq=Chan();

                      break;

                    }

                }
                if (pos != -1 && change != now) {
                    if (!((now >= 57 && now <= 62) || (now >= 15 && now <= 20) || (now >= 36 && now <= 41) || (now >= 78 && now <= 83))) {

                        kq = 5;//Di chuyen ngoĂ i Ä‘Ă­ch
                    } else {
                        kq = 6;  //Di chuyá»ƒn trong Ä‘Ă­ch
                    }
                    
                    //set vá»‹ trĂ­ quĂ¢n cá»� ,tráº¡ng thĂ¡i Ă´ cá»� khi thá»�a cĂ¡c Ä‘iá»�u kiá»‡n 
                    qct.get(pos).setVitri(change);
                    oct.get(now).setTrangthai(0);
                    oct.get(change).setTrangthai(1);
                    oct.get(change).setId_qc(oct.get(now).getId_qc());

                }
                if (num_Xingau > 1 && num_Xingau < 6) {
                    num_Xingau = -1;
                }
                if (num_Xingau == 6 || num_Xingau == 1) {
                    num_Xingau = 0;
                }
                break;
        }


                    
        return kq;

    }
    int Chan()
    {
                                                      change = now;
        System.out.println("Bi chan");
          
                        num_Xingau = 999;//de k vao case 1,0
                        return 2;
    }
    int CoquanCungphe()
    {
         change = now;
         num_Xingau = 999;
         return 3;
    }
     int Da(int bida)
    {
          
       qct.get(bida).setVitri(qct.get(bida).getVitriraquan() - 1);
       qct.get(bida).setTrangthai(0);
         return 4;
    }
}
