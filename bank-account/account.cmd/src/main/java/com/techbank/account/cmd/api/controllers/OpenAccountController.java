package com.techbank.account.cmd.api.controllers;

import com.techbank.account.cmd.api.commands.OpenAccountCommand;
import com.techbank.account.cmd.api.dto.OpenAccountResponse;
import com.techbank.account.common.dto.BaseResponse;
import com.techbank.cqrs.core.infra.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
  @RequestMapping(path = "/api/v1/openBankAccount")
public class OpenAccountController {
  private final Logger logger = Logger.getLogger(OpenAccountController.class.getName());

  @Autowired private CommandDispatcher commandDispatcher;

  @PostMapping
  public ResponseEntity<BaseResponse> openAccount(@RequestBody OpenAccountCommand command) {
    var id = UUID.randomUUID().toString();
    command.setId(id);
    try {
      commandDispatcher.send(command);
      return new ResponseEntity<>(
          new OpenAccountResponse("Bank account creation completed successfully", id),
          HttpStatus.CREATED);
    } catch (IllegalStateException e) {
      logger.log(
          Level.WARNING, MessageFormat.format("Client made a bad request {0}", e.toString()));
      return new ResponseEntity<>(new BaseResponse(e.toString()), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      var errorMessage =
          MessageFormat.format(
              "Error while processing request for OpenAccountCommand for id {0}", id);
      logger.log(Level.SEVERE, errorMessage, e);
      return new ResponseEntity<>(new BaseResponse(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
