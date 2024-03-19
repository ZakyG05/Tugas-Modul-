import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.menu();
    }
    public void menu(){
        Scanner input = new Scanner(System.in);
        Mahasiswa mahasiswaObject = new Mahasiswa();
        String option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Tampilkan data mahasiswa");
            System.out.println("3. Exit");

            System.out.print("Pilihan (1-3): ");
            option = input.nextLine();

            if(option.equals("1")) {
                System.out.println("Menu:");
                System.out.print("Masukkan nama mahasiswa: ");
                mahasiswaObject.nama[mahasiswaObject.jumlahMahasiswa] = input.nextLine();
                System.out.print("Masukkan NIM mahasiswa: ");
                String nimInput = input.nextLine();
                try {
                    long nim = Long.parseLong(nimInput);
                    if(String.valueOf(nim).length() == 15){ // membatasi inputan user hanya boleh memasukkan 15 digit angka
                        mahasiswaObject.nim[mahasiswaObject.jumlahMahasiswa] = nim;
                        System.out.print("Masukkan Jurusan mahasiswa: ");
                        mahasiswaObject.jurusan[mahasiswaObject.jumlahMahasiswa] = input.nextLine();
                        mahasiswaObject.jumlahMahasiswa++;//menambahkan data mahasiswa
                        System.out.println("Data mahasiswa berhasil ditambahkan.");
                    } else {
                        System.out.println("Nim harus 15 digit!!!");
                    }
                } catch(NumberFormatException e){
                    System.out.println("NIM harus berupa bilangan bulat!!!");
                }
            } else if(option.equals("2")) {
                System.out.println("===== Tampilkan Data Mahasiswa =====");
                System.out.println(Mahasiswa.tampilUniversitas());
                System.out.println(mahasiswaObject.tampilDataMahasiswa());
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
