package com.ciqd.graphdb.neo4j.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class CiqdNode {

    @Id @GeneratedValue
    private Long id;
    @Property(name="nodename")
    private String nodeName;
    @Property(name="nodetype")
    private String nodeType;

    @Relationship(type="NODE2NODE", direction = "INCOMING")
    private List<CiqdNodeRelationship> ciqdNodeRelationships;


    public CiqdNode(String nodeName,String nodeType) {
        this.nodeName = nodeName;
        this.nodeType = nodeType;
    }

    public Long getId() {
        return id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public List<CiqdNodeRelationship> getCiqdNodeRelationships() {
        return ciqdNodeRelationships;
    }

    public void addCiqdNodeRelationship(CiqdNodeRelationship nodeRelationship) {
        if (this.ciqdNodeRelationships == null) {
            ciqdNodeRelationships = new ArrayList();
        }
        ciqdNodeRelationships.add(nodeRelationship);
    }
}
