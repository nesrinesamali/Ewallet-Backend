package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Categories;
import com.nesryne.wallet.repository.CategoriesRepository;
import com.nesryne.wallet.service.dto.CategoriesDto;
import com.nesryne.wallet.service.mapper.CategoriesMapper;

@Service
public class CategoriesServiceImpl implements CategoriesService  {
   

@Autowired
CategoriesRepository CategorieRepository;
@Autowired
CategoriesMapper categoriesMapper;
private CategoriesRepository CategoriesRepository;

public CategoriesServiceImpl(CategoriesMapper categoriesMapper,CategoriesRepository categoriesRepository){
    this.categoriesMapper=categoriesMapper;
    this.CategoriesRepository=categoriesRepository;
}




@Override
public CategoriesDto saveCategories(CategoriesDto categoriesDto) {
    Categories categories=categoriesMapper.toEntity(categoriesDto);
    categories=CategoriesRepository.save(categories);
    return categoriesMapper.toDto(categories);}

@Override
public CategoriesDto updateCategories(CategoriesDto categoriesDto) {
    Categories categories=categoriesMapper.toEntity(categoriesDto);
    categories=CategoriesRepository.save(categories);
    return categoriesMapper.toDto(categories);}

@Override
public void deleteCategoriesById(Long idCategories) {
    CategoriesRepository.deleteById(idCategories);
}
@Override
public Categories getCategories(Long idCategories) {
    return CategoriesRepository.findById(idCategories).get();}
@Override
public List<Categories> getAllCategories() {
    return CategoriesRepository.findAll();
}
}

