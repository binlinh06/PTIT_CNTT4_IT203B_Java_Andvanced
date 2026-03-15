package session06.demo;

public class DataShare {
    private int number;
    private int control = 1;

    public DataShare(){}
    public DataShare(int number,int control) {
        this.number = number;
        this.control = control;
    }

    public int getControl() {
        return control;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setControl(int control) {
        this.control = control;
    }
}
