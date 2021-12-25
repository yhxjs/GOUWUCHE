package JAVA02;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DeletesFrame extends JFrame {
    public DeletesFrame() {
        setLayout(new FlowLayout());
        setTitle("删除商品");
        setBounds(650, 250, 250, 250);
        setVisible(true);
        setResizable(false);
        JLabel noLabel=new JLabel("记录号:");
        JTextField no=new JTextField("请输入记录号",10);
        no.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                no.selectAll();
            }
        });
        JButton submit=new JButton("删除");
        submit.addActionListener((event)->{
            if(Integer.parseInt(no.getText())<=0)
                JOptionPane.showMessageDialog(this,"非法数据！","失败",JOptionPane.WARNING_MESSAGE);
            else {
                boolean flag = false;
                int j = Integer.parseInt(no.getText());
                for (int i=Data.goodsList.size()-1;i>=0;i--) {
                    if (Data.goodsList.get(i).getNo() == j) {
                        Data.goodsList.remove(i);
                        flag=true;
                        Goods.n=Data.goodsList.size();
                        for (int k=Data.goodsList.size()-1;i>=0;i--){
                            Data.goodsList.get(k).setNo(k+1);
                        }
                        JOptionPane.showMessageDialog(this, "已删除!", "成功", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(this, "该记录不存在！", "失败", JOptionPane.WARNING_MESSAGE);
                }
            }
            no.setText("请输入记录号");
        });
        add(noLabel);
        add(no);
        add(submit);
        validate();
    }
}
