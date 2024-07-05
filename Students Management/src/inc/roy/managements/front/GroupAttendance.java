package inc.roy.managements.front;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GroupAttendance extends JFrame
{

   public JLabel grp;
  public  JLabel grpd;
   public JLabel tec;
 public  JLabel tecd;
  public JLabel total;
  public JLabel totald;
  public JLabel back;
  public  JLabel sem;
   public JLabel semd,biit;
  private Font font;
  private Container c;
  private Cursor cursor;
  private ImageIcon b,s,icon,biiti;
  protected JLabel submit,roll,name;
  String []columns={"","Roll","Name","Extra"};
  String []rows=new String[2];
  //private JTable table;
  //private DefaultTableModel model;
  private JScrollPane scroll;
  public JPanel panel,rollp,namep;
  public JCheckBox check[];
   public Connection con = null,con1,con2;
    public  PreparedStatement pst = null,pst1,pst2;
    public  ResultSet rs = null,rs1,rs2;
    public  Statement stmt = null;
    private FlowLayout fLayout;
    protected String []tabl;
    
    
    
    public GroupAttendance()
    {
        initp();
    }
    
    public void initp()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
        font=new Font("Bahnschrift SemiLight",Font.BOLD,20);
        cursor =new Cursor(Cursor.HAND_CURSOR);
        this.setTitle("STUDENT ATTENDANCE SYSTEM");
             // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());      
        //make full screen
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(screenSize);
        
        // for set screen full
        Toolkit kb=Toolkit.getDefaultToolkit();
        
        int x,y,w;
        x=(int)kb.getScreenSize().getWidth();
        y=(int)kb.getScreenSize().getHeight();
        //this.setSize(x, y);
        if(x>=1366)
       {
          w=1100; 
       }
       else
       {
          w=1000; 
       }
        
        
        // BACK
        
        b=new ImageIcon(getClass().getResource("image/B.png"));
        Image bck=b.getImage();
	Image bak=bck.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon backc=new ImageIcon(bak);
        
         back=new JLabel(backc);
        back.setBounds(10,10,250,50);
        back.setCursor(cursor);
       back.setToolTipText("BACK");
        c.add(back);
        
        
        
        //      tecnology
        tec=new JLabel("Technology     :");
        tec.setBounds(500, 50, 200, 50);
        tec.setFont(font);
        tec.setForeground(Color.BLUE);
        c.add(tec);
        
        tecd=new JLabel();
        tecd.setBounds(700, 50, 300, 50);
        tecd.setFont(font);
        c.add(tecd);
        
        
         //      semester
        sem=new JLabel("Semester         :");
        sem.setBounds(500, 90, 200, 50);
        sem.setFont(font);
        sem.setForeground(Color.BLUE);
        c.add(sem);
        
        semd=new JLabel();
        semd.setBounds(700, 90, 50, 50);
        semd.setFont(font);
        c.add(semd);
        
        
        //      group
      grp=new JLabel("Group              :");
      grp.setBounds(500,120,200,50);
      grp.setFont(font);
      grp.setForeground(Color.BLUE);
      c.add(grp);
      
      grpd=new JLabel();
      grpd.setBounds(700,120,100,50);
      grpd.setFont(font);
      c.add(grpd);
      
      
      //        total student
      total=new JLabel("Total Students :");
      total.setBounds(500,150,200,50);
      total.setFont(font);
      total.setForeground(Color.BLUE);
      c.add(total);
      
      totald=new JLabel();
      totald.setBounds(700,150,100,50);
      totald.setFont(font);
      c.add(totald);
      
      // roll
      roll=new JLabel("Roll");
      roll.setBounds(430,210,50,40);
      roll.setFont(font);
      roll.setForeground(Color.BLUE);
      c.add(roll);
      
      rollp=new JPanel();
      rollp.setBounds(422,245,55,2);
      rollp.setBackground(Color.CYAN);
      c.add(rollp);
      //name
      name=new JLabel("Name");
      name.setBounds(600,210,70,40);
      name.setFont(font);
      name.setForeground(Color.BLUE);
      c.add(name);
      namep=new JPanel();
      namep.setBounds(520,245,300,2);
      namep.setBackground(Color.CYAN);
      c.add(namep);
      //            table
    panel=new JPanel();
   //panel.setBackground(Color.BLUE);
   
  //fLayout =new FlowLayout(FlowLayout.CENTER, 100,0);
                        
                
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    panel.setBorder(null);
    panel.setBackground(Color.WHITE);
   scroll=new JScrollPane(panel);
    scroll.setBounds(400,250,700,450);
    scroll.setBorder(null);
    c.add(scroll);
    
    
    check=new JCheckBox[100];
    
    
    
    //          submit
     s=new ImageIcon(getClass().getResource("image/SU.png"));
        Image sub=s.getImage();
	Image su=sub.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon subm=new ImageIcon(su);
        
         submit=new JLabel(subm);
        submit.setBounds(w,10,250,50);
        submit.setCursor(cursor);
       submit.setToolTipText("SUBMIT");
        c.add(submit);

       // Biit
        biiti=new ImageIcon(getClass().getResource("image/biitl.png"));
        Image bti=biiti.getImage();
	Image bt=bti.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
        ImageIcon bimg=new ImageIcon(bt);
        
        biit=new JLabel(bimg);
        biit.setBounds(50,600,80,100);
        biit.setToolTipText("BIIT, Bogra");
        c.add(biit);
       
    

     //                                 Handling
    class Handler implements MouseListener
     {

           @Override
           public void mouseClicked(MouseEvent e) {
               
               
               if(e.getSource()==submit)
               {
               
               int c=panel.getComponentCount();
               tabl=new String[c];
               
               String t=tecd.getText();
               String s=semd.getText();
               String grps=grpd.getText();
               
               String grp="";
                    
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
                 try{
                  String sql="select* from  std where Department=? and Section=? and Semester=?";
                  
                   
                  con1 = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                   pst1 = con1.prepareStatement(sql);
                   
                   //con2=DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                  
                   
                   pst1.setString(1,t);
                   pst1.setString(2,grp);
                     pst1.setString(3,s);
                 
                 
                  
                  rs1=pst1.executeQuery();
                   int i=0;
                   
                   while(rs1.next())
                   {
                       String tb=rs1.getString(6);
                      
                       tabl[i]=tb;
                      // System.out.println(tb);
                       
                       i++;
                   }
                   pst1.close();
                   con1.close(); 
                  
               }
               catch(HeadlessException | SQLException ex)
               {
                   JOptionPane.showMessageDialog(null,"Cheeck your Server Conection");
               }
              /* if(check[0].isSelected())
               {
              System.out.println(check[0].getText());
               }*/
              
              try{
                  
                  
                  con2=DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                 // String tst=tabl[0];
                 
                 int ark=0;
                 
                 
                 //    Date
                 LocalDate date = LocalDate.now(); 
                 String dt=date.toString();
                 
                 //         Time
                 LocalDateTime now = LocalDateTime.now();  
                 DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");  
                 String tm = now.format(format);  
                 
                 
                 
                for (String tabl1 : tabl) {
                   //System.out.println("P "+tabl1);
                   
                   if(check[ark].isSelected())
                   {
                    String sql1="INSERT INTO `"+tabl1+"` (`Id`, `Date`, `Time`, `Attendance`) VALUES (NULL, ?, ?, '1');";
                  pst2 = con2.prepareStatement(sql1);
                  pst2.setString(1,dt);
                  pst2.setString(2,tm);
                  
                  int up=pst2.executeUpdate();
                   }
                   else
                   {
                     String sql1="INSERT INTO `"+tabl1+"` (`Id`, `Date`, `Time`, `Attendance`) VALUES (NULL, ?, ?, '0');";
                  pst2 = con2.prepareStatement(sql1);
                  pst2.setString(1,dt);
                  pst2.setString(2,tm);
                  
                  int up=pst2.executeUpdate();  
                   }
                   
                   ark++;
               }  
                
                pst2.close();
                con2.close();
                JOptionPane.showMessageDialog(null,"Submited");
              }
              catch(HeadlessException | SQLException ex)
               {
                   JOptionPane.showMessageDialog(null,"Cheeck your Server Conection");
               }
               }
               
               else if(e.getSource()==back)
               {
                   MakeAttendance mk= new MakeAttendance();
                   mk.setVisible(true);
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
     submit.addMouseListener(h);
     back.addMouseListener(h); 
    }
    
    /*
    public static void main(String[] args) {
        
        
        GroupAttendance g=new GroupAttendance();
        g.setVisible(true);
    }
*/
}
