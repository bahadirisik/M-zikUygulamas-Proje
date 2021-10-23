package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    private static Connection con=null;
    private String gad,gSanatci_ad,gTur,kullanici_adii,Sarki,ekle_sanatci,kullanici_profil_isim;
    private int kullanici_id;
    private int ekleSid;
    private String profil_sarki,album_ad1;

    public String getAlbum_ad1() {
        return album_ad1;
    }

    public void setAlbum_ad1(String album_ad1) {
        this.album_ad1 = album_ad1;
    }

    public String getProfil_sarki() {
        return profil_sarki;
    }

    public void setProfil_sarki(String profil_sarki) {
        this.profil_sarki = profil_sarki;
    }

    public String getKullanici_profil_isim() {
        return kullanici_profil_isim;
    }

    public void setKullanici_profil_isim(String kullanici_profil_isim) {
        this.kullanici_profil_isim = kullanici_profil_isim;
    }

    public String getEkle_sanatci() {
        return ekle_sanatci;
    }

    public void setEkle_sanatci(String ekle_sanatci) {
        this.ekle_sanatci = ekle_sanatci;
    }

    public int getEkleSid() {
        return ekleSid;
    }

    public void setEkleSid(int ekleSid) {
        this.ekleSid = ekleSid;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getSarki() {
        return Sarki;
    }

    public void setSarki(String sarki) {
        Sarki = sarki;
    }

    public String getKullanici_adii() {
        return kullanici_adii;
    }

    public void setKullanici_adii(String kullanici_adii) {
        this.kullanici_adii = kullanici_adii;
    }

    public String getGad() {
        return gad;
    }

    public void setGad(String gad) {
        this.gad = gad;
    }

    public String getgSanatci_ad() {
        return gSanatci_ad;
    }

    public void setgSanatci_ad(String gSanatci_ad) {
        this.gSanatci_ad = gSanatci_ad;
    }

    public String getgTur() {
        return gTur;
    }

    public void setgTur(String gTur) {
        this.gTur = gTur;
    }

    @FXML
    private Label takip_et_hata;
    @FXML
    private Label profil_var;
    @FXML
    private Label profil_eklendi;
    @FXML
    private Label add_gir;
    @FXML
    private Label zaten_var;
    @FXML
    private Label takip_label_1;
    @FXML
    private Label kayıt_hata;
    @FXML
    private Label admin_hata;
    @FXML
    private Label Silme_hata;
    @FXML
    private Label kayit_hata;
    @FXML
    private Label kullanici_hata;
    @FXML
    private Label isim;
    @FXML
    private Label sanatci_hata;
    @FXML
    private Label profil_label2;
    @FXML
    private Label Sarki_var;
    @FXML
    private Label at_label;
    @FXML
    private Label tur_label;
    @FXML
    private Label label2;
    @FXML
    private Label Sarki_eklendi;
    @FXML
    private Button kullanici_buton;
    @FXML
    private ListView liste;
    @FXML
    private ListView tum_sarkilar_list;
    @FXML
    private ListView Takip_edilen_list;
    @FXML
    private ListView tr_top_10;
    @FXML
    private ListView abd_top_10;
    @FXML
    private ListView al_top_10;
    @FXML
    private ListView arama_sonuclari;
    @FXML
    private ListView ing_top_10;
    @FXML
    private ListView profil_jazz;
    @FXML
    private ListView profil_pop;
    @FXML
    private ListView takip_edilenler;
    @FXML
    private ListView album_sarki_list;
    @FXML
    private ListView album_list;
    @FXML
    private ListView profil_klasic;
    @FXML
    private ListView tum_sarkilar1;
    @FXML
    private Button admin_buton;
    @FXML
    private AnchorPane sahne1;
    @FXML
    private AnchorPane ulkeler_top_10_sahne;
    @FXML
    private AnchorPane profil_calma_list_sahne;
    @FXML
    private AnchorPane ekle_fazla;
    @FXML
    private AnchorPane sanatci_sahne_gir;
    @FXML
    private AnchorPane sahne4;
    @FXML
    private AnchorPane kullanici_profil;
    @FXML
    private AnchorPane album_sahne;
    @FXML
    private AnchorPane asifre_sahne;
    @FXML
    private AnchorPane Sarki_ekle_sahne;
    @FXML
    private AnchorPane Sarki_sil_sahne;
    @FXML
    private AnchorPane sahne2;
    @FXML
    private AnchorPane sahne3;
    @FXML
    private AnchorPane album_list_sahne;
    @FXML
    private AnchorPane kayit_sahne;
    @FXML
    private AnchorPane tum_sarkilar_sahne;
    @FXML
    private AnchorPane Sarki_guncelle_sahne;
    @FXML
    private AnchorPane arama_sonuclari_sahne;
    @FXML
    private AnchorPane ksifre_sahne;
    @FXML
    private AnchorPane sahne5;
    @FXML
    private TextField admin_giris;
    @FXML
    private TextField sure_gir;
    @FXML
    private TextField tarih_gir;
    @FXML
    private TextField sayi_gir;
    @FXML
    private TextField kullanici_ara;
    @FXML
    private TextField sad_gir;
    @FXML
    private TextField ulke_gir;
    @FXML
    private TextField album_ad;
    @FXML
    private TextField gsarki_adi;
    @FXML
    private TextField yetki;
    @FXML
    private TextField gsanatci_adi;
    @FXML
    private TextField gsarki_turu;
    @FXML
    private TextField gsarki_adi1;
    @FXML
    private TextField gsanatci_adi1;
    @FXML
    private TextField kayit_ad;
    @FXML
    private TextField kayit_sifre;
    @FXML
    private TextField gsarki_turu1;
    @FXML
    private TextField Sarki_adi_al;
    @FXML
    private TextField Sanatci_adi_al;
    @FXML
    private TextField Tur_al;
    @FXML
    private TextField Sarki_adi_al1;
    @FXML
    private TextField Sanatci_adi_al1;
    @FXML
    private TextField admin_sifre;
    @FXML
    private Button agiris_buton;
    @FXML
    private TextField kullanici_giris;
    @FXML
    private TextField kullanici_sifre;
    public void sqlac()
    {
        String link="jdbc:mysql://localhost:3306/proje3"+"?useUnicode=true&characterEncoding=utf8";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("driver bulunamadı");
        }
        try {
            con = DriverManager.getConnection(link,"root","");
            System.out.println("bağlandı");
        } catch (SQLException throwables) {
            System.out.println("veri tabanına bağlanamadı");
        }
    }

    public void Admin_mouse(MouseEvent mouseEvent)
    {
        asifre_sahne.setVisible(true);
        ksifre_sahne.setVisible(false);
        kullanici_hata.setVisible(false);
    }
    public void Kullanici_mouse(MouseEvent mouseEvent)
    {
        asifre_sahne.setVisible(false);
        ksifre_sahne.setVisible(true);
        admin_hata.setVisible(false);

    }
    public void agiris(MouseEvent mouseEvent)
    {
        sqlac();
        String ad_girilen=admin_giris.getText().trim();
        String parola_girilen=admin_sifre.getText().trim();
        String sorgu="Select * From giris where";
        String sorgu1=sorgu+" Kullanici_adi='"+ad_girilen+"' and Sifre='"+parola_girilen+"' and Yetki='Admin'";
        System.out.println(sorgu1);
        try {
            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            if(rs.next())
            {
                sahne1.setVisible(false);
                sahne2.setVisible(true);
                tum_sarkilar1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        setProfil_sarki(newValue);
                    }
                });

            }
            else
            {
                admin_hata.setVisible(true);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Kayit_ol(MouseEvent mouseEvent)
    {
        sahne1.setVisible(false);
        kayit_sahne.setVisible(true);
    }
    public void Kayit_ol1(MouseEvent mouseEvent)
    {
        sqlac();
        String ad=kayit_ad.getText().trim();
        String parola=kayit_sifre.getText().trim();
        String yetki1=yetki.getText().trim();
        String sorgu="Select * From giris where";
        String sorgu1=sorgu+" Kullanici_adi='"+ad+"' and Sifre='"+parola+"'";
        System.out.println(ad);
        System.out.println(yetki1);
        System.out.println(parola);
        String sorgu2="INSERT INTO `giris` (`Kid`, `Kullanici_adi`, `Sifre`, `Yetki`) VALUES ";
        try {
            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            if(rs.next())
            {
                kayit_hata.setVisible(true);
            }
            else
            {
                if(parola.equals(""))
                {
                    kayit_hata.setVisible(true);
                }
                else
                {
                    if(yetki1.equals("Premium")||yetki1.equals("Kullanici"))
                    {
                        Statement a1= con.createStatement();
                        String sorgu3=sorgu2+"(NULL, '"+ad+"' , '"+parola+"' , '"+yetki1+"')";
                        a1.executeUpdate(sorgu3);
                        sahne4.setVisible(false);
                        sahne1.setVisible(true);
                        kayıt_hata.setVisible(false);
                    }
                    else {
                        kayıt_hata.setVisible(true);
                    }

                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void anasayfaya_geri(MouseEvent mouseEvent)
    {
        while(tum_sarkilar_list.getItems().size()!=0)
        {
            tum_sarkilar_list.getItems().remove(0);
        }
        Sarki_eklendi.setVisible(false);
        Sarki_var.setVisible(false);
        tum_sarkilar_sahne.setVisible(false);
        sahne4.setVisible(true);

    }
    public void tum_sarkilar(MouseEvent mouseEvent)
    {
        sqlac();
        label2.setText("Tüm");
        label2.setTextFill(Color.WHITE);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setStyle("-fx-font: 18 reguler;");
        sahne4.setVisible(false);
        tum_sarkilar_sahne.setVisible(true);

        String sorgu1="Select * From sarkilar ";
        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            while (rs.next())
            {
                String b=rs.getString("Sarki_adi");
                String c=rs.getString("Sanatci");
                int d = rs.getInt("Tur");
                String sorgu2="SELECT * FROM turler where Tid="+d;
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu2);
                if(rs1.next())
                {

                    String e = rs1.getString("Tur_ad");
                    String hepsi = b+"    "+c+"    "+e;
                    tum_sarkilar_list.getItems().add(hepsi);

                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void Kullanici_sarki_ekle(MouseEvent mouseEvent) {

        sqlac();
        System.out.println(getSarki());
        String[] arrSplit = getSarki().split("    ");
        String Tur_sorgu = "Select * From turler where";
        String Tur_sorgu1 = Tur_sorgu + " Tur_ad='" + arrSplit[2] + "'";
        String sorgu1 = "SELECT * FROM sarkilar";
        String sorgu7 = "SELECT * FROM sarkilar where Sarki_adi='" + arrSplit[0] + "' and Sanatci='" + arrSplit[1] + "'";
        String sorgu8="INSERT INTO `kullanicilarin_sarkilari` (`a`, `Kid`, `sid`) VALUES ";
        int Tid = 0;
        int Sid = 0;
        try {
            Statement a2 = con.createStatement();
            ResultSet rs2 = a2.executeQuery(Tur_sorgu1);
            if (rs2.next()) {
                Tid = rs2.getInt("Tid");
            }
            Statement a3 = con.createStatement();
            ResultSet rs3 = a3.executeQuery(sorgu7);
            if (rs3.next()) {
                Sid = rs3.getInt("sid");
            }
            String sorgu9=sorgu8+"("+null+", '"+getKullanici_id()+"', '"+Sid+"')";
            String Varmi="Select * From kullanicilarin_sarkilari where Kid='"+getKullanici_id()+"' and sid='"+Sid+"'";
            Statement a1= con.createStatement();
            ResultSet rs1 = a1.executeQuery(Varmi);
            if(rs1.next())
            {
                Sarki_var.setVisible(true);
                Sarki_eklendi.setVisible(false);
            }
            else
            {
                Sarki_eklendi.setVisible(true);
                Sarki_var.setVisible(false);
                a1.executeUpdate(sorgu9);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void kgiris(MouseEvent mouseEvent)
    {
        sqlac();
        String ad_girilen=kullanici_giris.getText().trim();
        String parola_girilen=kullanici_sifre.getText().trim();
        String sorgu="Select * From giris where";
        String sorgu1=sorgu+" Kullanici_adi='"+ad_girilen+"' and Sifre='"+parola_girilen+"' and Yetki!='Admin'";
        System.out.println(sorgu1);
        setKullanici_adii(ad_girilen);
        try {
            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            if(rs.next())
            {
                int ab=rs.getInt("Kid");
                setKullanici_id(ab);
                kayit_sahne.setVisible(false);

                isim.setText("   "+getKullanici_adii());
                isim.setTextFill(Color.WHITE);

                tum_sarkilar_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    setSarki(newValue);
                }
            });
                arama_sonuclari.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                       setKullanici_profil_isim(newValue);
                    }
                });
                profil_jazz.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        setProfil_sarki(newValue);
                    }
                });
                profil_pop.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        setProfil_sarki(newValue);
                    }
                });
                profil_klasic.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        setProfil_sarki(newValue);
                    }
                });
                album_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        setAlbum_ad1(newValue);
                    }
                });
                album_sarki_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        setProfil_sarki(newValue);
                    }
                });
                String sorgu2="Select * From takip where takip_eden='"+getKullanici_id()+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu2);
                while (rs1.next())
                {
                    int t=rs1.getInt("takip_edilen");
                    System.out.println(t);
                    String sorgu3="Select * From giris where Kid='"+t+"'";
                    Statement a2= con.createStatement();
                    ResultSet rs2 = a2.executeQuery(sorgu3);
                    if(rs2.next())
                    {
                        String ad=rs2.getString("Kullanici_adi");
                        takip_edilenler.getItems().add(ad);
                    }
                }
                sahne1.setVisible(false);
                sahne4.setVisible(true);

            }
            else
            {
                kullanici_hata.setVisible(true);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void Sarki_ekle(MouseEvent mouseEvent)
    {
        Sarki_ekle_sahne.setVisible(true);
        Sarki_sil_sahne.setVisible(false);
        Sarki_guncelle_sahne.setVisible(false);
    }
    public void Sarki_sil(MouseEvent mouseEvent)
    {
        Sarki_ekle_sahne.setVisible(false);
        Sarki_sil_sahne.setVisible(true);
        Sarki_guncelle_sahne.setVisible(false);
    }
    public void Sarki_guncelle(MouseEvent mouseEvent)
    {
        Sarki_ekle_sahne.setVisible(false);
        Sarki_sil_sahne.setVisible(false);
        Sarki_guncelle_sahne.setVisible(true);
    }
    public void Sarki_ekle_oke(MouseEvent mouseEvent)
    {
        sqlac();
        String ad=Sarki_adi_al.getText().trim();
        String Sanatci_ad=Sanatci_adi_al.getText().trim();
        setEkle_sanatci(Sanatci_ad);
        String Tur=Tur_al.getText().trim();
        String Tur_sorgu="Select * From turler where";
        String Tur_sorgu1=Tur_sorgu+" Tur_ad='"+Tur+"'";
        String sorgu="INSERT INTO `sarkilar` (`Sarki_adi`, `Sanatci`, `Tur`) VALUES ";
        String varmi="Select * From sarkilar where "+"Sarki_adi='"+ad+"' and Sanatci='"+Sanatci_ad+"'";
        int Tid = 0;
        try {
            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(Tur_sorgu1);
            Statement a2= con.createStatement();
            ResultSet rs2 = a2.executeQuery(varmi);
            if(rs2.next())
            {
               zaten_var.setVisible(true);
            }
            else
            {
                if(rs.next())
                {
                    Tid=rs.getInt("Tid");
                    System.out.println(Tid);
                }
                String sorgu1=sorgu+"('"+ad+"' , '"+Sanatci_ad+"' , "+Tid+")";
                Statement a1= con.createStatement();
                a1.executeUpdate(sorgu1);
                String sorgu2="Select * From sarkilar where "+"Sarki_adi='"+ad+"' and Sanatci='"+Sanatci_ad+"'";
                ResultSet rs1=a1.executeQuery(sorgu2);
                if(rs1.next())
                {
                    setEkleSid(rs1.getInt("sid"));
                    System.out.println(getEkleSid());
                }
                sahne2.setVisible(false);
                ekle_fazla.setVisible(true);
                zaten_var.setVisible(false);
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Sarki_sil_oke(MouseEvent mouseEvent)
    {
        sqlac();
        String ad=Sarki_adi_al1.getText().trim();
        String Sanatci_ad=Sanatci_adi_al1.getText().trim();
        String sorgu="Select * From sarkilar where "+"Sarki_adi='"+ad+"' and Sanatci='"+Sanatci_ad+"'";
        System.out.println(sorgu);


        try {
            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu);
            if(rs.next())
            {
                System.out.println("sildi");
                int Sid = rs.getInt("sid");
                String silme= "DELETE FROM `sarkilar`  WHERE `sarkilar`.`sid` ="+Sid;
                String silme2="DELETE FROM `sarki_bilgileri` WHERE `sarki_bilgileri`.`sid` ="+Sid;
                String silme3="DELETE FROM `kullanicilarin_sarkilari` WHERE `kullanicilarin_sarkilari`.`sid` ="+Sid;
                String silme4="DELETE FROM `album_icerik` WHERE `album_icerik`.`sid` ="+Sid;
                System.out.println(silme);
                a.executeUpdate(silme);
                a.executeUpdate(silme2);
                a.executeUpdate(silme3);
                a.executeUpdate(silme4);
            }
            else
            {
                Silme_hata.setVisible(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Sarki_guncelleme_oke(MouseEvent mouseEvent)
    {
       setGad(gsarki_adi.getText().trim());
       setgSanatci_ad(gsanatci_adi.getText().trim());
       setgTur(gsarki_turu.getText().trim());
       sahne2.setVisible(false);
       sahne3.setVisible(true);
    }
    public void Geri_buton (MouseEvent mouseEvent)
    {
        sahne2.setVisible(true);
    }
    public void Sarki_guncelleme_oke1(MouseEvent mouseEvent)
    {
        sqlac();
        String ad=gsarki_adi1.getText().trim();
        String Sanatci_ad=gsanatci_adi1.getText().trim();
        String tur=gsarki_turu1.getText().trim();
        String Tur_sorgu="Select * From turler where";
        String Tur_sorgu1=Tur_sorgu+" Tur_ad='"+tur+"'";
        String sorgu1="SELECT * FROM sarkilar";
        String sorgu7="SELECT * FROM sarkilar where Sarki_adi='"+getGad()+"' and Sanatci='"+getgSanatci_ad()+"'";
        int Tid = 0;
        int Sid= 0;
        try {
            Statement a2= con.createStatement();
            ResultSet rs2 = a2.executeQuery(Tur_sorgu1);
            if(rs2.next())
            {
                Tid=rs2.getInt("Tid");
                System.out.println(Tid);
            }
            Statement a3= con.createStatement();
            ResultSet rs3 = a3.executeQuery(sorgu7);
            if(rs3.next())
            {
                Sid=rs3.getInt("sid");
            }

            String guncelleme="UPDATE `sarkilar` SET `Sarki_adi` = '"+ad+"', `Sanatci` = '"+Sanatci_ad+"', `Tur` = '"+Tid+"' WHERE `sarkilar`.`sid` = "+Sid;

            a3.executeUpdate(guncelleme);

                Statement a= con.createStatement();
                ResultSet rs = a.executeQuery(sorgu1);
                while (rs.next())
                {
                    String b=rs.getString("Sarki_adi");
                    String c=rs.getString("Sanatci");
                    int d = rs.getInt("Tur");
                    String sorgu2="SELECT * FROM turler where Tid="+d;
                    Statement a1= con.createStatement();
                    ResultSet rs1 = a1.executeQuery(sorgu2);
                    if(rs1.next())
                    {
                        String e = rs1.getString("Tur_ad");
                        String hepsi = b+"       "+c+"          "+e;
                        liste.getItems().add(hepsi);

                    }
                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void jazz_calma_list(MouseEvent mouseEvent){


        sqlac();
        sahne4.setVisible(false);
        sahne5.setVisible(true);

        String sorgu1="Select * From kullanicilarin_sarkilari where Kid='"+getKullanici_id()+"'";
        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            while (rs.next())
            {
                int Sid = rs.getInt("sid");
                String sorgu2="Select * From sarkilar where sid='"+Sid+"' and Tur='"+201+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu2);
                if(rs1.next())
                {
                    String ad = rs1.getString("Sarki_adi");
                    String sanatci = rs1.getString("Sanatci");
                    String hepsi = ad+"      "+sanatci;
                    tur_label.setText("Jazz");
                    tur_label.setTextFill(Color.WHITE);
                    tur_label.setAlignment(Pos.CENTER_RIGHT);
                    tur_label.setStyle("-fx-font: 18 reguler;");
                    Takip_edilen_list.getItems().add(hepsi);
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void sahne5_geri(MouseEvent mouseEvent) {

        while(Takip_edilen_list.getItems().size()!=0)
        {
            Takip_edilen_list.getItems().remove(0);
        }
        sahne5.setVisible(false);
        sahne4.setVisible(true);
    }
    public void pop_calma_list(MouseEvent mouseEvent){
        sqlac();
        sahne4.setVisible(false);
        sahne5.setVisible(true);

        String sorgu1="Select * From kullanicilarin_sarkilari where Kid='"+getKullanici_id()+"'";
        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            while (rs.next())
            {
                int Sid = rs.getInt("sid");
                String sorgu2="Select * From sarkilar where sid='"+Sid+"' and Tur='"+200+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu2);
                if(rs1.next())
                {
                    String ad = rs1.getString("Sarki_adi");
                    String sanatci = rs1.getString("Sanatci");
                    String hepsi = ad+"      "+sanatci;
                    tur_label.setText("Pop");
                    tur_label.setTextFill(Color.WHITE);
                    tur_label.setAlignment(Pos.CENTER_RIGHT);
                    tur_label.setStyle("-fx-font: 18 reguler;");
                    Takip_edilen_list.getItems().add(hepsi);
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void klasic_calma_list(MouseEvent mouseEvent) {
        sqlac();
        sahne4.setVisible(false);
        sahne5.setVisible(true);

        String sorgu1="Select * From kullanicilarin_sarkilari where Kid='"+getKullanici_id()+"'";
        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            while (rs.next())
            {
                int Sid = rs.getInt("sid");
                String sorgu2="Select * From sarkilar where sid='"+Sid+"' and Tur='"+202+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu2);
                if(rs1.next())
                {
                    String ad = rs1.getString("Sarki_adi");
                    String sanatci = rs1.getString("Sanatci");
                    String hepsi = ad+"      "+sanatci;
                    tur_label.setText("Klasic");
                    tur_label.setTextFill(Color.WHITE);
                    tur_label.setAlignment(Pos.CENTER_RIGHT);
                    tur_label.setStyle("-fx-font: 18 reguler;");
                    Takip_edilen_list.getItems().add(hepsi);
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void jazz_top_10(MouseEvent mouseEvent) {
              sqlac();
        label2.setText("Jazz Top 10 ");
        label2.setTextFill(Color.WHITE);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setStyle("-fx-font: 18 reguler;");
              tum_sarkilar_sahne.setVisible(true);
              sahne4.setVisible(false);
              String sorgu1 = "Select *  From sarki_bilgileri ORDER BY Dinlenme_Sayisi DESC LIMIT 10000000000000000 ";

        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            int sayac=0;
            while (rs.next())
            {
                if(sayac==10)
                {
                    break;
                }
                int Sid = rs.getInt("sid");
                int sayi= rs.getInt("Dinlenme_Sayisi");
                String sorgu = "Select * From sarkilar where sid='"+Sid+"' and Tur='"+201+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu);
                if(rs1.next())
                {
                    String b = rs1.getString("Sarki_adi");
                    String c = rs1.getString("Sanatci");
                    String s=Integer.toString(sayi);
                    String hepsi = b+"    "+c+ "    "+s;
                    tum_sarkilar_list.getItems().add(hepsi);
                    sayac++;
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void pop_top_10(MouseEvent mouseEvent) {
        sqlac();
        label2.setText("Pop Top 10 ");
        label2.setTextFill(Color.WHITE);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setStyle("-fx-font: 18 reguler;");
        tum_sarkilar_sahne.setVisible(true);
        sahne4.setVisible(false);
        String sorgu1 = "Select *  From sarki_bilgileri ORDER BY Dinlenme_Sayisi DESC LIMIT 10000000000000000 ";

        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            int sayac=0;
            while (rs.next())
            {
                if(sayac==10)
                {
                    break;
                }
                int Sid = rs.getInt("sid");
                int sayi= rs.getInt("Dinlenme_Sayisi");
                String sorgu = "Select * From sarkilar where sid='"+Sid+"' and Tur='"+200+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu);
                if(rs1.next())
                {
                    String b = rs1.getString("Sarki_adi");
                    String c = rs1.getString("Sanatci");
                    String s=Integer.toString(sayi);
                    String hepsi = b+"    "+c+ "    "+s;
                    tum_sarkilar_list.getItems().add(hepsi);
                    sayac++;
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void klasic_top_10(MouseEvent mouseEvent) {
        sqlac();
        label2.setText("Klasic Top 10");
        label2.setTextFill(Color.WHITE);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setStyle("-fx-font: 18 reguler;");
        tum_sarkilar_sahne.setVisible(true);
        sahne4.setVisible(false);
        String sorgu1 = "Select *  From sarki_bilgileri ORDER BY Dinlenme_Sayisi DESC LIMIT 10000000000000000 ";

        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            int sayac=0;
            while (rs.next())
            {
                if(sayac==10)
                {
                    break;
                }
                int Sid = rs.getInt("sid");
                int sayi= rs.getInt("Dinlenme_Sayisi");
                String sorgu = "Select * From sarkilar where sid='"+Sid+"' and Tur='"+202+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu);
                if(rs1.next())
                {
                    String b = rs1.getString("Sarki_adi");
                    String c = rs1.getString("Sanatci");
                    String s=Integer.toString(sayi);
                    String hepsi = b+"    "+c+ "    "+s;
                    tum_sarkilar_list.getItems().add(hepsi);
                    sayac++;
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void dunya_top_10(MouseEvent mouseEvent) {
        sqlac();
        label2.setText("Dunya Top 10");
        label2.setTextFill(Color.WHITE);
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setStyle("-fx-font: 18 reguler;");
        tum_sarkilar_sahne.setVisible(true);
        sahne4.setVisible(false);
        String sorgu1 = "Select *  From sarki_bilgileri ORDER BY Dinlenme_Sayisi DESC LIMIT 10000000000000000 ";
        int sayac=0;
        try {

            Statement a= con.createStatement();
            ResultSet rs = a.executeQuery(sorgu1);
            while (rs.next())
            {
                if(sayac==10)
                {
                    break;
                }
                int Sid = rs.getInt("sid");
                int sayi= rs.getInt("Dinlenme_Sayisi");
                String sorgu = "Select * From sarkilar where sid='"+Sid+"'";
                Statement a1= con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu);
                if(rs1.next())
                {
                    String b = rs1.getString("Sarki_adi");
                    String c = rs1.getString("Sanatci");
                    String s=Integer.toString(sayi);
                    String hepsi = b+"   "+c+ "    "+s;
                    tum_sarkilar_list.getItems().add(hepsi);
                }
                sayac++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void tarih_yukle(MouseEvent mouseEvent) {
        sqlac();
        String sure=sure_gir.getText().trim();
        String tarih=tarih_gir.getText().trim();
        String dinlenme=sayi_gir.getText().trim();
        int i=Integer.valueOf(dinlenme);
        String sorgu="INSERT INTO `sarki_bilgileri` (`a`, `sid`, `Sure`, `Tarih`, `Dinlenme_Sayisi`) VALUES ("+null+", '"+getEkleSid()+"', '"+sure+"', '"+tarih+"', '"+i+"')";
        try {

            Statement a= con.createStatement();
            a.executeUpdate(sorgu);
            String sorgu1="Select * From sanatci where sanatci_adi='"+getEkle_sanatci()+"'";
            ResultSet rs1 = a.executeQuery(sorgu1);
            if(rs1.next())
            {
                sanatci_hata.setVisible(false);

            }
            else
            {
                sanatci_hata.setVisible(true);
                sanatci_sahne_gir.setVisible(true);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void admin_sayfa_geri(MouseEvent mouseEvent) {
        ekle_fazla.setVisible(false);
        sahne2.setVisible(true);
        sanatci_hata.setVisible(false);
        sanatci_sahne_gir.setVisible(false);

    }
    public void sanatci_yukle(MouseEvent mouseEvent) {
        sqlac();
        try {

            Statement a= con.createStatement();
            String ad=sad_gir.getText().trim();
            String ulke=ulke_gir.getText().trim();
            String sorgu2="INSERT INTO `sanatci` (`sanatci_id`, `sanatci_adi`, `ulkesi`) VALUES ("+null+", '"+ad+"', '"+ulke+"')";
            a.executeUpdate(sorgu2);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void ulkeler_top_10(MouseEvent mouseEvent) {
            sqlac();
            String sorgu="Select * From sarkilar";
            String sorgu1 = "Select *  From sarki_bilgileri ORDER BY Dinlenme_Sayisi DESC LIMIT 10000000000000000 ";
        try {

            Statement a= con.createStatement();
            ResultSet rs=a.executeQuery(sorgu1);
            int tut=0,tut1=0,tut2=0,tut3=0;
            while (rs.next())
            {
                int  Sid = rs.getInt("sid");
                String sorgu2="Select * From sarkilar where sid='"+Sid+"'";
                Statement a1= con.createStatement();
                ResultSet rs1=a1.executeQuery(sorgu2);
                if(rs1.next())
                {
                    String sanatci=rs1.getString("Sanatci");
                    String sorgu3="Select * From sanatci where sanatci_adi='"+sanatci+"'";
                    Statement a2= con.createStatement();
                    ResultSet rs2=a2.executeQuery(sorgu3);
                    if(rs2.next())
                    {
                        String ulke=rs2.getString("ulkesi");
                        if(ulke.equals("Türkiye")&&tut!=10)
                        {
                            String ad,sanatci1;
                            int dinlenme;
                            ad=rs1.getString("Sarki_adi");
                            sanatci1=rs1.getString("Sanatci");
                            dinlenme=rs.getInt("Dinlenme_Sayisi");
                            String s=Integer.toString(dinlenme);
                            String hepsi=ad+"  "+sanatci1+"  "+s;
                            tr_top_10.getItems().add(hepsi);
                            tut++;
                        }
                        else if(ulke.equals("ABD")&&tut1!=10)
                        {
                            String ad,sanatci1;
                            int dinlenme;
                            ad=rs1.getString("Sarki_adi");
                            sanatci1=rs1.getString("Sanatci");
                            dinlenme=rs.getInt("Dinlenme_Sayisi");
                            String s=Integer.toString(dinlenme);
                            String hepsi=ad+"  "+sanatci1+"  "+s;
                            abd_top_10.getItems().add(hepsi);
                            tut1++;
                        }
                        else if(ulke.equals("İngiltere")&&tut2!=10)
                        {
                            String ad,sanatci1;
                            int dinlenme;
                            ad=rs1.getString("Sarki_adi");
                            sanatci1=rs1.getString("Sanatci");
                            dinlenme=rs.getInt("Dinlenme_Sayisi");
                            String s=Integer.toString(dinlenme);
                            String hepsi=ad+"  "+sanatci1+"  "+s;
                            ing_top_10.getItems().add(hepsi);
                            tut2++;
                        }
                        else if(ulke.equals("Almanya")&&tut3!=10)
                        {
                            String ad,sanatci1;
                            int dinlenme;
                            ad=rs1.getString("Sarki_adi");
                            sanatci1=rs1.getString("Sanatci");
                            dinlenme=rs.getInt("Dinlenme_Sayisi");
                            String s=Integer.toString(dinlenme);
                            String hepsi=ad+"  "+sanatci1+"  "+s;
                            al_top_10.getItems().add(hepsi);
                            tut3++;
                        }
                    }
                }

            }
            ulkeler_top_10_sahne.setVisible(true);
            sahne4.setVisible(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void ulkeler_geri(MouseEvent mouseEvent) {
        while(tr_top_10.getItems().size()!=0)
        {
            tr_top_10.getItems().remove(0);
        }
        while(abd_top_10.getItems().size()!=0)
        {
            abd_top_10.getItems().remove(0);
        }
        while(al_top_10.getItems().size()!=0)
        {
            al_top_10.getItems().remove(0);
        }
        while(ing_top_10.getItems().size()!=0)
        {
            ing_top_10.getItems().remove(0);
        }
        ulkeler_top_10_sahne.setVisible(false);
        sahne4.setVisible(true);
    }
    public void ara(MouseEvent mouseEvent) {
        sqlac();
        String kullanici_adi=kullanici_ara.getText().trim();
        at_label.setText(getKullanici_profil_isim());
        at_label.setTextFill(Color.WHITE);
        at_label.setAlignment(Pos.CENTER_RIGHT);
        at_label.setStyle("-fx-font: 14 reguler;");
        String sorgu="Select * From giris where Kullanici_adi LIKE '%"+kullanici_adi+"%'";
        System.out.println(sorgu);
        try {

            Statement a= con.createStatement();
            ResultSet rs= a.executeQuery(sorgu);
            while (rs.next())
            {
                String ad = rs.getString("Kullanici_adi");
                arama_sonuclari.getItems().add(ad);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        sahne4.setVisible(false);
        arama_sonuclari_sahne.setVisible(true);
    }
    public void go_profil(MouseEvent mouseEvent) {
        sqlac();
        arama_sonuclari_sahne.setVisible(false);
        kullanici_profil.setVisible(true);
        add_gir.setText(getKullanici_profil_isim());
        add_gir.setTextFill(Color.WHITE);
        add_gir.setAlignment(Pos.CENTER_RIGHT);
        add_gir.setStyle("-fx-font: 14 reguler;");
        int kullanici_id=getKullanici_id();
        String sorgu="Select * From giris where Kullanici_adi='"+getKullanici_profil_isim()+"'";
        try {

            Statement a= con.createStatement();
            ResultSet rs= a.executeQuery(sorgu);
           if(rs.next())
           {
               int id = rs.getInt("Kid");
               String sorgu2="Select * From takip where takip_eden='"+kullanici_id+"' and takip_edilen='"+id+"'";
               Statement a1= con.createStatement();
               ResultSet rs1= a1.executeQuery(sorgu2);
               if(rs1.next())
               {
                   takip_label_1.setVisible(true);
               }
               else
               {
                   takip_label_1.setVisible(false);
               }
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void arama_geri(MouseEvent mouseEvent) {
        while(arama_sonuclari.getItems().size()!=0)
        {
            arama_sonuclari.getItems().remove(0);
        }
        sahne4.setVisible(true);
        arama_sonuclari_sahne.setVisible(false);
    }
    public void takip_et(MouseEvent mouseEvent) {
        sqlac();
        String sorgu="Select * From giris where Kullanici_adi='"+getKullanici_profil_isim()+"'";
        try {

            Statement a= con.createStatement();
            ResultSet rs= a.executeQuery(sorgu);
            if(rs.next())
            {
                String yetki=rs.getString("Yetki");
                int id = rs.getInt("Kid");
                if(yetki.equals("Premium"))
                {
                    String sorgu2="Select * From takip where takip_eden='"+kullanici_id+"' and takip_edilen='"+id+"'";
                    Statement a1= con.createStatement();
                    ResultSet rs1= a1.executeQuery(sorgu2);
                    if(rs1.next())
                    {

                    }
                    else
                    {
                        String sorgu3="INSERT INTO `takip` (`a`, `takip_eden`, `takip_edilen`) VALUES ("+null+", '"+kullanici_id+"', '"+id+"')";
                        Statement a2= con.createStatement();
                        a2.executeUpdate(sorgu3);
                        String sorgu4="Select * From giris where Kid='"+id+"'";
                        Statement a4= con.createStatement();
                        ResultSet rs4= a4.executeQuery(sorgu4);
                        if(rs4.next())
                        {
                            String ad=rs4.getString("Kullanici_adi");
                            takip_edilenler.getItems().add(ad);
                        }
                        takip_label_1.setVisible(true);
                    }
                }
                else
                {
                        takip_et_hata.setVisible(true);
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void profil_geri(MouseEvent mouseEvent) {
        arama_sonuclari_sahne.setVisible(true);
        kullanici_profil.setVisible(false);
    }
    public void takip_cik(MouseEvent mouseEvent) {
        sqlac();
        String sorgu="Select * From giris where Kullanici_adi='"+getKullanici_profil_isim()+"'";
        try {
            Statement a= con.createStatement();
            ResultSet rs= a.executeQuery(sorgu);
            if(rs.next())
            {

                int id = rs.getInt("Kid");


                    String sorgu2="Select * From takip where takip_eden='"+kullanici_id+"' and takip_edilen='"+id+"'";
                    Statement a1= con.createStatement();
                    ResultSet rs1= a1.executeQuery(sorgu2);
                    if(rs1.next())
                    {
                        int yer=rs1.getInt("a");
                        String sorgu3 ="DELETE FROM `takip` WHERE `takip`.`a` ="+yer;
                        a1.executeUpdate(sorgu3);
                        String sorgu4="Select * From giris where Kid='"+id+"'";
                        Statement a4= con.createStatement();
                        ResultSet rs4= a4.executeQuery(sorgu4);
                        if(rs4.next())
                        {
                            String ad=rs4.getString("Kullanici_adi");
                            takip_edilenler.getItems().remove(ad);
                        }
                        takip_label_1.setVisible(false);
                    }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Profil_calma_list(MouseEvent mouseEvent) {
        sqlac();
        String sorgu="Select * From giris where Kullanici_adi='"+getKullanici_profil_isim()+"'";
        profil_label2.setText(getKullanici_profil_isim());
        profil_label2.setTextFill(Color.WHITE);
        profil_label2.setAlignment(Pos.CENTER_RIGHT);
        profil_label2.setStyle("-fx-font: 14 reguler;");
        try {
            Statement a= con.createStatement();
            ResultSet rs= a.executeQuery(sorgu);
            if(rs.next())
            {
                int kid = rs.getInt("Kid");
                String sorgu4="Select * From takip where takip_eden='"+getKullanici_id()+"' and takip_edilen='"+kid+"'";
                Statement a4= con.createStatement();
                ResultSet r4= a4.executeQuery(sorgu4);
                if(r4.next())
                {
                    String sorgu1="Select * From kullanicilarin_sarkilari where Kid='"+kid+"'";
                    Statement a1= con.createStatement();
                    ResultSet rs1= a1.executeQuery(sorgu1);
                    while (rs1.next())
                    {
                        int Sid=rs1.getInt("sid");
                        String sorgu2="Select * From sarkilar where sid='"+Sid+"'";
                        Statement a2= con.createStatement();
                        ResultSet rs2= a2.executeQuery(sorgu2);
                        if(rs2.next())
                        {
                            String sarki_adi=rs2.getString("Sarki_adi");
                            String sanatci=rs2.getString("Sanatci");
                            int tur=rs2.getInt("Tur");
                            String sorgu3="Select * From turler where Tid='"+tur+"'";
                            Statement a3= con.createStatement();
                            ResultSet rs3= a3.executeQuery(sorgu3);
                            if(rs3.next())
                            {
                                String Tur_adi=rs3.getString("Tur_ad");
                                if(Tur_adi.equals("Jazz"))
                                {
                                    String hepsi=sarki_adi+"   "+sanatci+"   "+Tur_adi;
                                    profil_jazz.getItems().add(hepsi);
                                }
                                else if(Tur_adi.equals("Pop"))
                                {
                                    String hepsi=sarki_adi+"   "+sanatci+"   "+Tur_adi;
                                    profil_pop.getItems().add(hepsi);
                                }
                                else if(Tur_adi.equals("Klasic"))
                                {
                                    String hepsi=sarki_adi+"   "+sanatci+"   "+Tur_adi;
                                    profil_klasic.getItems().add(hepsi);
                                }
                            }

                        }
                        else
                        {
                            System.out.println("Böyle bir şarkı yok");
                        }
                    }
                    kullanici_profil.setVisible(false);
                    profil_calma_list_sahne.setVisible(true);
                }
                else
                {
                    System.out.println("takip etmiyorsun");
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Profil_calma_list_geri(MouseEvent mouseEvent) {
        while(profil_pop.getItems().size()!=0)
        {
            profil_pop.getItems().remove(0);
        }
        while(profil_jazz.getItems().size()!=0)
        {
            profil_jazz.getItems().remove(0);
        }
        while(profil_klasic.getItems().size()!=0)
        {
            profil_klasic.getItems().remove(0);
        }
        profil_calma_list_sahne.setVisible(false);
        kullanici_profil.setVisible(true);

    }
    public void sarkilari_ekle(MouseEvent mouseEvent) {
        sqlac();
        System.out.println(getProfil_sarki());
        String[] arrSplit = getProfil_sarki().split("   ");
        String Tur_sorgu = "Select * From turler where";
        String Tur_sorgu1 = Tur_sorgu + " Tur_ad='" + arrSplit[2] + "'";
        String sorgu1 = "SELECT * FROM sarkilar";
        String sorgu7 = "SELECT * FROM sarkilar where Sarki_adi='" + arrSplit[0] + "' and Sanatci='" + arrSplit[1] + "'";
        String sorgu8="INSERT INTO `kullanicilarin_sarkilari` (`a`, `Kid`, `sid`) VALUES ";
        int Tid = 0;
        int Sid = 0;
        try {
            Statement a2 = con.createStatement();
            ResultSet rs2 = a2.executeQuery(Tur_sorgu1);
            if (rs2.next()) {
                Tid = rs2.getInt("Tid");
            }
            Statement a3 = con.createStatement();
            ResultSet rs3 = a3.executeQuery(sorgu7);
            if (rs3.next()) {
                Sid = rs3.getInt("sid");
            }
            String sorgu9=sorgu8+"("+null+", '"+getKullanici_id()+"', '"+Sid+"')";
            String Varmi="Select * From kullanicilarin_sarkilari where Kid='"+getKullanici_id()+"' and sid='"+Sid+"'";
            Statement a1= con.createStatement();
            ResultSet rs1 = a1.executeQuery(Varmi);
            if(rs1.next())
            {
                profil_var.setVisible(true);
                profil_eklendi.setVisible(false);
            }
            else
            {
                profil_eklendi.setVisible(true);
                profil_var.setVisible(false);
                a1.executeUpdate(sorgu9);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void admin_sonraki_sayfa(MouseEvent mouseEvent) {
        sqlac();
        try {
                String sorgu1="Select * From sarkilar";
                Statement a= con.createStatement();
                ResultSet rs = a.executeQuery(sorgu1);
                while (rs.next())
                {
                    String b=rs.getString("Sarki_adi");
                    String c=rs.getString("Sanatci");
                    int d = rs.getInt("Tur");
                    String sorgu2="SELECT * FROM turler where Tid="+d;
                    Statement a1= con.createStatement();
                    ResultSet rs1 = a1.executeQuery(sorgu2);
                    if(rs1.next())
                    {

                        String e = rs1.getString("Tur_ad");
                        String hepsi = b+"    "+c+"    "+e;
                        tum_sarkilar1.getItems().add(hepsi);

                    }
                }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            sahne2.setVisible(false);
            album_sahne.setVisible(true);

    }
    public void sorgula(MouseEvent mouseEvent) {
        sqlac();
        String album_add=album_ad.getText().trim();
        String sorgu = "Select * From album where Album_adi='"+album_add+"'";
        try {
            Statement a2 = con.createStatement();
            ResultSet rs2 = a2.executeQuery(sorgu);
            if(rs2.next())
            {
                System.out.println("var");
            }
            else
            {
                String sorgu1="INSERT INTO `album` (`Aid`, `Album_adi`) VALUES ("+null+", '"+album_add+"')";
                a2.executeUpdate(sorgu1);
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void album_ekle(MouseEvent mouseEvent) {
        sqlac();
        System.out.println(getProfil_sarki());
        String ad=album_ad.getText().trim();
        String[] arrSplit = getProfil_sarki().split("    ");
        for (int i = 0; i <3 ; i++) {
            System.out.println(arrSplit[i]);
        }
        String Tur_sorgu = "Select * From turler where";
        String Tur_sorgu1 = Tur_sorgu + " Tur_ad='" + arrSplit[2] + "'";
        String sorgu7 = "SELECT * FROM sarkilar where Sarki_adi='" + arrSplit[0] + "' and Sanatci='" + arrSplit[1] + "'";
        String sorgubul="SELECT * FROM album where Album_adi='"+ad+"'";

        int Tid = 0;
        int Sid = 0;
        try {
            Statement a2 = con.createStatement();
            ResultSet rs2 = a2.executeQuery(Tur_sorgu1);
            if (rs2.next()) {
                Tid = rs2.getInt("Tid");

            }
            Statement a3 = con.createStatement();
            ResultSet rs3 = a3.executeQuery(sorgu7);
            if (rs3.next()) {
                Sid = rs3.getInt("sid");
                System.out.println(Sid);
            }
            Statement a = con.createStatement();
            ResultSet rs = a.executeQuery(sorgubul);
            if(rs.next())
            {
                int aid=rs.getInt("Aid");
                String sorgu="SELECT * FROM album_icerik where sid='"+Sid+"'";
                Statement a1 = con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu);
                if(rs1.next())
                {
                    System.out.println("Bir albumda eklemek istediğiniz şarkı var");
                }
                else
                {
                    String sorgu3="INSERT INTO `album_icerik` (`Aid`, `sid`, `a`) VALUES ('"+aid+"', '"+Sid+"', "+null+")";
                    a1.executeUpdate(sorgu3);
                    System.out.println("ekledim");
                }

            }


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void onceki_sayfa(MouseEvent mouseEvent) {
        while(tum_sarkilar1.getItems().size()!=0)
        {
            tum_sarkilar1.getItems().remove(0);
        }
        album_sahne.setVisible(false);
        sahne2.setVisible(true);
    }
    public void album_giris(MouseEvent mouseEvent) {
        sqlac();
        String sorgu="SELECT * FROM album  ";
        try {
            Statement a2 = con.createStatement();
            ResultSet rs2 = a2.executeQuery(sorgu);
            int i=1;
            while(rs2.next())
            {
                String ad=rs2.getString("Album_adi");
                album_list.getItems().add(ad);

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sahne4.setVisible(false);
        album_list_sahne.setVisible(true);
    }
    public void albumden_geri(MouseEvent mouseEvent) {
        while(album_list.getItems().size()!=0)
        {
            album_list.getItems().remove(0);
        }
            album_list_sahne.setVisible(false);
            sahne4.setVisible(true);
    }
    public void album_sarkilarini_listele(MouseEvent mouseEvent) {
        sqlac();
        String albumad=getAlbum_ad1();
        System.out.println(getAlbum_ad1());
        String sorgu="Select * From album where Album_adi='"+albumad+"'";
        while(album_sarki_list.getItems().size()!=0)
        {
            album_sarki_list.getItems().remove(0);
        }
        try {
            Statement a = con.createStatement();
            ResultSet rs = a.executeQuery(sorgu);
            if(rs.next())
            {
                int aid=rs.getInt("Aid");
                String sorgu1="Select * From album_icerik where Aid='"+aid+"'";
                Statement a1 = con.createStatement();
                ResultSet rs1 = a1.executeQuery(sorgu1);
                while (rs1.next())
                {
                    int Sid=rs1.getInt("sid");
                    String sorgu2="Select * From sarkilar where sid='"+Sid+"'";
                    Statement a2 = con.createStatement();
                    ResultSet rs2 = a2.executeQuery(sorgu2);
                    if(rs2.next()) {
                        String sarki_ad = rs2.getString("Sarki_adi");
                        String sanatci = rs2.getString("Sanatci");
                        int tur=rs2.getInt("Tur");
                        String sorgu3="Select * From turler where Tid='"+tur+"'";
                        Statement a3 = con.createStatement();
                        ResultSet rs3 = a3.executeQuery(sorgu3);
                        if(rs3.next())
                        {
                            String turler=rs3.getString("Tur_ad");
                            String hepsi=sarki_ad+"    "+sanatci+"    "+turler;
                            album_sarki_list.getItems().add(hepsi);
                        }
                    }
                }
            }
            else
            {
                System.out.println("giremedim");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void album_sarki_ekle(MouseEvent mouseEvent) {
        sqlac();
        System.out.println(getProfil_sarki());
        String[] arrSplit = getProfil_sarki().split("    ");
        String Tur_sorgu = "Select * From turler where";
        String Tur_sorgu1 = Tur_sorgu + " Tur_ad='" + arrSplit[2] + "'";
        String sorgu1 = "SELECT * FROM sarkilar";
        String sorgu7 = "SELECT * FROM sarkilar where Sarki_adi='" + arrSplit[0] + "' and Sanatci='" + arrSplit[1] + "'";
        String sorgu8="INSERT INTO `kullanicilarin_sarkilari` (`a`, `Kid`, `sid`) VALUES ";
        int Tid = 0;
        int Sid = 0;
        try {
            Statement a2 = con.createStatement();
            ResultSet rs2 = a2.executeQuery(Tur_sorgu1);
            if (rs2.next()) {
                Tid = rs2.getInt("Tid");
            }
            Statement a3 = con.createStatement();
            ResultSet rs3 = a3.executeQuery(sorgu7);
            if (rs3.next()) {
                Sid = rs3.getInt("sid");
            }
            String sorgu9=sorgu8+"("+null+", '"+getKullanici_id()+"', '"+Sid+"')";
            String Varmi="Select * From kullanicilarin_sarkilari where Kid='"+getKullanici_id()+"' and sid='"+Sid+"'";
            Statement a1= con.createStatement();
            ResultSet rs1 = a1.executeQuery(Varmi);
            if(rs1.next())
            {
                System.out.println("Bu şarkı zaten listnizde var");
            }
            else
            {
                System.out.println("eklendi");
                a1.executeUpdate(sorgu9);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
