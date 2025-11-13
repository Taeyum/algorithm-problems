import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] colors = {
            "black", "brown", "red", "orange", "yellow",
            "green", "blue", "violet", "grey", "white"
        };
        
        String color1 = sc.nextLine();
        String color2 = sc.nextLine();
        String color3 = sc.nextLine();
        
        long num1 = 0;
        long num2 = 0;
        long num3 = 1;
        
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color1)) {
                num1 = i;
            }
            if (colors[i].equals(color2)) {
                num2 = i;
            }
        }
        
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color3)) {
                num3 = (long) Math.pow(10, i);
            }
        }
        
        long multi = (num1 * 10) + num2;
        long result = multi * num3;
        
        System.out.println(result);
        
        sc.close();
    }
}