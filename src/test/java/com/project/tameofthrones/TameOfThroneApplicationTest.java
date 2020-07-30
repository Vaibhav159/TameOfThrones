package com.project.tameofthrones;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TameOfThroneApplicationTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void testForNoAlliedRulers() throws FileNotFoundException {

    String path1 = "/home/vaibhav/workspace/TameOfThrones/src/main/resources/input1.txt";
    TameOfThroneApplication.main(new String[]{path1});
    assertEquals("NONE\n", outContent.toString());
  }


  @Test
  public void testForAlliedRulers() throws FileNotFoundException {

    String path1 = "/home/vaibhav/workspace/TameOfThrones/src/main/resources/input.txt";
    TameOfThroneApplication.main(new String[]{path1});
    assertEquals("SPACE AIR LAND ICE\n", outContent.toString());
  }
}