package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test 
    public void equals_case1_sameObject() {
	assert(team.equals(team));
    }

    @Test
    public void equals_case2_differntClass() {
	assertFalse(team.equals(null));
    }

    @Test
    public void equals_case3_pt1() {
	Team otherTeam = new Team("test-team");
	assertTrue(team.equals(otherTeam));
    }

    @Test
    public void equals_case3_pt2() {
	Team otherTeam = new Team("different-team");
	assertFalse(team.equals(otherTeam));
    }

    @Test
    public void equals_case3_pt3() {
	Team otherTeam = new Team("different-team");
	otherTeam.addMember("Gaucho");
	assertFalse(team.equals(otherTeam));
    }

    
    @Test
    public void toString_returns_correct_string() {
	assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_hashCode() {
	int result = team.hashCode();
	int expectedResult = -1226298695;
	assertEquals(expectedResult, result);
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
