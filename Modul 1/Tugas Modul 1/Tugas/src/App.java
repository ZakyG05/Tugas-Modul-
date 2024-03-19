import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String option;
        do {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as student");
            System.out.println("2. Login as admin");
            System.out.println("3. Exit");

            System.out.print("choose option (1-3): ");
            option = input.nextLine();

            if(option.equals("1")) {
                System.out.println("===== Library System =====");
                System.out.print("Enter your NIM: ");
                String nim = input.nextLine();
                if(nim.length() == 15 && nim.matches("\\d+")){
                    long number = Long.parseLong(nim);
                    System.out.println("successfully entered");
                } else {
                    System.out.println("user not found");
                }
            } else if(option.equals("2")) {
                System.out.println("===== Library System =====");
                System.out.print("Enter your username: ");
                String username = input.nextLine();
                System.out.print("Enter your password: ");
                String password = input.nextLine();
                if(username.equals("admin") && password.equals("admin")){
                    System.out.println("successfully entered");
                } else {
                    System.out.println("Admin user not found");
                }
            } else if(option.equals("3")){
                System.out.println("adios");
                break; // keluar dari loop
            } else {
                System.out.println("Invalid option, please choose again.");
            }
        } while (!option.equals("3")); // ulangi loop sampai pilihan adalah "3"
        
        input.close();
    }
}
