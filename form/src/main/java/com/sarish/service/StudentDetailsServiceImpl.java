package com.sarish.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarish.dao.AddressDao;
import com.sarish.dao.StudentDetailsDao;
import com.sarish.model.Address;
import com.sarish.model.StudentDetails;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {

	@Autowired
	public StudentDetailsDao sdd;
	@Autowired
	public AddressDao add;

	@Override
	public String insert(StudentDetails sd) {
		return sdd.insert(sd);
	}

	@Override
	public String update(StudentDetails sd) {
		return sdd.update(sd);
	}

	@Override
	public String delete(StudentDetails sd) {
		List<StudentDetails> list = sdd.getAll();
		int res=0;
		for(StudentDetails sd1:list) {
			if(sd.getId()==sd1.getId()) {
				res=add.delete(sd1.getAddress());
				break;
			}
		}
		System.out.println(res);
		return sdd.delete(sd);
	}

	@Override
	public List<StudentDetails> getAll() {
		List<StudentDetails> finalList = new ArrayList<>();
		List<StudentDetails> inList= sdd.getAll();
		List<Address> adds=add.getAll();
		for(StudentDetails sd:inList) {
			Address newAd=null;
			for(Address ad:adds) {
				if(ad.getHouseNo()==sd.getAddress().getHouseNo()) {
					newAd=ad;
					break;
				}
			}
			finalList.add(new StudentDetails(sd.getId(),sd.getName(),newAd));
		}
		return finalList;
	}

}
