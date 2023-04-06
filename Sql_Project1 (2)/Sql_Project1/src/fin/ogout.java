package fin;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ogout {

ogout()
{
	JFrame frame = new JFrame();
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setSize(900,500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Login Out");

	JLabel fk = new JLabel();
	fk.setIcon(new ImageIcon("electric.png.png"));
	fk.setBounds(30,60,900,800);
	frame.add(fk);
	JLabel nam1 =new JLabel("GROUP MEMBERS");
	nam1.setBounds(350,225,280,40);
	nam1.setFont(new Font("Tahoma", Font.BOLD, 27));
	frame.add(nam1);
	JLabel nam2 =new JLabel("DHRUV PANDEY");
	frame.add(nam2);
	nam2.setBounds(370,285,280,40);
	nam2.setFont(new Font("Tahoma", Font.PLAIN, 17));
	JLabel nam3 =new JLabel("BHANU KAUSHAL");
	frame.add(nam3);
	nam3.setBounds(370,305,280,40);
	nam3.setFont(new Font("Tahoma", Font.PLAIN, 17));

	
}

}