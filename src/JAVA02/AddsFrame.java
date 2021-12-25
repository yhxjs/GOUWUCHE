package JAVA02;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddsFrame extends JFrame {
    public AddsFrame() {
        GridLayout lay=new GridLayout(7,1);
        setLayout(lay);
        setTitle("添加商品");
        setBounds(650, 250, 250, 300);
        setVisible(true);
        setResizable(false);
        JLabel nameLabel=new JLabel("商品名:");
        JLabel priceLabel=new JLabel("价格:");
        JLabel numLabel=new JLabel("数量:");
        JTextField name=new JTextField("请输入商品名",10);
        JTextField price=new JTextField("请输入价格",10);
        JTextField num=new JTextField("请输入数量",10);
        JButton submit=new JButton("确认");
        name.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                name.selectAll();
            }
        });
        price.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                price.selectAll();
            }
        });
        num.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                num.selectAll();
            }
        });
        submit.setSize(50,50);
        submit.addActionListener((event)->{
            String s=price.getText();
            double i=Double.parseDouble(s);
            boolean flag=false;
            if(i<0||Integer.parseInt(num.getText())<=0){
                JOptionPane.showMessageDialog(this,"非法数据！","失败",JOptionPane.WARNING_MESSAGE);
            }
            else {
                for(Goods goods: Data.goodsList){
                    if(goods.getName().equals(name.getText())&&goods.getPrice()==i){
                        flag=true;
                        goods.setNum(goods.getNum()+Integer.parseInt(num.getText()));
                        System.out.println(Data.goodsList.size());
                        System.out.println("n"+Goods.n);
                        JOptionPane.showMessageDialog(this, "已添加!", "成功", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
                if(!flag) {
                    Data.goodsList.add(new Goods(name.getText(), Double.parseDouble(price.getText()),Integer.parseInt(num.getText()),++Goods.n));
                    System.out.println(Data.goodsList.size());
                    System.out.println("n"+Goods.n);
                    JOptionPane.showMessageDialog(this, "已添加!", "成功", JOptionPane.PLAIN_MESSAGE);
                }
            }
            name.setText("请输入商品名");
            price.setText("请输入价格");
            num.setText("请输入数量");
        });
        add(nameLabel);
        add(name);
        add(priceLabel);
        add(price);
        add(numLabel);
        add(num);
        add(submit);
        validate();
    }
}
