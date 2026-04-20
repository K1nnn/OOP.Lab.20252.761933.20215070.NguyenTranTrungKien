

import java.util.Scanner;
import java.lang.Math;

public class Equation {
    public static void phuongtrinhbacnhat(double a, double b) {
        if (a == 0 && b == 0)
            System.out.println("Infinite solutions\n");
        else if (a == 0 && b != 0)
            System.out.println("No solution \n ");
        else {
            double x = -b / a;
            System.out.println("Solution of equation is x = " + Math.ceil(x * 1000) / 1000);
        }
    }

    public static void hephuongtrinh(double a1, double a2, double b1, double b2, double c1, double c2) {
        double D = a1 * b2 - a2 * b1;
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;
        if (D == 0 && Dx == 0 && Dy == 0)
            System.out.println("Infinite Solutions\n");
        else if ((D == 0 && Dx != 0) || (D == 0 && Dy != 0))
            System.out.println("No Solution\n");
        else
            System.out.println(
                    "x: " + Math.ceil((Dx / D) * 1000) / 1000 + " y: " + Math.ceil((Dy / D) * 1000) / 1000 + "\n");
    }

    public static void phuongtrinhbac2(double a, double b, double c) {
        if (a == 0 && b != 0)
            System.out.println("Solution of equation is " + Math.ceil((-c / b) * 1000) / 1000);
        else if (a == 0 && b == 0 && c == 0)
            System.out.println("Infinite solutions\n");
        else if (a == 0 && b == 0 && c != 0)
            System.out.println("No solution\n");
        else {
            double denta = b * b - 4 * a * c;
            if (denta > 0) {
                double x1 = Math.ceil(((-b + Math.sqrt(denta)) / (2 * a)) * 1000) / 1000;
                double x2 = Math.ceil(((-b - Math.sqrt(denta)) / (2 * a)) * 1000) / 1000;
                System.out.println("\n x1 = " + x1 + "\n x2 = " + x2);
            } else if (denta == 0) {
                double nghiemkep = Math.ceil((-b / (2 * a)) * 1000) / 1000;
                System.out.println("Solution of equation  " + nghiemkep);
            }
            if (denta < 0)
                System.out.println("No solution\n");
        }

    }

    public static void Menu() {
        System.out.println(
                "\n1) First Degree Equation (1 varibale)\n2) First Degree Equation (1 varibale)\n3) Second Degree Equation\n");
    }

    public static void main(String[] args) {
        double a, b, c;
        Menu();
        try (Scanner sc = new Scanner(System.in)) {
            int chucnang = sc.nextInt();
            if (chucnang == 1) {
                System.out.println("ax+b=0");
                System.out.print("Input a = ");
                a = sc.nextDouble();
                System.out.print("Input b = ");
                b = sc.nextDouble();
                phuongtrinhbacnhat(a, b);
            }
            if (chucnang == 2) {
                double a1, a2, b1, b2, c1, c2;
                System.out.println("a1x + b1y = c1, a2x + b2y =c2");
                System.out.print("Input a1 = ");
                a1 = sc.nextDouble();
                System.out.print("Input b1 = ");
                b1 = sc.nextDouble();
                System.out.print("Input");
                c1 = sc.nextDouble();
                System.out.print("Input = ");
                a2 = sc.nextDouble();
                System.out.print("Input = ");
                b2 = sc.nextDouble();
                System.out.print("Input c2 = ");
                c2 = sc.nextDouble();
                hephuongtrinh(a1, a2, b1, b2, c1, c2);
            }

            if (chucnang == 3) {
                System.out.println("aX^2 + bX + c = 0");
                System.out.print("Input a = ");
                a = sc.nextDouble();
                System.out.print("Input b = ");
                b = sc.nextDouble();
                System.out.print("Input c = ");
                c = sc.nextDouble();
                phuongtrinhbac2(a, b, c);
            }
        }

    }
}