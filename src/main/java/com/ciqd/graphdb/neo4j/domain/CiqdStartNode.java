package com.ciqd.graphdb.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class CiqdStartNode extends CiqdNode {

    @JsonIgnoreProperties("ciqdnodes")
    @Relationship(type = "NODE2NODE")
    private List<CiqdNode> ciqdNodes = new ArrayList<>();

    public CiqdStartNode(String nodeName, String nodeType) {
        super(nodeName, nodeType);
    }

    public List<CiqdNode> getTargetNodes() {
        return ciqdNodes;
    }
}
