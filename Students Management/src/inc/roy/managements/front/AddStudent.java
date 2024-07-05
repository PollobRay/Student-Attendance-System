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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class AddStudent extends JFrame {

    private Container c;
    private Font font,font1;
    private JLabel stdname, stdtec, stdsem, stdroll, stdgroup,adds,back,sas,biit;
    private JTextField stdnameT;
    private JComboBox stdtecC, stdsemC, stdgroupC;
    private JSpinner stdrollS;
    private SpinnerNumberModel value;
    private final String tec[] = {"Computer", "Electronics", "Electrical", "Civil", "Automobile", "Architecture", "Mechanical", "Telecommunication", "Textile", "Garmance"};
    private final String[] sem = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
    private final String[] grp={"A","B","C","D"};
    private ImageIcon a,b,sa,icon,biiti;
    private Cursor cursor;
    private Connection con = null,con1;
    private PreparedStatement pst = null,pst1;
    private ResultSet rs = null,rs1;
    private Statement stmt = null;
    

   public AddStudent() {
        initp();
    }

    public void initp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
        font = new Font("Bahnschrift SemiLight", Font.BOLD, 25);
        font1 = new Font("Arial", Font.BOLD,18);
        
        cursor =new Cursor(Cursor.HAND_CURSOR);
        this.setTitle("STUDENT ATTENDANCE SYSTEM");
           // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());
        //make full screen
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(screenSize);
         //this.setResizable(false);
           
        // for set screen full
        Toolkit kb = Toolkit.getDefaultToolkit();

        int x, y,w;
        x = (int) kb.getScreenSize().getWidth();
        y = (int) kb.getScreenSize().getHeight();
       // this.setSize(x, y);
       if(x>=1366)
       {
          w=300; 
       }
       else
       {
          w=250; 
       }

        //       student attendance system
       sa=new ImageIcon(getClass().getResource("image/AST.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(w, 70, 800, 80);
        c.add(sas);
        
        // student name
        stdname = new JLabel("Student Name");
        stdname.setBounds(250, 200, 200, 50);
        stdname.setFont(font);
        stdname.setForeground(Color.BLUE);
        c.add(stdname);

        stdnameT = new JTextField();
        stdnameT.setBounds(420, 205, 250, 40);
        stdnameT.setFont(font);
        //  stdnameT.setBorder(null);
        stdnameT.setBackground(null);
        c.add(stdnameT);

        // student roll
        stdroll = new JLabel("Student Roll");
        stdroll.setBounds(800, 200, 200, 50);
        stdroll.setFont(font);
        stdroll.setForeground(Color.BLUE);
        c.add(stdroll);

        // specific value:
        value = new SpinnerNumberModel(10, 1, 200, 1);// initialization, min, max, Inc/Dec
        stdrollS = new JSpinner(value);
        stdrollS.setBounds(950, 205, 70, 40);
        stdrollS.setFont(font1);
        stdrollS.setBackground(null);
        //stdrollS.setBorder(null);
        c.add(stdrollS);

        // student Technology
        stdtec = new JLabel("Technology");
        stdtec.setBounds(250, 320, 150, 50);
        stdtec.setFont(font);
        stdtec.setForeground(Color.BLUE);
        c.add(stdtec);

        stdtecC = new JComboBox(tec);
        stdtecC.setBounds(420, 325, 150, 40);
        stdtecC.setFont(font1);
        stdtecC.setBackground(null);
        stdtecC.setBorder(null);
        c.add(stdtecC);

        //       student seme
        stdsem = new JLabel("Semester");
        stdsem.setBounds(610, 320, 150, 50);
        stdsem.setFont(font);
        stdsem.setForeground(Color.BLUE);
        c.add(stdsem);

        stdsemC = new JComboBox(sem);
        stdsemC.setBounds(740, 325, 100, 40);
        stdsemC.setFont(font1);
        stdsemC.setBackground(null);
        stdsemC.setBorder(null);
        c.add(stdsemC);
        
        
        // student group
         stdgroup = new JLabel("Group");
        stdgroup.setBounds(880, 320, 150, 50);
        stdgroup.setFont(font);
        stdgroup.setForeground(Color.BLUE);
        c.add(stdgroup);

        stdgroupC = new JComboBox(grp);
        stdgroupC.setBounds(970, 325, 50, 40);
        stdgroupC.setFont(font1);
        stdgroupC.setBackground(null);
        stdgroupC.setBorder(null);
        c.add(stdgroupC);
        
        
        
         
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
        
        
        

    //          add
        a=new ImageIcon(getClass().getResource("image/AS.png"));
        Image signu=a.getImage();
	Image sup=signu.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon signup=new ImageIcon(sup);
        
         adds=new JLabel(signup);
        adds.setBounds(680,550,250,50);
        adds.setCursor(cursor);
        adds.setToolTipText("ADD STUDENT");
        c.add(adds);

         // Biit
        biiti=new ImageIcon(getClass().getResource("image/biit.jpg"));
        Image bti=biiti.getImage();
	Image bt=bti.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon bimg=new ImageIcon(bt);
        
        biit=new JLabel(bimg);
        biit.setBounds(50,600,100,100);
        biit.setToolTipText("BIIT, Bogra");
        c.add(biit);
        
        //          listener
        class Handler implements MouseListener
        {

            @Override
            public void mouseClicked(MouseEvent e) {
                 if(e.getSource()==back)
                 {
                     Interface i=new Interface();
                     i.setVisible(true);
                     dispose();
                 }
                 else if(e.getSource()==adds)
                 {
                     String name=stdnameT.getText();
                     String roll=stdrollS.getValue().toString();
                     String sem=stdsemC.getSelectedItem().toString();
                     String tec=stdtecC.getSelectedItem().toString();
                     String grps=stdgroupC.getSelectedItem().toString();
                     int rolli=(int) stdrollS.getValue();
                     String grp = null;
                    
                     switch(grps)
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
                       
                         
                     }
                       //  start
                         try{
                              con1 = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                              String sp="select * from std where Roll=? and Department=? and Semester=? ;";
                            pst1 = con1.prepareStatement(sp);
                           
                            pst1.setInt(1,rolli);
                            pst1.setString(2,tec);
                            pst1.setString(3,sem);
                           
                             rs1=pst1.executeQuery();
                             if(rs1.next())
                             {
                                 JOptionPane.showMessageDialog(null,"The Student is Alredy Exists !");
                             }
                             else
                             {
                                 //JOptionPane.showMessageDialog(null,"No !");
                                 
                                     String tab=sem+""+tec+""+grp+""+roll;
                    // JOptionPane.showMessageDialog(null," "+all);
                    
                    String sql="insert into std (Name,Roll,Department,Section,Tables,Semester) values (?,?,?,?,?,?) ;";
                   
                    
                    String sql3="CREATE TABLE "+tab+" ( `Id` INT NOT NULL AUTO_INCREMENT , "
                            + "`Date` TEXT NOT NULL , `Time` TEXT NOT NULL , `Attendance` TEXT NOT NULL , PRIMARY KEY (`Id`));";
                    
                    
                    if("".equals(name))
                    {
                        
                    }
                    else
                    {
                        try{

                            con = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                            pst = con.prepareStatement(sql);
                            pst.setString(1,name);
                            pst.setInt(2,rolli);
                            pst.setString(3,tec);
                            pst.setString(4,grp);
                            pst.setString(5,tab);
                            pst.setString(6,sem);

                            
                            
                            stmt = con.createStatement();
                            stmt.executeUpdate(sql3);
                            
                            
                            int count = pst.executeUpdate();
                           if(count==1)
                           {
                              JOptionPane.showMessageDialog(null, "Success"); 
                              stdnameT.setText("");
                              
                           }
                           
                           
                           con.close();
                        }
                    
                        catch(HeadlessException | SQLException ex)
                        {
                            JOptionPane.showMessageDialog(null, "Cheeck your server cunnection");
                        }
                    
                     }
                             }
                            con1.close();
                         }
                         catch(Exception ex)
                         {
                             JOptionPane.showMessageDialog(null,"Check server Connection");
                         }
                         
                         // end
                
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {}
                
            @Override
            public void mouseReleased(MouseEvent e) {}
            
            @Override
            public void mouseEntered(MouseEvent e) {}
             
            @Override
            public void mouseExited(MouseEvent e) {}
                
           
       
        }
    
        
        Handler h=new Handler();
        adds.addMouseListener(h);
        back.addMouseListener(h);

            
    }
    /**
    public static void main(String[] args) {

        AddStudent s = new AddStudent();
        s.setVisible(true);
    }
    */
}
