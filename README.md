Nama: Jemis Movid

NIM: 2409116070

# Manajemen-Daftar-Film

``` java
import java.util.ArrayList;
import java.util.Scanner;
```
Bagian kode ini digunakan untuk mengimport library yang ada di Java. ArrayList dipakai untuk menyimpan data film, sedangkan Scanner digunakan untuk input dari user. 

``` java
class Film {
    private String judul;
    private String genre;
    private int tahunRilis;
    private double rating;
```
Class Film dibuat untuk merepresentasikan sebuah data film. Intinya class dipakai untuk menjadi sebuah wadah indentitas data. Atributnya diset private supaya mengikuti prinsip enkapsulasi (tidak bisa diakses langsung dari luar).

``` java
    public Film(String judul, String genre, int tahunRilis, double rating) {
        this.judul = judul;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.rating = rating;
    }
```
Constructor digunakan untuk membuat objek Film baru dengan data yang diisi langsung saat pemanggilan. Di sini juga menggunakan fungsi 'this' untuk merepresentasikan sebuah objek di dalam class.

``` java
    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

```
Kode di atas ini adalah bagian setter dan getter nya yang nanti digunakan untuk memasukan sebuah value dan memanggil/mengambil sebuah value.

``` java
    @Override
    public String toString() {
        return "Judul: " + judul + " | Genre: " + genre + " | Tahun: " + tahunRilis + " | Rating: " + rating;
    }
}

```
Method toString() dipakai agar saat objek Film ditampilkan, langsung muncul dalam format teks yang rapi. selain itu juga menggunakan @Override agar tidak mengubah kode parents class secara langsung.

# Bagian Yang Menjadi MENU UTAMA
``` java
public class Manajemen_Daftar_Film {
    private static ArrayList<Film> daftarFilm = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

```
Bagian class ini pada dasarnya adalah class Main yang menjadi titik masuk program. Class ini ibarat bagian Menu Utamanya. Di dalamnya ada:
* daftarFilm, untuk menyimpan semua data film
* Scanner sc, bagian yang nanti menerima input user

``` java
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

```
Di sinilah program akan menampilkan menu utama. Pemilihan menu dilakukan dengan switch-case, dan do…while memastikan menu akan terus muncul sampai user memeilih 0 untuk keluar.

``` java
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

```
Bagian percabangan untuk mengarahkan user ke fitur sesuai pilihannya.

# Bagian METHOD
``` java
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

```
Bagian ini membuat objek Film baru berdasarkan input user, lalu menambahkannya ke ArrayList.

``` java
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
```
Menampilkan semua film dengan perulangan. Kalau listnya kosong, akan muncul pesan khusus.

``` java
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

```
User pilih nomor film, lalu memasukkan data baru. Data lama kemudian akan diganti dengan input baru.

``` java
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
```
User pilih nomor film, lalu data film tersebut dihapus dari daftar (Sangat simpel sekali).

# ALUR PROGRAM

1. Program dimulai dengan masuk ke method Manajemen_Daftar_Film (Di dalamnya nanti akan dibuatkan array buat nyimpan data dan scanner untuk nginput).
2. Nah, nanti akan muncul menu seperti ini. Di dalamnya ada perulangan do...while, jadi akan terus muncul setelah user melakukan aksi sampai ia memilih opsi 0 (keluar).

    <img width="510" height="225" alt="image" src="https://github.com/user-attachments/assets/2d0dad07-e20a-48dd-a7e0-74e513106b4c" />
3. Setelah itu user akan memasukan angka sebagai input.
4. Jika user memilih angka 1 (Tambah Film).

    <img width="438" height="365" alt="image" src="https://github.com/user-attachments/assets/05bcdfe6-b038-4739-822e-021f55e5653f" />

    Maka akan muncul inputan untuk memasukan value seperti judul, genre, tahun rilis, dan rating.
5. Jika user memilih angka 2 (Tampilkan Semua Film).

    <img width="765" height="255" alt="image" src="https://github.com/user-attachments/assets/6f8073ce-18af-4e4f-b66b-edecc284d819" />

    Program akan mengecek apakah ```daftarFilm``` kosong atau tidak. Kalau kosong maka akan muncul pesan "Belum ada film dalam daftar". Tapi bila ada, maka program akan menampilkan semua film yang ada.
6. Jika user memilih angka 3 (Update Film). (Di sini saya sudah menambahkan data lainnya)

    <img width="878" height="335" alt="image" src="https://github.com/user-attachments/assets/0b25639c-fae3-4865-a0d5-2b7dce7f24d0" />

    Pertama, program akan menampilkan semua film yang ada. User kemudian memasukan input sesuai dengan nomor urut film. Program kemudian akan meminta data baru (judul, genre, tahun rilis, dan rating). 
7. Jika user memilih angka 4 (Hapus Film).

    <img width="1345" height="237" alt="image" src="https://github.com/user-attachments/assets/b6cb09df-4a87-4f5b-9801-66ba44a2f125" />

    Mirip menu angka 3, pertama program akan menampilkan semua film yang ada. Lalu user tinggal menginput angka sesuai nomor urut filmnya dan film pun akan dihapus.
8. Jika user memilih angka 0 (keluar).

    <img width="421" height="267" alt="image" src="https://github.com/user-attachments/assets/285703bb-ff0f-470b-9a8b-a18ede9b26f8" />

    Program akhirnya akan berhenti berjalan dan user pun keluar dari program.
