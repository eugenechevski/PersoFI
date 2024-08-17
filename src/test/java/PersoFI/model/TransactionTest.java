package PersoFI.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class TransactionTest {

    private Transaction transaction;
    private final LocalDate date = LocalDate.of(2023, 5, 1);
    private final double amount = 100.00;
    private final String category = "Groceries";
    private final String description = "Weekly shopping";

    @Before
    public void setUp() {
        transaction = new Transaction(date, amount, category, description);
    }

    @Test
    public void testTransactionCreation() {
        assertNotNull(transaction);
        assertEquals(date, transaction.getDate());
        assertEquals(amount, transaction.getAmount(), 0.001);
        assertEquals(category, transaction.getCategory());
        assertEquals(description, transaction.getDescription());
    }

    @Test
    public void testSetId() {
        int id = 1;
        transaction.setId(id);
        assertEquals(id, transaction.getId());
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
}