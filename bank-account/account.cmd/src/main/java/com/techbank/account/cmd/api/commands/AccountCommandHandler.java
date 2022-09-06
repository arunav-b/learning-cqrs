package com.techbank.account.cmd.api.commands;

import com.techbank.account.cmd.domain.AccountAggregate;
import com.techbank.cqrs.core.handlers.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AccountCommandHandler implements CommandHandler {

  private final Logger logger = Logger.getLogger(AccountCommandHandler.class.getName());
  @Autowired EventSourcingHandler<AccountAggregate> eventSourcingHandler;

  @Override
  public void handle(OpenAccountCommand command) {
    var aggregate = new AccountAggregate(command);
    eventSourcingHandler.save(aggregate);
  }

  @Override
  public void handle(CloseAccountCommand command) {
    var aggregate = eventSourcingHandler.getById(command.getId());
    aggregate.closeAccount();
    eventSourcingHandler.save(aggregate);
  }

  @Override
  public void handle(DepositFundsCommand command) {
    var aggregate = eventSourcingHandler.getById(command.getId());
    logger.info("Aggregate=" + aggregate.getId());
    aggregate.depositFunds(command.getAmount());
    eventSourcingHandler.save(aggregate);
  }

  @Override
  public void handle(WithdrawFundsCommand command) {
    var aggregate = eventSourcingHandler.getById(command.getId());
    if (command.getAmount() > aggregate.getBalance())
      throw new IllegalStateException("Withdrawal declined, insufficient funds");
    aggregate.withdrawFunds(command.getAmount());
    eventSourcingHandler.save(aggregate);
  }
}