import java.util.Scanner;
import java.util.ArrayList;

public class Nomor2 {
    static String[] daftarBuku = {"Sherlock Holmes", "Arsene Lupin", "Game of Throne", "Psychology of Money"};
    static int[] hargaBuku = {350000, 450000, 500000, 95000};

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> belanjaUser = new ArrayList<>();

       
        System.out.println("Daftar Buku:");
        for (int i = 0; i < daftarBuku.length; i++) {
            System.out.println((i + 1) + ". " + daftarBuku[i] + " - " + hargaBuku[i]);
        }

        String pilihan;
        do {
            System.out.print("Masukan pilihan buku [1/2/3/4]: ");
            int pilihanBuku = scanner.nextInt();
            if (pilihanBuku >= 1 && pilihanBuku <= 4) {
                belanjaUser.add(hargaBuku[pilihanBuku - 1]);
            } else {
                System.out.println("Pilihan tidak valid!");
            }
            System.out.print("Input lagi (Y/N)?: ");
            pilihan = scanner.next().toUpperCase();
        } while (pilihan.equals("Y"));

        
        int totalBelanja = hitungTotalHarga(belanjaUser);
        
        int voucherBelanja = hitungVoucher(totalBelanja);

        
        System.out.println("Total Voucher Belanja = " + voucherBelanja);
        System.out.println("Total Yang Harus Dibayar = " + totalBelanja);
     

        scanner.close();

       
        System.out.println(Nomor2.class.getDeclaredMethods().length); 
    }


    public static int hitungTotalHarga(ArrayList<Integer> belanja) {
        int total = 0;
        for (int harga : belanja) {
            total += harga;
        }
        return total;
    }

    public static int hitungVoucher(int totalBelanja) {
        if (totalBelanja < 200000) {
            return 0;
        } else if (totalBelanja <= 500000) {
            return 50000;
        } else if (totalBelanja <= 750000) {
            return 100000;
        } else if (totalBelanja <= 1000000) {
            return 150000;
        } else {
            return 200000;
        }
    }
}
