package slaray_book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagerSavingBook {
    private static List<SavingBook> arrListSavingBook = new ArrayList<>();

    public static void menu() {
        System.out.println("----------MENU----------");
        System.out.println("1. Add new saving book.");
        System.out.println("2. Show list saving book.");
        System.out.println("3. Search saving book by Id.");
        System.out.println("4. Delete saving book by Id.");
        System.out.println("5. Edit saving book by Id.");
        System.out.println("6. Exit.");
        System.out.println("Select your choice:");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                addSavingBook();
                writeFile();
                break;
            case 2:
                showSavingBook();
                break;
            case 3:
                searchSavingBookById();
                break;
            case 4:
                deleteSavingBookById();
                writeFile();
                break;
            case 5:
                editSavingBookById();
                writeFile();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("Do not have choice, select again!");
        }
    }

    public static void addSavingBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your select:");
        System.out.println("1. Add Short term saving book.");
        System.out.println("2. Add Long term saving book.");
        switch (CheckInPrimeData.checkIntPositive()) {
            case 1:
                System.out.println("Enter id saving book (STK-xxxx): ");
                String idS = UtilitiesSavingBook.checkId();
                System.out.println("Enter name customer: ");
                String nameS = CheckInStringData.checkString();
                System.out.println("Enter start rent date: ");
                String startRentDateS = RegexToString.regexDate(input.nextLine());
                String endRentDateS = UtilitiesSavingBook.isCheckTimeRent(startRentDateS);

                long millisecondsStartS = TimeToMilliseconds.dateToMilliseconds(startRentDateS);
                long millisecondsEndS = TimeToMilliseconds.dateToMilliseconds(endRentDateS);
                long millisecondsRentTimeS = millisecondsEndS - millisecondsStartS;
                long rentTimeS = millisecondsRentTimeS / (1000 * 60 * 60 * 24);

                System.out.println("Enter amount: ");
                int amountS = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter money deposit (min 1.000.000 VND): ");
                double moneyDepositsS = CheckInPrimeData.checkDoubleMinOneMillion();

                SavingBook shortTermBook = new ShortTermBook(idS, nameS, startRentDateS, endRentDateS, rentTimeS,
                        amountS, moneyDepositsS);
                arrListSavingBook.add(shortTermBook);
                break;
            case 2:
                System.out.println("Enter id saving book (STK-xxxx): ");
                String idL = UtilitiesSavingBook.checkId();
                System.out.println("Enter name customer: ");
                String nameL = CheckInStringData.checkString();
                System.out.println("Enter start rent date: ");
                String startRentDateL = RegexToString.regexDate(input.nextLine());
                String endRentDateL = UtilitiesSavingBook.isCheckTimeRent(startRentDateL);

                long millisecondsStartL = TimeToMilliseconds.dateToMilliseconds(startRentDateL);
                long millisecondsEndL = TimeToMilliseconds.dateToMilliseconds(endRentDateL);
                long millisecondsRentTimeL = millisecondsEndL - millisecondsStartL;
                long rentTimeL = millisecondsRentTimeL / (1000 * 60 * 60 * 24);


                System.out.println("Enter amount: ");
                int amountL = CheckInPrimeData.checkIntPositive();
                System.out.println("Enter money deposit (min 1.000.000 VND): ");
                double moneyDepositsL = CheckInPrimeData.checkDoubleMinOneMillion();
                System.out.println("Enter gift: ");
                String gift = CheckInStringData.checkString();
                SavingBook longTermBook = new LongTermBook(idL, nameL, startRentDateL, endRentDateL, rentTimeL,
                        amountL, moneyDepositsL, gift);
                arrListSavingBook.add(longTermBook);
                break;
            default:
                System.out.println("Enter your select again");
                addSavingBook();
        }
    }

    public static void showSavingBook() {
        for (SavingBook savingBook : arrListSavingBook) {
            System.out.println(savingBook.toString());
        }
    }

    public static void searchSavingBookById() {
        System.out.println("Input id saving book (STK-xxxx) want to search: ");
        String id = UtilitiesSavingBook.checkId();
        boolean checkFind = false;
        for (SavingBook savingBook : arrListSavingBook) {
            if (id.equals(savingBook.getId())) {
                System.out.println(savingBook.toString());
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find saving book!");
        }
    }

    public static void deleteSavingBookById() {
        System.out.println("Enter id saving book (STK-xxxx) want to delete: ");
        String id = UtilitiesSavingBook.checkId();
        boolean checkFind = false;
        int d = -1;
        for (int i = 0; i < arrListSavingBook.size(); i++) {
            if (id.equals(arrListSavingBook.get(i).getId())) {
                checkFind = true;
                d = i;
                break;
            }
        }
        if (checkFind) {
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("Enter your select: ");
            int choice = CheckInPrimeData.checkIntPositive();
            if (choice == 1) {
                arrListSavingBook.remove(d);
                showSavingBook();
                writeFile();
            } else if (choice == 2) {
                showSavingBook();
            } else {
                System.out.println("Do not choice");
                deleteSavingBookById();
            }
        } else {
            System.out.println("DO NOT find saving book!");
            deleteSavingBookById();
        }
    }

    public static void editSavingBookById() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input id saving book (STK-xxxx) want to edit: ");
        String id = UtilitiesSavingBook.checkId();
        boolean checkFind = false;
        for (int i = 0; i < arrListSavingBook.size(); i++) {
            if (id.equals(arrListSavingBook.get(i).getId())) {
                if (checkAmountProperties(i) == 7){
                    System.out.println("Enter id saving book (STK-xxxx): ");
                    String idS = UtilitiesSavingBook.checkId();
                    System.out.println("Enter name customer: ");
                    String nameS = CheckInStringData.checkString();
                    System.out.println("Enter start rent date: ");
                    String startRentDateS = RegexToString.regexDate(input.nextLine());
                    String endRentDateS = UtilitiesSavingBook.isCheckTimeRent(startRentDateS);

                    long millisecondsStartS = TimeToMilliseconds.dateToMilliseconds(startRentDateS);
                    long millisecondsEndS = TimeToMilliseconds.dateToMilliseconds(endRentDateS);
                    long millisecondsRentTimeS = millisecondsEndS - millisecondsStartS;
                    long rentTimeS = millisecondsRentTimeS / (1000 * 60 * 60 * 24);

                    System.out.println("Enter amount: ");
                    int amountS = CheckInPrimeData.checkIntPositive();
                    System.out.println("Enter money deposit (min 1.000.000 VND): ");
                    double moneyDepositsS = CheckInPrimeData.checkDoubleMinOneMillion();

                    arrListSavingBook.get(i).setId(idS);
                    arrListSavingBook.get(i).setName(nameS);
                    arrListSavingBook.get(i).setStartRentDate(startRentDateS);
                    arrListSavingBook.get(i).setEndRentDate(endRentDateS);
                    arrListSavingBook.get(i).setRentTime(rentTimeS);
                    arrListSavingBook.get(i).setAmount(amountS);
                    arrListSavingBook.get(i).setMoneyDeposits(moneyDepositsS);
                }
                else if (checkAmountProperties(i) == 8){
                    System.out.println("Enter id saving book (STK-xxxx): ");
                    String idL = UtilitiesSavingBook.checkId();
                    System.out.println("Enter name customer: ");
                    String nameL = CheckInStringData.checkString();
                    System.out.println("Enter start rent date: ");
                    String startRentDateL = RegexToString.regexDate(input.nextLine());
                    String endRentDateL = UtilitiesSavingBook.isCheckTimeRent(startRentDateL);

                    long millisecondsStartL = TimeToMilliseconds.dateToMilliseconds(startRentDateL);
                    long millisecondsEndL = TimeToMilliseconds.dateToMilliseconds(endRentDateL);
                    long millisecondsRentTimeL = millisecondsEndL - millisecondsStartL;
                    long rentTimeL = millisecondsRentTimeL / (1000 * 60 * 60 * 24);


                    System.out.println("Enter amount: ");
                    int amountL = CheckInPrimeData.checkIntPositive();
                    System.out.println("Enter money deposit (min 1.000.000 VND): ");
                    double moneyDepositsL = CheckInPrimeData.checkDoubleMinOneMillion();
                    System.out.println("Enter gift: ");
                    String gift = CheckInStringData.checkString();

                    arrListSavingBook.get(i).setId(idL);
                    arrListSavingBook.get(i).setName(nameL);
                    arrListSavingBook.get(i).setStartRentDate(startRentDateL);
                    arrListSavingBook.get(i).setEndRentDate(endRentDateL);
                    arrListSavingBook.get(i).setRentTime(rentTimeL);
                    arrListSavingBook.get(i).setAmount(amountL);
                    arrListSavingBook.get(i).setMoneyDeposits(moneyDepositsL);
                    //arrListSavingBook.get(i).setGift(gift);

                }
                checkFind = true;
                break;
            }
        }
        if (!checkFind) {
            System.out.println("Do NOT find saving book!");
        }
    }

    public static int checkAmountProperties(int index){
        List<String> arrListStr = Arrays.asList(arrListSavingBook.get(index).toString().split(","));
        return arrListStr.size();
    }

    public static void readFile() {
        List<String> arrListStr = null;
        try {
            arrListStr = FileUtilities.readFileAsListOfStrings("src/slaray_book/SavingBooking.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert arrListStr != null;
        for (String str : arrListStr) {
            List<String> arrStr = new ArrayList<>();
            arrStr = Arrays.asList(str.split(","));
            if (arrStr.size() == 8) {
                SavingBook longTermBook = new LongTermBook(arrStr.get(0), arrStr.get(1), arrStr.get(2), arrStr.get(3),
                        Long.parseLong(arrStr.get(4)), Integer.parseInt(arrStr.get(5)),
                        Double.parseDouble(arrStr.get(6)), arrStr.get(7));
                arrListSavingBook.add(longTermBook);

            } else {
                SavingBook shortTermBook = new ShortTermBook(arrStr.get(0), arrStr.get(1), arrStr.get(2), arrStr.get(3),
                        Long.parseLong(arrStr.get(4)), Integer.parseInt(arrStr.get(5)),
                        Double.parseDouble(arrStr.get(6)));
                arrListSavingBook.add(shortTermBook);
            }
        }
    }

    public static void writeFile() {
        File file = new File("src/slaray_book/SavingBooking.csv");
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (SavingBook savingBook : arrListSavingBook) {
            try {
                assert  out != null;
                out.write(savingBook.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            assert out != null;
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
