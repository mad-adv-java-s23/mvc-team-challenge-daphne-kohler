package java112;

public class TipCalculatorBean {
    private double billAmount;
    private double tipPercentage;


    public TipCalculatorBean() {
        this.billAmount = 0.0;
        this.tipPercentage = 0.0;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public double getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(double tipPercentage) {
        this.tipPercentage = tipPercentage;
    }
}
