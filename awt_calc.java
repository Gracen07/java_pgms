import java.awt.*;
import java.awt.event.*;

class Calc extends Frame implements ActionListener
{
    int op1,op,res=0;
    Button bp,bm,b1,b2,b3,be;
    TextField t;
    Panel p,p1;
    public Calc()
    {
        super("Calculator");
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        bp=new Button("+");
        bm=new Button("-");
        be=new Button("=");

        t=new TextField(10);

        setLayout(new GridLayout(4,1));
        add(t);

        p=new Panel();
        p.setLayout(new GridLayout(2,2));
        p.add(b1);
        p.add(b2);
        p.add(bp);
        p.add(bm);
        add(p);

        p1=new Panel();
        p1.setLayout(new GridLayout(1,2));
        p1.add(be);
        p1.add(b3);
        add(p1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bp.addActionListener(this);
        bm.addActionListener(this);
        be.addActionListener(this);

        setSize(300,300);
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

public class awt_calc
{
    public static void main(String args[])
    {
        Calc obj=new Calc();
    }
}