package ru.javarush.internship.parts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.javarush.internship.parts.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Integer>{

    List<Detail> findAllByNecessaryIsTrueOrderByQuantity();

    Page<Detail> findAllByOrderByName(Pageable pageable);
    Page<Detail> findAllByNecessaryIsFalseOrderByName(Pageable pageable);
    Page<Detail> findAllByNecessaryIsTrueOrderByName(Pageable pageable);
    Page<Detail> findProductsByNameContains(Pageable pageable, String name);
}
