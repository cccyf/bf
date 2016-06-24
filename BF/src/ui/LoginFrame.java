package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import rmi.RemoteHelper;
import ui.LoginDialog.ButtonActionListener;
import ui.LoginDialog.backActionListener;

public class LoginFrame {
	ImageIcon logo = new ImageIcon("/Users/chengyunfei/Desktop/workspace/BF/image/logo4.png");
	JPanel login;
	JLabel logoLabel = new JLabel(logo);
	JLabel userL;
	JLabel passwordL;
	JButton loginB;
	JTextField userT;
	JPasswordField passwordP;
	JButton registerB;
	JLabel out;
	JPanel info;
	String nameInput;
	JFrame frame;
	JLabel hint;

	public LoginFrame() {
		frame = new JFrame("BF Server");
		// frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(730, 480);
		frame.setResizable(false);
		frame.setLayout(null);

		Dimension fraDim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((fraDim.width - 730) / 2, (fraDim.height - 480) / 2);
		init();
	}

	public void init() {
		login = new JPanel();
		Color logColor = new Color(71, 209, 175);
		login.setBackground(logColor);
		login.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		logoLabel.setBounds(150, 30, 430, 630);
		login.setLayout(null);
		login.add(logoLabel);

		// info = new JPanel();
		// info.setBounds(215, , width, height);
		userL = new JLabel("User name : ");
		userL.setBounds(250, 260, 80, 40);

		// userL.setOpaque(false);
		userT = new JTextField(10);
		// userT.setBackground(Color.BLACK);
		userT.setBounds(340, 260, 120, 40);

		passwordL = new JLabel(" Password :");
		passwordL.setOpaque(false);
		passwordL.setBounds(250, 310, 80, 40);
		passwordP = new JPasswordField();
		passwordP.setBounds(340, 310, 120, 40);
		passwordP.setEchoChar('*');

		hint = new JLabel("");
		hint.setHorizontalAlignment(JTextField.CENTER);
		hint.setVerticalAlignment(JTextField.CENTER);
		hint.setBounds(290, 400, 150, 40);

		loginB = new JButton("Log In");
		loginB.setBounds(235, 365, 100, 40);
		loginB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameInput = userT.getText();
				char[] password = passwordP.getPassword();
				String pass = new String(password);
				try {
					boolean canLogIn = RemoteHelper.getInstance().getUserService().login(nameInput, pass);
					if (canLogIn) {

						MainFrame jf = new MainFrame();
						jf.setUserName(nameInput);
						jf.setListSelected();
						jf.setVersionSelected();
						setList(jf);
						frame.dispose();

					} else {
						hint.setText("Wrong password!");
						// hint.setBounds(250, 420, 100, 40);
						// login.add(hint);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});
		registerB = new JButton("Register");
		registerB.setBounds(395, 365, 100, 40);
		registerB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameInput = userT.getText();
				char[] password = passwordP.getPassword();
				String pass = new String(password);
				// System.out.println(pass);
				try {
					System.out.println(nameInput);
					boolean canRegister = RemoteHelper.getInstance().getUserService().register(nameInput, pass);
					if (canRegister) {

						MainFrame jf = new MainFrame();
						jf.setUserName(nameInput);
						jf.setListSelected();
						// jf.log();
						setList(jf);
						frame.dispose();
					} else {
						// System.out.println("al");
						hint.setText("Already existed!");
						// hint.setBounds(250, 400, 100, 40);
						// login.add(hint);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

		login.add(userL);
		login.add(userT);
		login.add(passwordL);
		login.add(passwordP);
		login.add(loginB);
		login.add(registerB);
		login.add(hint);
		frame.add(login);
		frame.setVisible(true);

	}

	/*
	 * class ButtonActionListener implements ActionListener {
	 * 
	 * public void actionPerformed(ActionEvent e) { String cmd =
	 * e.getActionCommand(); String out = "Wrong!"; if (cmd == "Log In") {
	 * nameInput = userT.getText(); char[] password = passwordP.getPassword();
	 * String pass = new String(password); try { boolean canLogIn =
	 * RemoteHelper.getInstance().getUserService().login(nameInput, pass); if
	 * (canLogIn) { out = "Success!"; MainFrame jf = new MainFrame();
	 * jf.setUserName(nameInput); jf.setListSelected(); jf.setVersionSelected();
	 * // jf.setLogOut(); setList(jf);
	 * 
	 * } } catch (RemoteException e1) { e1.printStackTrace(); }
	 * 
	 * } else if (cmd == "Register") { nameInput = userT.getText(); char[]
	 * password = passwordP.getPassword(); String pass = new String(password);
	 * // System.out.println(pass); try { System.out.println(nameInput); boolean
	 * canRegister =
	 * RemoteHelper.getInstance().getUserService().register(nameInput, pass); if
	 * (canRegister) { out = "Welcome!"; // System.out.println("ok"); MainFrame
	 * jf = new MainFrame(); jf.setUserName(nameInput); jf.setListSelected(); //
	 * jf.log(); setList(jf); } else { out = "Already existed!"; } } catch
	 * (RemoteException e1) { e1.printStackTrace(); }
	 * 
	 * } outDia(out);
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public void outDia(String output) { frame.removeAll(); frame.repaint();
	 * JLabel out = new JLabel(output);// ,Label.CENTER);
	 * out.setHorizontalAlignment(SwingConstants.CENTER);
	 * out.setVerticalAlignment(SwingConstants.TOP); out.setBounds(50, 60, 200,
	 * 60); // out.setText(output); // out.setDefaultLocale(Label.CENTER);
	 * JButton back = new JButton("back"); back.setBounds(110, 110, 80, 60);
	 * back.addActionListener(new backActionListener()); frame.add(out);
	 * frame.add(back); frame.repaint(); // frame.dispose(); };
	 */

	public void setList(MainFrame jf) {
		try {
			jf.setFileList(RemoteHelper.getInstance().getIOService().readFileList(jf.getUserName()));
			jf.log();
			jf.timerInitial();
			jf.createFileStacks();
			// System.out.println(RemoteHelper.getInstance().getIOService().readFileList(jf.getUserName()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
