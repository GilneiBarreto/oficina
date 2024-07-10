package com.brtec.oficina.domain.repository;

import com.brtec.oficina.domain.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}
