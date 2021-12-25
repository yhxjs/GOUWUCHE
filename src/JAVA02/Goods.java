package JAVA02;

public class Goods {
    private String name;
    private double price;
    private int num;
    private int no;
    static int n=0;

    public Goods(String name, double price, int num,int no) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.no=no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
