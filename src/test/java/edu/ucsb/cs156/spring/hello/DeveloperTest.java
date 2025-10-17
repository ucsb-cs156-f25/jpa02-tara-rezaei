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
	assertTrue(t.getMembers().contains("ETHAN YUI"), "Team should contain ETHAN YUI");
	assertTrue(t.getMembers().contains("SAGNIK"), "Team should contain SAGNIK");
	assertTrue(t.getMembers().contains("JEHMIAH ALEXANDER JAM"), "Team should contain JEHMIAH ALEXANDER JAM");
	assertTrue(t.getMembers().contains("ETHAN DONGGUN"), "Team should contain ETHAN DONGGUN");
	assertTrue(t.getMembers().contains("AVANEESH"), "Team should contain AVANEESH");
	assertTrue(t.getMembers().contains("TARA"), "Team should contain TARA");
    }



}
