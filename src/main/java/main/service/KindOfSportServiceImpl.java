package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.KindOfSport;
import main.repository.KindOfSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KindOfSportServiceImpl implements KindOfSportService {
    @Autowired
    KindOfSportRepository kindOfSportRepository;

    @Override
    public KindOfSport getById(Long id) {
        return kindOfSportRepository.findOne(id);
    }

//    @Override
//    public KindOfSport findByName(String name_kindOfSport) {
//        return kindOfSportRepository.findByName(name_kindOfSport);
//    }
}
