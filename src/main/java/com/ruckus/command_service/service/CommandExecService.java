package com.ruckus.command_service.service;

import com.ruckus.command_service.domain.CommandExecRequest;
import com.ruckus.command_service.domain.CommandExecResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

@Service
public class CommandExecService {
    @Autowired
    private CommandRepository commandRepository;

    public CommandExecResponse execCommand(CommandExecRequest commandExecRequest) {
        System.out.println("Executing command request" + commandExecRequest);
        try {
            Process process = Runtime.getRuntime().exec(commandExecRequest.getCommand());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder commandResult = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                commandResult.append(line).append("\n");
            }
            System.out.println("command result:\n" + commandResult);
            CommandExecResponse response = new CommandExecResponse();
            response.setResult(commandResult.toString());
            String id = UUID.randomUUID().toString();
            response.setId(id);
            commandRepository.storeCommand(id, response);
            return response;
        } catch (IOException e) {
            System.out.println("Failed to executing command request" + commandExecRequest);
            e.printStackTrace();
        }
        return null;
    }

    public CommandExecResponse getCommandResult(String commandId) {
        return commandRepository.getCommand(commandId);
    }
}