package com.MoralexCorpSolare_Company_SAS.repository;

import com.MoralexCorpSolare_Company_SAS.model.entity.Gafas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GafasRepository  extends JpaRepository<Gafas, Long> {
    List<Gafas> findByActiveTrue();
    List<Gafas> findByMarca(String marca);

}