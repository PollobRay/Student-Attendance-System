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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {

    private Container c;
    private Font font;
    private JLabel uname, pass, repass, tid, fname, lname, sign, back,sas;
    private JTextField unamet;
    private JTextField tidt, fnamet, lnamet;
    private JPasswordField passt, repasst;
    private JPanel unamep, passp, repassp, tidp, fnamep, lnamep;
    private ImageIcon su, bk,icon,sa;
    private Cursor cursor;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SignUp() {
        initp();

    }

    public void initp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        font = new Font("Bahnschrift SemiLight", Font.BOLD, 25);
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
        
        sa=new ImageIcon(getClass().getResource("image/SGU.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(w, 70, 800, 80);
        c.add(sas);
        
        //          first name
        fname = new JLabel("First Name");
        fname.setBounds(450, 250, 200, 50);
        fname.setFont(font);
        fname.setForeground(Color.BLUE);
        c.add(fname);

        fnamet = new JTextField();
        fnamet.setBounds(650, 250, 250, 40);
        fnamet.setFont(font);
        fnamet.setBorder(null);
        fnamet.setBackground(null);
        c.add(fnamet);

        fnamep = new JPanel();
        fnamep.setBounds(650, 290, 250, 1);
        fnamep.setBackground(Color.BLUE);
        c.add(fnamep);

        //          last name
        lname = new JLabel("Last Name ");
        lname.setBounds(450, 305, 200, 50);
        lname.setFont(font);
        lname.setForeground(Color.BLUE);
        c.add(lname);

        lnamet = new JTextField();
        lnamet.setBounds(650, 305, 250, 40);
        lnamet.setFont(font);
        lnamet.setBorder(null);
        lnamet.setBackground(null);
        c.add(lnamet);

        lnamep = new JPanel();
        lnamep.setBounds(650, 345, 250, 1);
        lnamep.setBackground(Color.BLUE);
        c.add(lnamep);

        //              user name
        uname = new JLabel("User Name ");
        uname.setBounds(450, 360, 200, 50);
        uname.setFont(font);
        uname.setForeground(Color.BLUE);
        c.add(uname);

        unamet = new JTextField();
        unamet.setBounds(650, 360, 250, 40);
        unamet.setFont(font);
        unamet.setBorder(null);
        unamet.setBackground(null);
        c.add(unamet);

        unamep = new JPanel();
        unamep.setBounds(650, 400, 250, 1);
        unamep.setBackground(Color.BLUE);
        c.add(unamep);

        //          password
        pass = new JLabel("Password ");
        pass.setBounds(450, 415, 200, 50);
        pass.setFont(font);
        pass.setForeground(Color.BLUE);
        c.add(pass);

        passt = new JPasswordField();
        passt.setBounds(650, 415, 250, 40);
        passt.setFont(font);
        passt.setBorder(null);
        passt.setBackground(null);
        c.add(passt);

        passp = new JPanel();
        passp.setBounds(650, 455, 250, 1);
        passp.setBackground(Color.BLUE);
        c.add(passp);

        //          repassword
        repass = new JLabel("Re-Password ");
        repass.setBounds(450, 470, 200, 50);
        repass.setFont(font);
        repass.setForeground(Color.BLUE);
        c.add(repass);

        repasst = new JPasswordField();
        repasst.setBounds(650, 470, 250, 40);
        repasst.setFont(font);
        repasst.setBorder(null);
        repasst.setBackground(null);
        c.add(repasst);

        repassp = new JPanel();
        repassp.setBounds(650, 510, 250, 1);
        repassp.setBackground(Color.BLUE);
        c.add(repassp);

        // BACK
        bk = new ImageIcon(getClass().getResource("image/B.png"));
        Image bck = bk.getImage();
        Image bak = bck.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon backc = new ImageIcon(bak);

        back = new JLabel(backc);
        back.setBounds(420, 550, 250, 50);
        back.setCursor(cursor);
        back.setToolTipText("BACK");
        c.add(back);

        //          sign up
        su = new ImageIcon(getClass().getResource("image/signup2.png"));
        Image signu = su.getImage();
        Image sup = signu.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon signup = new ImageIcon(sup);

        sign = new JLabel(signup);
        sign.setBounds(680, 550, 250, 50);
        sign.setCursor(cursor);
        sign.setToolTipText("SIGN UP");
        c.add(sign);

        sign.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String f = fnamet.getText();
                String l = lnamet.getText();
                String p = passt.getText();
                String pr = repasst.getText();
                String u = unamet.getText();
                String sql = "insert into teacher(First_name,Last_name,user_name,pass) values(?,?,?,?);";

                if ("".equals(u) || "".equals(f) || "".equals(l) || "".equals(p) || "".equals(pr)) {
                    JOptionPane.showMessageDialog(null, "Please insert all data");
                } else {
                    if (p.equals(pr)) {
                        try {

                            con = DriverManager.getConnection("jdbc:mysql://localhost/stdmanagement", "root", "");
                            pst = con.prepareStatement(sql);
                            pst.setString(1, f);
                            pst.setString(2, l);
                            pst.setString(3, u);
                            pst.setString(4, p);

                            int count = pst.executeUpdate();
                            if (count == 1) {
                                JOptionPane.showMessageDialog(null, "Success");
                                unamet.setText("");
                                fnamet.setText("");
                                lnamet.setText("");
                                passt.setText("");
                                repasst.setText("");
                            }

                        } catch (SQLException ex) {

                            JOptionPane.showMessageDialog(null, "Cheeck Server Cunnection");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password are Incurrect");
                    }

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
        );

        back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Front f = new Front();
                f.setVisible(true);
                dispose();
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
        );
    }
  /*
    public static void main(String[] args) {

        SignUp s = new SignUp();
        s.setVisible(true);
    }
*/
}
