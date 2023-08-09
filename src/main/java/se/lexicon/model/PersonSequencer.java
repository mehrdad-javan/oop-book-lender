package se.lexicon.model;

public class PersonSequencer {

  private static int sequencer = 0;

  public static int getNextId(){
    return ++sequencer;
  }

}