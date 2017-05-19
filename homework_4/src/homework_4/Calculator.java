package homework_4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	
	public static final int DEAFULT_WIDTH = 300;
	public static final int DEAFULT_HEIGHT = 500;
	/** 计算器上的键的显示名字 */  
    private final String[] KEYS = { "%", "sqrt", "X²", "1/X", "CE", "C", "<-", "/",  
            "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".", "=" };  
	JButton[] button;
	JTextField text;
	/** 计算结果文本框 */  
    private JTextField resultText = new JTextField("0"); 
    // 标志用户按的是否是整个表达式的第一个数字,或者是运算符后的第一个数字  
    private boolean firstDigit = true;  
    // 计算的中间结果。  
    private double resultNum = 0.0;  
    // 当前运算的运算符  
    private String operator = "=";  
    // 操作是否合法  
    private boolean operateValidFlag = true;
    
    
	public Calculator(){
		// 设置窗口标题
		super("计算器");
		init();
		this.setSize( DEAFULT_WIDTH, DEAFULT_HEIGHT);
		this.setVisible(true);
		// 设置可见
        setVisible(true);
        // 使计算器中各组件大小合适  
        // this.pack();  
	}
	
	// 初始化界面
	private void init(){
		// 创建按钮对象
		button = new JButton[KEYS.length];
		
		// 按键panel  
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        
//		getContentPane().add(resultText, "North");
		getContentPane().add(resultText, "Center");
		getContentPane().add(buttonPanel, "South");
		
		buttonPanel.setLayout( new GridLayout( 6, 4));
        for(int i = 0; i < KEYS.length; i++){
        	button[i] = new JButton(KEYS[i]);
        	// 按钮大小
        	button[i].setPreferredSize(new Dimension(70, 50));
        	// 按钮颜色
        	button[i].setBackground(Color.lightGray);
        	// 字体颜色
        	button[i].setForeground(Color.BLACK);
        	// 字体
        	button[i].setFont(new java.awt.Font("幼圆",0,18));
        	// 不绘制选中边框
        	button[i].setFocusPainted(false);
        	// 不绘制边框
        	button[i].setBorderPainted(false);
        	// 注册事件
        	button[i].addActionListener(this);
        	// 把button加入panel
        	buttonPanel.add(button[i]);
        }
        
        // 文本框设置
        resultText.setFont(new Font("黑体", Font.BOLD, 30));
        resultText.setSize(90, 40);
        // 文本框中的内容采用右对齐方式  
        resultText.setHorizontalAlignment(JTextField.RIGHT);  
        // 不允许修改结果文本框  
        resultText.setEditable(false);  
        // 设置文本框背景颜色为白色  
        resultText.setBackground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 获取事件源的标签  
        String label = e.getActionCommand();
        
        if (label.equals("<-")) {  
            // 退格键
            handleBackspace();  
        } else if (label.equals("CE")) {  
            // "CE"键  
            resultText.setText("0");  
        } else if (label.equals("C")) {  
            // "C"键  
            handleC();  
        } else if ("0123456789.".indexOf(label) >= 0) {  
            // 数字键或者小数点键  
            handleNumber(label);   
        } else {  
            // 运算符  
            handleOperator(label);  
        }  
	}
	
	// 处理退格键
    private void handleBackspace() {  
        String text = resultText.getText();  
        int i = text.length();  
        if (i > 0) {  
            // 退格，将文本最后一个字符去掉  
            text = text.substring(0, i - 1);  
            if (text.length() == 0) {  
                // 如果文本没有了内容，则初始化计算器的各种值  
                resultText.setText("0");  
                firstDigit = true;  
                operator = "=";  
            } else {  
                // 显示新的文本  
                resultText.setText(text);  
            }  
        }  
    }  
  

    // 处理输入数字键
    private void handleNumber(String key) {  
        if (firstDigit) {  
            // 输入的第一个数字  
            resultText.setText(key);  
        } else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {  
            // 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面  
            resultText.setText(resultText.getText() + ".");  
        } else if (!key.equals(".")) {  
            // 如果输入的不是小数点，则将数字附在结果文本框的后面  
            resultText.setText(resultText.getText() + key);  
        }  
        // 以后输入的肯定不是第一个数字了  
        firstDigit = false;  
    }  
  
    // 处理C键
    private void handleC() {  
        // 初始化计算器的各种值  
        resultText.setText("0");  
        firstDigit = true;  
        operator = "=";  
    }  
   
	// 处理运算符键
    private void handleOperator(String key) {  
        if (operator.equals("/")) {  
            // 除法运算  
            // 如果当前结果文本框中的值等于0  
            if (getNumberFromText() == 0.0) {  
                // 操作不合法  
                operateValidFlag = false;  
                resultText.setText("除数不能为零");  
            } else {  
                resultNum /= getNumberFromText();  
            } 
            System.out.println("除法");
        } else if (operator.equals("1/X")) {  
            // 倒数运算  
            if (resultNum == 0.0) {  
                // 操作不合法  
                operateValidFlag = false;  
                resultText.setText("零没有倒数");  
            } else {  
                resultNum = 1 / resultNum;  
            }  
        } else if (operator.equals("+")) {  
            // 加法运算  
            resultNum += getNumberFromText();  
        } else if (operator.equals("-")) {  
            // 减法运算  
            resultNum -= getNumberFromText();  
        } else if (operator.equals("*")) {  
            // 乘法运算  
            resultNum *= getNumberFromText();  
        } else if (operator.equals("sqrt")) {  
            // 平方根运算  
            resultNum = Math.sqrt(resultNum);  
        } else if (operator.equals("%")) {  
            // 百分号运算，除以100  
            resultNum = resultNum / 100;  
        } else if (operator.equals("±")) {  
            // 正数负数运算  
            resultNum = resultNum * (-1);  
        } else if (operator.equals("χ²")) {  
            // 平方运算  
            resultNum *= resultNum;  
        } else if (operator.equals("=")) {  
            // 赋值运算  
            resultNum = getNumberFromText();
        }  
        if (operateValidFlag) {  
            // 双精度浮点数的运算  
            long t1;  
            double t2;  
            t1 = (long) resultNum;  
            t2 = resultNum - t1;  
            if (t2 == 0) {  
                resultText.setText(String.valueOf(t1));  
            } else {  
                resultText.setText(String.valueOf(resultNum));  
            }  
        }  
        // 运算符等于用户按的按钮  
        operator = key;  
        firstDigit = true;  
        operateValidFlag = true;  
    }  
    
    // 获取文本框中的值
    private double getNumberFromText() {  
        double result = 0;  
        try {  
            result = Double.valueOf(resultText.getText()).doubleValue();  
        } catch (NumberFormatException e) {  
        }  
        return result;  
    } 
}
