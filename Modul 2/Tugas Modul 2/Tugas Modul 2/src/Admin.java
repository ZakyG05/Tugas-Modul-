
import java.util.Scanner;

public class Admin {
    static String adminusername = "admin", adminpassword = "admin";
    static Scanner inputuser = new Scanner(System.in);

    static void loginadmin() {
        int adminloop;
        do {
            System.out.println("\n==== Login ====");
            System.out.print("Masukkan Username  : ");
            String username = inputuser.nextLine();

            System.out.print("Massukkan password : ");
            String password = inputuser.nextLine();

            if (username.equals(Admin.adminusername) && password.equals(Admin.adminpassword)) {
                System.out.println("==== Login berhasil ====\n");
                adminloop = 1;
            } else {
                System.out.println("==== Pengguna tidak ditemukan ====");
                adminloop = 0;
            }
        } while (adminloop == 0);
    }

    static void displaystudent() {
        System.out.println("\n==== Daftar Mahasiswa ====");
        for (App.Mahasiswa i : App.userstudent) {
            System.out.println("Nama     : " + i.nama);
            System.out.println("NIM      : " + i.nim);
            System.out.println("Fakultas : " + i.fakultas);
            System.out.println("Prodi    : " + i.jurusan);
            System.out.print("==============================\n\n");

        }
        App.menuadmin();
    }

    static void addstudent() {
        int loop;
        System.out.println("==== Tambah Mahasiswa ====");
        System.out.print("Masukkan Nama    : ");
        String nama = inputuser.nextLine();

        String nim;
        do {
            System.out.print("Masukkan NIM     : ");
            nim = inputuser.nextLine();
            if (nim.length() != 15) {
                System.out.print("\nNIM harus 15 digit");
                loop = 0;
            } else {
                loop = 1;
            }
        } while (loop == 0);
        System.out.print("Masukkan Fakultas: ");
        String fakultas = inputuser.nextLine();

        System.out.print("Masukkan jurusan : ");
        String jurusan = inputuser.nextLine();

        App.userstudent.add(new App.Mahasiswa(nama, nim, fakultas, jurusan));
        System.out.println("==== Mahasiswa Berhasil Didaftarkan ====");
        App.menuadmin();

    }

    static void addbook() {
        Scanner inputuser = new Scanner(System.in);

        int no = 0;
        System.out.println("====== Tambah Buku ======");
        System.out.print("Masukkan id buku          : ");
        String id = inputuser.nextLine();

        System.out.print("Masukkan Nama Buku        : ");
        String namabuku = inputuser.nextLine();

        System.out.print("Masukkan Nama Author      : ");
        String author = inputuser.nextLine();

        System.out.print("Masukkan Kategori Buku    : ");
        String category = inputuser.nextLine();

        System.out.print("Masukkan Jumlah Stok Buku : ");
        int stock = inputuser.nextInt();

        App.booklist.add(new App.book(no + 1, id, namabuku, author, category, stock));
        System.out.println("==== Buku Berhasil Ditambahkan ====");
        App.menuadmin();
        inputuser.close();
    }
}