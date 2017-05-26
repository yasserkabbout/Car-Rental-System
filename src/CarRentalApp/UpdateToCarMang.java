package CarRentalApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UpdateToCarMang extends JFrame implements ActionListener {
	
	JLabel title=new JLabel("Update Car",JLabel.CENTER);
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
 	JButton submit=new JButton("UPDATE");
 	JButton cancel=new JButton("CLOSE");
 	DB d=new DB();
 	
 	UpdateToCarMang(){
 		setLayout(new BorderLayout ());
 		setSize(450,350);
 		setTitle("Updating Car Informaton");
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
 		s.add(cancel);
 		tid.setEnabled(false);
 		submit.setPreferredSize(new Dimension(100,50));
 		cancel.setPreferredSize(new Dimension(100,50));
 		submit.addActionListener(this);
 		cancel.addActionListener(this);
 	
 		setVisible(true);
 		setResizable(false);
 	                 }
	
	public void actionPerformed(ActionEvent e) {
          if(e.getSource()==cancel)
          {
        	  CarMang cm=new CarMang();
        	  dispose();
          }
          if(e.getSource()==submit)
          {
        	  //after killing me ! the query is working !!! 
 d.update(" UPDATE `car_mang` SET `id`="+tid.getText()+","+"`car_model`='"+tcarModel.getText()+"',"+"`color`='"+tcolor.getText()+"',"+"`price_rent`='"+tprice.getText()+"',"+"`comment`='"+tcomment.getText()+"' where id="+tid.getText());
 JOptionPane.showMessageDialog(null, "updated successfully");
          }
	}
	 public void setId(Object a )
	 {
		 tid.setText(a.toString());
	 }
	 public void setCarModel(Object b)
	 {
		 tcarModel.setText(b.toString());
	 }
	 public void setColor(Object c)
	 {
		 tcolor.setText(c.toString());
	 }
	 public void setPrice(Object d)
	 {
           tprice.setText(d.toString());
	 }
	 public void setComment(Object e)
	 {
		 tcomment.setText(e.toString());
	 }
	
}
