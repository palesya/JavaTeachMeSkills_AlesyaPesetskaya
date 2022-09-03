package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;
import com.tms.homework_40.model.SearchRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatSpecificationService {

    public static Specification<Cat> getCatSpecification(SearchRequest request) {
        return (root, query, criteriaBuilder) -> {
            String name = request.getName();
            String breed = request.getBreed();
            Integer age = request.getAge();
            List<Predicate> predicateList = new ArrayList<>();
            if (name != null) {
                Predicate loginPredicate = criteriaBuilder.equal(root.get("name"), name);
                predicateList.add(loginPredicate);
            }
            if (breed != null) {
                Predicate passwordPredicate = criteriaBuilder.equal(root.get("breed"), breed);
                predicateList.add(passwordPredicate);
            }
            if (age != null) {
                Predicate isActivePredicate = criteriaBuilder.equal(root.get("age"), age);
                predicateList.add(isActivePredicate);
            }
            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };
    }
}

