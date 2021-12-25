package JAVA02;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SearchsFrame extends JFrame {
    public SearchsFrame() {
        setLayout(new FlowLayout());
        setTitle("查询商品");
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
        JButton submit=new JButton("查询");
        JButton first=new JButton("第一个");
        JButton last=new JButton("最后一个");
        submit.addActionListener((event)->{
            if(Integer.parseInt(no.getText())<=0)
                JOptionPane.showMessageDialog(this,"非法数据！","失败",JOptionPane.WARNING_MESSAGE);
            else {
                boolean flag = false;
                int j = Integer.parseInt(no.getText());
                for (Goods goods : Data.goodsList) {
                    if (goods.getNo() == j) {
                        JFrame recordFrame = new JFrame("第" + j + "号记录为");
                        recordFrame.setBounds(600, 200, 400, 200);
                        Object[] name = {"记录号", "商品名", "价格", "数量", "总价"};
                        DefaultTableModel tableModel = new DefaultTableModel(name, 0);
                        JTable table = new JTable(tableModel);
                        recordFrame.setLayout(new BorderLayout());
                        recordFrame.add(new JScrollPane(table));
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        table.setDefaultRenderer(Object.class, tcr);
                        Object[] info = {goods.getNo(), goods.getName(), goods.getPrice(), goods.getNum(), goods.getNum() * goods.getPrice()};
                        tableModel.addRow(info);
                        recordFrame.setVisible(true);
                        recordFrame.setResizable(true);
                        recordFrame.validate();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(this, "该记录不存在！", "失败", JOptionPane.WARNING_MESSAGE);
                }
            }
            no.setText("请输入记录号");
        });
        first.addActionListener((event)->{
            if(Data.goodsList.size()<=0){
                JOptionPane.showMessageDialog(this, "还未添加商品！", "失败", JOptionPane.WARNING_MESSAGE);
            }
            else {
                Goods goods=Data.goodsList.get(0);
                        JFrame recordFrame = new JFrame("第一个记录为");
                        recordFrame.setBounds(600, 200, 400, 200);
                        Object[] name = {"记录号", "商品名", "价格", "数量", "总价"};
                        DefaultTableModel tableModel = new DefaultTableModel(name, 0);
                        JTable table = new JTable(tableModel);
                        recordFrame.setLayout(new BorderLayout());
                        recordFrame.add(new JScrollPane(table));
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        table.setDefaultRenderer(Object.class, tcr);
                        Object[] info = {goods.getNo(), goods.getName(), goods.getPrice(), goods.getNum(), goods.getNum() * goods.getPrice()};
                        tableModel.addRow(info);
                        recordFrame.setVisible(true);
                        recordFrame.setResizable(true);
                        recordFrame.validate();
                    }
            no.setText("请输入记录号");
        });
        last.addActionListener((event)->{
            if(Data.goodsList.size()<=0){
                JOptionPane.showMessageDialog(this, "还未添加商品！", "失败", JOptionPane.WARNING_MESSAGE);
            }
            else {
                Goods goods=Data.goodsList.get(Data.goodsList.size()-1);
                JFrame recordFrame = new JFrame("最后一个记录为");
                recordFrame.setBounds(600, 200, 400, 200);
                Object[] name = {"记录号", "商品名", "价格", "数量", "总价"};
                DefaultTableModel tableModel = new DefaultTableModel(name, 0);
                JTable table = new JTable(tableModel);
                recordFrame.setLayout(new BorderLayout());
                recordFrame.add(new JScrollPane(table));
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(JLabel.CENTER);
                table.setDefaultRenderer(Object.class, tcr);
                Object[] info = {goods.getNo(), goods.getName(), goods.getPrice(), goods.getNum(), goods.getNum() * goods.getPrice()};
                tableModel.addRow(info);
                recordFrame.setVisible(true);
                recordFrame.setResizable(true);
                recordFrame.validate();
            }
            no.setText("请输入记录号");
        });
        add(noLabel);
        add(no);
        add(submit);
        add(first);
        add(last);
        validate();
    }
}
