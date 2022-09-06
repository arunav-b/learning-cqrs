package com.techbank.account.query.infra.consumers;

import com.techbank.account.common.events.AccountClosedEvent;
import com.techbank.account.common.events.AccountOpenedEvent;
import com.techbank.account.common.events.FundsDepositedEvent;
import com.techbank.account.common.events.FundsWithdrawnEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
  public void consume(@Payload AccountOpenedEvent event, Acknowledgment ack);

  public void consume(@Payload FundsDepositedEvent event, Acknowledgment ack);

  public void consume(@Payload FundsWithdrawnEvent event, Acknowledgment ack);

  public void consume(@Payload AccountClosedEvent event, Acknowledgment ack);
}
