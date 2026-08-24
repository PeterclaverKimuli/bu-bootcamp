import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact;
    private Contact contact2;

    @BeforeEach
    public void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
        contact2 = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    public void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    public void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    public void getName_returnsExactString_notTransformed() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    public void toString_containsName() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
    }

    @Test
    public void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    public void constructor_createsTwoIndependentObjectsWithSameName() {
        assertNotEquals(contact2, contact);
    }
}
