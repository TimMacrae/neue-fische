package com.oop.pharmacy;

public class MainPharmacy {
    public static void main(String[] args) {
        System.out.println("====================================================");
        Pharmacy pharmacy = new Pharmacy();

        pharmacy.save(new Medication("Ibu",20, true));
        pharmacy.save(new Medication("Panadol",35, true));
        pharmacy.save(new Medication("Dolo",55, true));
        pharmacy.save(new Medication("Nackos",40, false));

        System.out.println("All Medicals: " + pharmacy.getPharmacies());
        System.out.println("Find: " + pharmacy.find("Ibu"));
        System.out.println("Find: " + pharmacy.find("Paracita"));

        pharmacy.delete("Dolo");
        System.out.println("After delete Dolo: " + pharmacy.getPharmacies());
        System.out.println("Count: " + pharmacy.getCount());
    }

}
