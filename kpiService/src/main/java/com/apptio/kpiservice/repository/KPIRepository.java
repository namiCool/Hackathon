package com.apptio.kpiservice.repository;

import com.apptio.kpiservice.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KPIRepository extends JpaRepository<KPI,String> {
    KPI findById(Integer id);
}