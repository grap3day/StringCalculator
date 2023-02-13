import java.util.Scanner;

public class Main {
    public static String operation = null;
    public static String[] data = new String[0];
    public static void main(String[] args) {
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

        String a = data[0];
        String b = data[1];

        exceptions(a, b);

        a = a.replace("\"", "");
        b = b.replace("\"", "");

        calc(a, b);


    }
    public static void exceptions(String a, String b){

        if (a.length() > 10 || b.length() > 10 ) try{
            throw new Exception("Длина строки должна быть не более 10");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!(a.contains("\""))) try {
            throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(operation == "*" || operation == "/"){
            if (a.contains("\"")) {
                if (b.contains("\"")) try {
                    throw new Exception("Строку можно умножать или делить только на число");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (Integer.parseInt(b) > 10)try {
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        else if(operation == "+" || operation == "-"){
            if (!(b.contains("\"")) & (a.contains("\""))) try {
                throw new Exception("Нельзя вычесть или прибавить число к строке");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void calc(String a, String b) {
        if (operation == "+"){
            String result = (a + b);
            System.out.println("\""+result+"\"");

        }
        else if (operation == "-") {
            int index = a.indexOf(b);
            if (index == -1) {
                System.out.println("\"" + a + "\"");
            } else {
                String result = a.substring(0, index);
                result += a.substring(index + b.length());
                System.out.println("\"" + result + "\"");
            }
        } else if (operation == "*") {
            int multiply = Integer.parseInt(b);
            String result = "";
            for (int i = 0; i < multiply; i++) {
                result += a;
            }
            //проверка длины результата
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
                System.out.println(result);
            } else {
                System.out.println("\"" + result + "\"");
            }
        } else if (operation == "/") {
            int division = a.length() / Integer.parseInt(b);
            String result = a.substring(0, division);
            System.out.println("\"" + result + "\"");
        }
    }

}