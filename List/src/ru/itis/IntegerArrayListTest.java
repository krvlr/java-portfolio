package ru.itis;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import static org.junit.Assert.assertEquals;

/**
 * Created by KFU-user on 30.09.2016.
 */
public class IntegerArrayListTest {

    private static int GET_CORRECT_POSITION = 2;
    private  static int GET_CORRECT_ANSWER_ON_CORRECT_POSITION = 3;
    private  static int INCORRECT_POSITION = 10;

    IntegerArrayList testedList;

    @Before
    public void setUp() throws Exception {
        int testedData[] = {2, 5, 3, 4, 8};

        testedList = new IntegerArrayList(testedData);
    }

    @Test
    public void testGetOnCorrectData() throws Exception {
        int expected = 3;

        int actual = testedList.get(2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetOnIncorrectData() throws Exception{
        testedList.get(10);
    }

    @Test
    public void testAddOnCorrectData() throws Exception{
        int expected = 22;

        testedList.add(22);

        int actual = testedList.get(5);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddByPositionOnCorrectData() throws Exception{
        int expected = 99;

        testedList.add(99,1);

        int actual = testedList.get(1);

        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteOnCorrectData() throws Exception{
        int expected = 3;

        testedList.delete(5);

        int actual = testedList.get(1);

        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteByPositionOnCorrectData() throws Exception{
        int expected = 8;

        testedList.deleteByPosition(3);

        int actual = testedList.get(3);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindOnCorrectData() throws Exception{
        int expected = 2;

        int actual = testedList.find(3);

        assertEquals(expected, actual);
    }
}