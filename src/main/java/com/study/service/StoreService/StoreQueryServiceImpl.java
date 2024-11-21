package com.study.service.StoreService;

import com.study.domain.Review;
import com.study.domain.Store;
import com.study.dto.response.ReviewResponseDTO;
import com.study.repository.ReviewRepository.ReviewRepository;
import com.study.repository.StoreRepository.StoreRepository;
import com.study.repository.StoreRepository.StoreRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        filteredStores.forEach(store -> System.out.println("Store: "+store));

        return filteredStores;
    }


}
