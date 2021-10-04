package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResultDTO;
import com.example.demo.Model.BookingEntity;
import com.example.demo.Model.FeedbackEntity;

import com.example.demo.Repository.FeedbackRepos;
import com.example.demo.Service.BookingService;
import com.example.demo.Service.FeedbackService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@EnableEurekaClient
public class FeedbackController  {

	@Autowired
	public FeedbackService feedbackService;
	
	@Autowired
	public BookingService bookingService;
	
	private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);
		
	@RequestMapping(path = "/feedback/fetchAll", method = RequestMethod.GET)
	public ResponseEntity<String> createFeedback() {
		System.out.println("Inside the basic controller");
		ResultDTO resultDto= new ResultDTO(); 
		logger.warn("Inside the fetch all controller");
		try {
			Iterable<FeedbackEntity> feedbackEntityLst = feedbackService.findAll();
			if( feedbackService.count()!=0 ) {
				resultDto.setMessage(feedbackEntityLst.toString());
				resultDto.setStatus(true);
				return new ResponseEntity<>(resultDto.toString(), HttpStatus.CREATED);
			} else {
				resultDto.setMessage("Nothing to Fetch");
				resultDto.setStatus(false);
				return new ResponseEntity<>(resultDto.toString(), HttpStatus.ACCEPTED);
			}			
		}catch(Exception e) {
			e.printStackTrace();
			resultDto.setMessage("404 Not Found");
			resultDto.setStatus(false);
			return new ResponseEntity<>(resultDto.toString(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping( path = "/feedback/{bookingId}", method = RequestMethod.POST )
	public ResponseEntity<ResultDTO> createFeedbackWitBookingId(@RequestBody FeedbackEntity feedbackEntity, @PathVariable Long bookingId) {
		System.out.println("Inside the basic controller");		
		logger.warn("Inside the creation of the Feedback for Booking Id");	
		ResultDTO resultDto= new ResultDTO(); 
		String message = "Something Went Wrong";
		try {
			
			//Check for the given booking id  is present or not
			Optional<BookingEntity> currentBookingEntityOptional = bookingService.findById(bookingId);
			BookingEntity currentBookingEntity = null;
			if(currentBookingEntityOptional.isPresent() ) {
				currentBookingEntity = currentBookingEntityOptional.get();
			} else {
				currentBookingEntity = null;
				message = "No Booking found for this Booking Id";
			}
			 
			if( currentBookingEntityOptional.isPresent() && currentBookingEntity.getStatus().equals("Booked") ) 
					 {
				feedbackService.save(feedbackEntity);
				resultDto.setMessage(feedbackEntity.toString());
				resultDto.setStatus(true);
				return new ResponseEntity<>(resultDto, HttpStatus.CREATED);
			} else {
				message = "Booking status is not yet booked, cannot register a feedback";
				resultDto.setMessage(message);
				resultDto.setStatus(false);
				return new ResponseEntity<>(resultDto, HttpStatus.BAD_REQUEST);
			}				
		
		}catch(Exception e) {
			e.printStackTrace();
			resultDto.setMessage("JAVA cached Exception");
			resultDto.setStatus(false);
			return new ResponseEntity<>(resultDto, HttpStatus.BAD_REQUEST);			
		}
	}
/*	
	@RequestMapping("/feed")
	public ResponseEntity<ResultDTO> createFeed() {
		System.out.println("Inside the basic controller");
		ResultDTO resultDto= new ResultDTO(); 
		try {
			//feedbackService.save(feedbackEntity);
			resultDto.setMessage("JAVA is good");
			resultDto.setStatus(true);
			return new ResponseEntity<>(resultDto, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			resultDto.setMessage("JAVA cached Exception");
			resultDto.setStatus(true);
			return new ResponseEntity<>(resultDto, HttpStatus.BAD_REQUEST);
		}
	}
*/
}
