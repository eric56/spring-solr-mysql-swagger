package com.koin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.util.Date;

@Data
@SolrDocument(solrCoreName = "usuarios")
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @Field("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Field("nome")
    @JsonProperty("nome")
    @Column(name = "nome")
    private String name;

    @Field("idade")
    @JsonProperty("idade")
    @Column(name = "idade")
    private int age;

    @Field("email")
    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @Field("dt_nascimento")
    @JsonProperty("dt_nascimento")
    @Column(name = "dt_nascimento")
    private Date birthday;

    @Field("last_modified")
    @JsonProperty("last_modified")
    @Column(name = "last_modified")
    private Date last_modified;

}
