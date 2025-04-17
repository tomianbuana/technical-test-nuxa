# technical-test-nuxa

## Deskripsi Proyek

Repository ini berisi kode automation testing yang dibuat menggunakan Selenium WebDriver dengan bahasa pemrograman Java. Tujuan utama dari proyek ini adalah untuk melakukan pengujian otomatis pada aplikasi web tertentu (sebutkan aplikasi web jika relevan, misalnya: halaman login, fitur utama, dll.).

Proyek ini dirancang untuk menjadi kerangka kerja pengujian yang mudah dipahami, dikelola, dan dikembangkan lebih lanjut. Struktur proyek diatur sedemikian rupa untuk memisahkan antara konfigurasi, *page object*, dan skenario pengujian.

## Prasyarat

Sebelum menjalankan proyek automation ini, pastikan Anda telah menginstal perangkat lunak berikut di sistem Anda:

1.  **Java Development Kit (JDK):** Pastikan Anda memiliki JDK versi 8 atau lebih tinggi terinstal. Anda dapat mengunduhnya dari [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/) atau [OpenJDK](https://openjdk.java.net/install/).
2.  **Maven:** Proyek ini menggunakan Maven sebagai *build automation tool* dan *dependency management*. Pastikan Maven telah terinstal di sistem Anda. Anda dapat mengunduhnya dan mengikuti instruksi instalasinya dari [Apache Maven](https://maven.apache.org/download.cgi).
3.  **Browser Web:** Proyek ini mendukung berbagai browser web yang didukung oleh Selenium WebDriver, seperti Google Chrome, Mozilla Firefox, Microsoft Edge, dll. Pastikan browser yang ingin Anda gunakan telah terinstal.
4.  **WebDriver Manager (Opsional, tetapi direkomendasikan):** Proyek ini kemungkinan menggunakan WebDriverManager untuk mengelola driver browser secara otomatis. Jika tidak, Anda perlu mengunduh driver browser yang sesuai secara manual dan mengonfigurasinya.

## Instalasi dan Setup

Langkah-langkah berikut menjelaskan cara mengunduh dan menyiapkan proyek di lingkungan lokal Anda:

1.  **Clone Repository:** Buka terminal atau command prompt Anda dan navigasikan ke direktori tempat Anda ingin menyimpan proyek. Kemudian, jalankan perintah berikut:
    ```bash
    git clone https://github.com/tomianbuana/technical-test-nuxa.git
    cd technical-test-nuxa
    ```

2.  **Build Proyek Maven:** Setelah masuk ke direktori proyek, jalankan perintah Maven berikut untuk mengunduh semua *dependency* yang dibutuhkan:
    ```bash
    mvn clean install
    ```
    Perintah ini akan mengunduh *library* Selenium, WebDriverManager (jika digunakan), JUnit atau TestNG (jika digunakan), dan *dependency* lainnya yang didefinisikan dalam file `pom.xml`.

## Menjalankan Automation Test

1.  **Navigasi ke Direktori `src/main/java/org/example`:** Buka terminal atau command prompt Anda dan navigasikan ke direktori yang berisi file `Main.java`:
    ```bash
    cd src/main/java/org/example
    ```

2.  **Kompilasi File Java (Jika Belum Dikompilasi):** Jika file `Main.java` belum dikompilasi, Anda perlu melakukannya terlebih dahulu. Anda dapat menggunakan `javac` (bagian dari JDK). Pastikan `javac` berada di *system path* Anda.
    ```bash
    javac Main.java
    ```
    Ini akan menghasilkan file `Main.class` di direktori yang sama.

3.  **Jalankan File Java dengan Classpath Maven:** Untuk menjalankan file `Main.class`, Anda perlu menyertakan semua *dependency* Maven (termasuk *library* Selenium dan driver browser) dalam *classpath*. Anda dapat menggunakan perintah `java` dengan opsi `-cp` atau `--classpath`. Cara termudah adalah dengan memanfaatkan variabel *classpath* Maven.

    **Menggunakan `mvn exec:java` (Direkomendasikan):** Maven memiliki plugin `exec` yang memudahkan menjalankan kelas Java dengan *classpath* yang sudah dikonfigurasi oleh Maven. Dari direktori root proyek, jalankan perintah berikut:

    ```bash
    mvn exec:java -Dexec.mainClass="org.example.Main"
    ```

    Perintah ini akan mengkompilasi (jika perlu) dan menjalankan kelas `org.example.Main` dengan semua *dependency* proyek yang ada di `pom.xml`.

    **Menjalankan dengan `java` secara langsung (Membutuhkan Pengetahuan Classpath Maven):** Jika Anda ingin menggunakan perintah `java` secara langsung, Anda perlu mengetahui lokasi *JAR file* Selenium dan driver browser di direktori `.m2/repository` lokal Anda dan menyertakannya dalam *classpath*. Ini bisa menjadi rumit karena versi dan jumlah *JAR file* bisa bervariasi. Contoh (mungkin perlu disesuaikan):

    ```bash
    java -cp "target/classes;~/.m2/repository/org/seleniumhq/selenium/*;~/.m2/repository/io/github/bonigarcia/webdrivermanager/*;~/.m2/repository/commons-io/*;~/.m2/repository/com/google/guava/*" org.example.Main
    ```

    **Catatan Penting:**

    * Ganti `~/.m2` dengan *path* sebenarnya ke direktori repository Maven lokal Anda jika berbeda.
    * Tanda `;` digunakan sebagai pemisah *classpath* di Windows, sedangkan `:` digunakan di Linux/macOS. Sesuaikan dengan sistem operasi Anda.

    **Cara yang paling mudah dan direkomendasikan untuk menjalankan file Java dengan *dependency* Maven adalah menggunakan `mvn exec:java` seperti pada contoh pertama di langkah ini.**

4.  **Amati Hasil Pengujian:** Setelah perintah dijalankan, file `Main.java` akan menjalankan *automation test* yang telah Anda implementasikan. Perhatikan output di konsol atau laporan yang mungkin dihasilkan oleh kode Anda untuk melihat hasil pengujian.

**Menjalankan dari IDE (IntelliJ IDEA, Eclipse, dll.):**

Cara paling mudah untuk menjalankan `Main.java` adalah melalui IDE:

1.  Buka proyek `technical-test-nuxa` di IDE Anda.
2.  Navigasi ke file `src/main/java/org/example/Main.java`.
3.  Klik kanan pada file `Main.java` di *project explorer*.
4.  Pilih opsi "Run 'Main.main()'" (atau yang serupa, tergantung pada IDE Anda).

IDE akan secara otomatis mengelola *classpath* proyek Maven Anda, sehingga semua *dependency* yang dibutuhkan akan tersedia saat menjalankan file `Main.java`.

Dengan menjalankan file `Main.java` secara langsung, Anda dapat dengan cepat menguji atau menjalankan *sebagian* dari *automation test* Anda tanpa perlu menjalankan keseluruhan *build* Maven. Pastikan logika di dalam file `Main.java` sudah sesuai dengan *test case* yang ingin Anda jalankan.
