public class Tiket {
    int nomorTiket, nomorKursi;
    Film film;
    Studio studio;
    Penonton penonton;

    public Tiket(int nomorTiket, Film film, Studio studio, int nomorKursi, Penonton penonton) {
        this.nomorTiket = nomorTiket;
        this.film = film;
        this.studio = studio;
        this.nomorKursi = nomorKursi;
        this.penonton = penonton;
    }

    public void tampilkanInfo() {
        System.out.println("--------------------------------");
        System.out.println("Nomor Tiket: " + nomorTiket);
        System.out.println("Penonton: " + penonton.nama);
        System.out.println("Film: " + film.judul);
        System.out.println("Studio: " + studio.nomorStudio);
        System.out.println("Nomor Kursi: " + nomorKursi);
        System.out.println("Harga: Rp " + film.hargaTiket);
        System.out.println("--------------------------------");
    }
}
