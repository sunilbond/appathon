package com.ge.mict.scannerdataanalysis.app.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ge.mict.scannerdataanalysis.app.domain.Hospital;
import com.ge.mict.scannerdataanalysis.app.domain.ProtocolView;
import com.ge.mict.scannerdataanalysis.app.domain.RefPhysicianView;
import com.ge.mict.scannerdataanalysis.app.domain.ScannerInfo;
import com.ge.mict.scannerdataanalysis.app.repositories.ScannerInfoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/scannnerInfo")
public class ScannerInfoController {
    private static final Logger logger = LoggerFactory.getLogger(ScannerInfoController.class);
    private ScannerInfoRepository repository;

    @Autowired
    public ScannerInfoController(ScannerInfoRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ScannerInfo> scannerInfos() {
        return repository.findAll();
    }
    
    @ResponseBody
    @RequestMapping(value="/getHospitals",method = RequestMethod.GET)
    public Iterable<Hospital> getDistinctHosps() {
    	return repository.findHospitals();
    }
    
    @ResponseBody
    @RequestMapping(value="/getRefPhy/{hospID}",method = RequestMethod.GET)
    public Iterable<RefPhysicianView> getRefPhysician(@PathVariable String hospID) {
    	System.out.println("Called Ref Phy with Hosp ID = " +  hospID);
    	
    	System.out.println((repository.findRefphydetails(hospID)).toString());
    	
    	return repository.findRefphydetails(hospID);
    }

    @ResponseBody
    @RequestMapping(value="/getProtocolAnalysis/{hospID}",method = RequestMethod.GET)
    public Iterable<ProtocolView> getProtocolAnalysis(@PathVariable String hospID) {
        return repository.findProtocolAnalysis(hospID);
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ScannerInfo add(@RequestBody @Valid ScannerInfo scannerInfo) {
        logger.info("Adding ScannerInfo entry " + scannerInfo.getId());
        return repository.save(scannerInfo);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ScannerInfo update(@RequestBody @Valid ScannerInfo scannerInfo) {
        logger.info("Updating scannerInfo entry " + scannerInfo.getId());
        return repository.save(scannerInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ScannerInfo getById(@PathVariable String id) {
        logger.info("Getting scannerInfo by ID = " + id);
        return repository.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting scannerInfo with id = " + id);
        repository.delete(id);
    }
    
   /* @ResponseBody
    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public Object getAllHospitals() {
        logger.info("Getting All hospitals  ");
        return repository.findAllHospitals();
    }*/
}