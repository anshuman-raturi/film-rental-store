package com.cg.films.service.impl;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.cg.films.dto.LanguageDTO;
import com.cg.films.repository.LanguageRepository;
import com.cg.films.service.LanguageService;
@Service
public class LanguageServiceImpl implements LanguageService{
	private LanguageRepository langRepo;
	LanguageServiceImpl(LanguageRepository langRepo){
		this.langRepo=langRepo;
	}
 
	@Override
	public List<LanguageDTO> getAllLanguagesByName() {
		return langRepo.findAll().stream().
				                   map(language-> new LanguageDTO(language.getName())).toList();
	}

 
}