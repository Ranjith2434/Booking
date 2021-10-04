package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.BookingEntity;
import com.example.demo.Model.FeedbackEntity;
import com.example.demo.Repository.BookingRepos;
import com.example.demo.Repository.FeedbackRepos;

@Service
public class BookingService implements BookingRepos {
	
	@Autowired
	public BookingRepos bookingRepos;

	@Override
	public <S extends BookingEntity> S save(S entity) {
		// TODO Auto-generated method stub
		bookingRepos.save(entity);
		return null;
	}

	@Override
	public <S extends BookingEntity> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BookingEntity> findById(Long id) {
		// TODO Auto-generated method stub
		
		return bookingRepos.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<BookingEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<BookingEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookingEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends BookingEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	


}
