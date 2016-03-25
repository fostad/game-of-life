package com.gameoflife.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	CellTest.class, BoardTest.class, ControllerTest.class, TopModelTest.class
})
public class TestSuite {
	
}
