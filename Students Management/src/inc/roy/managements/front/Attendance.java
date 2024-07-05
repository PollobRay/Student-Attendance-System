package inc.roy.managements.front;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Attendance extends JFrame
{

    JLabel name;
    JLabel named;
    protected JLabel tec,tecd, group,groupd,roll,rolld,sem,semd,par,pard,back,save,biit;
    private Container c;
    private Font font;
    private Cursor cursor;
    private ImageIcon b,icon,savei,biiti;
     String []columns={"Date","Attendance"};
    String []rows=new String[2];
     JTable table;
     DefaultTableModel model;
     JScrollPane scroll;
     public Connection con = null,con1,con2;
    public  PreparedStatement pst = null,pst1,pst2;
    public  ResultSet rs = null,rs1,rs2;
    
   public Attendance()
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
        // this.setResizable(false);
       // for set screen full
        Toolkit kb=Toolkit.getDefaultToolkit();
        
        int x,y,w;
        x=(int)kb.getScreenSize().getWidth();
        y=(int)kb.getScreenSize().getHeight();
       // this.setSize(x, y);
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
        
        //              save as
         savei=new ImageIcon(getClass().getResource("image/SAVE.png"));
        Image sav=savei.getImage();
	Image sv=sav.getScaledInstance(250, 50, Image.SCALE_SMOOTH);
        ImageIcon sa=new ImageIcon(sv);
        
         save=new JLabel(sa);
        save.setBounds(w,10,250,50);
        save.setCursor(cursor);
       save.setToolTipText("SAVE AS PDF");
        c.add(save);
        
        
        name=new JLabel("Name                  :");
        name.setBounds(500, 50, 200, 50);
        name.setFont(font);
        name.setForeground(Color.BLUE);
        c.add(name);
        
        named=new JLabel();
        named.setBounds(700, 50, 250, 50);
        named.setFont(font);
        c.add(named);
        
        //  roll
        roll=new JLabel("Roll                     :");
        roll.setBounds(500, 80, 200, 50);
         roll.setFont(font);
         roll.setForeground(Color.BLUE);
        c.add( roll);
        
         rolld=new JLabel();
         rolld.setBounds(700, 80, 50, 50);
         rolld.setFont(font);
        c.add( rolld);
        
        
        
        
        //          technology
        tec=new JLabel("Technology         :");
        tec.setBounds(500, 115, 200, 50);
        tec.setFont(font);
        tec.setForeground(Color.BLUE);
        c.add(tec);
        
        tecd=new JLabel();
        tecd.setBounds(700, 115, 250, 50);
        tecd.setFont(font);
        c.add(tecd);
        //      semester
        sem=new JLabel("Semester             :");
        sem.setBounds(500, 150, 200, 50);
        sem.setFont(font);
        sem.setForeground(Color.BLUE);
        c.add(sem);
        
        semd=new JLabel();
        semd.setBounds(700, 150, 50, 50);
        semd.setFont(font);
        c.add(semd);
        
        //      parsetance
        par=new JLabel("Total Attendance :");
        par.setBounds(500, 190, 200, 50);
        par.setFont(font);
        par.setForeground(Color.BLUE);
        c.add(par);
        
        pard=new JLabel();
        pard.setBounds(700, 190, 200, 50);
        pard.setFont(font);
        c.add(pard);
        
        
        //          group
                groupd=new JLabel();
                groupd.setBounds(1200, 100, 100, 50);
                groupd.setVisible(false);
                c.add(groupd);

         // Biit
        biiti=new ImageIcon(getClass().getResource("image/biitl.png"));
        Image bti=biiti.getImage();
	Image bt=bti.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
        ImageIcon bimg=new ImageIcon(bt);
        
        biit=new JLabel(bimg);
        biit.setBounds(10,600,80,100);
        biit.setToolTipText("BIIT, Bogra");
        c.add(biit);
        
        //      Table
        
        table=new JTable();
    model=new DefaultTableModel();
    model.setColumnIdentifiers(columns);
    
   
   // table.setFont(font);
    table.setAlignmentX(TOP_ALIGNMENT);
    table.setModel(model);
    
    table.setFont(font);
    table.setSelectionBackground(Color.GREEN);
    
    table.setBackground(Color.WHITE);
    table.setRowHeight(30);
    
    scroll=new JScrollPane(table);
    scroll.setBounds(100,250,1150,400);
    c.add(scroll);
       
    class Handler implements MouseListener
    {
      
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==back)
                {
                SearchStudent s=new SearchStudent();
                s.setVisible(true);
                
                dispose();
                }
                else if(e.getSource()==save)
                {
                    String actPath="";
                   JFileChooser c = new JFileChooser();
                    // Demonstrate "Save" dialog:
                    int rVal = c.showSaveDialog(Attendance.this);
                     if (rVal == JFileChooser.APPROVE_OPTION) {
                     String file=c.getSelectedFile().getName();
                    String dir=c.getCurrentDirectory().toString();
                    
                    actPath=dir+"\\"+file+".pdf";
                    // System.out.println(actPath);
                        }
                 if (rVal == JFileChooser.CANCEL_OPTION) {}
        
                 
        float left = 30;
        float right = 30;
        float top = 40;
        float bottom =40;
        try{
        Document document = new Document(PageSize.A4, left, right, top, bottom);
        PdfWriter.getInstance(document, new FileOutputStream(actPath));
        document.open();
        
        //     set  path image
         String cwd = System. getProperty("user.dir");
        //System. out. println("Current working directory : " + cwd);
        String p=cwd+"\\lib\\biit.jpg";
        // C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Students Management\\src\\inc\\roy\\managements\\front\\image\\biit.jpg"
        
        //   img
        com.itextpdf.text.Image img=com.itextpdf.text.Image.getInstance(p);
        img.setAlignment(com.itextpdf.text.Image.ALIGN_LEFT);
        //img.setAbsolutePosition(40f, 10f);
        img.setAbsolutePosition(50, 755);
        img.scalePercent(8, 8);
        document.add(img);
        //
        
        document.addCreator("Roy.Inc");
        document.addAuthor("Pollob Roy"); 
        document.addTitle("Report");
        document.addSubject("Student Report");
        
        document.setMargins(left, right, top, bottom);
        
        //pr  
       document.add(new Paragraph("                                                                                                                                                                                                                                                                                                                             Pollob.C.Roy  ",FontFactory.getFont(FontFactory.TIMES_BOLD,6,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
        document.add(new Paragraph("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            7th-CmT-B(46) ",FontFactory.getFont(FontFactory.TIMES_BOLD,3,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
       // end
        
       // document.add(new Paragraph("   pollob ",FontFactory.getFont(FontFactory.TIMES_BOLD),BaseColor.RED));
       
       document.add(new Paragraph("                                                  Student Report",FontFactory.getFont(FontFactory.TIMES_BOLD,18,com.itextpdf.text.Font.BOLD,BaseColor.RED)));
       document.add(new Paragraph("-----------------------------------------------------------------------------------------",FontFactory.getFont(FontFactory.TIMES_BOLD,18,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
       
       document.add(new Paragraph("                                             "));
       document.add(new Paragraph("                                                   Name                  : "+" "+named.getText()));
       document.add(new Paragraph("                                                   Roll                     : "+" "+rolld.getText()));
       document.add(new Paragraph("                                                   Technology         : "+" "+tecd.getText()));
       document.add(new Paragraph("                                                   Semester            : "+" "+semd.getText()));
       document.add(new Paragraph("                                                   Group                 : "+" "+groupd.getText()));
       document.add(new Paragraph("                                                   Total Attendance: "+" "+pard.getText()));
       document.add(new Paragraph("                                             "));
       document.add(new Paragraph("                                             "));
       
       
       //           table
       int rows = table.getRowCount();
       
       
       PdfPTable tb=new PdfPTable(2);// 2 is column
        //set table title
        PdfPCell cell=new PdfPCell(new Paragraph("Report"));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.CYAN);
        tb.addCell(cell);
        
         PdfPCell date=new PdfPCell(new Paragraph("Date"));
        date.setHorizontalAlignment(Element.ALIGN_CENTER);
        date.setBackgroundColor(BaseColor.LIGHT_GRAY);
        
        PdfPCell att=new PdfPCell(new Paragraph("Attendance"));
        att.setHorizontalAlignment(Element.ALIGN_CENTER);
        att.setBackgroundColor(BaseColor.LIGHT_GRAY);
      
       tb.addCell(date);
       tb.addCell(att);
      
       //tb.addCell("Date");
       //tb.addCell("Attendance");
       
        int r=0;
        while(rows>0)
        {
            String d=table.getModel().getValueAt(r, 0).toString();
            String a=table.getModel().getValueAt(r, 1).toString();
            tb.addCell(d);
            tb.addCell(a);
            r++;
            rows--;
        }
       
       document.add(tb);
       
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       
       document.add(new Paragraph("             BIIT, Bogra ",FontFactory.getFont(FontFactory.TIMES_BOLD,15,com.itextpdf.text.Font.BOLD,BaseColor.RED)));
       
      // document.add(new Paragraph("                                         "));
       //document.add(new Paragraph("                                         "));
       //document.add(new Paragraph("                                                                                                                                                                               Pollob.C.Roy  ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
       //document.add(new Paragraph("                                                                                                                                                                                                                                                                                                 7th-CmT-B(46) ",FontFactory.getFont(FontFactory.TIMES_BOLD,5,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
    
      // debashish barman
       document.add(new Paragraph("                                                                                                                                                                               Abu Bashar Sardar   ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
       document.add(new Paragraph("                                                                                                                                                                                                                                                                                                 Instructor ",FontFactory.getFont(FontFactory.TIMES_BOLD,5,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
       document.add(new Paragraph("                                                                                                                                                                                                                                                                                                 BIIT, Bogra ",FontFactory.getFont(FontFactory.TIMES_BOLD,5,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
       // end
    
        document.close();
        }
        catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Faild to save file");
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
    
    Handler h=new Handler();
    back.addMouseListener(h);
    save.addMouseListener(h);
            
        
    }
    
    
    /**
    public static void main(String[] args) {
        
        
        Attendance a=new Attendance();
        a.setVisible(true);
    } */
}
