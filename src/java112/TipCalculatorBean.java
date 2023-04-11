package java112;

public class TipCalculatorBean implements java.io.Serializable {
    
    private double billAmount;
    private double tipPercentage;
    
    public TipCalculatorBean() {}
    
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
    
    public double calculateTip() {
        return billAmount * (tipPercentage / 100.0);
    }
    
}