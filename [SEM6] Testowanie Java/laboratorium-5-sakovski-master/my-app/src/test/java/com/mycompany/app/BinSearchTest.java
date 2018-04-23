package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class BinSearchTest
{
  @Test
  void elementInBeginningOfArray() {
    int[] array = {10,11,12,13,14,15};
    int number = 10;
    assertEquals(0, BinSearch.binarySearch(array, number));
  }

      @Test
      void elementInMiddleOfArray() {
        int[] array = {10,11,12,13,14,15};
        int number = 12;
        assertEquals(2, BinSearch.binarySearch(array, number));
      }

      @Test
      void elementInEndOfArray() {
        int[] array = {10,11,12,13,14,15};
        int number = 15;
        assertEquals(5, BinSearch.binarySearch(array, number));
      }

      @Test
      void elementNotInArray() {
        int[] array = {10,11,12,13,14,15};
        int number = 9;
        assertEquals(-1, BinSearch.binarySearch(array, number));
      }

      @Test
      void NotInOneElemArray() {
        int[] array = {10};
        int number = 9;
        assertEquals(-1, BinSearch.binarySearch(array, number));
      }

      @Test
      void InOneElemArray() {
        int[] array = {10};
        int number = 10;
        assertEquals(0, BinSearch.binarySearch(array, number));
      }
}
