package org.springframework.samples.petclinic.bill.Dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.Visit;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bills")
public class Bill extends BaseEntity {

/*	@Column(name="id")
	@NotEmpty
	private Integer idBill;*/

	@Column(name="money")
	@NotEmpty
	private Double money;

	@Column(name="payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;


	public Double getMoney() {return money;	}

	public void setMoney(Double money) {this.money = money;}

	public LocalDate getPaymentDate() {	return paymentDate;	}

	public void setPaymentDate(LocalDate paymentDate) {	this.paymentDate = paymentDate;	}
/*
	public List<Visit> getPets() {
		return this.visits;
	}
*/



}
