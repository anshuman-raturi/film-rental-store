package com.cg.films.serviceImpl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.films.entity.Staff;
import com.cg.films.entity.Store;
import com.cg.films.repository.StaffRepository;
import com.cg.films.repository.StoreRepository;
import com.cg.films.service.StaffService;
 
@Service
public class StaffServiceImpl implements StaffService {
 
    @Autowired
    private StaffRepository staffRepository;


 
    @Autowired
    private StoreRepository storeRepository;
 
 
  @Override
  public List<Staff> getStaffByManagerId(Long managerId) {
      Store store = storeRepository.findByManager_StaffId(managerId);
      return (store != null) ? staffRepository.findByStore_StoreId(store.getStoreId()) : List.of();
  }
 
 
   
}