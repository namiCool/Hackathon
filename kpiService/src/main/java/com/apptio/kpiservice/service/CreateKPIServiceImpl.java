package com.apptio.kpiservice.service;


import com.apptio.kpiservice.Exception.KPIAlreadyExistsException;
import com.apptio.kpiservice.Exception.KpiNotFoundException;
import com.apptio.kpiservice.model.KPI;
import com.apptio.kpiservice.repository.KPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class CreateKPIServiceImpl implements CreateKPIService{

    @Autowired
    KPIRepository kpiRepository;
    public KPI createKPI(KPI kpi) throws KPIAlreadyExistsException {;
        return kpiRepository.save(kpi);
    }

    public List<KPI> getAllKPIs() {
        return kpiRepository.findAll();
    }

    public KPI deleteKpi(String kpiId) throws KpiNotFoundException {
        KPI kpi1 = kpiRepository.findById(Integer.parseInt(kpiId));
        if (kpiRepository.existsById(kpiId))
            kpiRepository.deleteById(kpiId);
        else {
            throw new KpiNotFoundException("KPI not found");
        }
        return kpi1;

    }

    public KPI updateKpi(String kpiId, KPI kpi) throws KpiNotFoundException {
        if (kpiRepository.existsById(kpiId)) {
            return kpiRepository.save(kpi);
        } else
            throw new KpiNotFoundException("User not found");

    }

    @Override
    public String getUserByEmailid(String emailId) {
        //TO-DO return email id of user authenticated by front-door
        return "test@apptio.com";
    }
}
