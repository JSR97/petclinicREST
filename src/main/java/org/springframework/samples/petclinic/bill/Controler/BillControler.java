package org.springframework.samples.petclinic.bill.Controler;

import org.springframework.samples.petclinic.bill.Dao.BillRepository;
import org.springframework.samples.petclinic.bill.Dto.Bill;
import org.springframework.samples.petclinic.bill.Dto.Bills;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Map;


public class BillControler {

	private BillRepository billRepository;


	public BillControler(BillRepository billRepository){this.billRepository=billRepository;}

	@ModelAttribute("bill")
	public Bill findBill(@PathParam("idBill")int idBill){
		return this.billRepository.findById(idBill);
	}


	@GetMapping({"/bills"})
	public @ResponseBody Bills showResourcesBillList(){
		Bills bills = new Bills();
		bills.getBillList().addAll(this.billRepository.findAll());
		return bills;
	}







}
