package MHB.Banking.management;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

	public MiniStatement(String pinnumber) {

		setTitle("Mini Statement");
		setLayout(null);

		JLabel mini = new JLabel();
		add(mini);

		JLabel bank = new JLabel("State Bank of India");
		bank.setBounds(130, 20, 150, 20);
		add(bank);

		JLabel card = new JLabel("");
		card.setBounds(20, 80, 300, 20);
		add(card);

		JLabel balance = new JLabel("");
		balance.setBounds(20, 400, 300, 20);
		add(balance);

		try {
			Connect con = new Connect();

			ResultSet rs = con.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
			while (rs.next()) {
				card.setText("Card Number: " + rs.getString("Card_Number").substring(0, 4) + "XXXX-XXXX"
						+ rs.getString("Card_Number").substring(12));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connect con = new Connect();
			int bal = 0;
			ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
			while (rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("amount") + "<br><br><html>");
				if (rs.getString("type").equals("Deposite")) {

					bal += Integer.parseInt(rs.getString("amount"));
				} else {
					bal = Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current account balance is Rs " + bal);

		} catch (Exception e) {
			System.out.println(e);
		}

		mini.setBounds(20, 140, 400, 200);

		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MiniStatement("");

	}
}
