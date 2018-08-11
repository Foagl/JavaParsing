

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    private static  Double FilterStringForNumber (Object str){
        String sum =  str.toString();
        String result = sum.replaceAll("[a-zA-Zа > < /]*", "");
        double var2 = new Double(result);
        return var2;
    }
    private static  String FilterStringForName (Object str){
        String sum =  str.toString();
        String result = sum.replaceAll("[zA-Za 0-9 t d (srongsrong)> < / ]*", "");
//        String result2 = result.replaceAll(">", "");
//        String result3 = result2.replaceAll("<", "");
//        String result4 = result3.replaceAll("/", "");
        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
            int i = 0;

            List text = new ArrayList();
            Document doc = Jsoup.connect("https://zlata.ws/kantory/").get();
            Elements elements = doc.select("td").select("td");
                //Elements Cource = doc.attr("span");
             for ( Element element: elements ){
                 text.add(element);
                 i++;
                    //System.out.println(element);
             };
                    //System.out.println(i); // - How much string on list list "text'.
//                System.out.println(FilterStringForName(text.get(135)));
//                System.out.println(FilterStringForNumber(text.get(136)));
//
//                System.out.println(FilterStringForName(text.get(138)));
//                System.out.println(FilterStringForNumber(text.get(139)));
            double operand1 = FilterStringForNumber(text.get(136)); // гривна
            double operand2 = FilterStringForNumber(text.get(139)); // Доллар
             System.out.println("Какую валюту нужно переводить?: 1. Гривна 2. Злотый 3 Доллар :");
              int select = scanner.nextInt();

                if (select == 1){
            System.out.print("Злотый к гривне > ");
            double operand3 = scanner.nextDouble();
            operand3 = operand3 * operand1;
            System.out.println("> " + operand3);
        }
             if ( select == 2 ){
                 System.out.print(" Гривна к доллару > ");
                 double operand3 = scanner.nextDouble();
                 operand3 = (operand3 * operand1) / operand2; // Расчет гривны к доллару   Sum * KursUAH / KursUSD;
                 System.out.println("> " + operand3);
             }

             if (select == 3){
                 System.out.print("Злотый к Доллару > ");
                 double operand3 = scanner.nextDouble();
                 operand3 = operand3 / operand1; // Расчет гривны к доллару   Sum * KursUAH / KursUSD;
                 System.out.println("> " + operand3);
             }







    }}







