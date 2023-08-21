package math_tasks;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static DecimalFormat decimalFormat = new DecimalFormat("#.####");

	public static void main(String[] arg) {

		System.out.println("Сколько задач вы хотите решить? ");
		int tasksAmt = valid();
		int solvedTasks = task(tasksAmt);
		System.out.println("Вы решили " + solvedTasks + " задачи из " + tasksAmt);
		scanner.close();
	}

	public static int valid() {
		int num = 0;
		String fail = "Введите целое положительное число! ";
		do {
			try {
				num = scanner.nextInt();
				if (num < 0)
					System.out.println(fail);
				else
					return num;
			} catch (InputMismatchException e) {
				System.out.println(fail);
				scanner.next();
			}
		} while (true);

	}

	public static double solution() {
		double num;
		String fail = "Введите число! ";
		do {
			try {
				num = scanner.nextDouble();
				return num;
			} catch (InputMismatchException e) {
				System.out.println(fail);
				scanner.next();
			}
		} while (true);

	}

	public static int task(int count) {
		int erfolg = 0;
		int operationNumber;
		double a, b, c;
		c = 0;
		for (int i = 1; i <= count; i++) {
			System.out.println("Задача " + i + ": Сколько будет ");

			operationNumber = (int) (Math.random() * 4);
			a = Math.round(Math.random() * 100);
			b = Math.round(Math.random() * 100);
			switch (operationNumber) {
			case 0:
				System.out.print(decimalFormat.format(a) + " + " + decimalFormat.format(b) + " = ");
				c = a + b;
				break;
			case 1:
				System.out.print(decimalFormat.format(a) + " - " + decimalFormat.format(b) + " = ");
				c = a - b;
				break;
			case 2:
				System.out.print(decimalFormat.format(a) + " * " + decimalFormat.format(b) + " = ");
				c = a * b;
				break;

			case 3:

				if (b == 0) {
					i--;
					break;
				}
				System.out.print(decimalFormat.format(a) + " / " + decimalFormat.format(b) + " = ");
				c = a / b;
				break;
			}
			c = Math.round(c * 1000.0) / 1000.0;

			double userSolution = solution();
			if (userSolution == c) {
				System.out.println("Верно!");

				erfolg++;
			} else
				System.out.println("Неверно. Правильный ответ: " + decimalFormat.format(c));
		}
		return erfolg;

	}

}
