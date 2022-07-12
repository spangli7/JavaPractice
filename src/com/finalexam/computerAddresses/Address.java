package com.finalexam.computerAddresses;

import java.util.List;

public class Address {
    private AddressTypes types;
    private List<String> address;
  
    private Address(){
    }

    public Address(AddressTypes types, List<String> address) {
        this.types = types;
        this.address = address;
    }

    public AddressTypes getTypes() {
        return types;
    }

    public void setTypes(AddressTypes types) {
        this.types = types;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
