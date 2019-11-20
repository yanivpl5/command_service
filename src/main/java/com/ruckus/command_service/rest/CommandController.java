package com.ruckus.command_service.rest;

import com.ruckus.command_service.domain.CommandExecRequest;
import com.ruckus.command_service.domain.CommandExecResponse;
import com.ruckus.command_service.service.CommandExecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

    @Autowired
    private CommandExecService commandExecService;

    @PostMapping("/execute-command")
    public CommandExecResponse executeCommand(@RequestBody CommandExecRequest commandExecRequest) {
        return commandExecService.execCommand(commandExecRequest);
    }

    @GetMapping("/get-command-result")
    public CommandExecResponse executeCommand(String commandId) {
        return commandExecService.getCommandResult(commandId);
    }
}
