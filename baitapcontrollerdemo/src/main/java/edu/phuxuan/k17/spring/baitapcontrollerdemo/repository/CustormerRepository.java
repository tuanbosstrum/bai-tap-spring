package edu.phuxuan.k17.spring.baitapcontrollerdemo.repository;

import java.util.List;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Custormer;

public interface CustormerRepository {
	List<Custormer> findAll();

    Custormer findById(int id);

    void save(Custormer custormer);
}
