package com.university;

public enum EFunction {
    SIN("sin") {
        @Override
        public double apply(double value) {
            return Math.sin(Math.toRadians(value));
        }
    },
    COS("cos") {
        @Override
        public double apply(double value) {
            return Math.cos(Math.toRadians(value));
        }
    },
    SQRT("sqrt") {
        @Override
        public double apply(double value) {
            if (value < 0) {
                throw new IllegalArgumentException("Корень из отрицательного числа");
            }
            return Math.sqrt(value);
        }
    };

    private final String name;

    EFunction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double apply(double value);

    public static EFunction fromName(String name) {
        for (EFunction func : values()) {
            if (func.getName().equals(name)) {
                return func;
            }
        }
        throw new IllegalArgumentException("Неизвестная функция: " + name);
    }
}