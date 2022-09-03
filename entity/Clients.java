package entity;



public class Clients {
    // implements Book
    private static int id;
    private String name;
    private String address;
    private String cpf;

    public void registerClients (String name, String address, String cpf){

            if (name != null && !name.isEmpty() &&
                address != null && !address.isEmpty() &&
                cpf != null && !cpf.isEmpty()) {
                    setAddress(address);
                    setCpf(cpf);
                    setName(name);
                    this.id += 1;
                }
        }

    public void editClients(Clients client,String name, String address, String cpf){
                setAddress(address);
                setCpf(cpf);
                setName(name);

    }
    public void deleteClients(Clients client){
        this.address = null;
        this.cpf = null;
        this.name = null;
        client = null;
    }

        /*Métodos Set  e Get */
    public void setAddress(String address) {
        if(address != null&& !address.isEmpty()){
        this.address = address;
        }
    }
    public void setCpf(String cpf) {
        if(cpf != null && !cpf.isEmpty()){
        this.cpf = cpf;
        }
    }
    public void setName(String name) {
        if(name != null && !name.isEmpty()){
        this.name = name;
        }
    }
    public String getAddress() {
        return address;
    }
    public String getCpf() {
        return cpf;
    }
    public String getName() {
        return name;
    }
  }