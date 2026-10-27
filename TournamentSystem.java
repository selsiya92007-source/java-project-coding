import java.util.*;

class Team {
    String teamName;
    ArrayList<String> players;

    Team(String name) {
        teamName = name;
        players = new ArrayList<>();
    }
}

public class TournamentSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Team> teams = new ArrayList<>();
    static HashMap<String, String> results = new HashMap<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Sports Tournament System ---");
            System.out.println("1. Register Team");
            System.out.println("2. View Teams");
            System.out.println("3. Schedule Match");
            System.out.println("4. Update Result");
            System.out.println("5. View Results");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerTeam();
                    break;
                case 2:
                    viewTeams();
                    break;
                case 3:
                    scheduleMatch();
                    break;
                case 4:
                    updateResult();
                    break;
                case 5:
                    viewResults();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void registerTeam() {
        System.out.print("Enter Team Name: ");
        String name = sc.nextLine();
        Team team = new Team(name);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter player " + (i + 1) + ": ");
            team.players.add(sc.nextLine());
        }

        teams.add(team);
        System.out.println("Team Registered Successfully!");
    }

    static void viewTeams() {
        if (teams.isEmpty()) {
            System.out.println("No teams registered.");
            return;
        }

        for (Team t : teams) {
            System.out.println("\nTeam: " + t.teamName);
            System.out.println("Players: " + t.players);
        }
    }

    static void scheduleMatch() {
        if (teams.size() < 2) {
            System.out.println("Not enough teams!");
            return;
        }

        System.out.println("Available Teams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(i + ". " + teams.get(i).teamName);
        }

        System.out.print("Select Team 1 index: ");
        int t1 = sc.nextInt();
        System.out.print("Select Team 2 index: ");
        int t2 = sc.nextInt();
        sc.nextLine();

        String match = teams.get(t1).teamName + " vs " + teams.get(t2).teamName;
        results.put(match, "Pending");

        System.out.println("Match Scheduled: " + match);
    }

    static void updateResult() {
        if (results.isEmpty()) {
            System.out.println("No matches found.");
            return;
        }

        for (String match : results.keySet()) {
            System.out.println(match);
        }

        System.out.print("Enter match name: ");
        String matchName = sc.nextLine();

        if (results.containsKey(matchName)) {
            System.out.print("Enter result: ");
            String res = sc.nextLine();
            results.put(matchName, res);
            System.out.println("Result Updated!");
        } else {
            System.out.println("Match not found!");
        }
    }

    static void viewResults() {
        if (results.isEmpty()) {
            System.out.println("No results available.");
            return;
        }

        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}