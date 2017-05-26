package CarRentalApp;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class CarRentalApp extends JFrame implements ActionListener {
	//JPanel n=new JPanel();
	JPanel s=new JPanel();
	JPanel e=new JPanel();
	JPanel w=new JPanel();
	JLabel title=new JLabel("Car Rental Systems",JLabel.CENTER);
	JButton cMang=new JButton("Car Managment");
	JButton rMang=new JButton("Rent Managment");
	JButton cOMang=new JButton("Customers");
	JButton Accounting=new JButton("Accounting");
	public static void main(String[] args)
	{
		CarRentalApp cra=new CarRentalApp();
	}
	CarRentalApp()
	{
		setLayout(new FlowLayout ());
		setSize(800,600);

		setTitle("Car Rental System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//add("North",n);
		add("South",s);
		title.setFont(new Font("Moire Light",Font.BOLD,48));
		add(title);
		add(new Label("                                                                                                                                                                                                                                                                                                                                                                                                            "));
		add("West",w);
		add("East",e);

		e.setLayout(new GridLayout(1,1,100,92));
		w.setLayout(new GridLayout(1,1,100,92));
		e.add(cOMang);
		e.add(Accounting);
		w.add(cMang);
		w.add(rMang);
		cMang.setFont(new Font("Arial", Font.BOLD, 15));
		rMang.setFont(new Font("Arial", Font.BOLD, 15));
		Accounting.setFont(new Font("Arial", Font.BOLD, 15));
		cOMang.setFont(new Font("Arial", Font.BOLD, 15));
		cMang.setPreferredSize(new Dimension(180,180));
		rMang.setPreferredSize(new Dimension(180,180));
		cOMang.setPreferredSize(new Dimension(180,180));
		Accounting.setPreferredSize(new Dimension(180,180));

		cMang.addActionListener(this);
		rMang.addActionListener(this);
		Accounting.addActionListener(this);
		cOMang.addActionListener(this);

		setVisible(true);
		setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cMang)
		{
			CarMang cm=new CarMang();
			dispose();
		}
		if(e.getSource()==rMang)
		{
			RentMang rm=new RentMang();
			dispose();
		}
		if(e.getSource()==Accounting)
		{
			Accounting accounting=new Accounting();
			dispose();
		}
		if(e.getSource()==cOMang)
		{
			CustomerMang cm=new CustomerMang();
			dispose();
		}
		
		
	}

}
