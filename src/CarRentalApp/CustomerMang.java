package CarRentalApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CustomerMang extends JFrame implements ActionListener {
 
	JPanel l=new JPanel();
 	JPanel r=new JPanel();
 	JPanel n=new JPanel();
 	JTable jt=new JTable();
 	JButton add=new JButton("Add New");
 	JButton update=new JButton("Update");
 	JButton delete=new JButton("Delete");
 	JButton refresh=new JButton("Refresh");
 	ImageIcon h = new ImageIcon("lib/home-back.png"); 
 	JButton home=new JButton(h);
 	JLabel title=new JLabel("Customer Management",JLabel.CENTER);
 	DB db=new DB();
 	CustomerMang(){
     setLayout(new BorderLayout ());
 		setSize(800,600);
 		setTitle("Customer Management");
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		setLocationRelativeTo(null);
 		add("North",n);
 		n.add(new Label("       "));
 		
 		n.add(title);
 		title.setFont(new Font("Moire Light",Font.BOLD,48));
         // Adding the Buttons 
 		add(l);
 		add(r);
 		l.setSize(150, 500);
 	//	r.setSize(600,500);
 		
 		l.add(new Label("                                                                                                       "));
 		l.add(new Label("          "));
		l.add(new Label("          "));
 		l.add(new Label("          "));
		l.add(new Label("          "));
 		l.add(new Label("          "));
 		l.add(home);
 		l.add(new Label("          "));
 		l.add(add);
 		l.add(new Label("          "));
 		l.add(update);
 		l.add(new Label("          "));
 		l.add(delete);
 		l.add(new Label("          "));
 		l.add(update);
 		l.add(new Label("          "));
 		l.add(refresh);
		add.setFont(new Font("Arial", Font.BOLD, 15));
		update.setFont(new Font("Arial", Font.BOLD, 15));
		delete.setFont(new Font("Arial", Font.BOLD, 15));
		refresh.setFont(new Font("Arial", Font.BOLD, 15));
		add.setPreferredSize(new Dimension(100,50));
		update.setPreferredSize(new Dimension(100,50));
		delete.setPreferredSize(new Dimension(100,50));
		refresh.setPreferredSize(new Dimension(100,50));
		home.setPreferredSize(new Dimension(100,50));
		r.add(new Label("          "));
		r.add(new Label("          "));
		r.add(new Label("          "));
		r.add(new Label("          "));

		db.select("customer_mang");
		
	    jt.setModel(db.customer_mang);
		r.add(jt);
		jt.setSize(550,300);
		jt.setPreferredScrollableViewportSize(new Dimension(550,450));
		jt.setFillsViewportHeight(true);
		JScrollPane jsp=new JScrollPane(jt);
		r.add(jsp);
	      
		refresh.addActionListener(this);
		delete.addActionListener(this);
		add.addActionListener(this);
		update.addActionListener(this);
		home.addActionListener(this);
 		setVisible(true);
 		setResizable(false);
     }

	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==update)
	{
			
		int col = 0; // ID is the first Column
		int row = jt.getSelectedRow();
		if(row==-1)
		{
			JOptionPane.showMessageDialog(null, "Please select row to UPDATE it ","No selection",JOptionPane.ERROR_MESSAGE);
		}
		else{
			UpdateToCustomerMang utcm=new UpdateToCustomerMang();
			utcm.setId(jt.getValueAt( row, col ));
			col++;
			utcm.setName(jt.getValueAt( row, col ));
			col++;
			utcm.setPhone(jt.getValueAt( row, col ));
			col++;
			utcm.setAddress(jt.getValueAt( row, col ));
			col++;
			utcm.setComment(jt.getValueAt( row, col ));
			col=0;
			dispose();
		}
	

		
	}
	if(e.getSource()==refresh)
	{
		db.select("customer_mang");

	}
	if(e.getSource()==delete)
	{

		try{

		int row = jt.getSelectedRow();

		int col = 0; // ID is the first Column
		Object id = jt.getValueAt( row, col );
		if(db.areUsuretoDelete())
		{
      db.delet(id, "customer_mang");
      db.select("customer_mang");
			}
		}
		catch(Exception ee){
			JOptionPane.showMessageDialog(null, "Please select row to delete it ","No selection",JOptionPane.ERROR_MESSAGE);
		                   }
		
		}
     if(e.getSource()==add)
     {
    	 try{
    		 AddToCustomerMang atcm=new AddToCustomerMang();
    	 dispose();
    	 }catch(Exception e2)
    	 {
    		 JOptionPane.showMessageDialog(null, "Error occur","No selection",JOptionPane.ERROR_MESSAGE);
    	 }
    	 db.select("customer_mang");
     }
		if(e.getSource()==home)
		{
			CarRentalApp cra=new CarRentalApp();
			dispose();
		}


	

	}
	
}
