package edu.phuxuan.k17.spring.baitapcontrollerdemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Custormer;

public class CustormerRepositoryImpl implements CustormerRepository{
	private static final Map<Integer, Custormer> custormers;

    static {
        custormers = new HashMap<>();
        custormers.put(1, new Custormer(1, "GTFS", "Hoàng Tuấn","tuanbosstrum@gmail.com"));
        custormers.put(2, new Custormer(2, "GTFS", "Hoàng Tuấn","tuanbosstrum@gmail.com"));
        custormers.put(3, new Custormer(3, "GTFS", "Hoàng Anh Tuấn","tuanbosstrum@gmail.com"));
        custormers.put(4, new Custormer(4, "GTFS", "Hoàng Lê Anh Tuấn","tuanbosstrum@gmail.com"));
    }

    @Override
    public List<Custormer> findAll() {
        return new ArrayList<>(custormers.values());
    }

    @Override
    public Custormer findById(int id) {
        Custormer custormer = custormers.get(id);
        return custormer;
    }

    @Override
    public void save(Custormer custormer) {
    	custormers.put(custormer.getId(), custormer);
    }
}
