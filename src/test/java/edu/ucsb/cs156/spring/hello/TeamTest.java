package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_bool() {
        Team test_team;
        test_team = new Team("test-team");
        Team blank_team;
        blank_team = new Team("");
        String test_string = "";
        assertTrue(team.equals(team), "Team object should be equal to itself.");
        assertFalse(team.equals(test_string), "Team object should not be equal to a different object.");
        assertTrue(team.equals(test_team), "Team objects with identical fields should be equal.");
        assertFalse(team.equals(blank_team), "Team objects with different fields should not be equal.");
    }

    @Test
    public void hashCode_equal_for_equal_teams() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
