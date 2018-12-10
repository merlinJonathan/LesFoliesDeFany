package fr.kurzen.lesFoliesDeFany.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.kurzen.lesFoliesDeFany.model.MyUser;

@Repository
@Transactional
public interface MyUserRepository extends CrudRepository<MyUser, Long>
{
	Optional<MyUser> findByLogin(String login);
}
