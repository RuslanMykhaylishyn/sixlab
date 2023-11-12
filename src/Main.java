import java.util.ArrayList;
import java.util.Scanner;
class Patient {
    private String name;
    private int age;
    private String diagnosis;
    public Patient(String name, int age, String diagnosis) {
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Виберіть операцію:");
            System.out.println("1. Додати пацієнта");
            System.out.println("2. Показати список пацієнтів");
            System.out.println("3. Редагувати діагноз пацієнта");
            System.out.println("4. Видалити пацієнта");
            System.out.println("5. Вийти");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Ім'я пацієнта: ");
                    String name = scanner.nextLine();
                    System.out.print("Вік пацієнта: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Діагноз пацієнта: ");
                    String diagnosis = scanner.nextLine();
                    Patient patient = new Patient(name, age, diagnosis);
                    patients.add(patient);
                    System.out.println("Пацієнт доданий.");

                    break;
                case 2:
                    System.out.println("Список пацієнтів:");
                    for (Patient p : patients) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Введіть ім'я пацієнта для редагування діагнозу: ");
                    String patientName = scanner.nextLine();
                    for (Patient p : patients) {
                        if (p.getName().equalsIgnoreCase(patientName)) {
                            System.out.print("Новий діагноз: ");
                            String newDiagnosis = scanner.nextLine();
                            p.setDiagnosis(newDiagnosis);
                            System.out.println("Діагноз оновлений.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Введіть ім'я пацієнта для видалення: ");
                    String patientToRemove = scanner.nextLine();
                    patients.removeIf(p -> p.getName().equalsIgnoreCase(patientToRemove));
                    System.out.println("Пацієнт видалений.");
                    break;
                case 5:
                    System.out.println("Програма завершена.");
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір операції.");
                    break;
            }
        }
    }
}