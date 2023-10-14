package MHB.Banking.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

public class FastCash extends JFrame implements ActionListener {

	JButton deposite, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit;
	String pinnumber;

	public FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(0, 0, 900, 900);
		add(Image);

		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(215, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		Image.add(text);

		deposite = new JButton("Rs 100");
		deposite.setBounds(170, 415, 150, 30);
		deposite.addActionListener(this);
		Image.add(deposite);

		withdrawl = new JButton("Rs 500");
		withdrawl.setBounds(355, 415, 150, 30);
		withdrawl.addActionListener(this);
		Image.add(withdrawl);

		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		Image.add(fastcash);

		ministatement = new JButton("Rs 2000");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		Image.add(ministatement);

		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		Image.add(pinchange);

		balanceenquiry = new JButton("Rs 10,000");
		balanceenquiry.setBounds(355, 485, 150, 30);
		balanceenquiry.addActionListener(this);
		Image.add(balanceenquiry);

		exit = new JButton("BACK");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		Image.add(exit);

		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		} else {
			String amount = ((JButton) ae.getSource()).getText().substring(3);
			Connect c = new Connect();

			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
				int balance = 0;
				while (rs.next()) {
					if (rs.getString("type").equals("Deposite")) {

						balance += Integer.parseInt(rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}

				Date date = new Date();
				String query = "insert into bank values('" + pinnumber + "','" + date + "','withdrawl','" + amount
						+ "')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "RS " + amount + "Debited Successfully");

				setVisible(false);
				new Transaction(pinnumber).setVisible(true);

			} catch (Exception e) {

			}

		}

	}

	public static void main(String[] args) {
		new FastCash("");
	}
}
