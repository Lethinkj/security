import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VPNConfiguration {

    public static void main(String[] args) {

        try {

            // VPN command
            String[] commands = {
                "sudo",
                "openvpn",
                "--config",
                "/path/to/config.ovpn"
            };

            ProcessBuilder builder = new ProcessBuilder(commands);

            builder.redirectErrorStream(true);

            Process process = builder.start();

            // Read terminal output
            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(process.getInputStream())
                );

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            // Wait for process completion
            int exitCode = process.waitFor();

            System.out.println("Process exited with code " + exitCode);

        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }
    }
}