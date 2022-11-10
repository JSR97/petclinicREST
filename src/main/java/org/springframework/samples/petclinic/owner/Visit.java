/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.bill.Dto.Bill;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.util.Assert;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 * @author Dave Syer
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	@Column(name = "visit_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NotEmpty
	private String description;


	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bill_id")
	@OrderBy("payment_date")
	private List<Bill> bills = new ArrayList<>();



	/**
	 * Creates a new instance of Visit for the current date
	 */
	public Visit() {
		this.date = LocalDate.now();
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

*/
	public List<Bill> getBills() {
		return bills;
	}

	public void addBill(Bill bill) {
		if (bill.isNew()) {
			getBills().add(bill);
		}
	}

	@Override
	public String toString() {
		return "Visit{" +
			"date=" + date +
			", description='" + description + '\'' +
			", pet=" + pet +
			", bills=" + bills +
			'}';
	}

	public Bill getBill(Integer id) {
		for (Bill b : getBills()) {
			if (!b.isNew()) {
				Integer compId = b.getId();
				if (compId.equals(id)) {
					return b;
				}
			}
		}
		return null;
	}
	/*public Visit addBill(Integer billId, Bill bill) {

		Assert.notNull(billId, "Bill identifier must not be null!");
		Assert.notNull(bill, "Bill must not be null!");

		Bill b= getBill(billId);

		Assert.notNull(pet, "Invalid Pet identifier!");

		pet.addB(b);

		return this;
	}
	*/
}
