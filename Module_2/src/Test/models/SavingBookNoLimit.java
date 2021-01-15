package Test.models;

public class SavingBookNoLimit extends SavingBook {

    public SavingBookNoLimit(String id, String name, String savingTime, String amount, String mountOfMoney, String gift) {
        super(id, name, savingTime, amount, mountOfMoney, gift);
    }
    public String showInfor(){
        System.out.println(this.toString());
        return toString();
    }
    @Override
    public String toString() {
        return "SavingBookNoLimit{}";
    }
}
