package javaproje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaProje {

    public static void main(String[] args) throws IOException {
        System.out.print("OGRENCI ISLERI OTOMASYONUNA HOSGELDINIZ...\n");
        System.out.print("Giris yapmak istediginiz turu seciniz.\n Ogrenci girisi : 1\n Ogretim uyesi girisi : 2\n Idari memur girisi : 3\n Cikis : 0\n");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        Giris giris = new Giris();
        giris.uyeGirisi(x);
        OgrenciKayitIslemleri ogrenci = new OgrenciKayitIslemleri();
        do {
            if (x == 1) { //ogrenci
                System.out.print("Ders secmek icin : 1\nDers programini gormek icin : 2\nSinav notlarini gormek icin : 3\nGirise donmek icin : 0\n");
                int og = s.nextInt();
                Ogrenci ogr = new Ogrenci();

                switch (og) {
                    case 0:
                        System.out.print("Giris yapmak istediginiz turu seciniz.\n Ogrenci girisi : 1\n Ogretim uyesi girisi : 2\n Idari memur girisi : 3\n");
                        x = s.nextInt();
                        break;
                    case 1: //ders secme
                        Ders ders = new Ders();
                        DersIslemleri dersSecimi = ders;
                        dersSecimi.dersListeleri();
                        break;
                    case 2: //ders prog gorme
                        System.out.print("Sectiginiz derslere gore hazirlanan ders programiniz asagidadir...\n");
                        ogr.dersProgramiListele();
                        break;
                    case 3: //sinav sonuclari
                        System.out.print("Sinav notu bilgileriniz asagidadir...");
                        ogr.notListele();
                        break;
                    default:
                        System.out.println("Hatali secim! 1, 2, ya da 3'e basiniz.");
                        break;
                }

            } else if (x == 2) { //ogretimUyesi
                System.out.print("Not girmek icin : 1\nHarf notu belirlemek icin : 2\nYoklama listelerini girmek icin : 3\nOgrenci listelerine erisim icin : 4\nGirise donmek icin : 0\n");
                int ou = s.nextInt();
                NotIslemleri not = new NotIslemleri();
                switch (ou) {
                    case 0:
                        System.out.print("Giris yapmak istediginiz turu seciniz.\n Ogrenci girisi : 1\n Ogretim uyesi girisi : 2\n Idari memur girisi : 3\n");
                        x = s.nextInt();
                        break;
                    case 1: //not girme
                        not.notGirme();
                        break;
                    case 2: //harf notu belirleme
                        not.harfNotuBelirleme();
                        break;
                    case 3: //yoklama
                        Yoklama y = new Yoklama();
                        OgrenciIslemleri yoklama = y;
                        yoklama.yoklamaAl();
                        break;
                    case 4: //ogrenci listesi
                        ogrenci.ogrenciListele();
                        break;
                    default:
                        System.out.println("Hatali secim! 1, 2, 3 ya da 4'e basiniz.");
                        break;
                }
            } else if (x == 3) { //IdariMemur
                System.out.print("Ogrenci kayit islemleri : 1\nDers programi hazirlama : 2\nGirise donmek icin : 0\n");
                int im = s.nextInt();
                if (im == 1) { //ogrenciKayit
                    System.out.print("Kayit ekleme : 1\nKayit silme : 2\nKayit listeleme : 3 \nCikis : 0\n");
                    int oi = s.nextInt();
                    switch (oi) {
                        case 0:
                            System.out.print("Kayit ekleme : 1\nKayit silme : 2\nKayit listeleme : 3\nCikis : 0\n");
                            oi = s.nextInt();
                            break;
                        case 1:
                            ogrenci.ogrenciEkle();
                            break;
                        case 2:
                            ogrenci.ogrenciSil();
                            break;
                        case 3:
                            ogrenci.ogrenciListele();
                            break;
                        default:
                            System.out.println("Hatali secim! 1, 2 ya da 3'e basiniz.");
                            break;
                    }
                } else if (im == 2) { //dersProgramiHazirlama
                    Ders d = new Ders();
                    d.dersProgramiHazirlama();
                } else if (im == 0) {
                    System.out.print("Giris yapmak istediginiz turu seciniz.\n Ogrenci girisi : 1\n Ogretim uyesi girisi : 2\n Idari memur girisi : 3\n");
                    x = s.nextInt();
                }
            } else if (x == 0) { //cikis
                System.out.println("Sistemden cikis yapildi");
                break;
            }
        } while (true);
    }
}

interface OgrenciI {

    void dersProgramiListele();

    void notListele();
}

interface OgretimUyesiI {

    void notGirme();

    void harfNotuBelirleme();
}

interface IdariMemurI {

    void ogrenciEkle();

    void ogrenciSil();

    void ogrenciListele();
}

abstract class OgrenciIslemleri {

    public abstract void yoklamaAl();

}

abstract class DersIslemleri {

    public void dersSecme(ArrayList liste) {
        System.out.print("5 ders secme hakkiniz vardir, istediginiz derslerin numarasini giriniz.\n");
        ArrayList listeSecilenler = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            int secim = sc.nextInt();
            for (int j = 0; j < liste.size(); j++) {
                if (((String) liste.get(j)).contains(String.valueOf(secim))) {
                    String secilenSatirStr = ((String) liste.get(j));
                    int a = secilenSatirStr.indexOf(". ");
                    String secilenDers = secilenSatirStr.substring(a + 2);
                    listeSecilenler.add(secilenDers);
                    System.out.print(secilenDers);
                    break;
                }
            }
        }
        try {
            FileOutputStream f = new FileOutputStream("SecilenDersler.txt", true);
            PrintStream yaz = new PrintStream(f);
            for (int i = 0; i < listeSecilenler.size(); i++) {
                if (!(listeSecilenler.isEmpty())) {
                    yaz.print((i + 1) + ". " + listeSecilenler.get(i) + "\n");
                } else {
                    yaz.print((i + 1) + ". " + listeSecilenler.get(i));
                }
            }
        } catch (IOException e) {
        }
    }

    public void dersListeleri() {
        System.out.print("Bolumunuzu giriniz...\n 1. Bilgisayar Muhendisligi\n 2. Endustri Muhendisligi\n 3. Makine Muhendisligi\n 4. Elektrik Muhendisligi\n");
        Scanner s = new Scanner(System.in);
        int bolum = s.nextInt();
        if (bolum == 1) {
            try {
                FileInputStream fi = new FileInputStream("BilgisayarMuhendisligi.txt");
                BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                String satir;
                ArrayList liste = new ArrayList<String>();
                while ((satir = buf.readLine()) != null) {
                    System.out.println(satir);
                    liste.add(satir);
                }
                dersSecme(liste);
            } catch (FileNotFoundException f) {
                System.out.println("dosya yok"+f);
            } catch (IOException ioex) {
                System.out.println("başka bir hata oldu"+ioex);
            }

        } else if (bolum == 2) {
            try {
                FileInputStream fi = new FileInputStream("EndustriMuhendisligi.txt");
                BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                String satir;
                ArrayList liste = new ArrayList<String>();
                while ((satir = buf.readLine()) != null) {
                    System.out.println(satir);
                    liste.add(satir);
                }
                dersSecme(liste);
            } catch (FileNotFoundException f) {
                System.out.println("dosya yok");
            } catch (IOException ioex) {
                System.out.println("başka bir hata oldu");
            }

        } else if (bolum == 3) {
            try {
                FileInputStream fi = new FileInputStream("MakineMuhendisligi.txt");
                BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                String satir;
                ArrayList liste = new ArrayList<String>();
                while ((satir = buf.readLine()) != null) {
                    System.out.println(satir);
                    liste.add(satir);
                }
                dersSecme(liste);
            } catch (FileNotFoundException f) {
                System.out.println("dosya yok"+f);
            } catch (IOException ioex) {
                System.out.println("başka bir hata oldu"+ioex);
            }

        } else if (bolum == 4) {
            try {
                FileInputStream fi = new FileInputStream("ElektrikMuhendisligi.txt");
                BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                String satir;
                ArrayList liste = new ArrayList<String>();
                while ((satir = buf.readLine()) != null) {
                    System.out.println(satir);
                    liste.add(satir);
                }
                dersSecme(liste);
            } catch (FileNotFoundException f) {
                System.out.println("dosya yok"+f);
            } catch (IOException ioex) {
                System.out.println("başka bir hata oldu"+ioex);
            }
        }
    }

    public abstract void dersProgramiHazirlama();
}

class Giris {

    public int uyeGirisi(int x) {
        if (x == 1) {
            try {
                FileOutputStream f = new FileOutputStream("Uyeler.txt", true);
                PrintStream yaz = new PrintStream(f);
                Scanner girdi = new Scanner(System.in);
                System.out.print("Ad : ");
                String ad = girdi.next();
                yaz.print("\n" + ad + " ");
                System.out.print("Soyad: ");
                String soyad = girdi.next();
                yaz.print(soyad + " ");
                System.out.print("Okul No : ");
                int okulno = girdi.nextInt();
                yaz.print(okulno + " ");
                System.out.print("Bolum : ");
                String bolum = girdi.next();
                yaz.print(bolum + " ");
                System.out.print("Sifre : ");
                String sifre = girdi.next();
                yaz.print(sifre + " ");
                yaz.print("ogrenci");
            } catch (IOException e) {
                System.out.print("Giris yapilamadi" + e);
            }
        } else if (x == 2) {
            try {
                FileOutputStream f = new FileOutputStream("Uyeler.txt", true);
                PrintStream yaz = new PrintStream(f);
                Scanner girdi = new Scanner(System.in);
                System.out.print("Ad : ");
                String ad = girdi.next();
                yaz.print("\n" + ad + " ");
                System.out.print("Soyad: ");
                String soyad = girdi.next();
                yaz.print(soyad + " ");
                System.out.print("Bolum : ");
                String bolum = girdi.next();
                yaz.print(bolum + " ");
                System.out.print("Sifre : ");
                String sifre = girdi.next();
                yaz.print(sifre + " ");
                yaz.print("ogretim uyesi");
            } catch (IOException e) {
                System.out.print("Giris yapilamadi" + e);
            }
        } else if (x == 3) {
            try {
                FileOutputStream f = new FileOutputStream("Uyeler.txt", true);
                PrintStream yaz = new PrintStream(f);
                Scanner girdi = new Scanner(System.in);
                System.out.print("Ad : ");
                String ad = girdi.next();
                yaz.print("\n" + ad + " ");
                System.out.print("Soyad: ");
                String soyad = girdi.next();
                yaz.print(soyad + " ");
                System.out.print("Sifre : ");
                String sifre = girdi.next();
                yaz.print(sifre + " ");
                yaz.print("idari memur");
            } catch (IOException e) {
                System.out.print("Giris yapilamadi" + e);
            }
        }
        return 0;
    }
}

class OgrenciKayitIslemleri implements IdariMemurI {

    @Override
    public void ogrenciEkle() {
        System.out.print("Yeni ogrenci kaydi icin gerekli bilgileri giriniz...\n");
        try {
            FileOutputStream f = new FileOutputStream("OgrenciKayit.txt", true);
            PrintStream yaz = new PrintStream(f);
            Scanner girdi = new Scanner(System.in);
            System.out.print("TC: ");
            String tc = girdi.next();
            yaz.print("\n" + tc + " ");
            System.out.print("Ad : ");
            String ad = girdi.next();
            yaz.print(ad + " ");
            System.out.print("Soyad: ");
            String soyad = girdi.next();
            yaz.print(soyad + " ");
            System.out.print("Okul No : ");
            String okulno = girdi.next();
            yaz.print(okulno + " ");
            System.out.print("Bolum : ");
            String bolum = girdi.next();
            yaz.print(bolum);
        } catch (IOException ex) {
            System.out.print("Kayit yapilamadi" + ex);
        }
    }

    @Override
    public void ogrenciSil() {
        Scanner girdi = new Scanner(System.in);
        System.out.print("Silinmek istenen ogrencinin TC no :");
        String tc = girdi.next();
        String filePath = "OgrenciKayit.txt";
        String removeTerm = tc;
        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String TC = "";
        String ad = "";
        String soyad = "";
        String no = "";
        String bolum = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File(filePath));

            while (x.hasNext()) {
                TC = x.next();
                ad = x.next();
                soyad = x.next();
                no = x.next();
                bolum = x.next();
                if (!TC.equals(removeTerm)) {
                    pw.println(TC + " " + ad + " " + soyad + " " + no + " " + bolum);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File temp2 = new File(filePath);
            newFile.renameTo(temp2);
        } catch (IOException e) {
            System.out.print("Ogrenci kaydi silinemedi" + e);
        }
    }

    @Override
    public void ogrenciListele() {
        try {
            FileInputStream fi = new FileInputStream("OgrenciKayit.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            String satir;
            while ((satir = buf.readLine()) != null) {
                System.out.println(satir);
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok" + f);
        } catch (IOException ex) {
            Logger.getLogger(OgrenciKayitIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Ders extends DersIslemleri {

    @Override
    public void dersProgramiHazirlama() {
        System.out.print("Ogrencinin sectigi dersler :\n");
        try {
            FileInputStream fi = new FileInputStream("SecilenDersler.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            String satir;
            ArrayList listeDersler = new ArrayList<>();
            while ((satir = buf.readLine()) != null) {
                System.out.println(satir);
                listeDersler.add(satir);
            }
            System.out.print("Ogrenci tarafindan secilen derslerin numarasina gore asagidaki ogretim uyelerini derslerle eslestiriniz...\n");
            System.out.print("Secebileceginiz ogretim uyeleri, saat ve gunler :\n");
            try {
                FileInputStream f = new FileInputStream("OgretimUyeleri.txt");
                BufferedReader bf = new BufferedReader(new InputStreamReader(f));
                String satir2;
                ArrayList listeOgrUye = new ArrayList<>();
                while ((satir2 = bf.readLine()) != null) {
                    System.out.println(satir2);
                    listeOgrUye.add(satir2);
                }
                listeler(listeDersler, listeOgrUye);
            } catch (FileNotFoundException f) {
                System.out.println("dosya yok"+f);
            } catch (IOException ioex) {
                System.out.println("başka bir hata oldu"+ioex);
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok"+f);
        } catch (IOException ioex) {
            System.out.println("başka bir hata oldu"+ioex);
        }
    }

    public static void listeler(ArrayList listeDersler, ArrayList listeOgrUye) {

        try {
            FileOutputStream f = new FileOutputStream("DersProgrami.txt", true);
            PrintStream yaz = new PrintStream(f);
            for (int i = 0; i < listeDersler.size(); i++) {
                System.out.print((i + 1) + ". ders icin : ");
                Scanner sc = new Scanner(System.in);
                int secim = sc.nextInt();
                if (((String) listeOgrUye.get(i)).contains(String.valueOf(secim))) {
                    System.out.println(listeDersler.get(i) + " " + listeOgrUye.get(secim - 1));
                    yaz.println(listeDersler.get(i) + " " + listeOgrUye.get(secim - 1));
                } else {
                    System.out.println("Lutfen sadece 1-5 arasindaki sayilardan birini giriniz!");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("hata"+e);
        }
    }
}

class Ogrenci implements OgrenciI {

    @Override
    public void dersProgramiListele() {
        try {
            FileInputStream fi = new FileInputStream("DersProgrami.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            String satir;
            while ((satir = buf.readLine()) != null) {
                System.out.println(satir);
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok" + f);
        } catch (IOException ex) {
            System.out.println("başka bir hata oldu" + ex);
        }
    }

    @Override
    public void notListele() {
        try {
            FileInputStream fi = new FileInputStream("SinavNotlari.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            String satir;
            while ((satir = buf.readLine()) != null) {
                System.out.println(satir);
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok" + f);
        } catch (IOException ex) {
            System.out.println("başka bir hata oldu" + ex);
        }
    }
}

class NotIslemleri implements OgretimUyesiI {

    @Override
    public void notGirme() {
        System.out.print("Ogrencinin sectigi derslere gore vize ve final notlarini giriniz...\n");
        try {
            FileInputStream fi = new FileInputStream("SecilenDersler.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            ArrayList listeDersler = new ArrayList<String>();
            String satir;
            while ((satir = buf.readLine()) != null) {
                System.out.println(satir);
                listeDersler.add(satir);
            }
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + ". ders icin vize notu :\n");
                Scanner sc = new Scanner(System.in);
                int vize = sc.nextInt();
                System.out.print((i + 1) + ". ders icin final notu :\n");
                Scanner scn = new Scanner(System.in);
                int finaln = scn.nextInt();
                try {
                    FileOutputStream f = new FileOutputStream("SinavNotlari.txt", true);
                    PrintStream yaz = new PrintStream(f);
                    yaz.print(listeDersler.get(i) + " : vize = " + vize + ", final = " + finaln + "\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok" + f);
        } catch (IOException ioex) {
            System.out.println("başka bir hata oldu" + ioex);
        }
    }

    @Override
    public void harfNotuBelirleme() {
        try {
            FileInputStream fi = new FileInputStream("SecilenDersler.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            ArrayList listeDers = new ArrayList<String>();
            String satir;
            while ((satir = buf.readLine()) != null) {
                listeDers.add(satir);
            }
            ArrayList listeHarf = new ArrayList<String>();
            listeHarf.add("AA = ");
            listeHarf.add("BA = ");
            listeHarf.add("BB = ");
            listeHarf.add("CB = ");
            listeHarf.add("CC = ");
            listeHarf.add("KALDI");
            System.out.println("Dersler icin belirlediginiz harf notlarini giriniz...");
            try {
                FileOutputStream f = new FileOutputStream("HarfNotu.txt", true);
                PrintStream yaz = new PrintStream(f);
                for (int i = 0; i < listeDers.size(); i++) {
                    System.out.println(listeDers.get(i) + ": ");
                    for (int j = 0; j < listeHarf.size(); j++) {
                        System.out.print(listeHarf.get(j));
                        Scanner sc = new Scanner(System.in);
                        int not1 = sc.nextInt();
                        int not2 = sc.nextInt();
                        System.out.println(not1 + "-" + not2);
                        yaz.println(listeDers.get(i) + ": " + listeHarf.get(j) + not1 + "-" + not2);
                    }
                }
            } catch (IOException e) {
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok"+f);
        } catch (IOException ioex) {
            System.out.println("başka bir hata oldu"+ioex);
        }
    }
}

class Yoklama extends OgrenciIslemleri {

    @Override
    public void yoklamaAl() {
        try {
            FileInputStream fi = new FileInputStream("OgrenciKayit.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
            ArrayList listeOgr = new ArrayList<>();
            String satir;
            while ((satir = buf.readLine()) != null) {
                listeOgr.add(satir);
            }
            System.out.println("Derste olan ogrenci icin 1, olmayan icin 0 yaziniz...");
            try {
                FileOutputStream f = new FileOutputStream("Yoklama.txt", true);
                PrintStream yaz = new PrintStream(f);
                for (int i = 0; i < listeOgr.size(); i++) {
                    System.out.println(listeOgr.get(i) + ": ");
                    Scanner sc = new Scanner(System.in);
                    int yoklama = sc.nextInt();
                    if (yoklama != 0 && yoklama != 1) {
                        System.out.println("Sadece 0 ve 1 sayilarindan birini girebilirsiniz, tekrar deneyiniz!");
                        yoklamaAl();
                    }
                    if (yoklama == 1) {
                        yaz.println(listeOgr.get(i) + ": var");
                    } else if (yoklama == 0) {
                        yaz.println(listeOgr.get(i) + ": yok");
                    }
                }
            } catch (IOException e) {
            }
        } catch (FileNotFoundException f) {
            System.out.println("dosya yok" + f);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
