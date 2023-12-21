import java.util.Scanner;

public class AplikasiPerbankan {
    public static void main(String[] args) {
    tampilanAwal();
    }

    public static void tampilanAwal() { 
        

        
        while(true) {
            int back;
            Scanner scanner = new Scanner(System.in);
            System.out.println("====================================");
            System.out.println("Selamat datang di Aplikasi Perbankan");
            System.out.println("====================================");
            System.out.println("Pilih Masuk sebagai: ");
            System.out.println("1.Admin");
            System.out.println("2.Nasabah");
            System.out.println("3.Keluar");
            System.out.println("====================================");
            System.out.println("Pilih(1/2/3) ");
            System.out.println("====================================");
            String jenisUser = scanner.nextLine();

            if (jenisUser.equals("1")) {
                // Input untuk Admin
                System.out.print("Masukkan username Admin: ");
                String usernameAdmin = scanner.nextLine();
                System.out.print("Masukkan email Admin: ");
                String emailAdmin = scanner.nextLine();
                System.out.print("Masukkan password Admin: ");
                String passwordAdmin = scanner.nextLine();

                Akun admin = new Akun(usernameAdmin, emailAdmin, passwordAdmin);
                DataBase.setPasswordAdmin(passwordAdmin);
                DataBase.tambahAkunAdmin(admin);

                System.out.println("Akun Admin berhasil dibuat dengan ID: " + admin.getIdAdmin());
                System.out.print("Apakah Anda ingin login sebagai Nasabah? (ya/tidak): ");
                String inginLogin = scanner.nextLine().toLowerCase();

                if (inginLogin.equals("ya")) {
                    System.out.print("Masukkan ID Admin: ");
                    String idAdmin = scanner.nextLine();

                    Akun adminLogin = DataBase.getAkunAdminById(idAdmin);

                    if (adminLogin != null) {
                        adminLogin.adminLogin();
                        admin.tampilkanStrukTransaksi();

                    } else {
                        System.out.println("Admin tidak ditemukan.");
                    }
                }
            } else if (jenisUser.equals("2")) {
                // Input untuk Nasabah
                System.out.print("Masukkan username Nasabah: ");
                String nasabahUsername = scanner.nextLine();
                System.out.print("Masukkan email Nasabah: ");
                String nasabahEmail = scanner.nextLine();
                System.out.print("Masukkan password Nasabah: ");
                String nasabahPassword = scanner.nextLine();

                Akun nasabah = new Akun(nasabahUsername, nasabahEmail, nasabahPassword);
                DataBase.tambahAkun(nasabah);

                System.out.println("Akun Nasabah berhasil dibuat dengan ID: " + nasabah.getIdNasabah());

                // Login sebagai Nasabah
                System.out.print("Apakah Anda ingin login sebagai Nasabah? (ya/tidak): ");
                String pilihanLogin = scanner.nextLine().toLowerCase();

                if (pilihanLogin.equals("ya")) {
                    System.out.print("Masukkan ID Nasabah: ");
                    String idNasabah = scanner.nextLine();

                    Akun nasabahLogin = DataBase.getAkunById(idNasabah);

                    if (nasabahLogin != null) {
                        nasabahLogin.login();

                        // Menampilkan opsi transaksi Nasabah
                        do {
                        back = 1;
                        
                        System.out.println("\n======= Menu Transaksi: =========");
                        System.out.println("1. Setoran");
                        System.out.println("2. Tarik Tunai");
                        System.out.println("3. Investasi");
                        System.out.println("4. Top-up e-money");
                        System.out.println("5. Transfer");
                        System.out.println("6. Keluar");

                        System.out.print("Pilih transaksi (1-5): ");
                        int pilihan = scanner.nextInt();

                        switch (pilihan) {
                            case 1:
                                Transaksi.setoran(nasabah);
                                break;
                            case 2:
                                Transaksi.tarikTunai(nasabah);
                                break;
                            case 3:
                                Transaksi.investasi(nasabah);
                                break;
                            case 4:
                                Transaksi.topUpEmoney(nasabah);
                                break;
                            case 5:
                                Transaksi.transfer(nasabah);
                                break;    
                            case 6:
                                // Menampilkan struk transaksi sebelum keluar
                                nasabah.tampilkanStrukTransaksi();

                                // Opsi untuk kembali melanjutkan transaksi atau keluar
                                System.out.print("Apakah Anda ingin kembali melanjutkan transaksi? (ya/tidak): ");
                                String pilihanKembali = scanner.next().toLowerCase();

                                if (pilihanKembali.equals("tidak")) {
                                    
                                    System.out.println("Terimakasih, semoga harimu diberkahi.");
                                    back += 2;
                                }
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        }
                    

                       
                        
                    } while(back <= 1);
                } else {
                        System.out.println("Nasabah tidak ditemukan.");
                    }
                }
            } else if(jenisUser.equals("3")){
                System.out.println("Terimakasih, semoga harimu diberkahi.");
                System.exit(0);

            } else {    System.out.println("Jenis pengguna tidak valid.");
            }

           
        }
    }
 }



