package fin;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class home1 {
	JLabel heading,lblname,lblmeterno,lblmeter,lbladdress,lblstate,lblemail,lblphone;
	JTextField tfname,tfaddress,tfstate,tfemail,tfphone;
	JButton conti;
void home()
{
	JFrame frame = new JFrame();
	frame.setSize(700,500);
	frame.setLayout(null);
	frame.setVisible(true);
	heading= new JLabel("Electric Bill Generator");
    heading.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
    heading.setBounds(50,5,400,100);
    frame.add(heading);
    
	lblname = new JLabel("Owner Name");
	lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblname.setBounds(20,105,170,40);
	frame.add(lblname);
	
	tfname = new JTextField();
	tfname.setBackground(Color.GRAY);
	tfname.setBounds(170,120,175,20);
	frame.add(tfname);
	 
	lblmeterno = new JLabel("Unique MeterNo:");
	 lblmeterno.setFont(new Font("Tahoma", Font.PLAIN, 17));
	 lblmeterno.setBounds(405,120,300,20);
	 frame.add(lblmeterno);
	
	 lblmeter = new JLabel("");
	 lblmeter.setFont(new Font("Tahoma", Font.BOLD, 17));
	 lblmeter.setBounds(540,120,300,20);
	 frame.add(lblmeter);
	 
	Random uniq = new Random();
	long number = uniq.nextLong(100000000); //Unique Meter no
	lblmeter.setText(""+ Math.abs(number));
    
	lbladdress = new JLabel("Address");
	lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lbladdress.setBounds(20,170,170,40);
	frame.add(lbladdress);
	
	tfaddress = new JTextField();
	tfaddress.setBounds(170,180,175,20);
	tfaddress.setBackground(Color.GRAY);
	frame.add(tfaddress);
	
	lblstate = new JLabel("State");
	lblstate.setBounds(405,180,300,20);
	lblstate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	frame.add(lblstate);
	
	tfstate = new JTextField();
	tfstate.setBounds(500,180,175,20);
	tfstate.setBackground(Color.GRAY);
	frame.add(tfstate);
	
	lblemail = new JLabel("Email");
	lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblemail.setBounds(20,250,170,40);
	frame.add(lblemail);
	
	tfemail = new JTextField();
	tfemail.setBounds(170,260,175,20);
	tfemail.setBackground(Color.GRAY);
	frame.add(tfemail);
	
	lblphone = new JLabel("Phone No");
	lblphone.setBounds(405,260,300,20);
	lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
	frame.add(lblphone);
	
	tfphone = new JTextField();
	tfphone.setBounds(500,260,175,20);
	tfphone.setBackground(Color.GRAY);
	frame.add(tfphone);
	
	conti = new JButton("Continue");
	conti.setBounds(290,350,100,50);
	conti.setBackground(Color.GRAY);
	frame.add(conti);
	
	conti.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent e)
		{
		if (e.getSource() == conti)
		{
			String name = tfname.getText();
			String meter = lblmeter.getText();
			String address = tfaddress.getText();
			String state = tfstate.getText();
			String email = tfemail.getText();
			String phone = tfphone.getText();
			
			
			try
			{
				conn c = new conn();
				String query1 = "insert into customer values('"+name+"' , '"+meter+"','"+address+"','"+state+"','"+email+"','"+phone+"')";
				frame.dispose(); // Sending Data to Database
				c.s.executeUpdate(query1);
				new home2(meter);
				
			}catch( Exception e1)
			{
				e1.printStackTrace();
			}
		}
		else
		{
			frame.setVisible(false);
		}
			}});
		
	
	
	
	
}
}
