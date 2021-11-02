package com.sges.generic.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sges.dto.ErrorMessage;
import com.sges.dto.Metadata;
import com.sges.dto.ResponseDTO;
import com.sges.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericController<T, E> {
	@Autowired
	private ObjectMapper objectMapper;

	private final BaseService<T, E> baseService;

	public GenericController(BaseService<T, E> baseService) {
		this.baseService = baseService;
	}

	@GetMapping("")
	@ResponseBody
	public ResponseEntity<ResponseDTO<List<Map>>> findAll(
			@RequestParam(value = "p", defaultValue = "0") int page,
			@RequestParam(value = "s", defaultValue = "10") int size,
			@RequestParam(value = "fields", required = false) Set<String> fields) {

		ResponseDTO<List<Map>> responseDTO = new ResponseDTO<>();
		Page<T> p = this.baseService.findPage(page, size);

		List<Map> mapList = p.getContent()
				.stream()
				.map(r -> this.objectMapper.convertValue(r ,Map.class))
				.peek(map -> {
					if (fields != null) map.keySet().retainAll(fields);
				})
				.collect(Collectors.toList());
		responseDTO.setData(mapList);
		responseDTO.setMetadata(new Metadata(p.getSize(), p.getTotalElements(), p.getTotalPages()));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ResponseDTO<Map>> getById(@PathVariable("id") E id, @RequestParam(value = "fields", required = false) Set<String> fields) {
		ResponseDTO<Map> responseDTO = new ResponseDTO<>();
		try {
			T t = this.baseService.findById(id);
			Map map = this.objectMapper.convertValue(t, Map.class);
			if (fields != null) {
				map.keySet().retainAll(fields);
			}
			responseDTO.setData(map);
			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		} catch (Exception e){
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setUserMessage("No data found!");
			errorMessage.setInternalMessage(e.toString());
			responseDTO.setErrorMessage(errorMessage);
			return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	@ResponseBody
//	@PreAuthorize(value="isAuthenticated()")
	public ResponseEntity<ResponseDTO<T>> create(@Valid @RequestBody T obj, BindingResult result) {
		ResponseDTO<T> responseDTO = new ResponseDTO<>();
		if(result.hasErrors()) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setUserMessage("Data is invalid!");
			errorMessage.setInternalMessage(result.toString());
			responseDTO.setErrorMessage(errorMessage);
			return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		else {
			responseDTO.setData(this.baseService.create(obj));
			return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
		}
	}

	@PutMapping("")
	@ResponseBody
	@PreAuthorize(value="isAuthenticated()")
	public ResponseEntity<ResponseDTO<T>> update(@Valid @RequestBody T obj, BindingResult result) {
		ResponseDTO<T> responseDTO = new ResponseDTO<>();
		if(result.hasErrors()) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setUserMessage("Data is invalid!");
			errorMessage.setInternalMessage(result.toString());
			responseDTO.setErrorMessage(errorMessage);
			return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		else {
			responseDTO.setData(this.baseService.update(obj));
			return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
		}
	}
	
}
