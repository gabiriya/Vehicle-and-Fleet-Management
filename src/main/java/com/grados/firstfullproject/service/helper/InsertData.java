package com.grados.firstfullproject.service.helper;

import com.grados.firstfullproject.entities.Driver;
import com.grados.firstfullproject.entities.Insurance;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.mapper.DriverMapper;
import com.grados.firstfullproject.repository.DriverRepository;
import com.grados.firstfullproject.repository.InsuranceRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InsertData {

    private final InsuranceRepository insuranceRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;
    private final DriverService driverService;
    private final DriverMapper driverMapper;

    @Autowired
    public InsertData(InsuranceRepository insuranceRepository, VehicleRepository vehicleRepository, DriverRepository driverRepository, DriverService driverService, DriverMapper driverMapper) {
        this.vehicleRepository = vehicleRepository;
        this.insuranceRepository = insuranceRepository;
        this.driverRepository = driverRepository;
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    public void insertDummyData(){

        // object without foreign key
//        Vehicle (nope)
//        vv.setInsurances();
//        vv.setMaintenanceVehicles();
//        Driver (nope - set vehicles)
//        Insurance ( yes , but in db id_vec_fk)

        // ----- create insurance
        Insurance i1 = new Insurance();
        i1.setName("AXA");
        i1.setId(601L);
        i1.setDateOfInsurance(LocalDate.of(2020,4,23));
        i1.setId(200L);
        i1.setExpirationDate(LocalDate.of(2020,5,17));

        Insurance i2 = new Insurance(600L,"WAFA",LocalDate.of(2021,8,8),LocalDate.of(2022,7,7));
        Insurance i3 = new Insurance(602L,"Taamin",LocalDate.of(2019,1,18),LocalDate.of(2021,6,29));
//        insuranceRepository.saveAll(List.of(i1,i2,i3));


        // ----------- create Maintenance vehicle
//        MaintenanceVehicle mv1 = new MaintenanceVehicle();
//        mv1.setDateMaintenanceVehicle(LocalDate.of(2022,3,15));
//        mv1.setKmVehicle(5000);
//        mv1.setIdMaintenanceVehicle(700L);
//
//        MaintenanceVehicle mv2 = new MaintenanceVehicle(701L,LocalDate.of(2022,5,1),5000);


        // ------------ create vehicle
        Vehicle v1 = new Vehicle(10L,"Audi",LocalDate.of(2000,1,5),60,3000,LocalDate.of(2019,11,5));
//        v1.setInsurances(List.of(i1));
//        v1.setMaintenanceVehicles(List.of(mv1));
        Vehicle v2 = new Vehicle(11L,"Ferrari",LocalDate.of(2005,10,10),90,3500,LocalDate.of(2018,3,6));
        v2.setInsurances(List.of(i2));
//        v2.setMaintenanceVehicles(List.of(mv2));
        Vehicle v3 = new Vehicle(10L,"Audi",LocalDate.of(2000,1,5),60,3000,LocalDate.of(2019,11,5));
        v3.setInsurances(List.of(i3));
//        vehicleRepository.saveAll(List.of(v1,v2,v3));
        v1.setInsurances(null);
        v2.setInsurances(null);
        v3.setInsurances(null);

        //---------------- driver

        Driver d1 = new Driver("Youssef","Lotfi",LocalDate.of(2000,7,29));
        d1.setVehicles(List.of(v1));
        Driver d2 = new Driver("Ahmed","Zrida",LocalDate.of(1999,5,2));
//        d2.setVehicles(List.of(v2));
        Driver d3 = new Driver("amin","alami",LocalDate.of(1994,12,18));
//        d3.setVehicles(List.of(v3));
        Driver d4 = new Driver("Mokhtar","anlor",LocalDate.of(1989,3,13));

        driverService.saveDriver(driverMapper.DriverToDTO(d1));
//        driverRepository.save(d1);
//        driverRepository.saveAll(List.of(d1,d2,d3,d4));
    }

//    private static Driver buildDriver(final String id,
//                                        final String name,
//                                        final List<VehicleEs> cars) {
//        Driver person = new Driver();
//        person.setId(id);
//        person.setName(name);
//        person.setVehicles(cars);
//        return person;
//    }

}
