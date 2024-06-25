package org.example.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class GestionMethode {

    public static void createAnimal(Animal animal,EntityManager em){

        try {
            em.getTransaction().begin();

            em.persist(animal);
            em.getTransaction().commit();

            System.out.println(animal);

        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }




    }

    public static void searchAnimal(EntityManager em){


        Animal animalList = em.find(Animal.class, 1);

        System.out.println(animalList);

        }


    public static void searchAnimalByName(String animalName,EntityManager em) {


        Query query = em.createQuery("select a from Animal a where a.name = :name ", Animal.class);
        query.setParameter("name", animalName);
        List<Animal> animalList = query.getResultList();

        System.out.println(animalList);
    }

    public static void searchByFood(RegimeFood regimeFood, EntityManager em ) {



        Query query = em.createQuery("select a from Animal a where a.regimeFood = :regimeFood ", Animal.class);
        query.setParameter("regimeFood", regimeFood);
        List<RegimeFood> regimeFoodList = query.getResultList();

        System.out.println(regimeFoodList);
    }

    public static void addAnimal(EntityManager em) {

        Scanner sc = new Scanner(System.in);
        var animal = new Animal();

        System.out.println("Ajouter son nom : ");
        animal.setName(sc.nextLine());

        System.out.println("Ajouter son age : ");
        animal.setAge(sc.nextInt());
        sc.nextLine();

        System.out.println("Choisir un régime : ");
        animal.setRegimeFood(RegimeFood.valueOf(sc.nextLine().toUpperCase()));

        animal.setArrival(LocalDate.now());


        GestionMethode.createAnimal(animal,em);


    }



}
