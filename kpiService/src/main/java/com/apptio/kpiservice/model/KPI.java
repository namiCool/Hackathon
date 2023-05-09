package com.apptio.kpiservice.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@Data
public class KPI {
    @Id
    Integer id;
    // inform optimize operate
    String category;

    String kpiName;
    String definition;

    Integer current;
    Integer target;

}
