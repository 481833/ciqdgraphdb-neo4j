package com.ciqd.graphdb.neo4j.repositories;

import com.ciqd.graphdb.neo4j.domain.*;
import com.ciqd.graphdb.neo4j.repository.CiqdNodeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CiqdNodeRepositoryTest {

    private CiqdStartNode startNode;
    private CiqdTestStepNode testStepNode;

    @Autowired
    private CiqdNodeRepository testStepNodeRepository;

    @Autowired
    private CiqdNodeRepository startNodeRepository;

    @Before
    public void setUp() {

        startNode = new CiqdStartNode("S","START_NODE");
        startNodeRepository.save(startNode);

        testStepNode = new CiqdTestStepNode("T1","TESTSTEP_NODE");
        testStepNodeRepository.save(testStepNode);

        CiqdNodeRelationship nodeRelationship = new CiqdNodeRelationship(startNode,testStepNode);
        nodeRelationship.addRelationshipName("R1");

        testStepNode.addCiqdNodeRelationship(nodeRelationship);
        testStepNodeRepository.save(testStepNode);

            }

    @Test
    public void testFindByNodeName() {
        CiqdNode result = testStepNodeRepository.findByNodeName("T1");
        System.out.println(result);
        assertNotNull(result);
        //assertEquals("A", result.getNodeName());
            }
  }
