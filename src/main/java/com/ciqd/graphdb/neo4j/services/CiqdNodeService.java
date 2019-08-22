package com.ciqd.graphdb.neo4j.services;

import com.ciqd.graphdb.neo4j.domain.CiqdNode;
import com.ciqd.graphdb.neo4j.domain.CiqdNodeRelationship;
import com.ciqd.graphdb.neo4j.repository.CiqdNodeRepository;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;

import java.util.*;

@Service
@Transactional
public class CiqdNodeService {

    private final static Logger LOG = LoggerFactory.getLogger(CiqdNodeRepository.class);

    private final CiqdNodeRepository ciqdNodeRepository;

    public CiqdNodeService(CiqdNodeRepository ciqdNodeRepository) {
        this.ciqdNodeRepository = ciqdNodeRepository;
    }

    private Map<String, Object> toD3Format(Collection<CiqdNode> ciqdNodes) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<CiqdNode> result = ciqdNodes.iterator();
        while (result.hasNext()) {
            CiqdNode ciqdNode = result.next();
            nodes.add(map("nodeName", ciqdNode.getNodeName(), "nodeType", ciqdNode.getNodeType()));
            int target = i;
            i++;
            for (CiqdNodeRelationship ciqdNodeRelationship : ciqdNode.getCiqdNodeRelationships()) {
                Map<String, Object> nodeRelationship = map("nodeName", ciqdNodeRelationship.getSrcNode().getNodeName(), "relationShipName", "R1");
                int source = nodes.indexOf(nodeRelationship);
                if (source == -1) {
                    nodes.add(nodeRelationship);
                    source = i++;
                }
                rels.add(map("source", source, "target", target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    public CiqdNode findByNodeName(String nodeName) {
        CiqdNode result = ciqdNodeRepository.findByNodeName("T!");
        return result;
    }

    public Collection<CiqdNode> graph(int limit) {
        Collection<CiqdNode> result = ciqdNodeRepository.graph(limit);
        return result;
    }
}
