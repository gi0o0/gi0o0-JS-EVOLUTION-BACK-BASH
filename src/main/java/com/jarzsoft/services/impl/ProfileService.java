package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.mapper.IProfileMapper;
import com.jarzsoft.repository.W_Bas_T_PerfilRepository;
import com.jarzsoft.service.IProfileService;

@Service
public class ProfileService implements IProfileService {

	private final W_Bas_T_PerfilRepository dao;

	private final IProfileMapper mapper;

	@Autowired
	public ProfileService(W_Bas_T_PerfilRepository perfilRepository, IProfileMapper mapper) {
		super();
		this.dao = perfilRepository;
		this.mapper = mapper;

	}

	@Override
	public DTOProfile create(DTOProfile t) {

		return null;

	}

	@Override
	public DTOProfile update(DTOProfile t) {
		return null;
	}

	@Override
	public ResponseEntity<Object> delete(int id) {
		return null;
	}

	@Override
	public DTOProfile listById(int id) {
		return null;
	}

	@Override
	public List<DTOProfile> listAll() {
		return mapper.mapperList(dao.findAll());
	}

}
