@SuppressWarnings("ALL")
public class Student {

    static void loginstudent() {
        boolean validasi = false;
        int loop = 0;
        do {
            App.inputNIM();
            if (App.NIM.length() != 15) {
                System.out.println("NIM harus 15 digit\n");
                App.menu();
            }
            for (App.Mahasiswa i : App.userstudent) {
                if (i.nim.equals(App.NIM)) {
                    validasi = true;
                    break;
                }
            }
            if (validasi) {
                System.out.println("==== Login berhasil ====\n");
                loop = 1;
            } else {
                System.out.println("==== NIM tidak terdaftar ===");
                App.menu();
            }

        } while (loop == 0);

    }

    static void logout() {
        App.menu();
    }

    static void displaybooks() {
        System.out.println(
                "==================================================================================================================================");
        System.out.printf("|| %-3s || %-25s || %-25s || %-25s || %-20s || %-3s ||", "No.", "ID Buku", "Nama Buku",
                "Author", "Category", "Stock");
        System.out.println(
                "==================================================================================================================================");

        for (App.book i : App.booklist) {
            System.out.printf("|| %-3s || %-25s || %-25s || %-25s || %-20s || %-3s ||", i.no, i.id, i.namabuku,
                    i.author, i.category, i.stock);
        }

        System.out.println(
                "==============================================================================================================================================================");

    }
}