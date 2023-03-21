

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;



//yourFrame.setResizable(false);

public class Main extends JFrame implements ActionListener{

    double num1=0,num2=0,result=0;
	char operator;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[7];
    JButton addButton,subButton,mulButton,divButton;
	JButton equButton, clearButton, decButton;
    String str = "";
   // MyPanel panel;
   

        public Main() {
            
            //panel = new MyPanel();
            setSize(800,1000);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            setResizable(false);
            setLocationRelativeTo(null);

            textfield = new JTextField();
            textfield.setBounds(50, 25, 700, 150);
            textfield.setEditable(false);
           // textfield.setDocument(new JTextFieldLimit(10));
            
           //getContentPane().setBackground(Color.WHITE);

            JPanel tusPaneli = new JPanel();
            
            
            //tusPaneli.setLayout(new GridLayout(4, 4));
            tusPaneli.setBackground(Color.white);
            
            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("÷");
            decButton = new JButton(".");
            equButton = new JButton("=");
            clearButton = new JButton("C");
           
            functionButtons[0] = addButton;
            functionButtons[1] = subButton;
            functionButtons[2] = mulButton;
            functionButtons[3] = divButton;
            functionButtons[4] = decButton;
            functionButtons[5] = equButton;
            functionButtons[6] = clearButton;

            for(int i =0;i<7;i++) {
                functionButtons[i].addActionListener(this);
                functionButtons[i].setBackground(Color.BLUE);
                functionButtons[i].setForeground(Color.WHITE);
            }

            for(int i =0;i<10;i++) {
                numberButtons[i] = new JButton(String.valueOf(i));
                numberButtons[i].addActionListener(this);
                numberButtons[i].setBackground(Color.BLUE);
                numberButtons[i].setForeground(Color.WHITE);
            }

            tusPaneli.setBounds(50, 300, 700, 500);
		    tusPaneli.setLayout(new GridLayout(4,4,10,10));

            clearButton.setBounds(50, 190, 700, 100);



            tusPaneli.add(numberButtons[7]);
            tusPaneli.add(numberButtons[8]);
            tusPaneli.add(numberButtons[9]);
            tusPaneli.add(addButton);

            tusPaneli.add(numberButtons[4]);
            tusPaneli.add(numberButtons[5]);
            tusPaneli.add(numberButtons[6]);
            tusPaneli.add(subButton);

            tusPaneli.add(numberButtons[1]);
            tusPaneli.add(numberButtons[2]);
            tusPaneli.add(numberButtons[3]);
            tusPaneli.add(mulButton);

            tusPaneli.add(numberButtons[0]);
            tusPaneli.add(decButton);
            tusPaneli.add(equButton);
            tusPaneli.add(divButton);

           

            
            //add(tusPaneli,BorderLayout.CENTER);
            //add(textfield);// islem yapmak istiyorsan burayı ac graphı kapat
            //add(panel);
            //pack();
            add(clearButton);
            add(tusPaneli);
            setVisible(true);
            

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            for(int i=0;i<10;i++) {
                
                if(e.getSource() == numberButtons[i]) {
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                    str =  str + String.valueOf(i);
                }
            }
            if(e.getSource()==decButton) {
                textfield.setText(textfield.getText().concat("."));
                str += ".";
            }
            if(e.getSource()==addButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator ='+';
                textfield.setText("");
                //str = String.valueOf(num1);
                str = "";
            }
            if(e.getSource()==subButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator ='-';
                textfield.setText( "");
                //str = String.valueOf(num1);
                str = "";
            }
            if(e.getSource()==mulButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator ='*';
                textfield.setText( "");
                //str = String.valueOf(num1);
                str = "";
            }
            if(e.getSource()==divButton) {
                num1 = Double.parseDouble(textfield.getText());
                operator ='/';
                textfield.setText( "");
                //str = String.valueOf(num1);
                str = "";
            }
            if(e.getSource()==equButton) {
                num2=Double.parseDouble(textfield.getText());
                str = " ";
                str = String.valueOf(num2);
                switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
                }
                textfield.setText(String.valueOf(result));
                //str = " ";
                str = String.valueOf(result);
                num1=result;
            }
            if(e.getSource()==clearButton) {
                textfield.setText("");
                str = "";
            }
            repaint();
            
        }
            
        
    
    
    public static void main(String[] args) {
        new Main();


    }
   // /* 
    public void paint(Graphics g){// graph g 
        // jpanel ekle set bounds kullan, clear rectangle
        super.paint(g);
        JPanel panel = new JPanel();
        panel.setBounds(50, 25, 700, 150);
        
        for(int xo = 0;xo<str.length();xo++){//charları sıra ile gezip çizdir
            char c = str.charAt(xo);
            
            switch(c){
                case '9':
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 10, 80);//sol ust
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 120);//sag
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                    

                break;

                case '8':
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 10, 120);//sol
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 120);//sag
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                    

                break;

                case '7':
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 120);//sag
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                   

                break;

                case '6':
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 10, 120);//sol
                    g.drawLine(xo * 80 + 70, 80, xo * 80 + 70, 120);//sag alt
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                   

                break;

                case '5':
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 10, 80);//sol ust
                    g.drawLine(xo * 80 + 70, 80, xo * 80 + 70, 120);//sag alt
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                    

                break;

                case '4':
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 10, 80);//sol ust
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 120);//sag
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                   

                break;

                case '3':
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 120);//sag
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                   

                break;

                case '2':
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 10, 120);//sol alt
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 80);//sag ust
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                    

                break;

                case '1':
                    g.drawLine(xo * 80 + 40, 40, xo * 80 + 40, 120);
                    

                break;

                case '0':
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 10, 120);//sol
                    g.drawLine(xo * 80 + 70, 40, xo * 80 + 70, 120);//sag
                    g.drawLine(xo * 80 + 10, 40, xo * 80 + 70, 40);//ust
                    g.drawLine(xo * 80 + 10, 120, xo * 80 + 70, 120);//alt
                 

                break;

                case '.':
                    g.fillRect(xo*80-2,116 ,3,3);
                  

                break;

                case '-':
                    g.drawLine(xo * 80 + 10, 80, xo * 80 + 70, 80);//orta
                    

                break;
                default:
                //g.clearRect(50, 25, 700, 150);
                //getContentPane().setBackground(Color.WHITE);
                    g.clearRect(0, 30, 800, 100);
                    g.drawRect(0,35,790,90);
                   // g.
                break;

            }
            
            
        }
    
        
    }
    //*/
}
