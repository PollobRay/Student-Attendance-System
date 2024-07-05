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
import javax.swing.JSpinner;

import javax.swing.SpinnerNumberModel;


public class SearchStudent extends JFrame
{
 private Container c;
    private Font font,font1;
    private JLabel stdtec, stdsem, stdroll, stdgroup,ss,back,sas,biit;
    private JComboBox stdtecC, stdsemC, stdgroupC;
    private JSpinner stdrollS;
    private SpinnerNumberModel value;
    private final String tec[] = {"Computer", "Electronics", "Electrical", "Civil", "Automobile", "Architecture", "Mechanical", "Telecommunication", "Textile", "Garmance"};
    private final String[] sem = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
    private final String[] grp={"A","B","C","D"};
     private ImageIcon s,b,icon,sa,biiti;
     private Cursor cursor;
    
    public SearchStudent()
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
       
        sa=new ImageIcon(getClass().getResource("image/SRT.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(300, 70, 800, 80);
        c.add(sas);
        
         // student roll
        stdroll = new JLabel("Student Roll");
        stdroll.setBounds(350, 200, 200, 50);
        stdroll.setFont(font);
        stdroll.setForeground(Color.BLUE);
        c.add(stdroll);

        // specific value:
        value = new SpinnerNumberModel(10, 1, 200, 1);// initialization, min, max, Inc/Dec
        stdrollS = new JSpinner(value);
        stdrollS.setBounds(550, 205, 70, 40);
        stdrollS.setFont(font1);
        stdrollS.setBackground(null);
        //stdrollS.setBorder(null);
        stdrollS.setToolTipText("SELECT ROLL");
        c.add(stdrollS);

        // student Technology
        stdtec = new JLabel("Technology");
        stdtec.setBounds(650, 200, 150, 50);
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

        //       student seme
        stdsem = new JLabel("Semester");
        stdsem.setBounds(400, 320, 150, 50);
        stdsem.setFont(font);
        stdsem.setForeground(Color.BLUE);
        c.add(stdsem);

        stdsemC = new JComboBox(sem);
        stdsemC.setBounds(550, 325, 100, 40);
        stdsemC.setFont(font1);
        stdsemC.setBackground(null);
        stdsemC.setBorder(null);
         stdsemC.setToolTipText("SELECT SEMESTER");
        c.add(stdsemC);
        
        
        // student group
         stdgroup = new JLabel("Group");
        stdgroup.setBounds(800, 320, 150, 50);
        stdgroup.setFont(font);
        stdgroup.setForeground(Color.BLUE);
        c.add(stdgroup);

        stdgroupC = new JComboBox(grp);
        stdgroupC.setBounds(900, 325, 50, 40);
        stdgroupC.setFont(font1);
        stdgroupC.setBackground(null);
        stdgroupC.setBorder(null);
        stdgroupC.setToolTipText("SELECT GROUP");
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
        
        //              Handling
       class Handler implements MouseListener
                {

         @Override
         public void mouseClicked(MouseEvent e) {
             if (e.getSource()==ss)
             {
                 Attendance at=new Attendance();
                 String r=stdrollS.getValue().toString();
                 at.rolld.setText(r);
                 String s=stdtecC.getSelectedItem().toString();
                 at.tecd.setText(s);
                 String sm=stdsemC.getSelectedItem().toString();
                 at.semd.setText(sm);
                 
                 String g=stdgroupC.getSelectedItem().toString();
                  at.groupd.setText(g);
                  String grp="";
                    
                     switch(g)
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
                  
                  
                     int roll=Integer.parseInt(r);
                     String tab ="";
                     
                  try{
                     
                      String sql="select* from  std where Roll=? and Department=? and Section=? and Semester=?";
                  
                  at.con1 = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                   at.pst1 = at.con1.prepareStatement(sql);
                   at.pst1.setInt(1,roll);
                   at.pst1.setString(2,s);
                    at.pst1.setString(3,grp);
                  at.pst1.setString(4,sm);
                 
                  
                  at.rs1=at.pst1.executeQuery();
                  at.rs1.next();
                  tab=at.rs1.getString(6);
                  at.named.setText(at.rs1.getString(2));
                  
                  //System.out.println(tab);
                  at.pst1.close();
                  at.con1.close();
                      
                      
                  }
                  catch(HeadlessException | SQLException ex)
                  {
                    JOptionPane.showMessageDialog(null,"Not Found");  
                  }
                 
                  String sql1="select* from `"+tab+"`;";
                  int par=0;
                  
                  try{
                      at.con2=DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                       at.pst2 = at.con2.prepareStatement(sql1);
                        at.rs2= at.pst2.executeQuery();
                  
                  
                  while(at.rs2.next())
                  {
                      at.rows[0]=at.rs2.getString(2);
                      String a=at.rs2.getString(4);
                      if("1".equals(a))
                      {
                          at.rows[1]="P";
                          par++;
                      }
                      else{
                          at.rows[1]=".";
                      }
                      
                      at.model.addRow(at.rows);
                  }
                  
                  at.pst2.close();
                  at.con2.close();
                  at.setVisible(true);
                  at.pard.setText(""+par);
                 dispose();
                  }
                  catch(SQLException ex)
                  {
                     JOptionPane.showMessageDialog(null,"Not Found"); 
                  }
                  
                 
             }
             else if(e.getSource()==back)
             {
                 Interface i=new Interface();
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
       
       Handler h=new Handler();
       ss.addMouseListener(h);
       back.addMouseListener(h);
    }
    
    /*
    public static void main(String[] args) {
        
        
        SearchStudent s=new SearchStudent();
        s.setVisible(true);
    }
*/
}
