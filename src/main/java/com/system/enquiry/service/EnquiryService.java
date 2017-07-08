package com.system.enquiry.service;

import java.util.Date;
import java.util.List;

import com.common.entity.Enquiry;


/**
 * @author laxman
 *
 */
public interface EnquiryService {

	/**
	 * @param id
	 * @return
	 */
	Enquiry findById(long id);

	/**
	 * @param emailId
	 * @return
	 */
	Enquiry findByEnquiryDate(Date date);

	Long saveEnquiry(Enquiry enquiry);

	void updateEnquiry(Enquiry enquiry);

	/**
	 * @param id
	 */
	void deleteEnquiryById(long id);

	/**
	 * @return
	 */
	List<Enquiry> findAllEnquiries();

}
