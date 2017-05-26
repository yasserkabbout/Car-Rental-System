package CarRentalApp;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class AddToRentMang extends JFrame implements ActionListener {
	int i=0;
	RentMang rm=new RentMang();
	JLabel title=new JLabel("Add New Rent",JLabel.CENTER);
	JLabel id=new JLabel("      ID *:       ");
	JLabel carId=new JLabel("Car ID *:       ");
	JLabel customerName=new JLabel("Customer *: ");
	JLabel nOfDays=new JLabel("# of days*: ");
	JLabel pcost=new JLabel("Down Payment*: ");
	JComboBox cid=new JComboBox ();
	JComboBox cCName=new JComboBox ();
	JTextField tday=new JTextField(20);
	JTextField tid=new JTextField(20);
	JTextField tcost=new JTextField(20);
 	JPanel l=new JPanel();
 	JPanel r=new JPanel();
 	JPanel n=new JPanel();
 	JPanel s=new JPanel();
 	JButton submit=new JButton("Add New");
 	JButton cancel=new JButton("CLOSE");
 	DB d=new DB();
 	AddToRentMang(){
	     setLayout(new BorderLayout ());
	 		setSize(450,350);
	 		setTitle("Add New Car");
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		setLocationRelativeTo(null);
	 		
	 		//HAPPY TO DID IT !11:16..23.12.2015
	 		//FETCHIN THE DATA FROM MYSQL TO COMBOBOX 
			d.select("carIDcombo");
		    cCName.setModel(new DefaultComboBoxModel(d.carIds.toArray()));
			d.select("customerName");
		  cid.setModel(new DefaultComboBoxModel(d.cnames.toArray()));
	 		add("North",n);
	 		n.add(title);
	 		title.setFont(new Font("Moire Light",Font.BOLD,48));
	 		add("West",l);
	 		add("East",r);
	        l.setPreferredSize(new Dimension(100,280));
	        l.add(id);
	 		l.add(carId);	
	 		l.add(new Label(" "));
	 		l.add(customerName);
	 		l.add(new Label(" "));
	 		l.add(nOfDays);
	 		l.add(new Label("  "));
	 		l.add(pcost);
	 		r.setPreferredSize(new Dimension(300,280));
	 		cid.setPreferredSize(new Dimension(225,30) );
	 		cCName.setPreferredSize(new Dimension(225,30) );
	 		r.add(tid);
	 		r.add(cCName);
	 		//r.add(new Label("                                              "));
	 		r.add(cid);
	 		r.add(tday);
	 		r.add(tcost);
	 	add("South",s);
	 	
	 		s.add(submit);
	 		s.add(cancel);
	 		
	 		submit.setPreferredSize(new Dimension(100,50));
	 		cancel.setPreferredSize(new Dimension(100,50));
	 		submit.addActionListener(this);
	 		cancel.addActionListener(this);
	 	 cid.setSelectedIndex(-1);
	 	 cCName.setSelectedIndex(-1);
	 		setVisible(true);
	 		setResizable(false);
}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit)
		{

			if(cid.getSelectedIndex()==-1||cCName.getSelectedIndex()==-1||tday.getText().equals("")||tcost.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Complete the Required Field !","No selection",JOptionPane.ERROR_MESSAGE);
			}
			if(!d.isInteger(this.tday.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please Make Sure you enter a valid number of Days","Data Type Error",JOptionPane.ERROR_MESSAGE);

			}
			if(!d.isInteger(this.tcost.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please Make Sure you enter a valid number of Down Payment","Data Type Error",JOptionPane.ERROR_MESSAGE);

			}
			else
			{
				d.setJtable(cCName.getSelectedItem().toString());
				d.select(cCName.getSelectedItem().toString());
				//double totalc=Double.parseDouble(tday.getText())*Double.parseDouble(tcost.getText());
				double totalc=Double.parseDouble(tday.getText())*Double.parseDouble(d.carCost());
				String sTotalc=String.valueOf(totalc);
		         double bTotal=totalc-Double.parseDouble(tcost.getText());
		         String sbTotal=String.valueOf(bTotal);
			     d.insert("INSERT INTO rent_mang (id,car_id,customer_name,date,paid_cost,cost,total) VALUES ('"+tid.getText()+"','"+cCName.getSelectedItem().toString()+"','"+cid.getSelectedItem().toString()+"','"+tday.getText()+"','"+tcost.getText()+"','"+sTotalc+"','"+sbTotal+"')");   
					i++;
					JOptionPane.showMessageDialog(null, ""+i+"Record has been added succssfully!"," added succssfully",JOptionPane.INFORMATION_MESSAGE);
					}
			

			cid.setSelectedIndex(-1);;
			cCName.setSelectedIndex(-1);
			tday.setText("");
			tcost.setText("");
			tid.setText("");
			
			
	}

		if(e.getSource()==cancel)
		{
			RentMang rm=new RentMang();
            dispose();
		}

}
}