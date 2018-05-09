package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.tblbids;
import com.repository.BidRepository;

@Service
public class BidService {
	@Autowired
	private BidRepository bidRepository;
	
	public void addBid(tblbids bidDetails) {
		bidRepository.save(bidDetails);
	}
	
	public Iterable<tblbids> findByuserId(Integer userId) {
		return bidRepository.findByuserId(userId);
	}
	
	public Iterable<tblbids> findByprojectId(Integer projectId) {
		return bidRepository.findByprojectId(projectId);
	}
}
