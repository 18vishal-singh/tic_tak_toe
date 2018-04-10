import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
@author:Vishal Singh
*/
class TicTac implements ActionListener
{
	int flag=0;
	JPanel jp;
	JFrame f;
	JButton b[];
	String p1="";
	String p2="";
	TicTac(String s)
	{
		jp=new JPanel();
		f=new JFrame(s);
		b=new JButton[9];
		for(int i=0;i<b.length;i++)
		{
			b[i]=new JButton(".");
			b[i].addActionListener(this);
			jp.add(b[i]);
		}
		f.add(jp);
		jp.setLayout(new GridLayout(3,3,2,2));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(350,350);
		f.setLocationRelativeTo(null);
	//	f.setLocation(300,300);
		f.setResizable(false);
		f.setVisible(true);
	}
	public static void main(String s[])
	{
		new TicTac("Tic - Tac - Toe");
	}
	public void actionPerformed(ActionEvent e)
	{ 
		if(flag%2==0)
		{
			ImageIcon start=new ImageIcon("cross.jpg");
			for(int i=0;i<9;i++)
			{
				if(e.getSource()==b[i])
				{	b[i].setIcon(start);
					b[i].setEnabled(false);
					b[i].setDisabledIcon(start);	
					p1=p1+i;
	//				System.out.println(p1);
				}
			}
			flag++;
		}
		else
		{
			ImageIcon start=new ImageIcon("circle.jpg");
			for(int i=0;i<9;i++)
			{
				if(e.getSource()==b[i])
				{	b[i].setIcon(start);
					b[i].setEnabled(false);
					b[i].setDisabledIcon(start);
					p2=p2+i;
	//				System.out.println(p2);
				}
			}
			flag++;
		}
		checkWin();
		
	}
	void checkWin()
	{

		if(p1.contains("0")&&p1.contains("1")&&p1.contains("2")||
			p1.contains("3")&&p1.contains("4")&&p1.contains("5")||
			p1.contains("6")&&p1.contains("7")&&p1.contains("8")||
			p1.contains("0")&&p1.contains("3")&&p1.contains("6")||
			p1.contains("4")&&p1.contains("1")&&p1.contains("7")||
			p1.contains("5")&&p1.contains("8")&&p1.contains("2")||
			p1.contains("0")&&p1.contains("4")&&p1.contains("8")||
			p1.contains("4")&&p1.contains("6")&&p1.contains("2"))
			{	
				JOptionPane.showMessageDialog(null,"Payer 1 wins");
				//System.out.println("player 1 wins");
				for(int i=0;i<9;i++)
					b[i].setEnabled(false);
			}
					
		else
		if(p2.contains("0")&&p2.contains("1")&&p2.contains("2")||
			p2.contains("3")&&p2.contains("4")&&p2.contains("5")||
			p2.contains("6")&&p2.contains("7")&&p2.contains("8")||
			p2.contains("0")&&p2.contains("3")&&p2.contains("6")||
			p2.contains("4")&&p2.contains("1")&&p2.contains("7")||
			p2.contains("5")&&p2.contains("8")&&p2.contains("2")||
			p2.contains("0")&&p2.contains("4")&&p2.contains("8")||
			p2.contains("4")&&p2.contains("6")&&p2.contains("2"))
			{	
				JOptionPane.showMessageDialog(null,"Payer 2 wins");
				//System.out.println("player 2 wins");
				for(int i=0;i<9;i++)
					b[i].setEnabled(false);
			}
		
	}


}
