package com.apptio.kpiservice.service;


import com.apptio.kpiservice.Exception.KPIAlreadyExistsException;
import com.apptio.kpiservice.Exception.KpiNotFoundException;
import com.apptio.kpiservice.model.KPI;

import java.util.List;

public interface CreateKPIService {
    public KPI createKPI (KPI kpi) throws KPIAlreadyExistsException;
    public List<KPI> getAllKPIs();
    public KPI deleteKpi(String kpiName) throws KpiNotFoundException;
    public KPI updateKpi(String kpiName, KPI kpi) throws KpiNotFoundException;
    public String getUserByEmailid(String kpiName);

}
