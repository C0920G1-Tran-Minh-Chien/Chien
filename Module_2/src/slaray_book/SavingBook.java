package slaray_book;

public class SavingBook {
    private String id;
    private String name;
    private String startRentDate;
    private String endRentDate;
    private long rentTime;
    private int amount;
    private double moneyDeposits;

    public SavingBook() {
    }

    public SavingBook(String id, String name, String startRentDate, String endRentDate, long rentTime, int amount,
                      double moneyDeposits) {
        this.id = id;
        this.name = name;
        this.startRentDate = startRentDate;
        this.endRentDate = endRentDate;
        this.rentTime = rentTime;
        this.amount = amount;
        this.moneyDeposits = moneyDeposits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(String startRentDate) {
        this.startRentDate = startRentDate;
    }

    public long getRentTime() {
        return rentTime;
    }

    public void setRentTime(long rentTime) {
        this.rentTime = rentTime;
    }

    public String getEndRentDate() {
        return endRentDate;
    }

    public void setEndRentDate(String endRentDate) {
        this.endRentDate = endRentDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getMoneyDeposits() {
        return moneyDeposits;
    }

    public void setMoneyDeposits(double moneyDeposits) {
        this.moneyDeposits = moneyDeposits;
    }

    @Override
    public String toString() {
        return
                "" + id + ',' + name + ',' + startRentDate + ','
                        + endRentDate + ',' + rentTime + ',' + amount + ',' + moneyDeposits;
    }
}
