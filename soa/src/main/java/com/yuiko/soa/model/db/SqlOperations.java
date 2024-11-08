package com.yuiko.soa.model.db;

public enum SqlOperations {
    CONTAINS("contains", ""),

    MORE("more", ">"),

    MORE_OR_EQUALS("moreOrEquals", ">="),

    LESS("less", "<"),

    LESS_OR_EQUALS("lessOrEquals", "<="),

    EQUALS("equals", "=");

    private final String value;
    private final String operation;

    SqlOperations(String value, String operation) {
        this.value = value;
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static SqlOperations fromValue(String value) {
        for (SqlOperations op : SqlOperations.values()) {
            if (op.getValue().equals(value)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
