package com.sges.generic.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sges.dto.MessageResponse;
import com.sges.dto.OrderBy;
import com.sges.generic.GenericService;

public class GenericController<T, ID> {

	@Autowired
	GenericService<T, ID> genericService;
	
	public GenericService<T, ID> getService() {
        return genericService;
    }
	
	@PostMapping("/getAll")
	@ResponseBody
	public ResponseEntity<Object> getAll(@RequestParam("p") int page, @RequestParam("s") int size, OrderBy orderBy){
		MessageResponse<Object> msg = new MessageResponse<>();
		try {
			msg.setData(genericService.findPage(page, size, orderBy));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> findById(@PathVariable("id") ID id){
		MessageResponse<Object> msg = new MessageResponse<>();
		try {
			msg.setData(genericService.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody @Valid T t) {
		MessageResponse<Object> msg = new MessageResponse<>();
		try {
			msg.setData(genericService.save(t));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody @Valid T t) {
		MessageResponse<Object> msg = new MessageResponse<>();
		try {
			msg.setData(genericService.save(t));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable ID id) {
		MessageResponse<Object> msg = new MessageResponse<>();
		try {
			genericService.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
