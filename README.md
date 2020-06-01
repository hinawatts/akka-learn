# akka-learn
This repository aims to provide step by step guide for implementing akka-http based service using sbt compiler and scala programming language.
Repository contains different examples to learn the concepts of sbt, scala and akka.

### Usage
To use this effectively, navigate through different branches in the repository to learn the concepts step by step. Branch naming convention -
<_Sequence number_>-<_Concept_> where Sequence number represents the order and concept refers to the area around which current branch is implemented.
For example - '1 - SBT-multi-module' refers to first step to create the project where it focuses on learning how to create multi module projects in scaka.

### Branch Details
* 1-SBT-multi-module :- This branch contains an example on how to create multi module projects using SBT.
* 2-akka-http-GET :- Contains implementation of akka-http GET with following features - 
    * Implements Akka actor for handling GET request
    * Defines routes for GET API that sends message to actor on receiving request
    * Marshaller that converts the response received from GET API(actor) to JSON format, so that it can be returned to the client.
* _WIP_ : <Would be adding branches around implementation of filters on request receive, post requests and custom directives>