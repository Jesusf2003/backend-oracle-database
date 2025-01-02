package com.backend.entity;

import com.backend.entity.model.Adviser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviserRepository extends JpaRepository<Adviser, Long> {
}
