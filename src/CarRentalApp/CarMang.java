package CarRentalApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class CarMang extends JFrame implements ActionListener{
 	JPanel l=new JPanel();
 	JPanel r=new JPanel();
 	JPanel n=new JPanel();
 	JTable jt=new JTable();
 	JButton add=new JButton("Add Car");
 	JButton update=new JButton("Update");
 	JButton delete=new JButton("Delete");
 	JButton refresh=new JButton("Refresh");
 	ImageIcon h = new ImageIcon("lib/home-back.png"); 
 	JButton home=new JButton(h);
 	JLabel title=new JLabel("Car Management",JLabel.CENTER);
 	DB db=new DB();
	CarMang(){
     setLayout(new BorderLayout ());
 		setSize(800,600);
 		setTitle("Car Management");
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		setLocationRelativeTo(null);
 		car s= new car();
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

		db.select("car_mang");
		
	    jt.setModel(db.car_mang);
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
			UpdateToCarMang utcm=new UpdateToCarMang();
			utcm.setId(jt.getValueAt( row, col ));
			col++;
			utcm.setCarModel(jt.getValueAt( row, col ));
			col++;
			utcm.setColor(jt.getValueAt( row, col ));
			col++;
			utcm.setPrice(jt.getValueAt( row, col ));
			col++;
			utcm.setComment(jt.getValueAt( row, col ));
			col=0;
			dispose();
		}
	

		
	}
	if(e.getSource()==refresh)
	{
		db.select("car_mang");

	}
	if(e.getSource()==delete)
	{

		try{

		int row = jt.getSelectedRow();

		int col = 0; // ID is the first Column
		Object id = jt.getValueAt( row, col );
		if(db.areUsuretoDelete())
		{
      db.delet(id, "car_mang");
      db.select("car_mang");
			}
		}
		catch(Exception ee){
			JOptionPane.showMessageDialog(null, "Please select row to delete it ","No selection",JOptionPane.ERROR_MESSAGE);
		                   }
		
		}
     if(e.getSource()==add)
     {
    	 try{
    	 AddToCarMang atcm=new AddToCarMang();
    	 dispose();
    	 
    	 }catch(Exception e2)
    	 {
    		 JOptionPane.showMessageDialog(null, "Error occur","No selection",JOptionPane.ERROR_MESSAGE);
    	 }

     }
		if(e.getSource()==home)
		{
			CarRentalApp cra=new CarRentalApp();
			dispose();
		}


	

	}
	
}
