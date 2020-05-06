package example.model.repository;

import example.model.entity.db.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Integer, UserEntity> {

    public UserEntity getUserByUsername(String username);

    public List<UserEntity> getUsersByUsername(String username);
}
