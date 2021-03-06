package com.project.tameofthrones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
  public void testForNoAlliedRulers() throws IOException {
    String path1 = "src/test/resources/input1.txt";
    TameOfThroneApplication.main(new String[]{path1});
    assertEquals("NONE\n", outContent.toString());
  }

  @Test
  public void testForAlliedRulers() throws IOException {

    String path2 = "src/test/resources/input.txt";
    TameOfThroneApplication.main(new String[]{path2});
    assertEquals("SPACE AIR LAND ICE\n", outContent.toString());
  }

  @Test
  public void testForFileNotFound() {

    String path3 = "src/test/resources/input999.txt";
    assertThrows(Exception.class,
        () -> TameOfThroneApplication.main(new String[]{path3}));
  }

  @Test
  public void testForDuplicates() throws IOException {

    String path2 = "src/test/resources/input2.txt";
    TameOfThroneApplication.main(new String[]{path2});
    assertEquals("NONE\n", outContent.toString());
  }
}