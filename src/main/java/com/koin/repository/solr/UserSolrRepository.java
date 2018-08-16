package com.koin.repository.solr;

import com.koin.model.User;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Optional;

public interface UserSolrRepository extends SolrCrudRepository<User, String> {

    @Query("id:*?0*")
    Optional<User> findById(String idUser);

}
