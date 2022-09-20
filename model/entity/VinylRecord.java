package entity;

import java.util.ArrayList;

public class VinylRecord {
    private String title;
    private String bandsName;
    private String musicalStyle;
    private int totalRecords;
    private double rentalPrice;
    private int id;
    
    static ArrayList<VinylRecord> vinylRecords = new ArrayList<>();

    public void registerVinyl(String title, String bandsName, String musicalStyle, int totalRecords, double rentalPrice){

            VinylRecord newRecord = new VinylRecord();

            newRecord.setTitle(title);
            newRecord.setBandsName(bandsName);
            newRecord.setMusicalStyle(musicalStyle);
            newRecord.setTotalRecords(totalRecords);
            newRecord.setRentalPrice(rentalPrice);

            vinylRecords.add(newRecord);
    }

    public void edit(int id, String title, String bandsName, String musicalStyle, int totalRecords, double rentalPrice){
            setId(id);

            VinylRecord editRecord = new VinylRecord();

            editRecord.setTitle(title);
            editRecord.setBandsName(bandsName);
            editRecord.setMusicalStyle(musicalStyle);
            editRecord.setTotalRecords(totalRecords);
            editRecord.setRentalPrice(rentalPrice);
            

            vinylRecords.set(id, editRecord);
    }

    public void delete(int id){
            setId(id);
            vinylRecords.remove(id);
    }

    public ArrayList searchTitle(String title) {
        ArrayList<VinylRecord> filteredRecord = new ArrayList<VinylRecord>();
        
        for(VinylRecord i : vinylRecords){
            if(i.title.equals(title)){
                filteredRecord.add(i);
            }
        }

        if(filteredRecord.size() > 0) {
            return filteredRecord;
        } else {
            System.out.println("No record found");
            return null;
        }
    }

    public ArrayList searchBandsName(String bandsName) {
        ArrayList<VinylRecord> filteredRecord = new ArrayList<VinylRecord>();
        
        for(VinylRecord i : vinylRecords){
            if(i.bandsName.equals(bandsName)){
                filteredRecord.add(i);
            }
        }

        if(filteredRecord.size() > 0) {
            return filteredRecord;
        } else {
            System.out.println("No record found");
            return null;
        }
    }

    public ArrayList searchMusicalStyle(String musicalStyle) {
        ArrayList<VinylRecord> filteredRecord = new ArrayList<VinylRecord>();
        
        for(VinylRecord i : vinylRecords){
            if(i.musicalStyle.equals(musicalStyle)){
                filteredRecord.add(i);
            }
        }

        if(filteredRecord.size() > 0) {
            return filteredRecord;
        } else {
            System.out.println("No record found");
            return null;
        }
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            if(!title.isEmpty()) this.title = title;
            else throw new IllegalArgumentException("Title cannot be empty");
    }

    public String getBandsName() {
        return bandsName;
    }

    public void setBandsName(String bandsName) {
            if(!bandsName.isEmpty()) this.bandsName = bandsName;
            else throw new IllegalArgumentException("Band's name must not be empty");
    }

    public String getMusicalStyle() {
        return musicalStyle;
    }

    public void setMusicalStyle(String musicalStyle) {
            if(!musicalStyle.isEmpty()) this.musicalStyle = musicalStyle;
            else throw new IllegalArgumentException(" Musical style must not be empty");
    }

    public int getTotalRecords(){
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
            if(totalRecords > 0) this.totalRecords = totalRecords;
            else throw new IllegalArgumentException("Total records must be greater than 0");
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
            if(rentalPrice > 0) this.rentalPrice = rentalPrice;
            else throw new IllegalArgumentException("rentalPrice must be greater than 0");
    }

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
            if(id >= 0) this.id = id;
            else throw new IllegalArgumentException("Invalid id");
    }

}