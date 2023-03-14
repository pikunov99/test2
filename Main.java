import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] znac = {"+", "-", "/", "*"};
        String[] znacraz = {"\\+", "-", "/", "\\*"};
        if (input.contains("+") || input.contains("-") || input.contains("/") || input.contains("*")) {
            int ogh = 1;
        } else {
            throw new Exception("это не знак действия");
        }
        int index = -1;
        for (int i = 0; i <= znac.length; i++) {
            if (input.contains(znac[i])) {
                index = i;
                break;
            }
        }
        String[] xy = input.split(" " + znacraz[index] + " ");
        String x = xy[0];
        String y = xy[1];
        String v = x.replaceAll("\"", "");
        String l = y.replaceAll("\"", "");
        String vpn = v.replaceAll("\"", "");
        String gg = l.replaceAll("\"", "");

        if (y.contains("\"")) {
            int ttt = 5;
        } else {
            if (Integer.parseInt(y) > 10 || Integer.parseInt(y) < 1) {
                throw new Exception("втрая неизвестная должна быть больше 0 и меньше 11");
            }
        }

        if (input.contains(znac[2]) || input.contains(znac[3]) || input.contains(znac[0]) || input.contains(znac[1])) {

            if (x.contains("\"")) {
                int sew = 1;
            } else {
                throw new Exception("первая неизвестная должна быть строкой с кавычками");
            }
        }
        if (vpn.length() <= 10 && gg.length() <= 10) {
            int t = 1;
        } else {
            throw new Exception("строка должна быть размером менее 11ти символов");
        }
        if(input.contains(znac[0])){
            getPlus(index,x, y,xy);
        }

        if(input.contains(znac[1])){
            getMinus(x,y, index,vpn);
        }

        if (input.contains(znac[2])){
            getDelenie(index, y, vpn, gg);
        }
        if(input.contains(znac[3])){
            getUmnozhenie(index,y,x);
        }
    }
    static void getMinus(String x, String y, int index, String vpn) throws Exception {
        if (index == 1) {
            if (x.contains("\"") && y.contains("\"")) {
                String v = x.replaceAll("\"", "");
                String l = y.replaceAll("\"", "");
                vpn = v.replaceAll("\"", "");
                String gg = l.replaceAll("\"", "");
                if (vpn.contains(gg)) {
                    int num= vpn.indexOf(gg);
                    int mut= num+ gg.length();
                    String itog=vpn.substring(0,num);
                    String mmm= vpn.substring(num+gg.length(),vpn.length());
                    String jopr=itog+mmm;
                    System.out.println("\""+jopr+"\"");
                } else {
                    System.out.println("\""+vpn+"\"");
                }
            } else {
                throw new Exception("вычитать можно только строки со строками");
            }
        }

    }
    static void getPlus(int index,String x,String y,String xy[])throws Exception{
        if (index == 0) {
            if (x.contains("\"") && y.contains("\"")) {
                x = xy[0];
                y = xy[1];
                String pop = x.replaceAll("\"", "");
                String job = y.replaceAll("\"", "");
                System.out.println("\"" + pop + job + "\"");
            } else {
                throw new Exception("сложение происходит только между строками");
            }
        }
    }
    static void getDelenie(int index, String y, String vpn,String gg)throws Exception{
        if (index==2) {
            if (y.contains("\"")) {
                throw new Exception("число должно вводиться без ковычек");
            }
            String dom = vpn.replaceAll("\"", "");
            int a = dom.length();
            int b = Integer.parseInt(gg);
            String e = dom.substring(0, a / b);
            System.out.println("\"" + e + "\"");
        }}

    static void getUmnozhenie(int index,String y, String x)throws Exception{
        String result = "";
        String tre = "";
        if (index == 3) {
            if (y.contains("\"")) {
                throw new Exception("число должно вводиться без ковычек");
            }
            for (int m = 0; m < Integer.parseInt(y); m++) {
                result += x;
                tre = result.replaceAll("\"", "");
            }
            if (tre.length() <= 40) {
                System.out.println("\"" + tre + "\"");
            }
            if (tre.length() > 40) {
                String s = tre.substring(0, 40);
                System.out.println("\"" + s + "..." + "\"");
            }
        }
    }

}





