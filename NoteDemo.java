import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.io.File;
public class NoteDemo extends Frame implements ActionListener{
		
		MenuBar mbar;
		Menu file,edit,help;
		TextArea ta;
		MenuItem save,newn,exit,open;
		MenuItem cut,copy,paste;
		MenuItem about,viewhelp;
		
NoteDemo(){
	
	setSize(new Dimension(1000,1000));
	setTitle("Welcome to Notepad DEMO by M_Y");
	
	setFont(new Font ("Arial",Font.BOLD,20));
	setLayout(new BorderLayout());
	
	mbar=new MenuBar();
	setMenuBar(mbar);

	ta=new TextArea();
	ta.setBackground(Color.BLACK);
	ta.setForeground(Color.WHITE);
	//ta.setFont(new Font("Ariel", Font.BOLD, 20));
	add(ta);

	file=new Menu("File");
	mbar.add(file);

	open=new MenuItem("open");
	file.add(open);
	open.addActionListener(this);
	save=new MenuItem("save");
	file.add(save);
	save.addActionListener(this);
	newn=new MenuItem("new");
	file.add(newn);
	newn.addActionListener(this);
	file.addSeparator();
	exit=new MenuItem("exit");
	file.add(exit);
	exit.addActionListener(this);

	edit=new Menu("Edit");
	mbar.add(edit);
	cut=new MenuItem("cut");
	edit.add(cut);
	cut.addActionListener(this);
	copy=new MenuItem("copy");
	edit.add(copy);
	copy.addActionListener(this);
	paste=new MenuItem("paste");
	edit.add(paste);
	paste.addActionListener(this);

	help=new  Menu("Help");
	mbar.add(help);
	viewhelp=new MenuItem("view_help");
	viewhelp.addActionListener(this);
	about=new MenuItem("about");
	about.addActionListener(this);
	help.add(viewhelp);
	help.addSeparator();
	help.add(about);
	
	
	Myad me=new Myad();
	addWindowListener(me);	
	
}
public void actionPerformed(ActionEvent ae){
	String s=ae.getActionCommand();
	if(ae.getSource()==exit){
		System.exit(0);
	}
	if(ae.getSource()==newn){
		ta.setText(" ");
	}
	
	   if(ae.getSource()==open)
        {
            try
            {
                FileDialog fd=new FileDialog(this,"Open File",FileDialog.LOAD);
                fd.setVisible(true);
                String dir=fd.getDirectory();
                String fname=fd.getFile();
                FileInputStream fis=new FileInputStream(dir+fname);
                DataInputStream dis=new DataInputStream(fis);
                String str=" ",msg=" ";
                while((str=dis.readLine())!=null)
                {
                    msg=msg+str;
                    msg+="\n";
                }
                ta.setText(msg);
                dis.close();
            }
            catch(Exception e){}
        }

	    if(ae.getSource()==save)
        {
            try
            {
                FileDialog fdia=new FileDialog(this,"Save File",FileDialog.SAVE);
                fdia.setVisible(true);
                String txt=ta.getText();
                String dir=fdia.getDirectory();
                String fname=fdia.getFile();
                FileOutputStream fos=new FileOutputStream(dir+fname);
                DataOutputStream dos=new DataOutputStream(fos);
                dos.writeBytes(txt);
                dos.close();
            }
            catch(Exception e)
            {
            }
        }
		String m="";
		 if(ae.getSource()==cut)
        {
			
            m=ta.getSelectedText();
            ta.replaceRange("",ta.getSelectionStart(),ta.getSelectionEnd());
        }
        if(ae.getSource()==copy)
        {
			
            m=ta.getSelectedText();
        }
        else if(ae.getSource()==paste)
        {
            ta.replaceRange("",ta.getSelectionStart(),ta.getSelectionEnd());
        }

		if(ae.getSource()==about){
			 new MyDialogB().setVisible(true);     
		}
	
	
}
public void paint(Graphics g){
	
}
public static void main(String args[]){
	new NoteDemo().setVisible(true);
}
}

//Window Adapter
class Myad extends WindowAdapter{
	public void windowClosing(WindowEvent we){
		System.exit(0);
	}
}

//view>>about
class MyDialogB extends  Dialog implements  ActionListener
{
    private Label lbl;
    private Button btn;
    private Panel north_panel,south_panel;
    public MyDialogB()
    {
		
        super(new NoteDemo(),"Dialog Demo",true);
        north_panel=new Panel();
        south_panel=new Panel();
        
        setTitle("Notepad Information");
        setSize(400,200);
        setLocation(50,80);
        lbl=new Label("welcome to Notepad ... :) !");
        btn=new Button("OK! Got It");
        
        north_panel.add(lbl);
        south_panel.add(btn);
        add(south_panel,"South");
        add(north_panel,"North");
        btn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn)
            dispose();
    }
}