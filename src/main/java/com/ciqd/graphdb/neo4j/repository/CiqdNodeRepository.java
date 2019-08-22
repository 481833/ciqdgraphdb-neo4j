package com.ciqd.graphdb.neo4j.repository;

import com.ciqd.graphdb.neo4j.domain.CiqdNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface CiqdNodeRepository extends Neo4jRepository<CiqdNode, Long> {

    CiqdNode findByNodeName(@Param("nodename") String nodeName);

    @Query("MATCH (cn:CiqdNode) WHERE cn.nodename =~ ('(?i).*'+{type}+'.*') RETURN cn")
    Collection<CiqdNode> findByNameContaining(@Param("name")String nodeName);

    @Query("MATCH (cn:CiqdNode)<-[r:NODE2NODE]-(cm:CiqdNode) RETURN cn,r,cm LIMIT {limit}")
    Collection<CiqdNode> graph(@Param("limit") int limit);
}
