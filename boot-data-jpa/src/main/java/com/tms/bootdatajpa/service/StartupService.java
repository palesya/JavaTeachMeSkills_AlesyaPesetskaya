package com.tms.bootdatajpa.service;

import com.tms.bootdatajpa.model.SearchRequest;
import com.tms.bootdatajpa.model.User;
import com.tms.bootdatajpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartupService {

    @Autowired
    UserRepository repository;
    private EntityManager manager;

    @PostConstruct
    public void init() {
//        manager.lock(new User(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        User user1 = User.builder()
                .login("user1")
                .password("pass")
                .isActive(false)
                .birthday(new Date())
                .build();

        User user2 = User.builder()
                .login("user2")
                .password("pass")
                .isActive(true)
                .birthday(new Date())
                .build();

        User user3 = User.builder()
                .login("user3")
                .password("pass")
                .isActive(false)
                .birthday(new Date())
                .build();

//        PageRequest of = PageRequest.of(0, 2);
//        PageRequest pageRequest = PageRequest.ofSize(1);
//        Page<User> all = repository.findAll(pageRequest);
//        System.out.println(all);
//
//        List<UserProjection> byIsActive = repository.findByIsActive(false);
//        for(UserProjection user:byIsActive){
//            System.out.println(user.getLogin()+" "+user.getIsActive());
//        }

        SearchRequest request = SearchRequest.builder()
                .password("pass")
                .build();

        Specification<User> userSpecification = UserSpecification.getUserSpecification(request);
        List<User> all = repository.findAll(userSpecification);
        System.out.println(all);

        //User save = repository.save(user3);


//        Criteria criteria = session.createCriteria(User.class);
//        if(request.getLogin() != null){
//            criteria.add(Restrictions.eq("login",request.getLogin()));
//        }
//        if(request.getPassword() != null){
//            criteria.add(Restrictions.eq("password",request.getPassword()));
//        }
//        if(request.getIsActive() != null){
//            criteria.add(Restrictions.eq("isActive",request.getIsActive()));
//        }
//        List<User> list = criteria.list();
//        User userFromDB = (User) criteria.uniqueResult();

//
//        repository.save(user1);
//        repository.save(user2);
//        repository.save(user3);
//
//        List<User> usersFromDB = repository.getByIsActiveIsTrue();
//        for (User user : usersFromDB) {
//            System.out.println(user);
//        }
//        System.out.println("---------------------------------");
//        List<User> alesya = repository.findMyUser("user1");
//        System.out.println(alesya);
//        System.out.println(repository.count());
//        repository.updateActive(false,1L);
    }
}
