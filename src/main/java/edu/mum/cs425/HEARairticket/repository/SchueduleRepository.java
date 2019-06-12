package edu.mum.cs425.HEARairticket.repository;

import edu.mum.cs425.HEARairticket.model.Schuedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchueduleRepository   extends JpaRepository<Schuedule,Long> {
}
