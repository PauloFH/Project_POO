package entity;

import java.util.ArrayList;

public class VinylRecord extends Products {
    private String bandsName;
    private String musicalStyle;

    static ArrayList<VinylRecord> vinylRecords = new ArrayList<>();

    public void registerVinyl(String title, String bandsName, String musicalStyle, int copiesAmount, double rentPrice){

            VinylRecord newRecord = new VinylRecord();

            newRecord.setTitle(title);
            newRecord.setBandsName(bandsName);
            newRecord.setMusicalStyle(musicalStyle);
            newRecord.setCopiesAmount(copiesAmount);
            newRecord.setRentPrice(rentPrice);

            vinylRecords.add(newRecord);
    }

    public void edit(int id, String title, String bandsName, String musicalStyle, int copiesAmount, double rentPrice){
            setId(id);

            VinylRecord editRecord = new VinylRecord();

            editRecord.setTitle(title);
            editRecord.setBandsName(bandsName);
            editRecord.setMusicalStyle(musicalStyle);
            editRecord.setCopiesAmount(copiesAmount);
            editRecord.setRentPrice(rentPrice);
            

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

   

}