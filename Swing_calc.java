import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Calc extends JFrame implements ActionListener
{
    int op1,op,res=0;
    JButton bp,bm,b1,b2,b3,be;
    JTextField t;
    JPanel p,p1;
    public Calc()
    {
        super("Calculator");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        bp=new JButton("+");
        bm=new JButton("-");
        be=new JButton("=");

        t=new JTextField(10);

        Container c=this.getContentPane();
        c.setLayout(new GridLayout(4,1));
        c.add(t);

        p=new JPanel();
        p.setLayout(new GridLayout(3,2));
        p.add(b1);
        p.add(b2);
        p.add(bp);
        p.add(bm);
        p.add(be);
        p.add(b3);
        c.add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bp.addActionListener(this);
        bm.addActionListener(this);
        be.addActionListener(this);

        setSize(500,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        String str="";
        str=t.getText();
        if(ae.getSource()==b1)
        {            
            t.setText(str+"1");
        }
        if(ae.getSource()==b2)
        {   
            t.setText(str+"2");
        }
        if(ae.getSource()==b3)
        {     
            t.setText(str+"3");
        }
        if(ae.getSource()==bp)
        {            
            op1=Integer.parseInt(str);
            t.setText("");
            op=1;
        }
        if(ae.getSource()==bm)
        {            
            op1=Integer.parseInt(str);
            t.setText("");
            op=2;
        }
        if(ae.getSource()==be)
        {            
            int op2=Integer.parseInt(str);
            if(op==1)
            {
                res=op1+op2;
            }
            else
            {
                res=op1-op2;
            }

            t.setText(""+res);
        }


    }


}

public class Swing_calc
{
    public static void main(String args[])
    {
        Calc obj=new Calc();
    }
}