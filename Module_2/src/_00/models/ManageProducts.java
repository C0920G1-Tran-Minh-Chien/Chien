package _00.models;

import _00.Main.Main;
import _00.common.ReadAndWriteFile;
import _00.controller.MainController;
import _00.validate.Validate;
import java.util.ArrayList;
import java.util.List;
public class ManageProducts {
    public  static final String REGEX_INT = "[1-9][0-9]|[0-9]+([.][0-9]+)*";
    public  static final String REGEX_INPUT_ID = "([\\w][\\w]*[ ])*([\\w][\\w]*)";
    public  static final String REGEX_PRODUCER = "[A-Z][a-z]+([ ][A-Z][a-z]+)*";
    public  static final String NAME_ERROR = "Enter the wrong format, please enter again!";
    public  static final String INT_ERROR = "Enter the wrong number format, please enter again!";
    private static List<Products> productsList = new ArrayList<>();
    private static  final String P = ",";

    public void addNewProducts(){
        List<Products> newlist = read();
        int id = 1;
        if (newlist.size()!= 0){
            id = newlist.get(newlist.size()-1).getId()+1;
        }
        System.out.println("Customer Id = " + id);
        String idProduct = inputIdProduct();
        String nameProduct = inputNameProduct();
        String priceProduct = inputPriceProduct();
        String amountProduct = inputAmountProduct();
        String producer = inputProducerProduct();
        boolean check = true;
        do {
            System.out.println("Select Product Type."+
                    "\n 1.Import"+
                    "\n 2.Export");

            switch (Main.enter().nextInt()){
                case 1: {
                    String priceImport = inputPriceImport();
                    String placeImport = inputPlaceOfImport();
                    String tax = inputImportTax();
                    ImportProducts products1 = new ImportProducts(id, idProduct, nameProduct, priceProduct,
                            amountProduct, producer, priceImport, placeImport, tax);
                    productsList.add(products1);
                    String line =   products1.getId() + P +
                                    products1.getIdProduct() + P +
                                    products1.getProductName() + P +
                                    products1.getProductPrice() + P +
                                    products1.getProductAmount() + P +
                                    products1.getProducer() + P +
                                    products1.getImportPrice() + P +
                                    products1.getPlaceOfImport() + P +
                                    products1.getImportTax();
                    ReadAndWriteFile.writeFile("src/_00/data/products.csv", line);
                    check = false;
                    break;
                }
                case 2: {
                    String priceExport = inputPriceExport();
                    String placeExport = inputPlaceOfExport();
                    ExportProducts products1 = new ExportProducts(id, idProduct, nameProduct, priceProduct,
                            amountProduct, producer, priceExport, placeExport);
                    productsList.add(products1);
                    String line =   products1.getId() + P +
                                    products1.getIdProduct() + P +
                                    products1.getProductName() + P +
                                    products1.getProductPrice() + P +
                                    products1.getProductAmount() + P +
                                    products1.getProducer() + P +
                                    products1.getPriceExport() + P +
                                    products1.getPlaceOfExport();
                    ReadAndWriteFile.writeFile("src/_00/data/products.csv", line);
                    check = false;
                    break;
                }
            }
        } while (check);
        MainController.displayMenu();
    }

    public static List<Products> read(){
        List<String[]> list = ReadAndWriteFile.readFile("src/_00/data/products.csv");
        productsList.clear();
        for (String[] s: list){
            if (s.length == 0){
                System.out.println("Empty!");
            } else if (s.length == 9){
                ImportProducts importProducts = new ImportProducts(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4],
                        s[5], s[6], s[7], s[8]);
                productsList.add(importProducts);
            } else if (s.length == 8){
                ExportProducts exportProducts = new ExportProducts(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4],
                        s[5], s[6], s[7]);
                productsList.add(exportProducts);
            }
        }
        return productsList;
    }

    public void writeNew(){
        for (Products products1 : productsList){
            if (products1 instanceof ImportProducts){
                String line = products1.getId() + P +
                        products1.getIdProduct() + P +
                        products1.getProductName() + P +
                        products1.getProductPrice() + P +
                        products1.getProductAmount() + P +
                        products1.getProducer() + P +
                        ((ImportProducts) products1).getImportPrice() + P +
                        ((ImportProducts) products1).getPlaceOfImport() + P +
                        ((ImportProducts) products1).getImportTax();
                ReadAndWriteFile.writeFile("src/_00/data/products.csv", line);
            } else if (products1 instanceof ExportProducts){
                String line = products1.getId() + P +
                        products1.getIdProduct() + P +
                        products1.getProductName() + P +
                        products1.getProductPrice() + P +
                        products1.getProductAmount() + P +
                        products1.getProducer() + P +
                        ((ExportProducts) products1).getPriceExport() + P +
                        ((ExportProducts) products1).getPlaceOfExport();
                ReadAndWriteFile.writeFile("src/_00/data/products.csv", line);
            }
        }
    }
    public void edit(){
        boolean check = true;
        System.out.println("Enter Id want edit!");
        String temp = Main.enter().nextLine();
        if (productsList.isEmpty()){
            System.out.println("Out of Products");
        } else {
            for (int i = 0; i < productsList.size(); i++){
                if (temp.equals(productsList.get(i).getIdProduct())){
                    productsList.get(i).setProductName(inputNameProduct());
                    ReadAndWriteFile.removeFile("src/_00/data/products.csv");
                    writeNew();
                    check = false;
                }
            } if (check){
                System.out.println("Not Found");
            }
        }
    }
    public void removeProducts(){
        System.out.println("Enter Id Products want remove.");
        String temp = Main.enter().nextLine();
        if (productsList.isEmpty()){
            System.out.println("Out of Products");
        } else {
            for (int i = 0; i < productsList.size(); i++){
                if (temp.equals(productsList.get(i).getIdProduct())){
                    System.out.println("You really want to remove?"+
                        "\n1. Yes" +
                        "\n2. No");
                    switch (Main.enter().nextInt()){
                        case 1: {
                            productsList.remove(productsList.get(i));
                            ReadAndWriteFile.removeFile("src/_00/data/products.csv");
                            writeNew();
                            displayProducts();
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

    public void searchProducts(){
        boolean check = true;
        System.out.println("1. Search by Id" +
                "\n2. Search by Name");
        switch (Main.enter().nextLine()){
            case "1": {
                System.out.println("Enter Id");
                String valueID = Main.enter().nextLine();
                if (productsList.isEmpty()){
                    System.out.println("Out of Products");
                    break;
                }
                for (Products products : productsList){
                    if (products.getIdProduct().toLowerCase().contains(valueID.toLowerCase())){
                        check = false;
                        products.showInfor();
                    }
                } if (check){
                    System.out.println("Not Found.");
                }
                break;
            }
            case "2": {
                System.out.println("Enter Name");
                String valueName = Main.enter().nextLine();
                if (productsList.isEmpty()){
                    System.out.println("Out of Products");
                    break;
                }
                for (Products products : productsList){
                    if (products.getProductName().toLowerCase().contains(valueName.toLowerCase())){
                        check = false;
                        products.showInfor();
                    }
                } if (check){
                    System.out.println("Not Found.");
                }
                break;
            }
        }

    }
    public void displayProducts(){
        read();
        System.out.println("-------------------");
        for (Products products : productsList){
            products.showInfor();
        }
    }

    private String inputIdProduct(){
        System.out.println("Enter Id Products.");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INPUT_ID,NAME_ERROR);
    }
    private String inputNameProduct(){
        System.out.println("Enter Name Products.");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INPUT_ID,NAME_ERROR);
    }
    private String inputPriceProduct(){
        System.out.println("Enter Price Products.");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INT,INT_ERROR);
    }
    private String inputAmountProduct(){
        System.out.println("Enter Amount Products.");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INT,INT_ERROR);
    }
    private String inputProducerProduct(){
        System.out.println("Enter Products Producer.");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INPUT_ID,NAME_ERROR);
    }
    private String inputPriceImport(){
        System.out.println("Enter Import Price");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INT,INT_ERROR);
    }
    private String inputPriceExport(){
        System.out.println("Enter Export Price");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INT,INT_ERROR);
    }
    private String inputPlaceOfImport(){
        System.out.println("Enter Place Import");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_PRODUCER,NAME_ERROR);
    }
    private String inputPlaceOfExport(){
        System.out.println("Enter Place Export");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_PRODUCER,NAME_ERROR);
    }
    private String inputImportTax(){
        System.out.println("Enter Import Tax");
        return Validate.regexStr(Main.enter().nextLine(),REGEX_INT,INT_ERROR);
    }
}
