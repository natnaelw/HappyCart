package com.mum.edu.happycart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mum.edu.happycart.domain.MyFinance;
import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.service.MyFinanceService;
import com.mum.edu.happycart.service.ProductService;


//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
 
@Controller
@RequestMapping("/report/")
public class ReportController {
 
 
 
//    @Autowired
//    UserDao userDao;
 

	@Autowired
	ProductService productService;
	
	@Autowired
	MyFinanceService myFinanceService;

	private static final Logger logger = LoggerFactory.getLogger("Controller");
	
    @RequestMapping(method = RequestMethod.GET , value = "pdf")
    public ModelAndView generatePdfReport(ModelAndView modelAndView){
    	  logger.debug("--------------generate PDF report-----");
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
     //   List<User> usersList = userDao.retrieveAllRegisteredUsers();
          // List<Product>  products = productService.getAllProducts();
        List<MyFinance> myFinance = myFinanceService.getAllTransactions();
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(myFinance);
 
        parameterMap.put("datasource", JRdataSource);
 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
 

}//ReportController