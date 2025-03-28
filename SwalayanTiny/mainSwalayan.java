package SwalayanTiny;
import java.util.Scanner;
public class mainSwalayan {
    public static void main(String[] args) {
        Pelanggan[] listPelanggan = {
            new Pelanggan(500000, "3812345678", "Ali", "1234"),
            new Pelanggan(1000000, "5612345678", "Radi", "1234"),
            new Pelanggan(1500000, "7412345678", "Laras", "1234")
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan nomor pelanggan: ");
        String nomor = sc.nextLine();

        Pelanggan pelanggan = null;
        for (Pelanggan p : listPelanggan){
            if (p.getNoPel().equals(nomor)){
                pelanggan = p;
                break;
            }
        }

        if (pelanggan == null){
            System.out.println("Pelanggan belum terdaftar!");
            return;
        }

        System.out.println("Masukkan PIN: ");
        String pin = sc.nextLine();

        if(!pelanggan.checkPin(pin)) {
            return;
        }

        System.out.println("Pilih Menu Transaksi : ");
        System.out.println("1. Beli");
        System.out.println("2. Top Up");
        int pilihan = sc.nextInt();

        switch (pilihan){
            case 1 :
            System.out.println("Masukkan total pembelian: ");
            double jumlahUang = sc.nextDouble();
            pelanggan.beli(jumlahUang);
            break;

            case 2:
            System.out.println("Masukkan jumlah nominal yang anda ingin Top Up : ");
            double jumlah = sc.nextDouble();
            pelanggan.topUp(jumlah);
            break;

            default :
            System.out.println("Pilihan tidak valid!");
            break;

        }

        sc.close();
    }
}
