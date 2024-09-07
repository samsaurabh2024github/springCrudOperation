package com.sauv.learn.reposatory;

import com.sauv.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface USerReposatory extends JpaRepository<User,String> {

}
