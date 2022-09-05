# Learning CQRS

> We'll learn about the CQRS Architectural Pattern by building a project a Bank Account Project

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

## Mediator Pattern

 <img src="./images/mediator.png" width="25%">

### Command Dispatcher

It is a mediator that manages the distribution of messages(commands) among other objects.
