package CarRentalApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.security.Principal;
public class AddToCarMang extends JFrame implements ActionListener {
	int i=0;
	CarMang cm=new CarMang();
	JLabel title=new JLabel("Add New Car",JLabel.CENTER);
	JLabel id=new JLabel("Car ID *:       ");
	JLabel carModel=new JLabel("Car Model *: ");
	JLabel color=new JLabel("Car Color *: ");
	JLabel price=new JLabel("Renting Price *: ");
	JLabel comment=new JLabel("Add comment : ");
	JTextField tid=new JTextField(20);
	JTextField tcarModel=new JTextField(20);
	JTextField tcolor=new JTextField(20);
	JTextField tprice=new JTextField(20);
	JTextField tcomment=new JTextField(20);
 	JPanel l=new JPanel();
 	JPanel r=new JPanel();
 	JPanel n=new JPanel();
 	JPanel s=new JPanel();
 	JButton submit=new JButton("Add New");
 	JButton clear=new JButton("Clear");
 	JButton cancel=new JButton("CLOSE");
 	DB d=new DB();
	AddToCarMang(){
	     setLayout(new BorderLayout ());
	 		setSize(450,350);
	 		setTitle("Add New Car");
	 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		setLocationRelativeTo(null);

	 		add("North",n);
	 		n.add(title);
	 		title.setFont(new Font("Moire Light",Font.BOLD,48));
	 		add("West",l);
	 		add("East",r);
	        l.setPreferredSize(new Dimension(100,280));
	 		l.add(id);	
	 		l.add(carModel);
	 		l.add(new Label(" "));
	 		l.add(color);
	 		l.add(new Label("  "));
	 		l.add(price);

	 		l.add(comment);
	 		r.setPreferredSize(new Dimension(300,280));
	 		r.add(tid);
	 		r.add(tcarModel);
	 		r.add(tcolor);
	 		r.add(tprice);
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
		
			if(this.tid.getText().toString().equals("")||this.tcolor.getText().toString().equals("")||this.tcarModel.getText().equals("")||this.tprice.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Complete the Required Field !","No selection",JOptionPane.ERROR_MESSAGE);
			}
			if(!d.isInteger(this.tprice.getText()))
			{
				JOptionPane.showMessageDialog(null, "Please Make Sure you enter a valid price of the car","Data Type Error",JOptionPane.ERROR_MESSAGE);

			}
			else
			{
			     d.insert("INSERT INTO car_mang (id,car_model,color,price_rent,comment ) VALUES ('"+tid.getText()+"','"+tcarModel.getText()+"','"+tcolor.getText()+"','"+tprice.getText()+"','"+tcomment.getText()+"')");   
					i++;

					JOptionPane.showMessageDialog(null, ""+i+" Car has been added !","Car added succssfully",JOptionPane.INFORMATION_MESSAGE);
			}
			

			tid.setText("");
			tcarModel.setText("");
			tcolor.setText("");
			tprice.setText("");
			tcomment.setText("");
			
	}
		if(e.getSource()==clear)
		{
			tid.setText("");
			tcarModel.setText("");
			tcolor.setText("");
			tprice.setText("");
			tcomment.setText("");
		}
		if(e.getSource()==cancel)
		{
			CarMang cm=new CarMang();
            dispose();
		}

}
}