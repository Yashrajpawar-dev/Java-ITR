import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: ₹" + salary;
    }
}

public class test {
    static Scanner sc = new Scanner(System.in);
    static final String EMPLOYEE_FILE = "employees.dat";

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\n=== Java File Handling Projects ===");
            System.out.println("1. Student Report Card System");
            System.out.println("2. Employee Record Manager");
            System.out.println("3. File Word Frequency Counter");
            System.out.println("4. File Splitter");
            System.out.println("5. Directory File Organizer");
            System.out.println("6. Merge Text Files");
            System.out.println("7. Search Inside File");
            System.out.println("8. Encrypted File Writer");
            System.out.println("9. Copy Binary File");
            System.out.println("10. Log File Generator");
            System.out.println("11. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {


                
                case 1 -> studentReportCard();
                case 2 -> employeeManager();
                case 3 -> wordFrequencyCounter();
                case 4 -> fileSplitter();
                case 5 -> directoryOrganizer();
                case 6 -> mergeTextFiles();
                case 7 -> searchInFile();
                case 8 -> encryptedWriter();
                case 9 -> binaryCopy();
                case 10 -> logFileGenerator();
                case 11 -> System.exit(0);
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void studentReportCard() {
        try (BufferedReader r = new BufferedReader(new FileReader("students.txt"));
             BufferedWriter w = new BufferedWriter(new FileWriter("report_card.txt"))) {
            String line;
            DecimalFormat df = new DecimalFormat("#.00");
            while ((line = r.readLine()) != null) {
                String[] d = line.split("\\s+");
                String name = d[0]; int roll = Integer.parseInt(d[1]);
                int m1 = Integer.parseInt(d[2]), m2 = Integer.parseInt(d[3]), m3 = Integer.parseInt(d[4]);
                int total = m1 + m2 + m3;
                double avg = total / 3.0;
                String res = (m1 >= 35 && m2 >= 35 && m3 >= 35) ? "Pass" : "Fail";
                w.write("Name: " + name + ", Roll: " + roll + ", Total: " + total + ", Average: " + df.format(avg) + ", Result: " + res);
                w.newLine();
            }
            System.out.println("Report cards saved to report_card.txt");
        } catch (Exception e) { System.out.println("Error: " + e); }
    }

    static void employeeManager() {
        while (true) {
            System.out.println("\n-- Employee Manager --");
            System.out.println("1. Add 2. View 3. Delete 4. Update 5. Back");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1 -> {
                    List<Employee> list = readEmp();
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Salary: "); double sal = sc.nextDouble();
                    list.add(new Employee(id, name, sal));
                    writeEmp(list);
                }
                case 2 -> readEmp().forEach(System.out::println);
                case 3 -> {
                    List<Employee> list = readEmp();
                    System.out.print("ID to delete: "); int id = sc.nextInt();
                    list.removeIf(e -> e.id == id);
                    writeEmp(list);
                }
                case 4 -> {
                    List<Employee> list = readEmp();
                    System.out.print("ID to update: "); int id = sc.nextInt();
                    for (Employee e : list) {
                        if (e.id == id) {
                            System.out.print("New Salary: ");
                            e.salary = sc.nextDouble();
                        }
                    }
                    writeEmp(list);
                }
                case 5 -> { return; }
            }
        }
    }

    static List<Employee> readEmp() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(EMPLOYEE_FILE))) {
            return (List<Employee>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    static void writeEmp(List<Employee> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(EMPLOYEE_FILE))) {
            out.writeObject(list);
        } catch (Exception e) { System.out.println("Write error: " + e); }
    }

    static void wordFrequencyCounter() {
        try (BufferedReader r = new BufferedReader(new FileReader("input.txt"));
             PrintWriter w = new PrintWriter("word_count.txt")) {
            Map<String, Integer> map = new HashMap<>();
            String line;
            while ((line = r.readLine()) != null) {
                for (String word : line.toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+")) {
                    if (!word.isEmpty()) map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
            map.forEach((k, v) -> w.println(k + ": " + v));
            System.out.println("Word count written to word_count.txt");
        } catch (Exception e) { System.out.println(e); }
    }

    static void fileSplitter() {
        try (BufferedReader r = new BufferedReader(new FileReader("large.txt"))) {
            int lineCount = 0, fileNum = 1;
            BufferedWriter w = new BufferedWriter(new FileWriter("part" + fileNum + ".txt"));
            String line;
            while ((line = r.readLine()) != null) {
                if (lineCount == 100) {
                    w.close(); fileNum++; lineCount = 0;
                    w = new BufferedWriter(new FileWriter("part" + fileNum + ".txt"));
                }
                w.write(line); w.newLine(); lineCount++;
            }
            w.close();
            System.out.println("File split completed");
        } catch (Exception e) { System.out.println(e); }
    }

    static void directoryOrganizer() {
        File dir = new File("testDir");
        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                String ext = f.getName().contains(".") ? f.getName().substring(f.getName().lastIndexOf('.') + 1) : "others";
                File sub = new File(dir, ext);
                if (!sub.exists()) sub.mkdirs();
                f.renameTo(new File(sub, f.getName()));
            }
        }
        System.out.println("Files organized");
    }

    static void mergeTextFiles() {
        File dir = new File("mergeDir");
        try (BufferedWriter w = new BufferedWriter(new FileWriter("merged.txt"))) {
            for (File f : dir.listFiles((d, n) -> n.endsWith(".txt"))) {
                try (BufferedReader r = new BufferedReader(new FileReader(f))) {
                    String line;
                    while ((line = r.readLine()) != null) {
                        w.write(line); w.newLine();
                    }
                }
            }
            System.out.println("Merged to merged.txt");
        } catch (Exception e) { System.out.println(e); }
    }

    static void searchInFile() throws IOException {
        System.out.print("File: "); String file = sc.nextLine();
        System.out.print("Word: "); String word = sc.nextLine();
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line; int ln = 1;
            while ((line = r.readLine()) != null) {
                if (line.toLowerCase().contains(word.toLowerCase()))
                    System.out.println("Line " + ln + ": " + line);
                ln++;
            }
        }
    }

    static void encryptedWriter() {
        System.out.print("Text: ");
        String text = sc.nextLine();
        try (FileWriter fw = new FileWriter("encrypted.txt")) {
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    fw.write((char) ((c - base + 3) % 26 + base));
                } else fw.write(c);
            }
            System.out.println("Saved encrypted.txt");
        } catch (IOException e) { System.out.println(e); }
    }

    static void binaryCopy() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("source.jpg"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("copy.jpg"))) {
            byte[] buf = new byte[1024]; int len;
            while ((len = in.read(buf)) != -1) out.write(buf, 0, len);
            System.out.println("Image copied to copy.jpg");
        } catch (IOException e) { System.out.println(e); }
    }

    static void logFileGenerator() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter("process.log", true))) {
            for (int i = 0; i < 10; i++) {
                String t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                w.write(t + " - Running...");
                w.newLine();
                w.flush();
                Thread.sleep(5000);
            }
        } catch (Exception e) { System.out.println(e); }
    }
}
