package functions;


import java.util.Arrays;

public class SkoFunction implements MathFunction {
    private double[] data;
    public SkoFunction(double[] data) {
        this.data = data;
    }

    public double calculate() {
        if (data.length < 2) {
            throw new IllegalArgumentException("Array length should be at least 2");
        }
        double mean = calculateMean();
        double sumOfSquaredDifferences = 0.0;
        for (double value : data) {
            double difference = value - mean;
            sumOfSquaredDifferences += difference * difference;
        }
        return Math.sqrt(sumOfSquaredDifferences / (data.length - 1));
    }
    private double calculateMean() {
        double sum = Arrays.stream(data).sum();
        return sum / data.length;
    }

    @Override
    public double apply(double x) {
        return 0;
    }
}