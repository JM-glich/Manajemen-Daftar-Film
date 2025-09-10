
/*Nama: Jemis Movid
NIM: 2409116070
*/

package com.mycompany.manajemen_daftar_film;

/*@author USER
 */
import java.util.ArrayList;
import java.util.Scanner;

class Film {
    private String judul;
    private String genre;
    private int tahunRilis;
    private double rating;

    public Film(String judul, String genre, int tahunRilis, double rating) {
        this.judul = judul;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.rating = rating;
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Judul: " + judul + " | Genre: " + genre + " | Tahun: " + tahunRilis + " | Rating: " + rating;
    }
}

public class Manajemen_Daftar_Film {
    private static ArrayList<Film> daftarFilm = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU MANAJEMEN DAFTAR FILM ===");
            System.out.println("1. Tambah Film");
            System.out.println("2. Tampilkan Semua Film");
            System.out.println("3. Update Film");
            System.out.println("4. Hapus Film");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // buang enter

            switch (pilihan) {
                case 1:
                    tambahFilm();
                    break;
                case 2:
                    tampilkanFilm();
                    break;
                case 3:
                    updateFilm();
                    break;
                case 4:
                    hapusFilm();
                    break;
                case 0:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    private static void tambahFilm() {
        System.out.print("Judul: ");
        String judul = sc.nextLine();
        System.out.print("Genre: ");
        String genre = sc.nextLine();
        System.out.print("Tahun Rilis: ");
        int tahun = sc.nextInt();
        System.out.print("Rating (0.0 - 10.0): ");
        double rating = sc.nextDouble();
        sc.nextLine();

        Film film = new Film(judul, genre, tahun, rating);
        daftarFilm.add(film);
        System.out.println("Film berhasil ditambahkan!");
    }

    private static void tampilkanFilm() {
        if (daftarFilm.isEmpty()) {
            System.out.println("Belum ada film dalam daftar.");
        } else {
            System.out.println("=== DAFTAR FILM ===");
            int i = 1;
            for (Film film : daftarFilm) {
                System.out.println(i + ". " + film);
                i++;
            }
        }
    }

    private static void updateFilm() {
        tampilkanFilm();
        if (daftarFilm.isEmpty()) return;

        System.out.print("Pilih nomor film yang ingin diupdate: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < daftarFilm.size()) {
            Film film = daftarFilm.get(index);
            System.out.print("Judul baru (" + film.getJudul() + "): ");
            String judul = sc.nextLine();
            System.out.print("Genre baru (" + film.getGenre() + "): ");
            String genre = sc.nextLine();
            System.out.print("Tahun Rilis baru (" + film.getTahunRilis() + "): ");
            int tahun = sc.nextInt();
            System.out.print("Rating baru (" + film.getRating() + "): ");
            double rating = sc.nextDouble();
            sc.nextLine();

            film.setJudul(judul);
            film.setGenre(genre);
            film.setTahunRilis(tahun);
            film.setRating(rating);

            System.out.println("Film berhasil diupdate!");
        } else {
            System.out.println("Nomor film tidak valid.");
        }
    }

    private static void hapusFilm() {
        tampilkanFilm();
        if (daftarFilm.isEmpty()) return;

        System.out.print("Pilih nomor film yang ingin dihapus: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < daftarFilm.size()) {
            daftarFilm.remove(index);
            System.out.println("Film berhasil dihapus!");
        } else {
            System.out.println("Nomor film tidak valid.");
        }
    }
}

