package com.ism;

import java.util.Scanner;

import com.ism.entities.Patient;
import com.ism.entities.Medecin;
import com.ism.services.PersonneServiceImpl;
import com.ism.repositories.DatabaseImpl;
import com.ism.repositories.MedecinImpl;
import com.ism.repositories.PatientImpl;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;
        DatabaseImpl database = new DatabaseImpl();
        PatientImpl patientImpl= new PatientImpl(database);
        MedecinImpl medecinImpl= new MedecinImpl(database);
        PersonneServiceImpl<Medecin> medecinServiceImpl = new PersonneServiceImpl<>(medecinImpl);
        PersonneServiceImpl<Patient> patientServiceImpl = new PersonneServiceImpl<>(patientImpl);
        
        do {
            System.out.println("**************MENU*****************");
            System.out.println("1. Création d'un patient");
            System.out.println("2. Création d'un médecin");
            System.out.println("3. Planification rendez-vous");
            System.out.println("4. Afficher  rendez-vous du jour");
            System.out.println("5. Afficher rendez-vous d'un médecin par jour");
            System.out.println("6. Annuler  rendez-vous");
            System.out.println("7. Quitter");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Veuillez entrer le nom  du patient : ");
                    String nomCompletP = sc.next();
                    Patient patient = new Patient();
                    patient.setNomComplet(nomCompletP);
                    patient.setType(1); 
                    System.out.println("Veuillez entrer les antécédents du patient : ");
                    String antecedents = sc.next();
                    patient.setAntecedents(antecedents);

                    int resultP = patientServiceImpl.add(patient);

                    if (resultP > 0) {
                        System.out.println("Patient cree avec succès !");
                    } else {
                        System.out.println("Échec de la creation du patient.");
                    }
                    break;


                case 2:
                    System.out.println("Veuillez entrer le nom  du médecin : ");
                    String nomCompletM = sc.next();
                    Medecin medecin = new Medecin();
                    medecin.setNomComplet(nomCompletM);
                    medecin.setType(2);
                    System.out.println("Veuillez entrer la spécialité du médecin : ");
                    String specialite = sc.next();
                    medecin.setSpecialite(specialite);

                    int resultM = medecinServiceImpl.add(medecin);

                    if (resultM > 0) {
                        System.out.println("Médecin creer avec succès !");
                    } else {
                        System.out.println("Échec de la creation du médecin.");
                    }
                    break;

                default:
                    break;
            }
        } while (choix != 7);
        sc.close();
    }
}
