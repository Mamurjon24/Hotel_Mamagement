package org.example.service;

import org.example.entity.OutComeEntity;
import org.example.entity.RoomEntity;
import org.example.repository.OutComeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OutComeService {
    @Autowired
    private OutComeRepository outComeRepository;

    public void addOutCome(String outCome, Double amount, String payDay) {
        OutComeEntity outComeEntity = new OutComeEntity();
        outComeEntity.setReason(outCome);
        outComeEntity.setPayDate(LocalDate.parse(payDay));
        outComeEntity.setAmount(amount);
        outComeRepository.save(outComeEntity);
    }

    public void getOutComeList() {
        List<OutComeEntity> outComeEntities= outComeRepository.outComeList();
        if (outComeEntities == null){
            System.out.println("Not Active Room");
            return;
        }
        outComeEntities.forEach(System.out::println);
    }
}
