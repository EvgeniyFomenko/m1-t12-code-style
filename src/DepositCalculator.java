import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositTerm ) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositTerm);

        return calculate(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositTerm) {
        return calculate(depositAmount + depositAmount * yearRate * depositTerm, 2);
    }

    double calculate(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int depositTerm;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");

        int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositTerm = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double result = 0;

        if (action == 1) {
            result = calculateSimplePercent(depositAmount, 0.06, depositTerm);
        }
        else if (action == 2) {
            result = calculateComplexPercent(depositAmount, 0.06, depositTerm);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositTerm + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
