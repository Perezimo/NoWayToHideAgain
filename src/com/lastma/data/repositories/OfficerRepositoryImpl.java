package com.lastma.data.repositories;
import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepository {
    private List<Officer> officers = new ArrayList<>();
    private int numberOfOfficers= 0;

    @Override
    public Officer save(Officer officer) {
        officer.setId(++numberOfOfficers);
        officers.add(officer);
        return officer;
    }
    @Override
    public long count(){
        return numberOfOfficers;
    }
    @Override
    public Officer findById(int id) {
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return officer;
            }
        }
        throw new IllegalArgumentException("Officer with id" + id + "is not found");
    }
    @Override
    public List<Officer> findAll(){
        if(numberOfOfficers== 0) throw new IllegalArgumentException("No Drivers saved");
        return officers;
    }

    @Override
    public void delete(int officerId){
        Officer foundOfficer = findById(officerId);
        officers.remove(foundOfficer);
        numberOfOfficers--;
    }

    @Override
    public void deleteAll() {
        officers.clear();
        numberOfOfficers = 0;
    }

}
