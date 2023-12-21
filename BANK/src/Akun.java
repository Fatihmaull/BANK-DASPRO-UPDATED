import java.util.Scanner;

public class Akun {
    //Nasabah
    private static int countN = 1;
    private String idNasabah;
    private String username;
    private String email;
    private String password;
    private double totalSaldo;
    private String catatanTransaksi;
    //Admin
    private static int countA = 1;
    private String idAdmin;
    private String usernameAdmin;
    private String emailAdmin;
    private String passwordAdmin;

    public Akun(String username, String email, String password) {
        //Admin
        this.idAdmin = "A" + countA++;
        this.usernameAdmin = username;
        this.emailAdmin = email;
        this.passwordAdmin = password;
        //Nasabah
        this.idNasabah = "N" + countN++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.totalSaldo = 0;
        this.catatanTransaksi = "";
    }

    //Admin
    public String getIdAdmin() {
        return idAdmin;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    //Nasabah
    public String getIdNasabah() {
        return idNasabah;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public double getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(double totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public String getCatatanTransaksi() {
        return catatanTransaksi;
    }

    public void setCatatanTransaksi(String catatanTransaksi) {
        this.catatanTransaksi = catatanTransaksi;
    }

    public void login() {
       Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();

            if (inputPassword.equals(password)) {
                System.out.println("Login berhasil.");
            } else {
                System.out.println("Password salah. Login gagal.");
                System.exit(0);  // Keluar dari program jika login gagal
            }
        }

    public void adminLogin() {
       Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();

            if (inputPassword.equals(passwordAdmin)) {
                System.out.println("Login berhasil.");
            } else {
                System.out.println("Password salah. Login gagal.");
                System.exit(0);  // Keluar dari program jika login gagal
            }
        
    }

    public void tampilkanStrukTransaksi() {
        System.out.println("===============================");
        System.out.println("Struk Transaksi: ");
        System.out.println("===============================");
        System.out.println("");
        System.out.println("Username: " + getUsername());
        System.out.println("ID Nasabah: " + getIdNasabah());
        System.out.println("Jenis Transaksi: " + getCatatanTransaksi());
        System.out.println("Jumlah Transaksi: " + getTotalSaldo());
        System.out.println("Total Saldo: " + getTotalSaldo());
        System.out.println("");
        System.out.println("===============================");
        System.out.println("Terima kasih atas transaksi Anda.");
    }
}
