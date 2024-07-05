package inc.roy.managements.front;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MakeAttendance extends JFrame {

    private Container c;
    private Font font, font1;
    private JLabel stdtec, stdsem, stdroll, stdgroup, back, att,sas,biit;
    private JComboBox stdtecC, stdsemC, stdgroupC;
    private final String tec[] = {"Computer", "Electronics", "Electrical", "Civil", "Automobile", "Architecture", "Mechanical", "Telecommunication", "Textile", "Garmance"};
    private final String[] sem = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
    private final String[] grp = {"A", "B", "C", "D"};
    private ImageIcon a, b,icon,sa,biiti;
    private Cursor cursor;
    private Connection con1 = null;
    private PreparedStatement pst1 = null;
    private ResultSet rs1 = null;
    private Statement stmt1 = null;

    public MakeAttendance() {
        initp();
    }

    public void initp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        font = new Font("Bahnschrift SemiLight", Font.BOLD, 25);
        font1 = new Font("Arial", Font.BOLD, 18);

        cursor = new Cursor(Cursor.HAND_CURSOR);
   // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());
        this.setTitle("STUDENT ATTENDANCE SYSTEM");
        
        //make full screen
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(screenSize);
        /**
         * // for set screen full Toolkit kb = Toolkit.getDefaultToolkit();
         *
         * int x, y; x = (int) kb.getScreenSize().getWidth(); y = (int)
         * kb.getScreenSize().getHeight(); this.setSize(x, y);
         *
         *
         */
        Toolkit kb=Toolkit.getDefaultToolkit();
        
        int x,y,w;
        x=(int)kb.getScreenSize().getWidth();
        y=(int)kb.getScreenSize().getHeight();
        //this.setSize(x, y);
        if(x>=1366)
       {
          w=300; 
       }
       else
       {
          w=250; 
       }
  //       student attendance system
       sa=new ImageIcon(getClass().getResource("image/AT.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(w, 70, 800, 80);
        c.add(sas);
        
        stdtec = new JLabel("Technology");
        stdtec.setBounds(645, 200, 150, 50);
        stdtec.setFont(font);
        stdtec.setForeground(Color.BLUE);
        c.add(stdtec);

        stdtecC = new JComboBox(tec);
        stdtecC.setBounds(800, 205, 200, 40);
        stdtecC.setFont(font1);
        stdtecC.setBackground(null);
        stdtecC.setBorder(null);
        stdtecC.setToolTipText("SELECT TECHNOLOGY");
        c.add(stdtecC);

        stdsem = new JLabel("Semester");
        stdsem.setBounds(350, 320, 150, 50);
        stdsem.setFont(font);
        stdsem.setForeground(Color.BLUE);
        c.add(stdsem);

        stdsemC = new JComboBox(sem);
        stdsemC.setBounds(490, 325, 110, 40);
        stdsemC.setFont(font1);
        stdsemC.setBackground(null);
        stdsemC.setBorder(null);
        stdsemC.setToolTipText("SELECT SEMESTER");
        c.add(stdsemC);

        // student group
        stdgroup = new JLabel("Group");
        stdgroup.setBounds(850, 320, 150, 50);
        stdgroup.setFont(font);
        stdgroup.setForeground(Color.BLUE);
        c.add(stdgroup);

        stdgroupC = new JComboBox(grp);
        stdgroupC.setBounds(950, 325, 50, 40);
        stdgroupC.setFont(font1);
        stdgroupC.setBackground(null);
        stdgroupC.setBorder(null);
        stdgroupC.setToolTipText("SELECT GROUP");
        c.add(stdgroupC);

        // BACK
        b = new ImageIcon(getClass().getResource("image/B.png"));
        Image bck = b.getImage();
        Image bak = bck.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon backc = new ImageIcon(bak);

        back = new JLabel(backc);
        back.setBounds(420, 550, 250, 50);
        back.setCursor(cursor);
        back.setToolTipText("BACK");
        c.add(back);

        //          search
        a = new ImageIcon(getClass().getResource("image/A.png"));
        Image signu = a.getImage();
        Image sup = signu.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon signup = new ImageIcon(sup);

        att = new JLabel(signup);
        att.setBounds(680, 550, 250, 50);
        att.setCursor(cursor);
        att.setToolTipText("ATTENDANCE");
        c.add(att);
        
         // Biit
        biiti=new ImageIcon(getClass().getResource("image/biit.jpg"));
        Image bti=biiti.getImage();
	Image bt=bti.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon bimg=new ImageIcon(bt);
        
        biit=new JLabel(bimg);
        biit.setBounds(50,600,100,100);
        biit.setToolTipText("BIIT, Bogra");
        c.add(biit);
        
        //          Handle  class
        GroupAttendance gr = new GroupAttendance();

        class Handler implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {

                String t = stdtecC.getSelectedItem().toString();
                String s = stdsemC.getSelectedItem().toString();
                String g = stdgroupC.getSelectedItem().toString();

                if (e.getSource() == att) {
                    // GroupAttendance gr=new GroupAttendance();
                    gr.tecd.setText(t);
                    gr.semd.setText(s);
                    gr.grpd.setText(g);

                    //           pr
                    String grpp = g;
                    String grpr = null;
                    switch (grpp) {
                        case "A": {
                            grpr = "a";
                            break;
                        }
                        case "B": {
                            grpr = "b";
                            break;
                        }
                        case "C": {
                            grpr = "c";
                            break;
                        }
                        case "D": {
                            grpr = "d";
                            break;
                        }

                    }

                    //          db
                    try {
                        String sql = "select* from  std where Department=? and Section=? and Semester=?";
                        //String sql1="insert into ? (Date,Time,Attendance) values (?,?,?) ;";

                        gr.con = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                        gr.pst = gr.con.prepareStatement(sql);
                        gr.pst.setString(1, t);
                        gr.pst.setString(2, grpr);
                        gr.pst.setString(3, s);

                        /*            Insert
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
        pst1 = con1.prepareStatement(sql1);
                         */
                        int i = 0;

                        gr.rs = gr.pst.executeQuery();

                        //  while(gr.rs.next())
                        //  {j++;}
                        //  if(j!=0){
                        //    k=j-1;
                        gr.tabl = new String[10];

                        //}
                        while (gr.rs.next()) {
                            String r = String.valueOf(gr.rs.getInt(3));
                            String n = "  " + r + "          " + gr.rs.getString(2) + "                           ";
                            gr.check[i] = new JCheckBox(n);
                            gr.check[i].setFont(font);
                            gr.check[i].setBackground(null);
                            gr.check[i].setBorder(null);
                            gr.panel.add(gr.check[i]);

                            /*                   Insert
           String tb=gr.rs.getString(6);
           String dt="2018-08-25";
           String 
          pst1.setString(1, g);
          int count = pst1.executeUpdate();
          if(count==1)
            {
                JOptionPane.showMessageDialog(null, "Success"); 
               
            }  
                             */
                            i++;

                        }

                        gr.totald.setText("" + i);
                        gr.con.close();

                        gr.setVisible(true);
                        dispose();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Cheeck your Server Conection");
                    }

                } else if (e.getSource() == back) {
                    Interface i = new Interface();
                    i.setVisible(true);

                    dispose();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        }

        Handler h = new Handler();
        att.addMouseListener(h);
        back.addMouseListener(h);

    }
 /*
    public static void main(String[] args) {

        MakeAttendance m = new MakeAttendance();
        m.setVisible(true);
    }
*/
}
