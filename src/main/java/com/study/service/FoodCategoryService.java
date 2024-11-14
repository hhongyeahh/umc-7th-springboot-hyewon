package com.study.service;

import com.study.repository.FoodCategoryRepository;
import com.study.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsById(Long id) {
        return foodCategoryRepository.existsById(id);
    }

}
