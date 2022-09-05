# Learning CQRS

> We'll learn about the CQRS Architectural Pattern by building a project a Bank Account Project

<br/>

## Some keep concepts

### Message

A message can be:

- Command
- Event

### Command

Command is a message that describes something that we want it to be done. It encapsulates the information required to
undertake the action.

### Event

Events are objects that describe something that has occurred in the application. A typical source of events is the
aggregate. When something has occurred with the aggregate an event is generated.

### Aggregate

- Aggregate is an entity or group of entities that is always kept in a consistent state.
- Aggregate root is the entity within aggregate that is responsible for maintaining the consistent state.
- Primary building block for implementing a command model in any CQRS application.

### Query

Query is an enquiry on a domain object.

<br/>

## Mediator Pattern

Mediator design pattern can be used for dispatching commands to appropriate command handlers.

 <img src="./bank-account/images/mediator.png" width="100%">

### Command Dispatcher

It is a mediator that manages the distribution of messages(commands) among other objects.
