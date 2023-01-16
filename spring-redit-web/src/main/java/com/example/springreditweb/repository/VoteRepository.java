package com.example.springreditweb.repository;

import com.example.springreditweb.model.Post;
import com.example.springreditweb.model.User;
import com.example.springreditweb.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
