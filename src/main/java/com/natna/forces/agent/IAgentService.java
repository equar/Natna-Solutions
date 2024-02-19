package com.natna.forces.agent;

import com.natna.forces.exception.ResourceNotFoundException;
import com.natna.forces.agent.Agent;

import java.util.List;

public interface IAgentService {

    Agent addAgent(Agent agent);

    Agent updateAgent(Long agentId,Agent agent) throws ResourceNotFoundException;

    void deleteAgent(Long agentId) throws ResourceNotFoundException;

    Agent getAgentById(Long agentId);

    List<Agent> getAllAgents();

}
