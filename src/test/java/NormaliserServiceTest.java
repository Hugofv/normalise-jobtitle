import org.hugo.services.NormaliserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormaliserServiceTest {
    private NormaliserService normaliserService;

    @BeforeEach
    public void setUp() {
        normaliserService = new NormaliserService();
    }

    @Test
    public void testNormalise_JavaEngineer() {
        String result = normaliserService.normalise("Java Engineer");
        assertEquals("Software engineer", result);
    }

    @Test
    public void testNormalise_ChiefAccountant() {
        String result = normaliserService.normalise("Chief Accountant");
        assertEquals("Accountant", result);
    }

    @Test
    public void testNormalise_SeniorSoftwareDeveloper() {
        String result = normaliserService.normalise("Senior Software Developer");
        assertEquals("Software engineer", result);
    }

    @Test
    public void testNormalise_JuniorDeveloper() {
        String result = normaliserService.normalise("Junior Developer");
        assertEquals("Software engineer", result);
    }

    @Test
    public void testNormalise_Architect() {
        String result = normaliserService.normalise("Architect");
        assertEquals("Architect", result);
    }

    @Test
    public void testNormalise_QuantitySurveyor() {
        String result = normaliserService.normalise("Quantity Surveyor");
        assertEquals("Quantity surveyor", result);
    }
}
