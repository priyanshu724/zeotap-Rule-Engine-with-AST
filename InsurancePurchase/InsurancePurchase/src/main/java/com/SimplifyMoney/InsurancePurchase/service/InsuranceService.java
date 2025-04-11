package com.SimplifyMoney.InsurancePurchase.service;

import com.SimplifyMoney.InsurancePurchase.dao.InsaurenceDao;
import com.SimplifyMoney.InsurancePurchase.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InsaurenceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsaurenceDao insaurenceDao;

    public List<Insaurence> getInsaurence() {
    }


    public List<Insaurence> getCuratedInsurances(double minIncome, double maxIncome, int age, String gender) {
    }
}
