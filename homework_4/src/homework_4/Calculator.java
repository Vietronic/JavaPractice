package homework_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame /* implements ActionListener */{
	
	public static final int DEAFULT_WIDTH = 260;
	public static final int DEAFULT_HEIGHT = 500;
	/** 计算器上的键的显示名字 */  
    private final String[] KEYS = { "%", "√", "χ²", "¹/χ", "CE", "C", "<-", "÷",  
            "7", "8", "9", "×", "4", "5", "6", "－", "1", "2", "3", "＋", "±", "0", "·", "＝" };  
	JButton[] button;
	JTextField text;
    
    
    
	public Calculator(){
		// 设置窗口标题
		super("计算器");
		this.setSize( DEAFULT_WIDTH, DEAFULT_HEIGHT);
		this.setVisible(true);

		
		// 创建按钮对象
		button = new JButton[KEYS.length];
		
		// 
		JPanel viewPanel = new JPanel();
		
		JPanel ctrlPanel = new JPanel();
		// 按键panel  
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        
		//
		getContentPane().add(viewPanel, "North");
		getContentPane().add(ctrlPanel, "Center");
		getContentPane().add(buttonPanel, "South");
		
		buttonPanel.setLayout( new GridLayout( 6, 4));
        for(int i = 0; i < KEYS.length; i++){
        	button[i] = new JButton(KEYS[i]);
        	// 按钮大小
        	button[i].setPreferredSize(new Dimension(70, 50));
        	// 按钮颜色
        	button[i].setBackground(Color.GRAY);
        	// 字体颜色
        	button[i].setForeground(Color.BLACK);
        	// 字体
        	button[i].setFont(new java.awt.Font("幼圆",0,18));
        	buttonPanel.add(button[i]);
        }
		
        setVisible(true);
		
	}

//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
}
