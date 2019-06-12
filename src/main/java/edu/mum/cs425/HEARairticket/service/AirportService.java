package edu.mum.cs425.HEARairticket.service;
import edu.mum.cs425.HEARairticket.model.Airport;
import edu.mum.cs425.HEARairticket.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public  class AirportService {
    @Autowired
    AirportRepository airportRepository;

    public void save( Airport airport) {
         airportRepository.save(airport);
    }
    public List<Airport> searchAll() {
        return airportRepository.findAll();
    }

    public Airport findOne(String code) {
        return airportRepository.getOne(code);
    }

    public long count() {
        return  airportRepository.count() ;
    }
    public void delete(Airport airport) {
    }
}
