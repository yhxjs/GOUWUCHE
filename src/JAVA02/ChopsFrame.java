package JAVA02;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;

public class ChopsFrame extends JFrame {
    JTable table;
    Object[] name = {"记录号", "商品名", "价格", "数量", "总价"};
    JButton button;
    DefaultTableModel tableModel;
    double sum=0;
    public ChopsFrame() {
        setTitle("剁剁剁");
        setBounds(600, 200, 450, 600);
        setVisible(true);
        setResizable(true);
        tableModel= new DefaultTableModel(name, 0);
        table=new JTable(tableModel);
        setLayout(new BorderLayout());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JScrollPane(table));
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        button=new JButton("剁手");
        for(Goods goods: Data.goodsList){
            Object[] info = {goods.getNo(), goods.getName(), goods.getPrice(), goods.getNum(), goods.getNum() * goods.getPrice()};
            sum+=goods.getNum() * goods.getPrice();
            tableModel.addRow(info);
        }
        Object[] info = {"", "", "", "", sum};
        tableModel.addRow(info);
        button.addActionListener((e -> {
            if(Data.goodsList.size()>0) {
                for (int i = Data.goodsList.size() - 1; i >= 0; i--) {
                    Data.goodsList.remove(i);
                }
                Goods.n = 0;
                JOptionPane.showMessageDialog(this, "已清空购物车!花费"+sum+"元", "成功", JOptionPane.PLAIN_MESSAGE);
                sum=0;
            }
            else{
                JOptionPane.showMessageDialog(this, "购物车空空如也!", "失败", JOptionPane.WARNING_MESSAGE);
            }
            tableModel=new DefaultTableModel(name,0);
            table.setModel(tableModel);
            Object[] info1 = {"", "", "", "", sum};
            tableModel.addRow(info1);
        }));
        add(button);
    }
}
