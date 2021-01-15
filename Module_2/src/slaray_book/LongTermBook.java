package slaray_book;

public class LongTermBook extends SavingBook {
    private String gift;

    public LongTermBook() {
    }

    public LongTermBook(String id, String name, String startRentDate, String endRentDate, long rentTime, int amount, double moneyDeposits, String gift) {
        super(id, name, startRentDate, endRentDate, rentTime, amount, moneyDeposits);
        this.gift = gift;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return super.toString() + ',' + gift;
    }
}
