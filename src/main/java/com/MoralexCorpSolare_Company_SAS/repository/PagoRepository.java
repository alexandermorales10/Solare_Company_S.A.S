package com.MoralexCorpSolare_Company_SAS.repository;

import com.MoralexCorpSolare_Company_SAS.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    Optional<Pago> findByReferencia(String referencia);

    Optional<Pago> findByReferenciaWompi(String referenciaWompi);

    Optional<Pago> findByTransactionId(String transactionId);

}
