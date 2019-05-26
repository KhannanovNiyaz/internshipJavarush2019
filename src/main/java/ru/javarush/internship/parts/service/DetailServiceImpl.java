package ru.javarush.internship.parts.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.javarush.internship.parts.entity.Detail;
import ru.javarush.internship.parts.repository.DetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    private DetailRepository repository;

    @Autowired
    public void setNoteRepository(DetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public Detail getProductById(Integer id) {
        return this.repository.getOne(id);
    }

    @Override
    public void saveProduct(Detail detail) {
        this.repository.save(detail);
    }

    @Override
    public void updateProduct(Integer id, String name, Integer quantity, boolean isNecessary) {
        Detail updated = this.repository.getOne(id);
        updated.setNecessary(isNecessary);
        updated.setName(name);
        updated.setQuantity(quantity);
        this.repository.save(updated);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.repository.delete(id);
    }

    @Override
    public List<Detail> findAllByNecessaryIsTrueSorted() {
        return this.repository.findAllByNecessaryIsTrueOrderByQuantity();
    }
    @Override
    public Page<Detail> findAllByOrderByName(Pageable pageable) {
        return this.repository.findAllByOrderByName(pageable);
    }

    @Override
    public Page<Detail> findAllByNecessaryIsFalse(Pageable pageable) {
        return this.repository.findAllByNecessaryIsFalseOrderByName(pageable);
    }

    @Override
    public Page<Detail> findAllByNecessaryIsTrue(Pageable pageable) {
        return this.repository.findAllByNecessaryIsTrueOrderByName(pageable);
    }

    @Override
    public Page<Detail> findProductByName(Pageable pageable, String name) {
        return this.repository.findProductsByNameContains(pageable, name);
    }
}
