package team.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;

import team.model.Team;
import team.model.TeamMate;

class TeamGraph {
	
	String dbPath;
 	private static GraphDatabaseService graphDb;
	private static Index<Node> teamIndex;
	private static Index<Node> teamMateIndex;

	private static final String TEAMNAME_KEY = "name";
	private static final String TEAMMATEEMAIL_KEY = "email";

	public TeamGraph(final String dbPath) {
		this.dbPath = dbPath;
		init();
	}

	public void init() {
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( dbPath );
		teamIndex = graphDb.index().forNodes("teams");
		teamMateIndex = graphDb.index().forNodes("teamMates");
		registerShutdownHook();
	}

	public static void shutdown() {
		graphDb.shutdown();
	}

	public Team addTeam(Team newTeam) {
		Transaction tx = graphDb.beginTx();
		try {
			Node node = graphDb.createNode();
			node.setProperty( TEAMNAME_KEY, newTeam.name);
			teamIndex.add( node, TEAMNAME_KEY, newTeam.name );
			return newTeam;
		} finally {
			tx.finish();
		}
	}

	public TeamMate addTeamMate(TeamMate newTeamMate) {
		Transaction tx = graphDb.beginTx();
		try {
			Node node = graphDb.createNode();
			node.setProperty("email", newTeamMate.email);
			teamMateIndex.add(node, TEAMMATEEMAIL_KEY, newTeamMate.email);
			return newTeamMate;
		} finally {
			tx.finish();
		}
	}

	public void enroll(Team team, TeamMate teamMate) {
		Transaction tx = graphDb.beginTx();
		try {
			Node node = graphDb.createNode();
			node.setProperty("email", teamMate.email);
		} finally {
			tx.finish();
		}
	}

	private static void registerShutdownHook()
	{
		Runtime.getRuntime().addShutdownHook( new Thread() {
			@Override
			public void run() {
				shutdown();
			}
		});
	}

}