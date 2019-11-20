package com.ruckus.command_service.service;

import com.ruckus.command_service.domain.CommandExecResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CommandRepository {
    private Map<String, CommandExecResponse> commandMap = new ConcurrentHashMap();

    public void storeCommand(String id, CommandExecResponse commandExecResponse) {
        commandMap.put(id, commandExecResponse);
    }

    public CommandExecResponse getCommand(String id) {
        return commandMap.get(id);
    }
}
