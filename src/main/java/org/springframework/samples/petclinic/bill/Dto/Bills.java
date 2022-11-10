package org.springframework.samples.petclinic.bill.Dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Bills {

	private List<Bill> bills;

	@XmlElement
	public List<Bill> getBillList(){
		if(bills == null){
			bills = new ArrayList<>();
		}
		return bills;
	}


}
