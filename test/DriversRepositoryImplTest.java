import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DriversRepositoryImplTest {
    private DriverRepositoryImpl driverRepository = new DriverRepositoryImpl();
    private Driver driver;

    @BeforeEach
    void setup(){
        driverRepository = new DriverRepositoryImpl();
        driver = new Driver();
    }

    @Test
    public void testThat_I_Can_Save_Driver_And_Count_Increased_By_One() {
   assertEquals(0L, driverRepository.count());
   Driver driver = new Driver();
   driverRepository.save(driver);
   assertEquals(1L, driverRepository.count());
   }
   @Test
    public void testThat_When_I_Add_Two_Driver_Count_Becomes_Two(){
        assertEquals(0L, driverRepository.count());
        Driver driverTwo = new Driver();
        driverRepository.save(driverTwo);
        driverRepository.save(driver);
        assertEquals(2L, driverRepository.count());
   }
   @Test
    public void testThat_I_Can_Save_A_DriverId() {
       driverRepository.save(driver);
       assertEquals(1, driver.getId());
   }

   @Test
   public void testThat_A_Driver_Can_Be_Found_By_Driver_Id() {
       Driver savedDriver = driverRepository.save(driver);
       int driverId = savedDriver.getId();
       assertEquals(savedDriver, driverRepository.findById(driverId));
   }

    @Test
    public void test_That_I_Can_Find_All_Drivers(){

        Driver driverTwo = new Driver();
        Driver driverThree = new Driver();
        Driver [] allDrivers = {driver, driverTwo,driverThree};
        for(Driver driver : allDrivers){
            driverRepository.save(driver);
        }
        List<Driver> foundDrivers = driverRepository.findAll();
        int count = 0;
        for(Driver driver : foundDrivers){
            assertEquals(driver, allDrivers[count]);
            count++;
        }

    }
    @Test
    public void testThat_When_I_findAll_No_Drievr_isSaved_ErrorThrown(){
        assertThrows (IllegalArgumentException.class , ()-> driverRepository.findAll());

    }
    @Test
    public void testThat_When_I_Delete_Driver_Driver_Is_Deleted(){
        Driver savedDriver = driverRepository.save(driver);
        int driverId = savedDriver.getId();
        assertEquals(1L, driverRepository.count());
        driverRepository.delete(driverId);
        assertEquals(0L, driverRepository.count());
    }
    @Test
    public void testThat_When_I_Delete_Driver_With_Invalid_Id_Exception_Is_Thrown(){
        assertThrows (IllegalArgumentException.class, ()-> driverRepository.delete(-1));
    }


}
