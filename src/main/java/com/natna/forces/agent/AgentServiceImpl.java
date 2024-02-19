package com.natna.forces.agent;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements IAgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent updateAgent(Long agentId,Agent agentDetails) throws ResourceNotFoundException {
        Agent agent =
                agentRepository
                        .findById(agentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Agent not found on :: " + agentId));

        agent.setAgentName(agentDetails.getAgentName());

        return agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(Long agentId) throws ResourceNotFoundException {

        Agent agent =
                agentRepository
                        .findById(agentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Agent not found on :: " + agentId));

        agentRepository.delete(agent);
    }

    @Override
    public Agent getAgentById(Long agentId) {
        return agentRepository.findById(agentId).orElse(null);
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }
}
