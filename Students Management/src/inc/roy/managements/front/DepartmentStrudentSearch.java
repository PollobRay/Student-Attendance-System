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

public class DepartmentStrudentSearch extends JFrame {

    private Container c;
    private Font font,font1;
    private JLabel stdtec, stdsem, back,ss,sas,biit;
    private JComboBox stdtecC, stdsemC;
    private final String tec[] = {"Computer", "Electronics", "Electrical", "Civil", "Automobile", "Architecture", "Mechanical", "Telecommunication", "Textile", "Garmance"};
    private final String[] sem = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
    
    private ImageIcon s,b,icon,sa,biiti;
     private Cursor cursor;
    
   public DepartmentStrudentSearch()
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
        this.setTitle("STUDENT ATTENDANCE SYSTEM");
         // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());
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
        
          //       Technology report
       sa=new ImageIcon(getClass().getResource("image/TR.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(w, 70, 800, 80);
        c.add(sas);
        // student Technology
        stdtec = new JLabel("Technology");
        stdtec.setBounds(500, 280, 150, 50);
        stdtec.setFont(font);
        stdtec.setForeground(Color.BLUE);
        c.add(stdtec);

        stdtecC = new JComboBox(tec);
        stdtecC.setBounds(650, 285, 200, 40);
        stdtecC.setFont(font1);
        stdtecC.setBackground(null);
        stdtecC.setBorder(null);
        c.add(stdtecC);

        //       student seme
        stdsem = new JLabel("Semester");
        stdsem.setBounds(550, 400, 150, 50);
        stdsem.setFont(font);
        stdsem.setForeground(Color.BLUE);
        c.add(stdsem);

        stdsemC = new JComboBox(sem);
        stdsemC.setBounds(700, 405, 100, 40);
        stdsemC.setFont(font1);
        stdsemC.setBackground(null);
        stdsemC.setBorder(null);
        c.add(stdsemC);
        
        
        
        
        
        
        
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
        
        GroupStudent gs=new GroupStudent ();
        
         class Handler implements MouseListener
        {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                
                
                if(e.getSource()==ss)
                {
                    String t=stdtecC.getSelectedItem().toString();
                    String s=stdsemC.getSelectedItem().toString();
                    String g="All";
                    
                    gs.tecd.setText(t);
                    gs.semd.setText(s);
                    gs.grpd.setText(g);
                   
                    int total=0;
                   
                    
                    String sql="select* from  std where Department=? and Semester=?";
                    //String sqp="";
                    int i=0;
                    try{
                      gs.con = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                   gs.pst = gs.con.prepareStatement(sql);
                   gs.pst.setString(1,t);
                    gs.pst.setString(2,s);
                   
                  
                  gs.rs=gs.pst.executeQuery();
                  while(gs.rs.next())
                  {
                     gs.rows[0]=gs.rs.getString(3); 
                     gs.rows[1]=gs.rs.getString(2);
                     String tb=gs.rs.getString(6);
                     
                     total++;
                     
                     int par=0;
                     String sqp="select* from `"+tb+"`;";
                     try{
                         gs.pst1 = gs.con.prepareStatement(sqp);
                        gs.rs1= gs.pst1.executeQuery();
                        
                        while(gs.rs1.next())
                        {
                            String a=gs.rs1.getString(4);
                      if("1".equals(a))
                      {
                          par++;
                      }
                      else{
                          
                      }
                      
                      
                        }
                     gs.pst1.close();
                     }
                     catch(HeadlessException | SQLException ex)
                  {
                    //JOptionPane.showMessageDialog(null,"Not Found");  
                  }
                     gs.rows[2]=""+par;
                     gs.model.addRow(gs.rows);
                  }
                  
                  
                  gs.con.close();
                  gs.pst.close();
                  
                  gs.totald.setText(""+total);
                  gs.setVisible(true);
                  dispose();
                    }
                    catch(HeadlessException | SQLException ex)
                  {
                    JOptionPane.showMessageDialog(null,"Check Your Server connection");  
                  }
                }
                
                else if(e.getSource()==back)
                {
                   Interface i=new Interface();
                   i.setVisible(true);
                   dispose();
                }
                else if(e.getSource()==gs.back)
                {
                    DepartmentStrudentSearch dss=new DepartmentStrudentSearch();
                     dss.setVisible(true);
                     gs.dispose();
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
       
       //          group student page handle
        gs.back.addMouseListener(h);
       
        
    }
    
    /*
    public static void main(String[] args) {
        
        
          DepartmentStrudentSearch s=new DepartmentStrudentSearch();
          s.setVisible(true);
    } */
    
}
