package inc.roy.managements.front;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Interface extends JFrame
{
    private Container c;
    private Font font,font1,font2;
    private Cursor cursor;
    private JLabel adds,attendance,sreport,greport,dreport,sas,day,biit,ctor,pr,cmt;
    private ImageIcon a,att,sr,gr,dr,sa,icon,dayi,biiti;
    
    
    public Interface()
    {
        initp();
    }
    
    public void initp()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        c.setBackground(Color.WHITE);
        
        cursor =new Cursor(Cursor.HAND_CURSOR);
        
                
        
        font=new Font("Bahnschrift SemiLight",Font.BOLD,25);
        font1=new Font("Arial",Font.PLAIN,18);
        font2=new Font("Arial",Font.PLAIN,12);
       
              // change icon
        icon=new ImageIcon(getClass().getResource("image/icon.png"));
	this.setIconImage(icon.getImage());
        this.setTitle("STUDENT ATTENDANCE SYSTEM");
        //make full screen
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(screenSize);
      
        // for set screen full
        Toolkit kb=Toolkit.getDefaultToolkit();
        
        int x,y,w,pad;
        x=(int)kb.getScreenSize().getWidth();
        y=(int)kb.getScreenSize().getHeight();
        //this.setSize(x, y);
        if(x>=1366)
       {
          w=300; 
          pad=0;
       }
       else
       {
          w=250; 
          pad=200;
       }
        
        
        //          components
        
        //       student attendance system
       sa=new ImageIcon(getClass().getResource("image/SMS.png"));
        Image sms=sa.getImage();
	Image sm=sms.getScaledInstance(800, 80, Image.SCALE_SMOOTH);
        ImageIcon isa=new ImageIcon(sm);
        
        sas=new JLabel(isa);
        sas.setBounds(w, 70, 800, 80);
        c.add(sas);
        
        
        //          add student
        a=new ImageIcon(getClass().getResource("image/AS.png"));
        Image add=a.getImage();
	Image as=add.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon astd=new ImageIcon(as);
        
        adds=new JLabel(astd);
        adds.setBounds(400,200,250,50);
        adds.setCursor(cursor);
        adds.setToolTipText("ADD STUDENT");
        c.add(adds);
        
        //      attendance
         att=new ImageIcon(getClass().getResource("image/A.png"));
        Image at=att.getImage();
	Image atten=at.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon atn=new ImageIcon(atten);
        
        attendance=new JLabel(atn);
        attendance.setBounds(750,200,250,50);
        attendance.setCursor(cursor);
        attendance.setToolTipText("ATTENDANCE");
        c.add(attendance);
        
        //      student report
         sr=new ImageIcon(getClass().getResource("image/S.png"));
        Image sre=sr.getImage();
	Image srpt=sre.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon srp=new ImageIcon(srpt);
        
        sreport=new JLabel(srp);
        sreport.setBounds(400,300,250,50);
        sreport.setCursor(cursor);
        sreport.setToolTipText("STUDENT REPORT");
        c.add(sreport);
        
        //      group report
         gr=new ImageIcon(getClass().getResource("image/G.png"));
        Image grpt=gr.getImage();
	Image grp=grpt.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon grprt=new ImageIcon(grp);
        
         greport=new JLabel(grprt);
        greport.setBounds(750,300,250,50);
        greport.setCursor(cursor);
        greport.setToolTipText("GROUP REPORT");
        c.add(greport);
        
        //      department report
        dr=new ImageIcon(getClass().getResource("image/D.png"));
        Image drpt=dr.getImage();
	Image drp=drpt.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon drprt=new ImageIcon(drp);
        
         dreport=new JLabel(drprt);
        dreport.setBounds(400,400,250,50);
        dreport.setCursor(cursor);
        dreport.setToolTipText("DEPARTMENT REPORT");
        c.add(dreport);
        
        
        //      day report
         dayi=new ImageIcon(getClass().getResource("image/drp.png"));
        Image dyi=dayi.getImage();
	Image dy=dyi.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon dimg=new ImageIcon(dy);
        
        day=new JLabel(dimg);
        day.setBounds(750,400,250,50);
        day.setCursor(cursor);
        day.setToolTipText("GROUP REPORT");
        c.add(day);
        
        // Biit
        biiti=new ImageIcon(getClass().getResource("image/biit.jpg"));
        Image bti=biiti.getImage();
	Image bt=bti.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon bimg=new ImageIcon(bt);
        
        biit=new JLabel(bimg);
        biit.setBounds(50,600,100,100);
        biit.setToolTipText("BIIT, Bogra");
        c.add(biit);
        
       // creator
        ctor=new JLabel("Creator....");
        ctor.setBounds((1150-pad),635,100,20);
        ctor.setFont(font2);
        c.add(ctor);
       
        pr=new JLabel("Pollob C Roy");
        pr.setBounds((1200-pad),610,200,100);
        pr.setFont(font1);
        pr.setForeground(Color.BLUE);
        c.add(pr);
        
        cmt=new JLabel("7th-CmT-B (46)");
        cmt.setBounds((1210-pad), 670, 100,20);
        cmt.setFont(font2);
        c.add(cmt);
        
        class Handler implements MouseListener
        {

            @Override
            public void mouseClicked(MouseEvent e) {
            
                if(e.getSource()==adds)
                {
                    AddStudent a=new AddStudent();
                    a.setVisible(true);
                    dispose();
                }
                else  if(e.getSource()==attendance)
                {
                    MakeAttendance m=new MakeAttendance();
                    m.setVisible(true);
                    dispose();
                }
                else  if(e.getSource()==sreport)
                {
                    SearchStudent s=new SearchStudent();
                    s.setVisible(true);
                    dispose();
                }
                 else  if(e.getSource()==greport)
                {
                    GroupStudentSearch ss=new GroupStudentSearch();
                    ss.setVisible(true);
                    dispose();
                }
                else  if(e.getSource()==dreport)
                {
                    DepartmentStrudentSearch sp=new DepartmentStrudentSearch();
                    sp.setVisible(true);
                    dispose();
                }
                else if(e.getSource()==day)
                {
                    DayAttendance dt=new DayAttendance();
                    dt.setVisible(true);
                    dispose();
                }
            }
             
            @Override
            public void mousePressed(MouseEvent e) {}
             
            @Override
            public void mouseReleased(MouseEvent e){}
               

            @Override
            public void mouseEntered(MouseEvent e) {}
                

            @Override
            public void mouseExited(MouseEvent e) {}
               
        }
        
        Handler h=new Handler();
        adds.addMouseListener(h);
        attendance.addMouseListener(h);
        sreport.addMouseListener(h);
        greport.addMouseListener(h);
        dreport.addMouseListener(h);
        day.addMouseListener(h);
    }
    
    
    
   /** 
    public static void main(String[] args) {
        
        Interface i=new Interface();
        i.setVisible(true);
    } */
}
