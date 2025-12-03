import java.util.Scanner;

public class Lab21 {
    private final long hrn;
    private final byte coin;

    public Lab21(long hrn, byte coin) {
        if (coin >= 100 || coin < 0) {
            hrn += coin / 100;
            coin = (byte) (coin % 100);
        }
        this.hrn = hrn;
        this.coin = coin;
    }

    public Lab21(double amount) {
        hrn = (long) amount;
        coin = (byte) Math.round((amount - hrn) * 100);
    }

    private long toTotalcoin() {
        return hrn * 100 + coin;
    }

    private static Lab21 fromTotalcoin(long total) {
        long h = total / 100;
        byte k = (byte) (total % 100);
        return new Lab21(h, k);
    }

    public Lab21 add(Lab21 other) {
        return fromTotalcoin(this.toTotalcoin() + other.toTotalcoin());
    }

    public Lab21 subtract(Lab21 other) {
        return fromTotalcoin(this.toTotalcoin() - other.toTotalcoin());
    }

    public Lab21 divide(Lab21 other) {
        double ratio = (double) this.toTotalcoin() / other.toTotalcoin();
        return new Lab21(ratio);
    }

    public Lab21 divideByNumber(double number) {
        return fromTotalcoin(Math.round(this.toTotalcoin() / number));
    }

    public int compareTo(Lab21 other) {
        return Long.compare(this.toTotalcoin(), other.toTotalcoin());
    }

    public boolean equals(Lab21 other) {
        return this.toTotalcoin() == other.toTotalcoin();
    }

    public boolean greaterThan(Lab21 other) {
        return this.compareTo(other) > 0;
    }

    public boolean lessThan(Lab21 other) {
        return this.compareTo(other) < 0;
    }

    @Override
    public String toString() {
        return String.format("%d,%02d hrn", hrn, coin);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first amount (hrn): ");
        long hrn1 = scanner.nextLong();

        System.out.print("Enter first amount (coin): ");
        byte coin1 = scanner.nextByte();

        System.out.print("Enter second amount (hrn): ");
        long hrn2 = scanner.nextLong();

        System.out.print("Enter second amount (coin): ");
        byte coin2 = scanner.nextByte();

        Lab21 m1 = new Lab21(hrn1, coin1);
        Lab21 m2 = new Lab21(hrn2, coin2);

        System.out.println("\nm1 = " + m1);
        System.out.println("m2 = " + m2);
        System.out.println("Sum: " + m1.add(m2));
        System.out.println("Subtraction: " + m1.subtract(m2));
        System.out.println("Division m1 by m2: " + m1.divide(m2));
        System.out.println("Division m1 by 3: " + m1.divideByNumber(3));
        System.out.println("m1 > m2: " + m1.greaterThan(m2));
        System.out.println("m1 < m2: " + m1.lessThan(m2));
        System.out.println("m1 == m2: " + m1.equals(m2));

        scanner.close();
    }
}