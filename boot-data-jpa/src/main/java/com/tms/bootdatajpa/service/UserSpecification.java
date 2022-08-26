package com.tms.bootdatajpa.service;

import com.tms.bootdatajpa.model.SearchRequest;
import com.tms.bootdatajpa.model.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSpecification {

    public static Specification<User> getUserSpecification(SearchRequest request) {
        return (root, query, criteriaBuilder) -> {
            String login = request.getLogin();
            String password = request.getPassword();
            Boolean isActive = request.getIsActive();
            List<Predicate> predicateList = new ArrayList<>();
            if (login != null) {
                Predicate loginPredicate = criteriaBuilder.equal(root.get("login"), login);
                predicateList.add(loginPredicate);
            }
            if (password != null) {
                Predicate passwordPredicate = criteriaBuilder.equal(root.get("password"), password);
            predicateList.add(passwordPredicate);
            }
            if (isActive != null) {
                Predicate isActivePredicate = criteriaBuilder.equal(root.get("isActive"), isActive);
            predicateList.add(isActivePredicate);
            }
            return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
        };
    }
}

