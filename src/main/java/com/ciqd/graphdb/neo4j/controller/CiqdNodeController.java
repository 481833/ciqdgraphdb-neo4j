package com.ciqd.graphdb.neo4j.controller;

import com.ciqd.graphdb.neo4j.domain.CiqdNode;
import com.ciqd.graphdb.neo4j.services.CiqdNodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CiqdNodeController {
    private final CiqdNodeService ciqdNodeService;

    public CiqdNodeController(CiqdNodeService ciqdNodeService) {
        this.ciqdNodeService = ciqdNodeService;
    }

    @GetMapping("/graph")
    public Collection<CiqdNode> graph(@RequestParam(value="limit",required = false) Integer limit) {
        return ciqdNodeService.graph(limit == null ? 1 : limit);

    }
}
