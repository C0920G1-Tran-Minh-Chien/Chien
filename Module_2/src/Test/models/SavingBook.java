package Test.models;

public abstract class SavingBook {
    private String id;
    private String name;
    private String savingTime;
    private String amountOfMoney;
    private String bonusMoney;
    private String gift;


    public SavingBook(String id, String name, String savingTime, String amount, String mountOfMoney, String gift) {
        this.id = id;
        this.name = name;
        this.savingTime = savingTime;
        this.bonusMoney = amount;
        this.amountOfMoney = mountOfMoney;
        this.gift = gift;
    }


    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getBonusMoney() {
        return bonusMoney;
    }

    public void setBonusMoney(String bonusMoney) {
        this.bonusMoney = bonusMoney;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSavingTime() {
        return savingTime;
    }

    public void setSavingTime(String savingTime) {
        this.savingTime = savingTime;
    }

    public String getAmount() {
        return bonusMoney;
    }

    public void setAmount(String amount) {
        this.bonusMoney = amount;
    }

    public String getMountOfMoney() {
        return amountOfMoney;
    }

    public void setMountOfMoney(String mountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
    public String showInfor(){
        System.out.println(this.toString());
        return toString();
    }

    @Override
    public String toString() {
        return "SavingBook{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", savingTime='" + savingTime + '\'' +
                ", amountOfMoney='" + amountOfMoney + '\'' +
                ", bonusMoney='" + bonusMoney + '\'' +
                ", gift='" + gift + '\'' +
                '}';
    }
}
