package com.apptio.kpiservice.controller;


import com.apptio.kpiservice.Exception.KPIAlreadyExistsException;
import com.apptio.kpiservice.Exception.KpiNotFoundException;
import com.apptio.kpiservice.model.KPI;
import com.apptio.kpiservice.service.CreateKPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class CreateController {

    @Autowired
    CreateKPIService createKPIService;
    @PostMapping("createKPI")
    public ResponseEntity saveKPI(@RequestBody KPI kpi) {
        ResponseEntity responseEntity;
        try {
            createKPIService.createKPI(kpi);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
            //TO-DOIn future if we want to consume Kafka and send this data to message Bus use Kafka template
         //   kafkaTemplate.send("AuthMessage",user);
        }
        catch (KPIAlreadyExistsException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    //Request mapping for getting user details
    @GetMapping("kpis")
    public ResponseEntity<List<KPI>> listOfUsers() {
        List<KPI> allUsers = createKPIService.getAllKPIs();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    //Request mapping for deleting user details
    @DeleteMapping("kpi/{id}")
    public ResponseEntity<String> deleteKPI(@PathVariable("id") String kpiId){
        ResponseEntity responseEntity;
        try {
            KPI kpi = createKPIService.deleteKpi(kpiId);
            responseEntity = new ResponseEntity<KPI>(kpi, HttpStatus.GONE);
        }
        catch (KpiNotFoundException kpiNotFoundException){
            responseEntity = new ResponseEntity<>(kpiNotFoundException.getMessage(), HttpStatus.NOT_FOUND);

        }
        return responseEntity;
    }
    //Request mapping for updating user details
    @PutMapping("kpi/{id}")
    public ResponseEntity updateUser(@PathVariable("id") String userId, @RequestBody KPI kpi) {
        ResponseEntity responseEntity;
        try{
            KPI kpi1 = createKPIService.updateKpi(userId,kpi);
            responseEntity = new ResponseEntity<KPI>(kpi1, HttpStatus.OK);
        }
        catch (KpiNotFoundException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/publish/{email}")
    public String post(@PathVariable("email") String email){
        //TO-DO :lets hard code user for now as we will be fetching user from authentication by frontdoor
       // KPI kpi = createKPIService.getUserByEmailid(email);
        //kafkaTemplate.send("AuthMessage",user);
        //This is the alerting mechanism with which alerts are sent when over-shoot.
        return "Published Successfully";
    }
}
