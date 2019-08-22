package com.ciqd.graphdb.neo4j.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class CiqdDecisionNode extends CiqdNode {

    @Relationship(type="NODE2NODE", direction = "INCOMING")
    private List<CiqdNodeRelationship> ciqdNodeRelationships;

    public CiqdDecisionNode(String nodeName, String nodeType) {
        super(nodeName, nodeType);
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
