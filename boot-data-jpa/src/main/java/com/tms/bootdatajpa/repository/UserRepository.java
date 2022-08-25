package com.tms.bootdatajpa.repository;

import com.tms.bootdatajpa.model.User;
import com.tms.bootdatajpa.model.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getByLogin(String login);

    List<User> getByIsActiveIsTrue();

    Optional<User> getByLoginAndPassword(String login, String password);

    List<User> getByBirthdayBetween(Date after, Date before);

    @Query("select u from User u where u.login=:login")
    List<User> findMyUser(String login);

    @Query(value = "select count(*) from users",nativeQuery = true)
    long count();

    List<User> getOnlyActive();

    @Transactional
    @Modifying
    @Query("update User u set u.isActive=:isActive where u.id=:id")
    void updateActive(boolean isActive, Long id);

    List <UserProjection> findByIsActive(boolean isActive);

}
