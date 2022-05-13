package com.idat.tapia.repository;

import com.idat.tapia.model.MallaCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallaCurricularRepository extends JpaRepository<MallaCurricular, Integer> {
}
