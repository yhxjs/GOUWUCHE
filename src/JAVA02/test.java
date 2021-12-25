package JAVA02;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        JFrame p = new JFrame("031902430_张奕鸿_实验二");
        JPanel f = new JPanel();
        p.add(f);
        f.setLayout(null);
        JButton addS = new JButton("添加");
        addS.setBounds(20, 420, 100, 60);
        addS.addActionListener((event) -> {
            AddsFrame a=new AddsFrame();
        });
        JButton deleteS = new JButton("删除");
        deleteS.setBounds(140, 420, 100, 60);
        deleteS.addActionListener((event) -> {
            DeletesFrame a=new DeletesFrame();
        });
        JButton searchS = new JButton("查询");
        searchS.setBounds(260, 420, 100, 60);
        searchS.addActionListener((event) -> {
            SearchsFrame a=new SearchsFrame();
        });
        File t = new File("");
        String d = t.getAbsolutePath();
        ImageIcon icon = new ImageIcon(d + "\\src\\JAVA02\\chop.jpg");
        JButton chopS = new JButton(icon);
        chopS.setSize(400, 400);
        chopS.addActionListener((event) -> {
            ChopsFrame a=new ChopsFrame();
        });
        JButton output=new JButton("导出购物车");
        output.setBounds(70, 500, 100, 60);
        output.addActionListener((event) -> {
            try {
                FileWriter fileWriter=new FileWriter(d+"\\src\\JAVA02\\text.txt");
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                for (Goods goods : Data.goodsList){
                    String a=String.valueOf(goods.getNo());
                    String b=String.valueOf(goods.getName());
                    String c=String.valueOf(goods.getPrice());
                    String e=String.valueOf(goods.getNum());
                    bufferedWriter.write(a);
                    bufferedWriter.newLine();
                    bufferedWriter.write(b);
                    bufferedWriter.newLine();
                    bufferedWriter.write(c);
                    bufferedWriter.newLine();
                    bufferedWriter.write(e);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                bufferedWriter.close();
                JOptionPane.showMessageDialog(p, "导出成功!", "成功", JOptionPane.PLAIN_MESSAGE);
            }
            catch (IOException e){
                System.out.println("文件流创建异常");
            }
        });
        JButton input=new JButton("导入购物车");
        input.setBounds(220, 500, 100, 60);
        input.addActionListener((event) -> {
            try {
                FileReader fileReader=new FileReader(d+"\\src\\JAVA02\\text.txt");
                BufferedReader bufferedReader=new BufferedReader(fileReader);
                String no=null;
                no=bufferedReader.readLine();
                String name=bufferedReader.readLine();
                String price=bufferedReader.readLine();
                String num=bufferedReader.readLine();
                Data.goodsList.clear();
                Goods.n=0;
                while(no!=null){
                    Data.goodsList.add(new Goods(name,Double.parseDouble(price),Integer.parseInt(num),Integer.parseInt(no)));
                    no=null;
                    no=bufferedReader.readLine();
                    name=bufferedReader.readLine();
                    price=bufferedReader.readLine();
                    num=bufferedReader.readLine();
                    Goods.n++;
                }
                bufferedReader.close();
                JOptionPane.showMessageDialog(p, "导入成功!", "成功", JOptionPane.PLAIN_MESSAGE);
            }
            catch (IOException e){
                System.out.println("文件流创建异常");
            }
        });
        p.setBounds(600, 200, 400, 600);
        p.setVisible(true);
        p.setResizable(true);
        f.setBackground(new Color(143, 219, 182));
        f.add(addS);
        f.add(deleteS);
        f.add(searchS);
        f.add(chopS);
        f.add(input);
        f.add(output);
        f.validate();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
