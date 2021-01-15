package CaseStudy.sort;

import CaseStudy.models.Customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

public class AgeComparator implements Comparator<Customers> {
    @Override
    public int compare(Customers o1, Customers o2) {
        if(o1.getNameCustomer().equals(o2.getNameCustomer())){
            SimpleDateFormat f =new SimpleDateFormat("dd/MM/yyyy");
            Date date1=null;
            Date date2=null;
            try {
                date1= f.parse(o1.getBirthday());
                date2= f.parse(o2.getBirthday());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1.compareTo(date2)==0){
                return o1.getNameCustomer().compareTo(o2.getNameCustomer());
            }else {
                return date1.compareTo(date2);
            }
        }
        return o1.getNameCustomer().compareTo(o2.getNameCustomer());
    }
}
