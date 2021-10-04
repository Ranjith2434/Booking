package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.FeedbackEntity;
import com.example.demo.Repository.FeedbackRepos;

@Service
public class FeedbackService implements FeedbackRepos {
	
	@Autowired
	public FeedbackRepos feedbackRepos;
	

	@Override
	public <S extends FeedbackEntity> S save(S entity) {
		// TODO Auto-generated method stub
		feedbackRepos.save(entity);
		return null;
	}

	@Override
	public <S extends FeedbackEntity> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FeedbackEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<FeedbackEntity> findAll() {
		// TODO Auto-generated method stub		
		return feedbackRepos.findAll();
	}

	@Override
	public Iterable<FeedbackEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub.		
		return feedbackRepos.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FeedbackEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends FeedbackEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
