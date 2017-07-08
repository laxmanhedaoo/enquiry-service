package com.system.enquiry.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.common.entity.Enquiry;
import com.system.enquiry.error.CustomErrorType;
import com.system.enquiry.service.EnquiryService;

@RestController
@RequestMapping("/api/enquiry")
public class EnquiryController implements ErrorController {

	/**
	 * 
	 */
	private static final String ERROR_PATH = "/error";
	/**
	 * 
	 */
	public static final Logger logger = LoggerFactory.getLogger(EnquiryController.class);

	/**
	 * 
	 */
	@Autowired
	EnquiryService enquiryService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/get/", method = RequestMethod.GET)
	public ResponseEntity<List<Enquiry>> getEnquiries() {

		List<Enquiry> enquiries = enquiryService.findAllEnquiries();
		if (enquiries.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEnquiry(@PathVariable("id") long id) {
		logger.info("Fetching Enquiry with id {}", id);
		Enquiry enquiry = enquiryService.findById(id);
		if (enquiry == null) {
			logger.error("Enquiry with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Enquiry with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	}

	/**
	 * @param enquiry
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createEnquiry(@RequestBody Enquiry enquiry, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Enquiry : {}", enquiry);
		enquiryService.saveEnquiry(enquiry);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/enquiry/get/{id}").buildAndExpand(enquiry.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * @param id
	 * @param enquiry
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEnquiry(@PathVariable("id") long id, @RequestBody Enquiry enquiry) {
		logger.info("Updating User with id {}", id);

		Enquiry currentEnquiry = enquiryService.findById(id);

		if (currentEnquiry == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentEnquiry.setAttendedBy(enquiry.getAttendedBy());

		enquiryService.updateEnquiry(currentEnquiry);
		return new ResponseEntity<Enquiry>(currentEnquiry, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		Enquiry user = enquiryService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		enquiryService.deleteEnquiryById(id);
		return new ResponseEntity<Enquiry>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = ERROR_PATH)
	public String error() {
		return "Error handling";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
