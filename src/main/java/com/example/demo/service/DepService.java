package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.CustomException;
import com.example.demo.Dto.Department;
import com.example.demo.repo.DeptRepository;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DepService {

	@Autowired
	DeptRepository deptRepository;
	
	Logger logger = (Logger) LoggerFactory.getLogger(DepService.class);
	
	
	public Department saveDept(Department department) {
		logger.trace("kkkkkkkkkkkkkkkkkkkkk");
		logger.info("yeslllllllllllllllll");
		 deptRepository.save(department);
		 return department;
	}
	
	public Department getById(int id) {
          return deptRepository.findBydeptno(id);
	}
	public List<Department> fetchAll() {
		PageRequest pageRequest = PageRequest.of(0, 2,Sort.by("loc"));
		Page<Department> page = deptRepository.findAll(pageRequest);
//		String string = null;
//		System.out.println(string.length());
		List<Department> list = page.toList();
		return list;
	}
	
	public Department updateDept(Department department) throws CustomException  {
		
		Department department2 = deptRepository.findBydeptno(department.getDeptno());
		
		if(department.getDeptno() != 1) {
			throw new CustomException("sfghj");
		}
		department2.setDeptno(department.getDeptno());
		department2.setDname(department.getDname());
		department2.setLoc(department.getLoc());
		
		deptRepository.save(department2);
		
		return department2;
	}

	
	public int deleteDept(int id) {
            deptRepository.deleteById(id);
            return id;
	}
}
