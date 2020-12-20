package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.Category;
import com.vermeg.bookstoremvc.model.CategoryDTO;
import com.vermeg.bookstoremvc.service.mapper.CategoryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl extends GenericMapperImpl<CategoryDTO, Category> implements CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO mapToDto(Category entity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        modelMapper.map(entity,categoryDTO);
        return categoryDTO;
    }

    @Override
    public Category mapToEntity(CategoryDTO dto) {
        Category category = new Category();
        modelMapper.map(dto,category);
        return category;
    }
}
