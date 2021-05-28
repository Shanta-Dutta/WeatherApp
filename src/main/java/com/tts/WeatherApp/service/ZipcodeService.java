package com.tts.WeatherApp.service;


import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZipcodeService {
    @Autowired
    ZipCodeRepository zipcodeRepository;
    public void AddZipcode(ZipCode zipcode){
        zipcodeRepository.save(zipcode);
    }


    public List<ZipCode> getAllZipcode(){
        return (List<ZipCode>) zipcodeRepository.findAll();
    }

    public List<ZipCode> getTopTenZipcode(){
        Iterable<ZipCode> zipcodes= (List<ZipCode>) zipcodeRepository.findAll();
        List<ZipCode> tenZipcodes=new ArrayList<>();
        int i=0;
        while(i<10 && zipcodes.iterator().hasNext()){
            tenZipcodes.add(zipcodes.iterator().next());
            i++;
        }

        return tenZipcodes;
    }
}