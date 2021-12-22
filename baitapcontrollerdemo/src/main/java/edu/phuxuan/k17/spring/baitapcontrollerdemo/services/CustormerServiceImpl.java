package edu.phuxuan.k17.spring.baitapcontrollerdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Custormer;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.repository.CustormerRepository;

public class CustormerServiceImpl implements CustormerService{
	@Autowired
    public CustormerRepository custormerRepository;

    @Override
    public List<Custormer> findAll() {
        return this.custormerRepository.findAll();
    }

    @Override
    public Custormer findById(int id) {
        return this.custormerRepository.findById(id);
    }

    @Override
    public void save(Custormer custormer) {
        this.custormerRepository.save(custormer);
    }
}
