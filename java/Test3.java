import java.util.Scanner;
public class Test3 {
    public static void main(final String args[]) {
        String str;
        char ch1, ch2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        str = sc.nextLine();
        System.out.println("Enter the charector: ");
        ch1 = sc.next().charAt(0);
        ch2 = sc.next().charAt(0);
        final int ch1Pos = str.indexOf(ch1), ch2Pos = str.indexOf(ch2);
        System.out.println(str);
        System.out.println(ch1);
        System.out.println(ch2);
        if(ch1Pos > -1){
            if(ch2Pos > -1){
                System.out.println("Alphabets present");
                if(ch2Pos > ch1Pos)
                    System.out.println("First " + ch1 + " then " + ch2);
                else
                 System.out.println("First " + ch2 + " then " + ch1);
            }else {
                System.out.println("Only one alphabet present");
                System.out.println("First " + ch1);
            }
        }else if(ch2Pos > -1){
            System.out.println("Only one alphabet present");
            System.out.println("First " + ch2);
        }else {
            System.out.println("Sorry the alphabets not present in string.");
        }
        sc.close();
    }
}