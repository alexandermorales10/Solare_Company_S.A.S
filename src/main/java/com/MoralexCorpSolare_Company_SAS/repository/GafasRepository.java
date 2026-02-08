package com.MoralexCorpSolare_Company_SAS.repository;

import com.MoralexCorpSolare_Company_SAS.entity.Gafas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GafasRepository  extends JpaRepository<Gafas, Long> {
    List<Gafas> findByActiveTrue();
    List<Gafas> findByMarca(String marca);

}