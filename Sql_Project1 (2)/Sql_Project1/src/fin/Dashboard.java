package fin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard {
	JButton btn1;
void dasg()
{
	JFrame frame = new JFrame("Dashboard");
	JLabel naa = new JLabel("Welcome to the Home Page");
	JPanel ab = new JPanel();
	ab.setBackground(Color.BLUE);
	frame.add(ab);
	naa.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
	naa.setBounds(100,30,500,60);
	frame.add(naa);
	frame.setLayout(null);
	frame.setSize(600,600);
	frame.setVisible(true);
	JButton cre =new JButton("CREATE");
	frame.add(cre);
	cre.setBounds(80,330,150,50 );
	cre.setBackground(Color.GRAY);
	JButton cala = new JButton("CALCULATE");
	cala.setBounds(250,330,150,50);
	cala.setBackground(Color.GRAY);
	frame.add(cala);
	JButton vie = new JButton("VIEW");
	vie.setBounds(80,150,150,50);
	vie.setBackground(Color.GRAY);
	frame.add(vie);
	JButton ref = new JButton("Logout");
	ref.setBounds(250,150,150,50);
	ref.setBackground(Color.GRAY);
	frame.add(ref);
	
	cre.addActionListener(new ActionListener()
	{
public void actionPerformed(ActionEvent e)
{
	home1 abc = new home1();
	abc.home();
}
	});
	
	cala.addActionListener(new ActionListener()
	{
public void actionPerformed(ActionEvent e)
{
	Calculatebill abc = new Calculatebill();
	abc.home();
}
	});

	vie.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			viewdetails gg=new viewdetails();
			gg.details();
		}
	});

	ref.addActionListener(new ActionListener()
	{
public void actionPerformed(ActionEvent e)
{
	ogout oo = new ogout();
}
	});
	
	
 

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Dashboard dashboard = new Dashboard();
dashboard.dasg();
	}

}