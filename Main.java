import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Deklarasi Variabel Global
        Scanner hai = new Scanner(System.in);
        List<Tiket> daftartkt = new ArrayList<>();
        boolean next = true;
        int nomorTiket = 100;

        // inialisasi objek
        Film film1 = new Film("Popol and kupa", "Romance", "10:00", 25000);
        Film film2 = new Film("Jacob escaped from prison", "Action and Criminal", "15:00", 50000);
        Film film3 = new Film("Bloody rice", "Horror", "21:00", 35000);

        Studio studio1 = new Studio(1, 45, film1);
        Studio studio2 = new Studio(2, 60, film2);
        Studio studio3 = new Studio(3, 30, film3);

        // menampilkan menu atau list
        System.out.println("--------------------------------");
        System.out.println("Selamat datang di T-REX Cinema");
        System.out.println("--------------------------------");
        
        // loop utama pemesanan tiket
        while (next) {
            System.out.println("\nPilih film yang ingin Anda tonton:");
            System.out.println("1. Popol and kupa (Romance) - 10:00 - Rp 25000");
            System.out.println("2. Jacob escaped from prison (Action and Criminal) - 15:00 - Rp 50000");
            System.out.println("3. Bloody rice (Horror) - 21:00 - Rp 35000");

            System.out.print("\nMasukkan nomor film: ");
            int pilihFilm = hai.nextInt();
            hai.nextLine();

            // memilih berdasarkan input
            Film filmTerpilih = null;
            Studio studioTerpilih = null;

            switch (pilihFilm) {
                case 1: filmTerpilih = film1; studioTerpilih = studio1; break;
                case 2: filmTerpilih = film2; studioTerpilih = studio2; break;
                case 3: filmTerpilih = film3; studioTerpilih = studio3; break;
                default: System.out.println("Pilihan tidak valid!"); continue;
            }

            System.out.print("Masukkan nama Anda: ");
            String namaPenonton = hai.nextLine();

            // vzalidadi ketersediaan
            int nomorKursi;
            boolean kursiTersedia;

            do {
                System.out.print("Pilih nomor kursi (1 - " + studioTerpilih.kapasitasKursi + "): ");
                nomorKursi = hai.nextInt();
                hai.nextLine();

                kursiTersedia = cekKursiTersedia(daftartkt, studioTerpilih, nomorKursi);

                if (!kursiTersedia) {
                    System.out.println("Maaf, nomor kursi ini sudah dipesan. Silakan pilih nomor kursi lain.");
                }
            } while (!kursiTersedia);
            
            // menyimpan tiket
            Penonton penonton = new Penonton(namaPenonton);
            Tiket tiket = new Tiket(nomorTiket++, filmTerpilih, studioTerpilih, nomorKursi, penonton);

            daftartkt.add(tiket);

            System.out.println("\nTiket yang berhasil dipesan:");
            tiket.tampilkanInfo();

            // menanyakan apakah ingin memesan tiket
            System.out.print("\nIngin memesan tiket lagi? (ya/tidak): ");
            String jawaban = hai.nextLine();
            if (!jawaban.equalsIgnoreCase("ya")) {
                next = false;
            }
        }

        System.out.println("\n-----------------------------------");
        System.out.println("Ringkasan Semua Tiket yang Dipesan:");
        System.out.println("-----------------------------------");
        for (Tiket tiket : daftartkt) {
            tiket.tampilkanInfo();
            System.out.println("-----------------------------");
        }

        System.out.println("Terima kasih telah memesan tiket di T-REX Cinema!");
        hai.close();
    }

    public static boolean cekKursiTersedia(List<Tiket> daftartkt, Studio studio, int nomorKursi) {
        for (Tiket tiket : daftartkt) {
            if (tiket.studio.equals(studio) && tiket.nomorKursi == nomorKursi) {
                return false;
            }
        }
        return true;
    }
}
