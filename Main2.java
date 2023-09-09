import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main2 {
    public static void main(String[] args) {
        List<Integer> processPIDs = getAllProcessPIDs();
        Collections.sort(processPIDs);// ��������� ������ PID
        for (int pid : processPIDs) {// ������� ��������������� ������ PID
            System.out.println("PID: " + pid);
        }
    }
    public static List<Integer> getAllProcessPIDs() {
        List<Integer> processPIDs = new ArrayList<>();
        try {
            Process process = new ProcessBuilder("jps").start();// ��������� ������� jps ��� ��������� ������ PID
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");// ��������� ������ � ��������� PID � ������
                if (parts.length >= 1) {
                    try {
                        int pid = Integer.parseInt(parts[0]);
                        processPIDs.add(pid);
                    } catch (NumberFormatException e) {// ���������� ������������ ������
                    }
                }
            }
            process.waitFor();// ���������� ���������� �������� jps
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return processPIDs;
    }
}