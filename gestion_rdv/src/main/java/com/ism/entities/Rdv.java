package com.ism.entities;

public class Rdv {
    private static int nbreRdv;
    public static int getNbreRdv() {
        return nbreRdv;
    }
    public static void setNbreRdv(int nbreRdv) {
        Rdv.nbreRdv = nbreRdv;
    }
    private Personne personne;
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    public Personne getPersonne() {
        return personne;
    }
    
    private int id;
    private String date;
    private boolean statut;
    public Rdv(int id, String date, boolean statut) {
        id =++ nbreRdv;
        this.date = date;
        this.statut = statut;
    }
    public Rdv() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        id =++ nbreRdv;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public boolean isStatut() {
        return statut;
    }
    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rdv other = (Rdv) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Rdv [id=" + id + ", date=" + date + ", statut=" + statut + "]";
    }
    
}