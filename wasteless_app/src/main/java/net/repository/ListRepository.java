package net.repository;

import net.model.Lists;
import net.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepository extends JpaRepository<Lists, Long> {
    Lists findListsByName(String name);
    List<Lists> findAllByUserId(Long userId);
}
