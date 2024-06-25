package org.example.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

import static org.example.Entity.GestionMethode.*;

public class IHM {

        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            begin();
        }

        public static void begin(){

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("zoojpa");
            EntityManager em = emf.createEntityManager();

            while(true)
            {
                afficheMenu();
                String saisie = scanner.nextLine();

                switch (saisie){
                    case "1" -> addAnimal(em);
                    case "2" -> searchAnimal(em);
                    case "3" -> searchAnimalByName(nameAnimal(),em);
                    case "4" -> searchByFood(regimeFood(), em);
                    case "0" -> {
                        System.out.println("Au revoir !!!");
                        return; // (termine l'application)
                    }
                    default -> System.out.println("Choix invalide !!!!");
                }

            }
        }


        public static void afficheMenu(){

            System.out.println("##### Zoo #######");
            System.out.println();
            System.out.println("1) Créer un animal");
            System.out.println("2) Rechercher un animal");
            System.out.println("3) Rechercher un animal par nom ");
            System.out.println("4) Recherche régime");
            System.out.println("0) Quitter");
            System.out.println();
            System.out.print("Faite votre choix : ");
        }

        public static String nameAnimal(){
        System.out.println("Donnez le nom de l'animal");
        String nom = scanner.nextLine();
        return nom;
        }

        public static RegimeFood regimeFood(){
        System.out.println("Donnez le type de régime");
        RegimeFood regime = RegimeFood.valueOf(scanner.nextLine().toUpperCase());
        return regime;
        }


    }

