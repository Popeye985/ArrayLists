package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> producten = leesProducten(scanner);
        boolean eindeProgramma = false;
        do {
            System.out.println("Wat wilt u zien? ");
            System.out.println("1. De hoogste prijs");
            System.out.println("2. De laagste prijs");
            System.out.println("3. De gemiddelde prijs");
            System.out.print("Uw keuze: ");
            int keuze = Integer.parseInt(scanner.nextLine());
            switch (keuze) {
                case 1:
                    double hoogste = getHoogstePrijs(producten);
                    System.out.printf("De hoogste prijs is %.2f%n", hoogste);
                    eindeProgramma = true;
                    break;
                case 2:
                    double laagste = getLaagstePrijs(producten);
                    System.out.printf("De laagste prijs is %.2f%n", laagste);
                    eindeProgramma = true;
                    break;
                case 3:
                    double gemiddelde = getGemiddeldePrijs(producten);
                    System.out.printf("De gemiddelde prijs is %.2f%n", gemiddelde);
                    eindeProgramma = true;
                    break;
            }
        } while (!eindeProgramma);

    }




    private static double getHoogstePrijs(ArrayList<Product> producten) {
        double maxPrijs = Double.MIN_VALUE;
        for (Product prod : producten) {
            if (prod.getPrijs() > maxPrijs) {
                maxPrijs = prod.getPrijs();

            }
        }return maxPrijs;


    }

    private static ArrayList<Product> leesProducten(Scanner scanner) {
        ArrayList<Product> producten = new ArrayList<>();
        System.out.println("Geef producten in. <Return> om te stoppen.");
        String naam = scanner.nextLine();
        while (!naam.equals("")) {
            System.out.println("Geef prijs: ");
            double prijs = Double.parseDouble(scanner.nextLine());
            producten.add(new Product(naam, prijs));

        }
        return producten;


    }

    private static double getLaagstePrijs(ArrayList<Product> producten) {
        double minPrijs=Double.MAX_VALUE;
        for (Product prod : producten) {
            if (prod.getPrijs() < minPrijs)
                minPrijs = prod.getPrijs();
            }
            return minPrijs;
        }


    private static double getGemiddeldePrijs(ArrayList<Product> producten) {
        double som = 0;

        for (Product prod : producten ){
            som += prod.getPrijs();
        }
        return som/producten.size();

    }
}
class Product {
    private String naam;
    private double prijs;

    public Product(String naam, double prijs) {
        if (prijs < 0) throw new IllegalArgumentException("Prijs kan niet negatief zijn");
        this.naam = naam;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

}
