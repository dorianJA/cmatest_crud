package ru.cma.juntest.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cma.juntest.cruddemo.model.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Group findByName(String name);

}
