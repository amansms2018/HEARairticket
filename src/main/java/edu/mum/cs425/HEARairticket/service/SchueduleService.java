package edu.mum.cs425.HEARairticket.service;

import edu.mum.cs5.airTicketbooking.model.Schuedule;
import edu.mum.cs5.airTicketbooking.repository.SchueduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchueduleService {
    @Autowired
    private SchueduleRepository schueduleRepository;

    public void  SaveSchuedule( Schuedule schuedule){
        schueduleRepository.save(schuedule);
    }
    public Schuedule  searchById( Long id)
    {
      return   schueduleRepository.getOne(id);
    }


    public List<Schuedule> searchAllSchuedule(){
        return schueduleRepository.findAll();
    }
    public  Schuedule  searchSchueduleById( Long id){
        return schueduleRepository.getOne(id);
    }
    public void  deleteSchueduleById( Long id){
        schueduleRepository.deleteById(id);
    }
}