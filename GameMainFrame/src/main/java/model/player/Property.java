package model.player;

public class Property {
    int money;
    int point;
    int bomb;
    int block;
    int robot;

    public Property(int money, int point, int bomb, int block, int robot) {
        this.money=money;
        this.point=point;
        this.bomb = bomb;
        this.block = block;
        this.robot = robot;
    }

    public int getMoney() {
        return money;
    }

    public int getPoint() {
        return point;
    }

    public int getBomb() {
        return bomb;
    }

    public int getBlock() {
        return block;
    }

    public int getRobot() {
        return robot;
    }

    public void setRobot(int robot) {
        this.robot = robot;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setBomb(int bomb) {
        this.bomb = bomb;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Property{" +
                "\n money=" + money +
                "\n point=" + point +
                "\n bomb=" + bomb +
                "\n block=" + block +
                "\n robot=" + robot +
                '}';
    }
}