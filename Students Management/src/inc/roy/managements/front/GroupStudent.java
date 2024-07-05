package inc.roy.managements.front;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
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


public class GroupStudent extends JFrame
{
  protected JLabel grp,grpd,tec,sem,semd,tecd,total,totald,back,save,biit;
  private Font font;
  private Container c;
   private Cursor cursor;
    private ImageIcon b,icon,savei,biiti;
     String []columns={"Roll","Name","Total Attendance"};
    String []rows=new String[3];
     JTable table;
     DefaultTableModel model;
     JScrollPane scroll;
     public Connection con = null,con1,con2;
    public  PreparedStatement pst = null,pst1,pst2;
    public  ResultSet rs = null,rs1,rs2;

    
    public GroupStudent()
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
        
        
      
      
      //        semester
      sem=new JLabel("Semester         :");
      sem.setBounds(500,90,200,50);
      sem.setFont(font);
      sem.setForeground(Color.BLUE);
      c.add(sem);
      
      semd=new JLabel();
      semd.setBounds(700,90,100,50);
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
      total.setBounds(500,160,200,50);
      total.setFont(font);
      total.setForeground(Color.BLUE);
      c.add(total);
      
      totald=new JLabel();
      totald.setBounds(700,160,100,50);
      totald.setFont(font);
      c.add(totald);
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
    table.setFont(font);
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
               
                if(e.getSource()==save)
                {
                    String actPath="";
                   JFileChooser c = new JFileChooser();
                    // Demonstrate "Save" dialog:
                    int rVal = c.showSaveDialog(GroupStudent.this);
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
       
       document.add(new Paragraph("                                                  Students Report",FontFactory.getFont(FontFactory.TIMES_BOLD,18,com.itextpdf.text.Font.BOLD,BaseColor.RED)));
       document.add(new Paragraph("-----------------------------------------------------------------------------------------",FontFactory.getFont(FontFactory.TIMES_BOLD,18,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
       
       document.add(new Paragraph("                                             "));
      
       document.add(new Paragraph("                                                   Technology         : "+" "+tecd.getText()));
       document.add(new Paragraph("                                                   Semester            : "+" "+semd.getText()));
       document.add(new Paragraph("                                                   Group                 : "+" "+grpd.getText()));
       document.add(new Paragraph("                                                   Total Student     : "+" "+totald.getText()));
       document.add(new Paragraph("                                             "));
       document.add(new Paragraph("                                             "));
       
       
       //           table
       int rows = table.getRowCount();
       
       
       PdfPTable tb=new PdfPTable(3);// 3 is column
        //set table title
        PdfPCell cell=new PdfPCell(new Paragraph("Report"));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.CYAN);
        tb.addCell(cell);
        
        PdfPCell roll=new PdfPCell(new Paragraph("Roll"));
        roll.setHorizontalAlignment(Element.ALIGN_CENTER);
        roll.setBackgroundColor(BaseColor.LIGHT_GRAY);
        
        PdfPCell name=new PdfPCell(new Paragraph("Name"));
        name.setHorizontalAlignment(Element.ALIGN_CENTER);
        name.setBackgroundColor(BaseColor.LIGHT_GRAY);
        
        PdfPCell tatt=new PdfPCell(new Paragraph("Total Attendance"));
        tatt.setHorizontalAlignment(Element.ALIGN_CENTER);
        tatt.setBackgroundColor(BaseColor.LIGHT_GRAY);
       
       tb.addCell(roll);
       tb.addCell(name);
       tb.addCell(tatt);
        //tb.addCell("Roll");
       // tb.addCell("Name");
       // tb.addCell("Total Attendance");
        
       
        int r=0;
        while(rows>0)
        {
            String rl=table.getModel().getValueAt(r, 0).toString();
            String n=table.getModel().getValueAt(r, 1).toString();
            String ta=table.getModel().getValueAt(r, 2).toString();
            tb.addCell(rl);
            tb.addCell(n);
            tb.addCell(ta);
            r++;
            rows--;
        }
       
       document.add(tb);
       
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       document.add(new Paragraph("                                         "));
       //document.add(new Paragraph("                                                                                                                                                                               Pollob.C.Roy  ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
       //document.add(new Paragraph("                                                                                                                                                                                                                                                                                                 7th-CmT-B(46) ",FontFactory.getFont(FontFactory.TIMES_BOLD,5,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
      // document.add(new Paragraph("                                                                                                                                                                               BIIT, Bogra ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
       
       document.add(new Paragraph("             BIIT, Bogra ",FontFactory.getFont(FontFactory.TIMES_BOLD,15,com.itextpdf.text.Font.BOLD,BaseColor.RED)));
       
       //document.add(new Paragraph("                                         "));
       //document.add(new Paragraph("                                         "));
       //document.add(new Paragraph("                                                                                                                                                                               Pollob.C.Roy  ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
       //document.add(new Paragraph("                                                                                                                                                                                                                                                                                                 7th-CmT-B(46) ",FontFactory.getFont(FontFactory.TIMES_BOLD,5,com.itextpdf.text.Font.BOLD,BaseColor.BLACK)));
       
        // debashish barman
       document.add(new Paragraph("                                                                                                                                                                               Abu Bashar Sardar  ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,com.itextpdf.text.Font.BOLD,BaseColor.BLUE)));
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
    save.addMouseListener(h);
        
   
    }
    
   /*
    public static void main(String[] args) {
        
        GroupStudent g=new GroupStudent();
        g.setVisible(true);
    }
*/
}
