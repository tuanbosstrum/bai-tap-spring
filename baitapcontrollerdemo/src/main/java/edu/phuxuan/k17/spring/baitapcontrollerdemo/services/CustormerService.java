package edu.phuxuan.k17.spring.baitapcontrollerdemo.services;

import java.util.List;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Custormer;

public interface CustormerService {
	List<Custormer> findAll();

    Custormer findById(int id);

    void save(Custormer custormer);
}
