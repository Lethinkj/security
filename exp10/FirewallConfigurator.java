public class FirewallConfigurator {

    public static void addFirewallRule(String ruleName) {

        try {

            String command =
                "netsh advfirewall firewall add rule name=\"" +
                ruleName +
                "\" protocol=TCP dir=in localport=80 action=allow";

            Process process = Runtime.getRuntime().exec(command);

            process.waitFor();

            if (process.exitValue() == 0) {

                System.out.println("Firewall rule added successfully.");

            } else {

                System.out.println("Error adding firewall rule.");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Example
        addFirewallRule("My Port 80");
    }
}