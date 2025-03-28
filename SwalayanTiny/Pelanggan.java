package SwalayanTiny;
public class Pelanggan {
    private int saldo;
    private String noPel;
    private String nama;
    private String pin;
    private boolean diBlokir;
    private int salahPin;

    public Pelanggan(int saldo, String noPel, String nama, String pin){
        this.saldo = saldo;
        this.noPel = noPel;
        this.nama = nama;
        this.pin = pin;
        this.diBlokir = false;
        this.nama = nama;
        this.salahPin = 0;
    }

    public String getNoPel(){
        return noPel;
     }

    public boolean checkPin(String inputPin){
        if (pin == inputPin){
            salahPin = 0;
            return true;
        } else {
            salahPin++;
            System.out.println("Pin yang anda masukkan salah!");
            if (salahPin >= 3){
                diBlokir = true;
                System.out.println("Akun anda telah diblokir!");
            }
            return false;
        }
    }

    public void topUp (double jumlahUang){
        saldo += jumlahUang;
        System.out.println("Top Up anda berhasil!");
    }

    public double hitungCashback(double jumlahUang){
        String jenisKode = noPel.substring(0, 2);
        double cashback = 0;

        if (jumlahUang > 1000000){
            switch (jenisKode) {
                case "38":
                    cashback = jumlahUang * 0.05;
                    break;
                case "56":
                    cashback = jumlahUang * 0.07;
                    break;
                case "74":
                    cashback = jumlahUang * 0.10;
                    break;
                default:
                    break;
            }
        } else {
            switch (jenisKode) {
                case "56":
                    cashback = jumlahUang * 0.02;
                    break;
                case "74":
                    cashback = jumlahUang * 0.05;
                    break;
        }
    }
    return cashback;

    }

    public void beli(double jumlahUang){
        double cashback = hitungCashback(jumlahUang);
        double totalAfterCashback = jumlahUang - cashback;

        if (saldo - totalAfterCashback < 10000){
            System.out.println("Transaksi gagal, Saldo anda tidak mencukupi!");
            return;
        }

        saldo -= totalAfterCashback;
        saldo += cashback;
        System.out.println("Pembelian berhasil! Saldo anda sekarang : Rp" + saldo);

        if(diBlokir){
            System.out.println("Akun anda telah diblokir!");
            return;
        }
    }

}
