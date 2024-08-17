package PersoFI.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.UUID;

public class TransactionTest {

    private Transaction transaction;
    private final LocalDate date = LocalDate.of(2023, 5, 1);
    private final double amount = 100.00;
    private final String category = "Groceries";
    private final String description = "Weekly shopping";
    private final Transaction.TransactionType type = Transaction.TransactionType.EXPENSE;

    @Before
    public void setUp() {
        transaction = new Transaction(date, amount, category, description, type);
    }

    @Test
    public void testTransactionCreation() {
        assertNotNull(transaction);
        assertNotNull(transaction.getId());
        assertTrue(transaction.getId() instanceof UUID);
        assertEquals(date, transaction.getDate());
        assertEquals(amount, transaction.getAmount(), 0.001);
        assertEquals(category, transaction.getCategory());
        assertEquals(description, transaction.getDescription());
        assertEquals(type, transaction.getType());
    }

    @Test
    public void testSetDate() {
        LocalDate newDate = LocalDate.of(2023, 5, 2);
        transaction.setDate(newDate);
        assertEquals(newDate, transaction.getDate());
    }

    @Test
    public void testSetAmount() {
        double newAmount = 150.00;
        transaction.setAmount(newAmount);
        assertEquals(newAmount, transaction.getAmount(), 0.001);
    }

    @Test
    public void testSetCategory() {
        String newCategory = "Entertainment";
        transaction.setCategory(newCategory);
        assertEquals(newCategory, transaction.getCategory());
    }

    @Test
    public void testSetDescription() {
        String newDescription = "Movie night";
        transaction.setDescription(newDescription);
        assertEquals(newDescription, transaction.getDescription());
    }

    @Test
    public void testSetType() {
        Transaction.TransactionType newType = Transaction.TransactionType.INCOME;
        transaction.setType(newType);
        assertEquals(newType, transaction.getType());
    }

    @Test
    public void testToString() {
        String expectedString = "Transaction{" +
                "id=" + transaction.getId() +
                ", date=" + date +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
        assertEquals(expectedString, transaction.toString());
    }

    @Test
    public void testTransactionTypeEnum() {
        assertEquals(2, Transaction.TransactionType.values().length);
        assertEquals(Transaction.TransactionType.INCOME, Transaction.TransactionType.valueOf("INCOME"));
        assertEquals(Transaction.TransactionType.EXPENSE, Transaction.TransactionType.valueOf("EXPENSE"));
    }
}