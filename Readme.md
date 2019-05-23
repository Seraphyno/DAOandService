## Login

This project contains 3 modules:
1. `application`: represents the _runner_ and contains only the `Main#main(String[] args)` 
2. `database`: represents the _'database'_ layer. Give that we don't know database connections yet 
we just initialize a list and a map contains some users of type `IUser` and a service which provides
access to the resources
3. `form`: represents the interaction point between layers, basically here should be the logic for 
UI communication

The end-goal of this project is to exemplify how `Optional` should come in the picture, how 
the Java `Stream` should help and as much as possible, how the *lambdas* can work