package com.picosoft.picosoft.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.picosoft.picosoft.module.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByNom(String nom);

	public User findByEmail(String email);

	public List<User> findByPrenom(String prenom);
	
	public boolean findUserByEmail(String email);
	
	@Query("select u from user u where u.role.role='manager' ")
	public List<User> findAllManager();
	
	@Query("select u from user u where u.superior.idUser=:id")
	public List<User> findEquipe(@Param("id") Long id);

}
