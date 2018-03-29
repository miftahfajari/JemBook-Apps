package kelompok8.com.jembook_apps;

/**
 * Created by ASUS on 30/03/2018.
 */

public class Buku {

    String idBuku;
    String judulBuku;
    String penBuku;
    String genreBuku;

    public Buku(){

    }

    public Buku(String idBuku, String judulBuku, String penBuku, String genreBuku) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.penBuku = penBuku;
        this.genreBuku = genreBuku;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getPenBuku() {
        return penBuku;
    }

    public String getGenreBuku() {
        return genreBuku;
    }
}
