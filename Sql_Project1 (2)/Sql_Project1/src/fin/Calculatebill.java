package fin;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculatebill {
	JLabel lblmeternumber,heading,lblname,lbname,lbaddress1,lbladdress,lblmonth,lbconsumed;
JTextField tfconsum;
	JButton conti;
	Choice meternumber,chmonth;
void home()
{
	JFrame frame = new JFrame();
	frame.setSize(700,500);
	frame.setLayout(null);
	frame.setVisible(true);
	heading= new JLabel("Electric Bill Calculator");
    heading.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
    heading.setBounds(50,5,400,100);
    frame.add(heading);
    
	lblmeternumber = new JLabel("Meter Number:");
	lblmeternumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblmeternumber.setBounds(20,105,120,40);
	frame.add(lblmeternumber);
	
	meternumber = new Choice();
	try {
		conn c = new conn();
	 ResultSet rs = c.s.executeQuery("Select * from customer"); // fetch from the database
	 while(rs.next())
	 {
		meternumber.add( rs.getString("meterno"));
		 
	 }
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	meternumber.setBounds(170,120,175,20);
	frame.add(meternumber);
	 
	lbname = new JLabel("Name:");
	lbname.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lbname.setBounds(20,180,300,20);
	 frame.add(lbname);
	
	 lblname = new JLabel("");
	 lblname.setFont(new Font("Tahoma", Font.BOLD, 17));
	 lblname.setBounds(150,180,300,20);
	 frame.add(lblname);
	 
	 lbaddress1 = new JLabel("Address:");
	 lbaddress1.setFont(new Font("Tahoma", Font.PLAIN, 17));
	 lbaddress1.setBounds(350,170,170,40);
	frame.add(lbaddress1);
    
	lbladdress = new JLabel("");
	lbladdress.setFont(new Font("Tahoma", Font.BOLD, 17));
	lbladdress.setBounds(450,170,170,40);
	frame.add(lbladdress);
	
	lbconsumed = new JLabel("Units Consumed");
	lbconsumed.setBounds(350,230,150,70);
	lbconsumed.setFont(new Font("Tahoma", Font.PLAIN, 17));
	frame.add(lbconsumed);
	
	tfconsum = new JTextField();
	tfconsum.setBackground(Color.GRAY);
	tfconsum.setBounds(500,255,150,20);
	frame.add(tfconsum);
	

	
	try {
		conn c = new conn();
		ResultSet rs = c.s.executeQuery("Select * from customer where meterno = '"+meternumber.getSelectedItem()+"'");
		while(rs.next())
		{
			lblname.setText(rs.getString("name"));
			lbladdress.setText(rs.getString("address"));
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	meternumber.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent e) {
		try{
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("Select * from customer where meterno = '"+meternumber.getSelectedItem()+"'");
			while(rs.next())
			{
				lblname.setText(rs.getString("name"));
				lbladdress.setText(rs.getString("address"));
			}
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		}
		}
	);
	
	int totalbill =0;
	//int unitconsumed = Integer.parseInt(units);

	
	
	lblmonth = new JLabel("Month");
	lblmonth.setFont(new Font("Tahoma", Font.PLAIN, 17));
	lblmonth.setBounds(20,250,70,40);
	frame.add(lblmonth);
	
	chmonth = new Choice();
	chmonth.setBounds(120,260,170,40);
	chmonth.add("January");
	chmonth.add("Feburary");
	chmonth.add("March");
	chmonth.add("April");
	chmonth.add("May");
	chmonth.add("June");
	chmonth.add("July");
	chmonth.add("August");
	chmonth.add("September");
	chmonth.add("October");
	chmonth.add("November");
	chmonth.add("December");
	chmonth.setBackground(Color.GRAY);
	frame.add(chmonth);
	
	
	

	
	
	conti = new JButton("Calculate");
	conti.setBounds(290,350,100,50);
	conti.setBackground(Color.GRAY);
	frame.add(conti);
 
	conti.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == conti)
			{
				String meter = meternumber.getSelectedItem();
				String units = tfconsum.getText();
				String month = chmonth.getSelectedItem();
				
				int totalbill =0;
				int unitcons = Integer.parseInt(units);
				
				int state_tax= 5,center_tax=15; 
				
				totalbill = unitcons*state_tax+center_tax;
				String query4 ="insert into bills values('"+meter+"','"+month+"','"+units+"','"+totalbill+"')";
				try {
					conn c = new conn();
					c.s.executeUpdate(query4);
					
					JOptionPane.showMessageDialog(null,"bill generated successfully");
					Dashboard dashboard = new Dashboard();
					dashboard.dasg();
					frame.dispose();

				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
			});

		
	
	
	
	
}
public static void main(String [] args)
{
	Calculatebill abc = new Calculatebill();
	abc.home();
}

}