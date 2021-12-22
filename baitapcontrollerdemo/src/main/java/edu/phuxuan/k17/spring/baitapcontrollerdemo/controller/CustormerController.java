package edu.phuxuan.k17.spring.baitapcontrollerdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Custormer;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.services.CustormerService;

@Controller
public class CustormerController {
	@Autowired
    public CustormerService custormerService;

    @GetMapping("/custormers")
    public ModelAndView list(){
        List<Custormer> custormers = this.custormerService.findAll();
        ModelAndView modelAndView = new ModelAndView("custormer/listcus");
        modelAndView.addObject("custormers", custormers);
        return modelAndView;
    }

    @GetMapping("/newcus")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("custormer/createcus");
        modelAndView.addObject("custormer", new Custormer());
        return modelAndView;
    }

    @PostMapping("/newcus")
    public ModelAndView createCustormer(@ModelAttribute("custormer") Custormer custormer){
        int randomId = (int)(Math.random() * 10000);
        custormer.setId(randomId);//For demo purpose only

        this.custormerService.save(custormer);

        ModelAndView modelAndView = new ModelAndView("custormer/createcus");
        modelAndView.addObject("custormer", new Custormer());
        modelAndView.addObject("message", "Thêm thành công");
        return modelAndView;
    }

    @GetMapping(value = "/viewcus")
    public ModelAndView view(@RequestParam("id") Integer custormerId){
        Custormer custormer = this.custormerService.findById(custormerId);
        ModelAndView modelAndView = new ModelAndView("custormer/viewcus");
        modelAndView.addObject("custormer", custormer);
        return modelAndView;
    }
}
