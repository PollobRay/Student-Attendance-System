package inc.roy.managements.front;


import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class Front extends JFrame
{
 private JLabel backLabel,user,pass,iuser,ipass,login,noact,signup,sas;
 private ImageIcon backimg,bimg,userimg,passimg,uimg,pimg,log,sa,icon;
 private Container c;
 private JTextField username;
 private JPasswordField password;
 private JPanel upanel, ppanel;
 private Font font,font1,font2;
 private Cursor cursor;
  Connection con=null;
   PreparedStatement pst=null;
   ResultSet rs=null;
   
   public Front()
    {
       
            initp();
    }
    
    
    public void initp()
    {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
        cursor =new Cursor(Cursor.HAND_CURSOR);
           // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());
        // Make full size
        
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(screenSize);
        
        font=new Font("Bahnschrift SemiLight",Font.BOLD,25);
        font1=new Font("Arial",Font.PLAIN,18);
        font2=new Font("Arial",Font.BOLD,18);
        
      /*  this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent evt) {
              setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
            }
        });*/
      
       /**
        // for set screen full
        Toolkit kb=Toolkit.getDefaultToolkit();
        
        int x,y;
        x=(int)kb.getScreenSize().getWidth();
        y=(int)kb.getScreenSize().getHeight();
        //this.setSize(x, y);
       
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
       // this.setUndecorated(true);
       // this.setResizable(false);
        */
        
        // set background image
       /* bimg=new ImageIcon(getClass().getResource("img1.png"));
        Image img=bimg.getImage();
	Image newImage=img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
	backimg=new ImageIcon(newImage);
	backLabel=new JLabel(backimg);
        backLabel.setBounds(0, 0, x, y);
         c.add(backLabel);
        */ 
        
       //  title
       this.setTitle("STUDENT ATTENDANCE SYSTEM");
       // icon
       icon=new ImageIcon(getClass().getResource("image/u.png"));
	//this.setImageIcon(icon);
        
       
       //       student attendance system
       sa=new ImageIcon(getClass().getResource("image/SMS.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(300, 70, 800, 80);
        c.add(sas);
        
        
         
        // login
        //user name
        uimg=new ImageIcon(getClass().getResource("image/u.png"));
        Image uim=uimg.getImage();
	Image ui=uim.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        
        userimg=new ImageIcon(ui);
        iuser=new JLabel(userimg);
        iuser.setBounds(495, 275, 40, 40);
        c.add(iuser);
        
        user=new JLabel("User name");
        user.setBounds(650, 238, 300, 50);
         user.setBorder(null);
         user.setBackground(null);
         user.setFont(font1);
         user.setForeground(Color.BLUE);
        c.add(user);
        
        username=new JTextField();
        username.setBounds(550, 270, 300, 50);
         username.setBorder(null);
         username.setBackground(null);
         username.setFont(font);
        c.add(username);
        
        upanel=new JPanel();
        upanel.setBounds(550,320,300,1);
        upanel.setBackground(Color.BLUE);
        c.add(upanel);
       
        
        // password
        pimg=new ImageIcon(getClass().getResource("image/p.png"));
        Image pim=pimg.getImage();
	Image pi=pim.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        
         passimg=new ImageIcon(pi);
        ipass=new JLabel(passimg);
        ipass.setBounds(495, 380, 40, 40);
        c.add(ipass);
        
         pass=new JLabel("Password");
        pass.setBounds(650, 348, 300, 40);
         pass.setBorder(null);
         pass.setBackground(null);
         pass.setFont(font1);
         pass.setForeground(Color.BLUE);
        c.add(pass);
        
         password=new JPasswordField();
        password.setBounds(550, 375, 300, 50);
       password.setBorder(null);
         password.setBackground(null);
        password.setFont(font);
        c.add(password);
        
        ppanel=new JPanel();
        ppanel.setBounds(550,425,300,1);
        ppanel.setBackground(Color.BLUE);
        c.add(ppanel);
         
        // Login
        log=new ImageIcon(getClass().getResource("image/login2.png"));
        Image lg=log.getImage();
	Image l=lg.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon lo=new ImageIcon(l);
        
        login=new JLabel(lo);
        login.setBounds(570,450,250,50);
        login.setToolTipText("LOGIN");
	login.setCursor(cursor);
        c.add(login);
        
        // Sign up
        noact=new JLabel("NO ACCOUNT?");
        noact.setBounds(550, 600, 150, 40);
        noact.setFont(font1);
        noact.setForeground(Color.BLUE);
        c.add(noact);
        
        signup=new JLabel("SIGN UP");
        signup.setBounds(700, 600, 80, 40);
        signup.setFont(font2);
        signup.setCursor(cursor);
        signup.setForeground(Color.BLUE);
        signup.setToolTipText("SIGN UP");
        c.add(signup);
        
        
        
        
        //              Actions
        
        
        //          class 
        
        class Mouse implements MouseListener{
                                @Override
				public void mouseClicked(MouseEvent me)
				{
                                   if(me.getSource()==signup)
                                   {
                                  SignUp s=new SignUp();  
                                   s.setVisible(true) ;
                                   //s.unamet.setText(username.getText());
                                   dispose();
                                   }
                                   else if(me.getSource()==login)
                                   {
                                       //           jdbc
                                       
                                          
                                           

                                       try{
                                                                                    
                                           String sql="select* from  teacher where user_name=? and pass=?";
                                           
                                           con=DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement","root","");
                                          pst=con.prepareStatement(sql);
                                         pst.setString(1,username.getText());
                                         pst.setString(2,password.getText());
                                            rs=pst.executeQuery();
                                          if(rs.next())
                                                          {
                                          JOptionPane.showMessageDialog(null,"Welcome");
                                                        
                                                        Interface i=new Interface();
                                                       
                                                        i.setVisible(true);
                                                         dispose();
                                                         }
                                         else
                                                      {
                                                        JOptionPane.showMessageDialog(null,"User Name & Password is Incurrect");
                                                     }
                                           
                                                 }
                                       
                                       
                                       catch(HeadlessException | SQLException e)
                                          {
                                             JOptionPane.showMessageDialog(null,"Cheeck your Server Conection");
                                             }
                                   }
                                   
				}

                                @Override
				public void mousePressed(MouseEvent me)
				{
					
				}

                                @Override
				public void mouseReleased(MouseEvent me)
				{
					
				}

                                @Override
				public void mouseExited(MouseEvent me)
				{
					
				}
                                @Override
				public void mouseEntered(MouseEvent me)
				{
					
				}

           			}
        
        
        
        //      Sign up
        Mouse m=new Mouse();
       signup.addMouseListener( m);
       login.addMouseListener(m);
       
       
    }
    
    
    /*
    public static void main(String[] args) {
        Front f=new Front();
        f.setVisible(true);
    }
*/
  
}
