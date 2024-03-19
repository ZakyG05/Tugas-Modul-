public class Mahasiswa {
    String[] nama = new String[100];
    long[] nim = new long[100];
    String[] jurusan = new String[100];
    int jumlahMahasiswa = 0; // Menyimpan jumlah mahasiswa yang telah dimasukkan

    static String tampilUniversitas(){
        return "Universitas Muhammadiyah Malang";
    }
    String tampilDataMahasiswa(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < jumlahMahasiswa; i++) {
            result.append("Nama: ").append(nama[i]).append("\nNIM: ").append(nim[i]).append("\nJurusan: ").append(jurusan[i]).append("\n\n");
        }
        return result.toString();
    }
}
