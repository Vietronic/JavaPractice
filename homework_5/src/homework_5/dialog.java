package homework_5;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

public class dialog extends JFrame implements ActionListener {
	JLabel nameLabel, pwdLabel;
	JButton login, reg;
	JTextField nameTextField;
	JPasswordField pwdTextField;
	JPanel mainPanel;
	public static final int DEAFULT_WIDTH = 250;
	public static final int DEAFULT_HEIGHT = 200;
	
	public dialog(){
		super("��¼����");
		init();
		
		// ���ô����С�Ϳɼ���
		this.setSize( DEAFULT_WIDTH, DEAFULT_HEIGHT);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	// ��ʼ�����������
	private void init(){
		nameLabel = new JLabel("�û���:");
		pwdLabel = new JLabel("����:");
		login = new JButton("��¼");
		reg = new JButton("ע��");
		nameTextField = new JTextField(20);
		pwdTextField = new JPasswordField(20);
		
		login.addActionListener(this);
		reg.addActionListener(this);
		
		login.setBackground(Color.LIGHT_GRAY);
		reg.setBackground(Color.LIGHT_GRAY);
		
		mainPanel = new JPanel();
		mainPanel.add(nameLabel);
		mainPanel.add(nameTextField);
		mainPanel.add(pwdLabel);
		mainPanel.add(pwdTextField);
		mainPanel.add(login);
		mainPanel.add(reg);
		
		getContentPane().add(mainPanel);
	}
	
	private void login(String name, char[] pwd) throws SQLException{
		db_process db = new db_process();
		
		if(db.loginUser( name, pwd)){
			JOptionPane.showMessageDialog( null, "��¼�ɹ�!", "", JOptionPane. PLAIN_MESSAGE);
		}else{
			JOptionPane.showMessageDialog( null, "��¼ʧ��!", "", JOptionPane. PLAIN_MESSAGE);
		}
		
		db.close();
	}
	
	private void reg(String name, char[] pwd) throws SQLException{
		db_process db = new db_process();		
		
		if(db.regUser( name, pwd)){
			JOptionPane.showMessageDialog( null, "ע��ɹ�!", "", JOptionPane. PLAIN_MESSAGE);
		}else{
			JOptionPane.showMessageDialog( null, "ע��ʧ��!", "", JOptionPane. PLAIN_MESSAGE);
		}
		
		db.close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-ge3nerated method stub
		String label = arg0.getActionCommand();
		
		if(label=="��¼"){
			try {
				login( nameTextField.getText(), pwdTextField.getPassword());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(label=="ע��"){
			try {
				reg( nameTextField.getText(), pwdTextField.getPassword());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}