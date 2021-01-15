package Test.models;
import Test.common.ReadAndWriteFile;
import Test.validate.Validate;
import Test.view.Main;
import _00.controller.MainController;

import java.util.ArrayList;
import java.util.List;

public class ManageSavingBook {
    public  static final String REGEX_MONEY = "[1-9]+[0-9][0-9][0-9][0-9][0-9][0-9]+";
    public  static final String REGEX_ID = "(STK-)[0-9]+";
    public  static final String REGEX_INPUT_DATE = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)\n";

    public  static final String STR_ERROR = "Enter the wrong format, please enter again!";
    public  static final String INT_ERROR = "Enter the wrong number format, please enter again!";
    public  static final String COMMA = ",";
    private static List<SavingBook> savingBookList = new ArrayList<>();

    public static void addNewSavingBook(){
        boolean temp = true;
        String id = inputId();
        String name = inputName();
        String savingTime = inputSavingTime();
        String amountOfMoney = inputAmountOfMoney();
        String bonusMoney = inputBonusMoney();
        String gift = inputGift();
        boolean check = true;
        do {
            System.out.println("Select SavingBook Type."+
                    "\n 1.NoLimit"+
                    "\n 2.Limit");
            switch (Main.enter().nextLine()){
                case "1":{
                    SavingBookNoLimit savingBookNoLimit = new SavingBookNoLimit(id,name,savingTime,amountOfMoney,bonusMoney,gift);
                    savingBookList.add(savingBookNoLimit);
                    String line = savingBookNoLimit.getId() + COMMA + savingBookNoLimit.getName() + COMMA +
                            savingBookNoLimit.getSavingTime() + COMMA + savingBookNoLimit.getAmountOfMoney() +
                            COMMA + savingBookNoLimit.getBonusMoney() + COMMA + savingBookNoLimit.getGift();
                    ReadAndWriteFile.writeFile("src/Test/data/saving_book.csv", line);
                    check = false;
                    break;
                }
                case "2":{

                    String withDrawDate = withDrawDate();
                    do {
                        if (soSanh(savingTime,withDrawDate)){
                            System.out.println("Sai!");
                            savingTime = withDrawDate();
                        } else {
                            SavingBookLimit savingBookLimit = new SavingBookLimit(id,name,savingTime,amountOfMoney,bonusMoney,gift,withDrawDate);
                            savingBookList.add(savingBookLimit);
                            String line = savingBookLimit.getId() + COMMA + savingBookLimit.getName() + COMMA +
                                    savingBookLimit.getSavingTime() + COMMA + savingBookLimit.getAmountOfMoney() +
                                    COMMA + savingBookLimit.getBonusMoney() + COMMA + savingBookLimit.getGift() + COMMA +
                                    savingBookLimit.getWithDrawDate();
                            ReadAndWriteFile.writeFile("src/Test/data/saving_book.csv", line);
                            check = false;
                            break;
                        }
                    }while (check);
                }
            }
        } while (check);
    }
    public static List<SavingBook> read(){
        List<String[]> list = ReadAndWriteFile.readFile("src/Test/data/saving_book.csv");
        savingBookList.clear();
        for (String[] s: list){
            if (s.length == 0){
                System.out.println("Empty!");
            } else if (s.length == 7){
                SavingBookLimit savingBookLimit = new SavingBookLimit(s[0], s[1], s[2], s[3], s[4],
                        s[5], s[6]);
                savingBookList.add(savingBookLimit);
            } else if (s.length == 6){
                SavingBookNoLimit savingBookNoLimit = new SavingBookNoLimit(s[0], s[1], s[2], s[3], s[4],
                        s[5]);
                savingBookList.add(savingBookNoLimit);
            }
        }
        return savingBookList;
    }
    public static void writeNew(){
        for (SavingBook savingBook : savingBookList){
            if (savingBook instanceof SavingBookNoLimit){
                String line = savingBook.getId() + COMMA + savingBook.getName() + COMMA +
                        savingBook.getSavingTime() + COMMA + savingBook.getAmountOfMoney() +
                        COMMA + savingBook.getBonusMoney() + COMMA + savingBook.getGift();
                ReadAndWriteFile.writeFile("src/Test/data/saving_book.csv", line);
            } else if (savingBook instanceof SavingBookLimit){
                String line = savingBook.getId() + COMMA + savingBook.getName() + COMMA +
                        savingBook.getSavingTime() + COMMA + savingBook.getAmountOfMoney() +
                        COMMA + savingBook.getBonusMoney() + COMMA + savingBook.getGift() + COMMA +
                        ((SavingBookLimit) savingBook).getWithDrawDate();
                _00.common.ReadAndWriteFile.writeFile("src/Test/data/saving_book.csv", line);
            }
        }
    }
    public static void searchSavingBook(){
        read();
        boolean check = true;
            System.out.println(" Search by Id");
                String valueID = Main.enter().nextLine();
                if (savingBookList.isEmpty()){
                    System.out.println("Out of Products");
                } else {
                        for (SavingBook savingBook : savingBookList){
                            if (savingBook.getId().equals(valueID)){
                                    check = false;
                                    savingBook.showInfor();
                             }
                         }
                }if (check){
                    System.err.println("Not Found.");
                }
    }

    public static void remove(){
        read();
        System.out.println("Enter Id Products want remove.");
        String temp = Main.enter().nextLine();
        if (savingBookList.isEmpty()){
            System.out.println("Out of Products");
        } else {
            for (int i = 0; i < savingBookList.size(); i++){
                if (temp.equals(savingBookList.get(i).getId())){
                    System.out.println("You really want to remove?"+
                            "\n1. Yes" +
                            "\n2. No");
                    switch (Main.enter().nextInt()){
                        case 1: {
                            savingBookList.remove(savingBookList.get(i));
                            ReadAndWriteFile.removeFile("src/Test/data/saving_book.csv");
                            writeNew();
                            display();
                            break;
                        }
                        case 2: {
                            MainController.displayMenu();
                            break;
                        }
                    }
                }
            }
        }
    }
    public static boolean soSanh(String before, String after){
        boolean check = false;
        String[] element1 = before.split("/");
        String[] element2 = after.split("/");
        for (int i = 2; i >= 0; i--){
            if (Integer.parseInt(element1[i]) > Integer.parseInt(element2[i])){
                check = true;
                break;
            }
        }
        return check;
    }

    public static void display(){
        read();
        System.out.println("-------------------");
        for (SavingBook s : savingBookList){
            s.showInfor();
        }
    }
    private static String inputId(){
        System.out.println("Nhập Id Sổ: ");
        return Validate.regexStr(Main.enter().nextLine(), REGEX_ID, STR_ERROR);
    }
    private static String inputName(){
        System.out.println("Nhập Mã khách hàng: ");
        return Main.enter().nextLine();
    }
    private static String inputSavingTime(){
        System.out.println("Nhập ngày gửi : ");
        return Validate.regexStr(Main.enter().nextLine(), REGEX_INPUT_DATE, STR_ERROR);
    }
    private static String inputAmountOfMoney(){
        System.out.println("Nhập số tiền : ");
        return Validate.regexStr(Main.enter().nextLine(), REGEX_MONEY, STR_ERROR);

    }
    private static String inputBonusMoney(){
        System.out.println("Nhập số lãi suất : ");
        return Main.enter().nextLine();
    }
    private static String inputGift(){
        System.out.println("Nhập ưu đãi : ");
        return Main.enter().nextLine();
    }
    private static String withDrawDate(){
        System.out.println("Nhập ngày rút : ");
        return Validate.regexStr(Main.enter().nextLine(), REGEX_INPUT_DATE, STR_ERROR);
    }

}
