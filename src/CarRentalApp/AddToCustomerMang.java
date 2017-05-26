package CarRentalApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddToCustomerMang extends JFrame implements ActionListener {
	int i=0;
	CustomerMang cm=new CustomerMang();
	JLabel title=new JLabel("New Customer",JLabel.CENTER);
	JLabel id=new JLabel("Customer ID *:       ");
	JLabel customerName=new JLabel("Full Name *: ");
	JLabel customerPhone=new JLabel("Phone *: ");
	JLabel customerAddress=new JLabel("Address *: ");
	JLabel comment=new JLabel("Add comment : ");
	JTextField tid=new JTextField(20);
	JTextField tname=new JTextField(20);
	JTextField tphone=new JTextField(20);
	JTextField taddress=new JTextField(20);
	JTextField tcomment=new JTextField(20);
 	JPanel l=new JPanel();
 	JPanel r=new JPanel();
 	JPanel n=new JPanel();
 	JPanel s=new JPanel();
 	JButton submit=new JButton("Add New");
 	JButton clear=new JButton("Clear");
 	JButton cancel=new JButton("CLOSE");
 	DB d=new DB();
              AddToCustomerMang(){
	       setLayout(new BorderLayout ());
	 		setSize(450,350);
	 		setTitle("Add New Customer");
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		setLocationRelativeTo(null);

	 		add("North",n);
	 		n.add(title);
	 		title.setFont(new Font("Moire Light",Font.BOLD,48));
	 		add("West",l);
	 		add("East",r);
	        l.setPreferredSize(new Dimension(100,280));
	 		l.add(id);	
	 		l.add(customerName);
	 		l.add(new Label(" "));
	 		l.add(customerPhone);
	 		l.add(new Label("  "));
	 		l.add(customerAddress);
	 		l.add(comment);
	 		r.setPreferredSize(new Dimension(300,280));
	 		r.add(tid);
	 		r.add(tname);
	 		r.add(tphone);
	 		r.add(taddress);
	 		r.add(tcomment);
	 	add("South",s);
	 	
	 		s.add(submit);
	 		s.add(clear);
	 		s.add(cancel);
	 		
	 		submit.setPreferredSize(new Dimension(100,50));
	 		cancel.setPreferredSize(new Dimension(100,50));
	 		clear.setPreferredSize(new Dimension(100,50));
	 		submit.addActionListener(this);
	 		cancel.addActionListener(this);
	 		clear.addActionListener(this);
	 	
	 		setVisible(true);
	 		setResizable(false);
}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit)
		{
		
			if(tid.getText().equals("")||tname.getText().equals("")||tphone.getText().equals("")||taddress.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Complete the Required Field !","No selection",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			     d.insert("INSERT INTO customer_mang (id,customer_name,customer_phone,customer_address,comment ) VALUES ('"+tid.getText()+"','"+tname.getText()+"','"+tphone.getText()+"','"+taddress.getText()+"','"+tcomment.getText()+"')");   
					i++;
					JOptionPane.showMessageDialog(null, ""+i+" Customer has been added !","Customer added succssfully",JOptionPane.INFORMATION_MESSAGE);
					}
			

			tid.setText("");
			tname.setText("");
			tphone.setText("");
			taddress.setText("");
			tcomment.setText("");
			
	}
		if(e.getSource()==clear)
		{
			tid.setText("");
			tname.setText("");
			tphone.setText("");
			taddress.setText("");
			tcomment.setText("");
		}
		if(e.getSource()==cancel)
		{
			CustomerMang cm=new CustomerMang();
            dispose();
		}

}
}