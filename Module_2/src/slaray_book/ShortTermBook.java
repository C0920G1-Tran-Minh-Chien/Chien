package slaray_book;

public class ShortTermBook extends SavingBook {
    public ShortTermBook() {
    }

    public ShortTermBook(String id, String name, String startRentDate, String endRentDate, long rentTime, int amount, double moneyDeposits) {
        super(id, name, startRentDate, endRentDate, rentTime, amount, moneyDeposits);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
