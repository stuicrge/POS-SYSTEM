package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Sale;
import com.example.demo.dto.Stock;
import com.example.demo.service.SaleService;
import com.example.demo.service.StockService;

@Controller
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	@Autowired
	private StockService stockService;
	
	// 판매하는 페이지
	@GetMapping("/sale")
	public String sale(Model model) {   
		List<Stock> stockList = stockService.allStockList();
		model.addAttribute("stockList", stockList);
		return "sale";
	}
	
	// 판매내역 페이지
	@GetMapping("/sale/saleHistory")
	public String saleHistory(Model model) {   
		List<Sale> saleList = saleService.allSaleList();
		model.addAttribute("saleList", saleList);
		return "saleHistory";
	}
	
	// 판매내역으로 데이터 전송하는 결제창
	 @RequestMapping(value = "/sale/pay", method = RequestMethod.POST)
	 @ResponseBody 
	 public String salesList(	@RequestParam(value="name[]")String[] name, 
						 @RequestParam(value="count[]")int[] count,  
						 @RequestParam(value="price[]")int[] price, @RequestParam(value="type") String type) { 
		 
		 saleService.insert(name, count, price, type);
		 saleService.updateCount(name, count);
		 
		 return "redirect: /sale";
	 }

	
	// 판매내역이 적혀있는 페이지
	@GetMapping("/sales")
	public String sales(Model model){
		List<Sale> saleList = saleService.allSaleList();
		model.addAttribute("saleList", saleList);
		return "sales";
	}
	// 하루 매출및 총매출
	@GetMapping("/sales/daysales")
	public String daysales(Model model){
		int daysum = 0;
		List<Sale> saleList = saleService.DaySaleList();
		model.addAttribute("saleList", saleList);
		daysum = saleService.DaySum();
		model.addAttribute("daysum", daysum);
		return "sales";
	}
	// 한달 매출및 총매출
	@GetMapping("/sales/weeksales")
	public String Weeksales(Model model){
		List<Sale> saleList = saleService.WeekSaleList();
		model.addAttribute("saleList", saleList);
		return "sales";
	}
	
	//일년 매출및 총매출 
	@GetMapping("/sales/monthsales")
	public String Monthsales(Model model){
		List<Sale> saleList = saleService.MonthSaleList();
		model.addAttribute("saleList", saleList);
		return "sales";
	}
	// 가장 잘 팔린 제품
	@GetMapping("/sales/bestsales")
	public String BestSales(Model model){
		List<Sale> saleList = saleService.BestSaleList();
		model.addAttribute("saleList", saleList);
		return "sales";
	}
	
}