package com.ciqd.graphdb.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class CiqdApplication {

    @Id @GeneratedValue
    private Long Id;

    private String name;

}
