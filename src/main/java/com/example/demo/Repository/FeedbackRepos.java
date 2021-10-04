package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.FeedbackEntity;

@Repository
public interface FeedbackRepos extends CrudRepository<FeedbackEntity, Long> {

}
