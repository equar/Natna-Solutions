package com.natna.forces.agent;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AgentController {

  @Autowired
  private IAgentService agentService;

  @PostMapping("/agent")
  public Agent createagent(@RequestBody Agent agent) {

      Agent agentResponse = agentService.addAgent(agent);
      return new ResponseEntity<>(agentResponse, HttpStatus.CREATED).getBody();

  }

  @GetMapping("/agents")
  public List<Agent> getAllAgents() {
    return agentService.getAllAgents();
  }

  @GetMapping("/agent/{id}")
  public ResponseEntity<Agent> getAgentsById(@PathVariable(value = "id") Long agentId)
      throws ResourceNotFoundException {

    Agent agent = agentService.getAgentById(agentId);

    return ResponseEntity.ok().body(agent);
  }

  @PutMapping("/agent/{id}")
  public ResponseEntity<Agent> updateAgent(
      @PathVariable(value = "id") Long agentId,  @RequestBody Agent agentDetails)
      throws ResourceNotFoundException {

    Agent updatedagent = agentService.updateAgent(agentId,agentDetails);

    return ResponseEntity.ok(updatedagent);
  }

  @DeleteMapping("/agent/{id}")
  public Map<String, Boolean> deleteAgent(@PathVariable(value = "id") Long agentId) throws Exception {

    agentService.deleteAgent(agentId);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
