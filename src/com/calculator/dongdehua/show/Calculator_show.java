package com.calculator.dongdehua.show;
import javax.swing.JButton;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;

public class Calculator_show {

	protected Shell shell;
	private Text text;
    public static String x="";
    public static double result;
    private int temp = 0;
   
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator_show window = new Calculator_show();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   

	/**
	 * Open the window.
	 */
    public double calculate(int temp){
    	  switch(temp){
    	  case 1:result+=Double.parseDouble(x);break;
    	  case 2:result-=Double.parseDouble(x);break;
    	  case 3:result*=Double.parseDouble(x);break;
    	  case 4:result/=Double.parseDouble(x);break;
    	  case 5:result%=Double.parseDouble(x);break;
    	  case 6:result=Math.sqrt(result);break;
    	   }
    	 return result;
    }
	
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(647, 400));
		shell.setSize(450, 300);
		shell.setText("计算器");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 631, 361);
		
		Button Backspace = new Button(composite, SWT.NONE);
		Backspace.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Backspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String  DisplayString= text.getText(); // 取显示区的数字，String型 
			    String IsPoint = String.valueOf(DisplayString.charAt(DisplayString.length() - 1 ) ); // 查看当前去掉字符是否为"." 
			    if( IsPoint.compareTo( "." ) == 0 ){ 
			    boolean PointState = false; 
			    } 
			    DisplayString = DisplayString.substring( 0, ( DisplayString.length()-1 ) ); 
			    if( DisplayString.length() == 0 || ( DisplayString.compareTo( "-" ) == 0 ) ){ 
			     DisplayString = "0"; 
			    } 
			    String M = DisplayString; 
			    text.setText( M );
			    
			
			}
			});
		Backspace.setBounds(38, 93, 106, 48);
		Backspace.setText("Backspace");
		
		Button Empty = new Button(composite, SWT.NONE);
		Empty.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Empty.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			        x="";
			       text.setText(x);
			       result=0;
			}
		});
		Empty.setBounds(150, 93, 106, 48);
		Empty.setText("C");
		
		Button Button_0 = new Button(composite, SWT.NONE);
		Button_0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(x==""||x.charAt(0)!=0){
				x=x+"0";
				text.setText(x);
			}
				}
		});
		Button_0.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_0.setBounds(262, 93, 106, 48);
		Button_0.setText("0");
		
		Button Add = new Button(composite, SWT.NONE);
		Add.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				  if(result==0&&x != ""){
					  result=Double.parseDouble(x);
				  }
				  else{
					  calculate(1);
					  text.setText(Double.toString(result));
                  }
				  temp = 1;
				  x="";
			      }
		});
		Add.setBounds(374, 93, 106, 48);
		Add.setText("+");
		
		Button Button_1 =new Button(composite, SWT.NONE);
		Button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"1";
				text.setText(x);
	
			}
		});
		Button_1.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_1.setBounds(38, 161, 106, 48);
		Button_1.setText("1");
		
		Button Button_2 = new Button(composite, SWT.NONE);
		Button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"2";
			 text.setText(x);
	        
			}
		});
		Button_2.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_2.setBounds(150, 161, 106, 48);
		Button_2.setText("2");
		
		Button Button_3 = new Button(composite, SWT.NONE);
		Button_3.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"3";
				text.setText(x);
			   
			}
		});
		Button_3.setBounds(262, 161, 106, 48);
		Button_3.setText("3");
		
		Button Minus = new Button(composite, SWT.NONE);
		Minus.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Minus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			   
				if(result==0&&x != ""){
					  result=Double.parseDouble(x);
				  }
				  else{
					  calculate(2);
					  text.setText(Double.toString(result));
                }
				  temp = 2;
				  x="";
			      }
			});
		Minus.setBounds(374, 161, 106, 48);
		Minus.setText("-");
		
		Button Button_4 = new Button(composite, SWT.NONE);
		Button_4.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"4";
				text.setText(x);
			
			}
		});
		Button_4.setBounds(38, 228, 106, 48);
		Button_4.setText("4");
		
		Button Button_5 = new Button(composite, SWT.NONE);
		Button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"5";
				text.setText(x);
	
			}
		});
		Button_5.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_5.setBounds(150, 228, 106, 48);
		Button_5.setText("5");
		
		Button Button_6 = new Button(composite, SWT.NONE);
		Button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"6";
				text.setText(x);
		
			}
		});
		Button_6.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_6.setBounds(262, 228, 106, 48);
		Button_6.setText("6");
		
		Button Multiply = new Button(composite, SWT.NONE);
		Multiply.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Multiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(result==0||x==""){
					result=Double.parseDouble(x);
				}
				else{ 
					calculate(3);
			      text.setText(Double.toString(result));
			}
				  temp = 3;
				  x="";
			      }
		});
		Multiply.setBounds(374, 228, 106, 48);
		Multiply.setText("*");
		
		Button Button_7 = new Button(composite, SWT.NONE);
		Button_7.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"7";
				text.setText(x);
		
			}
		});
		Button_7.setBounds(38, 300, 106, 48);
		Button_7.setText("7");
		
		Button Button_8 = new Button(composite, SWT.NONE);
		Button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"8";
				text.setText(x);
		
			}
		});
		Button_8.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_8.setBounds(150, 300, 106, 48);
		Button_8.setText("8");
		
		Button Button_9 = new Button(composite, SWT.NONE);
		Button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				x=x+"9";
				text.setText(x);
				
			}
		});
		Button_9.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Button_9.setBounds(262, 300, 106, 48);
		Button_9.setText("9");
		
		Button Divide = new Button(composite, SWT.NONE);
		Divide.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Divide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(result==0||x==""){
					result=Double.parseDouble(x);
				}
				else{ 
					calculate(4);
			      text.setText(Double.toString(result));
			}
				  temp =4;
				  x="";
			      }
		});
		Divide.setBounds(374, 300, 106, 48);
		Divide.setText("/");
		
		Button Sqrt = new Button(composite, SWT.NONE);
		Sqrt.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Sqrt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(result==0||x==""){
					result=Double.parseDouble(x);
				}
				else{ 
					calculate(6);
			      text.setText(Double.toString(result));
			}
				  temp =6;
				  x="";
			      }
		});
		Sqrt.setBounds(503, 93, 106, 48);
		Sqrt.setText("sqrt");
		
		Button Mod = new Button(composite, SWT.NONE);
		Mod.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Mod.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(result==0||x==""){
					result=Double.parseDouble(x);
				}
				else{ 
					calculate(5);
			      text.setText(Double.toString(result));
			}
				  temp =5 ;
				  x="";
			      }
		});
		Mod.setBounds(503, 161, 106, 48);
		Mod.setText("%");
	
		Button Point = new Button(composite, SWT.NONE);
		Point.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Point.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(x!=""){
				if(x.compareTo(".")==0){
					text.setText(x);
				}
				else{
					x=x+".";
					text.setText(x);
				}
			}
				else 
				{
					x="0.";;
				  text.setText(x);
				  }
			
			}
		});
		Point.setBounds(503, 228, 106, 48);
		Point.setText(".");
		
		Button Equal = new Button(composite, SWT.NONE);
		Equal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	             calculate(temp);
				  text.setText(String.valueOf(result));
				
			}
		});
		Equal.setFont(SWTResourceManager.getFont("新宋体", 15, SWT.NORMAL));
		Equal.setBounds(503, 300, 106, 48);
		Equal.setText("=");
		
		text = new Text(composite, SWT.BORDER | SWT.RIGHT);
		text.setFont(SWTResourceManager.getFont("MingLiU", 25, SWT.NORMAL));
		text.setBounds(38, 10, 571, 77);

	}
}
