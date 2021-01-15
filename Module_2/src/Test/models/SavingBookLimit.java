package Test.models;

public class SavingBookLimit extends SavingBook{
    private String withDrawDate;

    public SavingBookLimit(String id, String name, String savingTime, String amount, String mountOfMoney, String gift, String withDrawDate) {
        super(id, name, savingTime, amount, mountOfMoney, gift);
        this.withDrawDate = withDrawDate;
    }

    public String getWithDrawDate() {
        return withDrawDate;
    }

    public void setWithDrawDate(String withDrawDate) {
        this.withDrawDate = withDrawDate;
    }

    public String showInfor(){
        System.out.println(this.toString());
        return toString();
    }

    @Override
    public String toString() {
        return  super.toString() +
                "SavingBookLimit{" +
                "withDrawDate='" + withDrawDate + '\'' +
                '}';
    }
}
