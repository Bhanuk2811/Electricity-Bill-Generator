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

public class home2 {
	JLabel heading,lblname, lblmeternumber,lblmeterno,lblmetertype,lbldays,lblphasecode;
	Choice meterlocation, metertype, phasecode, billtype;
	JButton sub;
	String meternumber;
	home2(String meternumber)
	{
		this.meternumber = meternumber;
		JFrame frame = new JFrame();
		frame.setSize(700,500);
		frame.setLayout(null);
		frame.setVisible(true);
		heading= new JLabel("Electric Bill Generator");
	    heading.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
	    heading.setBounds(50,5,400,100);
	    frame.add(heading);
	    
	     lblmeternumber = new JLabel(meternumber);
	     lblmeternumber.setBounds(170,120,175,20);
	     frame.add(lblmeternumber);
	    
	    
		lblname = new JLabel("Meter Number");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblname.setBounds(20,105,170,40);
		frame.add(lblname);
		
		lblmeterno = new JLabel("Meter Location");
		lblmeterno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 lblmeterno.setBounds(355,120,120,20);
		 frame.add(lblmeterno);
		
		meterlocation = new Choice();
		meterlocation.add("outside");
		meterlocation.add("Inside");
		meterlocation.setBounds(500,120,160,20);
		meterlocation.setBackground(Color.GRAY);
		frame.add(meterlocation);
		
		lblmetertype = new JLabel("Bill Type");
		lblmetertype.setBounds(355,190,120,50);
		lblmetertype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.add(lblmetertype);
		
		billtype = new Choice();
		billtype.add("normal");
		billtype.add("Industrial");
		billtype.add("commercial");
		billtype.setBounds(500,205,175,20);
		billtype.setBackground(Color.GRAY);
		frame.add(billtype);
		
		lblmetertype = new JLabel("Meter Type");
		lblmetertype.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblmetertype.setBounds(20,190,110,40);
		frame.add(lblmetertype);
		
		metertype = new Choice();
		metertype.add("Electric Meter");
		metertype.add("Solar Meter");
		metertype.add("Smart Meter");
		metertype.setBounds(150,202,175,20);
		metertype.setBackground(Color.GRAY);
		frame.add(metertype);
	    
		lblphasecode = new JLabel("Phase Code");
		lblphasecode.setBounds(20,290,100,40);
		lblphasecode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.add(lblphasecode);
		
		phasecode = new Choice();
		phasecode.add("011");
		phasecode.add("022");
		phasecode.add("033");
		phasecode.add("044");
		phasecode.add("055");
		phasecode.add("066");
		phasecode.add("077");
		phasecode.setBounds(150,300,175,20);
		phasecode.setBackground(Color.GRAY);
		frame.add(phasecode);
		
		JLabel lbldisp = new JLabel("Default Calculation is 30 Days");
		lbldisp.setBounds(405,290,300,20);
		lbldisp.setForeground(Color.ORANGE);
		lbldisp.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.add(lbldisp);
		
		
		sub = new JButton("Submit");
		sub.setBounds(290,350,100,50);
		sub.setBackground(Color.GRAY);
		frame.add(sub);
		
		sub.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == sub)
				{
					String meter = meternumber;
					String location = meterlocation.getSelectedItem();
					String type = metertype.getSelectedItem();
					String code = phasecode.getSelectedItem();
					String typebill = billtype.getSelectedItem();
					String days = "30";
					
					String query = "insert into meter_inf values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
				
				try {
					conn c = new conn();
					c.s.executeUpdate(query);
				
					JOptionPane.showMessageDialog(null,"MeterInformation saved Successfully");
					frame.dispose();
					Dashboard dashboard = new Dashboard();
					dashboard.dasg();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
			}
				});
		
	}
}