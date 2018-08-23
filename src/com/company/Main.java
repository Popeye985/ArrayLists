package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
            Scanner scanner = new Scanner(System.in);
            ArrayList<Persoon> personen = new ArrayList<>();
            System.out.print("Geef naam(<RETURN> om te stoppen): ");
            String naam = scanner.nextLine();
            while(!"".equals(naam)){
                LocalDate geboorteDatum = leesDatum(scanner);
                while (geboorteDatum.compareTo(LocalDate.now())>0) {
                    System.out.println("Geboortedatum kan niet in de toekomst liggen.");
                    geboorteDatum = leesDatum(scanner);

                }
                personen.add(new Persoon(naam, geboorteDatum));
                System.out.println("Geef naam");
                naam = scanner.nextLine();

            }
            System.out.print("De personen zijn: ");
            for(Persoon p: personen){
                System.out.printf("%s geboren op %s%n", p.getNaam(), p.getGeboorteDatum());
            }

        }
        private static LocalDate leesDatum(Scanner scanner){
            System.out.print("Geef geboortejaar: ");
            int jaar = Integer.parseInt(scanner.nextLine());
            System.out.print("Geef geboortemaand: ");
            int maand = Integer.parseInt(scanner.nextLine());
            System.out.print("Geef geboortedag: ");
            int dag = Integer.parseInt(scanner.nextLine());
            return LocalDate.of(jaar, maand, dag);
        }
    }
    class Persoon{
        private String naam;
        private LocalDate geboorteDatum;

        public Persoon(String naam, LocalDate geboorteDatum) {
            if (geboorteDatum.compareTo(LocalDate.now()) > 0)
                throw new IllegalArgumentException("Geboortedatum kan niet in de toekomst liggen");
            this.naam = naam;
            this.geboorteDatum = geboorteDatum;
        }

        public String getNaam() {
            return naam;
        }

        public LocalDate getGeboorteDatum() {
            return geboorteDatum;
        }

    }

