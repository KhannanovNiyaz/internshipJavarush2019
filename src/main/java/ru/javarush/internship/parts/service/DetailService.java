package ru.javarush.internship.parts.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.javarush.internship.parts.entity.Detail;

import java.util.List;

public interface DetailService {
    Detail getProductById(Integer id);
    void saveProduct(Detail detail);
    void updateProduct(Integer id, String name, Integer quantity, boolean isNecessary);
    void deleteProduct(Integer id);

    Page<Detail> findAllByOrderByName(Pageable pageable);
    Page<Detail> findAllByNecessaryIsFalse(Pageable pageable);
    Page<Detail> findAllByNecessaryIsTrue(Pageable pageable);
    Page<Detail> findProductByName(Pageable pageable, String name);
    List<Detail> findAllByNecessaryIsTrueSorted();
}
