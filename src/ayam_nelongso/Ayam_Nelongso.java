/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam_nelongso;

/**
 *
 * @author RISKY
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.IntStream;
public class Ayam_Nelongso {
public static Scanner sc = new Scanner(System.in);
    public static int tt,a,menuutama,i,pilihmkn,jumporsi,potongan,pt,totalakhir,bayar,kembalian,jb,menuedit;
    public static boolean yes = true, ulang = true, ul=true, ut=true,uu=true,ud=true;
    public static String kasir,psnmkn2,nama,tempat,mnutm,lihatkb,upkb,tbkb,dlkb;
    public static int arrharga[] = new int[10];
    public static String arrmenumkn[] = new String[10];
    public static String notas[] = new String[1000];
    public static int notai[] = new int[1000];
    public static int total[] = new int[100];
    public static int tj[] = new int[100];
    public static int nonot[] = new int[100];
 
    public static void main(String[] args) {
        arrharga[1] = 10000;
        arrharga[2] = 9000;
        arrharga[3] = 15000;
        arrharga[4] = 12000;

        arrmenumkn[1] = "Ayam Crispy & Nasi";
        arrmenumkn[2] = "Ayam Goreng Nelongso & Nasi";
        arrmenumkn[3] = "Ayam Bakar Rica - Rica & Nasi";
        arrmenumkn[4] = "Ayam Kampung & Nasi";
        menumakanan(arrmenumkn, arrharga);
    }

    public static void menumakanan(String[] arrmenumkn, int[] arrharga) {
        System.out.println("===============================================");
        System.out.println("               Menu Utama                      ");
        System.out.println("===============================================");
        System.out.println("1. Transaksi                                   ");
        System.out.println("2. Menu Edit                                   ");
        System.out.println("3. Keluar                                      ");
        System.out.println("===============================================");
        do{
            System.out.print("Silahkan Pilih Menu Utama :");
            menuutama = sc.nextInt();
            if(menuutama==0||menuutama>3){
                System.out.println("Inputan Salah");
            }
        }while(menuutama==0||menuutama>3);
        switch(menuutama){
            case 1:
                transaksi();
                break;
            case 2:
                editmenu();
                break;
            case 3:
                keluar();
                break;
            default:
                break;
        }
    }
    
    public static void keluar(){
        System.out.println("Anda telah keluar dari program");
    }

    private static void transaksi() {
            Ayam_Nelongso tgll = new Ayam_Nelongso();
            Date tgl = new Date();
            SimpleDateFormat tglan = new SimpleDateFormat("HH:mm:ss / dd-MM-yyyy");
            Scanner sc = new Scanner(System.in);
            System.out.println("|-----------------------------------------------|");
            System.out.println("|            Ayam Nelongso Ekstra               |");
            System.out.println("|-----------------------------------------------|");
            System.out.println("|                 Menu Makanan                  |");
            System.out.println("|-----------------------------------------------|");
            System.out.print("Kasir : ");
            kasir = sc.nextLine();
            a=1;
            yes = true;
            while(yes){
                for(i=1; i<arrharga.length; i++){
                    if(arrharga[i]!=0){
                        System.out.println(i+". "+arrmenumkn[i]+" = "+arrharga[i]);
                    }
                }
                do{
                    System.out.print("Silahkan pilih yang anda pesan : ");
                    pilihmkn = sc.nextInt();
                    if(arrharga[pilihmkn]==0){
                        System.out.println("Inputan salah");
                    }else{
                        notas[a] = arrmenumkn[pilihmkn];
                        notai[a] = arrharga[pilihmkn];
                    }
                }while(arrharga[pilihmkn]==0);
                do{
                    System.out.print("Masukkan jumlah porsi : ");
                    jumporsi = sc.nextInt();
                    if(jumporsi==0){
                        System.out.println("Inputan Salah");
                    }else if(jumporsi>1000){
                        System.out.println("Maksimal Pemesanan 1000");
                    }
                    notai[a+1] = jumporsi;
                }while(jumporsi==0||jumporsi>1000);
                ulang = true;
                while(ulang){
                    System.out.print("Pesan Lagi Y/T : ");
                    psnmkn2 = sc.next();
                    if(psnmkn2.equalsIgnoreCase("Y")){
                        yes = true;
                        break;
                    }else if(psnmkn2.equalsIgnoreCase("T")){
                        yes = false;
                        break;
                    }else{
                        System.out.println("Inputan Salah!!!");
                    }
                }
                notai[a+2] = ((notai[a]) * (notai[a+1]));
                total[a] = ((notai[a]) * (notai[a+1]));
                 tj[a] = jumporsi;
                pt = IntStream.of(tj).sum();
                nonot[a] = a;
                a+=3;
            }
            a=1;
            System.out.println("Kode Nota TR00"+nonot[a]);
            System.out.println("Antrian: 00" + nonot[a]);
            System.out.print("Atas Nama: ");
            nama = sc.next();
            System.out.println("Tanggal "+tgl);
            System.out.print("Tempat : ");
            tempat = sc.next();
            System.out.println("===========================================================");
            System.out.println("Makanan     \t      \tharga\t       \tjumlah        \ttotal");
            System.out.println("===========================================================");
            for(i=1; i<arrharga.length; i++){
                if(notai[a]!=0){
                    System.out.println(notas[a]+"\t"+notai[a]+"\t\t"+notai[a+1]+"\t\t"+notai[a+2]);
                }
                a+=3;
            }
            tt = IntStream.of(total).sum();
            if(pt>=5){
                potongan = 2000;
            }
            System.out.println();
            System.out.println("========================================================");
            System.out.println("Total \t\t: Rp. " + tt);//mencetak nilai dari objek total
            System.out.println("Potongan \t: Rp. " + potongan);
            totalakhir = tt - potongan;
            System.out.println("Subtotal \t: Rp. "+totalakhir);
            do{
                System.out.print("Bayar \t\t: Rp. ");
                bayar = sc.nextInt();
                if(bayar==0){
                    System.out.println("Anda Harus Bayar!!!");
                }else if(bayar<totalakhir){
                    System.out.println("Uang Anda Kurang!!!");
                }
            }while(bayar==0||bayar<totalakhir);
            kembalian = bayar - totalakhir;
            System.out.println("Kembaliannya \t: Rp. "+kembalian);//mencetak nilai dari objek total1
            System.out.println("Terimakasih Atas Kunjungan Anda , Semoga Tidak Bosan Untuk Kembali ");
            ulang = true;
            while(ulang){
                System.out.print("Kembali Ke Menu Utama Y/T : ");
                mnutm = sc.next();
                if(mnutm.equalsIgnoreCase("Y")){
                    ulang = false;
                    yes = false;
                    menumakanan(arrmenumkn, arrharga);
                    break;
                }else if(mnutm.equalsIgnoreCase("T")){
                    yes = true;
                    break;
                }else{
                    System.out.println("Inputan Salah!!!");
                }
            }
    }

    private static void editmenu() {
        System.out.println("===============================================");
        System.out.println("            Silahkan Pilih Menu                ");
        System.out.println("===============================================");
        System.out.println("1. Lihat Makanan    ");
        System.out.println("2. Tambah Makanan   ");
        System.out.println("3. Update           ");
        System.out.println("4. Delete           ");
        System.out.println("5. Kembali Ke Menu Utama ");
        System.out.println("================================================");
        do{
            System.out.print("Silahkan Pilih Menu :");
            menuedit = sc.nextInt();
            if(menuedit==0||menuedit>5){
                System.out.println("Inputan Salah");
            }
        }while(menuedit==0||menuedit>5);
        switch(menuedit){
            case 1:
                lhtmkn();
                break;
            case 2:
                tbmkn();
                break;
            case 3:
                upd();
                break;
            case 4:
                dl();
                break;
            case 5:
                menumakanan(arrmenumkn, arrharga);
                break;
            default:
                System.out.println("Inputan Salah!!!");
                break;
        }
    }

    public static void lhtmkn() {
        System.out.println("Lihat Makanan");
        for(i=1; i<arrharga.length; i++){
            if(arrharga[i]!=0){
                System.out.println(i+". "+arrmenumkn[i]+"\t = "+arrharga[i]);
            }
        }
        ul = true;
        while(ul){
            System.out.print("Kembali Ke Menu Sebelumnya Y/T : ");
            lihatkb = sc.next();
            if(lihatkb.equalsIgnoreCase("Y")){
                ul = false;
                editmenu();
                break;
            }else if(lihatkb.equalsIgnoreCase("T")){
                ul = false;
                menumakanan(arrmenumkn, arrharga);
                break;
            }else{
                System.out.println("Inputan Salah!!!");
            }
        }
    }

    public static void tbmkn() {
        int b=5;
        a=5;
        System.out.println("Tambah Makanan");
        ut=true;
        while(ut){
        
        
            Scanner sc = new Scanner(System.in);
            System.out.print("Nama Makanan Yang Ditambahkan : ");
            arrmenumkn[a] = sc.nextLine();
            a++;
            System.out.print("Harga : ");
            arrharga[b] = sc.nextInt();
            b++;
            looptb();
        }
    }
    
    public static void looptb(){
        System.out.print("Tambah Menu Makanan Lagi Y/T : ");
        tbkb = sc.next();
        if(tbkb.equalsIgnoreCase("Y")){
            ut = true;
        }else if(tbkb.equalsIgnoreCase("T")){
            ut = false;
            editmenu();
        }else{
            System.out.println("Inputan Salah!!!");
            looptb();
        }
    }

    public static void upd() {
        uu = true;
        System.out.println("Update Makanan");
        for(i=1; i<arrharga.length; i++){
            if(arrharga[i]!=0){
                System.out.println(i+". "+arrmenumkn[i]+"\t = "+arrharga[i]);
            }
        }
        while(uu){
            do{
                System.out.print("Pilih No Makanan Yang akan di Update : ");
                a = sc.nextInt();
                if(arrharga[a]==0){
                    System.out.println("Inputan Salah");
                }
            }while(arrharga[a]==0);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nama Makanan : ");
            arrmenumkn[a] = sc.nextLine();
            System.out.print("Harga Makanan : ");
            arrharga[a] = sc.nextInt();
            loopupd();
        }
    }
    
    public static void loopupd(){
        System.out.print("Update Lagi Y/T : ");
        upkb = sc.next();
        if(upkb.equalsIgnoreCase("Y")){
            uu = true;
        }else if(upkb.equalsIgnoreCase("T")){
            uu = false;
            editmenu();
        }else{
            System.out.println("Inputan Salah!!!");
            loopupd();
        }
    }

    public static void dl() {
        ud=true;
        System.out.println("Delete Makanan ");
        for(i=1; i<arrharga.length; i++){
            if(arrharga[i]!=0){
                System.out.println(i+". "+arrmenumkn[i]+"\t = "+arrharga[i]);
            }
        }
        while(ud){
            System.out.print("Pilih No Makanan Yang akan di Delete : ");
            a = sc.nextInt();
            if(arrharga[a]!=0){
                arrharga[a] = 0;
                arrmenumkn[a] = null;
                for(int dl = (a); dl<arrmenumkn.length - 1; dl++){
                    arrmenumkn[dl] = arrmenumkn[dl+1];
                    arrharga[dl] = arrharga[dl+1];
                }
            }else{
                System.out.println("Inputan Tidak Tersedia");
                ud = true;
            }
            loopdel();
        }
    }
    
    public static void loopdel(){
        System.out.print("Hapus Makanan Lagi Y/T : ");
        dlkb = sc.next();
        if(dlkb.equalsIgnoreCase("Y")){
            ud = true;
        }else if(dlkb.equalsIgnoreCase("T")){
            ud = false;
            editmenu();
        }else{
            System.out.println("Inputan Salah!!!");
            loopdel();
        }
    }
    
    public String tanggal(){
        Date tgl = new Date();
        SimpleDateFormat tglan = new SimpleDateFormat("HH:mm:ss / dd-MM-yyyy");
        return tglan.format(tgl);
    }
    
}
