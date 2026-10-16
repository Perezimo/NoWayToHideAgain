
import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepository = new OfficerRepositoryImpl();
    private Officer officer;

    @BeforeEach
    void setUp() {
        officerRepository = new OfficerRepositoryImpl();
        officer = new Officer();
    }

    @Test
    public void testThat_I_Can_Save_Officer_And_Count_Increased_By_One() {
        assertEquals(0L, officerRepository.count());
        Officer officer = new Officer();
        officerRepository.save(officer);
        assertEquals(1L, officerRepository.count());
    }

    @Test
    public void testThat_When_I_Add_Two_Officer_Count_Becomes_Two() {
        assertEquals(0L, officerRepository.count());
        Officer officerTwo = new Officer();
        officerRepository.save(officerTwo);
        officerRepository.save(officer);
        assertEquals(2L, officerRepository.count());
    }

    @Test
    public void testThat_I_Can_Save_A_OfficerId() {
        officerRepository.save(officer);
        assertEquals(1, officer.getId());
    }

    @Test
    public void testThat_A_Driver_Can_Be_Found_By_Officer_Id() {
        Officer savedOfficer = officerRepository.save(officer);
        int officerId = savedOfficer.getId();
        assertEquals(savedOfficer, officerRepository.findById(officerId));
    }

    @Test
    public void test_That_I_Can_Find_All_Officer() {

        Officer officerTwo = new Officer();
        Officer officerThree = new Officer();
        Officer[] allOfficers = {officer, officerTwo, officerThree};
        for (Officer officer : allOfficers) {
            officerRepository.save(officer);
        }

        List<Officer> foundOfficers = officerRepository.findAll();
        int count = 0;
        for (Officer officer : foundOfficers) {
            assertEquals(officer, allOfficers[count]);
            count++;
        }

   }
    @Test
    public void testThat_When_I_findAll_No_Drievr_isSaved_ErrorThrown(){
        assertThrows (IllegalArgumentException.class , ()-> officerRepository.findAll());

    }
    @Test
    public void testThat_I_Can_Delete_Officer_And_Officer_Is_Deleted(){
        Officer savedOfficer = officerRepository.save(officer);
        int officerId = savedOfficer.getId();
        assertEquals(1L, officerRepository.count());
        officerRepository.delete(officerId);
        assertEquals(0L, officerRepository.count());
    }
    @Test
    public void testThat_When_I_Delete_An_Officer_With_Invalid_Id_Exception_Is_Thrown(){
        assertThrows (IllegalArgumentException.class, ()-> officerRepository.delete(-1));
    }


}


