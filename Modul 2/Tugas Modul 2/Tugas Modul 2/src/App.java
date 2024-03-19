import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<book> booklist = new ArrayList<>();
    static ArrayList<Mahasiswa> userstudent = new ArrayList<>();
    static Scanner inputswitchcase = new Scanner(System.in);
    static Scanner inputuser = new Scanner(System.in);
    static String NIM;

    static class book {
        String id, namabuku, author, category;
        int no, stock;

        public book(int no, String id, String namabuku, String author, String category, int stock) {
            this.no = no;
            this.id = id;
            this.namabuku = namabuku;
            this.author = author;
            this.category = category;
            this.stock = stock;
        }
    }

    static class Mahasiswa {
        String nama, nim, fakultas, jurusan;

        public Mahasiswa(String nama, String nim, String fakultas, String jurusan) {
            this.nama = nama;
            this.nim = nim;
            this.fakultas = fakultas;
            this.jurusan = jurusan;
        }
    }

    static void menu() {
        int menuloop = 0;
        do {
            System.out.println("==== Library System ====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Administrator");
            System.out.println("3. Exit Program");
            System.out.print("Choose option (1-3): ");

            int pilihan = inputswitchcase.nextInt();
            switch (pilihan) {
                case 1:
                    Student.loginstudent();
                    menustudent();
                    break;

                case 2:
                    Admin.loginadmin();
                    menuadmin();
                    break;

                case 3:
                    menuloop = 1;
                    break;
            }
        } while (menuloop == 0);
    }

    static void inputNIM() {
        System.out.print("Masukkan NIM: ");
        NIM = inputuser.nextLine();
    }

    static void menuadmin() {

        System.out.println("==== Admin Menu ====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Daftar Mahasiswa");
        System.out.println("3. Tambah Buku");
        System.out.println("4. Logout From Admin");
        System.out.print("Choose option (1-3): ");

        int pilihan = inputswitchcase.nextInt();
        switch (pilihan) {
            case 1:
                Admin.addstudent();
                break;
            case 2:
                Admin.displaystudent();
                break;
            case 3:
                Admin.addbook();
                break;
            case 4:
                menu();
                break;
            default:
                System.out.print("Pilih 1-4");
                menuadmin();
        }

    }

    static void menustudent() {

        System.out.println("====== Student Menu ======");
        System.out.println("1. Daftar buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Pengembalian Buku");
        System.out.println("4. Logout From Student Menu");
        System.out.print("Choose option (1-3) : ");

        int pilihan = inputswitchcase.nextInt();
        switch (pilihan) {
            case 1:
                Student.displaybooks();
                menustudent();
                break;
            case 2:
                System.out.println("====  Pinjam Buku  ====");
                System.out.print("Masukkan id buku: ");
                String idbukudipinjam = inputuser.nextLine();
                for (App.book i : App.booklist) {
                    if (i.id.equals(idbukudipinjam)) {
                        if (i.stock > 0) {
                            i.stock--;
                            System.out.println("Buku berhasil dipinjam");
                        } else {
                            System.out.println("Stok buku habis");
                        }
                    }
                }
                menustudent();
                break;
            case 3:
                System.out.println("==== Pengembalian Buku ====");
                System.out.print("Masukkan id buku: ");
                String idbukupengembalian = inputuser.nextLine();
                for (App.book i : App.booklist) {
                    if (i.id.equals(idbukupengembalian)) {
                        if (i.stock >= 0) {
                            i.stock++;
                            System.out.println("Buku berhasil dikembalikan");
                        }
                    }
                }
                menustudent();
                break;
            case 4:
                Student.logout();

            default:
                System.out.print("Pilih 1-4");
                menustudent();
        }

    }

    public static void main(String[] args) {
        menu();
    }
}