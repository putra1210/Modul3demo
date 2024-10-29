package org.example;

import java.util.Scanner;

interface BangunDatarInterface {
    double hitungLuas();
    double hitungKeliling();
}

class Persegi implements BangunDatarInterface {
    private double sisi;

    /**
     * konstruktor untuk membuat objek persegi
     * @param sisi panjang sisi persegi
     */
    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    /**
     * Menghitung luas bangun datar
     * @return luas bangun datar
     */
    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }

    /**
     * Menhgitung keliling persegi
     * @return keliling persegi
     */
    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang implements BangunDatarInterface {
    private double panjang, lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}

class Lingkaran implements BangunDatarInterface {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    @Override
    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }
}

public class BangunDatar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih bangun datar: ");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Lingkaran");
        int pilihan = scanner.nextInt();

        BangunDatarInterface bangunDatar = null;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan panjang sisi persegi: ");
                double sisi = scanner.nextDouble();
                bangunDatar = new Persegi(sisi);
                break;

            case 2:
                System.out.print("Masukkan panjang persegi panjang: ");
                double panjang = scanner.nextDouble();
                System.out.print("Masukkan lebar persegi panjang: ");
                double lebar = scanner.nextDouble();
                bangunDatar = new PersegiPanjang(panjang, lebar);
                break;

            case 3:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double jariJari = scanner.nextDouble();
                bangunDatar = new Lingkaran(jariJari);
                break;

            default:
                System.out.println("Pilihan tidak valid!");
                scanner.close();
                return;
        }

        System.out.println("Luas: " + bangunDatar.hitungLuas());
        System.out.println("Keliling: " + bangunDatar.hitungKeliling());

        scanner.close();
    }
}
