
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
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DayAttendance extends JFrame
{
    private Container c;
    private Font font,font1;
    private JLabel stdtec, stdsem, stdgroup,back,ss,sas,date,biit;
    private JTextField datet;
    private JComboBox stdtecC, stdsemC, stdgroupC;
    private final String tec[] = {"Computer", "Electronics", "Electrical", "Civil", "Automobile", "Architecture", "Mechanical", "Telecommunication", "Textile", "Garmance"};
    private final String[] sem = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
    private final String[] grp={"A","B","C","D"};
    private ImageIcon s,b,icon,sa,biiti;
     private Cursor cursor;
    
    public DayAttendance()
    {
        initp();
    }
    
    
    public void initp()
    {
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
        font = new Font("Bahnschrift SemiLight", Font.BOLD, 25);
        font1 = new Font("Arial", Font.BOLD,18);
        cursor =new Cursor(Cursor.HAND_CURSOR);
              // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());
        this.setTitle("STUDENT ATTENDANCE SYSTEM");
        
        //make full screen
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(screenSize);
        
      
        // for set screen full
        Toolkit kb = Toolkit.getDefaultToolkit();

        int x, y,w;
        x = (int) kb.getScreenSize().getWidth();
        y = (int) kb.getScreenSize().getHeight();
        //this.setSize(x, y);
        if(x>=1366)
       {
          w=300; 
       }
       else
       {
          w=250; 
       }
        
          //  group report
       sa=new ImageIcon(getClass().getResource("image/DR.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(w, 70, 800, 80);
        c.add(sas);
        // student Technology
        stdtec = new JLabel("Technology");
        stdtec.setBounds(500, 200, 150, 50);
        stdtec.setFont(font);
        stdtec.setForeground(Color.BLUE);
        c.add(stdtec);

        stdtecC = new JComboBox(tec);
        stdtecC.setBounds(650, 205, 200, 40);
        stdtecC.setFont(font1);
        stdtecC.setBackground(null);
        stdtecC.setBorder(null);
        c.add(stdtecC);

        //       student seme
        stdsem = new JLabel("Semester");
        stdsem.setBounds(550, 290, 150, 50);
        stdsem.setFont(font);
        stdsem.setForeground(Color.BLUE);
        c.add(stdsem);

        stdsemC = new JComboBox(sem);
        stdsemC.setBounds(700, 295, 100, 40);
        stdsemC.setFont(font1);
        stdsemC.setBackground(null);
        stdsemC.setBorder(null);
        c.add(stdsemC);
        
        
        // student group
         stdgroup = new JLabel("Group");
        stdgroup.setBounds(580, 370, 150, 50);
        stdgroup.setFont(font);
        stdgroup.setForeground(Color.BLUE);
        c.add(stdgroup);

        stdgroupC = new JComboBox(grp);
        stdgroupC.setBounds(700, 375, 50, 40);
        stdgroupC.setFont(font1);
        stdgroupC.setBackground(null);
        stdgroupC.setBorder(null);
        c.add(stdgroupC);
        
        //  date
         date = new JLabel("Date");
        date.setBounds(550, 450, 100, 50);
        date.setFont(font);
        date.setForeground(Color.BLUE);
        c.add(date);
        
        datet=new JTextField();
        datet.setBounds(650,450,200,50);
        datet.setFont(font);
        datet.setToolTipText("YYYY-MM-DD");
        c.add(datet);
        
          // BACK
        
        b=new ImageIcon(getClass().getResource("image/B.png"));
        Image bck=b.getImage();
	Image bak=bck.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon backc=new ImageIcon(bak);
        
         back=new JLabel(backc);
        back.setBounds(420,550,250,50);
        back.setCursor(cursor);
       back.setToolTipText("BACK");
        c.add(back);
        
        
        

    //          search
        s=new ImageIcon(getClass().getResource("image/SE.png"));
        Image signu=s.getImage();
	Image sup=signu.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon signup=new ImageIcon(sup);
        
         ss=new JLabel(signup);
        ss.setBounds(680,550,250,50);
        ss.setCursor(cursor);
        ss.setToolTipText("SEARCH");
        c.add(ss);
        
         // Biit
        biiti=new ImageIcon(getClass().getResource("image/biit.jpg"));
        Image bti=biiti.getImage();
	Image bt=bti.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon bimg=new ImageIcon(bt);
        
        biit=new JLabel(bimg);
        biit.setBounds(50,600,100,100);
        biit.setToolTipText("BIIT, Bogra");
        c.add(biit);
        
         ViewDayAttendance gs=new ViewDayAttendance();
        
         //  Handling 
         class Handler implements MouseListener
         {  @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getSource()==ss)
               {
                   String dmp=datet.getText();
                   if(dmp.equals(""))
                   {
                       JOptionPane.showMessageDialog(null,"Enter Date");
                   }
                   else
                   {
                   String t=stdtecC.getSelectedItem().toString();
                    String s=stdsemC.getSelectedItem().toString();
                    String g=stdgroupC.getSelectedItem().toString();
                    String d=datet.getText();
                    
                    gs.tecd.setText(t);
                    gs.semd.setText(s);
                    gs.grpd.setText(g);
                    gs.dated.setText(d);
                    
                    int total=0;
                    int totalpresent=0;
                    
                    String grp="";
                    switch(g) // start switch
                     {
                         case "A":
                         {
                             grp="a";
                             break;
                         }
                         case "B":
                         {
                             grp="b";
                             break;
                         }
                         case "C":
                         {
                             grp="c";
                             break;
                         }
                         case "D":
                         {
                             grp="d";
                             break;
                         }
                            
                     } /// end switch
                    
                   // String tbl[]=new String[60];
                    String sql="select* from  std where Department=? and Section=? and Semester=?";
                   // String sq="";
                    int i=0;
                    try{        // select table
                     gs.con = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                     gs.pst = gs.con.prepareStatement(sql);
                     gs.pst.setString(1,t);
                     gs.pst.setString(2,grp);
                     gs.pst.setString(3,s);  
                  
                    gs.rs=gs.pst.executeQuery();
                    
                    while(gs.rs.next())
                    {
                         gs.rows[0]=gs.rs.getString(3); 
                         gs.rows[1]=gs.rs.getString(2);
                         String tb=gs.rs.getString(6);
                         
                         String dt="";
                         ///     get attendance
                         total++;
                     
                        int par=0;
                         String sq="select* from `"+tb+"` where Date=? ;";
                         try{
                             gs.pst1 = gs.con.prepareStatement(sq);
                             gs.pst1.setString(1, d);
                             gs.rs1= gs.pst1.executeQuery();
                        
                             while(gs.rs1.next())
                            {
                            String a=gs.rs1.getString(4);
                            if("1".equals(a))
                                {
                                    dt="P";
                                    totalpresent++;
                                }
                            else{
                                    dt=".";
                                }
                            }
                             gs.pst1.close();
                            }
                        catch(HeadlessException | SQLException ex)
                            {
                             //JOptionPane.showMessageDialog(null,"Not Found");  
                             }
                        /* 
                         if(dt.equals(""))
                         {
                             dt=".";
                         }
                         */
                     gs.rows[2]=""+dt;
                     gs.model.addRow(gs.rows);
                    }// end while
                    
                  gs.con.close();
                  gs.pst.close();
                  
                  gs.totald.setText(""+total);
                  gs.totalpd.setText(""+totalpresent);
                  gs.setVisible(true);
                  dispose();
                  
                    } // end try
                    catch(SQLException ex)
                    {
                        JOptionPane.showMessageDialog(null,"Check Your Server Connection");
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(null,"Check Your Server Connection");
                    }
                   }// end else    
               } // end if
               
               else if(e.getSource()==back)
                {
                   Interface i=new Interface();
                   i.setVisible(true);
                   dispose();
                } 
            } // end method
              @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            
         }
        
         
         
          Handler h=new Handler();
        ss.addMouseListener(h);
        back.addMouseListener(h);
        
     
    }
    /**
    public static void main(String[] args) {
        
        
          DayAttendance s=new DayAttendance();
          s.setVisible(true);
    }
    * */
}
