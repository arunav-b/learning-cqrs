# Learning CQRS

> We'll learn about the CQRS Architectural Pattern by building a project a Bank Account Project

<br/>

## Some keep concepts

### Message

- Command
- Events
- Query

### Command

Command is a message that needs to be processed.

### Event

Event is a message that is generated after processing a message.

### Query

Query is an enquiry on a domain object.

<br/>

## Mediator Pattern

Mediator design pattern can be used for dispatching commands to appropriate command handlers.

 <img src="./bank-account/images/mediator.png" width="100%">

### Command Dispatcher

It is a mediator that manages the distribution of messages(commands) among other objects.
