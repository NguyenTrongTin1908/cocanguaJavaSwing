package GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.util.Random;
import java.util.Scanner;

import BUS.*;

import static BUS.Dichuyen.change;
import static BUS.Dichuyen.now;
import static BUS.Xingau.die;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static BUS.Xingau.num_Xingau;


public class BancoGUI {

    private JFrame m;
    private JPanel main;
    private JTextField txingau, t_num;
    private JLabel lboc, lbqc, lbXingau, lbXingau2, lbFlag, lbHecarim;
    private JButton btbc, btoc, btXingau, btRaquan, btBoluot, btRestart;
   
   
//    private int num_Xingau = 1;

    public static int id_btn;
    public static int flag = 1;
//    public static final int flag = 2;
    private Icon iconDie[], iconHorse[];
    private ImageIcon icon;
    private ArrayList<JButton> bt;
    private ArrayList<JLabel> lbbc, array_lbqc;
    Raquan rq = new Raquan();
    Setup setup = new Setup();
    Xingau xingau = new Xingau();
    Win win = new Win();

    public BancoGUI()  {
       

        

        UIMain();
        prepareImage();
        actionListener();
    }

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    

    public void prepareImage() {
        iconHorse = new ImageIcon[5];
        try {
            BufferedImage image = ImageIO.read(new File("./image/o.jpg"));
            iconHorse[0] = new ImageIcon(image.getScaledInstance(40, 40, image.SCALE_SMOOTH));
        } catch (IOException ex) {
        }
        for (int j = 1; j <= 4; j++) {
            try {
                BufferedImage image = ImageIO.read(new File("./image/H" + j + "-0000.jpg"));
                iconHorse[j] = new ImageIcon(image.getScaledInstance(40, 40, image.SCALE_SMOOTH));
            } catch (IOException ex) {
            }
        }
    }

    public void UIMain() {
        main = new JPanel();
        main.setLayout(null);
        main.setBounds(0, 0, 800, 800);
        main.setBackground(Color.LIGHT_GRAY);
        main.setVisible(true);
        int a = 40, b = 240, k = 0;
        int y1 = 0, y2 = 0, y3 = 7 * a, y4 = 0, y5 = 0, y6 = 6 * a,
                x1 = 0, x2 = 0, x3 = 7 * a, x4 = 0, x5 = 0, x6 = 6 * a;
        bt = new ArrayList<>();
        lbbc = new ArrayList<>();
        array_lbqc = new ArrayList<>();
        txingau = new JTextField();
        txingau.setBounds(720, 0, 50, 50);
//        main.add(txingau);
//        btXingau.setText("Ä�á»•");
        btXingau = new JButton();
        btXingau.setBounds(600, 0, 60, 50);
        btXingau.setText("Do");
        main.add(btXingau);
        btRaquan = new JButton();
        btRaquan.setBounds(660, 70, 90, 50);
        btRaquan.setText("Ra quan");
        btRaquan.setVisible(false);
        main.add(btRaquan);
        btBoluot = new JButton();
        btBoluot.setBounds(605, 130, 260, 50);
        btBoluot.setText("Xong");
        btBoluot.setVisible(false);
        main.add(btBoluot);
        lbXingau = new JLabel();
        lbXingau.setBounds(600, 70, 50, 50);
        t_num = new JTextField("hi");
        t_num.setBounds(600, 140, 30, 30);
        main.add(t_num);
        try {
            BufferedImage image = ImageIO.read(new File("./image/D0.jpg"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, image.SCALE_SMOOTH));
            lbXingau.setIcon(icon);
        } catch (IOException ex) {
        }
        main.add(lbXingau);
        lbHecarim = new JLabel();
        lbHecarim.setBounds(610, 190, 260, 410);
        try {
            BufferedImage image = ImageIO.read(new File("./image/Hecarim.jpg"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(260, 410, image.SCALE_SMOOTH));
            lbHecarim.setIcon(icon);
        } catch (IOException ex) {
        }
        main.add(lbHecarim);
        btRestart = new JButton();
        btRestart.setBounds(780, 0, 90, 40);
        btRestart.setText("Restart");
        main.add(btRestart);

        lbFlag = new JLabel();
        lbFlag.setBounds(670, 0, 40, 40);
        try {
            BufferedImage image = ImageIO.read(new File("./image/H1-0000.jpg"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(40, 40, image.SCALE_SMOOTH));
            lbFlag.setIcon(icon);
        } catch (IOException ex) {
        }
        main.add(lbFlag);
        for (int i = 0; i < 84; i++) {
            lboc = new JLabel();
            lbbc.add(lboc);
            btoc = new JButton();
            String stringCommand = Integer.toString(i);
            btoc.setActionCommand(stringCommand);
            bt.add(btoc);
            bt.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String command = button.getActionCommand();
                    id_btn = Integer.parseInt(command);
                    Dichuyen dichuyen = new Dichuyen();
                    int kqdc = dichuyen.Move();
                    switch (kqdc) {
                        case 1:
                            JOptionPane.showMessageDialog(main, "Ä�i quĂ¡ giá»›i háº¡n cho phĂ©p");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(main, "Ä�Ă£ cĂ³ quĂ¢n cá»§a báº¡n");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(main, "Bá»‹ cháº·n");
                            break;
                        case 5:
                            bt.get(now).setIcon(iconHorse[0]);
                            bt.get(now).setEnabled(false);
                            bt.get(change).setVisible(true);
                            bt.get(change).setEnabled(true);
                            bt.get(change).setIcon(iconHorse[flag]);///di chuyen thanh cong ngoai dich
                            break;
                        case 6:
                            bt.get(now).setVisible(false);
                            bt.get(change).setVisible(true);
                            bt.get(change).setEnabled(true);
                            bt.get(change).setIcon(iconHorse[flag]);
                            break;
                        ///di chuyen thanh cong trong dich

                    }
                    if (num_Xingau == 0) {
                        btRaquan.setVisible(false);
                    }
                    int check = win.CheckWin();
                    if (check == 99) {
                        JOptionPane.showMessageDialog(main, "Player " + flag + " Win");
                        restart();
                    }
                }
            }
            );
        }

        for (int i = 0; i <= 83; i++) {

            bt.get(i).setEnabled(false);
        }

////////////////////////////////*           KHá»�I Táº O BĂ€N Cá»œ      *////////////////////////////////////////
/////////////////////**       setbound sáº¯p xáº¿p lable      **/////////////////////
        for (int i = 0; i < 84; i++) {
            if (i >= 1 && i <= 7) {
                lbbc.get(i).setBounds(b + 2 * a, 560 - y1, a, a);
                main.add(lbbc.get(i));
                y1 = y1 + a;
            }
            if (i >= 77 && i <= 83) {
                lbbc.get(i).setBounds(b + a, 560 - y2, a, a);
                main.add(lbbc.get(i));
                y2 = y2 + a;
            }
            if (i >= 70 && i <= 76) {
                lbbc.get(i).setBounds(b, 600 - y3, a, a);
                main.add(lbbc.get(i));
                y3 = y3 - a;
            }
            /////////////////////////////////////////////

            if (i >= 22 && i <= 28) {
                lbbc.get(i).setBounds(560 - x1, b, a, a);
                main.add(lbbc.get(i));
                x1 = x1 + a;
            }
            if (i >= 14 && i <= 20) {
                lbbc.get(i).setBounds(560 - x2, b + a, a, a);
                main.add(lbbc.get(i));
                x2 = x2 + a;
            }
            if (i >= 7 && i <= 13) {
                lbbc.get(i).setBounds(600 - x3, b + 2 * a, a, a);
                main.add(lbbc.get(i));
                x3 = x3 - a;
            }

            //////////////////////////////////////////////
            if (i >= 43 && i <= 49) {
                lbbc.get(i).setBounds(b, y4, a, a);
                main.add(lbbc.get(i));
                y4 = y4 + a;
            }
            if (i >= 35 && i <= 41) {
                lbbc.get(i).setBounds(b + a, y5, a, a);
                main.add(lbbc.get(i));
                y5 = y5 + a;
            }
            if (i >= 28 && i <= 34) {
                lbbc.get(i).setBounds(b + 2 * a, y6, a, a);
                main.add(lbbc.get(i));
                y6 = y6 - a;
            }
            //////////////////////////////////////////////

            if (i >= 64 && i <= 70) {
                lbbc.get(i).setBounds(x4, b + 2 * a, a, a);
                main.add(lbbc.get(i));
                x4 = x4 + a;
            }
            if (i >= 56 && i <= 62) {
                lbbc.get(i).setBounds(x5, b + a, a, a);
                main.add(lbbc.get(i));
                x5 = x5 + a;
            }
            if (i >= 49 && i <= 55) {
                lbbc.get(i).setBounds(x6, b, a, a);
                main.add(lbbc.get(i));
                x6 = x6 - a;
            }
//////////////////** set anh cho button ,add vao lable  **////////////////////
            if (i >= 57 && i <= 62) {
                lbbc.get(i).setHorizontalAlignment(JLabel.CENTER);
                lbbc.get(i).setOpaque(true);
                lbbc.get(i).setBackground(Color.yellow);
                bt.get(i).setBounds(0, 0, 0, 0);
                lbbc.get(i).add(bt.get(i));
                lbbc.get(i).setText("" + (i) % (7 * 1));
                bt.get(i).setBounds(0, 0, a, a);
                lbbc.get(i).add(bt.get(i));
                bt.get(i).setVisible(false);
            } else if (i >= 15 && i <= 20) {
                lbbc.get(i).setHorizontalAlignment(JLabel.CENTER);
                lbbc.get(i).setOpaque(true);
                lbbc.get(i).setBackground(Color.green);
                bt.get(i).setBounds(0, 0, 0, 0);
                lbbc.get(i).add(bt.get(i));
                lbbc.get(i).setText("" + (i) % (7 * 1));
                bt.get(i).setBounds(0, 0, a, a);
                lbbc.get(i).add(bt.get(i));
                bt.get(i).setVisible(false);
            } else if (i >= 36 && i <= 41) {
                lbbc.get(i).setHorizontalAlignment(JLabel.CENTER);
                lbbc.get(i).setOpaque(true);
                lbbc.get(i).setBackground(Color.blue);
                bt.get(i).setBounds(0, 0, 0, 0);
                lbbc.get(i).add(bt.get(i));
                lbbc.get(i).setText("" + (i) % (7 * 1));
                bt.get(i).setBounds(0, 0, a, a);
                lbbc.get(i).add(bt.get(i));
                bt.get(i).setVisible(false);
            } else if (i >= 78 && i <= 83) {
                lbbc.get(i).setHorizontalAlignment(JLabel.CENTER);
                lbbc.get(i).setOpaque(true);
                lbbc.get(i).setBackground(Color.red);
                bt.get(i).setBounds(0, 0, 0, 0);
                lbbc.get(i).add(bt.get(i));
                lbbc.get(i).setText("" + (i) % (7 * 1));
                bt.get(i).setBounds(0, 0, a, a);
                lbbc.get(i).add(bt.get(i));
                bt.get(i).setVisible(false);
            } //////***     Ă” vá»� Ä‘Ă­ch   ***///////    
            else {
                bt.get(i).setBounds(0, 0, a, a);
                lbbc.get(i).add(bt.get(i));
                try {
                    BufferedImage image = ImageIO.read(new File("./image/o.jpg"));
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(40, 40, image.SCALE_SMOOTH));
                    bt.get(i).setIcon(icon);
                } catch (IOException ex) {
                }
            }

////////////////////**   Ă” Chuá»“ng     **///////////////////////  
            switch (i) {
                case 0:
                    lbbc.get(i).setBounds(361, 361, 242, 242);
                    try {
                        BufferedImage image = ImageIO.read(new File("./image/anh dich 1'.jpg"));
                        ImageIcon icon = new ImageIcon(image.getScaledInstance(242, 242, image.SCALE_SMOOTH));
                        lbbc.get(i).setIcon(icon);
                    } catch (IOException ex) {

                    }
                    bt.get(i).setBounds(0, 0, 2, 2);
                    lbbc.get(i).add(bt.get(i));
                    int o = 0;

                    main.add(lbbc.get(i));

                    break;
                case 21:
                    lbbc.get(i).setBounds(360, 0, 242, 242);
                    try {
                        BufferedImage image = ImageIO.read(new File("./image/anh dich 2'.jpg"));
                        ImageIcon icon = new ImageIcon(image.getScaledInstance(242, 242, image.SCALE_SMOOTH));
                        lbbc.get(i).setIcon(icon);
                    } catch (IOException ex) {

                    }
                    bt.get(i).setBounds(0, 0, 2, 2);
                    lbbc.get(i).add(bt.get(i));
                    o = 0;

                    main.add(lbbc.get(i));
                    break;
                case 42:
                    lbbc.get(i).setBounds(0, 0, 242, 242);
                    try {
                        BufferedImage image = ImageIO.read(new File("./image/anh dich 3'.jpg"));
                        ImageIcon icon = new ImageIcon(image.getScaledInstance(242, 242, image.SCALE_SMOOTH));
                        lbbc.get(i).setIcon(icon);
                    } catch (IOException ex) {

                    }
                    bt.get(i).setBounds(0, 0, 2, 2);
                    lbbc.get(i).add(bt.get(i));
                    o = 0;

                    main.add(lbbc.get(i));
                    break;
                case 63:
                    lbbc.get(i).setBounds(0, 360, 242, 242);
                    try {
                        BufferedImage image = ImageIO.read(new File("./image/anh dich 4'.jpg"));
                        ImageIcon icon = new ImageIcon(image.getScaledInstance(242, 242, image.SCALE_SMOOTH));
                        lbbc.get(i).setIcon(icon);
                    } catch (IOException ex) {

                    }
                    bt.get(i).setBounds(0, 0, 2, 2);
                    lbbc.get(i).add(bt.get(i));
                    o = 0;

                    main.add(lbbc.get(i));
                    break;
            }
        }
        m = new JFrame();
        m.setDefaultCloseOperation(m.EXIT_ON_CLOSE);
        m.add(main);
        m.setSize(885, 640);
        m.setVisible(true);

    }

    public void actionListener() {

        ActionListener ButtonRandom = new ButtonRandom();
        ActionListener ButtonRaquan = new ButtonRaquan();
        ActionListener ButtonBoluot = new ButtonBoluot();
        ActionListener ButtonRestart = new ButtonRestart();
        ActionListener Txt = new Txt();
        btRestart.addActionListener(ButtonRestart);
        btXingau.addActionListener(ButtonRandom);
        btRaquan.addActionListener(ButtonRaquan);
        btBoluot.addActionListener(ButtonBoluot);
        txingau.addActionListener(Txt);

    }

    private class Txt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

        }
    }

    private class ButtonRaquan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            btXingau.setEnabled(true);

            int kq = rq.Raquan();
            switch (kq) {
                case -1:
                    bt.get(rq.vt_raquan).setIcon(iconHorse[flag]);
                    bt.get(rq.vt_raquan).setEnabled(true);
                    btRaquan.setVisible(false);
                    num_Xingau = 0;
                    break;
                case 1:
                    JOptionPane.showMessageDialog(main, "Ä�Ă¡.");
                    bt.get(rq.vt_raquan).setIcon(iconHorse[flag]);
                    bt.get(rq.vt_raquan).setEnabled(true);
                    btRaquan.setVisible(false);
                    num_Xingau = 0;
                    break;
                case 2:
                    JOptionPane.showMessageDialog(main, "Vá»‹ trĂ­ Ä‘Ă£ cĂ³ quĂ¢n cá»§a báº¡n.");

                    break;

            }

        }
    }

    private class ButtonBoluot implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (!(num_Xingau == 1 || num_Xingau == 6 || num_Xingau == 0)) {
                if (flag < 4) {
                    flag += 1;
                } else {
                    flag = 1;
                }
            }
            switch (flag) {
                case 1:
                    lbFlag.setIcon(iconHorse[flag]);
                    break;
                case 2:
                    lbFlag.setIcon(iconHorse[flag]);
                    break;
                case 3:
                    lbFlag.setIcon(iconHorse[flag]);
                    break;
                case 4:
                    lbFlag.setIcon(iconHorse[flag]);
                    break;
            }
            btXingau.setEnabled(true);
            num_Xingau = 0;
        }
    }

    public void Xuliluotdi() {
        btXingau.setEnabled(false);
        btBoluot.setVisible(true);
        if (num_Xingau == 1 || num_Xingau == 6) {
            btRaquan.setVisible(true);
        } else {
            btRaquan.setVisible(false);

        }

    }

    public void restart() {
        m.setVisible(false);

        
			BancoGUI bcGUI = new BancoGUI();
		

        ArrayListBC ar = new ArrayListBC();
        flag = 1;
    }

    private class ButtonRestart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            restart();

        }
    }

    private class ButtonRandom implements ActionListener {

    	 @Override
         public void actionPerformed(ActionEvent arg0) {
//             die.thrown();
//             num_Xingau = die.getSteps();
    		 xingau.Doxingau();

             try {
                 BufferedImage image = ImageIO.read(new File("./image/D" + num_Xingau + ".jpg"));
                 ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, image.SCALE_SMOOTH));
                 lbXingau.setIcon(icon);
             } catch (IOException ex) {

             }

             Xuliluotdi();
         }
    }

    public static void main(String arg[]) {

        BancoGUI bcGUI = new BancoGUI();
        ArrayListBC ar = new ArrayListBC();

    }
}
