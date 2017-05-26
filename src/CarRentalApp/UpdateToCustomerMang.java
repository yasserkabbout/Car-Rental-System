package CarRentalApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class UpdateToCustomerMang  extends JFrame implements ActionListener {
	int i=0;
	CustomerMang cm=new CustomerMang();
	JLabel title=new JLabel("Update Customer",JLabel.CENTER);
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
 	JButton submit=new JButton("UPDATE");
 	JButton cancel=new JButton("CLOSE");
 	DB d=new DB();
 	UpdateToCustomerMang(){
	       setLayout(new BorderLayout ());
	 		setSize(450,350);
	 		setTitle("Update Customer Info");
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
	 		s.add(cancel);
	 		
	 		submit.setPreferredSize(new Dimension(100,50));
	 		cancel.setPreferredSize(new Dimension(100,50));
	 	    tid.setEditable(false);
	 		submit.addActionListener(this);
	 	cancel.addActionListener(this);
	 		setVisible(true);
	 		setResizable(false);
}

	
	
	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel)
        {
      	  CustomerMang cm=new CustomerMang();
      	  dispose();
        }
        if(e.getSource()==submit)
        {
      	  //update query 
d.update(" UPDATE `customer_mang` SET `id`="+tid.getText()+","+"`customer_name`='"+tname.getText()+"',"+"`customer_phone`='"+tphone.getText()+"',"+"`customer_address`='"+taddress.getText()+"',"+"`comment`='"+tcomment.getText()+"' where id="+tid.getText());
JOptionPane.showMessageDialog(null, "updated successfully");
        }
		
	}
	 public void setId(Object a )
	 {
		 tid.setText(a.toString());
	 }
	 public void setName(Object b)
	 {
		 tname.setText(b.toString());
	 }
	 public void setPhone(Object c)
	 {
		 tphone.setText(c.toString());
	 }
	 public void setAddress(Object d)
	 {
          taddress.setText(d.toString());
	 }
	 public void setComment(Object e)
	 {
		 tcomment.setText(e.toString());
	 }
}
