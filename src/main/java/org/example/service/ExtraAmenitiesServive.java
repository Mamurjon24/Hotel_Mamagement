package org.example.service;

import org.example.entity.ExtraAmenitiesEntity;
import org.example.repository.ExtraAmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraAmenitiesServive {
    @Autowired
    private ExtraAmenitiesRepository extraAmenitiesRepository;

    public void addconvenient(String convenientName) {
        ExtraAmenitiesEntity extraAmenities = new ExtraAmenitiesEntity();
        extraAmenities.setExtraAmenitiesName(convenientName);
        extraAmenitiesRepository.save(extraAmenities);

    }

    public void convenientList() {
        List<ExtraAmenitiesEntity> extraAmenitiesEntityList = extraAmenitiesRepository.extraamenitiesList();
        if (extraAmenitiesEntityList == null) {
            System.out.println("Convenient is nor found :)");
            return;
        }
        extraAmenitiesEntityList.forEach(System.out::println);
    }

    public void deleteConvenient(Integer convenientId) {
        ExtraAmenitiesEntity extraAmenities = extraAmenitiesRepository.getById(convenientId);
        if (extraAmenities == null){
            System.out.println("Convenient is not Found :)");
            return;
        }
        extraAmenitiesRepository.delete(convenientId);
    }
}
