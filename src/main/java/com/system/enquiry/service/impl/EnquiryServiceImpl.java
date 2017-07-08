package com.system.enquiry.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.entity.Enquiry;
import com.system.enquiry.repository.EnquiryRepository;
import com.system.enquiry.service.EnquiryService;

/**
 * @author laxman
 *
 */
@Service("enquiryService")
public class EnquiryServiceImpl implements EnquiryService {

	/**
	 * 
	 */
	@Autowired
	EnquiryRepository enquiryRepository;

	@Override
	public Enquiry findById(long id) {
		return enquiryRepository.findOne(id);
	}

	@Override
	public Enquiry findByEnquiryDate(Date enquiryDate) {
		return enquiryRepository.findByEnquiryDate(enquiryDate);
	}

	@Override
	public Long saveEnquiry(Enquiry enquiry) {
		return enquiryRepository.save(enquiry).getId();
	}

	@Override
	public void updateEnquiry(Enquiry enquiry) {
		enquiryRepository.save(enquiry);
	}

	@Override
	public void deleteEnquiryById(long id) {
		enquiryRepository.delete(id);

	}

	@Override
	public List<Enquiry> findAllEnquiries() {
		return enquiryRepository.findAll();
	}

}
