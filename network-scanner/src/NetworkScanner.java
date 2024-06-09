import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class NetworkScanner {
    public static void main(String[] args) {
        while (true) {
            try {
                String myIp = InetAddress.getLocalHost().getHostAddress();
                System.out.println("My IP Address: " + myIp);

                for (int i = 1; i < 255; i++) {
                    String subnet = "192.168.1.";
                    String host = subnet + i;
                    if (InetAddress.getByName(host).isReachable(100)) {
                        System.out.println("Found device: " + host);
                        logDevice(host, myIp);
                    }
                }
                Thread.sleep(10000);  // Sleep for 10 seconds
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void logDevice(String ipAddress, String myIp) {
        String logEntry = new Date() + " - Found device: " + ipAddress + "\n";
        try {
            Files.write(Paths.get("/logs/"+ myIp+"logs.txt"), logEntry.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
