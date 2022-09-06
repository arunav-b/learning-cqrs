package com.techbank.account.cmd.api.controllers;

import com.techbank.account.cmd.api.commands.DepositFundsCommand;
import com.techbank.account.common.dto.BaseResponse;
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException;
import com.techbank.cqrs.core.infra.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/depositFunds")
public class DepositFundsController {
  private final Logger logger = Logger.getLogger(DepositFundsController.class.getName());

  @Autowired private CommandDispatcher commandDispatcher;

  @PutMapping(path = "/{id}")
  public ResponseEntity<BaseResponse> depositFunds(
      @PathVariable(value = "id") String id, @RequestBody DepositFundsCommand command) {
    try {
      logger.info("Account-Id=" + id);
      command.setId(id);
      commandDispatcher.send(command);
      return new ResponseEntity<>(
          new BaseResponse("Deposit Funds completed successfully"), HttpStatus.OK);
    } catch (IllegalStateException | AggregateNotFoundException e) {
      logger.log(
          Level.WARNING, MessageFormat.format("Client made a bad request {0}", e.toString()));
      return new ResponseEntity<>(new BaseResponse(e.toString()), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      var errorMessage =
          MessageFormat.format(
              "Error while processing request for DepositFundsCommand for id {0}", id);
      logger.log(Level.SEVERE, errorMessage, e);
      return new ResponseEntity<>(new BaseResponse(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
