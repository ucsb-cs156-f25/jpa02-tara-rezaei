package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Tara R.", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void testgetName_returns_correct_githubId() {
	assertEquals("tararezaei", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
	Team t = Developer.getTeam();
	assertEquals("f25-11", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_names(){
	Team t = Developer.getTeam();
	assertTrue(t.getMembers().contains("Tara R."), "Team should contain Tara R.");
	assertTrue(t.getMembers().contains("Avaneesh V."), "Team should contain Avaneesh V.");
	assertTrue(t.getMembers().contains("Ethan K."), "Team should contain Ethan K.");
	assertTrue(t.getMembers().contains("Ethan C."), "Team should contain Ethan C.");
	assertTrue(t.getMembers().contains("Jehmiah P."), "Team should contain Jehmiah P.");
	assertTrue(t.getMembers().contains("Sagnik B."), "Team should contain Sagnik B.");
    }



}
