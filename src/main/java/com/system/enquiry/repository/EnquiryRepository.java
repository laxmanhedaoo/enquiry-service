package com.system.enquiry.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.common.entity.Enquiry;


/**
 * @author laxman
 *
 */
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
	Enquiry findByEnquiryDate(Date date);
}
