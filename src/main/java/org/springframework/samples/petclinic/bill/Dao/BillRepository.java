package org.springframework.samples.petclinic.bill.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.bill.Dto.Bill;
//import org.springframework.samples.petclinic.bill.Service.BillService;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface BillRepository extends Repository<Bill, Integer> {

	@Transactional(readOnly = true)
	@Cacheable("bills")
	Collection<Bill> findAll() throws DataAccessException;

	void save(Bill bill);

	Bill findById(@Param("id") Integer id);



	@Query(value="SELECT * FROM bills where id =1",nativeQuery = true)
	@Transactional(readOnly = true)
	List<Bill>findBills();






}
