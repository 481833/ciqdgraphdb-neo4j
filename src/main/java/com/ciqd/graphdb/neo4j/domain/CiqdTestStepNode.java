package com.ciqd.graphdb.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class CiqdTestStepNode extends CiqdNode {

    public CiqdTestStepNode(String nodeName, String nodeType) {
        super(nodeName, nodeType);
    }

}
