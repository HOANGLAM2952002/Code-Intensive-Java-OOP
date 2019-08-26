public class Equation2 {
    float a, b, c;
    float x1, x2;
    int numberOfSolutions;
    Equation2(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    void execute(){
        float delta = b*b - 4*a*c;
        if (delta < 0) {
            numberOfSolutions = 0;
//            System.out.println("Phuong trinh vo nghiem.");
            return;
        } else {
            if (delta == 0) {
                x1 = -b / (2 * a);
                // x1 = x1 = -b / (2 * a);
                numberOfSolutions = 1;
                return;
//                System.out.println("Phuong trinh co " + numberOfSolutions + " nghiem duy nhat.");
//                System.out.println("Nghiem la: " + x1);
            } else {
                x1 = (float)(-b + Math.sqrt(delta)) / (2*a);
//                x2 = (float)(-b - Math.sqrt(delta)) / (2*a);
                x2 = -b/a - x1;
                numberOfSolutions = 2;
//                System.out.println("Phuong trinh co " + numberOfSolutions + " nghiem phan biet.");
//                System.out.println("Nghiem 1 la: " + x1);
//                System.out.println("Nghiem 2 la: " + x2);
                return;
            }
        }
    }

    void printSolution(){
        switch (numberOfSolutions) {
            case 0:
                System.out.println("Vo nghiem.");
                break;
            case 1:
                System.out.println("Mot nghiem duy nhat:");
                System.out.println(x1);
                break;
            case 2:
                System.out.println("Hai nghiem phan biet:");
                System.out.println(x1 + " " + x2);
                break;
        }
    }
}
