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

public class viewdetails{
	JLabel heading,lblmeternumber,lblmonth,lbmonth,lblunii,lbunii,lbltotal,lbtotal,lblname;
	Choice meternumbera;
	String namee;
	public void details()
	{
		JFrame frame = new JFrame("Bill Details");
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
		
		meternumbera = new Choice();
		try
		{
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from bills");
			while(rs.next())
			{
				meternumbera.add(rs.getString("meter_number"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		meternumbera.setBounds(170,120,175,20);
		frame.add(meternumbera);  
		
		
		lblmonth = new JLabel("Month:");
		lblmonth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblmonth.setBounds(20,180,300,20);
		frame.add(lblmonth);
		
		lbmonth = new JLabel("");
		lbmonth.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbmonth.setBounds(100,180,300,20);
		 frame.add(lbmonth);
		 
		 lblunii = new JLabel("Total Units:");
		 lblunii.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 lblunii.setBounds(350,170,170,40);
			frame.add(lblunii);
		 
	     lbunii = new JLabel();
	     lbunii.setFont(new Font("Tahoma", Font.BOLD, 17));
	     lbunii.setBounds(450,170,170,40);
	     frame.add(lbunii);
	     
	     lbltotal = new JLabel("Total Bill:");
	     lbltotal.setBounds(220,230,150,70);
	     lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
	 	frame.add(lbltotal);

		lblname = new JLabel("Name :");
		lblname.setBounds(220,230,100,70);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.add(lblname);
	 	
	 	JButton click = new JButton("Go Back");
	 	click.setBounds(250, 330,100,40);
	 	click.setBackground(Color.GRAY);
	 	frame.add(click);
	 	
	 	lbtotal = new JLabel();
	 	lbtotal.setBounds(300,255,150,20);
	 	lbtotal.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.add(lbtotal);
		
		
		click.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent e)
	{
		Dashboard dashboard = new Dashboard();
		dashboard.dasg();
	}
		});
	 	
	 	
	 	meternumbera.addItemListener( new ItemListener()
	 			{
	 		public void itemStateChanged(ItemEvent e)
	 		{
			 try
			 {
				 conn c = new conn();
				 ResultSet rs = c.s.executeQuery("Select * from bills where meter_number ='"+meternumbera.getSelectedItem()+"'");
				 while(rs.next())
				 {

					 lbmonth.setText(rs.getString("month"));
					 lbunii.setText(rs.getString("units"));
					 lbtotal.setText(rs.getString("totalbill"));
				 }
	 			}catch(Exception e1)
	 		{
	 				e1.printStackTrace();
	 		}
	 		}
	 			}
	 		);
	 			
	 		
		 try
		 {
			 conn c = new conn();
			 ResultSet rs = c.s.executeQuery("Select * from bills where meter_number ='"+meternumbera.getSelectedItem()+"'");
			 while(rs.next())
			 {
				 lbmonth.setText(rs.getString("month")); 
				 lbunii.setText(rs.getString("units"));
				 lbtotal.setText(rs.getString("totalbill"));
			 }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 			
	}
	public static void main(String [] args)
	{
		viewdetails uu = new viewdetails();
	}
}

