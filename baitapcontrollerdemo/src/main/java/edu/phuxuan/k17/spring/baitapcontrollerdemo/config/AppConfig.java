package edu.phuxuan.k17.spring.baitapcontrollerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.repository.CustormerRepository;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.repository.CustormerRepositoryImpl;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.repository.ProductRepository;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.repository.ProductRepositoryImpl;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.services.CustormerService;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.services.CustormerServiceImpl;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.services.ProductService;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.services.ProductServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
	    "edu.phuxuan.k17.spring.baitapcontrollerdemo"
	})
public class AppConfig {
	
	@Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }
    @Bean
    public CustormerService custormerService(){
        return new CustormerServiceImpl();
    }

    @Bean
    public CustormerRepository custormerRepository(){
        return new CustormerRepositoryImpl();
    }
}


