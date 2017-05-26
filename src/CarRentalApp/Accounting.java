package CarRentalApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Accounting extends JFrame implements ActionListener {
	JPanel n=new JPanel();
	JPanel s=new JPanel();
	JTable jt=new JTable();
 	ImageIcon h = new ImageIcon("lib/home-back.png"); 
 	JButton home=new JButton(h);
 	JButton update =new JButton("Add Payment");
	DB db=new DB();
	Accounting(){
    setLayout(new FlowLayout ());
		setSize(800,600);
		setTitle("Accounting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add("North",n);
		add("South",s);
		s.add(home);
		db.select("accounting");
	    jt.setModel(db.accounting);
		n.add(jt);
		jt.setSize(550,300);
		jt.setPreferredScrollableViewportSize(new Dimension(784,450));
		jt.setFillsViewportHeight(true);
		JScrollPane jsp=new JScrollPane(jt);
		n.add(jsp);
		update.setPreferredSize(new Dimension(150,50));
		home.setPreferredSize(new Dimension(150,50));
		s.add(update);
		home.addActionListener(this);
		update.addActionListener(this);

		
		setVisible(true);
		setResizable(false);
	}


	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==home)
		{
			CarRentalApp cra=new CarRentalApp();
			dispose();
		}
		if(e.getSource()==update)
		{
				
			int col = 6; // ID is the first Column
			int row = jt.getSelectedRow();
			if(row==-1)
			{
				JOptionPane.showMessageDialog(null, "Please select row to add payment it ","No selection",JOptionPane.ERROR_MESSAGE);
			}
			else{
				//UpdateToCarMang utcm=new UpdateToCarMang();
			String id=jt.getValueAt( row, 0 ).toString();
				String paid_amount=jt.getValueAt( row, 5 ).toString();
				//String required=jt.getValueAt( row, 6 ).toString();
				//String required=(Double.valueOf(threeDForm.format(jt.getValueAt( row, 6 )))).toString();
				String cost=jt.getValueAt( row, 4 ).toString();
				double dcost=Double.parseDouble(cost);
				double dpaid_amount=Double.parseDouble(paid_amount);
				double drequired=dcost-dpaid_amount;
				double tpay=Double.parseDouble(JOptionPane.showInputDialog("Please Add NEW payment"));
				String total=String.valueOf(dpaid_amount+tpay);
				String last=String.valueOf(dcost-(dpaid_amount+tpay));
 db.update(" UPDATE `rent_mang` SET `paid_cost`="+total+","+"`total`='"+last+"' where id="+id);

 db.select("accounting");
			
			}
		

			
		}
		
	}


	
		
	                                                            }


