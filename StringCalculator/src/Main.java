import java.util.Scanner;

public class Main {
    private static String operation = null;
    private static String[] data = new String[0];
    public static void main(String[] args) {
        operationSign();
        delQ();
        exceptions();

        if (operation == "+"){
            String result = (data[0] + data[1]);
            System.out.println("\""+result+"\"");

            }

        else if (operation == "-"){
            int index = data[0].indexOf(data[1]);
            if (index == -1){
                System.out.println("\""+data[0]+"\"");
            }
            else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                System.out.println("\""+result+"\"");
            }
        }

        else if (operation == "*"){
            int multiply = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiply; i++){
                result += data[0];
            }
            //проверка длины результата
            if (result.length() > 40){
                result = result.substring(0, 40) + "...";
                System.out.println(result);
            }
            else {
                System.out.println("\""+result+"\"");
            }
        }

        else if (operation == "/"){
            int division = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, division);
            System.out.println("\""+result+"\"");
        }

    }

    public static void delQ(){
        for (int i = 0; i<data.length; i++){
            data[i] = data[i].replace("\"", "");
        }

    }

    public static void operationSign(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace(" ","");
        if (input.contains("+")){
            data = input.split("\\+");
            operation = "+";
        }
        else if (input.contains("-")){
            data = input.split("-");
            operation = "-";
        }
        else if (input.contains("/")){
            data = input.split("/");
            operation = "/";
        }
        else if (input.contains("*")){
            data = input.split("\\*");
            operation = "*";
        }
        else try {
                throw new Exception("Вы ввели недопустимый знак арифметической операции");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public static void exceptions(){

        if (data[0].length() > 10 || data[1].length() > 10 ) try{
            throw new Exception("Длина строки должна быть не более 10");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if ((data[0].contains("\""))) try {
            throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(operation == "*" || operation == "/"){
            if (data[0].contains("\"")) {
                if (data[1].contains("\"")) try {
                    throw new Exception("Строку можно умножать или делить только на число");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (Integer.parseInt(data[1]) > 10)try {
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        else if(operation == "+" || operation == "-"){
            if (!(data[1].contains("\""))) try {
                throw new Exception("Нельзя вычесть или прибавить число к строке");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}