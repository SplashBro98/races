package task.epam.race.pool;

public class Account {
    private double sum;
    private String name;

    public Account(double sum, String name) {
        this.sum = sum;
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double takeMoney(double money){
        this.sum -= money;
        return money;
    }
}
