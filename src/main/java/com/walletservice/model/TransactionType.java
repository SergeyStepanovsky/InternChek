package com.walletservice.model;

/**
 * ������������ TransactionType ������������ ����� ���� ����������, ������� ����� ���� ��������� � ������� ��������.
 */
public enum TransactionType {

    /**
     * ��������� ����������, ������� ������������ ����� ���������� ������� �� ����.
     */
    CREDIT("Credit Transaction", "Adding funds to the account"),

    /**
     * ��������� ����������, ������� ������������ ����� �������� ������� �� �����.
     */
    DEBIT("Debit Transaction", "Removing funds from the account");

    /**
     * ������������ ��� ���� ����������.
     */
    private final String displayName;

    /**
     * �������� ���� ����������.
     */
    private final String description;

    /**
     * ����������� ��� ������������� ���� ���������� � ��� ������������ ������ � ���������.
     *
     * @param displayName ������������ ��� ���� ����������.
     * @param description �������� ���� ����������.
     */
    TransactionType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    /**
     * �������� ������������ ��� ���� ����������.
     *
     * @return ������������ ��� ���� ����������.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * �������� �������� ���� ����������.
     *
     * @return �������� ���� ����������.
     */
    public String getDescription() {
        return description;
    }

    /**
     * ���������������� ����� ��� ����������� ������, �������������� ��� ����������.
     *
     * @return ������, �������������� ��� ����������.
     */
    @Override
    public String toString() {
        return displayName + ": " + description;
    }
}
