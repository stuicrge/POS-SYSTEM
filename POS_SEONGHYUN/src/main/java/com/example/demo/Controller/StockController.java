package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Stock;
import com.example.demo.service.StockService;
@Controller
public class StockController {
	
	@Autowired
	private StockService stockService;

	// 재고의 메인페이지로 들어가는 컨트롤러
	@GetMapping("/stock")
	public String stock1(Model model) {   	
		List<Stock> stockList = stockService.allStockList();
		model.addAttribute("stockList", stockList);
		return "stock";	
	}
	
	//제품 추가 페이지로 넘어감
	@GetMapping("/stock/addstock")
	public String stock2Get() {  return "addstock"; }
	
	// 제품 입고 페이지로 넘어감
	@GetMapping("/stock/addstocks")
	public String stock3Get() {  return "addstocks"; }

	// 제품 추가 실행 컨트롤러
	@PostMapping("/addstock")
	public String addNewStock1(Stock add) 
	{
			try {
				stockService.regist(add);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/stock";
	}
	// 제품 입고 실행 컨트롤러 , 실행 성공시 실행 성공했다 표현
	@PostMapping(value = "/stock/addComplete")
	public String addStocks2(Model model,
			@RequestParam(value = "stockCode") String stockCode, @RequestParam(value = "stocks") int stocks) {
		stockService.plusStocks(stockCode, stocks);
		return "addComplete";
	}
	
	// 제품 수정 페이지로 넘어감
	@GetMapping(value="/stock/updatestocks")
	public String updateStock1(){
		return "updatestocks";
	}
	// 제품 수정 실행 컨트롤러
	@PostMapping(value = "/stock/updateComplete")
	public String updateStocks2(Stock stock) {
		stockService.update(stock);
		return "updateComplete";
	}	
	// 제품 삭제 페이지로 넘어감
	@GetMapping(value="/stock/deletestock")
	public String deleteStock1(){
		return "deletestock";
	}
	// 제품 삭제 컨트롤러로 넘어감
	@PostMapping(value = "/stock/deleteComplete")
	public String deleteStock2(Long id) {
		stockService.delete(id);
		return "deleteComplete";
	}	
}
	