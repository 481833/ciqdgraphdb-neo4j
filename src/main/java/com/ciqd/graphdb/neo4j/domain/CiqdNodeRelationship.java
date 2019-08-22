package com.ciqd.graphdb.neo4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type="NODE2NODE")
public class CiqdNodeRelationship {
    @Id @GeneratedValue
    private Long relationshipId;
    private List<String> relationshipNames= new ArrayList<>();

    @StartNode
    private CiqdNode srcNode;
    @EndNode
    private CiqdNode targetNode;

    public CiqdNodeRelationship(CiqdNode srcNode, CiqdNode targetNode) {
        this.srcNode = srcNode;
        this.targetNode=targetNode;
    }

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public List<String> getRelationshipNames() {
        return relationshipNames;
    }

    public void addRelationshipName(String relationshipName) {
        if (this.relationshipNames==null) {
            this.relationshipNames = new ArrayList<>();
        }
        this.relationshipNames.add(relationshipName);
    }

    public CiqdNode getSrcNode() {
        return srcNode;
    }

    public void setSrcNode(CiqdNode srcNode) {
        this.srcNode = srcNode;
    }

    public CiqdNode getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(CiqdNode targetNode) {
        this.targetNode = targetNode;
    }

}
