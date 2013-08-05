package team.neo4j;

import static org.junit.Assert.*;
import org.junit.*;

import team.model.Team;
import team.model.TeamMate;

public class TestTeamGraph {

	public TestTeamGraph() {}

	@Test
	public void testDB() {

		String DB_PATH = "target/team-db";

		TeamGraph teamGraph = new TeamGraph(DB_PATH);

		Team team1 = teamGraph.addTeam(new Team("training liferay"));
		TeamMate teamMate1 = teamGraph.addTeamMate(new TeamMate("jeroldan@atsistemas.com"));
		teamGraph.enroll(team1, teamMate1);

	}
}